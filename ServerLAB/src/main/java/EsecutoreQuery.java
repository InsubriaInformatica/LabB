
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//RISORSA CONDIVISA CHE SI INTERFACCIERA' LOCALMENTE CON IL NOSTRO SKELETON e CON IL DB per eseguire query
public class EsecutoreQuery implements SkeletonInterface{
	
	private Connection connessione;
	private Statement istruzione;
	private ResultSet rs;
	private boolean result;
	private ViewInterface view;
	
	//costruttore che instanzia connessione a database
	public EsecutoreQuery(String username, String password, String host, String port, String nomeDB) {
		try {
			this.connessione = DataBaseConnessione.getConnection(username, password, host, port , nomeDB); //prende connessione al database
			this.istruzione = (Statement) connessione.createStatement(); //statement per eseguire query
			
		} catch (SQLException e) {
			System.err.println("ESECUTORE QUERY: connessione al DB non riuscita " + e.toString());
		} 
	}
	
	
	public synchronized void creazioneTabelle() throws SQLException {
		
		System.out.println("ESECUTORE QUERY: Inizializzo DataBase");
		
		String query = "CREATE TABLE Cittadini (\n"
				+ "	codiceFiscale CHARACTER(16),\n"
				+ "	cognome CHARACTER(30) NOT NULL,\n"
				+ "	nome CHARACTER(30) NOT NULL,\n"
				+ "	PRIMARY KEY (codiceFiscale)\n"
				+ ")";
		try {
			result = istruzione.execute(query);
			System.out.println("ESECUTORE QUERY: Tabella Cittadini creata con successo!");
		} catch (Exception e) {
			System.out.println("ESECUTORE QUERY: La tabella cittadini esiste già!");
		}
		
		String query1 = "CREATE TABLE Indirizzo (\n"
				+ "	id NUMERIC,		\n"
				+ "	qualificatore CHARACTER(6) NOT NULL CHECK(qualificatore IN ('Via', 'Viale', 'Piazza')),\n"
				+ "	nome CHARACTER(40) NOT NULL, \n"
				+ "	numeroCivico CHARACTER(6) NOT NULL,\n"
				+ "	comune CHARACTER(30) NOT NULL,\n"
				+ "	cap NUMERIC NOT NULL CHECK(cap BETWEEN 0 AND 99999),\n"
				+ "	siglaProvincia CHARACTER(2) NOT NULL, \n"
				+ "	PRIMARY KEY (id)\n"
				+ ")";
		try {
			result = istruzione.execute(query1);
			System.out.println("ESECUTORE QUERY: Tabella Indirizzo creata con successo!");
		} catch (Exception e) {
			System.out.println("ESECUTORE QUERY: La tabella Indirizzo esiste già!");
		}
		
		String query2 = "CREATE TABLE CentriVaccinali (\n"
				+ "	nome CHARACTER(40),\n"
				+ "	tipologia CHARACTER(11) NOT NULL CHECK(tipologia IN ('Ospedaliero', 'Hub', 'Aziendale')),\n"
				+ "	idIndirizzo NUMERIC NOT NULL REFERENCES Indirizzo(id),\n"
				+ "	PRIMARY KEY (nome)\n"
				+ ")";
		try {
			result = istruzione.execute(query2);
			System.out.println("ESECUTORE QUERY: Tabella centrivaccinali creata con successo!");
		} catch (Exception e) {
			System.out.println("ESECUTORE QUERY: La tabella centrivaccinali esiste già!");
		}
		
		String query3 = "CREATE TABLE Vaccinazione (\n"
				+ "	id SMALLINT,\n"
				+ "	codiceFiscale CHARACTER(16) REFERENCES Cittadini(codiceFiscale),\n"
				+ "	data DATE NOT NULL, \n"
				+ "	tipoVaccino CHARACTER(11) NOT NULL CHECK(tipoVaccino IN ('Pfizer', 'Moderna', 'J&J', 'AstraZeneca')),\n"
				+ "	nomeCentro CHARACTER(40) NOT NULL REFERENCES CentriVaccinali(nome),\n"
				+ "	nDosi CHARACTER(20) CHECK (nDosi IN ('Prima', 'Seconda', 'Terza o Successiva')),\n"
				+ "	PRIMARY KEY (id)\n"
				+ ")";
		try {
			result = istruzione.execute(query3);
			System.out.println("ESECUTORE QUERY: Tabella Vaccinazione creata con successo!");
		} catch (Exception e) {
			System.out.println("ESECUTORE QUERY: La tabella Vaccinazione esiste già! " + e.toString() );
		}
		
		String query4 = "CREATE TABLE Cittadini_Registrati (\n"
				+ "	codiceFiscale CHARACTER(16) REFERENCES Cittadini(codiceFiscale),\n"
				+ "	username CHARACTER(50) NOT NULL, \n"
				+ "	password CHARACTER(50) NOT NULL,\n"
				+ "	email CHARACTER(60) NOT NULL,\n"
				+ "	idVaccinazione SMALLINT UNIQUE REFERENCES Vaccinazione(id),\n"
				+ "	PRIMARY KEY(codiceFiscale)\n"
				+ ")";
		try {
			result = istruzione.execute(query4);
			System.out.println("ESECUTORE QUERY: Tabella Cittadini_Registrati creata con successo!");
		} catch (Exception e) {
			System.out.println("ESECUTORE QUERY: La tabella Cittadini_Registrati esiste già! " + e.toString());
		}
		
		String query5 = "CREATE TABLE Eventi_Avversi (\n"
				+ "	codiceFiscale CHARACTER(16) REFERENCES Cittadini_Registrati(codiceFiscale),\n"
				+ "	evento CHARACTER(30),\n"
				+ "	severita NUMERIC CHECK(severita BETWEEN 1 AND 5),\n"
				+ "	note CHARACTER(256),\n"
				+ "	nomeCentro CHARACTER(40) REFERENCES CentriVaccinali(nome), \n"
				+ "	PRIMARY KEY (codiceFiscale, evento)\n"
				+ ")";
		try {
			result = istruzione.execute(query5);
			System.out.println("ESECUTORE QUERY: Tabella Eventi_Avversi creata con successo!");
		} catch (Exception e) {
			System.out.println("ESECUTORE QUERY: La tabella Eventi_Avversi esiste già! " + e.toString());
		}
		
	}

	//registra nel database il centro vaccinale --> METODI SYCHRONIZED, si accede ai dati in modo concorrente
	public synchronized int registraCentroVaccinale(String nome, String qualificatore, String indirizzo, String numeroCivico, String comune, String provincia, String Cap, String tipologia) throws SQLException {
		int ret = 0;
		String queryUltimoID = "SELECT i.id  FROM indirizzo i WHERE i.id >=ALL(SELECT id FROM indirizzo)";
		
		ResultSet rs;
		int brs = 0;
		
		rs = istruzione.executeQuery(queryUltimoID);
		
		int idIndirizzoNuovo = 0;
		
		while(rs.next()) {
			idIndirizzoNuovo = rs.getInt("id") + 1; //aggioramento id indirizzo progressivo
		}
		
		String queryPerVerificareEsistenzaCentro = "SELECT nome FROM centrivaccinali WHERE nome = '"+ nome +"';";
		rs = istruzione.executeQuery(queryPerVerificareEsistenzaCentro);
		
		if(rs.next()==false) {
			String queryPerVerificareEsistenzaIndirizzo = "SELECT id FROM indirizzo WHERE nome = '"+ indirizzo +"' AND comune = '"+ comune +"' AND cap = '"+ Cap +"'; ";
			rs = istruzione.executeQuery(queryPerVerificareEsistenzaIndirizzo);
			
			if(rs.next()==false) {
				
				String queryPerInserireIndirizzo = "INSERT INTO indirizzo VALUES ('"+ idIndirizzoNuovo +"', '"+qualificatore+"', '"+ indirizzo +"', '"+ numeroCivico +"', '"+ comune +"', '"+ Cap +"', '"+ provincia +"');";
				brs = istruzione.executeUpdate(queryPerInserireIndirizzo);
				String queryPerInserireCentro = "INSERT INTO centrivaccinali VALUES ('"+ nome +"', '"+ tipologia +"', '"+ idIndirizzoNuovo +"');";
				brs = istruzione.executeUpdate(queryPerInserireCentro);
			}
			else {
				int id = rs.getInt("id");
				String queryPerInserireCentro = "INSERT INTO centrivaccinali VALUES ('"+ nome +"', '"+ tipologia +"', "+ id +");";
				brs = istruzione.executeUpdate(queryPerInserireCentro);
			}
			
			ret = 1; //operazione e buon fine
		}
		else {
			ret = -1; //operazione non a buon fine
		}
		
		return ret;
	}


	//metodo che permette di registrare un vaccinato nel DB
	public synchronized int registraVaccinato(String nomeCentro, String nome, String cognome, String codiceFiscale,String dataSomministrazione, String tipoVaccino, String nDosi) throws SQLException {
		int ret = 0;
		
		//cerca l'ultimo identificativo
		String queryPerIdMax = "SELECT id FROM vaccinazione WHERE id >= ALL(SELECT id FROM vaccinazione)";
		ResultSet rs = istruzione.executeQuery(queryPerIdMax);
		int brs;
		int idVacMax = 0;
		
		//genera identificativo univoco per il vaccinato
		while(rs.next()) {
			idVacMax = rs.getInt("id") + 1;
		}
		
		String queryPerVerificareEsistenzaCittadino = "SELECT * FROM cittadini WHERE codicefiscale = '"+ codiceFiscale +"'";
		rs = istruzione.executeQuery(queryPerVerificareEsistenzaCittadino);
		
		//se il cittadino non è nel DB
		if(rs.next()==false) {
			String queryPerVerificareVaccinato = "SELECT * FROM vaccinazione WHERE codiceFiscale = '"+ codiceFiscale +"'";
			rs = istruzione.executeQuery(queryPerVerificareVaccinato);
			
			//se non è nella tabella dei vaccinati, lo aggiungo sia nei cittadini che nei vaccinati
			if(rs.next()==false) {
				System.out.println("ESECUTORE QUERY: aggiungo: " + nomeCentro + " " + nome + " " + cognome + " " + codiceFiscale + " " + dataSomministrazione + " " + tipoVaccino + " " + nDosi);
				String queryPerInserireCittadino = "INSERT INTO cittadini VALUES ('"+codiceFiscale+"', '"+cognome+"', '"+nome+"');";
				brs = istruzione.executeUpdate(queryPerInserireCittadino);
				System.out.println("cittadino ok aggiunto");
				
				String queryPerInserireVaccinato = "SET datestyle = \"ISO, DMY\";INSERT INTO vaccinazione VALUES('"+ idVacMax +"', '"+ codiceFiscale+"', '"+ dataSomministrazione +"', '"+ tipoVaccino +"', '"+ nomeCentro+"' , '"+ nDosi+"')";
				brs = istruzione.executeUpdate(queryPerInserireVaccinato);
				System.out.println("vaccinato ok aggiunto");
				ret = 1; //operazione e buon fine
			}
			else {
				ret = -1;
			}
		}
		
		else {
			String queryPerVerificareVaccinato = "SELECT * FROM vaccinazione WHERE codiceFiscale = '"+ codiceFiscale +"'";
			rs = istruzione.executeQuery(queryPerVerificareVaccinato);
			if(rs.next()==false) {
				String queryPerInserireVaccinato = "INSERT INTO vaccinazione VALUES('"+ idVacMax +"', '"+ codiceFiscale+"', '"+ dataSomministrazione  +"', '"+ tipoVaccino +"', '"+ nomeCentro+"' , '"+ nDosi+"')";
				brs = istruzione.executeUpdate(queryPerInserireVaccinato);
				ret = 1; //operazione e buon fine
			}
			else {
				ret = 0;
			}
		}
		
		return ret;
	}


	//questo metodo Cerca nel DB : nome, cognome, id univoco, il nome del centro dove è stato vaccinato
	public synchronized List<String> IdUnivoco(String codiceFiscale) throws SQLException {
		List<String> ret = new ArrayList<String>();
		
		String queryRicerca = "SELECT nome, cognome, id, nomeCentro FROM cittadini c JOIN vaccinazione v ON c.codiceFiscale = v.codiceFiscale WHERE c.codicefiscale = '"+codiceFiscale+"'";
		ResultSet rs = istruzione.executeQuery(queryRicerca);
		
		while(rs.next()) {
			ret.add(rs.getString("nome"));
			ret.add(rs.getString("cognome"));
			ret.add(String.valueOf(rs.getInt("id"))); //indice 2
			ret.add(rs.getString("nomecentro"));
		}
		
		return ret;
	}


	//questo metodo ritorna i centri vaccinali aggiunti al DB
	public synchronized List<String> retElencoCentriVaccinali() throws SQLException {
		
		List<String> ret = new ArrayList<String>();
		
		String query = "SELECT nome FROM centrivaccinali ORDER BY nome ASC";
		ResultSet rs = istruzione.executeQuery(query);
		
		while(rs.next()) {
			ret.add(rs.getString("nome"));
		}
		
		return ret;
	}
	

}

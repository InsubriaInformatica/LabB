
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * risorsa condivisa che si interfaccia localmente con lo skeleton e con il db per eseguire le query.
 * @author simon
 *
 */
public class EsecutoreQuery implements SkeletonInterface{
	
	private Connection connessione;
	private Connection conn;
	private Statement istruzione;
	private Statement istr;
	private ResultSet rs;
	private boolean result;
	private ViewInterface view;
	private String nomeDataB;
	
	/**
	 * Costruttore vuoto
	 */
	public EsecutoreQuery() {
		
	}
	
	/**
	 * costruttore che istanzia la connessione al database
	 * @param username nome utente per accedere al database
	 * @param password password associata all'utente scritto sopra
	 * @param host indirizzo della macchina sulla quale � situato il database
	 * @param port porta sulla quale gira il database
	 * @param nomeDB nome del DataBase
	 */
	public EsecutoreQuery(String username, String password, String host, String port, String nomeDB) {
		try {
			this.nomeDataB = nomeDB;
			LoginServer(host, port, username, password);
			creazioneDB();
			this.connessione = DataBaseConnessione.getConnection(username, password, host, port , nomeDB); //prende connessione al database
			this.istruzione = (Statement) connessione.createStatement(); //statement per eseguire query
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "CONNESSIONE FALLITA", "SERVER", JOptionPane.ERROR_MESSAGE);
			System.err.println("ESECUTORE QUERY: connessione al DB non riuscita " + e.toString());
		} 
	}
	/**
	 * metodo che consente di connettersi al server postgre
	 */
	public void LoginServer(String host, String port, String username, String password){
		try {
			this.conn = DataBaseConnessione.getConnectionServer(username, password, host, port); //prende connessione al server
			this.istr = (Statement) conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * controlla se esiste un database che abbia il nome inserito all'avvio del server
	 * se non esiste lo crea
	 */
	public synchronized void creazioneDB() {
		try {
			String queryVerificaDB = "SELECT 'CREATE DATABASE " + nomeDataB + "' AS creazione\n"
					+ "WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = '" + nomeDataB + "')";
			rs = istr.executeQuery(queryVerificaDB);
			String x = "";
			while(rs.next()) {
				x = rs.getString("creazione");
			}
			
			String queryCreazioneDB = x.toString();
			result = istr.execute(queryCreazioneDB);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DB GIA' ESISTENTE", "SERVER", JOptionPane.ERROR_MESSAGE);
			System.out.println("Il database esiste già" + e.toString());
		}
	}
	
	public synchronized void dataset() {
		System.out.println("ESECUTORE QUERY: creazione dataset");
		
		String queryDataset = "";
	}
	
	/**
	 * questo metodo crea tutte le tabelle necessarie per il corretto funzionamento del programma (nel caso in cui queste non esistano)
	 */
	public synchronized void creazioneTabelle() throws SQLException {
		
		System.out.println("ESECUTORE QUERY: Inizializzo DataBase");
		
		String queryCreazione
				= "CREATE TABLE if not exists Cittadini (\n"
				+ "	codiceFiscale CHARACTER(16),\n"
				+ "	cognome CHARACTER(30) NOT NULL,\n"
				+ "	nome CHARACTER(30) NOT NULL,\n"
				+ "	PRIMARY KEY (codiceFiscale)\n"
				+ ");"
		
				+	"CREATE TABLE if not exists Indirizzo (\n"
				+ "	id NUMERIC,		\n"
				+ "	qualificatore CHARACTER(6) NOT NULL CHECK(qualificatore IN ('Via', 'Viale', 'Piazza')),\n"
				+ "	nome CHARACTER(40) NOT NULL, \n"
				+ "	numeroCivico CHARACTER(6) NOT NULL,\n"
				+ "	comune CHARACTER(30) NOT NULL,\n"
				+ "	cap NUMERIC NOT NULL CHECK(cap BETWEEN 0 AND 99999),\n"
				+ "	siglaProvincia CHARACTER(2) NOT NULL, \n"
				+ "	PRIMARY KEY (id)\n"
				+ ");"
		
				+ "CREATE TABLE if not exists CentriVaccinali (\n"
				+ "	nome CHARACTER(40),\n"
				+ "	tipologia CHARACTER(11) NOT NULL CHECK(tipologia IN ('Ospedaliero', 'Hub', 'Aziendale')),\n"
				+ "	idIndirizzo NUMERIC NOT NULL REFERENCES Indirizzo(id),\n"
				+ "	PRIMARY KEY (nome)\n"
				+ ");"
		
				+ "CREATE TABLE if not exists Vaccinazione (\n"
				+ "	id SMALLINT,\n"
				+ "	codiceFiscale CHARACTER(16) REFERENCES Cittadini(codiceFiscale),\n"
				+ "	data DATE NOT NULL, \n"
				+ "	tipoVaccino CHARACTER(11) NOT NULL CHECK(tipoVaccino IN ('Pfizer', 'Moderna', 'J&J', 'AstraZeneca')),\n"
				+ "	nomeCentro CHARACTER(40) NOT NULL REFERENCES CentriVaccinali(nome),\n"
				+ "	nDosi CHARACTER(20) CHECK (nDosi IN ('Prima', 'Seconda', 'Terza o Successiva')),\n"
				+ "	PRIMARY KEY (id)\n"
				+ ");"
		
				+ "CREATE TABLE if not exists Cittadini_Registrati (\n"
				+ "	codiceFiscale CHARACTER(16) REFERENCES Cittadini(codiceFiscale),\n"
				+ "	username CHARACTER(50) NOT NULL, \n"
				+ "	password CHARACTER(50) NOT NULL,\n"
				+ "	email CHARACTER(60) NOT NULL,\n"
				+ "	idVaccinazione SMALLINT UNIQUE REFERENCES Vaccinazione(id),\n"
				+ "	PRIMARY KEY(codiceFiscale)\n"
				+ ");"
		
				+ "CREATE TABLE if not exists Eventi_Avversi (\n"
				+ "	codiceFiscale CHARACTER(16) REFERENCES Cittadini_Registrati(codiceFiscale),\n"
				+ "	evento CHARACTER(30),\n"
				+ "	severita NUMERIC CHECK(severita BETWEEN 1 AND 5),\n"
				+ "	note CHARACTER(256),\n"
				+ "	nomeCentro CHARACTER(40) REFERENCES CentriVaccinali(nome), \n"
				+ "	PRIMARY KEY (codiceFiscale, evento)\n"
				+ ")";

			result = istruzione.execute(queryCreazione);
		
	}

	/**
	 * metodo che inserisce i dati di un certo centro vaccinale dentro al DB
	 * @return <b>1</b> se l'operazione e' andata a buon fine
	 */
	//METODI SYCHRONIZED, si accede ai dati in modo concorrente
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


	/**
	 * metodo che inserisce i dati di un vaccinato nel DB, generandogli un codice univoco.
	 * @return <b>1</b> se l'operazione e' andata a buon fine
	 * 
	 */
	public synchronized int registraVaccinato(String nomeCentro, String nome, String cognome, String codiceFiscale,String dataSomministrazione, String tipoVaccino, String nDosi) throws SQLException {
		int ret = 0;
		
		
		String queryPerIdMax = "SELECT id FROM vaccinazione WHERE id >= ALL(SELECT id FROM vaccinazione)";
		ResultSet rs = istruzione.executeQuery(queryPerIdMax);
		int brs;
		int idVacMax = 0;
		
		
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


	/**
	 * effettua una ricerca tramite il codice fiscale
	 * @return <b>nome<br> cognome<br> id<br> Luogo della vaccinazione<br></b> della persona ricercata
	 */
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



	/**
	 * @return centri vaccinali aggiunti al DB
	 */
	public synchronized List<String> retElencoCentriVaccinali() throws SQLException {
		
		List<String> ret = new ArrayList<String>();
		
		String query = "SELECT nome FROM centrivaccinali ORDER BY nome ASC";
		ResultSet rs = istruzione.executeQuery(query);
		
		while(rs.next()) {
			ret.add(rs.getString("nome"));
		}
		
		return ret;
	}


	/**
	 * verifica l'esistenza di un centro vaccinale
	  * @return <b>true</b> se esiste<br> <b>false</b> se non esiste 
	 */
	public synchronized boolean esisteCentroNome(String nomeCentro) throws SQLException {
		
		boolean ret = false;
		String query = "SELECT nome FROM centrivaccinali WHERE nome = '"+ nomeCentro +"';";
		ResultSet rs = istruzione.executeQuery(query);
		
		while(rs.next()) {
			ret = true;
		}
		
		return ret;
	}
	
	//verifica nel DB che esiste il centro nel comune e nella tipologia specificata
	/**
	 * verifica che nel DB esista in un certo comune un centro vaccinale con un certo nome. 
	 * @return <b>true</b> se esiste<br> <b>false</b> se non esiste
	 */
	public synchronized boolean EsisteCentroCeT(String comune, String tipologia) throws SQLException {
		boolean ret = false;
		String query = "SELECT cv.tipologia, i.comune FROM centrivaccinali cv JOIN indirizzo i ON cv.idIndirizzo = i.id WHERE tipologia = '"+ tipologia +"' AND comune = '"+ comune +"';";
		ResultSet rs = istruzione.executeQuery(query);
		
		while(rs.next()) {
			ret = true;
		}
		return ret;
	}


/**
 * dato il codice fiscale, ricerca l'esistenza di un cittadino vaccinato nel DB
 * @return <b>true</b> se esiste<br> <b>false</b> se non esiste
 */
	public synchronized boolean checkCittadinoVaccinato(String codiceFiscale) throws SQLException {
		
		String query = "SELECT * \n"
				+ "FROM cittadini c JOIN vaccinazione v ON c.codicefiscale = v.codicefiscale\n"
				+ "WHERE c.codicefiscale = '"+ codiceFiscale +"'";
		
		ResultSet rs = this.istruzione.executeQuery(query);
		
		while(rs.next()) {
			return true;
		}
		return false;
	}


	/**
	 * registra l'utente vaccinato al portale cittadini
	 * @return <b>1</b> se la registrazione e' andata a buon fine<br> <b>0</b> se la query e' andata a buon fine ma il cittadino non e' stato inserito (gia' presente)<br> <b>-1</b> se la query non e' andata a buon fine
	 */
	public synchronized int registrazioneCittadino(String nome, String cognome, String codiceFiscale, String eMail, String username, String password, String IdUnivoco) throws SQLException{
		int ret = 0;
		int brs;
		String queryControlloCittadino = "SELECT * FROM cittadini WHERE codiceFiscale = '"+ codiceFiscale +"'";
		ResultSet rs = istruzione.executeQuery(queryControlloCittadino);
		
		if(rs.next()) {
			String queryControlloRegistrato = "SELECT * FROM cittadini_registrati WHERE codiceFiscale = '"+ codiceFiscale +"'";
			rs = istruzione.executeQuery(queryControlloRegistrato);
			
			if(rs.next()==false) { 
				String queryInsert = "INSERT INTO cittadini_registrati VALUES('"+ codiceFiscale +"', '"+ username +"', '"+ password+"', '"+ eMail +"', '"+ IdUnivoco +"');";
				brs = istruzione.executeUpdate(queryInsert);
				System.out.println("cittadino registrato");
				ret = 1; //buon fine
			}
			
			else {
				System.out.println("Cittadino non inserito, già presente");
				ret = 0; //query buon fine ma cittadino non inserito
			}
		}
		else {
			ret = -1;
		}
		return ret;
	}


/**
 * ricerca un utente nel DB in base al suo username
 * @return <b>true</b> se esiste<br> <b>false</b> se non esiste
 */
	public synchronized boolean esisteUtente(String username) throws SQLException {
		boolean ret = false;
		String query = "SELECT username, password FROM cittadini_registrati WHERE username = '"+username+"'";
		ResultSet rs = istruzione.executeQuery(query);
		
		while(rs.next()) {
			ret = true;
		}
		return ret;
	}


	/**
	 * verifica corrispondenza tra codice univoco e codice fiscale dell'utente
	 * @return <b>true</b> se corrispondono<br> <b>false</b> se non corrispondono
	 */
	public synchronized boolean verificaCorrispondenzaId(String codiceFiscale, String idVaccinato) throws SQLException {
		
		String queryControlloId = "SELECT id FROM vaccinazione NATURAL JOIN cittadini\n"
				+ "WHERE codicefiscale = '"+ codiceFiscale +"'";
		rs = istruzione.executeQuery(queryControlloId);
		
		if(rs.next()) {
			String idQuery = rs.getString(1);
			System.out.println("L'id della query è: " + idQuery + ", l'id inserito dall'utente è: " + idVaccinato);
			
			if(idQuery.equals(idVaccinato)) {
				return true; //buon fine 
			}
			else {
				System.out.println("L'ID NON è UGUALE CAMBIARE!!!!");
				return false;
			}
		}
		
		else {return false;}
	}


	/**
	 * verifica corrispondenza tra username e password
	 * @return <b>false</b> se non i dati non corrispondono
	 */
	public synchronized boolean login(String username, String password) throws SQLException {
		boolean ret = false;
		
		String verificaRegistrazione = "SELECT username, password FROM cittadini_registrati WHERE username = '"+ username +"' AND password = '"+ password +"'";
		ResultSet rs = istruzione.executeQuery(verificaRegistrazione);
		
		ret = rs.next();
		
		return ret;
	}


	/**
	 * @return codice fiscale dell'utente
	 */
	public synchronized String retCfUtente(String username) throws SQLException {
		String ret = "";
		
		String query = "SELECT codicefiscale\n"
				+ "FROM cittadini_registrati\n"
				+ "WHERE username = '"+ username +"';";
		ResultSet rs = this.istruzione.executeQuery(query);
		
		while(rs.next()) {
			ret = rs.getString("codicefiscale");
		}
		return ret;
	}


	/**
	 * inserisce nella tabella degli eventi avversi i dati inseriti da una certa persona. la persona viene distinta tramite il suo CF
	 * @return <b>1</b> se l'operazione va a buon fine<br> <b>0</b> altrimenti
	 */
	public synchronized int inserisciEventoAvverso(String codiceFiscale, String evento, String severita, String note)throws SQLException {
		int ret = 0;

		String queryPerVerificareEsistenzaEvento = "SELECT codiceFiscale FROM eventi_avversi WHERE codiceFiscale = '"+ codiceFiscale +"' AND evento = '"+ evento +"';";
		ResultSet rs = istruzione.executeQuery(queryPerVerificareEsistenzaEvento);
		int brs = 0;

		if(rs.next()==false) {
			String queryPerPrendereCentro = "SELECT nomecentro FROM vaccinazione WHERE codicefiscale = '"+ codiceFiscale +"'";
			String nomeCentro = null;
			rs = istruzione.executeQuery(queryPerPrendereCentro);
			while(rs.next()) {
				nomeCentro = rs.getString("nomecentro");
			}
			
			String queryPerInserire = "INSERT INTO eventi_avversi VALUES('"+ codiceFiscale +"', '"+ evento +"', '"+ severita +"', '"+ note +"', '"+ nomeCentro +"');";
			brs = istruzione.executeUpdate(queryPerInserire);
			ret = 1;
		}
		else {
			ret = 0;
		}
		
		return ret;
	}


	/**
	 * dato il nome di un centro vaccinale, ne riporta le informazioni
	 * @return <b>qualificatore<br> nome<br> numeroCivico<br> comune<br> CAP<br> provincia<br></b>
	 * <b>0 </b> se non esiste un centro con quel nome
	 */
	public synchronized List<String> infoCentriVaccinaliNome(String nomeCentro) throws SQLException {
		List<String> ret = new ArrayList<String>();
		ret.add(nomeCentro);	
		
		System.out.println("eseguo ricerca nome");
		
		String queryPerTipologia = "SELECT tipologia FROM centrivaccinali WHERE nome = '"+nomeCentro+"';";
		ResultSet rs = istruzione.executeQuery(queryPerTipologia);
		while(rs.next())
			ret.add((rs.getString("tipologia"))); 
		
		String queryPerIndirizzo = "SELECT i.qualificatore, i.nome, i.numerocivico, i.comune, i.cap, i.siglaprovincia \n"
				+ "FROM indirizzo i JOIN centrivaccinali cv ON cv.idIndirizzo = i.id WHERE cv.nome = '"+nomeCentro+"'";
		rs = istruzione.executeQuery(queryPerIndirizzo);
		
		while(rs.next()) {
			ret.add(togliSpazi(rs.getString("qualificatore")) + " " + togliSpazi(rs.getString("nome")) + " " + togliSpazi(rs.getString("numerocivico")) + ", " + togliSpazi(rs.getString("comune")) + ", " + togliSpazi(rs.getString("cap")) + ", " + togliSpazi(rs.getString("siglaprovincia")));
		}
		
		String queryPerSegnalazioniSeverita = "SELECT cv.nome, COUNT(ea.codicefiscale) AS numeroSegnalazioni, AVG(ea.severita) AS severitaMedia"
				+ " FROM centrivaccinali cv"
				+ "    JOIN eventi_avversi ea ON cv.nome = ea.nomeCentro"
				+ " WHERE cv.nome = '"+ nomeCentro +"'"
				+ " GROUP BY cv.nome, cv.tipologia";
		rs = istruzione.executeQuery(queryPerSegnalazioniSeverita);
		
		if(rs.next()!=false) {
			ret.add(String.valueOf(rs.getInt("numerosegnalazioni"))); 
			ret.add(String.valueOf(rs.getFloat("severitamedia")));	
			while(rs.next()) {
				ret.add(String.valueOf(rs.getInt("numerosegnalazioni")));
				ret.add(String.valueOf(rs.getFloat("severitamedia")));	
			}
		}
		else {
			ret.add("0"); 
			ret.add("0");
		}

		return ret;
	}


	/**
	 * dati comune e tipologia ritorna le informazioni dei centri che soddisfano i criteri
	 * @return <b>qualificatore<br> nome<br> numeroCivico<br> comune<br> CAP<br> provincia<br></b>
	 * <b>0 </b> se non esistono centri che soddisfano i requisiti 
	 */
	public synchronized List<List<String>> infoCentriVaccinaliCeT(String comune, String tipologia) throws SQLException {
		List<List<String>> ret = new ArrayList<List<String>>();
		List<String> tmp;
		int i=0;
		String queryPerNomiCentri = "SELECT cv.nome, cv.tipologia, i.comune FROM centrivaccinali cv JOIN indirizzo i ON cv.idindirizzo = i.id WHERE cv.tipologia = '"+ tipologia +"' AND i.comune = '"+ comune +"'; " ;
		ResultSet rs = istruzione.executeQuery(queryPerNomiCentri);
		ResultSet forRS;
		String nomeCentro;
		

		System.out.println("eseguo ricerca comune e tipologia");
		while(rs.next()) {
			nomeCentro = rs.getString("nome");
			
			tmp = new ArrayList<String>();
			tmp.add(nomeCentro);
			ret.add(tmp);
		}
		
		for(i=0; i<ret.size(); i++) {
			String queryPerTipologia = "SELECT tipologia FROM centrivaccinali WHERE nome = '"+ret.get(i).get(0)+"';";
			forRS = istruzione.executeQuery(queryPerTipologia);
			
			while(forRS.next())
				ret.get(i).add(forRS.getString("tipologia"));
		}
		
		for(i=0; i<ret.size(); i++) {
			String queryPerIndirizzo = "SELECT i.qualificatore, i.nome, i.numerocivico, i.comune, i.cap, i.siglaprovincia \n"
					+ "FROM indirizzo i JOIN centrivaccinali cv ON cv.idIndirizzo = i.id WHERE cv.nome = '"+ret.get(i).get(0)+"'";
			forRS = istruzione.executeQuery(queryPerIndirizzo);
			
			while(forRS.next()) {
				ret.get(i).add(togliSpazi(forRS.getString("qualificatore")) + " " + togliSpazi(forRS.getString("nome")) + " " + togliSpazi(forRS.getString("numerocivico")) + ", " + togliSpazi(forRS.getString("comune")) + ", " + togliSpazi(forRS.getString("cap")) + ", " + togliSpazi(forRS.getString("siglaprovincia")));
			}
		}
		
		for(i=0; i<ret.size(); i++) {
			String queryPerSegnalazioniSeverita = "SELECT cv.nome, COUNT(ea.codicefiscale) AS numeroSegnalazioni, AVG(ea.severita) AS severitaMedia"
					+ " FROM centrivaccinali cv"
					+ "    JOIN eventi_avversi ea ON cv.nome = ea.nomeCentro"
					+ " WHERE cv.nome = '"+ ret.get(i).get(0) +"'"
					+ " GROUP BY cv.nome, cv.tipologia";
			forRS = istruzione.executeQuery(queryPerSegnalazioniSeverita);
			
			if(forRS.next()!=false) {
				ret.get(i).add(String.valueOf(forRS.getInt("numerosegnalazioni")));
				ret.get(i).add(String.valueOf(forRS.getFloat("severitamedia")));
				
				while(forRS.next()) {
					ret.get(i).add(String.valueOf(forRS.getInt("numerosegnalazioni")));
					ret.get(i).add(String.valueOf(forRS.getFloat("severitamedia")));
				}
			}
			else {
				ret.get(i).add("0");
				ret.get(i).add("0");
			}
		}

		return ret;
	}
	
	/**
	 * ritorna eventi avversi inseriti da un utente con un certo username
	 * @return <b>evento</b><br> <b>severita'<br></b> <b>note<br></b>
	 */
	public List<List<String>> retMyElencoEventiAvversi(String username) throws SQLException {
		List<List<String>> ret = new ArrayList<List<String>>();
		int i=0;
		
		String queryElencoEA = "SELECT evento, severita, note\n"
				+ "FROM eventi_avversi ea\n"
				+ "    JOIN cittadini_registrati cr ON ea.codicefiscale = cr.codicefiscale\n"
				+ "WHERE cr.username = '"+ username +"';";
		
		ResultSet rs = istruzione.executeQuery(queryElencoEA);
		
		while(rs.next()) {
			ret.add(new ArrayList<String>());
			ret.get(i).add(togliSpazi(rs.getString("evento")));
			ret.get(i).add(togliSpazi(rs.getString("severita")));
			ret.get(i).add(togliSpazi(rs.getString("note")));
			
			i++;
		}
		return ret;
	}
	
	/**
	 * toglie gli spazi in pi� eventualmente presenti in una stringa
	 * @param dato
	 * @return stringa senza spazi
	 */
	private String togliSpazi(String dato) {
		String ret = "";
		int i;
		
		for(i = 0; i<dato.length(); i++) {
			if(dato.charAt(i)!= ' ') {
				ret = ret + dato.charAt(i);
			}
			else {
				while(i<dato.length() && dato.charAt(i) == ' ') {
					i++;
				}
				if(i!=dato.length()) {
					i--;
					ret = ret + " ";
				}
			}
		}
		
		return ret;
	}

}

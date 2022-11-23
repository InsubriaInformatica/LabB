import java.sql.SQLException;
import java.util.List;

//PATTERN SKELETON --> solleva il server dalla gestione delle comunicazioni.
public interface SkeletonInterface {

	//inserisce il nuovo centro nel DB 
	public int registraCentroVaccinale(String nome, String qualificatore, String indirizzo, String numeroCivico, String comune, String provincia, String cap, String tipologia) throws SQLException;
	
	//verifica se il centro è inserito nel DB passando come parametro il nome di questo
	public boolean esisteCentroNome(String nomeCentro) throws SQLException;
	
	//verifica se esiste un centro Vaccinale nel comune e tipologia specificata
	public boolean EsisteCentroCeT(String comune, String tipologia)throws SQLException;
	
	//inserisce vaccinato nel DB
	public int registraVaccinato(String nomeCentro, String nome, String cognome, String codiceFiscale, String dataSomministrazione, String tipoVaccino, String nDosi) throws SQLException ;
	
	//verifica se cittadino si è vaccinato
	public boolean checkCittadinoVaccinato(String codiceFiscale) throws SQLException;
	
	//permette di registrare il cittadino se vaccinato
	public int registrazioneCittadino(String nome, String cognome, String codiceFiscale, String eMail, String username, String password, String IdUnivoco) throws SQLException;
	
	//questo metodo verifica che esiste nome utente
	public boolean esisteUtente(String username) throws SQLException;
	
	//verifica che id in fase di registrazione corrisponde all'utente realmente assegnato
	public boolean verificaCorrispondenzaId(String codiceFiscale, String idVaccinato)throws SQLException;
	
	//verifica se dati login sono corretti
	public boolean login(String username, String password)throws SQLException;
	
	//inserisce evento avverso dell'utente connesso
	public int inserisciEventoAvverso(String codiceFiscale, String evento, String severita, String note)throws SQLException;
	
	//restituisce una lista contenente in posizione 0 il nome e in posizione 1 idUnivoco del vaccinato
	public List<String> IdUnivoco(String codiceFiscale) throws SQLException; 
	
	//ritorna l'elenco dei centri vaccinali registrati nel DB
	public List<String> retElencoCentriVaccinali() throws SQLException;
	
	//ritorna il codice fiscale di quell'utente
	public String retCfUtente(String username)throws SQLException;
	
	//metodo che ritorna list di list contenente elenco eventi avversi dell'utente connesso
	public List<List<String>> retMyElencoEventiAvversi(String username)throws SQLException;
	
	//prende le info dei centri vaccinali tramite ricerca per nome
	public List<String> infoCentriVaccinaliNome(String nomeCentro)throws SQLException;
		
	//prende le info dei centri vaccinali tramite ricerca per comune e tipologia
	public List<List<String>> infoCentriVaccinaliCeT(String comune, String tipologia)throws SQLException;
	
	//crea tabelle nel DB
	public void creazioneTabelle() throws SQLException;
	
	public void creazioneDB();
	
	//Login al database
//	public void LoginServer(String host, String port, String username, String password);
	
}

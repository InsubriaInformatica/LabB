//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import java.sql.SQLException;
import java.util.List;
/**
 * Pattern dello Skeleton: solleva il server dalla gestione delle comunicazioni.
 * @author Simone Battaglia
 *
 */
public interface SkeletonInterface {

	/**
	 * inseirsce il nuovo centro vaccinale nel DB 
	 * @param nome
	 * @param qualificatore
	 * @param indirizzo
	 * @param numeroCivico
	 * @param comune
	 * @param provincia
	 * @param cap
	 * @param tipologia
	 * @return
	 * @throws SQLException
	 */
	public int registraCentroVaccinale(String nome, String qualificatore, String indirizzo, String numeroCivico, String comune, String provincia, String cap, String tipologia) throws SQLException;
	
	
	/**
	 * Verifica se il centro vaccinale "nomeCentro" esiste all'interno del DB
	 * @param nomeCentro
	 * @throws SQLException
	 */
	public boolean esisteCentroNome(String nomeCentro) throws SQLException;
	
	/**
	 * verifica se esiste un centro Vaccinale nel comune e della tipologia passati come parametri
	 * @param comune
	 * @param tipologia
	 * @throws SQLException
	 */
	public boolean EsisteCentroCeT(String comune, String tipologia)throws SQLException;
	
	/**
	 * inserisce vaccinato nel DB
	 * @param nomeCentro
	 * @param nome
	 * @param cognome
	 * @param codiceFiscale
	 * @param dataSomministrazione
	 * @param tipoVaccino
	 * @param nDosi
	 * @throws SQLException
	 */
	public int registraVaccinato(String nomeCentro, String nome, String cognome, String codiceFiscale, String dataSomministrazione, String tipoVaccino, String nDosi) throws SQLException ;
	
	/**
	 * Verifica se il cittadino corrispondente ad un certo codice fiscale � vaccinato
	 * @param codiceFiscale
	 * @throws SQLException
	 */
	public boolean checkCittadinoVaccinato(String codiceFiscale) throws SQLException;
	
	/**
	 * Permette di registrare il cittadino (nel caso in cui questo sia vaccinato)
	 * @param nome
	 * @param cognome
	 * @param codiceFiscale
	 * @param eMail
	 * @param username
	 * @param password
	 * @param IdUnivoco
	 * @throws SQLException
	 */
	public int registrazioneCittadino(String nome, String cognome, String codiceFiscale, String eMail, String username, String password, String IdUnivoco) throws SQLException;
	
	/**
	 * verifica se esiste un utente registrato con quel username
	 * @param username
	 * @throws SQLException
	 */
	public boolean esisteUtente(String username) throws SQLException;
	
	/**
	 * verifica corrispondenza tra codice fiscale ed identificativo di un certo vaccinato.
	 */
	public boolean verificaCorrispondenzaId(String codiceFiscale, String idVaccinato)throws SQLException;
	
	/**
	 * verifica corrispondenza tra username e password
	 * @param username
	 * @param password
	 * @throws SQLException
	 */
	public boolean login(String username, String password)throws SQLException;
	
	/**
	 * aggiunge nel DB l'evento avverso inserito dall'utente connesso
	 * @param codiceFiscale
	 * @param evento
	 * @param severita
	 * @param note
	 * @throws SQLException
	 */
	public int inserisciEventoAvverso(String codiceFiscale, String evento, String severita, String note)throws SQLException;
	
	//restituisce una lista contenente in posizione 0 il nome e in posizione 1 idUnivoco del vaccinato
	/**
	 * restituisce una lista che: in posizione <b>0</b> contiene il nome del vaccinato, mentre in posizione <b>1</b> contiene il suo id univoco 
	 * @param codiceFiscale
	 * @return
	 * @throws SQLException
	 */
	public List<String> IdUnivoco(String codiceFiscale) throws SQLException; 
	
	/**
	 * il metodo ritorna l'elenco di tutti i centri vaccinali presenti nel DB
	 * @throws SQLException
	 */
	public List<String> retElencoCentriVaccinali() throws SQLException;
	
	/**
	 * ritorna il Codice Fiscale dell'utente relativo allo username passato come parametro
	 * @param username
	 * @throws SQLException
	 */
	public String retCfUtente(String username)throws SQLException;
	
	/**
	 * ritorna una list di list, contenente l'elenco di tutti gli eventi avversi inseriti dall'utente connesso
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public List<List<String>> retMyElencoEventiAvversi(String username)throws SQLException;
	
	//prende le info dei centri vaccinali tramite ricerca per nome
	public List<String> infoCentriVaccinaliNome(String nomeCentro)throws SQLException;
		
	//prende le info dei centri vaccinali tramite ricerca per comune e tipologia
	public List<List<String>> infoCentriVaccinaliCeT(String comune, String tipologia)throws SQLException;
	
	/**
	 * crea le tabelle nel DB
	 * @throws SQLException
	 */
	public void creazioneTabelle() throws SQLException;
	
	/**
	 * crea il DB 
	 */
	public void creazioneDB();
	
	/**
	 * genera dataset
	 */
	public void creazioneDataset();
	
}

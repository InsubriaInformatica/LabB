//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import java.sql.SQLException;
import java.util.List;

/**
 * FORNISCE I METODI NECESSARI DEL SERVER, in base alle richieste del client
 * @author Gabriele Sassi
 *
 */
public interface ServerInterface {
	
	/**
	 * Metodo che inserisce il nuovo centro nel DB 
	 * @param nome
	 * @param qualificatore
	 * @param indirizzo
	 * @param numeroCivico
	 * @param comune
	 * @param provincia
	 * @param cap
	 * @param tipologia
	 * @return
	 */
	public int registraCentroVaccinale(String nome, String qualificatore, String indirizzo, String numeroCivico, String comune, String provincia, String cap, String tipologia);
	
	/**
	 * Metodo che inserisce un nuovo vaccinato nel DB
	 * @param nomeCentro
	 * @param nome
	 * @param cognome
	 * @param codiceFiscale
	 * @param dataSomministrazione
	 * @param tipoVaccino
	 * @param nDosi
	 * @return
	 */
	public int registraVaccinato(String nomeCentro, String nome, String cognome, String codiceFiscale, String dataSomministrazione, String tipoVaccino, String nDosi);
	
	/**
	 * Metodo che effettua inserimento nel DB di un cittadino vaccinato
	 * @param nome
	 * @param cognome
	 * @param codiceFiscale
	 * @param eMail
	 * @param username
	 * @param password
	 * @param IdUnivoco
	 * @return
	 */
	public int registrazioneCittadino(String nome, String cognome, String codiceFiscale, String eMail, String username, String password, String IdUnivoco);
	
	/**
	 * Metodo che controlla se utente esiste verificando username
	 * @param username
	 * @return
	 */
	public boolean esisteUtente(String username);
	
	/**
	 * Metodo che verifica che id in fase di registrazione corrisponde all'utente realmente assegnato
	 * @param codiceFiscale
	 * @param idVaccinato
	 * @return
	 */
	public boolean verificaCorrispondenzaId(String codiceFiscale, String idVaccinato);
	
	/**
	 * Metodo che verifica l'esistenza con il db di un username o password registrata
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password);
	
	/**
	 * Metodo che registra nel DB un nuovo evento avverso di un cittadino
	 * @param codiceFiscale
	 * @param evento
	 * @param severita
	 * @param note
	 * @return
	 */
	public int inserisciEventoAvverso(String codiceFiscale, String evento, String severita, String note);
	
	/**
	 * Metodo che verifica se esiste un centro Vaccinale con quel nome
	 * @param nome
	 * @return
	 */
	public boolean EsisteCentroNome(String nome);
	
	/**
	 * Metodo che verifica se esiste un centro Vaccinale nel comune e tipologia specificata
	 * @param comune
	 * @param tipologia
	 * @return
	 */
	public boolean EsisteCentroCeT(String comune, String tipologia);
	
	/**
	 * Metodo che prende le info dei centri vaccinali tramite ricerca per nome
	 * @param nomeCentro
	 * @return
	 */
	public List<String> infoCentriVaccinaliNome(String nomeCentro);
	
	/**
	 * Metodo che prende le info dei centri vaccinali tramite ricerca per comune e tipologia
	 * @param comune
	 * @param tipologia
	 * @return
	 */
	public List<List<String>> infoCentriVaccinaliCeT(String comune, String tipologia);
		
	/**
	 * Metodo che controlla se cittadino si è effettivamente registrato
	 * @param nomeCittadino
	 * @return
	 */
	public boolean checkCittadinoVaccinato(String nomeCittadino);
	
	/**
	 * Metodo che ritorna elenco centri vaccinali inseriti nel DB
	 * @return
	 */
	public List<String> retElencoCentriVaccinali();
	
	/**
	 * Metodo che ritorna elenco eventi avversi inseriti nel DB per quell'utente
	 * @param username
	 * @return
	 */
	public List<List<String>> retMyElencoEventiAvversi(String username);

	/**
	 * Metodo che restituisce una lista contenente in posizione 0 il nome e in posizione 1 idUnivoco del vaccinato
	 * @param codiceFiscale
	 * @return
	 */
	public List<String> IdUnivoco(String codiceFiscale);

	/**
	 * Metodo che ritorna il codice fiscale di quell'utente che ne fa richiesta
	 * @param username
	 * @return
	 */
	public String retCfUtente(String username);
	
	/**
	 * Metodo che serve per la creazione del dataset
	 */
	public void creazioneDataset();
	
}

import java.sql.SQLException;
import java.util.List;

//FORNISCE I METODI NECESSARI DEL SERVER, in base alle richieste del client
public interface ServerInterface {
	
	//inserisce il nuovo centro nel DB 
	public int registraCentroVaccinale(String nome, String qualificatore, String indirizzo, String numeroCivico, String comune, String provincia, String cap, String tipologia);
	
	//inserisce un nuovo vaccinato nel DB
	public int registraVaccinato(String nomeCentro, String nome, String cognome, String codiceFiscale, String dataSomministrazione, String tipoVaccino, String nDosi);
	
	//effettua inserimento nel DB di un cittadino vaccinato
	public int registrazioneCittadino(String nome, String cognome, String codiceFiscale, String eMail, String username, String password, String IdUnivoco);
	
	//controlla se utente esiste verificando username
	public boolean esisteUtente(String username);
	
	//verifica che id in fase di registrazione corrisponde all'utente realmente assegnato
	public boolean verificaCorrispondenzaId(String codiceFiscale, String idVaccinato);
	
	//verifica l'esistenza con il db di un username o password registrata
	public boolean login(String username, String password);
	
	//registra nel DB un nuovo evento avverso di un cittadino
	public int inserisciEventoAvverso(String codiceFiscale, String evento, String severita, String note);
	
	//verifica se esiste un centro Vaccinale con quel nome
	public boolean EsisteCentroNome(String nome);
	
	//verifica se esiste un centro Vaccinale nel comune e tipologia specificata
	public boolean EsisteCentroCeT(String comune, String tipologia);
		
	//controlla se cittadino si è effettivamente registrato
	public boolean checkCittadinoVaccinato(String nomeCittadino);
	
	//ritorna elenco centri vaccinali inseriti nel DB
	public List<String> retElencoCentriVaccinali();
	
	//ritorna elenco eventi avversi inseriti nel DB per quell'utente
	public List<List<String>> retElencoEventiAvversi(String username);

	//restituisce una lista contenente in posizione 0 il nome e in posizione 1 idUnivoco del vaccinato
	public List<String> IdUnivoco(String codiceFiscale);

	//ritorna il codice fiscale di quell'utente che ne fa richiesta
	public String retCfUtente(String username);
	
}

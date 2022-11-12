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
	
	//verifica l'esistenza con il db di un username o password registrata
	public boolean login(String username, String password);
	
	//registra nel DB un nuovo evento avverso di un cittadino
	public int inserisciEventoAvverso(String codiceFiscale, String evento, String severità, String note);
	
	//verifica se esiste un centro Vaccinale con quel nome
	public boolean EsisteCentroNome(String nome);
	
	//verifica se esiste un centro Vaccinale nel comune e tipologia specificata
	public boolean EsisteCentroCeT(String comune, String tipologia);
	
	//verifica esistenza di username del cittadino
	public boolean esisteUsername(String username);
	
	//controlla se il cittadino si è vaccinato per effettuare registrazione
	public boolean checkCittadinoVaccinatoPerRegistrazione(String codiceFiscale, String cognome, String nome, String idUnivoco, String nomeCentro);
	
	//controlla se cittadino si è effettivamente registrato
	public boolean checkCittadinoVaccinato(String nomeCittadino);
	
	//ritorna elenco centri vaccinali inseriti nel DB
	public List<String> retElencoCentriVaccinali();
	
	//ritorna elenco eventi avversi inseriti nel DB
	public List<String> retElencoEventiAvversi();

	
	public List<String> IdUnivoco(String codiceFiscale);
	
	
	
}

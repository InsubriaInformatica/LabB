//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestisce la logica di funzionamento dell'applicazione
 * @author Gabriele Sassi
 *
 */
public class ModelImpl implements Model{
	
	private View v;
	private ServerInterface proxy; //chiamata locale 
	String utenteConnesso; //utente al momento loggato
	private boolean flag;
	private boolean err;

	/**
	 * Riferimento a view dove model dovrà operare, instanzia riferimento proxy server locale dove andrà ad operare
	 * @param v
	 */
	public ModelImpl(View v) {
		
		try {
			
			this.v = v; //instanzia view
			this.utenteConnesso = null;
			this.proxy = new Proxy(InetAddress.getByName("localhost"), 8080); //local host e porta
			
		} catch (UnknownHostException e) {
			System.err.println("CLIENT MODEL: host sconosciuto " + e.toString());
		}
	}
	
	//METODI PER VERIFICARE I CAMPI INSERITI
	
	/**
	 * Metodo che controlla se ci sono campi vuoti
	 * @param daControllare
	 * @return vero se non contiene stringhe vuote altrimenti falso
	 */
	public boolean controlloStringheVuote(List<String> daControllare) {
		
		for(String str: daControllare) {
			if(str.equals("")) {
				return true; //se non contiene stringhe vuote
			}
		}
		return false; //se contiene stringhe vuote
	}

	/**
	 * Metodo che controlla dati inseriti per registrare il centro vaccinale
	 * @param datiCentro
	 * @return
	 */
	public boolean controlloDatiNuovoCentro(List <String> datiCentro) {
		boolean res = true;
		
		//campi vuoti
		if(datiCentro.get(0).equals("") || datiCentro.get(2).equals("") || datiCentro.get(3).equals("") || datiCentro.get(4).equals("") || datiCentro.get(5).equals("") || datiCentro.get(6).equals("")  ) {
			return false;  //dati forniti non validi
		}
		
		//centro esistente
		if(this.proxy.EsisteCentroNome(datiCentro.get(0))) {
			return false; 
		}
		
		//provincia lughezza 2 caratteri
		if(datiCentro.get(5).length() != 2) {
			return false;
		}
		
		//provincia deve contenere solo lettere 
		for(int i=0; i<datiCentro.get(5).length(); i++) {
			if((!('a' <= datiCentro.get(5).charAt(i) && datiCentro.get(5).charAt(i) <= 'z')) && (!('A' <= datiCentro.get(5).charAt(i) && datiCentro.get(5).charAt(i) <= 'Z'))) {
				return false;
			}	
		}
		
		//cap lunghezza 5
		if(datiCentro.get(6).length() != 5) {
			return false;
		}
		
		//cap deve avere solo caratteri numerici
		for(int i=0; i<datiCentro.get(6).length(); i++) {
			if(!('0' <= datiCentro.get(6).charAt(i) && datiCentro.get(6).charAt(i) <= '9')) {
				return false;
			}
		}
		return res;
	}
	
	/**
	 * Metodo che verifica la correttezza del modello del codice fiscale inserito: AAAAAA00A00A000A
	 * @param codiceFiscale
	 * @return
	 */
	public boolean controlloCodiceFiscale(String codiceFiscale) {
		
		boolean res = false;
		if(codiceFiscale.length()==16) {
			res = true;
		}
		else {
			return false;
		}
		for(int i=0; i<6; i++) {
			if(('A'<=codiceFiscale.charAt(i) && codiceFiscale.charAt(i)<='Z') || ('a'<=codiceFiscale.charAt(i) && codiceFiscale.charAt(i)<='z')) {
				res = true;
			}
			else {
				return false;
			}
		}
		if(('A'<=codiceFiscale.charAt(8) && codiceFiscale.charAt(8)<='Z') || ('a'<=codiceFiscale.charAt(8) && codiceFiscale.charAt(8)<='z')) {
			res = true;
		} 
		else {
			return false;
		}
		if(('A'<=codiceFiscale.charAt(11) && codiceFiscale.charAt(11)<='Z') || ('a'<=codiceFiscale.charAt(11) && codiceFiscale.charAt(11)<='z')) {
			res = true;
		}
		else {
			return false;
		}
		if(('A'<=codiceFiscale.charAt(15) && codiceFiscale.charAt(15)<='Z') || ('a'<=codiceFiscale.charAt(15) && codiceFiscale.charAt(15)<='z')) {
			res = true;
		}
		else {
			return false; 
		}
		if('0'<=codiceFiscale.charAt(6) && codiceFiscale.charAt(6)<='9') {
			res = true;
		}
		else {
			return false;
		}
		if('0'<=codiceFiscale.charAt(7) && codiceFiscale.charAt(7)<='9') {
			res = true;
		}
		else {
			return false;
		}
		if('0'<=codiceFiscale.charAt(9) && codiceFiscale.charAt(9)<='9') {
			res = true;
		}
		else {
			return false;
		}
		if('0'<=codiceFiscale.charAt(10) && codiceFiscale.charAt(10)<='9') {
			res = true;
		}
		else {
			return false;
		}
		if('0'<=codiceFiscale.charAt(12) && codiceFiscale.charAt(12)<='9') {
			res = true;
		}
		else {
			return false;
		}
		if('0'<=codiceFiscale.charAt(13) && codiceFiscale.charAt(13)<='9') {
			res = true;
		}
		else {
			return false;
		}
		if('0'<=codiceFiscale.charAt(14) && codiceFiscale.charAt(14)<='9') {
			res = true;
		}
		else {
			return false;
		}
		
		return true; //rispetta lo standard
	}
	
	/**
	 * Metodo che verifica se cittadino è vaccinato
	 * @param cf
	 * @return
	 */
	public boolean isVaccinato(String cf) {
		return this.proxy.checkCittadinoVaccinato(cf);
	}
	
	/**
	 * Metodo che verifica che id in fase di registrazione corrisponde all'utente realmente assegnato
	 * @param codiceFiscale
	 * @param idVaccinato
	 * @return
	 */
	public boolean controlloIdUnivoco(String codiceFiscale, String idVaccinato) {
		return this.proxy.verificaCorrispondenzaId(codiceFiscale, idVaccinato);
	}
	
	/**
	 * Metodo che controlla modello e-mail --> nome@dominio.it/com ecc..
	 * @param eMail
	 * @return
	 */
	public boolean controlloEmail(String eMail) {
		String emailControllo = eMail;
		String[] nome = emailControllo.split("@");
		boolean res = false;
		if(nome.length>1) {
			for(int i=0; i<nome[1].length(); i++) {
				if(nome[1].charAt(i) == '.') {
					res = true;
					if(i<nome[1].length()-1) {
						res = true; //se rispetta modello
					}
					else {
						res = false;
					}
				}
			}
		}
		else {
			res = false;
		}
		return res;
	}

	/**
	 * Metodo che verifica centro vaccinale
	 * @param datiCentroVaccinale
	 * @return
	 */
	public Object registraCentroVaccinale(List<String> datiCentroVaccinale) {
		
		List<String> ret = new ArrayList <String>();

		if(controlloDatiNuovoCentro(datiCentroVaccinale)) {
			this.proxy.registraCentroVaccinale(datiCentroVaccinale.get(0), datiCentroVaccinale.get(1), datiCentroVaccinale.get(2), datiCentroVaccinale.get(3), datiCentroVaccinale.get(4), datiCentroVaccinale.get(5), datiCentroVaccinale.get(6), datiCentroVaccinale.get(7));
			ret = datiCentroVaccinale;
		}
		else {
			ret.add("ERRORE:");
			
			//campi obbligatori (*)
			if(datiCentroVaccinale.get(0).equals("") || datiCentroVaccinale.get(2).equals("") || datiCentroVaccinale.get(3).equals("") || datiCentroVaccinale.get(4).equals("") || datiCentroVaccinale.get(5).equals("") || datiCentroVaccinale.get(6).equals("")){
				ret.add("-INSERISCI TUTTI I CAMPI OBBLIGATORI");
			}
			
			if(this.proxy.EsisteCentroNome(datiCentroVaccinale.get(0))){
				ret.add("-CENTRO GIA' ESISTENTE");
			}
			
			//lunghezza sigla provincia 2
			if(datiCentroVaccinale.get(5).length() != 2) {
				ret.add("-ATTENZIONE: PROVINCIA DI TIPO: 'VA'");
			}
			
			//provincia deve contenere solo lettere 
			for(int i=0; i<datiCentroVaccinale.get(5).length(); i++) {
				if((!('a' <= datiCentroVaccinale.get(5).charAt(i) && datiCentroVaccinale.get(5).charAt(i) <= 'z')) && (!('A' <= datiCentroVaccinale.get(5).charAt(i) && datiCentroVaccinale.get(5).charAt(i) <= 'Z'))) {
					ret.add("-PROVINCIA CON SOLO LETTERE");
				}
				break;
			}
			
			//cap lunghezza 5
			if(datiCentroVaccinale.get(6).length() != 5) {
				//ret.add("ERRORE:");
				ret.add("-IL CAP DEVE CONTENERE 5 CIFRE");
			}
			
			//cap deve avere solo caratteri numerici
			for(int i=0; i<datiCentroVaccinale.get(6).length(); i++) {
				if(!('0' <= datiCentroVaccinale.get(6).charAt(i) && datiCentroVaccinale.get(6).charAt(i) <= '9')) {
					//ret.add("ERRORE:");
					ret.add("-IL CAP DEVE CONTENERE SOLO CIFRE");
				}
				break;
			}
		
		}
		return ret;
	}
	
	/**
	 * Metodo che verifica i dati del vaccininato
	 * @param datiVaccinato
	 * @return
	 */
	public Object registraVaccinato(List<String> datiVaccinato) {
		List<String> ret = new ArrayList <String>();
		boolean controlloCF = controlloCodiceFiscale(datiVaccinato.get(3)); //controllo CF inserito
		boolean isVaccinato = isVaccinato(datiVaccinato.get(3)); //controlla se cittadino è vaccinato con CF
		
		if(!isVaccinato && controlloCF) { //se CF inserito corretto e cittadino non ancora vaccinato
			
			this.proxy.registraVaccinato(datiVaccinato.get(0), datiVaccinato.get(1), datiVaccinato.get(2), datiVaccinato.get(3), datiVaccinato.get(4), datiVaccinato.get(5), datiVaccinato.get(6));
			
			//QUESTO serve per prendere i dati da mostrare una volta inserito il vaccinato
			List<String> retIdUnivocoeCf = (List<String>) retIdUnivoco(datiVaccinato.get(3));
			ret = retIdUnivocoeCf; //ritorna una lista contenente Cf e IdUnivoco del vaccinato
		} 
	
		else {
			ret.add("ERRORE:");
			
			if(!controlloCF) {
				ret.add("-CODICE FISCALE NON RISPETTA STANDARD");
			}
			
			if(isVaccinato) {
				ret.add("-CITTADINO GIA' VACCINATO");
			}			
		}
		return ret;
	}
	
	/**
	 * Metodo che ritorna codice fiscale e id Univoco di vaccinazione, in base al codice fiscale del vaccinato
	 * @param codiceFiscale
	 * @return
	 */
	private Object retIdUnivoco(String codiceFiscale) {
		List<String> res = new ArrayList <String> ();
		
		List<String> dati = this.proxy.IdUnivoco(codiceFiscale);
		
		if(dati.size() != 0) {
			res.add(codiceFiscale);
			res.add(dati.get(2));
		}
		
		return res;
	}
	
	
	/**
	 * Metodo che permette al cittadino di registrarsi dopo aver effettuato la vaccinazione
	 * @param datiRegistrazione
	 * @return
	 */
	public Object registrazioneCittadino(List<String> datiRegistrazione) {
		List<String> ret = new ArrayList <String>();
		boolean stringheVuote = controlloStringheVuote(datiRegistrazione); // controllo stringhe vuote nella lista
		
		if(!stringheVuote) { //verifica che non ci siano stringhe vuote
			
			boolean idValido = controlloIdUnivoco(datiRegistrazione.get(2), datiRegistrazione.get(6)); //controllo id numerico
			
			if(idValido) {
				boolean isVaccinato = isVaccinato(datiRegistrazione.get(2)); //controlla se cittadino è vaccinato con CF
				boolean controlloCF = controlloCodiceFiscale(datiRegistrazione.get(2)); //controlla modello CF 
				boolean controlloEmail = controlloEmail(datiRegistrazione.get(3)); //controlla modello e-mail
				boolean utenteEsistente = this.proxy.esisteUtente(datiRegistrazione.get(4)); //controlla se utente esiste
				
				if(isVaccinato){ //se utente è vaccinato
					
					if(controlloCF && controlloEmail && !utenteEsistente) { //controlla campi inseriti, se ok registra
						this.proxy.registrazioneCittadino(datiRegistrazione.get(0), datiRegistrazione.get(1), datiRegistrazione.get(2), datiRegistrazione.get(3), datiRegistrazione.get(4), datiRegistrazione.get(5), datiRegistrazione.get(6));
						ret = datiRegistrazione;
					}
					else {
						ret.add("ERRORE:");
						
						if(!controlloCF)
							ret.add("-VERIFICA CODICE FISCALE INSERITO");
						
						if(!controlloEmail) {
							ret.add("-VERIFICA E-MAIL INSERITA");
						}
						
						if(utenteEsistente) {
							ret.add("-NOME UTENTE GIA' ESISTENTE");
						}
					}
					
				}
				else {
					ret.add("ERRORE:");
					ret.add("-UTENTE NON VACCINATO:");
				}
			}
			
			else {
				ret.add("ERRORE:");
				ret.add("-NESSUNA CORRISPONDENZA: VERIFICA ID UNIVOCO E CODICE FISCALE INSERITO");
			}
		
		}
		else {
			ret.add("ERRORE:");
			ret.add("-INSERISCI TUTTI I CAMPI");
		}
				
		return ret;
	}
		
	/**
	 * Metodo che verifica i dati inseriti in fase di login
	 * @param datiLogin
	 * @return
	 */
	public Object login(List <String> datiLogin) {
		List<String> ret = new ArrayList <String>();
		
		if(datiLogin.get(0).equals("") || datiLogin.get(1).equals("")) {
			ret.add("ERRORE:");
			
			if(datiLogin.get(0).equals("")) {
				ret.add("-INSERISCI USERNAME");
			}
			
			if(datiLogin.get(1).equals("")) {
				ret.add("-INSERISCI PASSWORD");
			}
			
		}
		else {
			boolean successo = this.proxy.login(datiLogin.get(0), datiLogin.get(1));
			
			if(successo == true) {
				this.utenteConnesso = datiLogin.get(0); //memorizza utente connesso per visualizza in seguito gli eventi avversi da lui inseriti
				System.out.println("Login effettuato da: " + utenteConnesso );
				ret = datiLogin;
			}
			else {
				ret.add("ERRORE:");
				ret.add("-UTENTE NON REGISTRATO");
			}
				
		}
		return ret;
	}
	
	/**
	 * Metodo che permette di inserire evento avverso
	 * @param datiEvento
	 * @return
	 */
	public Object inserisciEventoAvverso(List <String> datiEvento) {
		Object ret = null;
		
		if(datiEvento.get(2).length()>255) {
			err = true;
			List <String> errore = new ArrayList<String>();
			errore.add("ERRORE:");
			errore.add("-MASSIMO 256 CARATTERI");
			ret = errore;
			
		}
		else {
			String codiceFiscale = this.proxy.retCfUtente(this.utenteConnesso);
			this.proxy.inserisciEventoAvverso(codiceFiscale, datiEvento.get(0), datiEvento.get(1), datiEvento.get(2)); //inserisce evento avverso
			ret = this.proxy.retMyElencoEventiAvversi(utenteConnesso); //restituisce lista con tutti eventi avversi da visualizzare sulla tabella 
			System.out.println("Evento avverso inserito da: " + this.utenteConnesso);
		}
		return ret;
	}
	
	/**
	 * Metodo che si occupa di ricerca delle info del centro vaccinale, con i dati contenuti
	 * @param infoDatiCentro
	 * @return
	 */
	public Object visualizzaInfoCentriVaccinali(List<String> infoDatiCentro){
		
		Object datiDaVisualizzare = null;
		boolean nomeInserito = false;
		boolean comuneEtipoInserito = false;
		
		
		if(infoDatiCentro.get(0).equals("")) {
			nomeInserito = true;
		}
		
		if(infoDatiCentro.get(1).equals("")) {
			comuneEtipoInserito = true;
		}
		
		
		if(!nomeInserito || !comuneEtipoInserito) { //se uno dei due è inserito
			if(!infoDatiCentro.get(0).equals("")) { //se inserito nome 
				
				if(this.proxy.EsisteCentroNome(infoDatiCentro.get(0))) {
					List<String> infoXnome = this.proxy.infoCentriVaccinaliNome(infoDatiCentro.get(0));
					datiDaVisualizzare = infoXnome;
					
				}
				else {
					List<String> errore = new ArrayList<String>();
					errore.add("ERRORE:");
					errore.add("-CENTRO NON ESISTENTE");
					datiDaVisualizzare = errore;
				}
			}
			else { //si cerca per comune e tipologia
				if(this.proxy.EsisteCentroCeT(infoDatiCentro.get(1), infoDatiCentro.get(2))) {
					List<List<String>> infoXceT = this.proxy.infoCentriVaccinaliCeT(infoDatiCentro.get(1), infoDatiCentro.get(2));
					datiDaVisualizzare = infoXceT;
				}
				else {
					List<String> errore = new ArrayList<String>();
					errore.add("ERRORE:");
					errore.add("-NON ESISTONO CENTRI IN QUEL COMUNE DI QUELLA TIPOLOGIA");
					datiDaVisualizzare = errore;
				}
				
			}
		}
		
		else {
			err = true;
			List<String> errore = new ArrayList<String>();
			errore.add("ERRORE:");
			errore.add("-INSERISCI O NOME CENTRO O NOME COMUNE");
			datiDaVisualizzare = errore;
		}
		return datiDaVisualizzare;
	}
	
	
	
	public Object sceltaCentroVaccinalePerInfo(List<String> datiInfo) {
		Object ret = null;
		
		if(!datiInfo.get(0).equals("")) {
			List<String> esito = this.proxy.infoCentriVaccinaliNome(datiInfo.get(0));
			ret = esito;
		}
		else {
			List<List<String>> esito = this.proxy.infoCentriVaccinaliCeT(datiInfo.get(1), datiInfo.get(2));
			ret = esito;
		}
		
		return ret;
	}
		
	/**
	 * Metodo che rimette a null l'utente connesso se torna alla schermata di login
	 * @return
	 */
	public Object esciDaEA() {
		List<String> ret = null;
		
		if(this.v.getViewAttuale().equals("inserimentoEventiAvversi")) {
			this.utenteConnesso = null;
			System.out.println("Utente sconnesso: " + utenteConnesso);
		}
		
		return ret;
	}

	/**
	 * Metodo richiamato dal controller che aggiorna ed elabora dati da mostrare alla view
	 * @param source: evento di origine (es. bottone che è stato cliccato)
	 * @param dati: dati mandati dal controller e presi dalla view
	 */
	public void updateModel(String source, Object dati) {
		
		String button = source;
		Object datiPerModel = null;
		this.flag = false;
		
		if(button.equals("REGISTRA CENTRO")) {
			List<String> datiCentro = (List<String>) dati;
			datiPerModel = (List<String>) registraCentroVaccinale(datiCentro);
			
			if(((List<String>) datiPerModel).get(0).equals("ERRORE:")){
				this.flag = true;
			}
		}
		
		/**
		 * Metodo che manda dati alla combobox per visualizzare centro vaccinali
		 */
		if(button.equals("REGISTRA NUOVO VACCINATO")) {
			List<String> datiDaMandareAview = this.proxy.retElencoCentriVaccinali();
			datiPerModel = datiDaMandareAview;
		}
		
		if(button.equals("REGISTRA VACCINATO")) {
			List<String> datiVaccinato = (List<String>) dati;
			datiPerModel = (List<String>) registraVaccinato(datiVaccinato);
			
			if(((List<String>) datiPerModel).get(0).equals("ERRORE:")){
				this.flag = true;
			}
		}
		
		if(button.equals("CONFERMA-REGISTRAZIONE")) {
			List<String> datiRegistrazione = (List<String>) dati;
			datiPerModel = (List<String>) registrazioneCittadino(datiRegistrazione);
			
			if(((List<String>) datiPerModel).get(0).equals("ERRORE:")){
				this.flag = true;
			}
			
		}
		
		if(button.equals("ACCEDI")) {
			List<String> datiLogin = (List<String>) dati;
			datiPerModel = (List<String>) login(datiLogin);
			
			if(((List<String>) datiPerModel).get(0).equals("ERRORE:")){
				this.flag = true;
			}
		}
		
		if(button.equals("CONFERMA EVENTO AVVERSO")) {
			List<String> datiInserimentoEA = (List<String>) dati;
			datiPerModel = (List <String>) inserisciEventoAvverso(datiInserimentoEA);
			
			if(err){
				err = false;
				this.flag = true;
			}
		}
		
		if(button.equals("ComboBoxCentroInfo")) {
			List<String> info = (List<String>) dati;
			datiPerModel = (List<String>) sceltaCentroVaccinalePerInfo(info);		
		}
		
		
		if(button.equals("CercaNome")) {
			List<String> info = (List<String>) dati;
			datiPerModel = (List<String>) visualizzaInfoCentriVaccinali(info);
			
			
			if(((List<String>) datiPerModel).get(0).equals("ERRORE:")){
				this.flag = true;
				
			}
			
		}
		
		if(button.equals("CercaComune")) {
			List<String> info = (List<String>) dati;
			datiPerModel = (List<List<String>>) visualizzaInfoCentriVaccinali(info);
			
			if(err){
				err = false;
				this.flag = true;
			}
		}
		
		if(button.equals("cambiaIP")) {
			String IP = (String) dati;
			try {
				this.proxy = new Proxy(InetAddress.getByName(IP), 8080); //local host e porta
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} 
		}
		
		if(button.equals("Dataset")) {
			this.proxy.creazioneDataset();
		}
		
		//passo info eventi a view
		
		if(button.equals("INDIETRO")) {
			datiPerModel = (List<String>) esciDaEA();
		}
		
		this.v.updateView(button, datiPerModel, this.flag); //aggiorna view in base all'elaborazione
	}
	
}

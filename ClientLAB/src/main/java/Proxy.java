//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import java.io.*;
import java.net.*;
import java.util.List;

/**
 * PATTERN PROXY --> intermediaro tra richieste del client e ricerca di risorse sul server
 * @author Simone Battaglia, Qaldo Ademi
 *
 */
public class Proxy implements ServerInterface{
	
	private Socket socket;
	private ObjectInput in;
	private ObjectOutput out;
	
	/**
	 * Costruttore che istanzia connessione con server e buffer di comunicazione
	 * @param addr
	 * @param port
	 */
	public Proxy(InetAddress addr, int port) {
		
		try {
			
			if(this.socket != null) {
				this.socket.close();
			}
			
			this.socket = new Socket(addr, port); //indirizzo e porta server
			this.out = new ObjectOutputStream(this.socket.getOutputStream());
			this.in = new ObjectInputStream(this.socket.getInputStream());
			
		} catch (IOException e) {
			
			System.err.println("PROXY: errore di connessione al server " + e.toString());
		} 
	}

	
	public int registraCentroVaccinale(String nome, String qualificatore, String indirizzo, String numeroCivico, String comune, String provincia, String cap, String tipologia) {
		Integer res = 0; //segnale restituito dal server con callBack
		
		try {
			
			this.out.writeObject("registraCentro");
			this.out.writeObject(nome);
			this.out.writeObject(qualificatore);
			this.out.writeObject(indirizzo);
			this.out.writeObject(numeroCivico);
			this.out.writeObject(comune);
			this.out.writeObject(provincia);
			this.out.writeObject(cap);
			this.out.writeObject(tipologia);
			
			res = (Integer) this.in.readObject(); //ascolta risposta da server
			
		} catch (IOException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Proxy: problemi con salvataggio: " + e.toString());
		}
		
		return res.intValue(); //se maggiore di zero aggiunto, se = o < no perchè gia esiste
	}
	

	/**
	 * Metodo che verifica l'esistenza di una centro vaccinale nel DB
	 */
	public boolean EsisteCentroNome(String nomeCentro) {
		boolean res = false;
		
		try {
			this.out.writeObject("esisteCentroNome");
			this.out.writeObject(nomeCentro);
			
			res = (Boolean) this.in.readObject();
			
		} catch (IOException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Proxy: problemi con salvataggio: " + e.toString());
		}
		return res;
	}
	
	/**
	 * Metodo che verifica esistenza centro nel comune e tipologia specificata
	 */
	public boolean EsisteCentroCeT(String comune, String tipologia) {
		boolean res = false;
		
		try {
			this.out.writeObject("esisteCentroComuneTipologia");
			this.out.writeObject(comune);
			this.out.writeObject(tipologia);
			
			res = (Boolean) this.in.readObject();
			
		} catch (IOException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Proxy: problemi con salvataggio: " + e.toString());
		}
		return res;
	}

	/**
	 * Metodo che manda e legge info per registrare vaccinato
	 */
	public int registraVaccinato(String nomeCentro, String nome, String cognome, String codiceFiscale,String dataSomministrazione, String tipoVaccino, String nDosi) {
		Integer res = 0; //segnale restituito dal server con callBack
		
		try {
			
			this.out.writeObject("registraVaccinato");
			this.out.writeObject(nomeCentro);
			this.out.writeObject(nome);
			this.out.writeObject(cognome);
			this.out.writeObject(codiceFiscale);
			this.out.writeObject(dataSomministrazione);
			this.out.writeObject(tipoVaccino);
			this.out.writeObject(nDosi);
			
			res = (Integer) this.in.readObject(); //ascolta risposta da server
			
		} catch (IOException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Proxy: problemi con salvataggio: " + e.toString());
		}
		
		return res.intValue(); //se maggiore di zero aggiunto, se = o < no perchè gia esiste
	}
	
	/**
	 * Metodo che verifica che un cittadino sia stato vaccinato, controllando il CF
	 */
	public boolean checkCittadinoVaccinato(String codiceFiscale) {
			
		boolean res = false;
			
		try {
			this.out.writeObject("verificaCittadinoVaccinato");
			this.out.writeObject(codiceFiscale);
				
			res = ((Boolean) this.in.readObject()).booleanValue();
				
		} catch (IOException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Proxy: problemi con salvataggio: " + e.toString());
		}
		return res;
	}

	public int registrazioneCittadino(String nome, String cognome, String codiceFiscale, String eMail, String username, String password, String IdUnivoco) {
		Integer res = 0;
		
		try {
			this.out.writeObject("registrazione");
			this.out.writeObject(nome);
			this.out.writeObject(cognome);
			this.out.writeObject(codiceFiscale);
			this.out.writeObject(eMail);
			this.out.writeObject(username);
			this.out.writeObject(password);
			this.out.writeObject(IdUnivoco);
			
			res = (Integer) this.in.readObject();
			
		} catch (IOException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Proxy: problemi con salvataggio: " + e.toString());
		}
		
		return res.intValue();
	}
	
	/**
	 * Metodo che verifica se username esiste controllando nome utente
	 */
	public boolean esisteUtente(String username) {
		
		boolean res = false;
		
		try {
			this.out.writeObject("esisteUtente");
			this.out.writeObject(username);
			
			res = (Boolean) this.in.readObject();
			
		} catch (IOException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Proxy: problemi con salvataggio: " + e.toString());
		}
		return res;
	}
	
	/**
	 * Metodo che verifica se id inserito in fase di registrazione è quello dell' utente vaccinato effettivo
	 */
	public boolean verificaCorrispondenzaId(String codiceFiscale, String idVaccinato) {
		
		boolean res = false;
		
		try {
			this.out.writeObject("corrispondenzaId");
			this.out.writeObject(codiceFiscale);
			this.out.writeObject(idVaccinato);
			
			res = (Boolean) this.in.readObject();
			
		} catch (IOException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Proxy: problemi con salvataggio: " + e.toString());
		}
		return res;
	}
	
	/**
	 * Metodo che verifica se dati inseriti sono corretti per accedere
	 */
	public boolean login(String username, String password) {
		
		Boolean res = false;
		
		try {
			this.out.writeObject("login");
			this.out.writeObject(username);
			this.out.writeObject(password);
			
			res = (Boolean) this.in.readObject();
			
		} catch (IOException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Proxy: problemi con salvataggio: " + e.toString());
		}
		return res.booleanValue();
	}


	public int inserisciEventoAvverso(String codiceFiscale, String evento, String severita, String note) {
		Integer ret = 0;
		
		try {
			this.out.writeObject("inserisciEventroAvverso");
			this.out.writeObject(codiceFiscale);
			this.out.writeObject(evento);
			this.out.writeObject(severita);
			this.out.writeObject(note);
			
			ret = (Integer) this.in.readObject();
			
		} catch (IOException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Proxy: problemi con salvataggio: " + e.toString());
		}
		
		return ret.intValue();
	}


	

	public boolean esisteUsername(String username) {
		return false;
	}

	public boolean checkCittadinoVaccinatoPerRegistrazione(String codiceFiscale, String cognome, String nome,
			String idUnivoco, String nomeCentro) {
		return false;
	}


	/**
	 * Metodo che ritorna elenco centri vaccinali registrati
	 */
	public List<String> retElencoCentriVaccinali() {
		List<String> res = null;
		
		try {
			this.out.writeObject("elencoCentriVaccinali");
			res = (List<String>) this.in.readObject();
			
		} catch (IOException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		}
		
		return res;
	}

	/**
	 * Metodo che ritorna id univoco del vaccinato in base al codice fiscale
	 */
	public List<String> IdUnivoco(String codiceFiscale) {
		
		List<String> res = null;
		
		try {
			this.out.writeObject("retIdUnivoco");
			this.out.writeObject(codiceFiscale);
			
			res = (List<String>) this.in.readObject(); //ritorna nome e idUnivoco mandato dal server
			
		} catch (IOException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		}
		return res;
	}
	
	
	/**
	 * Metodo che ritorna il codice fiscale dell'utente passato come parametro
	 */
	public String retCfUtente(String username) {
		String res = "";
		try {
			this.out.writeObject("retMyCodiceFiscale");
			this.out.writeObject(username);
			
			res = (String) this.in.readObject();
			
		} catch (IOException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		}
		return res;
	}
	
	/**
	 * Metodo che richiede al server l'elenco degli eventi avversi dell'username attualmente connesso
	 */
	public List<List<String>> retMyElencoEventiAvversi(String username) {
		List<List<String>> res = null;
		
		try {
			this.out.writeObject("MyElencoEA");
			this.out.writeObject(username);
			
			res = (List<List<String>>) this.in.readObject();
			
		} catch (IOException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		}
		return res;
	}


	/**
	 * Metodo che restituise le informazioni del centro ricercato mediante nome
	 */
	public List<String> infoCentriVaccinaliNome(String nomeCentro) {
		List<String> res = null;
		
		try {
			this.out.writeObject("InfoCentroConNome");
			this.out.writeObject(nomeCentro);
			
			res = (List<String>) this.in.readObject();
			
		} catch (IOException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		}
		
		return res;
	}

	/**
	 * Metodo che restituisce le info del centro cercato mediante comune e tipologia
	 */
	public List<List<String>> infoCentriVaccinaliCeT(String comune, String tipologia) {
		List<List<String>> res = null;
		
		try {
			this.out.writeObject("InfoCentroConComuneTipologia");
			this.out.writeObject(comune);
			this.out.writeObject(tipologia);
			
			res = (List<List<String>>) this.in.readObject();
			
		} catch (IOException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Proxy: problemi nell'acquisizione: " + e.toString());
		}
		
		return res;
	}


	/**
	 * Metodo che si occupa di creare il dataset
	 */
	public void creazioneDataset() {
		try {
			this.out.writeObject("generaDataset");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	



	



	


	
	
	

}

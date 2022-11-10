import java.io.*;
import java.net.*;
import java.util.List;

//PATTERN PROXY --> intermediaro tra richieste del client e ricerca di risorse sul server
public class Proxy implements ServerInterface{
	
	private Socket socket;
	private ObjectInput in;
	private ObjectOutput out;
	
	//COSTRUTTORE --> istanzia connessione con server e buffer di comunicazione
	public Proxy(InetAddress addr, int port) {
		
		try {
			
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

	public int registrazione(String nome, String cognome, String codiceFiscale, String eMail, String username,
			String password, String IdUnivoco) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public int inserisciEventoAvverso(String codiceFiscale, String evento, String severità, String note) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean EsisteCentroNome(String nome) {
		
		return false;
	}

	public boolean EsisteCentroCeT(String comune, String tipologia) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean esisteUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkCittadinoVaccinatoPerRegistrazione(String codiceFiscale, String cognome, String nome,
			String idUnivoco, String nomeCentro) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkCittadinoVaccinato(String nomeCittadino) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<String> retElencoCentriVaccinali() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> retElencoEventiAvversi() {
		// TODO Auto-generated method stub
		return null;
	}



	public List<String> IdUnivoco(String codiceFiscale) {
		
		return null;
	}
	
	

}

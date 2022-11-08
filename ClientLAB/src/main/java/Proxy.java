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
	
	
	
	public int registraCentroVaccinale(String nome, String qualificatore, String indirizzo, String numeroCivico,
			String comune, String provincia, String cap, String tipologia) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int registraVaccinato(String nomeCentro, String nome, String cognome, String codiceFiscale,
			String dataSomministrazione, String tipoVaccino, String nDosi) {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
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
	
	

}

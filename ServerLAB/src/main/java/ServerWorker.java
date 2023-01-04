//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.List;


/**
 * classe che si occupa di gestire i thread server
 * @author Simone Battaglia, Gabriele Sassi
 *
 */
public class ServerWorker extends Thread{

	private Socket socket;
	private SkeletonInterface swi; //oggetto di comunicazione locale 
	
	private ObjectInput in;
	private ObjectOutput out;
	
	//COSTRUTTORE --> stabilisce buffer di comunicazione, prende il socket di connessione e lo skeleton per comunicare
	public ServerWorker(Socket socket, SkeletonInterface swi) {
		
		try {
			this.socket = socket;
			this.swi = swi;
			this.out = new ObjectOutputStream(this.socket.getOutputStream());
			this.in = new ObjectInputStream(this.socket.getInputStream());
			
		} catch (IOException e) {}
		
		start(); //lancia i thread per permettere di eseguire metodo run()
	}
	

	/**
	 * metodo ereditato dalla classe thread. Gestisce le tasks richieste dal client
	 */
	public void run() {
		String inputClient;
		
		while(true) {
			try {
				inputClient = (String) this.in.readObject();
				
				if(inputClient.equals("registraCentro")) {
					String nome = (String) this.in.readObject();
					String qualificatore = (String) this.in.readObject();
					String indirizzo = (String) this.in.readObject();
					String numeroCivico = (String) this.in.readObject();
					String comune = (String) this.in.readObject();
					String provincia = (String) this.in.readObject();
					String cap = (String) this.in.readObject();
					String tipologia = (String) this.in.readObject();
					
					//chiamata il metodo per eseguire query
					int esito = this.swi.registraCentroVaccinale(nome, qualificatore, indirizzo, numeroCivico, comune, provincia, cap, tipologia);
					this.out.writeObject(esito); //comunica al client esito
				}
				
				else if(inputClient.equals("esisteCentroNome")) {
					String nomeCentro = (String) this.in.readObject();
					
					boolean esito = this.swi.esisteCentroNome(nomeCentro);
					this.out.writeObject(esito);
				}
				
				else if(inputClient.equals("esisteCentroComuneTipologia")) {
					String comune = (String) this.in.readObject();
					String tipologia = (String) this.in.readObject();
					
					boolean esito = this.swi.EsisteCentroCeT(comune, tipologia);
					
					this.out.writeObject(esito);
				}
				
				else if(inputClient.equals("registraVaccinato")) {
					
					String nomeCentro = (String) this.in.readObject();
					String nome = (String) this.in.readObject();
					String cognome = (String) this.in.readObject();
					String codiceFiscale = (String) this.in.readObject();
					String data = (String) this.in.readObject();
					String tipoVaccino = (String) this.in.readObject();
					String ndosi = (String) this.in.readObject();
					
					int esito = this.swi.registraVaccinato(nomeCentro, nome, cognome, codiceFiscale, data, tipoVaccino, ndosi);
					this.out.writeObject(esito);
				}
				
				else if(inputClient.equals("verificaCittadinoVaccinato")) {
					
					String cf = (String) this.in.readObject();
					
					Boolean esito = this.swi.checkCittadinoVaccinato(cf);
					this.out.writeObject(esito.booleanValue());
				}
				
				else if(inputClient.equals("retIdUnivoco")) {
					String codiceFiscale = (String) this.in.readObject();
					
					List<String> esito = swi.IdUnivoco(codiceFiscale);
					this.out.writeObject(esito);
				}
				
				else if(inputClient.equals("elencoCentriVaccinali")) {
					this.out.writeObject(this.swi.retElencoCentriVaccinali());
				}
				
				else if(inputClient.equals("registrazione")) {
					String nome = (String) this.in.readObject();
					String cognome = (String) this.in.readObject();
					String codiceFiscale = (String) this.in.readObject();
					String eMail = (String) this.in.readObject();
					String username = (String) this.in.readObject();
					String password = (String) this.in.readObject();
					String idUnivoco = (String) this.in.readObject();
					
					int esito = this.swi.registrazioneCittadino(nome, cognome, codiceFiscale, eMail, username, password, idUnivoco);
					this.out.writeObject(esito);
				}
				
				else if(inputClient.equals("esisteUtente")) {
					String username = (String) this.in.readObject();
					
					boolean esito = this.swi.esisteUtente(username);
					this.out.writeObject(esito);
				}
				
				else if(inputClient.equals("corrispondenzaId")) {
					String codiceFiscale = (String) this.in.readObject();
					String idUnivoco = (String) this.in.readObject();
					
					boolean esito = this.swi.verificaCorrispondenzaId(codiceFiscale, idUnivoco);
					this.out.writeObject(esito);
				}
				
				else if(inputClient.equals("login")) {
					String username = (String) this.in.readObject();
					String password = (String) this.in.readObject();
					
					boolean esito = this.swi.login(username, password);
					this.out.writeObject(esito);
				}
				
				else if(inputClient.equals("retMyCodiceFiscale")) {
					
					String username = (String) this.in.readObject();
					
					String codiceFiscale = this.swi.retCfUtente(username);
					this.out.writeObject(codiceFiscale);
				}
				
				else if(inputClient.equals("inserisciEventroAvverso")) {
					
					String codiceFiscale = (String) this.in.readObject();
					String evento = (String) this.in.readObject();
					String severita = (String) this.in.readObject();
					String note = (String) this.in.readObject();
					
					int esito = this.swi.inserisciEventoAvverso(codiceFiscale, evento, severita, note);
					this.out.writeObject(esito);
				}
				
				else if(inputClient.equals("MyElencoEA")) {
					
					String username = (String) in.readObject();
					
					List<List<String>> esito = this.swi.retMyElencoEventiAvversi(username);
					this.out.writeObject(esito);
				}
				
				else if(inputClient.equals("InfoCentroConNome")) {
					String nomeCentroVaccinale = (String) this.in.readObject();
					
					List<String> esito = (List<String>) this.swi.infoCentriVaccinaliNome(nomeCentroVaccinale);
					this.out.writeObject(esito);
				}
				
				else if(inputClient.equals("InfoCentroConComuneTipologia")) {
					String comune = (String) this.in.readObject();
					String tipologia = (String) this.in.readObject();
					
					List<List<String>> esito = this.swi.infoCentriVaccinaliCeT(comune, tipologia);
					this.out.writeObject(esito);
				}
				
				else if(inputClient.equals("generaDataset")) {
					this.swi.creazioneDataset();
				}
				
			} catch (ClassNotFoundException | IOException e) {
				System.err.println("THREAD: problemi invio dato: " + e.toString());
				break;
			} catch (SQLException e) {
				System.err.println("THREAD: query non eseguita: " + e.toString());
				break;
			}
		}
		
		
	}
	


}

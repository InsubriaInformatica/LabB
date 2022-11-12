import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.List;

//classe THREAD che svolge task client
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
	
	//ereditato dalla classe thread --> metodo che gestisce le task del client
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

import java.io.*;
import java.net.*;
import java.sql.SQLException;

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
				
			} catch (ClassNotFoundException | IOException e) {
				System.err.println("THREAD: problemi invio dato: " + e.toString());
			} catch (SQLException e) {
				System.err.println("THREAD: query non eseguita: " + e.toString());
			}
		}
		
		
	}
	


}

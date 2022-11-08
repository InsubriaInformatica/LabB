import java.io.*;
import java.net.*;

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
				
				
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	


}

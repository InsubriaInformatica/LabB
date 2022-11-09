import java.io.IOException;
import java.net.*;
import java.util.List;

public class ModelImpl implements ModelInterface{
	
	public static int PORT = 8080;
	
	ViewInterface v;
	SkeletonInterface swi;
	ServerSocket theServerSocket;
	Socket socket;
	

	public ModelImpl(ViewInterface v) {
		this.v = v; //instanzia view per inviare dati da mostrare 
	}
	
	//metodo utile per ACCETTARE ed AVVIARE il server thread che si occuperano di lavorare per il client
	public void avvioServer(Object dati) {
		try {
				
			theServerSocket = new ServerSocket(ModelImpl.PORT); //porta di ascolto 
			System.out.println("Server Started... waiting connection");
				
			while(true) {
				socket = theServerSocket.accept(); //attende connessione --> ritorna oggetto socket quando si connette
				System.out.println("Server: connessione accettata " + socket);
				new ServerWorker(socket, swi); //lancia un server thread che gestisce task
			}
				
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("MODEL: Server non avviato: " + e.toString());
		} 
	}
	
	//chiude il server in modo che nessun client possa connettersi
	public void spegniServer() {
		try {
			
			socket.close(); //chiude connesione
			theServerSocket.close(); //chiuse ascolto server
			System.out.println("MODEL: ho spento server");
			
		} catch (IOException e) {
			System.err.println("MODEL: Il server non è riuscito a chiudere connessione: " + e.toString());
			
		}
	}
	
	
	public void updateModel(Object dati) {
		
		List<String> datiPrelevatidaArgomento = (List) dati; //preleva dati passati dal controller
		
		if(datiPrelevatidaArgomento.get(0).equals("AVVIO SERVER")) {
			List <String> lista = (List) dati;
			swi = new EsecutoreQuery(lista.get(1), lista.get(2), lista.get(3), lista.get(4), lista.get(5));
			avvioServer(null); //avvia il server
			this.v.updateView(dati); //aggiorna view in base all'elaborazione
		}
		
		if(datiPrelevatidaArgomento.get(0).equals("SPEGNI SERVER")) {
			spegniServer();
		}
		
		
	}
}

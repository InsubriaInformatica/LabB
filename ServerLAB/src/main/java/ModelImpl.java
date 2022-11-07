import java.io.IOException;
import java.net.*;
import java.util.List;

public class ModelImpl implements ModelInterface{
	
	public static int PORT = 8080;
	
	ViewInterface v;
	ServerSocket theServerSocket;
	Socket socket;
	

	public ModelImpl(ViewInterface v) {
		this.v = v; //instanzia view per inviare dati da mostrare 
	}
	
	//metodo utile per accettare ed avviare il server thread che si occuperano di lavorare per il client
	public void avvioServer(Object dati) {
		try {
				
			theServerSocket = new ServerSocket(ModelImpl.PORT); //porta di ascolto 
			System.out.println("Server Started");
				
			while(true) {
				socket = theServerSocket.accept(); //attende connessione --> ritorna oggetto socket quando si connette
				System.out.println("Server: connessione accettata " + socket);
				new ServerWorker(socket); //lancia un server thread che gestisce task
			}
				
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("MODEL: Server non avviato: " + e.toString());
		} 
	}

	
	public void updateModel(Object dati) {
		
		List<String> datiPrelevatidaArgomento = (List) dati; //preleva dati passati dal controller
		if(datiPrelevatidaArgomento.get(0).equals("AVVIO SERVER")) {
			avvioServer(null); //avvia il server
		}
		
		this.v.updateView(dati); //aggiorna view in base all'elaborazione
		
	}

	

}

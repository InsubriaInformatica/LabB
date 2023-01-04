//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import java.io.IOException;
import java.net.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Timer;

/**
 * 
 * @author Gabriele Sassi
 *
 */
public class ModelImpl implements ModelInterface {

	public static int PORT = 8080;

	ViewInterface v;
	SkeletonInterface swi;
	ServerSocket theServerSocket;
	Socket socket;

	/**
	 * instanzia view per inviare dati da mostrare
	 * 
	 * @param v view
	 */
	public ModelImpl(ViewInterface v) {
		this.v = v;
	}

	/**
	 * questo metodo serve ad accettare i tentativi di connessione che arrivano.
	 * Successivamente crea un ServerThread per ogni client connesso
	 */
	public void avvioServer(Object dati) throws SQLException {

		try {

			theServerSocket = new ServerSocket(ModelImpl.PORT); // porta di ascolto
			System.out.println("Server Started... waiting connection");
			swi.creazioneTabelle();
			boolean loop = true;

			while (loop) {
				socket = theServerSocket.accept(); // attende connessione --> ritorna oggetto socket quando si connette
				System.out.println("Server: connessione accettata " + socket);
				new ServerWorker(socket, swi); // lancia un server thread che gestisce task
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("MODEL: Server non avviato: " + e.toString());
		}
	}

	/**
	 * metodo richiamato dal controller che aggiorna ed elabora dati da mostrare alla view
	 * @param dati: dati mandati dal controller e presi dalla view
	 */
	public void updateModel(Object dati) throws SQLException {

		List<String> datiPrelevatidaArgomento = (List) dati; // preleva dati passati dal controller

//		this.v.updateView("avvio"); //aggiorna view in base all'elaborazione

		if (datiPrelevatidaArgomento.get(0).equals("AVVIO SERVER")) {
			this.v.updateView("avvio"); // aggiorna view in base all'elaborazione
			List<String> lista = (List) dati;
			swi = new EsecutoreQuery(lista.get(1), lista.get(2), lista.get(3), lista.get(4),
					lista.get(5).toLowerCase());
			avvioServer(null); // avvia il server
		}
	}
}

//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

/**
 * crea la view degli elementi grafici, il model ed il controller per gli eventi
 * @author Qaldo Ademi, Simone Battaglia, Enrico Brullo, Gabriele Sassi
 *
 */
public class ServerMain {

	public static void main(String[] args) {
		ViewInterface v = new ServerGUI(); //crea view --> istanzia elementi grafici
		ModelInterface m = new ModelImpl(v); //crea model passando la view --> tramite updateview manda dati
		Controller c = new Controller(m,v); //crea controller --> per eventi 
	}

}

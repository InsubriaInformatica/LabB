//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

/**
 * Classe main del client
 * @author Qaldo Ademi, Simone Battaglia, Enrico Brullo, Gabriele Sassi
 */
public class ClientMain {

	public static void main(String[] args) {
		
		View v = new ViewImpl();
		Model m = new ModelImpl(v);
		ControllerImpl c = new ControllerImpl(v,m);

	}

}

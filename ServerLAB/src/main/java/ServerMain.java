
public class ServerMain {

	public static void main(String[] args) {
		ViewInterface v = new ViewImpl(); //crea view --> istanzia elementi grafici
		ModelInterface m = new ModelImpl(v); //cea model passando la view --> tramite updateview manda dati
		Controller c = new Controller(m,v); //crea controller --> per eventi 
	}

}

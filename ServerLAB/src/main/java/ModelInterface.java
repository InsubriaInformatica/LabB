// PATTERN MVC --> interfaccia che fornisce elementi necessari all'implementazione
public interface ModelInterface {
	
	public void updateModel(Object dati); //aggiorna il model in base all'evento generato
	
	public void avvioServer(Object dati); //contiene dati per avvio del server

}

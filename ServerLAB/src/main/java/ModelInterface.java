import java.sql.SQLException;

// PATTERN MVC --> interfaccia che fornisce elementi necessari all'implementazione
public interface ModelInterface {
	
	public void updateModel(Object dati) throws SQLException; //aggiorna il model in base all'evento generato
	
	public void avvioServer(Object dati) throws SQLException; //contiene dati per avvio del server
	
	public void spegniServer(); //spegne server

}

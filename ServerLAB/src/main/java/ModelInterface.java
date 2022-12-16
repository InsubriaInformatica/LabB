import java.sql.SQLException;

/**
 *  PATTERN MVC --> interfaccia che fornisce elementi necessari all'implementazione
 * @author Gabriele Sassi
 *
 */
public interface ModelInterface {
	/**
	 * aggiorna il model in base all'evento generato
	 * 
	 * @param dati
	 * @throws SQLException
	 */
	public void updateModel(Object dati) throws SQLException;

	/**
	 * contiene dati per avvio del server
	 * 
	 * @param dati
	 * @throws SQLException
	 */
	public void avvioServer(Object dati) throws SQLException;

}

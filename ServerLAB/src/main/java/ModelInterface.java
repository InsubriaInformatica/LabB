//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

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

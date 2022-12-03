import java.util.List;
import javax.swing.JButton;


/**
 * PATTERN MVC: interfaccia che fornisce gli elementi necessari all'implementazione
 * @author simon
 *
 */
public interface ViewInterface {
	/**
	 * aggiorna i componenti grafici
	 * @param dati
	 */
	public void updateView(Object dati); 
	/**
	 * riferimento al bottone "Avvia Server"
	 */
	public JButton retButtonAvvia(); 
	
	/**
	 * lista contenente le info del server
	 * @return
	 */
	public List<String> txtInfoServer(); 
	

}

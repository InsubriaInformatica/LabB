import java.util.List;
import javax.swing.JButton;

//PATTERN MVC --> interfaccia che fornisce elementi necessari all'implementazione
public interface ViewInterface {
	
	public void updateView(Object dati); //aggiorna i componenti grafici come per il client
	
	public JButton retButtonAvvia(); //riferimento al bottone di avvio del server
	
	public JButton retButtonSpegni(); //riferimento al bottone di chiusura del server
	
	public List<String> txtInfoServer(); //lista che contiene info del server prese da text-field
	

}

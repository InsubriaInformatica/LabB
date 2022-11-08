import java.net.InetAddress;
import java.net.UnknownHostException;

//gestisce la logica di funzionamento dell'applicazione
public class ModelImpl implements Model{
	
	private View v;
	private ServerInterface proxy; //chiamata locale 
	private boolean flag;

	//riferimento a view dove model dovrà operare, instanzia riferimento proxy server locale dove andrà ad operare
	public ModelImpl(View v) {
		
		try {
			
			this.v = v; //instanzia view
			this.proxy = new Proxy(InetAddress.getByName(null), 8080); //local host e porta
			
		} catch (UnknownHostException e) {
			System.err.println("CLIENT MODEL: host sconosciuto " + e.toString());
		}
		
	}
	
	public void updateModel(String source, Object dati) {
		
		String button = source;
		Object datiPerModel = null;
		this.flag = false;
		
		this.v.updateView(button, datiPerModel, this.flag); //aggiorna view in base all'elaborazione
	}
	
	

}

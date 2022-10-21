
//gestisce la logica di funzionamento dell'applicazione
public class ModelImpl implements Model{
	
	private View v;
	private boolean flag;

	//riferimento a view dove model dovrà operare 
	public ModelImpl(View v) {
		this.v = v; //instanzia view
	}
	
	public void updateModel(String source, Object dati) {
		
		String button = source;
		Object datiPerModel = null;
		this.flag = false;
		
		this.v.updateView(button, datiPerModel, this.flag); //aggiorna view in base all'elaborazione
	}
	
	

}

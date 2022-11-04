
public class ModelImpl implements ModelInterface{
	
	ViewInterface v;

	public ModelImpl(ViewInterface v) {
		this.v = v;
	}

	@Override
	public void updateModel(Object dati) {
		this.v.updateView(dati); //aggiorna view in base all'elaborazione
	}

	@Override
	public void avvioModel(Object dati) {
		
		
	}

}

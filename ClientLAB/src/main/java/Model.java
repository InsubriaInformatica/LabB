
/**
 * PATTERN MVC --> questa interfaccia fornisce i prototipi necessari al funzionamento del model nell'applicazione
 * @author Gabriele Sassi
 *
 */
public interface Model {
	
	//source --> evento di origine
	//dati --> dati mandati dal controller e presi dalla view
	public void updateModel(String source, Object dati); //metodo richiamato dal controller che aggiorna ed elabora dati da mostrare alla view

}

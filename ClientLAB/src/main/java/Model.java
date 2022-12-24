/**
 * PATTERN MVC --> questa interfaccia fornisce i prototipi necessari al funzionamento del model nell'applicazione
 * @author Gabriele Sassi
 * 
 */
public interface Model {
	/**
	 * Metodo richiamato dal controller che aggiorna ed elabora dati da mostrare alla view
	 * @param source: evento di origine
	 * @param dati: dati mandati dal controller e presi dalla view
	 */
	public void updateModel(String source, Object dati);

}

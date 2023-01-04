//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import java.util.List;
import javax.swing.*;

/**
 * PATTERN MVC --> questa interfaccia fornisce i prototipi necessari al funzionamento della view nell'applicazione
 * @author Gabriele Sassi
 *
 */
public interface View {
	
	/**
	 * Metodo che riceve i dati del model e aggiorna in base al componente che ha generato l'evento
	 * 
	 * @param source: contiene il riferimento al componente che ha generato l'evento
	 * @param dati: oggetto che contiene dati con cui aggiornare i componenti della view
	 * @param flagErrore: valore booleano, indica se ci sono errori oppure no
	 */
	public void updateView(Object source, Object dati, boolean flagErrore);
	/**
	 * Metodo che restituisce array contenente i riferimenti al Jbutton del tipo di utente selezionato (x ogni utente)
	 * @return
	 */
	public JButton[] getSceltaTipoUtente();
	
	/**
	 * metodo che fa riferimento al bottone "indietro"
	 * @return
	 */
	public JButton getBack();
	
	/**
	 * Metodo che restituisce la stringa che identifica la view mostrata sullo schermo
	 * @return
	 */
	public String getViewAttuale();
	
	/**
	 * Metodo che restituisce button per aprire finestra di ip
	 * @return
	 */
	public JButton getButtonImpostazioni();
	
	/**
	 * Metodo che richiama il bottone per cambiare IP
	 * @return
	 */
	public JButton getButtonCambioIP();
	
	/**
	 * Metodo che recupera IP inserito dalla textView
	 * @return
	 */
	public String getNuovoIP();
	
	/**
	 * Metodo che richiama il bottone per generare dataset
	 * @return
	 */
	public JButton getButtonDataset();
	
	//OPERATORE
	
	/**
	 * Metodo che serve al controller per aggiungersi come action listener --> restituisce un array di button con le funzionalità principali dell'operatore
	 * @return
	 */
	public JButton[] getBottoniFunzionalitaOperatore();
	
	/**
	 * Metodo che restituisce il riferimento al JButton per confermare l'inserimento di un nuovo centro
	 * @return
	 */
	public JButton getBottoneRegistraNuovoCentro();
	
	/**
	 * Metodo che restituisce la lista di stringhe fornite durante la registrazione di un nuovo centro
	 * @return
	 */
	public List<String> getDatiRegistraNuovoCentro();
	
	/**
	 * Metodo che restituisce il riferimento al JButton per confermare l'inserimento di un nuovo vaccinato
	 * @return
	 */
	public JButton getBottoneRegistraNuovoVaccinato();
	
	/**
	 * Metodo che restituisce la lista di stringhe fornite durante la registrazione di un nuovo vaccinato
	 * @return
	 */
	public List<String> getDatiRegistraNuovoVaccinato();
	
	/**
	 * Metodo che restituisce il riferimento al Jbutton per cercare info dei centri vaccinali	
	 * @return
	 */
	public JButton[] getCercaInfoCentriVaccinali();
	
	/**
	 * Metodo che restituisce il riferimento alla JComboBox per la scelta del centro di cui ottenere le informazioni
	 * @return
	 */
	public JComboBox boxSceltaCentroGetInfo();
	
	/**
	 * Metodo che restituisce la stringa nomeCentro inserita per effettuare la ricerca di informazioni
	 * @return
	 */
	public String getDatiNomeCentroPerConsultareInfo();
	
	/**
	 * Metodo che restituisce una lista contenente il comune e la tipologia per effettuare la ricerca per comune/tipologia
	 * @return
	 */
	public List<String> getDatiComuneTipologiaPerConsultareInfo();
	
	//EVENTI AVVERSI
	
	/**
	 * Metodo che restituisce il riferimento al JButton per confermare l'aggiunta di un evento avverso
	 * @return
	 */
	public JButton getBottonePerInserireEventoAvverso();
	
	/**
	 * Metodo che restituisce una lista contenente i dati forniti nel momento di aggiunta di un evento avverso
	 * @return
	 */
	public List<String> getDatiInserisciEventoAvverso();
	
	//CITTADINO
	
	/**
	 * Metodo che serve al controller per aggiungersi come action listener --> restituisce un array di button con le funzionalità principali del cittadino
	 * @return
	 */
	public JButton[] getBottoniFunzionalitaCittadino();
	
	/**
	 * Metodo che restituisce il riferimento al JButton per confermare la registrazione
	 * @return
	 */
	public JButton getBottoneRegistrati();
	
	/**
	 * Metodo che restituisce una lista contenente i dati forniti per la registrazione
	 * @return
	 */
	public List<String> getDatiPerRegistrazione();
	
	/**
	 * Metodo che restituisce il riferimento al JButton per confermare il login
	 * @return
	 */
	public JButton getBottonePerLogin();
	
	/**
	 * Metodo che restituisce una lista contenente username e password per effettuare il login 
	 * @return
	 */
	public List<String> getDatiPerLogin();
	
	/**
	 * Metodo che restituisce il riferimento al JButton per registrarsi dalla schermata di login
	 * @return
	 */
	public JButton getBottoneRegistrazioneDaLogin();
	
}

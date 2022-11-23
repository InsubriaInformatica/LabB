import java.util.List;
import javax.swing.*;

//PATTERN MVC --> questa interfaccia fornisce i prototipi necessari al funzionamento della view nell'applicazione
public interface View {
	
	//source --> contiene il riferimento al componente che ha generato l'evento
	//dati --> oggetto che contiene dati con cui aggiornare i componenti della view
	//flagErrore --> valore booleano, indica se ci sono errori oppure no
	public void updateView(Object source, Object dati, boolean flagErrore); //riceve i dati del model e aggiorna in base al componente che ha generato l'evento
	
	public JButton[] getSceltaTipoUtente(); //restituisce array contenente i riferimenti al Jbutton del tipo di utente selezionato (x ogni utente)
	
	public JButton getBack(); //riferimento al bottone "indietro"
	
	public String getViewAttuale(); //restituisce la stringa che identifica la view mostrata sullo schermo
	
	public JButton getButtonImpostazioni(); //restituisce button per aprire finestra di ip
	
	public JButton getButtonCambioIP(); //bottone per cambiare IP
	
	public String getNuovoIP(); //recupera IP inserito dalla textView
	
	public JButton getButtonDataset(); //bottone per generare dataset
	
	//OPERATORE
	public JButton[] getBottoniFunzionalitaOperatore(); //serve al controller per aggiungersi come action listener --> restituisce un array di button con le funzionalità principali dell'operatore
	
	public JButton getBottoneRegistraNuovoCentro(); //restituisce il riferimento al JButton per confermare l'inserimento di un nuovo centro
	
	public List<String> getDatiRegistraNuovoCentro(); //restituisce la lista di stringhe fornite durante la registrazione di un nuovo centro
	
	public JButton getBottoneRegistraNuovoVaccinato(); //restituisce il riferimento al JButton per confermare l'inserimento di un nuovo vaccinato
	
	public List<String> getDatiRegistraNuovoVaccinato(); //restituisce la lista di stringhe fornite durante la registrazione di un nuovo vaccinato
	
	public JButton[] getCercaInfoCentriVaccinali();//restituisce il riferimento al Jbutton per cercare info dei centri vaccinali	
	
	public JComboBox boxSceltaCentroGetInfo(); //restituisce il riferimento alla JComboBox per la scelta del centro di cui ottenere le informazioni
	
	public String getDatiNomeCentroPerConsultareInfo(); //restituisce la stringa nomeCentro inserita per effettuare la ricerca di informazioni
	
	public List<String> getDatiComuneTipologiaPerConsultareInfo(); //restituisce una lista contenente il comune e la tipologia per effettuare la ricerca per comune/tipologia
	
	//EVENTI AVVERSI
	public JButton getBottonePerInserireEventoAvverso(); //restituisce il riferimento al JButton per confermare l'aggiunta di un evento avverso
	
	public List<String> getDatiInserisciEventoAvverso(); //restituisce una lista contenente i dati forniti nel momento di aggiunta di un evento avverso
	
	//CITTADINO
	public JButton[] getBottoniFunzionalitaCittadino(); //serve al controller per aggiungersi come action listener --> restituisce un array di button con le funzionalità principali del cittadino
	
	public JButton getBottoneRegistrati(); //restituisce il riferimento al JButton per confermare la registrazione
	
	public List<String> getDatiPerRegistrazione(); //restituisce una lista contenente i dati forniti per la registrazione
	
	public JButton getBottonePerLogin(); // restituisce il riferimento al JButton per confermare il login
	
	public List<String> getDatiPerLogin(); //restituisce una lista contenente username e password per effettuare il login 
	
	public JButton getBottoneRegistrazioneDaLogin(); //restituisce il riferimento al JButton per registrarsi dalla schermata di login
	
}

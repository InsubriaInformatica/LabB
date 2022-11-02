import java.util.List;
import javax.swing.*;

//PATTERN MVC --> questa interfaccia fornisce i prototipi necessari al funzionamento della view nell'applicazione
public interface View {
	
	//source --> contiene il riferimento al componente che ha generato l'evento
	//dati --> oggetto che contiene dati con cui aggiornare i componenti della view
	//flagErrore --> valore booleano, indica se ci sono errori oppure no
	public void updateView(Object source, Object dati, boolean flagErrore); //riceve i dati del model e aggiorna in base al componente che ha generato l'evento
	
	
	
	
	public JButton getBack(); //riferimento al bottone "indietro"
	
	public JButton[] getSceltaTipoUtente(); //restituisce array contenente i riferimenti al Jbutton del tipo di utente selezionato (x ogni utente)
	
	
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
	public JButton[] getBottonePerEventiAvversi(); //restituisce un array di button che contengono riferimenti per la gestione degli eventi avversi
	
	public JButton getBottonePerInserireEventoAvverso(); //restituisce il riferimento al JButton per confermare l'aggiunta di un evento avverso
	
	public JButton getBottonePerAggiornareEventoAvverso(); //restituisce il riferimento al JButton per confermare l'aggiornamento di un evento avverso
	
	public JButton getJButtonConfermaEliminareEventoAvverso(); //restituisce un riferimento di button per confermare eliminazione evento avverso
	
	public JComboBox getEventoDaAggiornare(); //riferimento alla comboBox per la scelta dell'evento da aggiornare
	
	public String getDatiEliminaEventoAvverso(); //restituisce la stringa fornita per l'eliminazione di un evento avverso
	
	public List<String> getDatiInserisciEventoAvverso(); //restituisce una lista contenente i dati forniti nel momento di aggiunta di un evento avverso
	
	public List<String> getDatiAggiornaEventoAvverso(); //restituisce una lista contenente i dati forniti nel momento di aggiornamento di un evento avverso
	
	
	//CITTADINO
	public JButton[] getBottoniFunzionalitaCittadino(); //serve al controller per aggiungersi come action listener --> restituisce un array di button con le funzionalità principali del cittadino
	
	public JButton getBottoneRegistrazione(); //restituisce il riferimento al JButton per confermare la registrazione
	
	public JButton getBottonePerLogin(); // restituisce il riferimento al JButton per confermare il login
	
	public JButton getBottoneRegistrazioneDaLogin(); //restituisce il riferimento al JButton per registrarsi dalla schermata di login
	
	public JButton getBottoneRecuperoIdVaccinazione(); //restituisce il riferimento al JButton per la funzionalità di recuperare id vaccinazione
	
	public JButton getBottoneConfermaRecuperoIdVaccinazione(); //restituisce il riferimento al JButton per confermare l'operazione di recuperare id vaccinazione
	
	public JTextField getTextFieldCodiceFiscale(); //restituisce il riferimento al JTextField per inserire il codice fiscale in fase di registrazione
	
	
	public List<String> getDatiPerLogin(); //restituisce una lista contenente username e password per effettuare il login 
	
	public List<String> getDatiPerRegistrazione(); //restituisce una lista contenente i dati forniti per la registrazione

	
	
	public String getViewAttuale(); //restituisce la stringa che identifica la view mostrata sullo schermo
	public String datiEventoDaAggiornare(); //restituisce la stringa dell'evento da aggiornare selezionato
	public String getCfPerRecuperoIdVacc(); //restituisce la stringa fornita per recuperare id vaccinazione
}

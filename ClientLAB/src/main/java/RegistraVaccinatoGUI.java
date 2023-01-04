//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import javax.swing.*;
import javax.swing.border.Border;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.util.Date;

/**
 * 
 * @author Enrico Brullo
 *
 */
public class RegistraVaccinatoGUI {
	
	private JPanel intestazione; //intestazione comune
	
	private JPanel contenitorePrincipale;
	
	private JPanel panelTitolo;
	private JLabel labelTitolo;
	
	private JPanel panelVuoto;
	private JLabel labelVuoto;

	private JPanel panelSceltacentro;
	private JLabel labelNomeCentro;
	private JComboBox<String> nomeCentroVaccinale;
	
	private JPanel panelNomeVaccinato;
	private JLabel labelNomeVaccinato;
	private JTextField textFieldNomeVaccinato;
	
	private JPanel panelCognomeVaccinato;
	private JLabel labelCognomeVaccinato;
	private JTextField textFieldCognomeVaccinato;
	
	private JPanel panelCFVaccinato;
	private JLabel labelCFVaccinato;
	private JTextField textFieldCFVaccinato;
	
	private JPanel panelData;
	private JLabel labelData;
	private JDateChooser dataSomministrazione;
	
	private JPanel panelVaccino;
	private JLabel labelVaccino;
	private JComboBox<String> nomeVaccino;
	
	private JPanel panelNdosi;
	private JLabel labelNdosi;
	private JRadioButton radioButtonDoseN1;
    private JRadioButton radioButtonDoseN2;
    private JRadioButton radioButtonDoseN3;
    private ButtonGroup buttonGroupDosi;
    
    private JPanel panelVuoto1;
	private JLabel labelVuoto1;
	
    private JPanel panelBottone;
    private JButton buttonRegistraVacc;
	
	/**
	 * Costruttore della classe
	 * @param altezza
	 * @param larghezza
	 * @param intestazione
	 */
	public RegistraVaccinatoGUI(int altezza, int larghezza, JPanel intestazione) {
		
		this.intestazione = intestazione;
		
		Border bordo = BorderFactory.createLineBorder(Colori.light_grey, 1); //crea bordo
		
		//TITOLO
		this.panelTitolo = new JPanel();
		this.panelTitolo.setLayout(new GridLayout(1,1));
		this.panelTitolo.setBackground(Colori.purple);
		this.labelTitolo = new JLabel("REGISTRA VACCINATO:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		this.labelTitolo.setForeground(Colori.arancione);
		this.panelTitolo.add(this.labelTitolo);
		this.panelTitolo.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//PANEL PER SPAZIO
		this.panelVuoto = new JPanel();
		this.panelVuoto.setLayout(new GridLayout(1,1));
		this.panelVuoto.setBackground(Colori.purple);
		this.labelVuoto = new JLabel();
		this.labelVuoto.setHorizontalAlignment(JLabel.CENTER);
		this.labelVuoto.setVerticalAlignment(JLabel.CENTER);
		this.labelVuoto.setBackground(Colori.purple);
		this.panelVuoto.add(labelVuoto);
		this.panelVuoto.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//LISTA CENTRI REGISTRATI --> deve prenderli dal database e inserirli  nella combobox
		this.panelSceltacentro = new JPanel();
		this.panelSceltacentro.setLayout(new GridLayout(1,2));
		this.panelSceltacentro.setBackground(Colori.purple);
		this.labelNomeCentro = new JLabel("Seleziona Centro:");
		this.labelNomeCentro.setForeground(Colori.light_grey);
		this.nomeCentroVaccinale = new JComboBox<String>();
		this.nomeCentroVaccinale.setPreferredSize(new Dimension(600, 25));
		this.panelSceltacentro.add(this.labelNomeCentro);
		this.panelSceltacentro.add(this.nomeCentroVaccinale);
		this.panelSceltacentro.setPreferredSize(new Dimension(600, 25));
		
		//NOME VACCINATO
		this.panelNomeVaccinato = new JPanel();
		this.panelNomeVaccinato.setLayout(new GridLayout(1,2));
		this.panelNomeVaccinato.setBackground(Colori.purple);
		this.labelNomeVaccinato = new JLabel("Nome:");
		this.labelNomeVaccinato.setForeground(Colori.light_grey);
		this.textFieldNomeVaccinato = new JTextField("", 20); 
		this.panelNomeVaccinato.add(this.labelNomeVaccinato);
		this.panelNomeVaccinato.add(this.textFieldNomeVaccinato);
		this.panelNomeVaccinato.setPreferredSize(new Dimension(600, 25));
		
		//COGNOME VACCINATO
		this.panelCognomeVaccinato = new JPanel();
		this.panelCognomeVaccinato.setLayout(new GridLayout(1,2));
		this.panelCognomeVaccinato.setBackground(Colori.purple);
		this.labelCognomeVaccinato = new JLabel("Cognome:");
		this.labelCognomeVaccinato.setForeground(Colori.light_grey);
		this.textFieldCognomeVaccinato = new JTextField("", 20); 
		this.panelCognomeVaccinato.add(this.labelCognomeVaccinato);
		this.panelCognomeVaccinato.add(this.textFieldCognomeVaccinato);
		this.panelCognomeVaccinato.setPreferredSize(new Dimension(600, 25));
		
		//CODICE FISCALE 
		this.panelCFVaccinato = new JPanel();
		this.panelCFVaccinato.setLayout(new GridLayout(1,2));
		this.panelCFVaccinato.setBackground(Colori.purple);
		this.labelCFVaccinato = new JLabel("Codice Fiscale:");
		this.labelCFVaccinato.setForeground(Colori.light_grey);
		this.textFieldCFVaccinato = new JTextField("", 20); 
		this.panelCFVaccinato.add(this.labelCFVaccinato);
		this.panelCFVaccinato.add(this.textFieldCFVaccinato);
		this.panelCFVaccinato.setPreferredSize(new Dimension(600, 25));
		
		//DATA SOMMINISTRAZIONE
		this.panelData = new JPanel();
		this.panelData.setLayout(new GridLayout(1,2));
		this.panelData.setBackground(Colori.purple);
		this.labelData = new JLabel("Data somministrazione:");
		this.labelData.setForeground(Colori.light_grey);
		this.dataSomministrazione = new JDateChooser();
		this.dataSomministrazione.setPreferredSize(new Dimension(600, 25));
		this.dataSomministrazione.setDateFormatString("dd/MM/yyyy");
		this.dataSomministrazione.setDate(new Date());
		this.dataSomministrazione.setBackground(Colori.purple);
		this.panelData.add(this.labelData);
		this.panelData.add(this.dataSomministrazione);
		this.panelData.setPreferredSize(new Dimension(600, 25));
		
		
		//TIPO DI VACCINO
		this.panelVaccino = new JPanel();
		this.panelVaccino.setLayout(new GridLayout(1,2));
		this.panelVaccino.setBackground(Colori.purple);
		this.labelVaccino = new JLabel("Vaccino somministrato:");
		this.labelVaccino.setForeground(Colori.light_grey);
		this.labelVaccino.setBackground(Colori.purple);
		this.nomeVaccino = new JComboBox<String>();
		this.nomeVaccino.addItem("AstraZeneca");
		this.nomeVaccino.addItem("Pfizer");
		this.nomeVaccino.addItem("Moderna");
		this.nomeVaccino.addItem("J&J");
		this.nomeVaccino.setPreferredSize(new Dimension(600, 25));
		this.panelVaccino.add(this.labelVaccino);
		this.panelVaccino.add(this.nomeVaccino);
		this.panelVaccino.setPreferredSize(new Dimension(600, 25));
		
		//NUMERO DOSI
		this.panelNdosi = new JPanel();
		this.panelNdosi.setLayout(new GridLayout(1,3));
		this.panelNdosi.setPreferredSize(new Dimension(600, 25));
		this.panelNdosi.setBackground(Colori.purple);
		this.labelNdosi = new JLabel("N.Dose:");
		this.labelNdosi.setForeground(Colori.light_grey);
		
		this.radioButtonDoseN1 = new JRadioButton();
		this.radioButtonDoseN1.setText("Prima");
		this.radioButtonDoseN1.setForeground(Colori.light_grey);
		this.radioButtonDoseN1.setBackground(Colori.purple);
		this.radioButtonDoseN2 = new JRadioButton();
		this.radioButtonDoseN2.setText("Seconda");
		this.radioButtonDoseN2.setForeground(Colori.light_grey);
		this.radioButtonDoseN2.setBackground(Colori.purple);
		this.radioButtonDoseN3 = new JRadioButton();
		this.radioButtonDoseN3.setText("Terza o Successiva");
		this.radioButtonDoseN3.setForeground(Colori.light_grey);
		this.radioButtonDoseN3.setBackground(Colori.purple);
		this.buttonGroupDosi = new ButtonGroup();
        
        this.buttonGroupDosi.add(radioButtonDoseN1);
        this.buttonGroupDosi.add(radioButtonDoseN2);
        this.buttonGroupDosi.add(radioButtonDoseN3);
        this.radioButtonDoseN1.setSelected(true);
        
        this.panelNdosi.add(labelNdosi);
        this.panelNdosi.add(radioButtonDoseN1);
        this.panelNdosi.add(radioButtonDoseN2);
        this.panelNdosi.add(radioButtonDoseN3);
        
        //PANEL PER SPAZIO
        this.panelVuoto1 = new JPanel();
        this.panelVuoto1.setLayout(new GridLayout(1,1));
        this.panelVuoto1.setBackground(Colori.purple);
        this.labelVuoto1 = new JLabel();
        this.labelVuoto1.setHorizontalAlignment(JLabel.CENTER);
        this.labelVuoto1.setVerticalAlignment(JLabel.CENTER);
        this.labelVuoto1.setBackground(Colori.purple);
        this.panelVuoto1.add(labelVuoto1);
        this.panelVuoto1.setPreferredSize(new Dimension(700, 25)); //larghezza, altezza
     
        //BOTTONE REGISTRA
        this.panelBottone = new JPanel();
        this.panelBottone.setBackground(Colori.purple);
		this.buttonRegistraVacc = new JButton("REGISTRA VACCINATO");
		this.buttonRegistraVacc.setName("REGISTRA VACCINATO");
		this.buttonRegistraVacc.setBackground(Colori.arancione);
		this.buttonRegistraVacc.setForeground(Colori.light_grey);
		this.buttonRegistraVacc.setBorder(bordo);
		this.panelBottone.setPreferredSize(new Dimension(500, 60));
		this.buttonRegistraVacc.setPreferredSize(new Dimension(200, 50)); 
		this.panelBottone.add(this.buttonRegistraVacc);
		
		//INSERIMENTO NEL PANEL PRINCIPALE
		this.contenitorePrincipale = new JPanel();
		this.contenitorePrincipale.setBackground(Colori.purple);
		this.contenitorePrincipale.add(this.panelTitolo);
		this.contenitorePrincipale.add(panelVuoto);
		this.contenitorePrincipale.add(this.panelSceltacentro);
		this.contenitorePrincipale.add(this.panelNomeVaccinato);
		this.contenitorePrincipale.add(this.panelCognomeVaccinato);
		this.contenitorePrincipale.add(this.panelCFVaccinato);
		this.contenitorePrincipale.add(this.panelData);
		this.contenitorePrincipale.add(this.panelVaccino);
		this.contenitorePrincipale.add(this.panelNdosi);
		this.contenitorePrincipale.add(panelVuoto1);
		this.contenitorePrincipale.add(this.panelBottone);
		
		
	}
	
	
	/**
	 * Metodo che ritorna intestazione della pagina
	 * @return
	 */
	public JPanel retIntestazione() {
		return this.intestazione;
	}

	/**
	 * Metodo che ritorna contenitore elementi
	 * @return
	 */
	public JPanel retContenitore() {
		return this.contenitorePrincipale;
	}
	
	/**
	 * Metodo che rimuove centri dalla combobox
	 */
	public void resetComboBox() {
		this.nomeCentroVaccinale.removeAllItems();
	}
	
	public void pulisciView() {
		this.textFieldNomeVaccinato.setText("");
		this.textFieldCognomeVaccinato.setText("");
		this.textFieldCFVaccinato.setText("");
		this.nomeVaccino.setSelectedIndex(0);
	}
	
	
	/**
	 * Metodo che aggiunge il centro vaccinale alla combo box
	 * @param centro
	 */
	public void aggiungiCentroComboBox(String centro) {
		this.nomeCentroVaccinale.addItem(centro);
	}
	
	/**
	 * Metodo che ritorna il centro vaccinale selezionato nella combo box
	 * @return
	 */
	public Object retNomeCentro() {
		return this.nomeCentroVaccinale.getSelectedItem();
	}
	
	
	/**
	 * Metodo che rimozione centri vaccinali da comboBox
	 */
	public void rimuoviCentroComboBox() {
		this.nomeCentroVaccinale.removeAllItems();
	}
	
	/**
	 * Metodo che ritorna il nome del vaccinato
	 * @return
	 */
	public String retNomeVaccinato() {
		return this.textFieldNomeVaccinato.getText();
	}
	
	/**
	 * Metodo che ritorna il cognome del vaccinato
	 * @return
	 */
	public String retCognomeVaccinato() {
		return this.textFieldCognomeVaccinato.getText();
	}
	
	/**
	 * Metodo che ritorna CF vaccinato
	 * @return
	 */
	public String retCFVaccinato() {
		return this.textFieldCFVaccinato.getText();
	}
	
	/**
	 * Metodo che ritorna data somministrazione vaccino
	 * @return
	 */
	public Date retDataVaccinazione() {
		return this.dataSomministrazione.getDate();
	}
	
	/**
	 * Metodo che ritorna vaccino selezionato
	 * @return
	 */
	public Object retVaccinoComboBox() {
		return this.nomeVaccino.getSelectedItem();
	}
	
	/**
	 * Metodo che ritona la dose selezionata nei radiobutton
	 * @return
	 */
	public String retNdose() {
		
		String dose= " ";
		
		if(radioButtonDoseN1.isSelected()) {
			dose = "Prima";
		}
		
		else if(radioButtonDoseN2.isSelected()) {
			dose = "Seconda";
		}
		
		else if(radioButtonDoseN3.isSelected() ){
			dose = "Terza o Successiva";
		}
		
		return dose;
	}
	
	/**
	 * Metodo che ritorna il bottone per registrare vaccinato
	 * @return
	 */
	public JButton retButtonRegistraVaccinato() {
		return this.buttonRegistraVacc;
	}
	
	
	

}

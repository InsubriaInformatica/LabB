import javax.swing.*;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.util.Date;

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
	
    private JPanel panelBottone;
    private JButton buttonRegistraVacc;
	
	
	public RegistraVaccinatoGUI(int altezza, int larghezza, JPanel intestazione) {
		
		this.intestazione = intestazione;
		
		//TITOLO
		this.panelTitolo = new JPanel();
		this.panelTitolo.setLayout(new GridLayout(1,1));
		this.labelTitolo = new JLabel("REGISTRA VACCINATO:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		this.panelTitolo.add(this.labelTitolo);
		this.panelTitolo.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//PANEL PER SPAZIO
		this.panelVuoto = new JPanel();
		this.panelVuoto.setLayout(new GridLayout(1,1));
		this.labelVuoto = new JLabel();
		this.labelVuoto.setHorizontalAlignment(JLabel.CENTER);
		this.labelVuoto.setVerticalAlignment(JLabel.CENTER);
		this.panelVuoto.add(labelVuoto);
		this.panelVuoto.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//LISTA CENTRI REGISTRATI --> deve prenderli dal database e inserirli  nella combobox
		this.panelSceltacentro = new JPanel();
		this.panelSceltacentro.setLayout(new GridLayout(1,2));
		this.labelNomeCentro = new JLabel("Seleziona Centro:");
		this.nomeCentroVaccinale = new JComboBox<String>();
		this.nomeCentroVaccinale.setPreferredSize(new Dimension(600, 25));
		this.panelSceltacentro.add(this.labelNomeCentro);
		this.panelSceltacentro.add(this.nomeCentroVaccinale);
		this.panelSceltacentro.setPreferredSize(new Dimension(600, 25));
		
		//NOME VACCINATO
		this.panelNomeVaccinato = new JPanel();
		this.panelNomeVaccinato.setLayout(new GridLayout(1,2));
		this.labelNomeVaccinato = new JLabel("Nome:");
		this.textFieldNomeVaccinato = new JTextField("", 20); 
		this.panelNomeVaccinato.add(this.labelNomeVaccinato);
		this.panelNomeVaccinato.add(this.textFieldNomeVaccinato);
		this.panelNomeVaccinato.setPreferredSize(new Dimension(600, 25));
		
		//COGNOME VACCINATO
		this.panelCognomeVaccinato = new JPanel();
		this.panelCognomeVaccinato.setLayout(new GridLayout(1,2));
		this.labelCognomeVaccinato = new JLabel("Cognome:");
		this.textFieldCognomeVaccinato = new JTextField("", 20); 
		this.panelCognomeVaccinato.add(this.labelCognomeVaccinato);
		this.panelCognomeVaccinato.add(this.textFieldCognomeVaccinato);
		this.panelCognomeVaccinato.setPreferredSize(new Dimension(600, 25));
		
		//CODICE FISCALE 
		this.panelCFVaccinato = new JPanel();
		this.panelCFVaccinato.setLayout(new GridLayout(1,2));
		this.labelCFVaccinato = new JLabel("Codice Fiscale:");
		this.textFieldCFVaccinato = new JTextField("", 20); 
		this.panelCFVaccinato.add(this.labelCFVaccinato);
		this.panelCFVaccinato.add(this.textFieldCFVaccinato);
		this.panelCFVaccinato.setPreferredSize(new Dimension(600, 25));
		
		//DATA SOMMINISTRAZIONE
		this.panelData = new JPanel();
		this.panelData.setLayout(new GridLayout(1,2));
		this.labelData = new JLabel("Data somministrazione:");
		this.dataSomministrazione = new JDateChooser();
		this.dataSomministrazione.setPreferredSize(new Dimension(600, 25));
		this.dataSomministrazione.setDateFormatString("dd/MM/yyyy");
		this.dataSomministrazione.setDate(new Date());
		this.panelData.add(this.labelData);
		this.panelData.add(this.dataSomministrazione);
		this.panelData.setPreferredSize(new Dimension(600, 25));
		
		
		//TIPO DI VACCINO
		this.panelVaccino = new JPanel();
		this.panelVaccino.setLayout(new GridLayout(1,2));
		this.labelVaccino = new JLabel("Vaccino somministrato:");
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
		this.labelNdosi = new JLabel("N.Dose");
		
		this.radioButtonDoseN1 = new JRadioButton();
		this.radioButtonDoseN1.setText("Prima");
		this.radioButtonDoseN2 = new JRadioButton();
		this.radioButtonDoseN2.setText("Seconda");
		this.radioButtonDoseN3 = new JRadioButton();
		this.radioButtonDoseN3.setText("Terza o Successiva");
		this.buttonGroupDosi = new ButtonGroup();
        
        this.buttonGroupDosi.add(radioButtonDoseN1);
        this.buttonGroupDosi.add(radioButtonDoseN2);
        this.buttonGroupDosi.add(radioButtonDoseN3);
        this.radioButtonDoseN1.setSelected(true);
        
        this.panelNdosi.add(labelNdosi);
        this.panelNdosi.add(radioButtonDoseN1);
        this.panelNdosi.add(radioButtonDoseN2);
        this.panelNdosi.add(radioButtonDoseN3);
        
        //BOTTONE REGISTRA
        this.panelBottone = new JPanel();
		this.buttonRegistraVacc = new JButton("REGISTRA VACCINATO");
		this.buttonRegistraVacc.setName("REGISTRA VACCINATO");
		this.panelBottone.setPreferredSize(new Dimension(500, 60));
		this.buttonRegistraVacc.setPreferredSize(new Dimension(200, 50)); 
		this.panelBottone.add(this.buttonRegistraVacc);
		
		//INSERIMENTO NEL PANEL PRINCIPALE
		this.contenitorePrincipale = new JPanel();
		this.contenitorePrincipale.add(this.panelTitolo);
		this.contenitorePrincipale.add(panelVuoto);
		this.contenitorePrincipale.add(this.panelSceltacentro);
		this.contenitorePrincipale.add(this.panelNomeVaccinato);
		this.contenitorePrincipale.add(this.panelCognomeVaccinato);
		this.contenitorePrincipale.add(this.panelCFVaccinato);
		this.contenitorePrincipale.add(this.panelData);
		this.contenitorePrincipale.add(this.panelVaccino);
		this.contenitorePrincipale.add(this.panelNdosi);
		this.contenitorePrincipale.add(this.panelBottone);
		
		
	}
	
	
	//ritorna intestazione della pagina
	public JPanel retIntestazione() {
		return this.intestazione;
	}

	//ritorna contenitore elementi
	public JPanel retContenitore() {
		return this.contenitorePrincipale;
	}
	
	public void pulisciView() {
		this.textFieldNomeVaccinato.setText("");
		this.textFieldCognomeVaccinato.setText("");
		this.textFieldCFVaccinato.setText("");
		this.nomeVaccino.setSelectedIndex(0);
	}
	
	
	//aggiunge il centro vaccinale alla combo box
	public void aggiungiCentroComboBox(String centro) {
		this.nomeCentroVaccinale.addItem(centro);
	}
	
	//ritorna il centro vaccinale selezionato nella combo box
	public Object retNomeCentro() {
		return this.nomeCentroVaccinale.getSelectedItem();
	}
	
	
	//rimozione centri vaccinali da comboBox
	public void rimuoviCentroComboBox() {
		this.nomeCentroVaccinale.removeAllItems();
	}
	
	//ritorna il nome del vaccinato
	public String retNomeVaccinato() {
		return this.textFieldNomeVaccinato.getText();
	}
	
	//ritorna il cognome del vaccinato
	public String retCognomeVaccinato() {
		return this.textFieldCognomeVaccinato.getText();
	}
	
	//ritorna CF vaccinato
	public String retCFVaccinato() {
		return this.textFieldCFVaccinato.getText();
	}
	
	//ritorna data somministrazione vaccino
	public Date retDataVaccinazione() {
		return this.dataSomministrazione.getDate();
	}
	
	//ritorna vaccino selezionato
	public Object retVaccinoComboBox() {
		return this.nomeVaccino.getSelectedItem();
	}
	
	//ritona la dose selezionato
	public Object retNdose() {
		return this.buttonGroupDosi.getSelection();
	}
	
	//ritorna il bottone per registrare vaccinato
	public JButton retButtonRegistraVaccinato() {
		return this.buttonRegistraVacc;
	}
	
	
	

}

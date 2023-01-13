//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

/**
 * 
 * @author Enrico Brullo
 *
 */
public class RegistraCentroGUI {
	
	private JPanel intestazione;
	
	private JPanel contenitorePrincipale;
	
	private JPanel panelTitolo;
	private JLabel labelTitolo;
	
	private JPanel panelVuoto;
	private JLabel labelVuoto;
	
	private JPanel panelNomeCentro;
	private JLabel labelNomeCentro;
	private JTextField textFieldNomeCentro;
	
	private JPanel panelQualificatore;
	private JLabel labelQulificatore;
	private JRadioButton radioButtonVia;
    private JRadioButton radioButtonViale;
    private JRadioButton radioButtonPiazza;
    private ButtonGroup buttonGroupViaVialePiazza;
    
    private JPanel panelIndirizzo;
	private JLabel labelIndirizzo;
	private JTextField textFieldIndirizzo;
	
	private JPanel panelNumeroCivico;
	private JLabel labelNumeroCivico;
    private JTextField textFieldNumeroCivico;
    
	private JPanel panelComune;
    private JLabel labelComune;
    private JTextField textFieldComune;
    
    private JPanel panelProvincia;
    private JLabel labelProvincia;
    private JTextField textFieldProvincia;
    
    private JPanel panelCap;
    private JLabel labelCap;
    private JTextField textFieldCap;
	
	private JPanel panelSceltaTipologiaCentro;
	private JLabel labelTipoCentro;
	private JComboBox<String> tipologiaCentro;
	
	private JPanel panelVuoto1;
	private JLabel labelVuoto1;
	
	private JPanel panelBottone;
	private JButton buttonRegistra;
	
	/**
	 * Costruttore della classe
	 * @param altezza
	 * @param larghezza
	 * @param intestazione
	 */
	public RegistraCentroGUI(int altezza, int larghezza, JPanel intestazione){
		
		this.intestazione = intestazione;
		
		Border bordo = BorderFactory.createLineBorder(Colori.light_grey, 1); //crea bordo
		
		//TITOLO
		this.panelTitolo = new JPanel();
		this.panelTitolo.setLayout(new GridLayout(1,1));
		this.panelTitolo.setBackground(Colori.purple);
		this.labelTitolo = new JLabel("REGISTRA CENTRO VACCINALE:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo.setForeground(Colori.arancione);
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		this.panelTitolo.add(this.labelTitolo);
		this.panelTitolo.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//PANEL PER SPAZIO
		this.panelVuoto = new JPanel();
		this.panelVuoto.setLayout(new GridLayout(1,1));
		this.panelVuoto.setBackground(Colori.purple);
		this.labelVuoto = new JLabel();
		this.labelVuoto.setHorizontalAlignment(JLabel.CENTER);
		this.labelVuoto.setVerticalAlignment(JLabel.CENTER);
		this.panelVuoto.add(labelVuoto);
		this.panelVuoto.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//NOME CENTRO
		this.panelNomeCentro = new JPanel();
		this.panelNomeCentro.setLayout(new GridLayout(1,2));
		this.panelNomeCentro.setBackground(Colori.purple);
		this.labelNomeCentro = new JLabel("Nome centro:");
		this.labelNomeCentro.setForeground(Colori.light_grey);
		this.textFieldNomeCentro = new JTextField("", 10);
		this.textFieldNomeCentro.setBackground(Colori.light_grey);
		this.panelNomeCentro.add(this.labelNomeCentro);
		this.panelNomeCentro.add(this.textFieldNomeCentro);
		this.panelNomeCentro.setPreferredSize(new Dimension(500, 25));
		
		//QUALIFICATORE
		this.panelQualificatore = new JPanel();
		this.panelQualificatore.setLayout(new GridLayout(1,3));
		this.panelQualificatore.setBackground(Colori.purple);
		this.panelQualificatore.setPreferredSize(new Dimension(500, 25));
		this.labelQulificatore = new JLabel("Qualificatore:");
		this.labelQulificatore.setForeground(Colori.light_grey);
		
		this.radioButtonVia = new JRadioButton();
		this.radioButtonVia.setText("Via");
		this.radioButtonVia.setForeground(Colori.light_grey);
		this.radioButtonViale = new JRadioButton();
		this.radioButtonViale.setText("Viale");
		this.radioButtonViale.setForeground(Colori.light_grey);
		this.radioButtonPiazza = new JRadioButton();
		this.radioButtonPiazza.setText("Piazza");
		this.radioButtonPiazza.setForeground(Colori.light_grey);
		this.buttonGroupViaVialePiazza = new ButtonGroup();
		this.radioButtonPiazza.setBackground(Colori.purple);
		this.radioButtonVia.setBackground(Colori.purple);
		this.radioButtonViale.setBackground(Colori.purple);
        
        this.buttonGroupViaVialePiazza.add(radioButtonVia);
        this.buttonGroupViaVialePiazza.add(radioButtonViale);
        this.buttonGroupViaVialePiazza.add(radioButtonPiazza);
        this.radioButtonVia.setSelected(true);
        
        this.panelQualificatore.add(labelQulificatore);
        this.panelQualificatore.add(radioButtonVia);
        this.panelQualificatore.add(radioButtonViale);
        this.panelQualificatore.add(radioButtonPiazza);
        
        //INDIRIZZO
        this.panelIndirizzo = new JPanel();
    	this.panelIndirizzo.setLayout(new GridLayout(1,2));
    	this.panelIndirizzo.setBackground(Colori.purple);
		this.labelIndirizzo = new JLabel("Indirizzo:");
		this.labelIndirizzo.setForeground(Colori.light_grey);
		this.textFieldIndirizzo = new JTextField("", 10);
		this.textFieldIndirizzo.setBackground(Colori.light_grey);
		this.panelIndirizzo.add(this.labelIndirizzo);
		this.panelIndirizzo.add(this.textFieldIndirizzo);
		this.panelIndirizzo.setPreferredSize(new Dimension(500, 25));
		
		//NUMERO CIVICO
		this.panelNumeroCivico = new JPanel();
    	this.panelNumeroCivico.setLayout(new GridLayout(1,2));
    	this.panelNumeroCivico.setBackground(Colori.purple);
		this.labelNumeroCivico = new JLabel("Numero Civico:");
		this.labelNumeroCivico.setForeground(Colori.light_grey);
		this.textFieldNumeroCivico = new JTextField("", 10);
		this.textFieldNumeroCivico.setBackground(Colori.light_grey);
		this.panelNumeroCivico.add(this.labelNumeroCivico);
		this.panelNumeroCivico.add(this.textFieldNumeroCivico);
		this.panelNumeroCivico.setPreferredSize(new Dimension(500, 25));
		
		//COMUNE
		this.panelComune = new JPanel();
		this.panelComune.setLayout(new GridLayout(1,2));
		this.panelComune.setBackground(Colori.purple);
		this.labelComune = new JLabel("Comune:");
		this.labelComune.setForeground(Colori.light_grey);
		this.textFieldComune = new JTextField("", 10);
		this.textFieldComune.setBackground(Colori.light_grey);
		this.panelComune.add(this.labelComune);
		this.panelComune.add(this.textFieldComune);
		this.panelComune.setPreferredSize(new Dimension(500, 25));	
		
		//PROVINCIA
		this.panelProvincia = new JPanel();
		this.panelProvincia.setLayout(new GridLayout(1,2));
		this.panelProvincia.setBackground(Colori.purple);
		this.labelProvincia = new JLabel("Provincia:");
		this.labelProvincia.setForeground(Colori.light_grey);
		this.textFieldProvincia = new JTextField("", 10);
		this.textFieldProvincia.setBackground(Colori.light_grey);
		this.panelProvincia.add(this.labelProvincia);
		this.panelProvincia.add(this.textFieldProvincia);
		this.panelProvincia.setPreferredSize(new Dimension(500, 25));
		
		//CAP
		this.panelCap = new JPanel();
		this.panelCap.setLayout(new GridLayout(1,2));
		this.panelCap.setBackground(Colori.purple);
		this.labelCap = new JLabel("CAP:");
		this.labelCap.setForeground(Colori.light_grey);
		this.textFieldCap = new JTextField("", 10);
		this.textFieldCap.setBackground(Colori.light_grey);
		this.panelCap.add(this.labelCap);
		this.panelCap.add(this.textFieldCap);
		this.panelCap.setPreferredSize(new Dimension(500, 25));
		
		//TIPOLOGIA CENTRO
		this.panelSceltaTipologiaCentro = new JPanel();
		this.panelSceltaTipologiaCentro.setLayout(new GridLayout(1,2));
		this.panelSceltaTipologiaCentro.setBackground(Colori.purple);
		this.labelTipoCentro = new JLabel("Tipologia centro Vaccinale:");
		this.labelTipoCentro.setForeground(Colori.light_grey);
		this.tipologiaCentro = new JComboBox<String>();
		this.tipologiaCentro.addItem("Ospedaliero");
		this.tipologiaCentro.addItem("Aziendale");
		this.tipologiaCentro.addItem("Hub");
		this.tipologiaCentro.setPreferredSize(new Dimension(500, 25));
		this.tipologiaCentro.setBackground(Colori.light_grey);
		this.panelSceltaTipologiaCentro.add(this.labelTipoCentro);
		this.panelSceltaTipologiaCentro.add(this.tipologiaCentro);
		this.panelSceltaTipologiaCentro.setPreferredSize(new Dimension(500, 25));
		
		//PANEL PER SPAZIO
		this.panelVuoto1 = new JPanel();
		this.panelVuoto1.setLayout(new GridLayout(1,1));
		this.panelVuoto1.setBackground(Colori.purple);
		this.labelVuoto1 = new JLabel();
		this.labelVuoto1.setHorizontalAlignment(JLabel.CENTER);
		this.labelVuoto1.setVerticalAlignment(JLabel.CENTER);
		this.panelVuoto1.add(labelVuoto1);
		this.panelVuoto1.setPreferredSize(new Dimension(700, 25)); //larghezza, altezza
		
		
		//BOTTONE
		this.panelBottone = new JPanel();
		this.panelBottone.setBackground(Colori.purple);
		this.buttonRegistra = new JButton("REGISTRA CENTRO");
		this.buttonRegistra.setName("REGISTRA CENTRO");
		this.buttonRegistra.setBorder(bordo);
		this.buttonRegistra.setForeground(Colori.light_grey);
		this.buttonRegistra.setFont(new Font("Arial", Font.BOLD, 15));
		this.panelBottone.setPreferredSize(new Dimension(500, 60));
		this.buttonRegistra.setPreferredSize(new Dimension(200, 50));
		this.buttonRegistra.setBackground(Colori.arancione);
		this.panelBottone.add(this.buttonRegistra);
		
		//CONTENITORE PRINCIPALE
		this.contenitorePrincipale = new JPanel();
		this.contenitorePrincipale.setBackground(Colori.purple);
		this.contenitorePrincipale.add(panelTitolo);
		this.contenitorePrincipale.add(panelVuoto);
		this.contenitorePrincipale.add(panelNomeCentro);
		this.contenitorePrincipale.add(panelQualificatore);
		this.contenitorePrincipale.add(panelIndirizzo);
		this.contenitorePrincipale.add(panelNumeroCivico);
		this.contenitorePrincipale.add(panelComune);
		this.contenitorePrincipale.add(panelProvincia);
		this.contenitorePrincipale.add(panelCap);
		this.contenitorePrincipale.add(panelSceltaTipologiaCentro);
		this.contenitorePrincipale.add(panelVuoto1);
		this.contenitorePrincipale.add(panelBottone);
		
	}
	
	/**
	 * Metodo che mette label con "" 
	 */
	public void pulisciView() {
	this.tipologiaCentro.setSelectedIndex(0);
	this.textFieldNomeCentro.setText("");
	this.textFieldIndirizzo.setText("");
	this.textFieldNumeroCivico.setText("");
	this.textFieldComune.setText("");
	this.textFieldCap.setText("");
	this.textFieldProvincia.setText("");
	}
	
	//AGGIUNGI METODI PER CONTROLLO DEI CAMPI --> GUARDA nostro progetto vecchio

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
	 * Metodo che ritorna dalla combobox la tipologia selezionato
	 * @return
	 */
	public Object retTipoCentro() {
		return this.tipologiaCentro.getSelectedItem();
	}
	
	/**
	 * Metodo che ritorna il nome del centro
	 * @return
	 */
	public String retNomeCentro() {
		return this.textFieldNomeCentro.getText().toLowerCase();
	}
	
	/**
	 * Metodo che ritona il qualificatore selezionato nel radio Button
	 * @return
	 */
	public String retQualificatore() {
		
		String qualificatore = " " ;
		
		if(radioButtonVia.isSelected()) {
			qualificatore = "Via";
		}
		
		else if(radioButtonViale.isSelected()) {
			qualificatore = "Viale";
		}
		
		else if(radioButtonPiazza.isSelected()) {
			qualificatore = "Piazza";
		}
				
		return qualificatore;
	}
	
	/**
	 * Metodo che ritorna l'indirizzo del centro
	 * @return
	 */
	public String retNomeIndirizzo() {
		return this.textFieldIndirizzo.getText().toLowerCase();
	}
	
	/**
	 * Metodo che ritorna numero civico del centro
	 * @return
	 */
	public String retNumeroCivico() {
		return this.textFieldNumeroCivico.getText();
	}
	
	/**
	 * Metodo che ritorna comune centro
	 * @return
	 */
	public String retComune() {
		return this.textFieldComune.getText().toLowerCase();
	}
	
	/**
	 * Metodo che ritorna provincia centro
	 * @return
	 */
	public String retProvincia() {
		return this.textFieldProvincia.getText();
	}
	
	/**
	 * Metodo che ritorna CAP centro
	 * @return
	 */
	public String retCAP() {
		return this.textFieldCap.getText();
	}
	
	/**
	 * Metodo che ritorna il bottone di aggiunta del centro
	 * @return
	 */
	public JButton retBottoneRegistraCentro() {
		return this.buttonRegistra;
	}
}

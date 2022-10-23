
import javax.swing.*;
import java.awt.*;

public class RegistraCentroGUI {
	
	private JPanel intestazione;
	
	private JPanel contenitorePrincipale;
	
	private JPanel panelTitolo;
	private JLabel labelTitolo;
	
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
	
	private JPanel panelBottone;
	private JButton buttonRegistra;
	
	public RegistraCentroGUI(int altezza, int larghezza, JPanel intestazione){
		
		this.intestazione = intestazione;
		
		//TITOLO
		this.panelTitolo = new JPanel();
		this.panelTitolo.setLayout(new GridLayout(1,1));
		this.labelTitolo = new JLabel("REGISTRA CENTRO VACCINALE:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		this.panelTitolo.add(this.labelTitolo);
		this.panelTitolo.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//NOME CENTRO
		this.panelNomeCentro = new JPanel();
		this.panelNomeCentro.setLayout(new GridLayout(1,2));
		this.labelNomeCentro = new JLabel("Nome centro:");
		this.textFieldNomeCentro = new JTextField("", 10);
		this.panelNomeCentro.add(this.labelNomeCentro);
		this.panelNomeCentro.add(this.textFieldNomeCentro);
		this.panelNomeCentro.setPreferredSize(new Dimension(500, 25));
		
		//QUALIFICATORE
		this.panelQualificatore = new JPanel();
		this.panelQualificatore.setLayout(new GridLayout(1,3));
		this.panelQualificatore.setPreferredSize(new Dimension(500, 25));
		this.labelQulificatore = new JLabel("Qualificatore");
		
		this.radioButtonVia = new JRadioButton();
		this.radioButtonVia.setText("Via");
		this.radioButtonViale = new JRadioButton();
		this.radioButtonViale.setText("Viale");
		this.radioButtonPiazza = new JRadioButton();
		this.radioButtonPiazza.setText("Piazza");
		this.buttonGroupViaVialePiazza = new ButtonGroup();
        
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
		this.labelIndirizzo = new JLabel("Indirizzo:");
		this.textFieldIndirizzo = new JTextField("", 10);
		this.panelIndirizzo.add(this.labelIndirizzo);
		this.panelIndirizzo.add(this.textFieldIndirizzo);
		this.panelIndirizzo.setPreferredSize(new Dimension(500, 25));
		
		//NUMERO CIVICO
		this.panelNumeroCivico = new JPanel();
    	this.panelNumeroCivico.setLayout(new GridLayout(1,2));
		this.labelNumeroCivico = new JLabel("Numero Civico:");
		this.textFieldNumeroCivico = new JTextField("", 10);
		this.panelNumeroCivico.add(this.labelNumeroCivico);
		this.panelNumeroCivico.add(this.textFieldNumeroCivico);
		this.panelNumeroCivico.setPreferredSize(new Dimension(500, 25));
		
		//COMUNE
		this.panelComune = new JPanel();
		this.panelComune.setLayout(new GridLayout(1,2));
		this.labelComune = new JLabel("Comune:");
		this.textFieldComune = new JTextField("", 10);
		this.panelComune.add(this.labelComune);
		this.panelComune.add(this.textFieldComune);
		this.panelComune.setPreferredSize(new Dimension(500, 25));	
		
		//PROVINCIA
		this.panelProvincia = new JPanel();
		this.panelProvincia.setLayout(new GridLayout(1,2));
		this.labelProvincia = new JLabel("Provincia:");
		this.textFieldProvincia = new JTextField("", 10);
		this.panelProvincia.add(this.labelProvincia);
		this.panelProvincia.add(this.textFieldProvincia);
		this.panelProvincia.setPreferredSize(new Dimension(500, 25));
		
		//CAP
		this.panelCap = new JPanel();
		this.panelCap.setLayout(new GridLayout(1,2));
		this.labelCap = new JLabel("CAP:");
		this.textFieldCap = new JTextField("", 10);
		this.panelCap.add(this.labelCap);
		this.panelCap.add(this.textFieldCap);
		this.panelCap.setPreferredSize(new Dimension(500, 25));
		
		//TIPOLOGIA CENTRO
		this.panelSceltaTipologiaCentro = new JPanel();
		this.panelSceltaTipologiaCentro.setLayout(new GridLayout(1,2));
		this.labelTipoCentro = new JLabel("Tipologia centro Vaccinale:");
		this.tipologiaCentro = new JComboBox<String>();
		this.tipologiaCentro.addItem("Ospedaliero");
		this.tipologiaCentro.addItem("Aziendale");
		this.tipologiaCentro.addItem("Hub");
		this.tipologiaCentro.setPreferredSize(new Dimension(500, 25));
		this.panelSceltaTipologiaCentro.add(this.labelTipoCentro);
		this.panelSceltaTipologiaCentro.add(this.tipologiaCentro);
		this.panelSceltaTipologiaCentro.setPreferredSize(new Dimension(500, 25));
		
		//BOTTONE
		this.panelBottone = new JPanel();
		this.buttonRegistra = new JButton("REGISTRA CENTRO");
		this.buttonRegistra.setName("REGISTRA CENTRO");
		this.panelBottone.setPreferredSize(new Dimension(500, 35));
		this.panelBottone.add(this.buttonRegistra);
		
		//CONTENITORE PRINCIPALE
		this.contenitorePrincipale = new JPanel();
		this.contenitorePrincipale.add(panelTitolo);
		this.contenitorePrincipale.add(panelNomeCentro);
		this.contenitorePrincipale.add(panelQualificatore);
		this.contenitorePrincipale.add(panelIndirizzo);
		this.contenitorePrincipale.add(panelNumeroCivico);
		this.contenitorePrincipale.add(panelComune);
		this.contenitorePrincipale.add(panelProvincia);
		this.contenitorePrincipale.add(panelCap);
		this.contenitorePrincipale.add(panelSceltaTipologiaCentro);
		this.contenitorePrincipale.add(panelBottone);
		
	}
	
	//mette label con "" 
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

	//ritorna intestazione della pagina
	public JPanel retIntestazione() {
		return this.intestazione;
	}

	//ritorna contenitore elementi
	public JPanel retContenitore() {
		return this.contenitorePrincipale;
	}
	

	//ritorna dalla combobox la tipologia selezionato
	public Object retTipoCentro() {
		return this.tipologiaCentro.getSelectedItem();
	}
	
	//ritorna il nome del centro
	public String retNomeCentro() {
		return this.textFieldNomeCentro.getText();
	}
	
	//ritona il qualificatore selezionato
	public Object retQualificatore() {
		return this.buttonGroupViaVialePiazza.getSelection();
	}
	
	//ritorna l'indirizzo del centro
	public String retNomeIndirizzo() {
		return this.textFieldIndirizzo.getText();
	}
	
	//ritorna numero civico del centro
	public String retNumeroCivico() {
		return this.textFieldNumeroCivico.getText();
	}
	
	//ritorna comune centro
	public String retComune() {
		return this.textFieldComune.getText();
	}
	
	//ritorna provincia centro
	public String retProvincia() {
		return this.textFieldProvincia.getText();
	}
	
	//ritorna CAP centro
	public String retCAP() {
		return this.textFieldCap.getText();
	}
	
	//ritorna il bottone di aggiunta del centro
		public JButton retBottoneRegistraCentro() {
			return this.buttonRegistra;
		}
	
	

}

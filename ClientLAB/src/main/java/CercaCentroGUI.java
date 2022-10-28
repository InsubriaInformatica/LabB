import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class CercaCentroGUI {
	
	private JPanel intestazione;
	private JPanel contenitorePrincipale;
	
	private JPanel panelTitolo;
	private JLabel labelTitolo;
	
	private JPanel panelVuoto;
	private JLabel labelVuoto;
	
	private JPanel panelVuoto1;
	private JLabel labelVuoto1;
	
	private JPanel panelSottoTitolo1;
	private JLabel labelSottoTitolo1;
	
	private JPanel panelSottoTitolo2;
	private JLabel labelSottoTitolo2;
	
	private JPanel panelNomeCentro;
	private JLabel labelNomeCentro;
	private JTextField textFieldNomeCentro;
	private JButton buttonCercaNome;
	
	private JPanel panelTipologiaCentro;
	private JLabel labelTipologiaCentro;
	private JComboBox comboBoxTipologiaCentro;
	
	private JPanel panelComuneCentro;
	private JLabel labelComuneCentro;
	private JTextField textFieldComuneCentro;
	private JButton buttonCercaComune;
	
	
	public CercaCentroGUI(int larghezza, int altezza, JPanel intestazione) {
		
		this.intestazione = intestazione;
		
		//TITOLO
		this.panelTitolo = new JPanel();
		this.panelTitolo.setLayout(new GridLayout(1,1));
		this.labelTitolo = new JLabel("RICERCA IL TUO CENTRO:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		//this.labelTitolo.setForeground(Colori.arancione);
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
		this.panelVuoto.setPreferredSize(new Dimension(700, 50)); //larghezza, altezza
		
		//PANEL PER SPAZIO
		this.panelVuoto1 = new JPanel();
		this.panelVuoto1.setLayout(new GridLayout(1,1));
		this.labelVuoto1 = new JLabel();
		this.labelVuoto1.setHorizontalAlignment(JLabel.CENTER);
		this.labelVuoto1.setVerticalAlignment(JLabel.CENTER);
		this.panelVuoto1.add(labelVuoto1);
		this.panelVuoto1.setPreferredSize(new Dimension(700, 50)); //larghezza, altezza
		
		//SOTTOTITOLO 1
		this.panelSottoTitolo1 = new JPanel();
		this.panelSottoTitolo1.setLayout(new GridLayout(1,1));
		this.labelSottoTitolo1 = new JLabel("Cerca il nome del centro:");
		this.labelSottoTitolo1.setFont(new Font("Arial", Font.BOLD, 25));
		this.labelSottoTitolo1.setHorizontalAlignment(JLabel.CENTER);
		this.labelSottoTitolo1.setVerticalAlignment(JLabel.CENTER);
		this.panelSottoTitolo1.add(this.labelSottoTitolo1);
		this.panelSottoTitolo1.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//NOME CENTRO RICERCA
		this.panelNomeCentro = new JPanel();
		this.panelNomeCentro.setLayout(new GridLayout(1,3));
		this.labelNomeCentro = new JLabel("Nome Centro Vaccinale:");
		this.textFieldNomeCentro = new JTextField("", 20); 
		this.buttonCercaNome = new JButton("Cerca");
		this.buttonCercaNome.setName("CercaNome");
		this.panelNomeCentro.add(this.labelNomeCentro);
		this.panelNomeCentro.add(this.textFieldNomeCentro);
		this.panelNomeCentro.add(this.buttonCercaNome);
		this.panelNomeCentro.setPreferredSize(new Dimension(800, 25));
		
		//SOTTOTITOLO 2
		this.panelSottoTitolo2 = new JPanel();
		this.panelSottoTitolo2.setLayout(new GridLayout(1,1));
		this.labelSottoTitolo2 = new JLabel("Cerca i centri nel tuo comune:");
		this.labelSottoTitolo2.setFont(new Font("Arial", Font.BOLD, 24));
		this.labelSottoTitolo2.setHorizontalAlignment(JLabel.CENTER);
		this.labelSottoTitolo2.setVerticalAlignment(JLabel.CENTER);
		this.panelSottoTitolo2.add(this.labelSottoTitolo2);
		this.panelSottoTitolo2.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//TIPOLOGIA CENTRO
		this.panelTipologiaCentro = new JPanel();
		this.panelTipologiaCentro.setLayout(new GridLayout(1,3));
		this.labelTipologiaCentro = new JLabel("Tipologia:");
		JLabel vuoto = new JLabel();
		this.comboBoxTipologiaCentro = new JComboBox(); 
		this.comboBoxTipologiaCentro.addItem("Ospedaliero");
		this.comboBoxTipologiaCentro.addItem("Hub");
		this.comboBoxTipologiaCentro.addItem("Aziendale");
		this.panelTipologiaCentro.add(this.labelTipologiaCentro);
		this.panelTipologiaCentro.add(this.comboBoxTipologiaCentro);
		this.panelTipologiaCentro.add(vuoto);
		this.panelTipologiaCentro.setPreferredSize(new Dimension(800, 25));
		
		//COMUNE CENTRO RICERCA
		this.panelComuneCentro = new JPanel();
		this.panelComuneCentro.setLayout(new GridLayout(1,3));
		this.labelComuneCentro = new JLabel("Comune Centro Vaccinale:");
		this.textFieldComuneCentro = new JTextField("", 20); 
		this.buttonCercaComune = new JButton("Cerca");
		this.buttonCercaComune.setName("CercaComune");
		this.panelComuneCentro.add(this.labelComuneCentro);
		this.panelComuneCentro.add(this.textFieldComuneCentro);
		this.panelComuneCentro.add(this.buttonCercaComune);
		this.panelComuneCentro.setPreferredSize(new Dimension(800, 25));
		
		
		this.contenitorePrincipale = new JPanel();
		//this.contenitorePrincipale.setBackground(Colori.purple);
		this.contenitorePrincipale.add(panelTitolo);
		this.contenitorePrincipale.add(panelVuoto); //spazio
		this.contenitorePrincipale.add(panelSottoTitolo1);
		this.contenitorePrincipale.add(panelNomeCentro);
		this.contenitorePrincipale.add(panelVuoto1); //spazio
		this.contenitorePrincipale.add(panelSottoTitolo2);
		this.contenitorePrincipale.add(panelTipologiaCentro);
		this.contenitorePrincipale.add(panelComuneCentro);
	
	}
	
	//metodo che ritorna riferimento al Panel Intestazione della schermata
	public JPanel retIntestazione() {
		return this.intestazione;
	}
				
	//metodo che ritorna riferimento al Panel contenitore, ovvero al corpo della schermata
	public JPanel retContenitore() {
		return this.contenitorePrincipale;
	}

	public void pulisciView() {
		this.textFieldNomeCentro.setText("");
		this.textFieldComuneCentro.setText("");
		this.comboBoxTipologiaCentro.setSelectedIndex(0);
	}
	
	//ritorna nome centro inserito
	public String retNomeCentro() {
		return this.textFieldNomeCentro.getText();
		
	}
	
	//ritorna comune centro inserito
	public String retComuneCentro() {
		return this.textFieldComuneCentro.getText();
			
	}
	
	//ritorna tipologia selezionata
	public Object retTipologiaCentro() {
		return this.comboBoxTipologiaCentro.getSelectedItem();
			
	}
	
	//ritorna il bottone per cercare per nome
	public JButton retButtonCercaNome() {
		return this.buttonCercaNome;
	}
	
	//ritorna il bottone per cercare per comune
	public JButton retButtonCercaComune() {
		return this.buttonCercaComune;
	}

}
//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * Classe che implementa la GUI per la ricerca del centro vaccinale
 * @author Qaldo Ademi, Enrico Brullo
 *
 */
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
	
	/**
	 * Metodo che crea la GUI per la ricerca del centro vaccinale
	 * 
	 * @param larghezza
	 * @param altezza
	 * @param intestazione
	 */
	public CercaCentroGUI(int larghezza, int altezza, JPanel intestazione) {
		
		this.intestazione = intestazione;
		
		Border bordo = BorderFactory.createLineBorder(Colori.light_grey, 1); //crea bordo
		
		//TITOLO
		this.panelTitolo = new JPanel();
		this.panelTitolo.setLayout(new GridLayout(1,1));
		this.panelTitolo.setBackground(Colori.purple);
		this.labelTitolo = new JLabel("RICERCA IL TUO CENTRO:");
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
		
		//PANEL PER SPAZIO
		this.panelVuoto1 = new JPanel();
		this.panelVuoto1.setLayout(new GridLayout(1,1));
		this.panelVuoto1.setBackground(Colori.purple);
		this.labelVuoto1 = new JLabel();
		this.labelVuoto1.setHorizontalAlignment(JLabel.CENTER);
		this.labelVuoto1.setVerticalAlignment(JLabel.CENTER);
		this.panelVuoto1.add(labelVuoto1);
		this.panelVuoto1.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//SOTTOTITOLO 1
		this.panelSottoTitolo1 = new JPanel();
		this.panelSottoTitolo1.setLayout(new GridLayout(1,1));
		this.panelSottoTitolo1.setBackground(Colori.purple);
		this.labelSottoTitolo1 = new JLabel("Cerca il nome del centro:");
		this.labelSottoTitolo1.setForeground(Colori.arancione);
		this.labelSottoTitolo1.setFont(new Font("Arial", Font.BOLD, 25));
		this.labelSottoTitolo1.setHorizontalAlignment(JLabel.CENTER);
		this.labelSottoTitolo1.setVerticalAlignment(JLabel.CENTER);
		this.panelSottoTitolo1.add(this.labelSottoTitolo1);
		this.panelSottoTitolo1.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//NOME CENTRO RICERCA
		this.panelNomeCentro = new JPanel();
		this.panelNomeCentro.setLayout(new GridLayout(1,3));
		this.panelNomeCentro.setBackground(Colori.purple);
		this.labelNomeCentro = new JLabel("Nome Centro Vaccinale:");
		this.labelNomeCentro.setForeground(Colori.light_grey);
		this.textFieldNomeCentro = new JTextField("", 20); 
		this.buttonCercaNome = new JButton("Cerca");
		this.buttonCercaNome.setName("CercaNome");
		this.buttonCercaNome.setBackground(Colori.arancione);
		this.buttonCercaNome.setForeground(Colori.light_grey);
		this.buttonCercaNome.setBorder(bordo);
		this.panelNomeCentro.add(this.labelNomeCentro);
		this.panelNomeCentro.add(this.textFieldNomeCentro);
		this.panelNomeCentro.add(this.buttonCercaNome);
		this.panelNomeCentro.setPreferredSize(new Dimension(800, 25));
		
		//SOTTOTITOLO 2
		this.panelSottoTitolo2 = new JPanel();
		this.panelSottoTitolo2.setLayout(new GridLayout(1,1));
		this.panelSottoTitolo2.setBackground(Colori.purple);
		this.labelSottoTitolo2 = new JLabel("Cerca i centri nel tuo comune:");
		this.labelSottoTitolo2.setForeground(Colori.arancione);
		this.labelSottoTitolo2.setFont(new Font("Arial", Font.BOLD, 23));
		this.labelSottoTitolo2.setHorizontalAlignment(JLabel.CENTER);
		this.labelSottoTitolo2.setVerticalAlignment(JLabel.CENTER);
		this.panelSottoTitolo2.add(this.labelSottoTitolo2);
		this.panelSottoTitolo2.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//TIPOLOGIA CENTRO
		this.panelTipologiaCentro = new JPanel();
		this.panelTipologiaCentro.setLayout(new GridLayout(1,3));
		this.panelTipologiaCentro.setBackground(Colori.purple);
		this.labelTipologiaCentro = new JLabel("Tipologia:");
		this.labelTipologiaCentro.setForeground(Colori.light_grey);
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
		this.panelComuneCentro.setBackground(Colori.purple);
		this.labelComuneCentro = new JLabel("Comune Centro Vaccinale:");
		this.labelComuneCentro.setForeground(Colori.light_grey);
		this.textFieldComuneCentro = new JTextField("", 20); 
		this.buttonCercaComune = new JButton("Cerca");
		this.buttonCercaComune.setName("CercaComune");
		this.buttonCercaComune.setBackground(Colori.arancione);
		this.buttonCercaComune.setForeground(Colori.light_grey);
		this.buttonCercaComune.setBorder(bordo);
		this.panelComuneCentro.add(this.labelComuneCentro);
		this.panelComuneCentro.add(this.textFieldComuneCentro);
		this.panelComuneCentro.add(this.buttonCercaComune);
		this.panelComuneCentro.setPreferredSize(new Dimension(800, 25));
		
		
		this.contenitorePrincipale = new JPanel();
		this.contenitorePrincipale.setBackground(Colori.purple);
		this.contenitorePrincipale.add(panelTitolo);
		this.contenitorePrincipale.add(panelVuoto); //spazio
		this.contenitorePrincipale.add(panelSottoTitolo1);
		this.contenitorePrincipale.add(panelNomeCentro);
		this.contenitorePrincipale.add(panelVuoto1); //spazio
		this.contenitorePrincipale.add(panelSottoTitolo2);
		this.contenitorePrincipale.add(panelTipologiaCentro);
		this.contenitorePrincipale.add(panelComuneCentro);
	
	}
	
	/**
	 * Metodo che ritorna riferimento al Panel Intestazione della schermata
	 * @return
	 */
	public JPanel retIntestazione() {
		return this.intestazione;
	}
				
	/**
	 *;Metodo che ritorna riferimento al Panel contenitore, ovvero al corpo della schermata
	 * @return
	 */
	public JPanel retContenitore() {
		return this.contenitorePrincipale;
	}

	/**
	 * Metodo che setta a vuoto i campi nelle text field
	 */
	public void pulisciView() {
		this.textFieldNomeCentro.setText("");
		this.textFieldComuneCentro.setText("");
		this.comboBoxTipologiaCentro.setSelectedIndex(0);
	}
	
	/**
	 * Metodo che ritorna nome centro inserito
	 * @return
	 */
	public String retNomeCentro() {
		return this.textFieldNomeCentro.getText().toLowerCase();
		
	}
	
	/**
	 * Metodo che ritorna comune centro inserito
	 * @return
	 */
	public String retComuneCentro() {
		return this.textFieldComuneCentro.getText().toLowerCase();
			
	}
	
	/**
	 * Metodo che ritorna tipologia selezionata
	 * @return
	 */
	public Object retTipologiaCentro() {
		return this.comboBoxTipologiaCentro.getSelectedItem();
			
	}
	
	/**
	 * Metodo che ritorna il bottone per cercare per nome un centro vaccinale
	 * @return
	 */
	public JButton retButtonCercaNome() {
		return this.buttonCercaNome;
	}
	
	/**
	 * Metodo che ritorna il bottone per cercare per comune un centro vaccinale
	 * @return
	 */
	public JButton retButtonCercaComune() {
		return this.buttonCercaComune;
	}

}

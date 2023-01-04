//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


/**
 * 
 * Classe che implementa la GUI della pagina di visualizzazione dei centri vaccinali
 * @author Enrico Brullo
 *
 */
public class ElencoCentriGUI {
	
	private JPanel intestazione;
	
	private JPanel contenitorePrincipale;
	
	private JPanel panelTitolo;
	private JLabel labelTitolo;
	
	private JPanel panelSpazio;
	private JLabel labelSpazio;
	
	private JPanel panelTitolo1;
	private JLabel labelTitolo1;
	
	private JPanel panelBox;
	private JComboBox<String> sceltaCentro;
	
	private JPanel panelInformazioni;
	private JLabel nome;
	private JLabel infoNome;
	private JLabel tipologia;
	private JLabel infoTipologia;
	private JLabel indirizzo;
	private JLabel infoIndirizzo;
	
	
	private JPanel panelSintomi;
	private JLabel numeroSegnalazioni;
	private JLabel infoNumeroSegnalazioni;
	private JLabel mediaSintomi;
	private JLabel infoMediaSintomi;
	
	/**
	 * Costruttore della classe
	 * 
	 * @param larghezza
	 * @param altezza
	 * @param intestazione
	 */
	public ElencoCentriGUI(int larghezza, int altezza, JPanel intestazione){
		
		this.intestazione = intestazione;
		
		//Border bordo = BorderFactory.createLineBorder(Colori.light_grey, 1); //crea bordo
		
		//TITOLO
		this.panelTitolo = new JPanel();
		this.panelTitolo.setLayout(new GridLayout(1,1));
		this.panelTitolo.setBackground(Colori.purple);
		this.labelTitolo = new JLabel("SELEZIONA IL TUO CENTRO:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo.setForeground(Colori.arancione);
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		this.panelTitolo.add(this.labelTitolo);
		this.panelTitolo.setPreferredSize(new Dimension(900, 35)); //larghezza, altezza
		
		
		//COMBOBOX X VISUALIZZARE CENTRI CERCATI
		this.panelBox = new JPanel();
		this.panelBox.setLayout(new BorderLayout());
		this.panelBox.setBackground(Colori.purple);
		this.sceltaCentro = new JComboBox<String>();
		this.sceltaCentro.setName("ComboBoxCentroInfo");
		this.sceltaCentro.setForeground(Colori.purple);
		this.panelBox.add(this.sceltaCentro);
		this.panelBox.setPreferredSize(new Dimension(800, 25));
		
		//spazio
		this.panelSpazio = new JPanel();
		this.panelSpazio.setLayout(new GridLayout(1,1));
		this.panelSpazio.setBackground(Colori.purple);
		this.labelSpazio = new JLabel();
		this.labelSpazio.setHorizontalAlignment(JLabel.CENTER);
		this.labelSpazio.setVerticalAlignment(JLabel.CENTER);
		this.labelSpazio.setBackground(Colori.purple);
		this.panelSpazio.add(labelSpazio);
		this.panelSpazio.setPreferredSize(new Dimension(700, 25)); //larghezza, altezza
		
		//PANEL CHE CONTIENE INFO CENTRI
		this.panelInformazioni = new JPanel();
		this.panelInformazioni.setLayout(new GridLayout(4,2));
		this.panelInformazioni.setBackground(Colori.purple);
		
		this.nome = new JLabel("-Nome Centro:");
		this.nome.setFont(new Font("Arial", Font.BOLD, 18));
		this.nome.setForeground(Colori.light_grey);
		this.infoNome = new JLabel("Default");
		this.infoNome.setFont(new Font("Arial", Font.BOLD, 18));
		this.infoNome.setForeground(Colori.light_grey);
		
		this.tipologia = new JLabel("-Tipologia Centro:");
		this.tipologia.setFont(new Font("Arial", Font.BOLD, 18));
		this.tipologia.setForeground(Colori.light_grey);
		this.infoTipologia = new JLabel("Default");
		this.infoTipologia.setFont(new Font("Arial", Font.BOLD, 18));
		this.infoTipologia.setForeground(Colori.light_grey);
		
		this.indirizzo = new JLabel("-Indirizzo Centro:");
		this.indirizzo.setFont(new Font("Arial", Font.BOLD, 18));
		this.indirizzo.setForeground(Colori.light_grey);
		this.infoIndirizzo = new JLabel("Default");
		this.infoIndirizzo.setFont(new Font("Arial", Font.BOLD, 18));
		this.infoIndirizzo.setForeground(Colori.light_grey);
		
		this.panelInformazioni.add(nome);
		this.panelInformazioni.add(infoNome);
		this.panelInformazioni.add(tipologia);
		this.panelInformazioni.add(infoTipologia);
		this.panelInformazioni.add(indirizzo);
		this.panelInformazioni.add(infoIndirizzo);
		
		this.panelInformazioni.setPreferredSize(new Dimension(800, 180));
		
		//TITOLO 1 
		this.panelTitolo1 = new JPanel();
		this.panelTitolo1.setLayout(new BorderLayout());
		this.panelTitolo1.setBackground(Colori.purple);
		this.labelTitolo1 = new JLabel("Prospetto rissuntivo sintomi:");
		this.labelTitolo1.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo1.setForeground(Colori.arancione);
		this.labelTitolo1.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo1.setVerticalAlignment(JLabel.CENTER);
		this.panelTitolo1.add(this.labelTitolo1);
		this.panelTitolo1.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//PANEL CHE CONTIENE MEDIA SINTOMI
		this.panelSintomi = new JPanel();
		this.panelSintomi.setLayout(new GridLayout(1,2));
		this.panelSintomi.setPreferredSize(new Dimension(800, 130));
		this.panelSintomi.setBackground(Colori.purple);
		
		this.numeroSegnalazioni = new JLabel("-Numero Segnalazioni:");
		this.numeroSegnalazioni.setFont(new Font("Arial", Font.BOLD, 18));
		this.numeroSegnalazioni.setForeground(Colori.light_grey);
		this.infoNumeroSegnalazioni = new JLabel("Default");
		this.infoNumeroSegnalazioni.setFont(new Font("Arial", Font.BOLD, 18));
		this.infoNumeroSegnalazioni.setForeground(Colori.light_grey);
		
		this.mediaSintomi = new JLabel("-Media Sintomi:");
		this.mediaSintomi.setFont(new Font("Arial", Font.BOLD, 18));
		this.mediaSintomi.setForeground(Colori.light_grey);
		this.infoMediaSintomi = new JLabel("--/5");
		this.infoMediaSintomi.setFont(new Font("Arial", Font.BOLD, 18));
		this.infoMediaSintomi.setForeground(Colori.light_grey);
		
		this.panelSintomi.add(numeroSegnalazioni);
		this.panelSintomi.add(infoNumeroSegnalazioni);
		this.panelSintomi.add(mediaSintomi);
		this.panelSintomi.add(infoMediaSintomi);
		
		this.contenitorePrincipale = new JPanel();
		this.contenitorePrincipale.setBackground(Colori.purple);
		this.contenitorePrincipale.add(panelTitolo);
		this.contenitorePrincipale.add(panelBox);
		this.contenitorePrincipale.add(panelSpazio);
		this.contenitorePrincipale.add(panelInformazioni);
		this.contenitorePrincipale.add(panelTitolo1);
		this.contenitorePrincipale.add(panelSintomi);
		
	}


	/**
	 * Metodo che ritorna riferimento al Panel Intestazione della schermata
	 * @return
	 */
	public JPanel retIntestazione() {
		return this.intestazione;
	}
					
	/**
	 * Metodo che ritorna riferimento al Panel contenitore, ovvero al corpo della schermata
	 * @return
	 */
	public JPanel retContenitore() {
		return this.contenitorePrincipale;
	}
	
	/**
	 * Metodo che ritorna elenco dei centri
	 * @return
	 */
	public JComboBox<String> retComboBox() {
		return this.sceltaCentro;
	}
	
	/**
	 * Metodo che resetta la combo box contenente i centri vaccinali
	 */
	public void resetComboBox() {
		this.sceltaCentro.removeAllItems();
	}
	
	/**
	 * Metodo che inserisce nella comboBox centri ricercati
	 * @param centro
	 */
	public void aggiungiCentroInComboBox(String centro) {
		this.sceltaCentro.addItem(centro);
	}
	
	/**
	 * Metodo che ritorna indice elemento selezionato della ComboBox
	 * @return
	 */
	public int retIndiceCentroSelezionatoComboBox() {
		return this.sceltaCentro.getSelectedIndex();
	}
	
	/**
	 * Metodo che ritorna elemento selezionato della ComboBox
	 * @return
	 */
	public Object retCentroSelezionatoComboBox() {
		return this.sceltaCentro.getSelectedItem();
	}
	
	
	/**
	 * Metodo che setta info label con parametro passato
	 * @param txt
	 */
	public void setNomeCentro(String txt) {
		this.nome.setVisible(true);
		this.infoNome.setVisible(true);
		this.infoNome.setText(txt);
	}
	
	/**
	 * Metodo che setta tipologia del centro
	 * @param txt
	 */
	public void setTipologiaCentro(String txt) {
		this.tipologia.setVisible(true);
		this.infoTipologia.setVisible(true);
		this.infoTipologia.setText(txt);
	}
	
	/**
	 * Metodo che setta l'indirizzo del centro
	 * @param txt
	 */
	public void setIndirizzoCentro(String txt) {
		this.indirizzo.setVisible(true);
		this.infoIndirizzo.setVisible(true);
		this.infoIndirizzo.setText(txt);
	}
	
	/**
	 * Metodo che setta il numero di segnalazioni di un centro
	 * @param txt
	 */
	public void setNumeroSegnalazioni(String txt) {
		this.numeroSegnalazioni.setVisible(true);
		this.infoNumeroSegnalazioni.setVisible(true);
		this.infoNumeroSegnalazioni.setText(txt);
	}
	
	/**
	 * Metodo che setta la media dei sintomi di un centro
	 * @param txt
	 */
	public void setMediaSintomi(String txt) {
		this.mediaSintomi.setVisible(true);
		this.infoMediaSintomi.setVisible(true);
		this.infoMediaSintomi.setText(txt);
	}
	
	/**
	 * Metodo che setta info label con parametro passato --> non visualizza info
	 * @param txt
	 */
	public void setNomeCentroNOVISUAL(String txt) {
		this.nome.setVisible(false);
		this.infoNome.setVisible(false);
		this.infoNome.setText(txt);
	}
	
	/**
	 * Metodo che setta info label con parametro passato --> non visualizza info
	 * @param txt
	 */
	public void setTipologiaCentroNOVISUAL(String txt) {
		this.tipologia.setVisible(false);
		this.infoTipologia.setVisible(false);
		this.infoTipologia.setText(txt);
	}
	
	/**
	 * Metodo che setta info label con parametro passato --> non visualizza info
	 * @param txt
	 */
	public void setIndirizzoCentroNOVISUAL(String txt) {
		this.indirizzo.setVisible(false);
		this.infoIndirizzo.setVisible(false);
		this.infoIndirizzo.setText(txt);
	}
		
	/**
	 * Metodo che setta info label con parametro passato --> non visualizza info
	 * @param txt
	 */
	public void setNumeroSegnalazioniNOVISUAL(String txt) {
		this.numeroSegnalazioni.setVisible(false);
		this.infoNumeroSegnalazioni.setVisible(false);
		this.infoNumeroSegnalazioni.setText(txt);
	}	
	
	/**
	 * Metodo che setta info label con parametro passato --> non visualizza info
	 * @param txt
	 */
	public void setMediaSintomiNOVISUAL(String txt) {
		this.mediaSintomi.setVisible(false);
		this.infoMediaSintomi.setVisible(false);
		this.infoMediaSintomi.setText(txt);
	}
	
	
}

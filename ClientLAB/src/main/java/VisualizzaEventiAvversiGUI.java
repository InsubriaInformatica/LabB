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
 * 
 * @author Enrico Brullo
 *
 */
public class VisualizzaEventiAvversiGUI {
	
	private JPanel intestazione;
	
	private JPanel contenitorePrincipale;
	
	private JPanel panelTitolo;
	private JLabel labelTitolo;
	
	private JPanel panelVuoto;
	private JLabel labelVuoto;
	
	private JTable tabellaEA;
	private JScrollPane scrollPaneEA; //visualizzazione dinamica "scrollabile"
	private String[] colonne;
	private String[][] valori;
	
	/**
	 * Costruttore della classe
	 * @param altezza
	 * @param larghezza
	 * @param intestazione
	 */
	public VisualizzaEventiAvversiGUI(int altezza, int larghezza, JPanel intestazione) {
		
		this.intestazione = intestazione;
		
		
		//TITOLO
		this.panelTitolo = new JPanel();
		this.panelTitolo.setLayout(new GridLayout(1,1));
		this.panelTitolo.setBackground(Colori.purple);
		this.labelTitolo = new JLabel("INFO EVENTI AVVERSI:");
		this.labelTitolo.setForeground(Colori.arancione);
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		this.panelTitolo.add(this.labelTitolo);
		this.panelTitolo.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//SPAZIO
		this.panelVuoto = new JPanel();
		this.panelVuoto.setLayout(new GridLayout(1,1));
		this.panelVuoto.setBackground(Colori.purple);
		this.labelVuoto = new JLabel();
		this.panelVuoto.add(labelVuoto);
		this.panelVuoto.setPreferredSize(new Dimension(800, 22)); //larghezza, altezza
		
		
		//TABELLA DI VISUALIZZAZIONE EVENTI AVVERSI
		String[] nomiCol = {"TIPO EVENTO", "SEVERITA' (da 1 a 5)" , "NOTE OPZIONALI (max 256)"};
		String [][] valoriBase = {
				{"Default", "--/5", "Default" },
				{"Default2", "--/5", "Default2" },
				{"Default3", "--/5", "Default3" }
				
		};
		
		//nomi e valori assegnati alle colonne
		this.colonne = nomiCol;
		this.valori = valoriBase;
		
		contenitorePrincipale = new JPanel();
		this.contenitorePrincipale.setBackground(Colori.purple);
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
	 * Metodo che ritorna array che contiene nomi colonne
	 * @return
	 */
	public String[] retColonne() {
		return this.colonne;
	}

	/**
	 * Metodo che crea tabella con valori passati come argomento
	 * @param inserimento
	 */
	public void creaTabella(String [][] inserimento) {
		
		this.tabellaEA = new JTable(inserimento, this.colonne);
		this.tabellaEA.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
		this.tabellaEA.setRowHeight(25);
		this.tabellaEA.setSelectionBackground(Colori.arancione);
		this.tabellaEA.setFont(new Font("Arial", 0, 15));
		this.tabellaEA.setEnabled(true); 
		
	}

	/**
	 * Metodo che rende tabella scrollabile ed aggiunge elementi utili
	 */
	public void ultimaView() {
		
		//TITOLO
		this.panelTitolo = new JPanel();
		this.panelTitolo.setLayout(new GridLayout(1,1));
		this.panelTitolo.setBackground(Colori.purple);
		this.labelTitolo = new JLabel("INFO EVENTI AVVERSI:");
		this.labelTitolo.setForeground(Colori.arancione);
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		this.panelTitolo.add(this.labelTitolo);
		this.panelTitolo.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
				
		//SPAZIO
		this.panelVuoto = new JPanel();
		this.panelVuoto.setLayout(new GridLayout(1,1));
		this.panelVuoto.setBackground(Colori.purple);
		this.labelVuoto = new JLabel();
		this.panelVuoto.add(labelVuoto);
		this.panelVuoto.setPreferredSize(new Dimension(800, 18)); //larghezza, altezza
				
		Border bordo = BorderFactory.createLineBorder(Colori.arancione, 3); //crea bordo
		
		this.scrollPaneEA = new JScrollPane(this.tabellaEA);
		this.scrollPaneEA.setPreferredSize(new Dimension(800, 240));
		this.scrollPaneEA.setBorder(bordo);
		
		this.contenitorePrincipale.add(panelTitolo);
		this.contenitorePrincipale.add(panelVuoto);
		this.contenitorePrincipale.add(this.scrollPaneEA);
	}
	
	/**
	 * Metodo che resetta la view
	 */
	public void pulisciView() {
		this.contenitorePrincipale.removeAll();
	}
	
	

}

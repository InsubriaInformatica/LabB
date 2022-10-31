import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

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
	
	
	public VisualizzaEventiAvversiGUI(int altezza, int larghezza, JPanel intestazione) {
		
		this.intestazione = intestazione;
		
		//TITOLO
		this.panelTitolo = new JPanel();
		this.panelTitolo.setLayout(new GridLayout(1,1));
		this.labelTitolo = new JLabel("INFO EVENTI AVVERSI:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		this.panelTitolo.add(this.labelTitolo);
		this.panelTitolo.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//SPAZIO
		this.panelVuoto = new JPanel();
		this.panelVuoto.setLayout(new GridLayout(1,1));
		this.labelVuoto = new JLabel();
		this.panelVuoto.add(labelVuoto);
		this.panelVuoto.setPreferredSize(new Dimension(800, 22)); //larghezza, altezza
		
		
		//TABELLA DI VISUALIZZAZIONE EVENTI AVVERSI
		String[] nomiCol = {"TIPO EVENTO", "SEVERITA' (1-5)" , "NOTE OPZIONALI"};
		String [][] valoriBase = {
				{"Default", "--/5", "Default" }
		};
		
		//nomi e valori assegnati alle colonne
		this.colonne = nomiCol;
		this.valori = valoriBase;
		
		this.tabellaEA = new JTable(valoriBase,nomiCol);
		this.scrollPaneEA = new JScrollPane(this.tabellaEA);
		this.scrollPaneEA.setPreferredSize(new Dimension(800, 320));
		
		
		contenitorePrincipale = new JPanel();
		this.contenitorePrincipale.add(panelTitolo);
		this.contenitorePrincipale.add(panelVuoto);
		this.contenitorePrincipale.add(scrollPaneEA);
		
		
	}
	
	//ritorna intestazione della pagina
	public JPanel retIntestazione() {
		return this.intestazione;
	}

	//ritorna contenitore elementi
	public JPanel retContenitore() {
		return this.contenitorePrincipale;
	}
	
	//array che contiene nomi colonne
	public String[] retColonne() {
		return this.colonne;
	}

	//crea tabella con valori passati come argomento
	public void creaTabella(String [][] inserimento) {
		this.tabellaEA = new JTable(inserimento, this.colonne);
		this.tabellaEA.setEnabled(false); //senza eventi
		
	}

	//rende tabella scrollabile ed aggiunge elementi utili
	public void ultimaView() {
		this.scrollPaneEA = new JScrollPane(this.tabellaEA);
		this.contenitorePrincipale.add(this.scrollPaneEA);
	}
	
	

}

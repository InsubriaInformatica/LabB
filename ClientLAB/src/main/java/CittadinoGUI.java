

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

//componenti grafici operatore
public class CittadinoGUI {
	
	private JPanel intestazione;
	
	private JPanel contenitore;
	
	private JLabel labelTitolo;
	
	private JLabel spazioVuoto1;
	private JLabel spazioVuoto2;
	private JLabel spazioVuoto3;
	private JLabel spazioVuoto4;
	private JLabel spazioVuoto5;
	
	private JButton buttonConsultaInfo;
	private JButton buttonRegistrati;
	private JButton buttoninserisciAvversita;
	
	public CittadinoGUI(int larghezza, int altezza, JPanel intestazione) {
		this.intestazione = intestazione;
		
		this.contenitore = new JPanel();
		this.contenitore.setLayout(new GridLayout(3,3, 20, 20)); //layout del panel, margine tra righe e colonne
		this.contenitore.setPreferredSize(new Dimension(larghezza/2, altezza/10*7)); //size
		
		this.labelTitolo = new JLabel("CITTADINO:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		
		
		
		this.buttonRegistrati = new JButton("REGISTRATI");
		this.buttonRegistrati.setName("REGISTRATI");
		
		
		
		this.buttonConsultaInfo = new JButton("CONSULTA INFO CENTRI VACCINALI");
		this.buttonConsultaInfo.setName("CONSULTA INFO CENTRI VACCINALI");
		
		
		
		this.buttoninserisciAvversita = new JButton("INSERISCI EVENTI AVVERSI");
		this.buttoninserisciAvversita.setName("INSERISCI EVENTI AVVERSI");
		
		
		spazioVuoto1 = new JLabel();
		spazioVuoto2 = new JLabel();
		spazioVuoto3 = new JLabel();
		spazioVuoto4 = new JLabel();
		spazioVuoto5 = new JLabel();
		
		this.contenitore.add(this.spazioVuoto1);
		this.contenitore.add(this.labelTitolo);
		this.contenitore.add(this.spazioVuoto2);
		this.contenitore.add(this.buttonRegistrati);
		this.contenitore.add(this.buttonConsultaInfo);
		this.contenitore.add(this.buttoninserisciAvversita);
		this.contenitore.add(this.spazioVuoto3);
		this.contenitore.add(this.spazioVuoto4);
		this.contenitore.add(this.spazioVuoto5);
	
		
	}
	
	//metodo che ritorna riferimento al Panel Intestazione della schermata
			public JPanel retIntestazione() {
				return this.intestazione;
			}
			
			//metodo che ritorna riferimento al Panel contenitore, ovvero al corpo della schermata
			public JPanel retContenitore() {
				return this.contenitore;
			}
			
			
	
	
	

}


import java.awt.*;

import javax.swing.*;

//componenti grafici operatore

public class OperatoreGUI{
	
	private JPanel intestazione;
	
	private JLabel labelTitolo;
	private ImageIcon immagine;
	
	private JPanel contenitore;
	
	private JButton registraCentro;
	private JButton registraVaccinato;
	
	private JLabel spazioVuoto1;
	private JLabel spazioVuoto2;
	private JLabel spazioVuoto3;
	private JLabel spazioVuoto4;
	private JLabel spazioVuoto5;
	private JLabel spazioVuoto6;
	
	//costruttore
	public OperatoreGUI(int larghezza, int altezza, JPanel intestazione) {
		this.intestazione = intestazione; //instestazione schermata
		
	
		this.contenitore = new JPanel(); //inizializza contenitore, corpo dello schermo
		this.contenitore.setLayout(new GridLayout(3,3,20,20)); //layout del panel
		this.contenitore.setPreferredSize(new Dimension(larghezza, altezza/10*7)); //size
		//this.contenitore.setBackground(Color.white);
		
		this.labelTitolo = new JLabel("OPERATORE:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		
		this.registraCentro = new JButton("REGISTRA NUOVO CENTRO"); //bottone centro
		this.registraCentro.setName("REGISTRA NUOVO CENTRO");
		this.registraCentro.setFont(new Font("Arial", Font.BOLD, 18)); //size:18
		
		
		this.registraVaccinato = new JButton("REGISTRA NUOVO VACCINATO"); //bottone vaccinato
		this.registraVaccinato.setName("REGISTRA NUOVO VACCINATO");
		this.registraVaccinato.setFont(new Font("Arial", Font.BOLD, 18)); //size:18
		
		spazioVuoto1 = new JLabel();
		spazioVuoto2 = new JLabel();
		spazioVuoto3 = new JLabel();
		spazioVuoto4 = new JLabel();
		spazioVuoto5 = new JLabel();
		spazioVuoto6 = new JLabel();
		
		
		//aggiunta bottoni al Panel
		this.contenitore.add(this.spazioVuoto1);
		this.contenitore.add(this.labelTitolo);
		this.contenitore.add(this.spazioVuoto2);
		this.contenitore.add(this.registraCentro);
		this.contenitore.add(this.spazioVuoto6);
		this.contenitore.add(this.registraVaccinato);
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
		
		//metodo che ritorna riferimento al button relativo alla registrazione di un nuovo centro
		public JButton retButtonRegistraCentro() {
			return this.registraCentro;
		}
		
		//metodo che ritorna riferimento al button relativo alla alla registrazione di un nuovo vaccinato
		public JButton retButtonRegistraVaccinato() {
			return this.registraVaccinato;
		}
	
}

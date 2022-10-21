
import java.awt.*;

import javax.swing.*;

//componenti grafici operatore

public class OperatoreGUI{
	
	private JPanel intestazione;
	private JLabel titolo;
	private ImageIcon immagine;
	
	private JPanel contenitore;
	private JButton registraCentro;
	private JButton registraVaccinato;
	
	
	
	//costruttore
	public OperatoreGUI(int larghezza, int altezza, JPanel intestazione) {
		this.intestazione = intestazione; //instestazione schermata
		
	
		this.contenitore = new JPanel(); //inizializza contenitore, corpo dello schermo
		this.contenitore.setLayout(new GridLayout(3,2,10,10)); //layout del panel
		this.contenitore.setPreferredSize(new Dimension(larghezza, altezza/10*7)); //size
		this.contenitore.setBackground(Color.RED);
		
		
		this.registraCentro = new JButton("REGISTRA NUOVO CENTRO"); //bottone centro
		this.registraCentro.setName("REGISTRA NUOVO CENTRO");
		this.registraCentro.setFont(new Font("Arial", Font.BOLD, 18)); //size:18
		
		
		this.registraVaccinato = new JButton("REGISTRA NUOVO VACCINATO"); //bottone vaccinato
		this.registraVaccinato.setName("REGISTRA NUOVO VACCINATO");
		this.registraVaccinato.setFont(new Font("Arial", Font.BOLD, 18)); //size:18
		
		
		
		//aggiunta bottoni al Panel
		this.contenitore.add(this.registraCentro, BorderLayout.WEST); 
		this.contenitore.add(this.registraVaccinato, BorderLayout.EAST); 
		
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

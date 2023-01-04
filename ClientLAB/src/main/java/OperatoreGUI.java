//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * Componenti grafici operatore
 * @author Enrico Brullo
 *
 */

public class OperatoreGUI{
	
	private JPanel intestazione;
	
	private JLabel labelTitolo;
	
	private JPanel contenitore;
	
	private JButton registraCentro;
	private JButton registraVaccinato;
	
	private ImageIcon immagineRegCentro;
	private ImageIcon scalaRegCentro; //immagine in scala da inserire
	
	private ImageIcon immagineRegVaccinato;
	private ImageIcon scalaRegVaccinato; //immagine in scala da inserire
	
	private JLabel spazioVuoto1;
	private JLabel spazioVuoto2;
	private JLabel spazioVuoto3;
	private JLabel spazioVuoto4;
	private JLabel spazioVuoto5;
	private JLabel spazioVuoto6;
	
	/**
	 * Costruttore della classe
	 * @param larghezza
	 * @param altezza
	 * @param intestazione
	 */
	public OperatoreGUI(int larghezza, int altezza, JPanel intestazione) {
		this.intestazione = intestazione; //instestazione schermata
		
		Border bordo = BorderFactory.createLineBorder(Colori.arancione, 5); //crea bordo
	
		this.contenitore = new JPanel(); //inizializza contenitore, corpo dello schermo
		this.contenitore.setLayout(new GridLayout(3,3,10,10)); //layout del panel
		this.contenitore.setPreferredSize(new Dimension(larghezza, altezza/10*7)); //size
		this.contenitore.setBackground(Colori.purple);
		
		immagineRegCentro = new ImageIcon(getClass().getClassLoader().getResource("regCentro.png"));
		//immagineRegCentro = new ImageIcon("img/regCentro.png");
		scalaRegCentro = new ImageIcon(immagineRegCentro.getImage().getScaledInstance(immagineRegCentro.getIconWidth()/20*3, immagineRegCentro.getIconHeight()/20*3, java.awt.Image.SCALE_SMOOTH)); //immagine in scala
		
		immagineRegVaccinato = new ImageIcon(getClass().getClassLoader().getResource("regVaccinato.png"));
		//immagineRegVaccinato = new ImageIcon("img/regVaccinato.png");
		scalaRegVaccinato = new ImageIcon(immagineRegVaccinato.getImage().getScaledInstance(immagineRegVaccinato.getIconWidth()/20*3, immagineRegVaccinato.getIconHeight()/20*3, java.awt.Image.SCALE_SMOOTH)); //immagine in scala
		
		this.labelTitolo = new JLabel("FORM OPERATORE:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 27));
		this.labelTitolo.setForeground(Colori.arancione);
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		
		this.registraCentro = new JButton("REGISTRA NUOVO CENTRO"); //bottone centro
		this.registraCentro.setName("REGISTRA NUOVO CENTRO");
		this.registraCentro.setFont(new Font("Arial", Font.BOLD, 16)); //size
		this.registraCentro.setForeground(Colori.light_grey);
		this.registraCentro.setIcon(scalaRegCentro);
		this.registraCentro.setHorizontalTextPosition(JButton.CENTER);
		this.registraCentro.setVerticalTextPosition(JButton.BOTTOM);
		this.registraCentro.setIconTextGap(10); //distanza tra immagine e testo
		this.registraCentro.setBorder(bordo);
		this.registraCentro.setBackground(Colori.purple);
		
		this.registraVaccinato = new JButton("REGISTRA NUOVO VACCINATO"); //bottone vaccinato
		this.registraVaccinato.setName("REGISTRA NUOVO VACCINATO");
		this.registraVaccinato.setFont(new Font("Arial", Font.BOLD, 16)); //size
		this.registraVaccinato.setForeground(Colori.light_grey);
		this.registraVaccinato.setIcon(scalaRegVaccinato);
		this.registraVaccinato.setHorizontalTextPosition(JButton.CENTER);
		this.registraVaccinato.setVerticalTextPosition(JButton.BOTTOM);
		this.registraVaccinato.setIconTextGap(10); //distanza tra immagine e testo
		this.registraVaccinato.setBorder(bordo);
		this.registraVaccinato.setBackground(Colori.purple);
		
		
		this.spazioVuoto1 = new JLabel("Seleziona Servizio");
		this.spazioVuoto1.setFont(new Font("Arial", Font.PLAIN, 30));
		this.spazioVuoto1.setForeground(Colori.arancione);
		
		spazioVuoto2 = new JLabel();
		spazioVuoto3 = new JLabel();
		spazioVuoto4 = new JLabel();
		spazioVuoto5 = new JLabel();
		spazioVuoto6 = new JLabel();
		
		
		//aggiunta bottoni al Panel
		this.contenitore.add(this.labelTitolo);
		this.contenitore.add(this.spazioVuoto1);
		this.contenitore.add(this.spazioVuoto2);
		this.contenitore.add(this.registraCentro);
		this.contenitore.add(this.spazioVuoto6);
		this.contenitore.add(this.registraVaccinato);
		this.contenitore.add(this.spazioVuoto3);
		this.contenitore.add(this.spazioVuoto4);
		this.contenitore.add(this.spazioVuoto5);
		
		
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
		return this.contenitore;
	}
	
	/**
	 * Metodo che ritorna riferimento al button relativo alla registrazione di un nuovo centro
	 * @return
	 */
	public JButton retButtonRegistraCentro() {
		return this.registraCentro;
	}
	
	/**
	 * Metodo che ritorna riferimento al button relativo alla alla registrazione di un nuovo vaccinato
	 * @return
	 */
	public JButton retButtonRegistraVaccinato() {
		return this.registraVaccinato;
	}
	
}

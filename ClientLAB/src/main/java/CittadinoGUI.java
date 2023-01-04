//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Classe che implementa la GUI per i cittadini
 * @author Enrico Brullo
 *
 */
public class CittadinoGUI {
	
	private JPanel intestazione;
	
	private JPanel contenitore;
	
	private JLabel labelTitolo;
	
	private JLabel sottoTitolo;
	
	private JLabel spazioVuoto2;
	private JLabel spazioVuoto3;
	private JLabel spazioVuoto4;
	private JLabel spazioVuoto5;
	
	private JButton buttonConsultaInfo;
	private JButton buttonRegistrati;
	private JButton buttoninserisciAvversita;
	
	private ImageIcon immagineRegistrati;
	private ImageIcon scalaRegistrati; //immagine in scala da inserire
	
	private ImageIcon immagineInfo;
	private ImageIcon scalaInfo; //immagine in scala da inserire
	
	private ImageIcon immagineAvversi;
	private ImageIcon scalaAvversi; //immagine in scala da inserire
	
	/**
	 * Metodo che implementa l'interfaccia grafica del cittadino
	 * 
	 * @param larghezza
	 * @param altezza
	 * @param intestazione
	 */
	public CittadinoGUI(int larghezza, int altezza, JPanel intestazione) {
		this.intestazione = intestazione;
		
		Border bordo = BorderFactory.createLineBorder(Colori.arancione, 5); //crea bordo
		
		this.contenitore = new JPanel();
		this.contenitore.setLayout(new GridLayout(3,3, 10, 10)); //layout del panel, margine tra righe e colonne
		this.contenitore.setPreferredSize(new Dimension(larghezza/2, altezza/10*7)); //size
		this.contenitore.setBackground(Colori.purple);
		
		immagineRegistrati = new ImageIcon(getClass().getClassLoader().getResource("registrati.png"));
		//immagineRegistrati = new ImageIcon("img/registrati.png");
		scalaRegistrati = new ImageIcon(immagineRegistrati.getImage().getScaledInstance(immagineRegistrati.getIconWidth()/20*2, immagineRegistrati.getIconHeight()/20*2, java.awt.Image.SCALE_SMOOTH)); //immagine in scala
		
		immagineInfo = new ImageIcon(getClass().getClassLoader().getResource("info.png"));
		//immagineInfo = new ImageIcon("img/info.png");
		scalaInfo = new ImageIcon(immagineInfo.getImage().getScaledInstance(immagineInfo.getIconWidth()/20*2, immagineInfo.getIconHeight()/20*2, java.awt.Image.SCALE_SMOOTH)); //immagine in scala
		
		immagineAvversi = new ImageIcon(getClass().getClassLoader().getResource("avversi.png"));
		//immagineAvversi = new ImageIcon("img/avversi.png");
		scalaAvversi = new ImageIcon(immagineAvversi.getImage().getScaledInstance(immagineAvversi.getIconWidth()/20*2, immagineAvversi.getIconHeight()/20*2, java.awt.Image.SCALE_SMOOTH)); //immagine in scala
		
		this.labelTitolo = new JLabel("FORM CITTADINO:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 28));
		this.labelTitolo.setForeground(Colori.arancione);
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
	
		
		this.buttonRegistrati = new JButton("REGISTRATI");
		this.buttonRegistrati.setName("REGISTRATI");
		this.buttonRegistrati.setFont(new Font("Arial", Font.BOLD, 18)); //size
		this.buttonRegistrati.setForeground(Colori.light_grey);
		this.buttonRegistrati.setIcon(scalaRegistrati);
		this.buttonRegistrati.setHorizontalTextPosition(JButton.CENTER);
		this.buttonRegistrati.setVerticalTextPosition(JButton.BOTTOM);
		this.buttonRegistrati.setIconTextGap(10); //distanza tra immagine e testo
		this.buttonRegistrati.setBorder(bordo);
		this.buttonRegistrati.setBackground(Colori.purple);
		
		
		this.buttonConsultaInfo = new JButton("INFO CENTRI VACCINALI");
		this.buttonConsultaInfo.setName("INFO CENTRI VACCINALI");
		this.buttonConsultaInfo.setFont(new Font("Arial", Font.BOLD, 18)); //size
		this.buttonConsultaInfo.setForeground(Colori.light_grey);
		this.buttonConsultaInfo.setIcon(scalaInfo);
		this.buttonConsultaInfo.setHorizontalTextPosition(JButton.CENTER);
		this.buttonConsultaInfo.setVerticalTextPosition(JButton.BOTTOM);
		this.buttonConsultaInfo.setIconTextGap(10); //distanza tra immagine e testo
		this.buttonConsultaInfo.setBorder(bordo);
		this.buttonConsultaInfo.setBackground(Colori.purple);
		
		this.buttoninserisciAvversita = new JButton("INSERISCI EVENTI AVVERSI");
		this.buttoninserisciAvversita.setName("INSERISCI EVENTI AVVERSI");
		this.buttoninserisciAvversita.setFont(new Font("Arial", Font.BOLD, 18)); //size
		this.buttoninserisciAvversita.setForeground(Colori.light_grey);
		this.buttoninserisciAvversita.setIcon(scalaAvversi);
		this.buttoninserisciAvversita.setHorizontalTextPosition(JButton.CENTER);
		this.buttoninserisciAvversita.setVerticalTextPosition(JButton.BOTTOM);
		this.buttoninserisciAvversita.setIconTextGap(10); //distanza tra immagine e testo
		this.buttoninserisciAvversita.setBorder(bordo);
		this.buttoninserisciAvversita.setBackground(Colori.purple);
		
		this.sottoTitolo = new JLabel("Seleziona Servizio");
		this.sottoTitolo.setFont(new Font("Arial", Font.PLAIN, 28));
		this.sottoTitolo.setForeground(Colori.arancione);
		
		spazioVuoto2 = new JLabel();
		spazioVuoto3 = new JLabel();
		spazioVuoto4 = new JLabel();
		spazioVuoto5 = new JLabel();
		
		this.contenitore.add(this.labelTitolo);
		this.contenitore.add(this.sottoTitolo);
		this.contenitore.add(this.spazioVuoto2);
		this.contenitore.add(this.buttonRegistrati);
		this.contenitore.add(this.buttonConsultaInfo);
		this.contenitore.add(this.buttoninserisciAvversita);
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
	 * Metodo che ritorna riferimento al bottone registrati
	 * @return
	 */
	public JButton retButtonRegistrati() {
		return this.buttonRegistrati;
		
	}
	
	/**
	 * Metodo che ritorna riferimento al bottone inserisci evento avverso
	 * @return
	 */
	public JButton retButtonInserisciEvento() {
		return this.buttoninserisciAvversita;
		
	}
	
	/**
	 * Metodo che ritorna riferimento al bottone visualizza info centri vaccinali
	 * @return
	 */
	public JButton retButtonVisualizzaInfo() {
		return this.buttonConsultaInfo;
		
	}
	
	
			
			
	
	
	

}

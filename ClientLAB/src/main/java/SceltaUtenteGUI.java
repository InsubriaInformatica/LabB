//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * In questa schermata viene selezionata la tipologia utente cui si vuole lavorare
 * @author Enrico Brullo
 *
 */
public class SceltaUtenteGUI {
	
	private JPanel intestazione;
	

	private ImageIcon immagineOperatore;
	private ImageIcon scalaOperatore; //immagine in scala da inserire
	
	private ImageIcon immagineCittadino;
	private ImageIcon scalaCittadino; //immagine in scala da inserire
	
	private ImageIcon immagineSetting;
	private ImageIcon scalaSetting; //immagine in scala da inserire 
	
	private JPanel panelSetting;
	private JButton buttonSetting;
	
	private JPanel contenitoreTipoUtente;
	private JButton operatore;
	private JButton cittadino;

	private JLabel labelTitolo;
	private JLabel spazioVuoto;

	/**
	 * Costruttore della classe
	 * @param larghezza
	 * @param altezza
	 * @param intestazione
	 */
	public SceltaUtenteGUI(int larghezza, int altezza, JPanel intestazione) {
		this.intestazione = intestazione; //intestazione schermata
		
		Border bordo = BorderFactory.createLineBorder(Colori.arancione, 5); //crea bordo
		
		
		this.contenitoreTipoUtente = new JPanel(); //inizializza contenitore 
		this.contenitoreTipoUtente.setLayout(new GridLayout(3,3, 20, 20)); //layout del panel, margine tra righe e colonne
		this.contenitoreTipoUtente.setPreferredSize(new Dimension(larghezza/2, altezza/10*7)); //size
		this.contenitoreTipoUtente.setBackground(Colori.purple);
			
		immagineOperatore = new ImageIcon(getClass().getClassLoader().getResource("operatore.png"));
		//immagineOperatore = new ImageIcon("img/operatore.png");
		scalaOperatore = new ImageIcon(immagineOperatore.getImage().getScaledInstance(immagineOperatore.getIconWidth()/20*2, immagineOperatore.getIconHeight()/20*2, java.awt.Image.SCALE_SMOOTH)); //immagine in scala
		
		immagineCittadino = new ImageIcon(getClass().getClassLoader().getResource("cittadino.png"));
		//immagineCittadino = new ImageIcon("img/cittadino.png");
		scalaCittadino = new ImageIcon(immagineCittadino.getImage().getScaledInstance(immagineCittadino.getIconWidth()/20*2, immagineCittadino.getIconHeight()/20*2, java.awt.Image.SCALE_SMOOTH)); //immagine in scala
		
		immagineSetting = new ImageIcon(getClass().getClassLoader().getResource("impostazioni.png"));
		//immagineSetting = new ImageIcon("img/impostazioni.png");
		scalaSetting = new ImageIcon(immagineSetting.getImage().getScaledInstance(immagineSetting.getIconWidth()/20*2, immagineSetting.getIconHeight()/20*2, java.awt.Image.SCALE_SMOOTH)); //immagine in scala
		

		this.labelTitolo = new JLabel("SELEZIONA IL TIPO UTENTE:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 28));
		this.labelTitolo.setForeground(Colori.arancione);
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		
		this.spazioVuoto = new JLabel();
		
		this.operatore = new JButton("OPERATORE"); //bottone operatore
		this.operatore.setName("OPERATORE");
		this.operatore.setFont(new Font("Arial", Font.BOLD, 25)); //size
		this.operatore.setForeground(Colori.light_grey);
		this.operatore.setIcon(scalaOperatore);
		this.operatore.setHorizontalTextPosition(JButton.CENTER);
		this.operatore.setVerticalTextPosition(JButton.BOTTOM);
		this.operatore.setIconTextGap(10); //distanza tra immagine e testo
		this.operatore.setBorder(bordo);
		this.operatore.setBackground(Colori.purple);
		
		
		this.cittadino = new JButton("CITTADINO"); //bottone cittadino
		this.cittadino.setName("CITTADINO");
		this.cittadino.setFont(new Font("Arial", Font.BOLD, 25)); //size
		this.cittadino.setForeground(Colori.light_grey);
		this.cittadino.setIcon(scalaCittadino);
		this.cittadino.setHorizontalTextPosition(JButton.CENTER);
		this.cittadino.setVerticalTextPosition(JButton.BOTTOM);
		this.cittadino.setIconTextGap(10); //distanza tra immagine e testo
		this.cittadino.setBorder(bordo);
		this.cittadino.setBackground(Colori.purple);
		
	
		this.panelSetting = new JPanel();
		this.panelSetting.setLayout(new BorderLayout());
		this.panelSetting.setPreferredSize(new Dimension(500,50));
		this.panelSetting.setBackground(Colori.purple);
		this.buttonSetting = new JButton();
		this.buttonSetting.setName("IMPOSTAZINI-IP");
		this.buttonSetting.setIcon(scalaSetting);
		this.buttonSetting.setBorderPainted(false);
		this.buttonSetting.setBackground(Colori.purple);
		this.panelSetting.add(buttonSetting);
		
		
		//aggiunta bottoni al Panel
		this.contenitoreTipoUtente.add(this.labelTitolo);
		this.contenitoreTipoUtente.add(this.panelSetting);
		this.contenitoreTipoUtente.add(this.operatore);
		this.contenitoreTipoUtente.add(this.cittadino);
		//this.contenitoreTipoUtente.add(this.panelSetting);
		
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
		return this.contenitoreTipoUtente;
	}
	
	/**
	 * Metodo che ritorna riferimento al button relativo alla scelta di essere operatore
	 * @return
	 */
	public JButton retButtonOperatore() {
		return this.operatore;
	}
	
	/**
	 * Metodo che ritorna riferimento al button relativo alla scelta di essere cittadino
	 * @return
	 */
	public JButton retButtonCittadino() {
		return this.cittadino;
	}
	
	/**
	 * Metodo che ritorna il pulsante per cambiare ip
	 * @return
	 */
	public JButton retButtonImpostazioni() {
		return this.buttonSetting;
	}
}

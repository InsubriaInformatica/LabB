
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

//in questa schermata viene selezionata la tipologia utente cui si vuole lavorare
public class SceltaUtenteGUI {
	
	private JPanel intestazione;
	

	private ImageIcon immagineOperatore;
	private ImageIcon scalaOperatore; //immagine in scala da inserire
	
	private ImageIcon immagineCittadino;
	private ImageIcon scalaCittadino; //immagine in scala da inserire
	
	
	private JPanel contenitoreTipoUtente;
	private JButton operatore;
	private JButton cittadino;

	private JLabel labelTitolo;
	private JLabel spazioVuoto;

	//costruttore
	public SceltaUtenteGUI(int larghezza, int altezza, JPanel intestazione) {
		this.intestazione = intestazione; //intestazione schermata
		
		Border bordo = BorderFactory.createLineBorder(Colori.arancione, 5); //crea bordo
		
		
		this.contenitoreTipoUtente = new JPanel(); //inizializza contenitore 
		this.contenitoreTipoUtente.setLayout(new GridLayout(3,2, 20, 20)); //layout del panel, margine tra righe e colonne
		this.contenitoreTipoUtente.setPreferredSize(new Dimension(larghezza/2, altezza/10*7)); //size
		this.contenitoreTipoUtente.setBackground(Colori.purple);
			
		immagineOperatore = new ImageIcon("img/operatore.png");
		scalaOperatore = new ImageIcon(immagineOperatore.getImage().getScaledInstance(immagineOperatore.getIconWidth()/20*3, immagineOperatore.getIconHeight()/20*3, java.awt.Image.SCALE_SMOOTH)); //immagine in scala
		
		immagineCittadino = new ImageIcon("img/cittadino.png");
		scalaCittadino = new ImageIcon(immagineCittadino.getImage().getScaledInstance(immagineCittadino.getIconWidth()/20*3, immagineCittadino.getIconHeight()/20*3, java.awt.Image.SCALE_SMOOTH)); //immagine in scala
		
		this.labelTitolo = new JLabel("SELEZIONA IL TIPO UTENTE:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo.setForeground(Colori.arancione);
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		
		this.operatore = new JButton("OPERATORE"); //bottone operatore
		this.operatore.setName("OPERATORE");
		this.operatore.setFont(new Font("Arial", Font.BOLD, 25)); //size
		this.operatore.setForeground(Colori.light_grey);
		this.operatore.setIcon(scalaOperatore);
		this.operatore.setHorizontalTextPosition(JButton.CENTER);
		this.operatore.setVerticalTextPosition(JButton.BOTTOM);
		this.operatore.setIconTextGap(10); //distanza tra immagine e testo
		this.operatore.setBorder(bordo);
		
		
		this.cittadino = new JButton("CITTADINO"); //bottone cittadino
		this.cittadino.setName("CITTADINO");
		this.cittadino.setFont(new Font("Arial", Font.BOLD, 25)); //size
		this.cittadino.setForeground(Colori.light_grey);
		this.cittadino.setIcon(scalaCittadino);
		this.cittadino.setHorizontalTextPosition(JButton.CENTER);
		this.cittadino.setVerticalTextPosition(JButton.BOTTOM);
		this.cittadino.setIconTextGap(10); //distanza tra immagine e testo
		this.cittadino.setBorder(bordo);
		
		this.spazioVuoto = new JLabel();
		
		
		//aggiunta bottoni al Panel
		this.contenitoreTipoUtente.add(this.labelTitolo);
		this.contenitoreTipoUtente.add(this.spazioVuoto);
		this.contenitoreTipoUtente.add(this.operatore);
		this.contenitoreTipoUtente.add(this.cittadino);
		
	}
	
	
	//metodo che ritorna riferimento al Panel Intestazione della schermata
	public JPanel retIntestazione() {
		return this.intestazione;
	}
	
	//metodo che ritorna riferimento al Panel contenitore, ovvero al corpo della schermata
	public JPanel retContenitore() {
		return this.contenitoreTipoUtente;
	}
	
	//metodo che ritorna riferimento al button relativo alla scelta di essere operatore
	public JButton retButtonOperatore() {
		return this.operatore;
	}
	
	//metodo che ritorna riferimento al button relativo alla scelta di essere cittadino
	public JButton retButtonCittadino() {
		return this.cittadino;
	}
}

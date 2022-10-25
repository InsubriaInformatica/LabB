
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

//in questa schermata viene selezionata la tipologia utente cui si vuole lavorare
public class SceltaUtenteGUI {
	
	private JPanel intestazione;
	private JPanel intestazioneTipoUtente;
	private JPanel titolo;
	
	private ImageIcon immagineOperatore;
	private ImageIcon scalaOperatore; //immagine in scala da inserire
	
	private JPanel contenitoreTipoUtente;
	private JButton operatore;
	private JButton cittadino;

	private JLabel spazioVuotoS;
	private JLabel spazioVuotoG;
	
	
	//costruttore
	public SceltaUtenteGUI(int larghezza, int altezza, JPanel intestazione) {
		this.intestazione = intestazione; //intestazione schermata
		
		
		this.contenitoreTipoUtente = new JPanel(); //inizializza contenitore 
		this.contenitoreTipoUtente.setLayout(new GridLayout(3,2, 20, 20)); //layout del panel, margine tra righe e colonne
		this.contenitoreTipoUtente.setPreferredSize(new Dimension(larghezza/2, altezza/10*7)); //size
			
		immagineOperatore = new ImageIcon("img/fotoprova.png");
		scalaOperatore = new ImageIcon(immagineOperatore.getImage().getScaledInstance(immagineOperatore.getIconWidth()/20*4, immagineOperatore.getIconHeight()/20*4, java.awt.Image.SCALE_SMOOTH)); //immagine in scala
		
		this.titolo = new JPanel();
		this.titolo.setLayout(new GridLayout(0, 1));
		this.titolo.setPreferredSize(new Dimension(larghezza/2, altezza/10*7));
		
		this.operatore = new JButton("OPERATORE"); //bottone operatore
		this.operatore.setName("OPERATORE");
		this.operatore.setFont(new Font("Arial", Font.BOLD, 18)); //size:18
		this.operatore.setIcon(scalaOperatore);
		this.operatore.setHorizontalTextPosition(JButton.CENTER);
		this.operatore.setVerticalTextPosition(JButton.BOTTOM);
		this.operatore.setIconTextGap(15); //distanza tra immagine e testo
		this.operatore.setBorder(BorderFactory.createEtchedBorder());
		
		this.spazioVuotoS = new JLabel("SELEZIONA TIPO DI UTENTE"); //inizializzo spazio vuoto prima riga
		this.spazioVuotoS.setHorizontalTextPosition(JLabel.CENTER);
		this.spazioVuotoG = new JLabel(); //inizializzo vuoto prima riga
		
		
		this.cittadino = new JButton("CITTADINO"); //bottone cittadino
		this.cittadino.setName("CITTADINO");
		this.cittadino.setFont(new Font("Arial", Font.BOLD, 18)); //size:18
		this.cittadino.setIcon(scalaOperatore);
		this.cittadino.setHorizontalTextPosition(JButton.CENTER);
		this.cittadino.setVerticalTextPosition(JButton.BOTTOM);
		this.cittadino.setIconTextGap(15); //distanza tra immagine e testo
		this.cittadino.setBorder(BorderFactory.createEtchedBorder());
	
		//aggiunta bottoni al Panel
//		this.contenitoreTipoUtente.add(this.spazioVuotoS, BorderLayout.WEST);
		this.titolo.add(this.spazioVuotoS);
		this.contenitoreTipoUtente.add(this.spazioVuotoG);
		this.contenitoreTipoUtente.add(this.operatore,BorderLayout.WEST);
		this.contenitoreTipoUtente.add(this.cittadino, BorderLayout.EAST);
		
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

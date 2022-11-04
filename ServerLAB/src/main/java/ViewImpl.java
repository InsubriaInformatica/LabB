
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;

//GESTIONE DEI COMPONENTI GRAFICI X AVVIO SERVER
public class ViewImpl extends JFrame implements ViewInterface{
	private static final long serialVersionUID = 1L;
	
	private String viewAttuale;
	private final short FRAME_WIDTH = 900;
	private final short FRAME_HEIGHT = 635;
	
	private JPanel intestazione;
	private JLabel titolo;
	
	private ImageIcon immagine;
	
	private ImageIcon exit;
	private JButton buttonExit;
	
	private ImageIcon avvio;
	private JButton buttonAvvio;

	//costruttore che realizza la view
	public ViewImpl() {
	
		//FRAME 
		this.viewAttuale = null;
		this.setTitle("SERVER VACCINIAMO");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocationRelativeTo(null); 
		this.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setLayout(new BorderLayout());
		
		//INTESTAZIONE
		Border bordoIntestazione = BorderFactory.createLineBorder(Color.BLACK, 3); //crea bordo

		//exit = new ImageIcon("img/indietro2.png");
		//ImageIcon scalaBack = new ImageIcon(back.getImage().getScaledInstance(back.getIconWidth()/20*2, back.getIconHeight()/20*2, java.awt.Image.SCALE_SMOOTH)); //immagine in scala
		
		this.immagine = new ImageIcon("img/server.png"); // ../ serve per il jar
		
		
		//TITOLO
		this.titolo = new JLabel(new ImageIcon(immagine.getImage().getScaledInstance(immagine.getIconWidth()/20*3, immagine.getIconHeight()/20*3, java.awt.Image.SCALE_SMOOTH)));
		titolo.setText("AVVIO SERVER");
		//titolo.setIcon(immagine);
		titolo.setHorizontalTextPosition(JLabel.CENTER); //setta il testo DX,CX,SX rispetto a immagine
		titolo.setVerticalTextPosition(JLabel.TOP); //setta il testo TOP,CX,BOTTOM rispetto a immagine
		titolo.setFont(new Font("MV Boli", Font.BOLD, 30));
		//titolo.setForeground(Colori.purple); //colore testo
		
		this.intestazione = new JPanel(); //inizializza contenitore intestazione
		this.intestazione.setLayout(new BorderLayout());
		this.intestazione.setPreferredSize(new Dimension(180, 160)); //size panel 
		this.intestazione.setOpaque(true);
		//this.intestazione.setBackground(Colori.arancione);
		this.intestazione.setBorder(bordoIntestazione);
		this.intestazione.add(this.titolo, BorderLayout.CENTER); //aggiungi titolo
		
		mostraAvvioServer();
		
	}
	
	private void mostraAvvioServer() {
		this.setVisible(false);
		this.getContentPane().removeAll();
		this.getContentPane().add(this.intestazione, BorderLayout.PAGE_START);
		//this.getContentPane().add(this.center, BorderLayout.CENTER);
		this.setVisible(true);
	}

	@Override
	public void updateView(Object dati) {
		
	}

	@Override
	public JButton retButtonAvvia() {
		
		return null;
	}

	@Override
	public List<String> txtInfoServer() {
		
		return null;
	}

}

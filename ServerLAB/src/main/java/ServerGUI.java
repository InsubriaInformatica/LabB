
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;

//PATTERN MVC --> GESTIONE DEI COMPONENTI GRAFICI X AVVIO SERVER
public class ServerGUI extends JFrame implements ViewInterface{
	private static final long serialVersionUID = 1L;
	
	private String viewAttuale;
	private final short FRAME_WIDTH = 900;
	private final short FRAME_HEIGHT = 635;
	
	private JPanel intestazione;
	private JLabel titolo;
	
	private JPanel contenitorePrincipale;
	
	private ImageIcon immagine;
	
	private JPanel panelUsername;
	private JLabel labelUsername;
	private JTextField txtUsername;
	
	private JPanel panelPsw;
	private JLabel labelPsw;
	private JPasswordField txtPsw;
	
	private JPanel panelHost;
	private JLabel labelHost;
	private JTextField txtHost;
	
	private JPanel panelPorta;
	private JLabel labelPorta;
	private JTextField txtPorta;
	
	private JPanel panelNomeDB;
	private JLabel labelNomeDB;
	private JTextField txtNomeDB;
	
	private JPanel panelVuoto;
	private JLabel labelVuoto;
	
	private JPanel panelBottoni;
	private ImageIcon avvio;
	private JButton buttonAvvio;
	
	private ImageIcon spegnimento;
	private JButton buttonSpegnimento;

	//costruttore che realizza la view
	public ServerGUI() {
	
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

		
		//Titolo contenuto nell'intestazione
		this.immagine = new ImageIcon("img/server.png"); // ../ serve per il jar
		this.titolo = new JLabel(new ImageIcon(immagine.getImage().getScaledInstance(immagine.getIconWidth()/20*4, immagine.getIconHeight()/20*4, java.awt.Image.SCALE_SMOOTH)));
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
		
		//CONTENITORE PRINCIPALE 
		this.contenitorePrincipale = new JPanel();
		
		//USERNAME 
		this.panelUsername = new JPanel();
		this.panelUsername.setLayout(new GridLayout(1,2));
		//this.panelUsername.setBackground(Colori.purple);
		this.labelUsername = new JLabel("USERNAME");
		//this.labelUsername.setForeground(Colori.light_grey);
		this.txtUsername= new JTextField("postgres", 20); 
		this.panelUsername.add(this.labelUsername);
		this.panelUsername.add(this.txtUsername);
		this.panelUsername.setPreferredSize(new Dimension(800, 50));
		
		//PASSWORD
		this.panelPsw = new JPanel();
		this.panelPsw.setLayout(new GridLayout(1,2));
		//this.panelUsername.setBackground(Colori.purple);
		this.labelPsw = new JLabel("PASSWORD:");
		//this.labelUsername.setForeground(Colori.light_grey);
		this.txtPsw= new JPasswordField("", 20); 
		this.panelPsw.add(this.labelPsw);
		this.panelPsw.add(this.txtPsw);
		this.panelPsw.setPreferredSize(new Dimension(800, 50));
		
		//HOST
		this.panelHost = new JPanel();
		this.panelHost.setLayout(new GridLayout(1,2));
		//this.panelUsername.setBackground(Colori.purple);
		this.labelHost = new JLabel("HOST:");
		//this.labelUsername.setForeground(Colori.light_grey);
		this.txtHost= new JTextField("localhost", 20); 
		this.panelHost.add(this.labelHost);
		this.panelHost.add(this.txtHost);
		this.panelHost.setPreferredSize(new Dimension(800, 50));
		
		//HOST
		this.panelPorta = new JPanel();
		this.panelPorta.setLayout(new GridLayout(1,2));
		//this.panelUsername.setBackground(Colori.purple);
		this.labelPorta = new JLabel("PORTA:");
		//this.labelUsername.setForeground(Colori.light_grey);
		this.txtPorta= new JTextField("5432", 20); 
		this.panelPorta.add(this.labelPorta);
		this.panelPorta.add(this.txtPorta);
		this.panelPorta.setPreferredSize(new Dimension(800, 50));
		
		//NOME DB
		this.panelNomeDB = new JPanel();
		this.panelNomeDB.setLayout(new GridLayout(1,2));
		//this.panelUsername.setBackground(Colori.purple);
		this.labelNomeDB = new JLabel("NOME DATABASE:");
		//this.labelUsername.setForeground(Colori.light_grey);
		this.txtNomeDB= new JTextField("LabB", 20); 
		this.panelNomeDB.add(this.labelNomeDB);
		this.panelNomeDB.add(this.txtNomeDB);
		this.panelNomeDB.setPreferredSize(new Dimension(800, 50));
		
		//SPAZIO VUOTO
		this.panelVuoto = new JPanel();
		this.panelVuoto.setLayout(new GridLayout(1,1));
		//this.panelVuoto.setBackground(Colori.purple);
		this.labelVuoto = new JLabel();
		this.labelVuoto.setHorizontalAlignment(JLabel.CENTER);
		this.labelVuoto.setVerticalAlignment(JLabel.CENTER);
		this.panelVuoto.add(labelVuoto);
		this.panelVuoto.setPreferredSize(new Dimension(700, 25)); //larghezza, altezza
		
		//BOTTONE AVVIA SERVER
		this.avvio = new ImageIcon("img/accendi.png");
		this.spegnimento = new ImageIcon("img/spegni.png");
		
		this.panelBottoni = new JPanel();
		this.panelBottoni.setLayout(new GridLayout(1,2));
		//this.panelBottoni.setBackground(Colori.purple);
		this.buttonAvvio = new JButton(new ImageIcon(avvio.getImage().getScaledInstance(avvio.getIconWidth()/20*2, avvio.getIconHeight()/20*2, java.awt.Image.SCALE_SMOOTH)));
		this.buttonAvvio.setName("AVVIO SERVER");
		this.buttonAvvio.setBorderPainted(false); //senza contorni
		//this.buttonAvvio.setBackground(Colori.arancione);
		//this.buttonAvvio.setForeground(Colori.light_grey);
		//this.buttonAvvio.setBorder(bordo);
		this.panelBottoni.setPreferredSize(new Dimension(200, 60)); //dimensioni panel
		this.buttonAvvio.setPreferredSize(new Dimension(200, 50)); //dimensioni bottone
		//this.panelBottone1.setBackground(Colori.purple);
		this.panelBottoni.add(this.buttonAvvio);
		
		
	
				
		//BOTTONE SPEGNI SERVER
		this.buttonSpegnimento = new JButton(new ImageIcon(spegnimento.getImage().getScaledInstance(spegnimento.getIconWidth()/20*2, spegnimento.getIconHeight()/20*2, java.awt.Image.SCALE_SMOOTH)));
		this.buttonSpegnimento.setName("SPEGNI SERVER");
		this.buttonSpegnimento.setBorderPainted(false); //senza contorni
		//this.buttonAvvio.setBackground(Colori.arancione);
		//this.buttonAvvio.setForeground(Colori.light_grey);
		//this.buttonAvvio.setBorder(bordo);
		this.panelBottoni.setPreferredSize(new Dimension(200, 60)); //dimensioni panel
		this.buttonSpegnimento.setPreferredSize(new Dimension(200, 50)); //dimensioni bottone
		//this.panelBottone1.setBackground(Colori.purple);
		this.panelBottoni.add(this.buttonSpegnimento);
		
		
		this.contenitorePrincipale.add(panelUsername);
		this.contenitorePrincipale.add(panelPsw);
		this.contenitorePrincipale.add(panelHost);
		this.contenitorePrincipale.add(panelPorta);
		this.contenitorePrincipale.add(panelNomeDB);
		this.contenitorePrincipale.add(panelVuoto);
		this.contenitorePrincipale.add(panelBottoni);
		
		mostraAvvioServer();
		
	}
	
	//mostra schermata di avvio del server
	private void mostraAvvioServer() {
		this.setVisible(false);
		this.getContentPane().removeAll();
		this.getContentPane().add(this.intestazione, BorderLayout.PAGE_START);
		this.getContentPane().add(this.contenitorePrincipale, BorderLayout.CENTER);
		this.setVisible(true);
	}

	@Override
	public void updateView(Object dati) {
		String s = (String) dati;
		
		if(s.equals("avvio")) {
			JOptionPane.showMessageDialog(null, "SERVER AVVIATO", "SERVER", JOptionPane.INFORMATION_MESSAGE);
		}else if (s.equals("spento")) {
			JOptionPane.showMessageDialog(null, "SERVER SPENTO", "SERVER", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public JButton retButtonAvvia() {
		return this.buttonAvvio;
	}
	
	@Override
	public JButton retButtonSpegni() {
		return this.buttonSpegnimento;
	}
	
	public String retPsw() {
		char[] charPassword = txtPsw.getPassword();
		String password = String.valueOf(charPassword);
		return password;
	}
	

	@Override
	public List<String> txtInfoServer() {
		List<String> datiServer = new ArrayList<String>();
		datiServer.add(this.txtUsername.getText());
		datiServer.add(this.retPsw());
		datiServer.add(this.txtHost.getText());
		datiServer.add(this.txtPorta.getText());
		datiServer.add(this.txtNomeDB.getText());
		return datiServer;
	}

}

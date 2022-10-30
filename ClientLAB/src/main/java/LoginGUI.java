
import java.awt.*;
import javax.swing.*;

public class LoginGUI {
	
	private JPanel intestazione;
	
	private JPanel contenitorePrincipale;
	
	private ImageIcon immagineUser;
	private ImageIcon scalaUser; //immagine in scala da inserire
	
	private ImageIcon immaginePsw;
	private ImageIcon scalaPsw; //immagine in scala da inserire
	
	private JPanel panelTitolo;
	private JLabel labelTitolo;
	
	private JPanel panelUsername;
	private JLabel labelUsername;
	private JTextField textFieldUsername;
	
	private JPanel panelVuoto;
	private JLabel labelVuoto;
	
	private JPanel panelPsw;
	private JLabel labelPsw;
	private JPasswordField textFieldPsw;
	
	private JPanel panelBottone;
    private JButton buttonAccedi;
    
    private JPanel panelVuoto2;
	private JLabel labelVuoto2;
    
    private JPanel panelTitolo1;
	private JLabel labelTitolo1;
	
	private JPanel panelBottone1;
    private JButton buttonLoginRegistrati;
	
	public LoginGUI(int altezza, int larghezza, JPanel intestazione) {
		
		this.intestazione = intestazione;
		
		immagineUser = new ImageIcon("img/user.png");
		scalaUser = new ImageIcon(immagineUser.getImage().getScaledInstance(immagineUser.getIconWidth()/20, immagineUser.getIconHeight()/20, java.awt.Image.SCALE_SMOOTH)); //immagine in scala
		
		immaginePsw = new ImageIcon("img/password.png");
		scalaPsw = new ImageIcon(immaginePsw.getImage().getScaledInstance(immaginePsw.getIconWidth()/20, immaginePsw.getIconHeight()/20, java.awt.Image.SCALE_SMOOTH)); //immagine in scala
		
		
		//TITOLO
		this.panelTitolo = new JPanel();
		this.panelTitolo.setLayout(new GridLayout(1,1));
		this.labelTitolo = new JLabel("ACCEDI ALL'AREA PERSONALE:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		this.panelTitolo.add(this.labelTitolo);
		this.panelTitolo.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//SPAZIO VUOTO
		this.panelVuoto = new JPanel();
		this.panelVuoto.setLayout(new GridLayout(1,1));
		this.labelVuoto = new JLabel();
		this.labelVuoto.setHorizontalAlignment(JLabel.CENTER);
		this.labelVuoto.setVerticalAlignment(JLabel.CENTER);
		this.panelVuoto.add(labelVuoto);
		this.panelVuoto.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza

		
		//USERNAME
		this.panelUsername = new JPanel();
		this.panelUsername.setLayout(new GridLayout(1,2));
		this.labelUsername = new JLabel("Username:");
		this.labelUsername.setIcon(scalaUser);
		this.labelUsername.setIconTextGap(10); //distanza tra immagine e testo
		this.textFieldUsername= new JTextField("", 20); 
		this.panelUsername.add(this.labelUsername);
		this.panelUsername.add(this.textFieldUsername);
		this.panelUsername.setPreferredSize(new Dimension(800, 50));
		
	
		//PASSWORD
		this.panelPsw = new JPanel();
		this.panelPsw.setLayout(new GridLayout(1,2));
		this.labelPsw = new JLabel("Password:");
		this.labelPsw.setIcon(scalaPsw);
		this.labelPsw.setIconTextGap(10); //distanza tra immagine e testo
		this.textFieldPsw = new JPasswordField("", 20); 
		this.panelPsw.add(this.labelPsw);
		this.panelPsw.add(this.textFieldPsw);
		this.panelPsw.setPreferredSize(new Dimension(800, 50)); 
		
		//BOTTONE ACCEDI
		this.panelBottone = new JPanel();
		this.buttonAccedi = new JButton("ACCEDI");
		this.buttonAccedi.setName("ACCEDI");
		this.panelBottone.setPreferredSize(new Dimension(200, 50));
		this.buttonAccedi.setPreferredSize(new Dimension(200, 50)); 
		this.panelBottone.add(this.buttonAccedi);
		
		//SPAZIO VUOTO
		this.panelVuoto2 = new JPanel();
		this.panelVuoto2.setLayout(new GridLayout(1,1));
		this.labelVuoto2 = new JLabel();
		this.labelVuoto2.setHorizontalAlignment(JLabel.CENTER);
		this.labelVuoto2.setVerticalAlignment(JLabel.CENTER);
		this.panelVuoto2.add(labelVuoto2);
		this.panelVuoto2.setPreferredSize(new Dimension(700, 25)); //larghezza, altezza
		
		//TITOLO 1
		this.panelTitolo1 = new JPanel();
		this.panelTitolo1.setLayout(new GridLayout(1,1));
		this.labelTitolo1 = new JLabel("Non sei registrato?");
		this.labelTitolo1.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo1.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo1.setVerticalAlignment(JLabel.CENTER);
		this.panelTitolo1.add(this.labelTitolo1);
		this.panelTitolo1.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//BOTTONE REGISTRATI
		this.panelBottone1 = new JPanel();
		this.buttonLoginRegistrati = new JButton("REGISTRATI");
		this.buttonLoginRegistrati.setName("REGISTRATI-Login");
		this.panelBottone1.setPreferredSize(new Dimension(200, 60)); //dimensioni panel
		this.buttonLoginRegistrati.setPreferredSize(new Dimension(200, 50)); //dimensioni bottone
		//this.panelBottone1.setBackground(Colori.purple);
		this.panelBottone1.add(this.buttonLoginRegistrati);
	
		
		this.contenitorePrincipale = new JPanel();
		this.contenitorePrincipale.add(panelTitolo);
		this.contenitorePrincipale.add(panelVuoto);
		this.contenitorePrincipale.add(panelUsername);
		this.contenitorePrincipale.add(panelPsw);
		this.contenitorePrincipale.add(buttonAccedi);
		this.contenitorePrincipale.add(panelVuoto2);
		this.contenitorePrincipale.add(panelTitolo1);
		this.contenitorePrincipale.add(panelBottone1);
		
		
	}
	
	//ritorna intestazione della pagina
	public JPanel retIntestazione() {
		return this.intestazione;
	}

	//ritorna contenitore elementi
	public JPanel retContenitore() {
		return this.contenitorePrincipale;
	}

	//pulisce i campi di testo
	public void pulisciCampi() {
		this.textFieldUsername.setText("");
		this.textFieldPsw.setText("");
	}
	
	//ritorna username inserito
	public String retUsernameInserito() {
		return textFieldUsername.getText();
	}
	
	//ritorna un char di password inserita che viene convertito in stringa
	public String retPswInserita() {
		char[] charPassword = textFieldPsw.getPassword();
		String password = String.valueOf(charPassword);
		return password;
	}
	
	//riferimento a button accedi
	public JButton retButtonAccedi() {
		return this.buttonAccedi;
	}
	
	//riferimento al button registrati
	public JButton retButtonLoginRegistrati() {
		return this.buttonLoginRegistrati;
	}
	

}

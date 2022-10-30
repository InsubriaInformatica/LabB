import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class RegisterGUI {
	
	private JPanel intestazione;
	
	private JPanel contenitorePrincipale;
	
	private JPanel panelTitolo;
	private JLabel labelTitolo;
	
	private JPanel panelVuoto;
	private JLabel labelVuoto;
	
	private JPanel panelNome;
	private JLabel labelNome;
	private JTextField textFieldNome;
	
	private JPanel panelCognome;
	private JLabel labelCognome;
	private JTextField textFieldCognome;
	
	private JPanel panelCF;
	private JLabel labelCF;
	private JTextField textFieldCF;
	
	private JPanel panelEmail;
	private JLabel labelEmail;
	private JTextField textFieldEmail;
	
	private JPanel panelUsername;
	private JLabel labelUsername;
	private JTextField textFieldUsername;
	
	private JPanel panelPsw;
	private JLabel labelPsw;
	private JTextField textFieldPsw;
	
	private JPanel panelIdUnivoco;
	private JLabel labelIdUnivoco;
	private JTextField textFieldIdUnivoco;
	
	private JPanel panelBottone;
    private JButton buttonRegistra;
	
	
	public RegisterGUI(int altezza, int larghezza, JPanel intestazione) {
		
		this.intestazione = intestazione;
		
		//TITOLO
		this.panelTitolo = new JPanel();
		this.panelTitolo.setLayout(new GridLayout(1,1));
		this.labelTitolo = new JLabel("FORM DI REGISTRAZIONE:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		this.panelTitolo.add(this.labelTitolo);
		this.panelTitolo.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//PANEL PER SPAZIO
		this.panelVuoto = new JPanel();
		this.panelVuoto.setLayout(new GridLayout(1,1));
		this.labelVuoto = new JLabel();
		this.labelVuoto.setHorizontalAlignment(JLabel.CENTER);
		this.labelVuoto.setVerticalAlignment(JLabel.CENTER);
		this.panelVuoto.add(labelVuoto);
		this.panelVuoto.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//NOME 
		this.panelNome = new JPanel();
		this.panelNome.setLayout(new GridLayout(1,2));
		this.labelNome = new JLabel("Nome:");
		this.textFieldNome = new JTextField("", 20); 
		this.panelNome.add(this.labelNome);
		this.panelNome.add(this.textFieldNome);
		this.panelNome.setPreferredSize(new Dimension(600, 25));
		
		//COGNOME 
		this.panelCognome = new JPanel();
		this.panelCognome.setLayout(new GridLayout(1,2));
		this.labelCognome = new JLabel("Cognome:");
		this.textFieldCognome = new JTextField("", 20); 
		this.panelCognome.add(this.labelCognome);
		this.panelCognome.add(this.textFieldCognome);
		this.panelCognome.setPreferredSize(new Dimension(600, 25));
		
		//CODICE FISCALE 
		this.panelCF = new JPanel();
		this.panelCF.setLayout(new GridLayout(1,2));
		this.labelCF = new JLabel("Codice Fiscale:");
		this.textFieldCF = new JTextField("", 20); 
		this.textFieldCF.setName("CampoCF");
		this.panelCF.add(this.labelCF);
		this.panelCF.add(this.textFieldCF);
		this.panelCF.setPreferredSize(new Dimension(600, 25));
		
		//E-MAIL
		this.panelEmail = new JPanel();
		this.panelEmail.setLayout(new GridLayout(1,2));
		this.labelEmail = new JLabel("E-mail:");
		this.textFieldEmail= new JTextField("", 20); 
		this.panelEmail.add(this.labelEmail);
		this.panelEmail.add(this.textFieldEmail);
		this.panelEmail.setPreferredSize(new Dimension(600, 25));
		
		//USERNAME
		this.panelUsername = new JPanel();
		this.panelUsername.setLayout(new GridLayout(1,2));
		this.labelUsername = new JLabel("Username:");
		this.textFieldUsername= new JTextField("", 20); 
		this.panelUsername.add(this.labelUsername);
		this.panelUsername.add(this.textFieldUsername);
		this.panelUsername.setPreferredSize(new Dimension(600, 25));
		
		//PASSWORD
		this.panelPsw = new JPanel();
		this.panelPsw.setLayout(new GridLayout(1,2));
		this.labelPsw = new JLabel("Password:");
		this.textFieldPsw = new JTextField("", 20); 
		this.panelPsw.add(this.labelPsw);
		this.panelPsw.add(this.textFieldPsw);
		this.panelPsw.setPreferredSize(new Dimension(600, 25));
		
		//ID UNIVOCO
		this.panelIdUnivoco = new JPanel();
		this.panelIdUnivoco.setLayout(new GridLayout(1,2));
		this.labelIdUnivoco = new JLabel("ID Univoco:");
		this.textFieldIdUnivoco = new JTextField("", 20); 
		this.panelIdUnivoco.add(this.labelIdUnivoco);
		this.panelIdUnivoco.add(this.textFieldIdUnivoco);
		this.panelIdUnivoco.setPreferredSize(new Dimension(600, 25));
		
		//BOTTONE REGISTRAZIONE
		this.panelBottone = new JPanel();
		this.buttonRegistra = new JButton("REGISTRATI");
		this.buttonRegistra.setName("REGISTRATI");
		this.panelBottone.setPreferredSize(new Dimension(500, 60));
		this.buttonRegistra.setPreferredSize(new Dimension(200, 50)); 
		this.panelBottone.add(this.buttonRegistra);

		this.contenitorePrincipale = new JPanel();
		this.contenitorePrincipale.add(panelTitolo);
		this.contenitorePrincipale.add(panelVuoto);
		this.contenitorePrincipale.add(panelNome);
		this.contenitorePrincipale.add(panelCognome);
		this.contenitorePrincipale.add(panelCF);
		this.contenitorePrincipale.add(panelEmail);
		this.contenitorePrincipale.add(panelUsername);
		this.contenitorePrincipale.add(panelPsw);
		this.contenitorePrincipale.add(panelIdUnivoco);
		this.contenitorePrincipale.add(panelBottone);
		
	}
	
	//ritorna intestazione della pagina
	public JPanel retIntestazione() {
		return this.intestazione;
	}

	//ritorna contenitore elementi
	public JPanel retContenitore() {
		return this.contenitorePrincipale;
	}

	//pulisce campi
	public void pulisciView() {
		this.textFieldNome.setText("");
		this.textFieldCognome.setText("");
		this.textFieldCF.setText("");
		this.textFieldEmail.setText("");
		this.textFieldUsername.setText("");
		this.textFieldPsw.setText("");
		this.textFieldIdUnivoco.setText("");
	}
	
	//ritorna il bottone per registrare 
	public JButton retButtonRegistraVaccinato() {
		return this.buttonRegistra;
	}
	
	public String retNome() {
		return textFieldNome.getText();
	}
	
	public String retCognome() {
		return textFieldCognome.getText();
	}
	
	public String retCF() {
		return textFieldCF.getText();
	}
	
	public String retEmail() {
		return textFieldEmail.getText();
	}
		
	
	public String retUsername() {
		return textFieldUsername.getText();
	}
		
	
	public String retPsw() {
		return textFieldPsw.getText();
	}
	
	public String retIDUnivoco() {
		return textFieldIdUnivoco.getText();
	}
		
		
		

}

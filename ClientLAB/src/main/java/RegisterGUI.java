//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * 
 * @author Enrico Brullo
 *
 */
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
	private JPasswordField textFieldPsw;
	
	private JPanel panelIdUnivoco;
	private JLabel labelIdUnivoco;
	private JTextField textFieldIdUnivoco;
	
	private JPanel panelVuoto1;
	private JLabel labelVuoto1;
	
	private JPanel panelBottone;
    private JButton buttonRegistra;
	
	/**
	 * Costruttore della classe
	 * @param altezza
	 * @param larghezza
	 * @param intestazione
	 */
	public RegisterGUI(int altezza, int larghezza, JPanel intestazione) {
		
		this.intestazione = intestazione;
		
		Border bordo = BorderFactory.createLineBorder(Colori.light_grey, 1); //crea bordo
		
		//TITOLO
		this.panelTitolo = new JPanel();
		this.panelTitolo.setLayout(new GridLayout(1,1));
		this.panelTitolo.setBackground(Colori.purple);
		this.labelTitolo = new JLabel("FORM DI REGISTRAZIONE:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		this.labelTitolo.setForeground(Colori.arancione);
		this.panelTitolo.add(this.labelTitolo);
		this.panelTitolo.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//PANEL PER SPAZIO
		this.panelVuoto = new JPanel();
		this.panelVuoto.setLayout(new GridLayout(1,1));
		this.panelVuoto.setBackground(Colori.purple);
		this.labelVuoto = new JLabel();
		this.labelVuoto.setHorizontalAlignment(JLabel.CENTER);
		this.labelVuoto.setVerticalAlignment(JLabel.CENTER);
		this.panelVuoto.add(labelVuoto);
		this.panelVuoto.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//NOME 
		this.panelNome = new JPanel();
		this.panelNome.setLayout(new GridLayout(1,2));
		this.panelNome.setBackground(Colori.purple);
		this.labelNome = new JLabel("Nome:");
		this.labelNome.setForeground(Colori.light_grey);
		this.textFieldNome = new JTextField("", 20); 
		this.panelNome.add(this.labelNome);
		this.panelNome.add(this.textFieldNome);
		this.panelNome.setPreferredSize(new Dimension(600, 25));
		
		//COGNOME 
		this.panelCognome = new JPanel();
		this.panelCognome.setLayout(new GridLayout(1,2));
		this.panelCognome.setBackground(Colori.purple);
		this.labelCognome = new JLabel("Cognome:");
		this.labelCognome.setForeground(Colori.light_grey);
		this.textFieldCognome = new JTextField("", 20); 
		this.panelCognome.add(this.labelCognome);
		this.panelCognome.add(this.textFieldCognome);
		this.panelCognome.setPreferredSize(new Dimension(600, 25));
		
		//CODICE FISCALE 
		this.panelCF = new JPanel();
		this.panelCF.setLayout(new GridLayout(1,2));
		this.panelCF.setBackground(Colori.purple);
		this.labelCF = new JLabel("Codice Fiscale:");
		this.labelCF.setForeground(Colori.light_grey);
		this.textFieldCF = new JTextField("", 20); 
		this.textFieldCF.setName("CampoCF");
		this.panelCF.add(this.labelCF);
		this.panelCF.add(this.textFieldCF);
		this.panelCF.setPreferredSize(new Dimension(600, 25));
		
		//E-MAIL
		this.panelEmail = new JPanel();
		this.panelEmail.setLayout(new GridLayout(1,2));
		this.panelEmail.setBackground(Colori.purple);
		this.labelEmail = new JLabel("E-mail:");
		this.labelEmail.setForeground(Colori.light_grey);
		this.textFieldEmail= new JTextField("", 20); 
		this.panelEmail.add(this.labelEmail);
		this.panelEmail.add(this.textFieldEmail);
		this.panelEmail.setPreferredSize(new Dimension(600, 25));
		
		//USERNAME
		this.panelUsername = new JPanel();
		this.panelUsername.setLayout(new GridLayout(1,2));
		this.panelUsername.setBackground(Colori.purple);
		this.labelUsername = new JLabel("Username:");
		this.labelUsername.setForeground(Colori.light_grey);
		this.textFieldUsername= new JTextField("", 20); 
		this.panelUsername.add(this.labelUsername);
		this.panelUsername.add(this.textFieldUsername);
		this.panelUsername.setPreferredSize(new Dimension(600, 25));
		
		//PASSWORD
		this.panelPsw = new JPanel();
		this.panelPsw.setLayout(new GridLayout(1,2));
		this.panelPsw.setBackground(Colori.purple);
		this.labelPsw = new JLabel("Password:");
		this.labelPsw.setForeground(Colori.light_grey);
		this.textFieldPsw = new JPasswordField("", 20); 
		this.panelPsw.add(this.labelPsw);
		this.panelPsw.add(this.textFieldPsw);
		this.panelPsw.setPreferredSize(new Dimension(600, 25));
		
		//ID UNIVOCO
		this.panelIdUnivoco = new JPanel();
		this.panelIdUnivoco.setLayout(new GridLayout(1,2));
		this.panelIdUnivoco.setBackground(Colori.purple);
		this.labelIdUnivoco = new JLabel("ID Univoco:");
		this.labelIdUnivoco.setForeground(Colori.light_grey);
		this.textFieldIdUnivoco = new JTextField("", 20); 
		this.panelIdUnivoco.add(this.labelIdUnivoco);
		this.panelIdUnivoco.add(this.textFieldIdUnivoco);
		this.panelIdUnivoco.setPreferredSize(new Dimension(600, 25));
		
		//PANEL PER SPAZIO
        this.panelVuoto1 = new JPanel();
        this.panelVuoto1.setLayout(new GridLayout(1,1));
        this.panelVuoto1.setBackground(Colori.purple);
        this.labelVuoto1 = new JLabel();
        this.labelVuoto1.setHorizontalAlignment(JLabel.CENTER);
        this.labelVuoto1.setVerticalAlignment(JLabel.CENTER);
        this.panelVuoto1.add(labelVuoto1);
        this.panelVuoto1.setPreferredSize(new Dimension(700, 25)); //larghezza, altezza
		
		//BOTTONE REGISTRAZIONE
		this.panelBottone = new JPanel();
		this.panelBottone.setBackground(Colori.purple);
		this.buttonRegistra = new JButton("REGISTRATI");
		this.buttonRegistra.setName("CONFERMA-REGISTRAZIONE");
		this.buttonRegistra.setBorder(bordo);
		this.buttonRegistra.setBackground(Colori.arancione);
		this.buttonRegistra.setForeground(Colori.light_grey);
		this.panelBottone.setPreferredSize(new Dimension(500, 60));
		this.buttonRegistra.setPreferredSize(new Dimension(200, 50)); 
		this.panelBottone.add(this.buttonRegistra);

		this.contenitorePrincipale = new JPanel();
		this.contenitorePrincipale.setBackground(Colori.purple);
		this.contenitorePrincipale.add(panelTitolo);
		this.contenitorePrincipale.add(panelVuoto);
		this.contenitorePrincipale.add(panelNome);
		this.contenitorePrincipale.add(panelCognome);
		this.contenitorePrincipale.add(panelCF);
		this.contenitorePrincipale.add(panelEmail);
		this.contenitorePrincipale.add(panelUsername);
		this.contenitorePrincipale.add(panelPsw);
		this.contenitorePrincipale.add(panelIdUnivoco);
		this.contenitorePrincipale.add(panelVuoto1);
		this.contenitorePrincipale.add(panelBottone);
		
	}
	
	/**
	 * Metodo che ritorna intestazione della pagina
	 * @return
	 */
	public JPanel retIntestazione() {
		return this.intestazione;
	}

	/**
	 * Metodo che ritorna contenitore elementi
	 * @return
	 */
	public JPanel retContenitore() {
		return this.contenitorePrincipale;
	}

	/**
	 * Metodo che pulisce campi
	 */
	public void pulisciView() {
		this.textFieldNome.setText("");
		this.textFieldCognome.setText("");
		this.textFieldCF.setText("");
		this.textFieldEmail.setText("");
		this.textFieldUsername.setText("");
		this.textFieldPsw.setText("");
		this.textFieldIdUnivoco.setText("");
	}
	
	/**
	 * Metodo che ritorna il bottone per registrare 
	 * @return
	 */
	public JButton retButtonRegistrati() {
		return this.buttonRegistra;
	}
	
	/**
	 * Metodo che ritorna il nome
	 * @return
	 */
	public String retNome() {
		return textFieldNome.getText();
	}
	
	/**
	 * Metodo che ritorna il cognome
	 * @return
	 */
	public String retCognome() {
		return textFieldCognome.getText();
	}
	
	/**
	 * Metodo che ritorna il codice fiscale
	 * @return
	 */
	public String retCF() {
		return textFieldCF.getText();
	}
	
	/**
	 * Metodo che ritorna l'email
	 * @return
	 */
	public String retEmail() {
		return textFieldEmail.getText();
	}
		
	/**
	 * Metodo che ritorna l'username
	 * @return
	 */
	public String retUsername() {
		return textFieldUsername.getText();
	}
		
	/**
	 * Metodo che ritorna la password
	 * @return
	 */
	public String retPsw() {
		char[] charPassword = textFieldPsw.getPassword();
		String password = String.valueOf(charPassword);
		return password;
	}
	
	/**
	 * Metodo che ritorna l'id univoco
	 * @return
	 */
	public String retIDUnivoco() {
		return textFieldIdUnivoco.getText();
	}
		
}

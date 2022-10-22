
import javax.swing.*;
import java.awt.*;

public class RegistraCentroGUI {
	
	private JPanel intestazione;
	private JLabel titolo;
	
	private JPanel contenitorePrincipale;
	
	private JPanel panelNomeCentro;
	private JLabel labelNomeCentro;
	private JTextField textFieldNomeCentro;
	
	private JPanel panelQualificatore;
	private JRadioButton radioButtonVia;
    private JRadioButton radioButtonViale;
    private JRadioButton radioButtonPiazza;
    private ButtonGroup buttonGroupViaVialePiazza;
    
    private JPanel panelIndirizzo;
	private JLabel labelIndirizzo;
	private JTextField textFieldIndirizzo;
	
	private JPanel panelNumeroCivico;
	private JLabel labelNumeroCivico;
    private JTextField textFieldNumeroCivico;
    
	private JPanel panelComune;
    private JLabel labelComune;
    private JTextField textFieldComune;
    
    private JPanel panelProvincia;
    private JLabel labelProvincia;
    private JTextField textFieldProvincia;
    
    private JPanel panelCap;
    private JLabel labelCap;
    private JTextField textFieldCap;
	
	private JPanel sceltaTipologiaCentro;
	private JLabel labelTipoCentro;
	private JComboBox<String> tipologiaCentro;
	
	private JPanel panelBottone;
	private JButton buttonRegistra;
	
	public RegistraCentroGUI(int altezza, int larghezza, JPanel intestazione){
		
		this.intestazione = intestazione;
		
		this.panelNomeCentro = new JPanel();
		this.panelNomeCentro.setLayout(new GridLayout(1,2));
		this.labelNomeCentro = new JLabel("Nome centro:");
		this.textFieldNomeCentro = new JTextField("", 10);
		this.panelNomeCentro.add(this.labelNomeCentro);
		this.panelNomeCentro.add(this.textFieldNomeCentro);
		this.panelNomeCentro.setPreferredSize(new Dimension(altezza/2, larghezza/100*7));
		
		this.panelBottone = new JPanel();
		this.buttonRegistra = new JButton("REGISTRA");
		this.buttonRegistra.setName("REGISTRA");
		this.panelBottone.setPreferredSize(new Dimension(altezza/2, larghezza/100*7));
		this.panelBottone.add(this.buttonRegistra);
		
		//CONTENITORE PRINCIPALE
		this.contenitorePrincipale = new JPanel();
		this.contenitorePrincipale.add(panelNomeCentro);
		this.contenitorePrincipale.add(panelBottone);
		
	}
	
	public void pulisciView() {
		
	}

	//ritorna intestazione della pagina
	public JPanel retIntestazione() {
		return this.intestazione;
	}

	//ritorna contenitore elementi
	public JPanel retContenitore() {
		return this.contenitorePrincipale;
	}
	
	

}

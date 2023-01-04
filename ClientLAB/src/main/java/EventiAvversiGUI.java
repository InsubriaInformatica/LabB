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
 * Classe che implementa la GUI degli eventi avversi
 * @author Enrico Brullo
 *
 */
public class EventiAvversiGUI {
	
	private JPanel intestazione;
	
	private JPanel contenitorePrincipale;
	
	private JPanel panelTitolo;
	private JLabel labelTitolo;
	
	private JPanel panelVuoto;
	private JLabel labelVuoto;
	
	private JPanel panelVuoto2;
	private JLabel labelVuoto2;
	
	private JPanel panelVuoto3;
	private JLabel labelVuoto3;
	
	private JPanel panelVuoto4;
	private JLabel labelVuoto4;
	
	private JPanel panelTipoEvento;
	private JLabel labelTipoEvento;
	
	private JPanel panelSeverita;
	private JLabel labelSeverita;
	
	private JPanel panelCampoSeverita;
	private JComboBox<String> Severita;
	
	private JPanel panelNote;
	private JLabel labelNote;
	
	private JPanel panelCampoNote;
	private JTextField note;
	
	private JPanel contenitoreEventi;
	private JRadioButton radioButtonMalDiTesta;
    private JRadioButton radioButtonFebbre;
    private JRadioButton radioButtonDolori;
    private JRadioButton radioButtonLinfoadenopatia;
    private JRadioButton radioButtonTachicardia;
    private JRadioButton radioButtonCrisi;
    private ButtonGroup buttonGroupEventi;
    
    private JPanel panelBottone;
    private JButton buttonConfermaEA;
	

    /**
     * Costruttore della classe
     * @param altezza
     * @param larghezza
     * @param intestazione
     */
	public EventiAvversiGUI(int altezza, int larghezza, JPanel intestazione) {
		
		this.intestazione = intestazione;
		
		Border bordo = BorderFactory.createLineBorder(Colori.light_grey, 1); //crea bordo
		
		//TITOLO
		this.panelTitolo = new JPanel();
		this.panelTitolo.setLayout(new GridLayout(1,1));
		this.panelTitolo.setBackground(Colori.purple);
		this.labelTitolo = new JLabel("SEGNALA EVENTO AVVERSO:");
		this.labelTitolo.setForeground(Colori.arancione);
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		this.panelTitolo.add(this.labelTitolo);
		this.panelTitolo.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//SPAZIO
		this.panelVuoto = new JPanel();
		this.panelVuoto.setLayout(new GridLayout(1,1));
		this.panelVuoto.setBackground(Colori.purple);
		this.labelVuoto = new JLabel();
		this.panelVuoto.add(labelVuoto);
		this.panelVuoto.setPreferredSize(new Dimension(800, 22)); //larghezza, altezza
		
		//TITOLO:TIPO EVENTO
		this.panelTipoEvento = new JPanel();
		this.panelTipoEvento.setLayout(new GridLayout(1,1));
		this.panelTipoEvento.setBackground(Colori.purple);
		this.labelTipoEvento = new JLabel("Tipo Evento");
		this.labelTipoEvento.setFont(new Font("Arial", Font.BOLD, 18));
		this.labelTipoEvento.setForeground(Colori.light_grey);
		this.panelTipoEvento.add(labelTipoEvento);
		this.panelTipoEvento.setPreferredSize(new Dimension(800, 35)); //larghezza, altezza
		
		// SCELTA EVENTI
		this.contenitoreEventi = new JPanel();
		this.contenitoreEventi.setLayout(new GridLayout(2,3));
		this.contenitoreEventi.setBackground(Colori.purple);
		this.contenitoreEventi.setPreferredSize(new Dimension(800, 50));
		
		this.radioButtonMalDiTesta = new JRadioButton();
		this.radioButtonMalDiTesta.setText("MAL DI TESTA");
		this.radioButtonMalDiTesta.setBackground(Colori.purple);
		this.radioButtonMalDiTesta.setForeground(Colori.light_grey);
		this.radioButtonFebbre = new JRadioButton();
		this.radioButtonFebbre.setText("FEBBRE");
		this.radioButtonFebbre.setBackground(Colori.purple);
		this.radioButtonFebbre.setForeground(Colori.light_grey);
		this.radioButtonDolori = new JRadioButton();
		this.radioButtonDolori.setText("DOLORI MUSCOLARI/ARTICOLARI");
		this.radioButtonDolori.setBackground(Colori.purple);
		this.radioButtonDolori.setForeground(Colori.light_grey);
		
		this.radioButtonLinfoadenopatia = new JRadioButton();
		this.radioButtonLinfoadenopatia.setText("LINFOADENOPATIA");
		this.radioButtonLinfoadenopatia.setBackground(Colori.purple);
		this.radioButtonLinfoadenopatia.setForeground(Colori.light_grey);
		this.radioButtonTachicardia = new JRadioButton();
		this.radioButtonTachicardia.setText("TACHICARDIA");
		this.radioButtonTachicardia.setBackground(Colori.purple);
		this.radioButtonTachicardia.setForeground(Colori.light_grey);
		this.radioButtonCrisi = new JRadioButton();
		this.radioButtonCrisi.setText("CRISI IPERTENSIVA");
		this.radioButtonCrisi.setBackground(Colori.purple);
		this.radioButtonCrisi.setForeground(Colori.light_grey);
		
		this.buttonGroupEventi = new ButtonGroup();
	
		this.buttonGroupEventi.add(radioButtonMalDiTesta);
        this.buttonGroupEventi.add(radioButtonFebbre);
        this.buttonGroupEventi.add(radioButtonDolori);
        this.buttonGroupEventi.add(radioButtonLinfoadenopatia);
        this.buttonGroupEventi.add(radioButtonTachicardia);
        this.buttonGroupEventi.add(radioButtonCrisi);
        
        
		this.contenitoreEventi.add(radioButtonMalDiTesta);
		this.contenitoreEventi.add(radioButtonFebbre);
		this.contenitoreEventi.add(radioButtonDolori);
		this.contenitoreEventi.add(radioButtonLinfoadenopatia);
		this.contenitoreEventi.add(radioButtonTachicardia);
		this.contenitoreEventi.add(radioButtonCrisi);
		
		//SPAZIO
		this.panelVuoto2 = new JPanel();
		this.panelVuoto2.setLayout(new GridLayout(1,1));
		this.panelVuoto2.setBackground(Colori.purple);
		this.labelVuoto2 = new JLabel();
		this.panelVuoto2.add(labelVuoto2);
		this.panelVuoto2.setPreferredSize(new Dimension(800, 15)); //larghezza, altezza
		
		//TITOLO:SEVERITA
		this.panelSeverita = new JPanel();
		this.panelSeverita.setLayout(new GridLayout(1,1));
		this.panelSeverita.setBackground(Colori.purple);
		this.labelSeverita = new JLabel("Severità (da 1 a 5)");
		this.labelSeverita.setFont(new Font("Arial", Font.BOLD, 18));
		this.labelSeverita.setForeground(Colori.light_grey);
		this.panelSeverita.add(labelSeverita);
		this.panelSeverita.setPreferredSize(new Dimension(800, 20)); //larghezza, altezza
		
		//CAMPO SEVERITA
		this.panelCampoSeverita = new JPanel();
		this.panelCampoSeverita.setLayout(new GridLayout(1,1));
		this.panelCampoSeverita.setBackground(Colori.purple);
		this.Severita = new JComboBox<String>();
		this.Severita.addItem("1");
		this.Severita.addItem("2");
		this.Severita.addItem("3");
		this.Severita.addItem("4");
		this.Severita.addItem("5");
		this.panelCampoSeverita.add(Severita);
		this.panelCampoSeverita.setPreferredSize(new Dimension(800, 35)); //larghezza, altezza
		
		//SPAZIO
		this.panelVuoto3 = new JPanel();
		this.panelVuoto3.setLayout(new GridLayout(1,1));
		this.panelVuoto3.setBackground(Colori.purple);
		this.labelVuoto3 = new JLabel();
		this.panelVuoto3.add(labelVuoto3);
		this.panelVuoto3.setPreferredSize(new Dimension(800, 15)); //larghezza, altezza
		
		//TITOLO: NOTE OPZIONALI
		this.panelNote = new JPanel();
		this.panelNote.setLayout(new GridLayout(1,1));
		this.panelNote.setBackground(Colori.purple);
		this.labelNote = new JLabel("Note Opzionali (256 caratteri max)");
		this.labelNote.setFont(new Font("Arial", Font.BOLD, 18));
		this.labelNote.setForeground(Colori.light_grey);
		this.panelNote.add(labelNote);
		this.panelNote.setPreferredSize(new Dimension(800, 35)); //larghezza, altezza
		
		//CAMPO NOTE OPZIONALI
		this.panelCampoNote = new JPanel();
		this.panelCampoNote.setLayout(new GridLayout(1,1));
		this.panelCampoNote.setBackground(Colori.purple);
		this.note = new JTextField ("", 256);
		this.panelCampoNote.add(note);
		this.panelCampoNote.setPreferredSize(new Dimension(800, 35)); //larghezza, altezza
		
		//SPAZIO
		this.panelVuoto4 = new JPanel();
		this.panelVuoto4.setLayout(new GridLayout(1,1));
		this.panelVuoto4.setBackground(Colori.purple);
		this.labelVuoto4 = new JLabel();
		this.panelVuoto4.add(labelVuoto4);
		this.panelVuoto4.setPreferredSize(new Dimension(800, 15)); //larghezza, altezza
		
		//BOTTONE CONFERMA
	    this.panelBottone = new JPanel();
	    this.panelBottone.setBackground(Colori.purple);
		this.buttonConfermaEA = new JButton("CONFERMA EVENTO AVVERSO");
		this.buttonConfermaEA.setName("CONFERMA EVENTO AVVERSO");
		this.buttonConfermaEA.setBackground(Colori.arancione);
		this.buttonConfermaEA.setForeground(Colori.light_grey);
		this.buttonConfermaEA.setBorder(bordo);
		this.panelBottone.setPreferredSize(new Dimension(500, 60));
		this.buttonConfermaEA.setPreferredSize(new Dimension(225, 50)); 
		this.panelBottone.add(this.buttonConfermaEA);
		
		
		contenitorePrincipale = new JPanel();
		this.contenitorePrincipale.setBackground(Colori.purple);
		this.contenitorePrincipale.add(panelTitolo);
		this.contenitorePrincipale.add(panelVuoto);
		this.contenitorePrincipale.add(panelTipoEvento);
		this.contenitorePrincipale.add(contenitoreEventi);
		this.contenitorePrincipale.add(panelVuoto2);
		this.contenitorePrincipale.add(panelSeverita);
		this.contenitorePrincipale.add(panelCampoSeverita);
		this.contenitorePrincipale.add(panelVuoto3);
		this.contenitorePrincipale.add(panelNote);
		this.contenitorePrincipale.add(panelCampoNote);
		this.contenitorePrincipale.add(panelVuoto4);
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
	 * Metodo che pulisce i campi
	 */
	public void pulisciCampi() {
		this.radioButtonMalDiTesta.setSelected(true);
		this.radioButtonFebbre.setSelected(false);
		this.radioButtonDolori.setSelected(false);
		this.radioButtonLinfoadenopatia.setSelected(false);
		this.radioButtonTachicardia.setSelected(false);
		this.radioButtonCrisi.setSelected(false);
		this.Severita.setSelectedIndex(0);
		this.note.setText("");
	}
	
	/**
	 * Metodo che ritorna dai radio button il tipo di evento selezionato
	 * @return
	 */
	public String retTipoEventoInserito() {
		String evento = " ";
		
		if(radioButtonMalDiTesta.isSelected()) {
			evento = "Mal di Testa";
		}
		
		else if(radioButtonFebbre.isSelected()) {
			evento = "Febbre";
		}
		
		else if(radioButtonDolori.isSelected()) {
			evento = "Dolori Muscolari/Articolari";
		}
		
		else if(radioButtonLinfoadenopatia.isSelected()) {
			evento = "Linfoadenopatia";
		}
		
		else if(radioButtonTachicardia.isSelected()) {
			evento = "Tachicardia";
		}
		
		else if(radioButtonCrisi.isSelected()) {
			evento = "Crisi Ipertensiva";
		}
		
		return evento;
		
	}
	
	/**
	 * Metodo che ritorna dalla combo box la severità selezionata
	 * @return
	 */
	public Object retSeveritaSelezionata() {
		return this.Severita.getSelectedItem();
	}
	
	/**
	 * Metodo che ritorna le note inserite 
	 * @return
	 */
	public String retNote(){
		return this.note.getText();
	}
	
	/**
	 * Metodo che ritorna il bottone per inserire evento avverso
	 * @return
	 */
	public JButton retButtonInserisciEA() {
		return this.buttonConfermaEA;
	}	
	
}

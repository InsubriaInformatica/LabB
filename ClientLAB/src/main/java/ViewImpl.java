import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

//questa classe gestisce tutte le componenti grafiche dell'applicazione, aggiornanando anche i singoli elementi
public class ViewImpl extends JFrame implements View{
	private static final long serialVersionUID = 1L;

	private String viewAttuale;
	//private Dimension size;
	private int larghezza;
	private int altezza;
	
	private final short FRAME_WIDTH = 900;
	private final short FRAME_HEIGHT = 635;
	
	//panel intestazione uguale  a tutte le schermate dell'applicazione --> passo come parametro alla creazione delle varie schermate
	private JPanel intestazione;
	private JLabel titolo;
	
	private ImageIcon immagine;
	private ImageIcon back;
	private JButton indietro;
	
	
	//scelta tipo utente 
	private SceltaUtenteGUI viewSceltaUtente;
	//schermata operatore
	private OperatoreGUI viewOperatore;
	//schermata operatore
	private CittadinoGUI viewCittadino;
	//schermata registrazione centro
	private RegistraCentroGUI viewRegistraCentro;
	
	//costruttore che realizza la view
	public ViewImpl() {
		
		//FRAME
		this.viewAttuale = null;
		//this.size = Toolkit.getDefaultToolkit().getScreenSize(); //dimensione schermo
		//this.larghezza = this.size.width/10*5;
		//this.altezza = this.size.height/10*5;
		//this.setPreferredSize(new Dimension(altezza/2, larghezza/10*7)); //setta dimensioni schermata
		this.setTitle("VACCINIAMO");
		this.setLayout(null);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setResizable(false);
		
		/////////INIZIO INTESTAZIONE--> comune a tutti 
		
		this.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setLayout(new BorderLayout());

		Border bordo = BorderFactory.createLineBorder(Color.RED, 2); //crea bordo
		back = new ImageIcon("img/indietro.png");
		ImageIcon scalaBack = new ImageIcon(back.getImage().getScaledInstance(back.getIconWidth()/20*2, back.getIconHeight()/20*2, java.awt.Image.SCALE_SMOOTH)); //immagine in scala
		
		//tasto indietro
		this.indietro = new JButton("INDIETRO");
		this.indietro.setName("INDIETRO");
		this.indietro.setFont(new Font("Arial", Font.BOLD, 10));
		this.indietro.setIcon(scalaBack);
		this.indietro.setHorizontalTextPosition(JButton.CENTER);
		this.indietro.setVerticalTextPosition(JButton.TOP);
		this.indietro.setIconTextGap(10); //distanza tra immagine e testo
		//this.indietro.setBorder(bordo);
		
		this.intestazione = new JPanel(); //inizializza contenitore intestazione
		this.intestazione.setLayout(new BorderLayout());
		this.intestazione.setPreferredSize(new Dimension(180, 180)); //size panel 
		this.intestazione.setOpaque(true);
		this.intestazione.setBackground(Color.WHITE);
		
		this.immagine = new ImageIcon("img/fotoprova.png"); // ../ serve per il jar
		
		
		//TITOLO
		this.titolo = new JLabel(new ImageIcon(immagine.getImage().getScaledInstance(immagine.getIconWidth()/20*4, immagine.getIconHeight()/20*4, java.awt.Image.SCALE_SMOOTH)));
		titolo.setText("VACCINIAMO");
		//titolo.setIcon(immagine);
		titolo.setHorizontalTextPosition(JLabel.CENTER); //setta il testo DX,CX,SX rispetto a immagine
		titolo.setVerticalTextPosition(JLabel.TOP); //setta il testo TOP,CX,BOTTOM rispetto a immagine
		titolo.setFont(new Font("MV Boli", Font.PLAIN, 30));
		titolo.setForeground(Color.RED); //colore testo
		titolo.setBorder(bordo); //aggiunge bordo
		
		this.intestazione.add(this.titolo, BorderLayout.CENTER); //aggiungi titolo
		this.intestazione.add(this.indietro, BorderLayout.EAST); //aggiungi bottono indietro
		
		//////////FINE INTESTAZIONE
		
		//tipo utente 
		this.viewSceltaUtente = new SceltaUtenteGUI(altezza,larghezza, this.intestazione);
		//operatore
		this.viewOperatore = new OperatoreGUI(altezza,larghezza, this.intestazione);
		//cittadino
		this.viewCittadino = new CittadinoGUI(altezza,larghezza, this.intestazione);
		//registra centro vaccinale
		this.viewRegistraCentro = new RegistraCentroGUI(altezza,larghezza, this.intestazione);
		
		this.mostraSceltaUtenteView(); //mostra a video
	}
	
	//METODI 
	
	//mostra gli elementi per la view "sceltaUtente"
	private void mostraSceltaUtenteView() {
		
		this.setVisible(false); //visibilità panel
		this.getContentPane().removeAll(); //rimuove contenuto precedente
		this.getBack().setVisible(false); //mostra tasto indietro
		this.getContentPane().add(this.viewSceltaUtente.retIntestazione(), BorderLayout.PAGE_START); //aggiunge al panel intestazione
		this.getContentPane().add(this.viewSceltaUtente.retContenitore(), BorderLayout.CENTER); //aggiunge al panel corpo schermata
		this.setVisible(true);
		this.viewAttuale = "sceltaUtenteView"; //imposta la schermata attuale
	}
	
	//mostra gli elementi per la view "operatore"
	private void mostraViewOperatore() {
		
		this.setVisible(false); //visibilità panel
		this.getContentPane().removeAll(); //rimuove contenuto precedente
		this.getBack().setVisible(true); //mostra tasto indietro
		this.getContentPane().add(this.viewOperatore.retIntestazione(), BorderLayout.PAGE_START); //aggiunge al panel intestazione
		this.getContentPane().add(this.viewOperatore.retContenitore(), BorderLayout.CENTER); //aggiunge al panel corpo schermata
		this.setVisible(true);
		this.viewAttuale = "viewOperatore"; //imposta la schermata attuale
	}
	
	//mostra elementi per la view "cittadino"
	private void mostraViewCittadino() {
		
		this.setVisible(false);
		this.getContentPane().removeAll();
		this.getBack().setVisible(true); //mostra tasto indietro
		this.getContentPane().add(this.viewCittadino.retIntestazione(), BorderLayout.PAGE_START); //aggiunge al panel intestazione
		this.getContentPane().add(this.viewCittadino.retContenitore(), BorderLayout.CENTER); //aggiunge al panel corpo schermata
		this.setVisible(true);
		this.viewAttuale = "viewCittadino"; //imposta la schermata attuale
	}
	
	//mostra elementi per la view "registra centro vaccinale"
	private void mostraViewRegistraCentro() {
		
		this.setVisible(false);
		this.getContentPane().removeAll();
		this.getBack().setVisible(true); //mostra tasto indietro
		this.viewRegistraCentro.pulisciView(); //pulisce tutte caselle
		this.getContentPane().add(this.viewRegistraCentro.retIntestazione(), BorderLayout.PAGE_START);
		this.getContentPane().add(this.viewRegistraCentro.retContenitore(), BorderLayout.CENTER);
		this.setVisible(true);
		this.viewAttuale = "registraNuovoCentro";
	}
	
	//metodo che riceve dati del model e aggiorna in base al componente che ha generato evento
	//source --> valore riferito al componente origine che ha generato evento
	//dati --> con cui aggiornare componenti view
	//flagerrore --> booleano per indicare se ci sono errori
	public void updateView(Object source, Object dati, boolean flagErrore) {
		
		String buttonOrigine = (String) source;
		
		//IMPLEMENTA FUNZIONALITA ERRORE
		
		if(buttonOrigine.equals("INDIETRO")) {
			
			if(this.viewAttuale.equals("viewOperatore") || this.viewAttuale.equals("viewCittadino")) {
				mostraSceltaUtenteView(); //torna indietro alla schermata
			}
			
			if(this.viewAttuale.equals("registraNuovoCentro")) {
				mostraViewOperatore(); //torna alla schermata dell'operatore
			}
		}
		
		if(buttonOrigine.equals("OPERATORE")) {
			mostraViewOperatore(); //va alla schermata dell'operatore
		}
		
		if(buttonOrigine.equals("CITTADINO")) {
			mostraViewCittadino(); //va alla schermata cittadino
		}
		
		if(buttonOrigine.equals("REGISTRA NUOVO CENTRO")) {
			mostraViewRegistraCentro(); //va alla schermata registrazione centro vaccinale
		}
		
	}

	//cattura le funzionalità dei vari bottoni
	public JButton[] getBottoniFunzionalita() {
		JButton[] ret = new JButton[2];
		ret[0] = this.viewOperatore.retButtonRegistraCentro();
		ret[1] = this.viewOperatore.retButtonRegistraVaccinato();
		return ret;
	}

	//metodo che ritorna riferimento bottone indietro
	public JButton getBack() {
		return this.indietro;
	}

	//restituisce i riferimenti dei button alla scelta del tipo di utente
	public JButton[] getSceltaTipoUtente() {
		JButton[] ret = new JButton[2]; //bottoni usati con controller per eventi
		ret[0] = this.viewSceltaUtente.retButtonOperatore();
		ret[1] = this.viewSceltaUtente.retButtonCittadino();
		return ret;
	}

	public JButton getCercaInfoCentriVaccinali() {
		// TODO Auto-generated method stub
		return null;
	}

	public JComboBox boxSceltaCentroGetInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public JButton getBottoneAggiungiNuovoCentro() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDatiNomeCentroPerConsultareInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getDatiComuneTipologiaPerConsultareInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getDatiRegistraNuovoCentro() {
		// TODO Auto-generated method stub
		return null;
	}

	public JButton[] getJButtonPerEventiAvversi() {
		// TODO Auto-generated method stub
		return null;
	}

	public JButton getBottonePerAggiungereEventoAvverso() {
		// TODO Auto-generated method stub
		return null;
	}

	public JButton getBottonePerAggiornareEventoAvverso() {
		// TODO Auto-generated method stub
		return null;
	}

	public JButton getJButtonConfermaEliminareEventoAvverso() {
		// TODO Auto-generated method stub
		return null;
	}

	public JComboBox getEventoDaAggiornare() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDatiEliminaEventoAvverso() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getDatiInserisciEventoAvverso() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getDatiAggiornaEventoAvverso() {
		// TODO Auto-generated method stub
		return null;
	}

	public JButton getBottoneAggiungiNuovoVaccinato() {
		// TODO Auto-generated method stub
		return null;
	}

	public JButton getBottoneRegistraione() {
		// TODO Auto-generated method stub
		return null;
	}

	public JButton getBottonePerLogin() {
		// TODO Auto-generated method stub
		return null;
	}

	public JButton getBottonePerEffettuareRegistrazione() {
		// TODO Auto-generated method stub
		return null;
	}

	public JButton getBottoneRecuperoIdVaccinazione() {
		// TODO Auto-generated method stub
		return null;
	}

	public JButton getBottoneConfermaRecuperoIdVaccinazione() {
		// TODO Auto-generated method stub
		return null;
	}

	public JTextField getTextFieldCodiceFiscale() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getDatiRegistraNuovoVaccinato() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getDatiPerLogin() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getDatiPerRegistrazione() {
		// TODO Auto-generated method stub
		return null;
	}

	//restituisce la view in mostra sullo schermo
	public String getViewAttuale() {
		return this.viewAttuale;
	}

	public String datiEventoDaAggiornare() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCfPerRecuperoIdVacc() {
		// TODO Auto-generated method stub
		return null;
	}

}

//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.*;

/**
 * Questa classe gestisce tutte le componenti grafiche dell'applicazione, aggiornanando anche i singoli elementi
 * @author Gabriele Sassi
 *
 */
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
	//finestra cambio IP
	private GUICambiaIP viewCambioIP;
	//schermata registrazione centro
	private RegistraCentroGUI viewRegistraCentro;
	//schermata registrazione vaccinato
	private RegistraVaccinatoGUI viewRegistraVaccinato;
	//schermata di registrazione del cittadino
	private RegisterGUI viewRegistrazione;
	//schermata di ricerca del centro vaccinale
	private CercaCentroGUI viewRicercaCentro;
	//schermata elenco centri
	private ElencoCentriGUI viewElencoCentri;
	//schermata login
	private LoginGUI viewLogin;
	//schermata inserimento eventi avversi
	private EventiAvversiGUI viewInserimentoEA;
	//schermata visualizzazione eventi avversi
	private VisualizzaEventiAvversiGUI viewVisualizzaEA;
	
	/**
	 * Costruttore che realizza la view
	 */
	public ViewImpl() {
		
		//FRAME 
		this.viewAttuale = null;
		this.setTitle("VACCINIAMO");
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
   
		/////////INIZIO INTESTAZIONE--> comune a tutti 
		
		Border bordoIntestazione = BorderFactory.createLineBorder(Colori.purple, 3); //crea bordo

		back = new ImageIcon(getClass().getClassLoader().getResource("indietro2.png"));
		ImageIcon scalaBack = new ImageIcon(back.getImage().getScaledInstance(back.getIconWidth()/20*2, back.getIconHeight()/20*2, java.awt.Image.SCALE_SMOOTH)); //immagine in scala
		
		//TASTO INDIETRO
		this.indietro = new JButton();
		this.indietro.setName("INDIETRO");
		this.indietro.setFont(new Font("Arial", Font.BOLD, 10));
		this.indietro.setIcon(scalaBack);
		this.indietro.setBorderPainted(false); //senza contorni
		this.indietro.setHorizontalTextPosition(JButton.CENTER);
		this.indietro.setVerticalTextPosition(JButton.TOP);
		this.indietro.setIconTextGap(10); //distanza tra immagine e testo
		this.indietro.setBackground(Colori.arancione);
		
		this.intestazione = new JPanel(); //inizializza contenitore intestazione
		this.intestazione.setLayout(new BorderLayout());
		this.intestazione.setPreferredSize(new Dimension(180, 160)); //size panel 
		this.intestazione.setOpaque(true);
		this.intestazione.setBackground(Colori.arancione);
		this.intestazione.setBorder(bordoIntestazione);
		
		this.immagine = new ImageIcon(getClass().getClassLoader().getResource("logovaccino.png"));
		//this.immagine = new ImageIcon("img/logovaccino.png"); // ../ serve per il jar
		ImageIcon immagineScala = new ImageIcon(immagine.getImage().getScaledInstance(immagine.getIconWidth()/20*3, immagine.getIconHeight()/20*3, java.awt.Image.SCALE_SMOOTH));
		
		//TITOLO
		this.titolo = new JLabel(immagineScala);
		titolo.setText("VACCINIAMO");
		//titolo.setIcon(immagine);
		titolo.setHorizontalTextPosition(JLabel.CENTER); //setta il testo DX,CX,SX rispetto a immagine
		titolo.setVerticalTextPosition(JLabel.TOP); //setta il testo TOP,CX,BOTTOM rispetto a immagine
		titolo.setFont(new Font("MV Boli", Font.BOLD, 30));
		titolo.setForeground(Colori.purple); //colore testo
		
		
		this.intestazione.add(this.titolo, BorderLayout.CENTER); //aggiungi titolo
		this.intestazione.add(this.indietro, BorderLayout.EAST); //aggiungi bottone indietro
		
		//////////FINE INTESTAZIONE
		
		//tipo utente 
		this.viewSceltaUtente = new SceltaUtenteGUI(altezza,larghezza, this.intestazione);
		//operatore
		this.viewOperatore = new OperatoreGUI(altezza,larghezza, this.intestazione);
		//cittadino
		this.viewCittadino = new CittadinoGUI(altezza,larghezza, this.intestazione);
		//finestra cambio IP
		this.viewCambioIP = new GUICambiaIP(altezza,larghezza, this.intestazione);
		//registra centro vaccinale
		this.viewRegistraCentro = new RegistraCentroGUI(altezza,larghezza, this.intestazione);
		//registra vaccinato
		this.viewRegistraVaccinato = new RegistraVaccinatoGUI(altezza, larghezza, this.intestazione);
		//registra cittadino
		this.viewRegistrazione = new RegisterGUI(altezza, larghezza, this.intestazione);
		//ricerca centro
		this.viewRicercaCentro = new CercaCentroGUI(altezza, larghezza, this.intestazione);
		//elenco centri
		this.viewElencoCentri = new ElencoCentriGUI(altezza, larghezza, this.intestazione);
		//login
		this.viewLogin = new LoginGUI(altezza, larghezza, this.intestazione);
		//inserimento eventi avversi
		this.viewInserimentoEA = new EventiAvversiGUI(altezza, larghezza, this.intestazione);
		//visualizzazione eventi avversi
		this.viewVisualizzaEA = new VisualizzaEventiAvversiGUI(altezza, larghezza, this.intestazione);
		
		this.mostraSceltaUtenteView(); //mostra a video
	}
	
	//METODI 
	
	/**
	 * Metodo che mostra gli elementi per la view "sceltaUtente"
	 */
	private void mostraSceltaUtenteView() {
		
		this.setVisible(false); //visibilità panel
		this.getContentPane().removeAll(); //rimuove contenuto precedente
		this.getBack().setVisible(false); //mostra tasto indietro
		this.getContentPane().add(this.viewSceltaUtente.retIntestazione(), BorderLayout.PAGE_START); //aggiunge al panel intestazione
		this.getContentPane().add(this.viewSceltaUtente.retContenitore(), BorderLayout.CENTER); //aggiunge al panel corpo schermata
		this.setVisible(true);
		this.viewAttuale = "sceltaUtenteView"; //imposta la schermata attuale
	}
	
	/**
	 * Metodo che mostra gli elementi per la view "operatore"
	 */
	private void mostraViewOperatore() {
		
		this.setVisible(false); //visibilità panel
		this.getContentPane().removeAll(); //rimuove contenuto precedente
		this.getBack().setVisible(true); //mostra tasto indietro
		this.getContentPane().add(this.viewOperatore.retIntestazione(), BorderLayout.PAGE_START); //aggiunge al panel intestazione
		this.getContentPane().add(this.viewOperatore.retContenitore(), BorderLayout.CENTER); //aggiunge al panel corpo schermata
		this.setVisible(true);
		this.viewAttuale = "viewOperatore"; //imposta la schermata attuale
	}
	
	/**
	 * Metodo che mostra elementi per la view "cittadino"
	 */
	private void mostraViewCittadino() {
		
		this.setVisible(false);
		this.getContentPane().removeAll();
		this.getBack().setVisible(true); //mostra tasto indietro
		this.getContentPane().add(this.viewCittadino.retIntestazione(), BorderLayout.PAGE_START); //aggiunge al panel intestazione
		this.getContentPane().add(this.viewCittadino.retContenitore(), BorderLayout.CENTER); //aggiunge al panel corpo schermata
		this.setVisible(true);
		this.viewAttuale = "viewCittadino"; //imposta la schermata attuale
	}
	
	/**
	 * Metodo che mostra l'option pane per cambiare ip del server
	 */
	private void mostraViewCambioIP() {
		this.viewCambioIP.mostraFinestraCambioIp();
	}
	
	/**
	 * Metodo che mostra elementi per la view "registra centro vaccinale"
	 */
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
	
	/**
	 * Metodo che mostra elementi per la view "registra vaccinato"
	 * @param elencoCentri
	 */
	private void mostraViewRegistraVaccinato(List<String> elencoCentri) {
		
		this.setVisible(false);
		this.getContentPane().removeAll();
		this.getBack().setVisible(true); //mostra tasto indietro
		this.viewRegistraVaccinato.resetComboBox();
		//inserisce centri nella combobox
		for(String centri : elencoCentri) {
			this.viewRegistraVaccinato.aggiungiCentroComboBox(centri);
		}
		this.viewRegistraCentro.pulisciView(); //pulisce tutte caselle
		this.getContentPane().add(this.viewRegistraVaccinato.retIntestazione(), BorderLayout.PAGE_START);
		this.getContentPane().add(this.viewRegistraVaccinato.retContenitore(), BorderLayout.CENTER);
		this.setVisible(true);
		this.viewAttuale = "registraNuovoVaccinato";
	}
	
	/**
	 * Metodo che mostra elementi per la view "registrazione"
	 */
	private void mostraViewRegistrazione() {
		this.setVisible(false);
		this.getContentPane().removeAll();
		this.getBack().setVisible(true); //mostra tasto indietro
		this.viewRegistrazione.pulisciView(); //pulisce tutte caselle
		this.getContentPane().add(this.viewRegistrazione.retIntestazione(), BorderLayout.PAGE_START);
		this.getContentPane().add(this.viewRegistrazione.retContenitore(), BorderLayout.CENTER);
		this.setVisible(true);
		this.viewAttuale = "registrazione";
	}
	
	/**
	 * Metodo che mostra elementi per la view "ricerca centro"
	 */
	private void mostraViewRicercaCentro() {
		this.setVisible(false);
		this.getContentPane().removeAll();
		this.getBack().setVisible(true); //mostra tasto indietro
		this.viewRicercaCentro.pulisciView(); //pulisce tutte caselle
		this.getContentPane().add(this.viewRicercaCentro.retIntestazione(), BorderLayout.PAGE_START);
		this.getContentPane().add(this.viewRicercaCentro.retContenitore(), BorderLayout.CENTER);
		this.setVisible(true);
		this.viewAttuale = "ricercaCentro";
	}
	
	/**
	 * Metodo che  mostra elementi per la view "elenco centri"
	 * @param centri
	 * @param dati
	 */
	private void mostraViewElencoCentri( List<String> centri, List<List<String>> dati) {
		this.setVisible(false);
		this.getContentPane().removeAll();
		this.getBack().setVisible(true);
		this.viewElencoCentri.resetComboBox();
		this.getContentPane().add(this.viewElencoCentri.retIntestazione(), BorderLayout.PAGE_START);
		this.getContentPane().add(this.viewElencoCentri.retContenitore(), BorderLayout.CENTER);
		this.setVisible(true);
		this.viewAttuale = "elencoCentri";
		
		//inserisci centri trovati nella combobox
		if(centri.size() != 0) {
			for(String centro : centri) {
				this.viewElencoCentri.aggiungiCentroInComboBox(centro);
			}
		}
		
		//recupera valori da lista e inserisce nelle label senza mostrarli
		this.viewElencoCentri.setNomeCentroNOVISUAL("index: " + this.viewElencoCentri.retIndiceCentroSelezionatoComboBox());
		this.viewElencoCentri.setTipologiaCentroNOVISUAL(dati.get(this.viewElencoCentri.retIndiceCentroSelezionatoComboBox()).get(0));
		this.viewElencoCentri.setIndirizzoCentroNOVISUAL(dati.get(this.viewElencoCentri.retIndiceCentroSelezionatoComboBox()).get(1));
		this.viewElencoCentri.setNumeroSegnalazioniNOVISUAL(dati.get(this.viewElencoCentri.retIndiceCentroSelezionatoComboBox()).get(2));
		this.viewElencoCentri.setMediaSintomiNOVISUAL(dati.get(this.viewElencoCentri.retIndiceCentroSelezionatoComboBox()).get(3));

		
	}
	
	/**
	 * Metodo che mostra elementi per la view "login"
	 */
	private void mostraViewLogin() {
		this.setVisible(false);
		this.getContentPane().removeAll();
		this.getBack().setVisible(true);
		this.viewLogin.pulisciCampi();
		this.getContentPane().add(this.viewLogin.retIntestazione(), BorderLayout.PAGE_START);
		this.getContentPane().add(this.viewLogin.retContenitore(), BorderLayout.CENTER);
		this.setVisible(true);
		this.viewAttuale = "login";
	}
	
	/**
	 * Metodo che mostra elementi per la view  "inserimento eventi avversi"
	 */
	private void mostraViewInserimentoEA() {
		this.setVisible(false);
		this.getContentPane().removeAll();
		this.getBack().setVisible(true);
		this.viewInserimentoEA.pulisciCampi();
		this.getContentPane().add(this.viewInserimentoEA.retIntestazione(), BorderLayout.PAGE_START);
		this.getContentPane().add(this.viewInserimentoEA.retContenitore(), BorderLayout.CENTER);
		this.setVisible(true);
		this.viewAttuale = "inserimentoEventiAvversi";
	}
	
	/**
	 * Metodo che mostra elementi per la view "visualizza eventi avversi"
	 */
	private void mostraViewVisualizzaEA(String [][]valoriTabella) {
		this.setVisible(false);
		this.getContentPane().removeAll();
		this.getBack().setVisible(true);
		this.viewVisualizzaEA.pulisciView();
		this.viewVisualizzaEA.creaTabella(valoriTabella);
		this.viewVisualizzaEA.ultimaView();
		this.getContentPane().add(this.viewVisualizzaEA.retIntestazione(), BorderLayout.PAGE_START);
		this.getContentPane().add(this.viewVisualizzaEA.retContenitore(), BorderLayout.CENTER);
		this.setVisible(true);
		this.viewAttuale = "visualizzaEventiAvversi";
	}
	
	/**
	 * Metodo che riceve dati del model e aggiorna in base al componente che ha generato evento
	 * @param source: valore riferito al componente origine che ha generato evento
	 * @param dati: dati con cui aggiornare componenti view
	 * @param flagErrore: booleano per indicare se ci sono errori --> li mostra con JPane
	 */
	public void updateView(Object source, Object dati, boolean flagErrore) {
		
		String buttonOrigine = (String) source;
		
		//FUNZIONALITA ERRORE, nel caso i campi violano i requisiti stabiliti 
		if(flagErrore == true) {
			String errore = "";
			List <String> listaErrori = (List<String>) dati;
			
			//ciclo che mostra gli errori 
			for(String e: listaErrori) {
				errore = errore + "\n" + e + "\n";
			}
			
			//mostra con schermata popup
			JOptionPane.showMessageDialog(null, errore, "VACCINIamo", JOptionPane.ERROR_MESSAGE);
		}
		
		else {
			
		if(buttonOrigine.equals("INDIETRO")) {
			
			if(this.viewAttuale.equals("viewOperatore") || this.viewAttuale.equals("viewCittadino")) {
				mostraSceltaUtenteView(); //torna indietro alla schermata
			}
			
			if(this.viewAttuale.equals("registraNuovoCentro") || this.viewAttuale.equals("registraNuovoVaccinato")) {
				mostraViewOperatore(); //torna alla schermata dell'operatore
			}
			
			if(this.viewAttuale.equals("registrazione") || this.viewAttuale.equals("ricercaCentro") || this.viewAttuale.equals("login") || this.viewAttuale.equals("inserimentoEventiAvversi")) {
				mostraViewCittadino(); //torna alla schermata cittadino
			}
			
			if(this.viewAttuale.equals("elencoCentri")) {
				mostraViewRicercaCentro(); //torna alla schermata di ricerca
			}
			
			if(this.viewAttuale.equals("visualizzaEventiAvversi")) {
				mostraViewInserimentoEA(); //va alla schermata di inserimento degli eventi avversi
			}
			
		}
		
		if(buttonOrigine.equals("OPERATORE")) {
			mostraViewOperatore(); //va alla schermata dell'operatore
		}
		
		if(buttonOrigine.equals("CITTADINO")) {
			mostraViewCittadino(); //va alla schermata cittadino
		}
		
		if(buttonOrigine.equals("IMPOSTAZINI-IP")) {
			mostraViewCambioIP(); //mostra JOptionPane per cambio ip
		}
		
		if(buttonOrigine.equals("cambiaIP")) {
			this.viewCambioIP.nascondiFinestra();
			JOptionPane.showMessageDialog(null, "IP Server cambiato", "IP SERVER", JOptionPane.INFORMATION_MESSAGE);
			this.viewCambioIP.chiudiFinestra();
		}
		
		if(buttonOrigine.equals("REGISTRA NUOVO CENTRO")) {
			mostraViewRegistraCentro(); //va alla schermata registrazione centro vaccinale
		}
		
		//conferma inserimento di un nuovo centro vaccinale
		if(buttonOrigine.equals("REGISTRA CENTRO")) {
			List <String> datiCentro = (List<String>) dati; //dati presi dal model

			String nomeInserito = datiCentro.get(0); //estrae nome del centro
	
			JOptionPane.showMessageDialog(null, "Nuovo Centro registrato: " + nomeInserito, "OPERATORE", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		if(buttonOrigine.equals("REGISTRA NUOVO VACCINATO")) {
			List <String> datiMandati = (List <String>) dati; // per visualizzare elenco centri
			mostraViewRegistraVaccinato(datiMandati); //va alla schermata registrazione del vaccinato
		}
		
		//conferma inserimento di un nuovo vaccinato presso il centro vaccinale
		if(buttonOrigine.equals("REGISTRA VACCINATO")) {
			List <String> vaccinato = (List <String>) dati; //dati dal model
			
			String nomeVaccinato = vaccinato.get(0);
			String idVaccinato = vaccinato.get(1);
			
			JOptionPane.showMessageDialog(null, "Nuovo vaccinato " + nomeVaccinato + " con ID " + idVaccinato + " inserito", "OPERATORE", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		if(buttonOrigine.equals("REGISTRATI")) {
			mostraViewRegistrazione(); //va alla schermata dove il cittadino può registrarsi presso il proprio centro di competenza
		}
		
		//conferma la registrazione del cittadino con i propri dati
		if(buttonOrigine.equals("CONFERMA-REGISTRAZIONE")) {
			JOptionPane.showMessageDialog(null, "Cittadino Registrato con successo", "CITTADINO", JOptionPane.INFORMATION_MESSAGE);
			mostraViewCittadino(); 
		}
		
		if(buttonOrigine.equals("INFO CENTRI VACCINALI")) {
			mostraViewRicercaCentro(); //va alla schermata dove il cittadino può visualizzare la ricerca del centro vaccinale
		}
		
		if(buttonOrigine.equals("INSERISCI EVENTI AVVERSI")) {
			mostraViewLogin(); //prima di inserire evento deve autenticarsi
		}
		
		if(buttonOrigine.equals("ACCEDI")) {
			
			List <String> datiUtente = (List<String>) dati;
			
			String utente = datiUtente.get(0);
			JOptionPane.showMessageDialog(null, "Benvenuto " + utente, "CITTADINO", JOptionPane.INFORMATION_MESSAGE);
			mostraViewInserimentoEA(); //va alla pagina di inserimento eventi avversi
		}
		
		if(buttonOrigine.equals("REGISTRATI-Login")) {
			mostraViewRegistrazione(); //va alla schermata dove il cittadino può registrarsi presso il proprio centro di competenza
		}
		
		
		if(buttonOrigine.equals("CercaNome") || buttonOrigine.equals("CercaComune")) {
			
			List <String> centri = new ArrayList<String>();
			List<List<String>> campo = new ArrayList<List<String>>();
			int j=0;
			
			//se non c'è inserito il nome, si cerca per comune e tipologia
			if(togliSpazi(this.viewRicercaCentro.retNomeCentro()).equals("")) {
				List<List<String>> datiComuneTipo = (List<List<String>>) dati; //dati passati dal model
				
				//cicla nella lista per estrarre dati di ogni centro trovato
				for(List<String> centroComTipo : datiComuneTipo) {
					centri.add(centroComTipo.get(0)); //nome centro
					campo.add(new ArrayList<String>()); //lista info per quello specifico centro
					campo.get(j).add(centroComTipo.get(1)); //indirizzo
					campo.get(j).add(centroComTipo.get(2)); //tipologia
					campo.get(j).add(centroComTipo.get(3)); //numero segnalazioni
					campo.get(j).add(centroComTipo.get(4)); //medie avversità
					j++;
					
				}
			} 
			//ricerca per nome
			else {
				List<String> datiNomeCentro = (List<String>) dati; //dati passati dal model
				centri.add(datiNomeCentro.get(0));  //nome centro
				campo.add(new ArrayList<String>()); //lista info per quel centro
				campo.get(j).add(datiNomeCentro.get(1)); //indirizzo
				campo.get(j).add(datiNomeCentro.get(2)); //tipologia
				campo.get(j).add(datiNomeCentro.get(3)); //numero segnalazioni
				campo.get(j).add(datiNomeCentro.get(4)); //medie avversità
				
			}
			
			mostraViewElencoCentri(centri, campo);
		}
		
		if(buttonOrigine.equals("ComboBoxCentroInfo")) {
			
			List <String> centri = new ArrayList<String>();
			List<List<String>> campo = new ArrayList<List<String>>();
			int j=0;
			
			//se non cè inserito il nome, si cerca per comune e tipologia
			if(togliSpazi(this.viewRicercaCentro.retNomeCentro()).equals("")) {
				List<List<String>> datiComuneTipo = (List<List<String>>) dati; //dati passati dal model
				
				//cicla nella lista per estrarre dati di ogni centro trovato
				for(List<String> centroComTipo : datiComuneTipo) {
					centri.add(centroComTipo.get(0)); //nome centro
					campo.add(new ArrayList<String>()); //lista info per quello specifico centro
					campo.get(j).add(centroComTipo.get(1)); //indirizzo
					campo.get(j).add(centroComTipo.get(2)); //tipologia
					campo.get(j).add(centroComTipo.get(3)); //numero segnalazioni
					campo.get(j).add(centroComTipo.get(4)); //medie avversità
					j++;
					
				}
			} 
			//ricerca per nome
			else {
				List<String> datiNomeCentro = (List<String>) dati; //dati passati dal model
				centri.add(datiNomeCentro.get(0));  //nome centro
				campo.add(new ArrayList<String>()); //lista info per quel centro
				campo.get(j).add(datiNomeCentro.get(1)); //indirizzo
				campo.get(j).add(datiNomeCentro.get(2)); //tipologia
				campo.get(j).add(datiNomeCentro.get(3)); //numero segnalazioni
				
				campo.get(j).add(datiNomeCentro.get(4)); //medie avversità
			}
			
			//centro selezionato
			String InfoDaVisualizzare = (String) this.viewElencoCentri.retCentroSelezionatoComboBox();
			
			int indice = 0;
			
			//salva indice di quel centro per scorrere nella lista
			for(int i = 0; i<centri.size(); i++) {
				if(centri.get(i).equals(InfoDaVisualizzare)) {
					indice = i;
				}
			}
			
			//inserisce e VISUALIZZA info dei centri
			this.viewElencoCentri.setNomeCentro(InfoDaVisualizzare);
			this.viewElencoCentri.setTipologiaCentro(campo.get(indice).get(0));
			this.viewElencoCentri.setIndirizzoCentro(campo.get(indice).get(1));
			this.viewElencoCentri.setNumeroSegnalazioni(campo.get(indice).get(2));
			this.viewElencoCentri.setMediaSintomi(campo.get(indice).get(3));
			
			
		}
		
		if(buttonOrigine.equals("CONFERMA EVENTO AVVERSO")) {
			List<List<String>> elencoEA = (List<List<String>>) dati;
			
			String[][] matricexTab = new String[1][3];
			JOptionPane.showMessageDialog(null, "Evento registrato con successo", "CITTADINO", JOptionPane.INFORMATION_MESSAGE);
			
			int n;
			int i;
			
			//cicla su elementi lista
			for(i =0; i<elencoEA.size(); i++ ) {
				matricexTab = matrice(matricexTab, elencoEA.get(i));
			}
				
			mostraViewVisualizzaEA(matricexTab); //va alla schermata di visualizzazione dell'eventi avversi
		}
		
		}
		
	}
	
	/**
	 * Metodo che ritorna riferimento bottone indietro
	 */
	public JButton getBack() {
		return this.indietro;
	}
		
	/**
	 * Metodo che restituisce i riferimenti dei button alla scelta del tipo di utente
	 */
	public JButton[] getSceltaTipoUtente() {
		JButton[] ret = new JButton[2]; //bottoni usati con controller per eventi
		ret[0] = this.viewSceltaUtente.retButtonOperatore();
		ret[1] = this.viewSceltaUtente.retButtonCittadino();
		return ret;
	}
	
	/**
	 * Metodo che ritorna bottone per impostazioni ip
	 */
	public JButton getButtonImpostazioni() {
		return this.viewSceltaUtente.retButtonImpostazioni();
	}
	
	/**
	 * Metodo che fa riferimento al bottone per cambiare IP
	 */
	public JButton getButtonCambioIP() {
		return this.viewCambioIP.retButtonCambiaIP();
		
	}
	
	/**
	 * Metodo che recupera ID inserito
	 */
	public String getNuovoIP() {
		return this.viewCambioIP.getIPInserito();
	}
	
	/**
	 * Metodo che fa riferimento al bottone dataset
	 */
	public JButton getButtonDataset() {
		return this.viewCambioIP.retButtonDataset();
	}

	/**
	 * Metodo che cattura le funzionalità dei vari bottoni della schermata operatore
	 */
	public JButton[] getBottoniFunzionalitaOperatore() {
		JButton[] ret = new JButton[2];
		ret[0] = this.viewOperatore.retButtonRegistraCentro();
		ret[1] = this.viewOperatore.retButtonRegistraVaccinato();
		return ret;
	}
	
	public JButton getBottoneRegistraNuovoCentro() {
		return this.viewRegistraCentro.retBottoneRegistraCentro();
	}

	public List<String> getDatiRegistraNuovoCentro() {
		List<String> centro = new ArrayList <String>();
		
		String tipoCentro = (String) this.viewRegistraCentro.retTipoCentro();
		
		centro.add(this.viewRegistraCentro.retNomeCentro()); //0 nome
		centro.add(this.viewRegistraCentro.retQualificatore()); //1 qualificatore
		centro.add(this.viewRegistraCentro.retNomeIndirizzo()); //2 indirizzo
		centro.add(this.viewRegistraCentro.retNumeroCivico()); //3 numero civico
		centro.add(this.viewRegistraCentro.retComune()); //4 comune
		centro.add(this.viewRegistraCentro.retProvincia()); //5 provincia
		centro.add(this.viewRegistraCentro.retCAP()); //6 cap
		centro.add(tipoCentro); //7 tipo centro
		
		return centro;
	}
	
	public JButton getBottoneRegistraNuovoVaccinato() {
		return this.viewRegistraVaccinato.retButtonRegistraVaccinato();
	}
	
	public List<String> getDatiRegistraNuovoVaccinato() {
		
		List<String> vaccinato = new ArrayList<String>();
		
		String centro = (String) this.viewRegistraVaccinato.retNomeCentro();
		String data = StringData(this.viewRegistraVaccinato.retDataVaccinazione());
		String vaccino = (String) this.viewRegistraVaccinato.retVaccinoComboBox();
		
		vaccinato.add(centro); //0 nome centro
		vaccinato.add(this.viewRegistraVaccinato.retNomeVaccinato()); //1 nome
		vaccinato.add(this.viewRegistraVaccinato.retCognomeVaccinato()); //2 cognome 
		vaccinato.add(this.viewRegistraVaccinato.retCFVaccinato()); //3 codice fiscale
		vaccinato.add(data); //4 data vaccinazione
		vaccinato.add(vaccino); //5 tipo vaccino
		vaccinato.add(this.viewRegistraVaccinato.retNdose()); //6 numero dose
		
		return vaccinato;
	}
	
	/**
	 * Metodo che cattura le funzionalità dei vari bottoni della schermata cittadino
	 */
	public JButton[] getBottoniFunzionalitaCittadino() {
		JButton[] ret = new JButton[3];
		ret[0] = this.viewCittadino.retButtonRegistrati();
		ret[1] = this.viewCittadino.retButtonVisualizzaInfo();
		ret[2] = this.viewCittadino.retButtonInserisciEvento();
		return ret;
	}

	/**
	 * Metodo che ritorna il bottone per permettere al cittadino di registrarsi 
	 */
	public JButton getBottoneRegistrati() {
		return this.viewRegistrazione.retButtonRegistrati();
	}
		
	public List<String> getDatiPerRegistrazione() {
		List<String> cittadinoRegistrato = new ArrayList<String>();
		
		cittadinoRegistrato.add(togliSpazi(this.viewRegistrazione.retNome())); //0 nome
		cittadinoRegistrato.add(togliSpazi(this.viewRegistrazione.retCognome())); //1 cognome
		cittadinoRegistrato.add(togliSpazi(this.viewRegistrazione.retCF())); //2 cf
		cittadinoRegistrato.add(togliSpazi(this.viewRegistrazione.retEmail())); //3 mail
		cittadinoRegistrato.add(togliSpazi(this.viewRegistrazione.retUsername())); //4 username
		cittadinoRegistrato.add(togliSpazi(this.viewRegistrazione.retPsw())); //5 password
		cittadinoRegistrato.add(togliSpazi(this.viewRegistrazione.retIDUnivoco())); //6 id 
		
		return cittadinoRegistrato;
	}
	
	/**
	 * Metodo che ritorna bottone per permettere al cittadino di accedere
	 */
	public JButton getBottonePerLogin() {
		return this.viewLogin.retButtonAccedi();
	}
	
	public List<String> getDatiPerLogin() {
		List <String> credenziali = new ArrayList<String>();
		
		credenziali.add(this.viewLogin.retUsernameInserito()); //0 username
		credenziali.add(this.viewLogin.retPswInserita()); //1 password
		
		return credenziali;
	}

	/**
	 * Metodo che ritorna bottone per permettere al cittadino di andare alla schermata di registrazione se si trova nella schermata accedi
	 */
	public JButton getBottoneRegistrazioneDaLogin() {
			return this.viewLogin.retButtonLoginRegistrati();
	}
	
	/**
	 * Metodo che fa riferimento a bottoni di ricerca info
	 */
	public JButton[] getCercaInfoCentriVaccinali() {
		JButton[] ret = new JButton[2];
		ret[0] = this.viewRicercaCentro.retButtonCercaNome();
		ret[1] = this.viewRicercaCentro.retButtonCercaComune();
		return ret;
	}

	/**
	 * Metodo che combobox con centro da visualizzare x ottenre info
	 */
	public JComboBox boxSceltaCentroGetInfo() {
		return this.viewElencoCentri.retComboBox();
	}

	/**
	 * Metodo che restituisce una stringa con il nome del centro inserito x ricerca
	 */
	public String getDatiNomeCentroPerConsultareInfo() {
		String risultato = this.viewRicercaCentro.retNomeCentro();
		return risultato;
	}

	/**
	 * Metodo che restituisce una lista contente comune e tipologia per ricerca
	 */
	public List<String> getDatiComuneTipologiaPerConsultareInfo() {
		List <String> risultato = new ArrayList<String>();
		risultato.add(this.viewRicercaCentro.retComuneCentro());
		String Tipologia = (String) this.viewRicercaCentro.retTipologiaCentro();
		risultato.add(Tipologia);
		return risultato;
	}
	
	public JButton getBottonePerInserireEventoAvverso() {
		return this.viewInserimentoEA.retButtonInserisciEA();
	}

	public List<String> getDatiInserisciEventoAvverso() {
		List <String> eventoAvverso = new ArrayList<String>();
		
		eventoAvverso.add(this.viewInserimentoEA.retTipoEventoInserito()); //0 evento
		String severita = (String) this.viewInserimentoEA.retSeveritaSelezionata();
		eventoAvverso.add(severita); //1 severita
		eventoAvverso.add(this.viewInserimentoEA.retNote()); //2 note
	
		return eventoAvverso;
	}
	
	/**
	 * Metodo che restituisce la view in mostra sullo schermo
	 */
	public String getViewAttuale() {
		return this.viewAttuale;
	}
	
	/**
	 * Metodo utile per salvare la data in formato testuale
	 * @param data
	 * @return
	 */
	private String StringData(Date data) {
		String risultato, b;
		String [] a;
		
		StringBuffer memoria = new StringBuffer(); //buffer dove salvare
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.format(data, memoria, new FieldPosition(0));
		
		b = memoria.toString();
		a = b.split("-");
		risultato = a[0] + "/" + a[1] + "/" + a[2];
		
		return risultato;
	}
	
	
	/**
	 * Metodo utile per eliminare spazi aggiuntivi di una stringa
	 * @param p
	 * @return
	 */
	private String togliSpazi(String p) {
	String esito = "";
		
	for(int i=0; i<p.length(); i++) {
				
		if(p.charAt(i) != ' ') {
			esito = esito + p.charAt(i);
		}
		else {
			while(i<p.length() && p.charAt(i) == ' ') {
				i++;
			}
			
			if(i != p.length()) {
				i--;
				esito = esito + " ";
			}
		}
	}
			
	return esito;
			
	}
	
	/**
	 * Metodo che  converte lista di stringhe in una matrice di string per inserire nella tabella (requisito di tabella)
	 * @param old
	 * @param elencoEa
	 * @return
	 */
	private String[][] matrice(String[][] old, List<String> elencoEa){
		
		int nRiga = old.length;
		int nColonna = old[0].length;
		String[][] matrice = new String[nRiga+1][nColonna];
		
		for(int i=0; i < nRiga; i++) {
			for(int j=0; j < nColonna; j++) {
				matrice[i][j] = old[i][j];
			}
		}
		
		for(int i=0; i<nColonna; i++) {
			matrice[nRiga][i] = elencoEa.get(i);
		}
		return matrice;
	}

}

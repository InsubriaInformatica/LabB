import java.util.*;
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
	
	//costruttore che realizza la view
	public ViewImpl() {
		
		//FRAME 
		this.viewAttuale = null;
		this.setTitle("VACCINIAMO");
		this.setLayout(null);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
          
        this.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setLayout(new BorderLayout());
   
		/////////INIZIO INTESTAZIONE--> comune a tutti 
		
		Border bordoIntestazione = BorderFactory.createLineBorder(Colori.purple, 3); //crea bordo

		back = new ImageIcon("img/indietro2.png");
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
		
		this.intestazione = new JPanel(); //inizializza contenitore intestazione
		this.intestazione.setLayout(new BorderLayout());
		this.intestazione.setPreferredSize(new Dimension(180, 160)); //size panel 
		this.intestazione.setOpaque(true);
		this.intestazione.setBackground(Colori.arancione);
		this.intestazione.setBorder(bordoIntestazione);
		
		this.immagine = new ImageIcon("img/logovaccino.png"); // ../ serve per il jar
		
		
		//TITOLO
		this.titolo = new JLabel(new ImageIcon(immagine.getImage().getScaledInstance(immagine.getIconWidth()/20*4, immagine.getIconHeight()/20*4, java.awt.Image.SCALE_SMOOTH)));
		titolo.setText("VACCINIAMO");
		//titolo.setIcon(immagine);
		titolo.setHorizontalTextPosition(JLabel.CENTER); //setta il testo DX,CX,SX rispetto a immagine
		titolo.setVerticalTextPosition(JLabel.TOP); //setta il testo TOP,CX,BOTTOM rispetto a immagine
		titolo.setFont(new Font("MV Boli", Font.BOLD, 30));
		titolo.setForeground(Colori.purple); //colore testo
		
		
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
	
	private void mostraViewRegistraVaccinato() {
		
		this.setVisible(false);
		this.getContentPane().removeAll();
		this.getBack().setVisible(true); //mostra tasto indietro
		this.viewRegistraCentro.pulisciView(); //pulisce tutte caselle
		this.getContentPane().add(this.viewRegistraVaccinato.retIntestazione(), BorderLayout.PAGE_START);
		this.getContentPane().add(this.viewRegistraVaccinato.retContenitore(), BorderLayout.CENTER);
		this.setVisible(true);
		this.viewAttuale = "registraNuovoVaccinato";
	}
	
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
	
	private void mostraViewElencoCentri( /*List<String> centri, List<List<String>> dati*/) {
		this.setVisible(false);
		this.getContentPane().removeAll();
		this.getBack().setVisible(true);
		this.viewElencoCentri.resetComboBox();
		this.getContentPane().add(this.viewElencoCentri.retIntestazione(), BorderLayout.PAGE_START);
		this.getContentPane().add(this.viewElencoCentri.retContenitore(), BorderLayout.CENTER);
		this.setVisible(true);
		this.viewAttuale = "elencoCentri";
		
		//inserisci centri trovati nella combobox
		/*for(String centro : centri) {
			this.viewElencoCentri.aggiungiCentroInComboBox(centro);;
		}*/
		
		//recupera valori da lista e inserisce nelle label senza mostrarli
		/*this.viewElencoCentri.setNomeCentroNOVISUAL("index: " + this.viewElencoCentri.retIndiceCentroSelezionatoComboBox());
		this.viewElencoCentri.setTipologiaCentroNOVISUAL(dati.get(this.viewElencoCentri.retIndiceCentroSelezionatoComboBox()).get(0));
		this.viewElencoCentri.setIndirizzoCentroNOVISUAL(dati.get(this.viewElencoCentri.retIndiceCentroSelezionatoComboBox()).get(1));
		this.viewElencoCentri.setNumeroSegnalazioniNOVISUAL(dati.get(this.viewElencoCentri.retIndiceCentroSelezionatoComboBox()).get(2));
		
		
		this.viewElencoCentri.setMalDiTestaNOVISUAL(dati.get(this.viewElencoCentri.retIndiceCentroSelezionatoComboBox()).get(3));
		this.viewElencoCentri.setFebbreNOVISUAL(dati.get(this.viewElencoCentri.retIndiceCentroSelezionatoComboBox()).get(4));
		this.viewElencoCentri.setDoloriNOVISUAL(dati.get(this.viewElencoCentri.retIndiceCentroSelezionatoComboBox()).get(5));
		this.viewElencoCentri.setLinfoadenopatiaNOVISUAL(dati.get(this.viewElencoCentri.retIndiceCentroSelezionatoComboBox()).get(6));
		this.viewElencoCentri.setTachicardiaNOVISUAL(dati.get(this.viewElencoCentri.retIndiceCentroSelezionatoComboBox()).get(7));
		this.viewElencoCentri.setCrisiNOVISUAL(dati.get(this.viewElencoCentri.retIndiceCentroSelezionatoComboBox()).get(8));*/
		
	}
	
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
	
	private void mostraViewVisualizzaEA(/*String [][]valoriTabella*/) {
		this.setVisible(false);
		this.getContentPane().removeAll();
		this.getBack().setVisible(true);
		//this.viewVisualizzaEA.creaTabella(valoriTabella);
		//this.viewVisualizzaEA.ultimaView();
		this.getContentPane().add(this.viewVisualizzaEA.retIntestazione(), BorderLayout.PAGE_START);
		this.getContentPane().add(this.viewVisualizzaEA.retContenitore(), BorderLayout.CENTER);
		this.setVisible(true);
		this.viewAttuale = "visualizzaEventiAvversi";
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
		
		if(buttonOrigine.equals("REGISTRA NUOVO CENTRO")) {
			mostraViewRegistraCentro(); //va alla schermata registrazione centro vaccinale
		}
		
		if(buttonOrigine.equals("REGISTRA NUOVO VACCINATO")) {
			mostraViewRegistraVaccinato(); //va alla schermata registrazione centro vaccinale
		}
		
		if(buttonOrigine.equals("REGISTRATI")) {
			mostraViewRegistrazione(); //va alla schermata dove il cittadino può registrarsi presso il proprio centro di competenza
		}
		
		if(buttonOrigine.equals("INFO CENTRI VACCINALI")) {
			mostraViewRicercaCentro(); //va alla schermata dove il cittadino può visualizzare la ricerca del centro vaccinale
		}
		
		if(buttonOrigine.equals("INSERISCI EVENTI AVVERSI")) {
			mostraViewLogin(); //prima di inserire evento deve autenticarsi
		}
		
		if(buttonOrigine.equals("ACCEDI")) {
			//IMPLEMENTA
			mostraViewInserimentoEA(); //va alla pagina di inserimento eventi avversi
		}
		
		if(buttonOrigine.equals("REGISTRATI-Login")) {
			mostraViewRegistrazione(); //va alla schermata dove il cittadino può registrarsi presso il proprio centro di competenza
		}
		
		
		if(buttonOrigine.equals("CercaNome") || buttonOrigine.equals("CercaComune")) {
			
			/*List <String> centri = new ArrayList<String>();
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
					campo.get(j).add(centroComTipo.get(5)); 
					campo.get(j).add(centroComTipo.get(6));
					campo.get(j).add(centroComTipo.get(7)); 
					campo.get(j).add(centroComTipo.get(8)); 
					campo.get(j).add(centroComTipo.get(9));
					
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
				campo.get(j).add(datiNomeCentro.get(5)); 
				campo.get(j).add(datiNomeCentro.get(6));
				campo.get(j).add(datiNomeCentro.get(7)); 
				campo.get(j).add(datiNomeCentro.get(8)); 
				campo.get(j).add(datiNomeCentro.get(9));
			}*/
			
			mostraViewElencoCentri(/*centri, campo*/);
		}
		
		if(buttonOrigine.equals("ComboBoxCentroInfo")) {
			
			/*List <String> centri = new ArrayList<String>();
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
					campo.get(j).add(centroComTipo.get(5)); 
					campo.get(j).add(centroComTipo.get(6));
					campo.get(j).add(centroComTipo.get(7)); 
					campo.get(j).add(centroComTipo.get(8)); 
					campo.get(j).add(centroComTipo.get(9));
					
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
				campo.get(j).add(datiNomeCentro.get(5)); 
				campo.get(j).add(datiNomeCentro.get(6));
				campo.get(j).add(datiNomeCentro.get(7)); 
				campo.get(j).add(datiNomeCentro.get(8)); 
				campo.get(j).add(datiNomeCentro.get(9));
			}*/
			
			//centro selezionato
			/*String InfoDaVisualizzare = (String) this.viewElencoCentri.retCentroSelezionatoComboBox();
			
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
			
			this.viewElencoCentri.setMalDiTesta(campo.get(indice).get(3));
			this.viewElencoCentri.setFebbre(campo.get(indice).get(4));
			this.viewElencoCentri.setDolori(campo.get(indice).get(5));
			this.viewElencoCentri.setLinfoadenopatia(campo.get(indice).get(6));
			this.viewElencoCentri.setTachicardia(campo.get(indice).get(7));
			this.viewElencoCentri.setCrisi(campo.get(indice).get(8));*/
			
		}
		
		if(buttonOrigine.equals("CONFERMA EVENTO AVVERSO")) {
			mostraViewVisualizzaEA(); //va alla schermata di visualizzazione dell'eventi avversi
		}
		
		
	}
	
	//restituisce i riferimenti dei button alla scelta del tipo di utente
	public JButton[] getSceltaTipoUtente() {
		JButton[] ret = new JButton[2]; //bottoni usati con controller per eventi
		ret[0] = this.viewSceltaUtente.retButtonOperatore();
		ret[1] = this.viewSceltaUtente.retButtonCittadino();
		return ret;
	}

	//cattura le funzionalità dei vari bottoni della schermata operatore
	public JButton[] getBottoniFunzionalitaOperatore() {
		JButton[] ret = new JButton[2];
		ret[0] = this.viewOperatore.retButtonRegistraCentro();
		ret[1] = this.viewOperatore.retButtonRegistraVaccinato();
		return ret;
	}
	
	//cattura le funzionalità dei vari bottoni della schermata cittadino
	public JButton[] getBottoniFunzionalitaCittadino() {
		JButton[] ret = new JButton[3];
		ret[0] = this.viewCittadino.retButtonRegistrati();
		ret[1] = this.viewCittadino.retButtonVisualizzaInfo();
		ret[2] = this.viewCittadino.retButtonInserisciEvento();
		return ret;
	}

	//metodo che ritorna riferimento bottone indietro
	public JButton getBack() {
		return this.indietro;
	}
	

	//riferimento a bottoni di ricerca info
	public JButton[] getCercaInfoCentriVaccinali() {
		JButton[] ret = new JButton[2];
		ret[0] = this.viewRicercaCentro.retButtonCercaNome();
		ret[1] = this.viewRicercaCentro.retButtonCercaComune();
		return ret;
	}

	//IMPLEMENTA
	public JComboBox boxSceltaCentroGetInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public JButton getBottoneAggiungiNuovoCentro() {
		// TODO Auto-generated method stub
		return null;
	}

	//restituisce una stringa con il nome del centro inserito x ricerca
	public String getDatiNomeCentroPerConsultareInfo() {
		String risultato = this.viewRicercaCentro.retNomeCentro();
		return risultato;
	}

	//restituisce una lista contente comune e tipologia per ricerca
	public List<String> getDatiComuneTipologiaPerConsultareInfo() {
		List <String> risultato = new ArrayList<String>();
		risultato.add(this.viewRicercaCentro.retComuneCentro());
		String Tipologia = (String) this.viewRicercaCentro.retTipologiaCentro();
		risultato.add(Tipologia);
		return risultato;
	}

	public List<String> getDatiRegistraNuovoCentro() {
		// TODO Auto-generated method stub
		return null;
	}

	public JButton[] getBottonePerEventiAvversi() {
		// TODO Auto-generated method stub
		return null;
	}

	public JButton getBottonePerInserireEventoAvverso() {
		return this.viewInserimentoEA.retButtonInserisciEA();
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

	public JButton getBottoneRegistrazione() {
		return null;
	}

	public JButton getBottonePerLogin() {
		return this.viewLogin.retButtonAccedi();
	}

	public JButton getBottoneRegistrazioneDaLogin() {
		return this.viewLogin.retButtonLoginRegistrati();
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

	//IMPLEMENTA
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
	
	
	
	
	//utile per eliminare spazi aggiuntivi di una stringa
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

}

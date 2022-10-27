
import java.awt.*;
import javax.swing.*;

public class ElencoCentriGUI {
	
	private JPanel intestazione;
	
	private JPanel contenitorePrincipale;
	
	private JPanel panelTitolo;
	private JLabel labelTitolo;
	
	private JPanel panelTitolo1;
	private JLabel labelTitolo1;
	
	private JPanel panelBox;
	private JComboBox<String> sceltaCentro;
	
	private JPanel panelInformazioni;
	private JLabel nome;
	private JLabel infoNome;
	private JLabel tipologia;
	private JLabel infoTipologia;
	private JLabel indirizzo;
	private JLabel infoIndirizzo;
	private JLabel numeroSegnalazioni;
	private JLabel infoNumeroSegnalazioni;
	
	private JPanel panelSintomi;
	private JLabel maleTesta;
	private JLabel infoMaleTesta;
	private JLabel febbre;
	private JLabel infoFebrre;
	private JLabel dolori;
	private JLabel infoDolori;
	private JLabel linfoadenopatia;
	private JLabel infoLinfoadenopatia;
	private JLabel tachicardia;
	private JLabel infotachicardia;
	private JLabel crisiIpertensiva;
	private JLabel infoCrisiIpertensiva;
	
	
	
	public ElencoCentriGUI(int larghezza, int altezza, JPanel intestazione){
		
		this.intestazione = intestazione;
		
		//TITOLO
		this.panelTitolo = new JPanel();
		this.panelTitolo.setLayout(new GridLayout(1,1));
		this.labelTitolo = new JLabel("SELEZIONA IL TUO CENTRO:");
		this.labelTitolo.setFont(new Font("Arial", Font.BOLD, 30));
		this.labelTitolo.setForeground(Colori.purple);
		this.labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo.setVerticalAlignment(JLabel.CENTER);
		this.panelTitolo.add(this.labelTitolo);
		this.panelTitolo.setPreferredSize(new Dimension(900, 35)); //larghezza, altezza
		this.panelTitolo.setBackground(Colori.arancione);
		
		//COMBOBOX X VISUALIZZARE CENTRI CERCATI
		this.panelBox = new JPanel();
		this.panelBox.setLayout(new BorderLayout());
		this.sceltaCentro = new JComboBox<String>();
		this.sceltaCentro.setName("ComboBoxCentroInfo");
		this.panelBox.add(this.sceltaCentro);
		this.panelBox.setPreferredSize(new Dimension(800, 25));
		
		//PANEL CHE CONTIENE INFO CENTRI
		this.panelInformazioni = new JPanel();
		this.panelInformazioni.setLayout(new GridLayout(4,2));
		
		this.nome = new JLabel("Nome Centro:");
		this.infoNome = new JLabel("Default");
		
		this.tipologia = new JLabel("Tipologia Centro:");
		this.infoTipologia = new JLabel("Default");
		
		this.indirizzo = new JLabel("Indirizzo Centro:");
		this.infoIndirizzo = new JLabel("Default");
		
		this.numeroSegnalazioni = new JLabel("Numero Segnalazioni:");
		this.infoNumeroSegnalazioni = new JLabel("Default");
		
		this.panelInformazioni.add(nome);
		this.panelInformazioni.add(infoNome);
		this.panelInformazioni.add(tipologia);
		this.panelInformazioni.add(infoTipologia);
		this.panelInformazioni.add(indirizzo);
		this.panelInformazioni.add(infoIndirizzo);
		this.panelInformazioni.add(numeroSegnalazioni);
		this.panelInformazioni.add(infoNumeroSegnalazioni);
		
		this.panelInformazioni.setPreferredSize(new Dimension(800, 180));
		
		
		//TITOLO 1 
		this.panelTitolo1 = new JPanel();
		this.panelTitolo1.setLayout(new BorderLayout());
		this.labelTitolo1 = new JLabel("Severità Media dei Sintomi:");
		this.labelTitolo1.setFont(new Font("Arial", Font.PLAIN, 30));
		//this.labelTitolo.setForeground(Colori.arancione);
		this.labelTitolo1.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitolo1.setVerticalAlignment(JLabel.CENTER);
		this.panelTitolo1.add(this.labelTitolo1);
		this.panelTitolo1.setPreferredSize(new Dimension(700, 35)); //larghezza, altezza
		
		//PANEL CHE CONTIENE MEDIA SINTOMI
		this.panelSintomi = new JPanel();
		this.panelSintomi.setLayout(new GridLayout(3,2));
		this.panelSintomi.setPreferredSize(new Dimension(800, 130));
		
		this.maleTesta = new JLabel("- Mal di Testa:");
		this.infoMaleTesta = new JLabel("--/5");
		
		this.febbre = new JLabel("- Febbre:");
		this.infoFebrre = new JLabel("--/5");
		
		this.dolori = new JLabel("- Dolori Muscolari e Articolari:");
		this.infoDolori = new JLabel("--/5");
		
		this.linfoadenopatia = new JLabel("- Linfoadenopatia:");
		this.infoLinfoadenopatia = new JLabel("--/5");
		
		this.tachicardia = new JLabel("- Tachicardia:");
		this.infotachicardia = new JLabel("--/5");
		
		this.crisiIpertensiva = new JLabel("- Crisi Ipertensiva:");
		this.infoCrisiIpertensiva = new JLabel("--/5");
		
		
		this.panelSintomi.add(maleTesta);
		this.panelSintomi.add(infoMaleTesta);
		this.panelSintomi.add(febbre);
		this.panelSintomi.add(infoFebrre);
		this.panelSintomi.add(dolori);
		this.panelSintomi.add(infoDolori);
		this.panelSintomi.add(linfoadenopatia);
		this.panelSintomi.add(infoLinfoadenopatia);
		this.panelSintomi.add(tachicardia);
		this.panelSintomi.add(infotachicardia);
		this.panelSintomi.add(crisiIpertensiva);
		this.panelSintomi.add(infoCrisiIpertensiva);
		
		
		this.contenitorePrincipale = new JPanel();
		this.contenitorePrincipale.setBackground(Colori.purple);
		this.contenitorePrincipale.add(panelTitolo);
		this.contenitorePrincipale.add(panelBox);
		this.contenitorePrincipale.add(panelInformazioni);
		this.contenitorePrincipale.add(panelTitolo1);
		this.contenitorePrincipale.add(panelSintomi);
		
		
	}


	//metodo che ritorna riferimento al Panel Intestazione della schermata
	public JPanel retIntestazione() {
		return this.intestazione;
	}
					
	//metodo che ritorna riferimento al Panel contenitore, ovvero al corpo della schermata
	public JPanel retContenitore() {
		return this.contenitorePrincipale;
	}
	
	//elenco dei centri
	public JComboBox<String> retComboBox() {
		return this.sceltaCentro;
	}
	
	//resetta la combo box contenente i centri vaccinali
	public void resetComboBox() {
		this.sceltaCentro.removeAllItems();
	}
	
	//inserisce nella comboBox centri ricercati
	public void aggiungiCentroInComboBox(String centro) {
		this.sceltaCentro.addItem(centro);
	}
	
	//ritorna indice elemento selezionato della ComboBox
	public void retIndiceCentroSelezionatoComboBox() {
		this.sceltaCentro.getSelectedIndex();
	}
	
	//ritorna elemento selezionato della ComboBox
	public void retCentroSelezionatoComboBox() {
		this.sceltaCentro.getSelectedItem();
	}
	
	
	//SETTA INFO LABEL CON PARAMETRO PASSATO
	public void setNomeCentro(String txt) {
		this.nome.setVisible(true);
		this.infoNome.setVisible(true);
		this.infoNome.setText(txt);
	}
	
	public void setTipologiaCentro(String txt) {
		this.tipologia.setVisible(true);
		this.infoTipologia.setVisible(true);
		this.infoTipologia.setText(txt);
	}
	
	public void setIndirizzoCentro(String txt) {
		this.indirizzo.setVisible(true);
		this.infoIndirizzo.setVisible(true);
		this.infoIndirizzo.setText(txt);
	}
	
	public void setNumeroSegnalazioni(String txt) {
		this.numeroSegnalazioni.setVisible(true);
		this.infoNumeroSegnalazioni.setVisible(true);
		this.infoNumeroSegnalazioni.setText(txt);
	}
	
	
	//SETTA INFO LABEL SEVERITA' CON PARAMETRO PASSATO
	public void setMalDiTesta(String txt) {
		this.maleTesta.setVisible(true);
		this.infoMaleTesta.setVisible(true);
		this.infoMaleTesta.setText(txt + "/5");
	}
	
	public void setDolori(String txt) {
		this.dolori.setVisible(true);
		this.infoDolori.setVisible(true);
		this.infoDolori.setText(txt + "/5");
	}
	
	public void setFebbre(String txt) {
		this.febbre.setVisible(true);
		this.infoFebrre.setVisible(true);
		this.infoFebrre.setText(txt + "/5");
	}
	
	public void setLinfoadenopatia(String txt) {
		this.linfoadenopatia.setVisible(true);
		this.infoLinfoadenopatia.setVisible(true);
		this.infoLinfoadenopatia.setText(txt + "/5");
	}
	
	public void setTachicardia(String txt) {
		this.maleTesta.setVisible(true);
		this.infotachicardia.setVisible(true);
		this.infotachicardia.setText(txt + "/5");
	}
	
	public void setCrisi(String txt) {
		this.crisiIpertensiva.setVisible(true);
		this.infoCrisiIpertensiva.setVisible(true);
		this.infoCrisiIpertensiva.setText(txt + "/5");
	}
	
	
	
	//SETTA INFO LABEL CON PARAMETRO PASSATO --> NON VISUALIZZA INFO
	public void setNomeCentroNOVISUAL(String txt) {
		this.nome.setVisible(false);
		this.infoNome.setVisible(false);
		this.infoNome.setText(txt);
	}
		
	public void setTipologiaCentroNOVISUAL(String txt) {
		this.tipologia.setVisible(false);
		this.infoTipologia.setVisible(false);
		this.infoTipologia.setText(txt);
	}
	
	public void setIndirizzoCentroNOVISUAL(String txt) {
		this.indirizzo.setVisible(false);
		this.infoIndirizzo.setVisible(false);
		this.infoIndirizzo.setText(txt);
	}
		
	public void setNumeroSegnalazioniNOVISUAL(String txt) {
		this.numeroSegnalazioni.setVisible(false);
		this.infoNumeroSegnalazioni.setVisible(false);
		this.infoNumeroSegnalazioni.setText(txt);
	}	
	
	
	//SETTA INFO LABEL SEVERITA' CON PARAMETRO PASSATO --> NON VISUALIZZA INFO
	public void setMalDiTestaNOVISUAL(String txt) {
		this.maleTesta.setVisible(false);
		this.infoMaleTesta.setVisible(false);
		this.infoMaleTesta.setText(txt + "/5");
	}
	
	public void setDoloriNOVISUAL(String txt) {
		this.dolori.setVisible(false);
		this.infoDolori.setVisible(false);
		this.infoDolori.setText(txt + "/5");
	}
	
	public void setFebbreNOVISUAL(String txt) {
		this.febbre.setVisible(false);
		this.infoFebrre.setVisible(false);
		this.infoFebrre.setText(txt + "/5");
	}
	
	public void setLinfoadenopatiaNOVISUAL(String txt) {
		this.linfoadenopatia.setVisible(false);
		this.infoLinfoadenopatia.setVisible(false);
		this.infoLinfoadenopatia.setText(txt + "/5");
	}
	
	public void setTachicardiaNOVISUAL(String txt) {
		this.maleTesta.setVisible(false);
		this.infotachicardia.setVisible(false);
		this.infotachicardia.setText(txt + "/5");
	}
	
	public void setCrisiNOVISUAL(String txt) {
		this.crisiIpertensiva.setVisible(false);
		this.infoCrisiIpertensiva.setVisible(false);
		this.infoCrisiIpertensiva.setText(txt + "/5");
	}
	

}

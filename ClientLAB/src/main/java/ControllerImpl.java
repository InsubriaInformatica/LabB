//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

/**
 * classe che gestisce gli eventi generati dall'utente
 * @author Gabriele Sassi
 *
 */
public class ControllerImpl implements ActionListener{
	
	private View v;
	private Model m; 
	
	/**
	 * Costruttore della classe
	 * @param v
	 * @param m
	 */
	public ControllerImpl(View v, Model m) {
		this.v = v;
		this.m = m;
		
		//cattura bottoni		
		JButton back = this.v.getBack();
		back.addActionListener(this);
		
		JButton[] sceltaUtente = this.v.getSceltaTipoUtente();
		sceltaUtente[0].addActionListener(this);
		sceltaUtente[1].addActionListener(this);
		
		JButton impostazioni = this.v.getButtonImpostazioni();
		impostazioni.addActionListener(this);
		
		JButton cambioIp = this.v.getButtonCambioIP();
		cambioIp.addActionListener(this);
		
		JButton dataset = this.v.getButtonDataset();
		dataset.addActionListener(this);
		
		JButton[] funzionalitaOperatore = this.v.getBottoniFunzionalitaOperatore();
		funzionalitaOperatore[0].addActionListener(this);
		funzionalitaOperatore[1].addActionListener(this);
		
		JButton registraNuovoCentro = this.v.getBottoneRegistraNuovoCentro();
		registraNuovoCentro.addActionListener(this);
		
		JButton registraNuovoVaccinato = this.v.getBottoneRegistraNuovoVaccinato();
		registraNuovoVaccinato.addActionListener(this);
		
		JButton[] funzionalitaCittadino = this.v.getBottoniFunzionalitaCittadino();
		funzionalitaCittadino[0].addActionListener(this);
		funzionalitaCittadino[1].addActionListener(this);
		funzionalitaCittadino[2].addActionListener(this);
		
		JButton registrati = this.v.getBottoneRegistrati();
		registrati.addActionListener(this);
		
		JButton[] cercaCentri = this.v.getCercaInfoCentriVaccinali();
		cercaCentri[0].addActionListener(this);
		cercaCentri[1].addActionListener(this);
		
		JButton accedi = this.v.getBottonePerLogin();
		accedi.addActionListener(this);
		
		JButton registratiDaLogin = this.v.getBottoneRegistrazioneDaLogin();
		registratiDaLogin.addActionListener(this);
		
		JButton inserisciEA = this.v.getBottonePerInserireEventoAvverso();
		inserisciEA.addActionListener(this);
		
		JComboBox visualizzaCentrixInfo = this.v.boxSceltaCentroGetInfo();
		visualizzaCentrixInfo.addActionListener(this);
		
	}

	/**
	 * e --> evento generato
	 */
	public void actionPerformed(ActionEvent e) {
		
		String source = null;
		Object dati = null;
		
		if(e.getSource() instanceof JButton) {
			JButton bottoneOrigine = (JButton) e.getSource(); //recupera origine --> quale bottone ho cliccato
			source = bottoneOrigine.getName();
		}
		
		if(e.getSource() instanceof JTextField) {
			JTextField textFieldOrigine = (JTextField) e.getSource(); //recupera origine
			source = textFieldOrigine.getName();
		}
		
		if(e.getSource() instanceof JComboBox) {
			JComboBox comboBoxOrigine = (JComboBox) e.getSource(); //recupera origine
			source = comboBoxOrigine.getName();
		}
		
		if(e.getSource() instanceof JRadioButton) {
			JRadioButton radioButtonOrigine = (JRadioButton) e.getSource(); //recupera origine
			source = radioButtonOrigine.getName();
		}
		
		
		String click = (String)source;
		
		if(click.equals("INDIETRO")) {
			dati = null; //non serve passare nulla
		}
		
		if(click.equals("OPERATORE")) {
			dati = null; //non serve passare nulla
		}
		
		if(click.equals("CITTADINO")) {
			dati = null; //non serve passare nulla
		}
		
		if(click.equals("IMPOSTAZINI-IP")) {
			dati = null;
		}
		
		if(click.equals("cambiaIP")) {
			dati = this.v.getNuovoIP();
		}
		
		if(click.equals("REGISTRA NUOVO CENTRO")) {
			dati = null;
		}
		
		if(click.equals("REGISTRA CENTRO")) {
			dati = this.v.getDatiRegistraNuovoCentro();
		}
		
		if(click.equals("REGISTRA NUOVO VACCINATO")) {
			dati = null;
		}
		
		if(click.equals("REGISTRA VACCINATO")) {
			dati = this.v.getDatiRegistraNuovoVaccinato();
		}
		
		if(click.equals("REGISTRATI")) {
			dati = null;
		}
		
		if(click.equals("CONFERMA-REGISTRAZIONE")) {
			dati = v.getDatiPerRegistrazione();
		}
		
		if(click.equals("INFO CENTRI VACCINALI")) {
			dati = null;
		}
		
		if(click.equals("INSERISCI EVENTI AVVERSI")) {
			dati = null;
		}
		
		if(click.equals("CercaNome")) {
			List<String> esito = new ArrayList<String>();
			esito.add(togliSpazi(this.v.getDatiNomeCentroPerConsultareInfo()));
			esito.add(togliSpazi(this.v.getDatiComuneTipologiaPerConsultareInfo().get(0)));
			esito.add(this.v.getDatiComuneTipologiaPerConsultareInfo().get(1));
			dati = esito;
		}
		
		if(click.equals("CercaComune")) {
			List<String> esito = new ArrayList<String>();
			esito.add(togliSpazi(this.v.getDatiNomeCentroPerConsultareInfo()));
			esito.add(togliSpazi(this.v.getDatiComuneTipologiaPerConsultareInfo().get(0)));
			esito.add(this.v.getDatiComuneTipologiaPerConsultareInfo().get(1));
			dati = esito;
			
		}
		
		if(click.equals("ComboBoxCentroInfo")) {
			List<String> risultato = new ArrayList<String>();
			risultato.add(togliSpazi(this.v.getDatiNomeCentroPerConsultareInfo()));
			risultato.add(togliSpazi(this.v.getDatiComuneTipologiaPerConsultareInfo().get(0)));
			risultato.add(this.v.getDatiComuneTipologiaPerConsultareInfo().get(1));
			dati = risultato;	
		}
		
		if(click.equals("ACCEDI")) {
			dati = this.v.getDatiPerLogin();
		}
		
		if(click.equals("REGISTRATI-Login")) {
			dati = null;
		}
		
		if(click.equals("CONFERMA EVENTO AVVERSO")) {
			dati = this.v.getDatiInserisciEventoAvverso();
		}
		
		m.updateModel(source, dati); //elabora dati sul bottone d'origine
		
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

}

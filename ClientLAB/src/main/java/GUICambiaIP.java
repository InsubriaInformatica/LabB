//Ademi Qaldo 746362 Va
//Battaglia Simone 744514 Va
//Brullo Enrico 744949 Va
//Sassi Gabriele 745081 Va

import java.awt.*;

import javax.swing.*;

/**
 * 
 * Classe che implementa la GUI per poter cambiare l'ip del server su cui connettersi
 * @author Enrico Brullo
 *
 */
public class GUICambiaIP {
	
	private JPanel intestazione;
	
	private JPanel panelJOptionIP;
	private JPanel panelInserimentoIP;
	private JLabel labelIP;
	private JTextField txtIP;
	private JButton buttonCambiaIP;
	private JButton buttonDataset;
	private JOptionPane finestraIP;
	private JLabel spazioVuoto;
	
	/**
	 * Costruttore della classe
	 * @param larghezza
	 * @param altezza
	 * @param intestazione
	 */
	public GUICambiaIP(int larghezza, int altezza, JPanel intestazione) {
		this.intestazione = intestazione;
		
		this.panelJOptionIP = new JPanel();
		this.panelJOptionIP.setLayout(new GridLayout(2,1));
		
		this.panelInserimentoIP = new JPanel();
		this.panelInserimentoIP.setLayout(new BorderLayout());
		
		this.labelIP = new JLabel("SERVER IP:");
		this.txtIP = new JTextField("localhost", 20);
		this.panelInserimentoIP.add(this.labelIP, BorderLayout.WEST);
		this.panelInserimentoIP.add(this.txtIP, BorderLayout.EAST);
		
		this.buttonDataset = new JButton("Dataset");
		this.buttonDataset.setName("Dataset");
		
		this.buttonCambiaIP = new JButton("CAMBIA IP SERVER");
		this.buttonCambiaIP.setName("cambiaIP");
		
		spazioVuoto = new JLabel();
		
		this.finestraIP = new JOptionPane();
		
		this.panelJOptionIP.add(panelInserimentoIP);
		this.panelJOptionIP.add(spazioVuoto);
		this.panelJOptionIP.add(buttonCambiaIP);
		this.panelJOptionIP.add(buttonDataset);
		
	}
	
	/**
	 * Metodo che mostra finestra per cambio IP
	 */
	public void mostraFinestraCambioIp() {
		this.finestraIP.showOptionDialog(null, this.panelJOptionIP, "CAMBIA IP SERVER", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
	}
	
	/**
	 * Metodo che chiude JOption pane
	 */
	public void chiudiFinestra() {
		this.finestraIP.getRootFrame().dispose();
	}
	
	/**
	 * Metodo che nasconde finestra
	 */
	public void nascondiFinestra() {
		this.finestraIP.setVisible(false);;
	}
	
	/**
	 * Metodo che prende IP inserito
	 * @return
	 */
	public String getIPInserito() {
		return this.txtIP.getText();
	
	}
	
	/**
	 * Bottone per cambiare IP
	 * @return
	 */
	public JButton retButtonCambiaIP() {
		return this.buttonCambiaIP;
	}
	
	public JButton retButtonDataset() {
		return this.buttonDataset;
	}

}

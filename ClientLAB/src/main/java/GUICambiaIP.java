
import java.awt.*;

import javax.swing.*;

public class GUICambiaIP {
	
	private JPanel intestazione;
	
	private JPanel panelJOptionIP;
	private JPanel panelInserimentoIP;
	private JLabel labelIP;
	private JTextField txtIP;
	private JButton buttonCambiaIP;
	private JOptionPane finestraIP;
	
	
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
		
		
		this.buttonCambiaIP = new JButton("CAMBIA IP SERVER");
		this.buttonCambiaIP.setName("cambiaIP");
		
		this.finestraIP = new JOptionPane();
		
		this.panelJOptionIP.add(panelInserimentoIP);
		this.panelJOptionIP.add(buttonCambiaIP);
		
	}
	
	//metodo che mostra finestra per cambio IP
	public void mostraFinestraCambioIp() {
		this.finestraIP.showOptionDialog(null, this.panelJOptionIP, "CAMBIA IP SERVER", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
	}
	
	//chiude JOption pane
	public void chiudiFinestra() {
		this.finestraIP.getRootFrame().dispose();
	}
	
	//prende IP inserito
	public String getIPInserito() {
		return this.txtIP.getText();
	
	}
	
	public JButton retButtonCambiaIP() {
		return this.buttonCambiaIP;
	}

}



import java.awt.*;

import javax.swing.*;

//componenti grafici operatore
public class CittadinoGUI {
	
	private JPanel intestazione;
	private JPanel contenitoreCittadini;
	
	private JLabel labelPortaleCittadini;
	
	private JButton ConsultaInfo;
	private JButton Registrati;
	private JButton inserisciAvversita;
	
	public CittadinoGUI(int larghezza, int altezza, JPanel intestazione) {
		this.intestazione = intestazione;
		
		
		this.contenitoreCittadini = new JPanel();
		//this.contenitoreCittadini.setLayout(new GridLayout(3,3, 20, 20));
		this.contenitoreCittadini.setLayout(new BorderLayout());
		this.contenitoreCittadini.setPreferredSize(new Dimension(larghezza, altezza/10*7)); //size
		
		labelPortaleCittadini = new JLabel();
		this.labelPortaleCittadini.setText("PORTALE CITTADINI");
		this.labelPortaleCittadini.setFont(new Font("Arial", Font.BOLD, 40));
		this.labelPortaleCittadini.setHorizontalAlignment(JLabel.CENTER);
		this.labelPortaleCittadini.setVerticalAlignment(JLabel.CENTER);
		labelPortaleCittadini.setBounds(0,0,900,150);
	

		Registrati = new JButton("REGISTRATI");
		Registrati.setText("REGISTRATI");
		//Registrati.setToolTipText("sono passato sopra");
		Registrati.setBounds(750,20,120,50);
		
		ConsultaInfo = new JButton("CONSULTA INFO CENTRI VACCINALI");
		ConsultaInfo.setText("CONSULTA INFO CENTRI VACCINALI");
		ConsultaInfo.setBounds(750,20,120,50);
		
		inserisciAvversita = new JButton("INSERISCI EVENTI AVVERSI");
		inserisciAvversita.setText("INSERISCI EVENTI AVVERSI");
		inserisciAvversita.setBounds(750,20,120,50);
		
		contenitoreCittadini.add(this.labelPortaleCittadini);
		contenitoreCittadini.add(this.Registrati);
		contenitoreCittadini.add(this.ConsultaInfo);
		contenitoreCittadini.add(this.inserisciAvversita);
		
		
	}
	
	//metodo che ritorna riferimento al Panel Intestazione della schermata
			public JPanel retIntestazione() {
				return this.intestazione;
			}
			
			//metodo che ritorna riferimento al Panel contenitore, ovvero al corpo della schermata
			public JPanel retContenitore() {
				return this.contenitoreCittadini;
			}
			
			
	
	
	

}

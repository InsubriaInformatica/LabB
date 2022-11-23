/**
 * La classe Controller utilizza il PATTERN MVC per gestire gli eventi generati dall'utente
 */
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


public class Controller implements ActionListener{

	
	private ModelInterface model;
	private ViewInterface view;
	
	/**
	 * salva riferimenti view e model, aggiunge bottone avvia server per gestire evento
	 * @param model
	 * @param view
	 */
	public Controller(ModelInterface model,ViewInterface view ) {
		this.model = model;
		this.view = view;
		
		/**
		 * cattura il bottone "Accendi Server" e lo aggiunge ad eventi
		 */
		JButton buttonAvvia = this.view.retButtonAvvia();
		buttonAvvia.addActionListener(this);	
		
		JButton buttonSpegni = this.view.retButtonSpegni();
		buttonSpegni.addActionListener(this);
	}
	
	@Override
	/**
	 * questo metodo viene richiamato ogni volta che un bottone viene premuto.
	 * riconosce quale bottone Ë stato premuto e agisce di conseguenza
	 */
	public void actionPerformed(ActionEvent e) {
		
		JButton buttonOrigine = (JButton) e.getSource(); //recupera origine cliccata del bottone
		String click = buttonOrigine.getName();
		
		List <String> listaButteInfo = new ArrayList<String>(); //questa lista conterr√† info del server + origine bottone, che serve al model
	
		if(click.equals("AVVIO SERVER")) {
			List <String> datiDaServerGUI = this.view.txtInfoServer();
				
			listaButteInfo.add(buttonOrigine.getName()); //stringa "avvio server" //indice 0
				
			for(String i : datiDaServerGUI ) {
					listaButteInfo.add(i); //aggiunge alla lista le info di quella vecchia
			}
		}
		
		if(click.equals("SPEGNI SERVER")) {
			System.out.println("spengo");
			listaButteInfo.add(buttonOrigine.getName()); //stringa "spegni server" //indice 0
		}
		
		try {
			this.model.updateModel(listaButteInfo);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}

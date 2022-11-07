
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

//PATTERN MVC --> gestisce eventi generati dall'utente
public class Controller implements ActionListener{

	
	private ModelInterface model;
	private ViewInterface view;
	
	//COSTRUTTORE --> salva riferimenti view e model e aggiunge bottone avvia server per gestire evento
	public Controller(ModelInterface model,ViewInterface view ) {
		this.model = model;
		this.view = view;
		
		JButton buttonAvvia = this.view.retButtonAvvia();
		buttonAvvia.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton buttonOrigine = (JButton) e.getSource(); //recupera origine cliccata del bottone
		List <String> listaButteInfo = new ArrayList<String>(); //questa lista conterrà info del server + origine bottone, che serve al model
		List <String> datiDaServerGUI = this.view.txtInfoServer();
		
		listaButteInfo.add(buttonOrigine.getName()); //stringa "avvio server" //indice 0
		for(String i : datiDaServerGUI ) {
			listaButteInfo.add(i); //aggiunge alla lista le info di quella vecchia
		}
		
		this.model.updateModel(listaButteInfo);
		
	}
	
}


import java.awt.event.*;
import javax.swing.*;

//PATTERN MVC --> gestisce eventi generati dall'utente
public class Controller implements ActionListener{

	
	private ModelInterface model;
	private ServerGUI view;
	
	//COSTRUTTORE --> salva riferimenti view e model e aggiunge bottone avvia server per gestire evento
	public Controller(ModelInterface model,ServerGUI view ) {
		this.model = model;
		this.view = view;
		
		//JButton buttonAvvia = this.view.retButtonAvvia();
		//buttonAvvia.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.model.updateModel(e);
	}
	
}

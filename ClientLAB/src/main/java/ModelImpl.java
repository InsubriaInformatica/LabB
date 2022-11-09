import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

//gestisce la logica di funzionamento dell'applicazione
public class ModelImpl implements Model{
	
	private View v;
	private ServerInterface proxy; //chiamata locale 
	private boolean flag;

	//riferimento a view dove model dovrà operare, instanzia riferimento proxy server locale dove andrà ad operare
	public ModelImpl(View v) {
		
		try {
			
			this.v = v; //instanzia view
			this.proxy = new Proxy(InetAddress.getByName(null), 8080); //local host e porta
			
		} catch (UnknownHostException e) {
			System.err.println("CLIENT MODEL: host sconosciuto " + e.toString());
		}
		
	}
	
	//METODI PER VERIFICARE I CAMPI INSERITI
	
	//controlla se ci sono campi vuoti
	public boolean controlloStringheVuote(List<String> daControllare) {
		
		for(String str: daControllare) {
			if(str.equals("")) {
				return true; //se non contiene stringhe vuote
			}
		}
		
		return false; //se contiene stringhe vuote
	}
	
	//controlla dati inseriti per registrare il centro vaccinale
	public boolean controlloDatiNuovoCentro(List <String> datiCentro) {
		boolean res = true;
		
		//campi vuoti
		if(datiCentro.get(0).equals("") || datiCentro.get(2).equals("") || datiCentro.get(3).equals("") || datiCentro.get(4).equals("") || datiCentro.get(5).equals("") || datiCentro.get(6).equals("")  ) {
			return false;  //dati forniti non validi
		}
		
		//centro esistente
		if(this.proxy.EsisteCentroNome(datiCentro.get(0))) {
			return false; 
		}
		
		//provincia lughezza 2 caratteri
		if(datiCentro.get(5).length() != 2) {
			return false;
		}
		
		//provincia deve contenere solo lettere 
		for(int i=0; i<datiCentro.get(5).length(); i++) {
			if((!('a' <= datiCentro.get(5).charAt(i) && datiCentro.get(5).charAt(i) <= 'z')) && (!('A' <= datiCentro.get(5).charAt(i) && datiCentro.get(5).charAt(i) <= 'Z'))) {
				return false;
			}
				
		}
		
		//cap lunghezza 5
		if(datiCentro.get(6).length() != 5) {
			return false;
		}
		
		//cap deve avere solo caratteri numerici
		for(int i=0; i<datiCentro.get(6).length(); i++) {
			if(!('0' <= datiCentro.get(6).charAt(i) && datiCentro.get(6).charAt(i) <= '9')) {
				return false;
			}
				
		}
		
		return res;
		
	}
	
	
	
	public Object registraCentroVaccinale(List<String> datiCentroVaccinale) {
		
		List<String> ret = new ArrayList <String>();
	
		
		if(controlloDatiNuovoCentro(datiCentroVaccinale)) {
			this.proxy.registraCentroVaccinale(datiCentroVaccinale.get(0), datiCentroVaccinale.get(1), datiCentroVaccinale.get(2), datiCentroVaccinale.get(3), datiCentroVaccinale.get(4), datiCentroVaccinale.get(5), datiCentroVaccinale.get(6), datiCentroVaccinale.get(7));
			ret = datiCentroVaccinale;
		}
		
		else {
			if(datiCentroVaccinale.get(0).equals("") || datiCentroVaccinale.get(2).equals("") || datiCentroVaccinale.get(3).equals("") || datiCentroVaccinale.get(4).equals("") || datiCentroVaccinale.get(5).equals("") || datiCentroVaccinale.get(6).equals("")){
				ret.add("ERRORE");
				ret.add("INSERISCI TUTTI I CAMPI OBBLIGATORI (*)");
			}
		}
		
		return ret;
		
	}
	
	public void updateModel(String source, Object dati) {
		
		String button = source;
		List <String> datiPerModel = null;
		this.flag = false;
		
		if(button.equals("REGISTRA CENTRO")) {
			List<String> datiCentro = (List<String>) dati;
			
			datiPerModel = (List<String>) registraCentroVaccinale(datiCentro);
			
			if(datiPerModel.get(0).equals("ERRORE")){
				this.flag = true;
			}
		}
		
		this.v.updateView(button, datiPerModel, this.flag); //aggiorna view in base all'elaborazione
	}
	
	

}

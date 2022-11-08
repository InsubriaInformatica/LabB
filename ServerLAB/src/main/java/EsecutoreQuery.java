
import java.sql.*;

//RISORSA CONDIVISA CHE SI INTERFACCIERA' LOCALMENTE CON IL NOSTRO SKELETON e CON IL DB per eseguire query
public class EsecutoreQuery implements SkeletonInterface{
	
	private Connection connessione;
	private Statement istruzione;
	private ResultSet rs;
	private ViewInterface view;
	
	//costruttore che instanzia connessione a database
	public EsecutoreQuery(String username, String password, String host, String port, String nomeDB) {
		try {
			this.connessione = DataBaseConnessione.getConnection(username, password, host, port , nomeDB); //prende connessione al database
			this.istruzione = (Statement) connessione.createStatement(); //statement per eseguire query
			
		} catch (SQLException e) {
			System.out.println("ESECUTORE QUERY: connessione al DB non riuscita " + e.toString());
		} 
	}
	


	//registra nel database il centro vaccinale
	public synchronized int registraCentroVaccinale(String nome, String qualificatore, String indirizzo, String numeroCivico, String comune, String provincia, String Cap, String tipologia) throws SQLException {
		return 0;
	}

}

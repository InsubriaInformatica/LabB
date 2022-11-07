import java.sql.SQLException;

public interface ServerWorkerInterface {

	public int registraCentroVaccinale (String nome, String qualificatore, String indirizzo, String numeroCivico, String comune, String provincia, String Cap, String tipologia) throws SQLException;
	
}

import java.sql.SQLException;

//PATTERN SKELETON --> solleva il server dalla gestione delle comunicazioni.
public interface SkeletonInterface {

	public int registraCentroVaccinale (String nome, String qualificatore, String indirizzo, String numeroCivico, String comune, String provincia, String Cap, String tipologia) throws SQLException;
	
}

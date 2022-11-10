import java.sql.SQLException;

//PATTERN SKELETON --> solleva il server dalla gestione delle comunicazioni.
public interface SkeletonInterface {

	//inserisce il nuovo centro nel DB 
	public int registraCentroVaccinale(String nome, String qualificatore, String indirizzo, String numeroCivico, String comune, String provincia, String cap, String tipologia) throws SQLException;
	
	public int registraVaccinato(String nomeCentro, String nome, String cognome, String codiceFiscale, String dataSomministrazione, String tipoVaccino, String nDosi) throws SQLException ;
	
	public void creazioneTabelle() throws SQLException;
	
}

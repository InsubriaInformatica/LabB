import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EsecutoreQuery {
	
	public static void main(String[] args) throws SQLException {
		
		ResultSet rs; //risultato query organizzato in tabella
		String query = "select * from Cittadini";
		
		// PASSWORD DATABASE
		// Lele: Sirmione2020!
		// Aldo: admin
		Connection c = DataBaseConnessione.getConnection("postgres", "admin", "localhost", "5432", "LabB"); //prende connessione al database
		Statement s = (Statement) c.createStatement(); //statement per eseguire query
		
	
		rs = s.executeQuery(query);
		
		//se ci sono dei dati nel result set
		while(rs.next()) {
			System.out.print(rs.getString(1) + " "); //in questo caso stampa la stringa in posizione 0esima ecc..
			System.out.print(rs.getString(2));
			System.out.print(rs.getString(3));
			System.out.println("");
		}
	}

}

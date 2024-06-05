package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.DAOException;
import exception.DBConnectionException;

public class CorsiPropedeuticiDAO {
	
	public static List<String> readCorsiPropedeutici(String codiceCorso) throws DBConnectionException, DAOException{
		
		String query = "SELECT id_corsoP FROM corsi_propedeutici WHERE id_corso = ?"; 
		List<String> listaEsamiP = new ArrayList<>();
	 
		try {
			
			Connection conn = DBManager.getConnection();
			
			try {
				
				PreparedStatement statement = conn.prepareStatement(query);
				
				statement.setString(1, codiceCorso);
				
				ResultSet result = statement.executeQuery();			
 
				while(result.next()) {
					String esameP = result.getString("id_corsoP");
					listaEsamiP.add(esameP);
				}
 
			} catch (SQLException e) {

				throw new DAOException("[CorsiPropedeuticiDAO]Nessun corso Propedeutico");

			} finally {

				DBManager.closeConnection();
			}
		} catch (SQLException e) {

			throw new DBConnectionException("[CorsiPropedeuticiDAO]Connessione al Database non riuscita");

		}
 
		return listaEsamiP;		//se un esame non ne richiede altri torna una lista vuota poichè non entra nel while
		
	}
}

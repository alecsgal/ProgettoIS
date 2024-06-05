package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exception.DAOException;
import exception.DBConnectionException;

public class DocenteDAO {

	public static boolean InserisciDocente(String Matricola, String Nome, 
											String Cognome) throws DAOException, DBConnectionException {
		
		String query="INSERT INTO  docente(Matricola, Nome, Cognome) VALUES (?,?,?)";
		
		try {
			
			Connection conn=DBManager.getConnection();
			try {
		 
				PreparedStatement stat=conn.prepareStatement(query);
				 
				stat.setString(1, Matricola);
				stat.setString(2, Nome);
				stat.setString(3, Cognome);
	 
				stat.executeUpdate();
	 
				return true;
				
			}catch(SQLException e) {
				throw new DAOException("[DocenteDAO]Impossibile aggiungere il docente");
			}
			finally {
				DBManager.closeConnection();
			}
			
		}catch(SQLException e) {
			throw new DBConnectionException("[DocenteDAO]Connessione al Database non riuscita");
		}
	}
}

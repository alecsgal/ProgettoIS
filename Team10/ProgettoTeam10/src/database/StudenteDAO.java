package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.EntityStudente;

import exception.DAOException;
import exception.DBConnectionException;

public class StudenteDAO {
	
	public static boolean readStudente(String Username, String Password) throws DAOException, DBConnectionException{
		
		String query = "SELECT Username, Password FROM studente WHERE Username = ? AND Password=?";  
	
		boolean accesso=false;
		
		try {
			
			Connection conn = DBManager.getConnection();
			
			try {
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, Username);
				statement.setString(2, Password);
				
				ResultSet result = statement.executeQuery();			
			
				if(result.next()) {
					accesso=true;  
				}
				
			} catch (SQLException e) {

				throw new DAOException("[StudenteDAO]Accesso non eseguito");

			} finally {

				DBManager.closeConnection();
			}
		} catch (SQLException e) {

			throw new DBConnectionException("[StudenteDAO]Connessione al Database non riuscita");

		}
		return accesso;
		
	}
	
	
}





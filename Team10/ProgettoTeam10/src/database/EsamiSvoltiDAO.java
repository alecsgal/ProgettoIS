package database;


import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

 

import entity.EntityEsame;
import entity.EntityStudente;
import exception.DAOException;
import exception.DBConnectionException;

public class EsamiSvoltiDAO {
	
	public static List<String> readEsamiSvolti(String username) throws DAOException, DBConnectionException{
		
		String query = "select * from esami_svolti where usernameS=?";   //Prendo la lista esami svolti di un certo studente
		List<String> esamiS = new ArrayList<String>();
	 
		try {
			
			Connection conn = DBManager.getConnection();
			
			try {
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, username);

				ResultSet result = statement.executeQuery();
 
				while(result.next()) {
					String id = result.getString("idCorso");
					esamiS.add(id);
				}
		 
			}catch (SQLException e) {

				throw new DAOException("[EsamiSvoltiDAO]Nessun esame svolto");

			}finally {

				DBManager.closeConnection();
			}
		} catch (SQLException e) {

			throw new DBConnectionException("[EsamiSvoltiDAO]Connessione al Database non riuscita");

		}
		
		return esamiS;
		
	}

	public static boolean updateEsamiSvolti(String codiceEsame, String username, List<String> esamiP,
											int valutazione, int Lode, String note_docente,String data
											,List<String> EsamiSvolti ) throws DAOException, DBConnectionException {
 
		
		String query = "INSERT INTO esami_svolti (usernameS, idCorso,Valutazione,Lode,note_docente,DataSuperamento) VALUES (?,?,?,?,?,?)";
		
		
		try {
			
			Connection conn = DBManager.getConnection();
			
			try {
	 
			  if(!esamiP.isEmpty()) {
 
				for(String esameProp:esamiP) {
					  
				   if(!EsamiSvolti.contains(esameProp)) {
				      
					  System.out.println("Non tutti gli esami propedeutici sono stati effettuati ");
					  return false;
					  
				   }
				}
			  }
				
			 PreparedStatement statement = conn.prepareStatement(query);	
			 
			 statement.setString(1, username);
		     statement.setString(2, codiceEsame);
			 statement.setInt(3, valutazione);
			 statement.setInt(4, Lode);
			 statement.setString(5, note_docente);
			 statement.setString(6,data);

			 statement.executeUpdate();                
			 
			 return true;
			
			}catch(SQLException e) {
				
				throw new DAOException("[EsamiSvoltiDAO]Nessun esame svolto");
				
			}finally {
				
				DBManager.closeConnection();
				
			}
		}catch (SQLException e) {

			throw new DBConnectionException("[EsamiSvoltiDAO]Connessione al Database non riuscita");

		}

	}
}






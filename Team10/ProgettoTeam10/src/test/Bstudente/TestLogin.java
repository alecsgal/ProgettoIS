package test.Bstudente;

import static org.junit.Assert.*;

import org.junit.Test;

import database.StudenteDAO;
import exception.DAOException;
import exception.DBConnectionException;

public class TestLogin {

	@Test
	public void testLogin() throws DAOException, DBConnectionException {
		
		//cambiare anche di poco username o password implica il fallimento del test
		String username = "user1";
		String password = "password1";
		
		boolean actual = false;
		boolean valoreAtt = true;
 
		actual = StudenteDAO.readStudente(username, password);
		
		assertEquals("Studente presente nel database", valoreAtt, actual);
	 
		//assertEquals(valoreAtt, valoreEsam);
	}



}

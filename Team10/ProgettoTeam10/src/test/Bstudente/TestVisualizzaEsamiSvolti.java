package test.Bstudente;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import database.EsamiSvoltiDAO;
import exception.DAOException;
import exception.DBConnectionException;

public class TestVisualizzaEsamiSvolti {

	@Test
	public void testVisualizzaEsamiSvolti() throws DAOException, DBConnectionException {
		
		//user 1 ha svolto vari esami, e confrontandoli con una lista vuota il test non fallisce
		List<String> listaEsami = new ArrayList<>();
		List<String> lista = new ArrayList<>();
		
		String username = "user1";
		
		listaEsami = EsamiSvoltiDAO.readEsamiSvolti(username);
		
		assertNotEquals(lista, listaEsami);
		
	}

}

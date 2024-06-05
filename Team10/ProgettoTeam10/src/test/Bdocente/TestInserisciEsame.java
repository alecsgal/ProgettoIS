package test.Bdocente;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.GestoreSegreteria;
import exception.OperationException;

public class TestInserisciEsame {
	
	//ESAMI C006-C009 RICHIESTI PER L'ESAME C004
	@Test
	public void testInserisciEsame() throws OperationException {
		
		//CASO IN CUI E' POSSIBILE AGGIUNGERE L'ESAME-SONO GIA' STATI ESEGUITI QUELLI PROPEDEUTICI
		
		String usernameS = "user1";
		String idCorso = "C004";
		int Valutazione = 28;
		int lode = 0; 
		String Data = "12-05-2023";
		String Note_Docente = "ottimo lavoro";
		
		boolean valoreAtt = true;
		boolean valoreEfft = false;
		
		valoreEfft = GestoreSegreteria.inserisciEsami(idCorso, usernameS, Valutazione, lode, Note_Docente, Data);
		
		assertEquals(valoreAtt, valoreEfft);
	}
	/*
	 * public void testInserisciEsame() throws OperationException {
		
		//CASO IN CUI NON E' POSSIBILE AGGIUNGERE L'ESAME-NON SONO GIA' STATI ESEGUITI QUELLI PROPEDEUTICI
		
		String usernameS = "user2";
		String idCorso = "C004";
		int Valutazione = 28;
		int lode = 0; 
		String Data = "12-05-2023";
		String Note_Docente = "ottimo lavoro";
		
		boolean valoreAtt = true;
		boolean valoreEfft = false;
		
		valoreEfft = GestoreSegreteria.inserisciEsami(idCorso, usernameS, Valutazione, lode, Note_Docente, Data);
		
		assertEquals(valoreAtt, valoreEfft);
	}
	*/
}



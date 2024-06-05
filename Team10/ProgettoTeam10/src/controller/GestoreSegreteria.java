package controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import database.CorsiPropedeuticiDAO;
import database.EsamiSvoltiDAO;
import database.StudenteDAO;
import entity.EntityStudente;
import exception.DAOException;
import exception.DBConnectionException;
import exception.OperationException;



public class GestoreSegreteria {
	
	private static GestoreSegreteria gS = null;
	
	public static GestoreSegreteria getIstance() {
		
		if( gS == null)		gS = new GestoreSegreteria();
		
		return gS;
	}
	
	public boolean login(String Username, String Password) throws OperationException {
		
		boolean riuscito=false;
		boolean accessoEseguito=false;
		
		try {
			 
			riuscito=StudenteDAO.readStudente(Username, Password);
			 
			if(riuscito){	
				accessoEseguito=true;
			} 
		
		}catch(DBConnectionException dbEx) {
			
			throw new OperationException("\n[GestoreSegreteria]Riscontrato problema interno applicazione!\n");

		}catch(DAOException ex) {

			throw new OperationException("\n[GestoreSegreteria]Ops, qualcosa e' andato storto..");
		}
		
		return accessoEseguito;
	}
	
	
	public List<String> visualizzaEsamisvolti(String username) throws OperationException{
		
		List<String> listaEsamiS = new ArrayList<String>();
		
		try {
		
			listaEsamiS = EsamiSvoltiDAO.readEsamiSvolti(username);
			
		}catch(DBConnectionException dbEx) {
			
			throw new OperationException("\n[GestoreSegreteria]Riscontrato problema interno applicazione!\n");

		}catch(DAOException ex) {

			throw new OperationException("[GestoreSegreteria]Ops, qualcosa e' andato storto..");
		}
		
		return listaEsamiS;		
	}

	
	public static boolean inserisciEsami(String CodiceCorso, String username, int Valutazione, int lode,
											String note_docente, String data) throws OperationException {
		
		List<String> corsiPropedeutici = new ArrayList<String>();
		List<String> EsamiSvolti = new ArrayList<String>();

		boolean esame=false;
		
		try {
			
			corsiPropedeutici = CorsiPropedeuticiDAO.readCorsiPropedeutici(CodiceCorso);	
	 
			EsamiSvolti = EsamiSvoltiDAO.readEsamiSvolti(username);												
			
			esame = EsamiSvoltiDAO.updateEsamiSvolti(CodiceCorso, username, corsiPropedeutici, Valutazione,
																lode, note_docente, data,EsamiSvolti);
			
			return esame;
			
		}catch(DBConnectionException dbEx) {
			
			throw new OperationException("\n[GestoreSegreteria]Riscontrato problema interno applicazione!\n");

		}catch(DAOException ex) {

			throw new OperationException("[GestoreSegreteria]Ops, qualcosa e' andato storto..");
		}
		
	}
	
	
}


/*

*/

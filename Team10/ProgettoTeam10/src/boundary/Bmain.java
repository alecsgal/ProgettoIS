package boundary;

import java.util.NoSuchElementException;
import java.util.Scanner;

import exception.OperationException;

public class Bmain {

	public static void main(String [] args) throws OperationException {
		
		boolean input = true, flag = false;
        Scanner scan = new Scanner(System.in);
        String scelta = null, operazione = null;
 
        System.out.println("\n-----Benvenuto al Conservatorio-----");
        
        while (input){
        	System.out.println("Che ruolo ricopri?"+ 
	  				"(Digita il numero alla sinistra dell'operazione)");
            System.out.println("1) STUDENTE "+"\n" + "2) DOCENTE");
            
            try {
            	
            	scelta = scan.nextLine();
            	
            	switch(scelta) {
            	
            		case "1":
            		  flag = false;
            		  while(!flag) {
            				
            			try{
            			  System.out.println("\nQuale operazione vuoi eseguire? ");
                          System.out.println("0) INDIETRO"+"\n" + "1) LOGIN" + "\n"+ "2) VISUALIZZA ESAMI SVOLTI"+ "\n");
                          
                          operazione = scan.nextLine();
                          
                          switch(operazione) {
                          	
                          	case "0":
                          		flag = true;
                          		break;

                          	case "1":
                          		bStudenti.login();
                          		flag = true;
                          		break;
                          		
                          	case "2":
                          		bStudenti.visualizzaEsamiSvolti();
                          		flag = true;
                          		break;
                          	
                          	 default: System.out.println("\nValore inserito non valido, riprova...");
                          }
                          
                          
            			}catch(NoSuchElementException e){
                                System.out.println("[BoundaryMain]Valore inserito non valido, riprovare...");
                        }
            			
            		  }
            		  break;
            		  
            		case "2":
            		  flag = false;
            		  
            		  while(!flag) {
            			 
            			try {
            				 System.out.println("\nQuale operazione vuoi eseguire?");
                             System.out.println("0) INDIETRO "+"\n" +"1) INSERISCI ESAME " + "\n");
                             
                             operazione = scan.nextLine();
                             
                             switch(operazione) {
                               
                               case "0":
                           		flag = true;
                           		break;
                           		
                               case "1":
                              	bDocenti.inserisciEsame();
                            	flag = true;
                              	break;
                              	
                               default: System.out.println("\nValore inserito non valido, riprova...");
                             }
            		    	
            		    }catch(NoSuchElementException e){
                            System.out.println("[BoundaryMain]Valore inserito non valido, riprovare...");
            		    }
            		  }
            	}
            	
            	
            } catch(NoSuchElementException e){
                System.out.println("[BoundaryMain]Valore inserito non valido, riprovare...");
            }
        }
	}
}

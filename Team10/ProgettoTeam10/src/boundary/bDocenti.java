package boundary;


import java.util.Date;
import java.util.Scanner;

import controller.GestoreSegreteria;
import exception.OperationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
 
public class bDocenti {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void inserisciEsame() throws OperationException {
		
		GestoreSegreteria gestoreSegreteria = GestoreSegreteria.getIstance();
		
		String codiceCorso = null, risposta=null,Username = null, note_docenti = null;
		boolean valido = false, inserito=false;
		int lode = 0, valutazione = 0;
		String data = null;
		

		System.out.println("\n--------Inserimento Esame--------\n");
		
		while(!valido) {
			try {
				
				System.out.println("Inserire il codice del corso: ");
				codiceCorso = scan.nextLine();
				
				if(codiceCorso.length()<4) {
					System.out.println("\nInput non valido, riprovare... ");
				}
				else if(codiceCorso.length()>5) {
					System.out.println("\nInput non valido, riprovare... ");
				}
				else if(codiceCorso.isEmpty()) {
					System.out.println("\nInput non valido, riprovare... ");
				}
				else {
					valido=true;
				}
			}catch(IllegalArgumentException e) {
				System.out.println("\n[BoundaryDocenti]Stringa inserita non valida, riprovare...");
			}
		}
		
		
		valido=false;
		while(!valido) {
			try {
				
				System.out.println("Inserire l'username dello studente: ");
				Username = scan.nextLine();
				
				if(Username.length()>10) {
					System.out.println("\nInput non valido, riprovare... ");
				}
				else if(Username.isEmpty()) {
					System.out.println("\nInput non valido, riprovare... ");
				}
				else {
					valido=true;
				}
			}catch(IllegalArgumentException e) {
				System.out.println("\n[BoundaryDocenti]Stringa inserita non valida, riprovare...");
			}
		}
		
		
		
		valido=false;
		while(!valido) {
			try {
				
				System.out.println("Inserire la Valutazione: ");
				valutazione = scan.nextInt();
				scan.nextLine();
				
				if(valutazione < 18 || valutazione > 30) {
					System.out.println("\nInput non valido, riprovare... ");
				}else {
			
				  if(valutazione == 30) {
					boolean lodevalida=false;
					while(!lodevalida) {
						System.out.println("Si vuole inserire la lode? s/n: ");
						risposta = scan.nextLine();
						
						if (risposta.equalsIgnoreCase("s")) {
				            System.out.println("Hai scelto di inserire la lode.");
				            lode = 1;
				            lodevalida=true;
				     
				        } else if (risposta.equalsIgnoreCase("n")) {
				        	lode=0;
				        	lodevalida=true;
			
				            System.out.println("Hai scelto di non inserire la lode.");
				        } else {
				            System.out.println("Risposta non valida, riprovare.");
				        }
					}
					
					
				  }
				  valido=true;
				}
			}catch(IllegalArgumentException e) {
				 System.out.println("\n[BoundaryDocenti]Stringa inserita non valida, riprovare...");
			}
		}
		
		valido=false;
		while(!valido) {
			try {
				
				System.out.println("Inserire note docenti:");
				note_docenti = scan.nextLine();
				
				if(note_docenti.length()>50) {
					System.out.println("Input non valido.");
				}
				else {
					valido=true;
				}
			}catch(IllegalArgumentException e) {
				System.out.println("\n[BoundaryDocenti]Stringa inserita non valida, riprovare...");
			}
		}
		
		valido = false;
	    while (!valido){
	    	try {
	    		
	    		System.out.println("Inserire la data (dd-MM-yyyy): ");
	            data = scan.nextLine();

	            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	            sdf.setLenient(false); // Imposta lenienza a false per una rigorosa verifica della data
	            Date date = sdf.parse(data);
	            valido = true; // Se parse non lancia un'eccezione, la data è valida
	            
	    	} catch (ParseException e) {
	                System.out.println("Data non valida, riprovare...");
	        }
	    }
 
		
			
		try {
			
			inserito=GestoreSegreteria.inserisciEsami(codiceCorso, Username, valutazione, lode, note_docenti,data);
			
			if(inserito) {
				System.out.println("Esame inserito");
			}
			else {
				System.out.println("Impossibile inserire esame");
			}
		}catch (OperationException e){
			
			System.out.println("\n[Boundary Docenti]Qualcosa e' andato storto...");
		}
 
		
	}
}

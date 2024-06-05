package entity;

import java.util.List;

public class EntityStudente {
	    private String Username;
	    private String Password;
	    private int Pin;
	    private String Nome;
	    private String Cognome;
	    private Double MediaPonderata;
	    private Double MediaAritmetica;
	    public EntityStudente(String Username,String Password,int Pin,String Nome, String Cognome,
	    					Double MediaPonderata, Double MediaAritmetica) 
	    
	    {
	    	super();
	    	this.Username=Username;
	    	this.Password=Password;
	    	this.Pin=Pin;
	    	this.Nome=Nome;
	    	this.Cognome=Cognome;
	    	this.MediaPonderata=MediaPonderata;
	    	this.MediaAritmetica=MediaAritmetica;
	
	    }
	
	        public String getUsername() {
	            return Username;
	        }

	        public String getPassword() {
	            return Password;
	        }

	        public int getPin() {
	            return Pin;
	        }

	        public String getNome() {
	            return Nome;
	        }

	        public String getCognome() {
	            return Cognome;
	        }

	        

	        public Double getMediaPonderata() {
	            return MediaPonderata;
	        }

	        public Double getMediaAritmetica() {
	            return MediaAritmetica;
	        }

	       
	        public void setUsername(String Username) {
	            this.Username = Username;
	        }

	        public void setPassword(String Password) {
	            this.Password = Password;
	        }

	        public void setPin(int Pin) {
	            this.Pin = Pin;
	        }

	        public void setNome(String Nome) {
	            this.Nome = Nome;
	        }

	        public void setCognome(String Cognome) {
	            this.Cognome = Cognome;
	        }

	       

	        public void setMediaPonderata(Double MediaPonderata) {
	            this.MediaPonderata = MediaPonderata;
	        }

	        public void setMediaAritmetica(Double MediaAritmetica) {
	            this.MediaAritmetica = MediaAritmetica;
	        }
	    }



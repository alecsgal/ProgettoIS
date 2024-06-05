package entity;



public class EntityEsame {
		private int Valutazione;
		private Boolean Lode;
		private String Note_Docente;
		private String codiceEsame;
		private String UsernameS;
		private String Data;
		
		public EntityEsame(int Valutazione, boolean Lode, String Note_Docente, String Data, String codiceEsame, String UsernameS) {
		    super();
			this.Valutazione = Valutazione;
		    this.Lode = Lode;
		    this.Note_Docente =Note_Docente;
		    this.Data = Data;
		    this.codiceEsame = codiceEsame;
		    this.UsernameS = UsernameS;
		    }

		    public int getValutazione() {
		        return Valutazione;
		    }

		    public boolean isLode() {
		        return Lode;
		    }

		    public String getNoteDocente() {
		        return Note_Docente;
		    }

		    public String getData() {
		        return Data;
		    }

		    public String getCodiceEsame() {
				return codiceEsame;
			}



			public String getUsernameS() {
				return UsernameS;
			}
			
			public void setCodiceEsame(String codiceEsame) {
				this.codiceEsame = codiceEsame;
			}

			public void setUsernameS(String usernameS) {
				UsernameS = usernameS;
			}

			public void setValutazione(int Valutazione) {
		        this.Valutazione = Valutazione;
		    }

		    public void setLode(boolean Lode) {
		        this.Lode = Lode;
		    }

		    public void setNoteDocente(String Note_Docente) {
		        this.Note_Docente = Note_Docente;
		    }

		    public void setData(String Data) {
		        this.Data = Data;
		    }
		}


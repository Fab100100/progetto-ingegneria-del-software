package entity;
import java.util.ArrayList;
import java.util.Date;

import database.DBUtente;
import database.DBViaggio;

public class Viaggio {
	
	
        private String idViaggio;	
        private String partenza;
        private String destinazione;
	    private String dataOra;
	    private float contributo;
	    private float incasso_totale=0;
	    
	
	    private Autista autista;
	    private ArrayList<Prenotazione> prenotazioni;
	    
	    
	    

		public Viaggio(String idViaggio) {
			
			DBViaggio viaggio=new DBViaggio(idViaggio);
			
			this.idViaggio=idViaggio;
			this.partenza = viaggio.getPartenza(); 
			this.destinazione = viaggio.getDestinazione();
			this.dataOra = viaggio.getDataOra();
			
			this.contributo=viaggio.getContributo();
			this.incasso_totale=viaggio.getIncasso_totale();
			this.prenotazioni = new ArrayList<>();
			
			
			
			viaggio.caricaPrenotazioniDaDB();
			
			caricaPrenotazione(viaggio);
			
			
		
		}
		
		public void caricaPrenotazione(DBViaggio viaggio) {
			
			for(int i=0;i<viaggio.getPrenotazioni().size();i++) {
				
				
				
				
			   Prenotazione prenotazione=new Prenotazione(viaggio.getPrenotazioni().get(i));
	
			  
			   
				this.prenotazioni.add(prenotazione);
				
			
				
				
			
			}
			
		}
			
		
		public Viaggio(DBViaggio viaggio) {
			
			
			this.idViaggio=viaggio.getIdViaggio();
			this.partenza = viaggio.getPartenza(); 
			this.destinazione = viaggio.getDestinazione();
			this.dataOra = viaggio.getDataOra();
			
			this.contributo=viaggio.getContributo();
			this.incasso_totale=viaggio.getIncasso_totale();	
			
		}

		public Viaggio(String idViaggio, String partenza, String destinazione, String dataOra, float contributo) {
			this.idViaggio = idViaggio;
			this.partenza = partenza;
			this.destinazione = destinazione;
			this.dataOra = dataOra;
			
			this.contributo = contributo;
			this.prenotazioni = new ArrayList<>();
		}

		public Viaggio(String partenza, String destinazione, String dataOra, float contributo) {
			this.partenza = partenza;
			this.destinazione = destinazione;
			this.dataOra = dataOra;
		
			this.contributo = contributo;
			this.prenotazioni = new ArrayList<>();
		}

		public String getPartenza() {
			return partenza;
		}

		public void setPartenza(String partenza) {
			this.partenza = partenza;
		}

		public String getDestinazione() {
			return destinazione;
		}

		public void setDestinazione(String destinazione) {
			this.destinazione = destinazione;
		}

		public String getDataOra() {
			return dataOra;
		}

		public void setDataOra(String dataOra) {
			this.dataOra = dataOra;
		}

	
		public double getContributo() {
			return contributo;
		}

		public void setContributo(float contributo) {
			this.contributo = contributo;
		}

		

		public float getIncasso_totale() {
			return incasso_totale;
		}

		public void setIncasso_totale(float incasso_totale) {
			this.incasso_totale = incasso_totale;
		}

		public Autista getAutista() {
			return autista;
		}

		public void setAutista(Autista autista) {
			if (this.autista != autista) {
	            this.autista = autista;
	            if (autista != null && !autista.getViaggiPubblicati().contains(this)) {
	            	autista.setViaggiPubblicati(this);
	            }
	        }
		}

		
		public ArrayList<Prenotazione> getPrenotazioni() {
			return prenotazioni;
		}
		
		   public void setPrenotazione(Prenotazione prenotazione) {
			   
			
		        if (!prenotazioni.contains(prenotazione)) { 
		        	prenotazioni.add(prenotazione); 
		        	prenotazione.setViaggio(this); 
		        	
		        }
		 
		   }
		    public void rimuoviPrenotazione(Prenotazione prenotazione) {
		        if (prenotazioni.remove(prenotazione)) {
		            prenotazione.setViaggio(null);
		        }
		    }

		@Override
		public String toString() {
			final int maxLen = 10;
			return String.format(
					"Viaggio [getPartenza()=%s, getDestinazione()=%s, getDataOra()=%s, getPostiDisponibili()=%s, getContributo()=%s, getIncasso_totale()=%s, getAutista()=%s, getPrenotazioni()=%s]",
					getPartenza(), getDestinazione(), getDataOra(), getContributo(),
					getIncasso_totale(), getAutista(),
					getPrenotazioni() != null ? getPrenotazioni().subList(0, Math.min(getPrenotazioni().size(), maxLen))
							: null);
		}

		
		
	    public void IncassoTotale() {
	    	this.incasso_totale=0;
	    	
	    	
	    	
	    	for(int i=0;i<prenotazioni.size();i++) {
	    		
	    		
	    		this.incasso_totale+=prenotazioni.get(i).getCosto();
	    	
	    	}
	    	
	    
	    	
	    }
	    
	  public void printdata() {
		  
		System.out.println(this.getDataOra()) ; 
	  }
}
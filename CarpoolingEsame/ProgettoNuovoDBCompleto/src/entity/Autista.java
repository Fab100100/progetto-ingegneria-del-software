package entity;
import java.util.ArrayList;

import database.DBAutista;
import database.DBPasseggero;
import database.DBUtente;
import database.DBViaggio;
public class Autista {
	
	Utente utente;
	private ArrayList<Viaggio>viaggiPubblicati;
	Feedback feedback;
    private String idAutista;
    
    
    
	public Autista(String idAutista) {
		
		DBAutista autista=new DBAutista(idAutista);
		
		this.idAutista = idAutista;
		this.viaggiPubblicati = new ArrayList<>();	
		
		autista.caricaViaggiDaDB();
		
		caricaViaggio(autista);
		
		autista.caricaFeedbackDaDB();
		caricaFeedback(autista);
	}
	
	public void caricaFeedback(DBAutista autista) {
		
		
		Feedback feedback=new Feedback(autista.getFeedback());
		this.feedback=feedback;

		
			
		}	
	
	
	public void caricaViaggio(DBAutista autista) {
		
		for(int i=0;i<autista.getViaggi().size();i++) {
			
			
			
			
			Viaggio viaggio=new Viaggio(autista.getViaggi().get(i));
			
			
			this.viaggiPubblicati.add(viaggio);
			
			
		
		}
		
	
	}

	public Autista() {
		
	this.viaggiPubblicati = new ArrayList<>();	
	}
	
	public Autista(DBAutista autista) {
		
	this.idAutista=autista.getIdAutista();	
		
		
	}

	public ArrayList<Viaggio> getViaggiPubblicati() {
		return viaggiPubblicati;
	}

	public void setViaggiPubblicati(Viaggio viaggio) {
		  if (!viaggiPubblicati.contains(viaggio)) { 
			  viaggiPubblicati.add(viaggio); 
	            viaggio.setAutista(this);
	            
	        
	        }
		  

	}
	 public void rimuoviViaggio(Viaggio viaggio) {
	        if (viaggiPubblicati.remove(viaggio)) {
	        	viaggio.setAutista(null);
	        }
	    }
	
	

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		 if (this.utente != utente) {
	            this.utente = utente;
	            if (utente != null && !utente.getAutisti().contains(this)) {
	            	utente.setAutisti(this);
	            }
	        }
	}
	

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		if (this.feedback != feedback) {
			this.feedback = feedback;
			if(feedback != null && feedback.getAutista() != this) {
				feedback.setAutista(this);
			}
		}
	}
	

	public void scriviFeedbackPasseggero(String comm) {
		
	this.feedback.setCommentoPasseggero(comm);	
		
	}
	
	public void printFeedbackAutista() {
		
	System.out.println(feedback.getCommentoautista());	
		
	}
	
	public void impostaValutazionePasseggero(float val) {
		
	this.feedback.setValutazionePasseggero(val);	
	}
	
	
	public void printValutazioneAutista() {
		
		System.out.println(feedback.getValutazoneAutista());	
			
		}
	
	
	

	public String getIdAutista() {
		return idAutista;
	}

	public void setIdAutista(String idAutista) {
		this.idAutista = idAutista;
	}

	@Override
	public String toString() {
		return "Autista [getViaggiPubblicati()=" + getViaggiPubblicati() + ", getUtente()=" + getUtente() + "]";
	}

}
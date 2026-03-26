package entity;
import java.util.ArrayList;

import database.DBPasseggero;
import database.DBUtente;



public class Passeggero {
	
	Utente utente;
	private ArrayList<Prenotazione>prenotazioniEffettuati;
	Feedback feedback;
    private String idPasseggero;
    
    
    public Passeggero(String idPasseggero) {
		
		
		DBPasseggero pass=new DBPasseggero(idPasseggero);
		
		this.idPasseggero = idPasseggero;
		this.prenotazioniEffettuati= new ArrayList<>();	
		
		pass.caricaPrenotazioniDaDB();
		caricaPrenotazione(pass);
		
		pass.caricaFeedbackDaDB();
		caricaFeedback(pass);
		
		
		
	}
	
public void caricaFeedback(DBPasseggero passeggero) {
	
	
Feedback feedback=new Feedback(passeggero.getFeedback());
this.feedback=feedback;


	
}	
	
	
public void caricaPrenotazione(DBPasseggero pass) {
		
		for(int i=0;i<pass.getPrenotazioni().size();i++) {
			
			
			
			
			
			Prenotazione prenotazione=new Prenotazione(pass.getPrenotazioni().get(i));
			
			System.out.println("index dentro");
			this.prenotazioniEffettuati.add(prenotazione);
		
		
		}
		

	}
	

	
    public Passeggero(DBPasseggero utente) {
		this.idPasseggero=utente.getIdPasseggero();
	}



	public Passeggero(DBPasseggero passdb,Utente utente) {
    	
    this.setUtente(utente);
    this.setIdPasseggero(passdb.getIdPasseggero());
   
    	
    }

	public Passeggero() {
		
	this.prenotazioniEffettuati= new ArrayList<>();	
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		  if (this.utente != utente) {
	            this.utente = utente;
	            if (utente != null && !utente.getPasseggeri().contains(this)) {
	                utente.setPasseggeri(this);
	            }
	        }
	}
	
	

	public ArrayList<Prenotazione> getPrenotazioniEffettuati() {
		return prenotazioniEffettuati;
	}

	public void setPrenotazioniEffettuati(Prenotazione prenotazione) {
		  if (!prenotazioniEffettuati.contains(prenotazione)) { 
			  prenotazioniEffettuati.add(prenotazione); 
	            prenotazione.setPasseggero(this);
	}
	
	}
	
	 public void rimuoviPrenotazione(Prenotazione prenotazione) {
	        if (prenotazioniEffettuati.remove(prenotazione)) {
	        	prenotazione.setPasseggero(null);
	        }
	    }
	 
	 

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		if (this.feedback != feedback) {
			this.feedback = feedback;
			if(feedback != null && feedback.getPasseggero() != this) {
				feedback.setPasseggero(this);
			}
		}
	
	}
	
	public void scriviFeedbackAutista(String comm) {
		
		this.feedback.setCommentoautista(comm);	
			
		}
	
	public void printFeedbackPasseggero() {
		
		System.out.println(feedback.getCommentoPasseggero());	
			
		}
	
	
     public void impostaValutazioneAutista(float val) {
		
		this.feedback.setValutazoneAutista(val);
			
		}
		
		
     public void printValutazionePasseggero() {
 		
 		System.out.println(feedback.getValutazionePasseggero());	
 			
 		}
		
		

	public String getIdPasseggero() {
		return idPasseggero;
	}

	public void setIdPasseggero(String idPasseggero) {
		this.idPasseggero = idPasseggero;
	}

	@Override
	public String toString() {
		return String.format("Passeggero [getIdPasseggero()=%s]", getIdPasseggero());
	}

}
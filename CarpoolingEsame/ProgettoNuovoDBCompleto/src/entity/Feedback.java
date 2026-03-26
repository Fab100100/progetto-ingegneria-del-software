package entity;
import database.DBFeedback;
public class Feedback {

	private Autista autista;
	private Passeggero passeggero;

	   private String idFeedback;
	   private String commentoPasseggero;
	   private float valutazionePasseggero;
	   private String commentoautista;
	   private float valutazoneAutista;
	   
	   
	public Feedback() {
	}
	
	

	public Feedback(String idFeedback) {
		
		DBFeedback feedback=new DBFeedback(idFeedback);
		
		this.idFeedback = idFeedback;
		
		
		this.commentoPasseggero = feedback.getCommentoPasseggero();
		this.valutazionePasseggero = feedback.getValutazionePasseggero();
		this.commentoautista = feedback.getCommentoautista();
		this.valutazoneAutista=feedback.getValutazoneAutista();
		
		
	}
	
  public Feedback(DBFeedback feedback) {
	  
		this.idFeedback = feedback.getIdFeedback();
		
		
		this.commentoPasseggero = feedback.getCommentoPasseggero();
		this.valutazionePasseggero = feedback.getValutazionePasseggero();
		this.commentoautista = feedback.getCommentoautista();
		this.valutazoneAutista=feedback.getValutazoneAutista();  
	  
	  
  }


	public Feedback(Autista autista, Passeggero passeggero, String commentoPasseggero, float valutazionePasseggero,
			String commentoautista,float valutazoneAutista) {
		this.autista = autista;
		this.passeggero = passeggero;
		this.commentoPasseggero = commentoPasseggero;
		this.valutazionePasseggero = valutazionePasseggero;
		this.commentoautista = commentoautista;
		this.valutazoneAutista=valutazoneAutista;
	}

	public Feedback(Autista autista, Passeggero passeggero, String commento, float valutazionePasseggero,float valutazoneAutista) {
		this.autista = autista;
		this.passeggero = passeggero;
		this.commentoPasseggero = commento;
		this.valutazionePasseggero = valutazionePasseggero;
		this.valutazoneAutista=valutazoneAutista;
		if (this.autista != autista) { 
			this.autista = autista; 
			if (autista != null && autista.getFeedback() != this) {
				autista.setFeedback(this);
			}
		}else{
		System.out.println(this.autista);
		}
		
		
		if (this.passeggero != passeggero) { 
			this.passeggero = passeggero; 
			if (passeggero != null && passeggero.getFeedback() != this) {
				passeggero.setFeedback(this);
			}
		}else{
		System.out.println(this.passeggero);
		}
		
	}



	public String getCommentoautista() {
		return commentoautista;
	}

	public void setCommentoautista(String commentoautista) {
		this.commentoautista = commentoautista;
	}

	public String getCommentoPasseggero() {
		return commentoPasseggero;
	}

	public void setCommentoPasseggero(String commentoPasseggero) {
		this.commentoPasseggero = commentoPasseggero;
	}

	
	public float getValutazionePasseggero() {
		return valutazionePasseggero;
	}

	public void setValutazionePasseggero(float valutazionePasseggero) {
		this.valutazionePasseggero = valutazionePasseggero;
	}

	public float getValutazoneAutista() {
		return valutazoneAutista;
	}

	public void setValutazoneAutista(float valutazoneAutista) {
		this.valutazoneAutista = valutazoneAutista;
	}

	public Autista getAutista() {
		return autista;
	}

	public void setAutista(Autista autista) {
		if (this.autista != autista) { 
			
			this.autista = autista; 
			
			if (autista != null && autista.getFeedback() != this) { 
				 
				autista.setFeedback(this);
			}
		}
	}

	public Passeggero getPasseggero() {
		return passeggero;
	}

	public void setPasseggero(Passeggero passeggero) {
		if (this.passeggero != passeggero) { 
		
			this.passeggero = passeggero; 
			
			if (passeggero != null && passeggero.getFeedback() != this) { 
		  
				passeggero.setFeedback(this);
			}
		}
	}
	


	public String getIdFeedback() {
		return idFeedback;
	}



	public void setIdFeedback(String idFeedback) {
		this.idFeedback = idFeedback;
	}



	@Override
	public String toString() {
		return String.format(
				"Feedback [getCommentoautista()=%s, getCommentoPasseggero()=%s, getValutazionePasseggero()=%s, getValutazoneAutista()=%s]",
				getCommentoautista(), getCommentoPasseggero(), getValutazionePasseggero(), getValutazoneAutista());
	}
	   
}
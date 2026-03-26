package entity;
import database.DBPrenotazione;
import database.DBUtente;

public class Prenotazione {
	private float costo;
	private Passeggero passeggero;
	private Viaggio viaggio;
	private String id; //id prenotazione
	private String idPasseggero;//usate per la funzione scrivi sul DB PER AUTISTA
	private String idViaggio;//usate per la funzione scrivi sul DB PER AUTISTA
	
	public Prenotazione() {
	}

	public Prenotazione(String id) {
		
		DBPrenotazione prenotazione=new DBPrenotazione(id);
		
		this.costo = prenotazione.getCosto();
		
		this.id = id;
	}
	
	public Prenotazione(DBPrenotazione prenotazione) {
		
		this.id=prenotazione.getIdPrenotazione();
		this.costo=prenotazione.getCosto();
		
	}


	public Prenotazione(float costo) {
		this.costo = costo;
	}

    
	public Prenotazione(float costo, Viaggio viaggio, String id) {
		this.costo = costo;
		this.viaggio = viaggio;
		this.id = id;
	}

   
	
	
	public Prenotazione(float costo, String id) {
		this.costo = costo;
		this.id = id;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public float getCosto() {
		return costo;
	}


	public void setCosto(float costo) {
		this.costo = costo;
	}


	public Passeggero getPasseggero() {
		return passeggero;
	}


	public String getIdPasseggero() {
		return idPasseggero;
	}

	public void setIdPasseggero(String idPasseggero) {
		this.idPasseggero = idPasseggero;
	}

	public String getIdViaggio() {
		return idViaggio;
	}

	public void setIdViaggio(String idViaggio) {
		this.idViaggio = idViaggio;
	}

	public void setPasseggero(Passeggero passeggero) {
		  if (this.passeggero != passeggero) {
	            this.passeggero = passeggero;
	            if (passeggero != null && !passeggero.getPrenotazioniEffettuati().contains(this)) {
	                passeggero.setPrenotazioniEffettuati(this);
	            }
	        }
	}


	
	public Viaggio getViaggio() {
		return viaggio;
	}


	public void setViaggio(Viaggio viaggio) {
		  if (this.viaggio != viaggio) {
	            this.viaggio = viaggio;
	            if (viaggio != null && !viaggio.getPrenotazioni().contains(this)) {
	                viaggio.setPrenotazione(this);
	            }
	        }
	}

	public int scriviSuDB(String idPrenotazione,float costo, String idViaggio, String idPasseggero) { //per il viaggio
		
	    int ret=0;
			
			DBPrenotazione Prenotazione = new DBPrenotazione();
			
			
			
			ret = Prenotazione.salvaInDB(idPrenotazione, costo, idViaggio,idPasseggero);
			
			if(ret!=-1) {
				this.setId(idPrenotazione);
				this.setCosto(costo);
				this.setIdViaggio(idViaggio);
				this.setIdPasseggero(idPasseggero);
				
						
			}
			
			return ret;
		}
	
	public int eliminaInDB(String idPrenota) { 
		
	    int ret=0;
			
			DBPrenotazione Prenotazione = new DBPrenotazione();
			
		ret = Prenotazione.eliminaInDB(idPrenota);
			
			if(ret!=-1) {
			
				}
			
			return ret;
		}

	@Override
	public String toString() {
		return String.format("Prenotazione [costo=%s, passeggero=%s, viaggio=%s, id=%s, getId()=%s, getCosto()=%s]",
				costo, passeggero, viaggio, id, getId(), getCosto());
	}

}
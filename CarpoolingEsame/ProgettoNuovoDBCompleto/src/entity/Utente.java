package entity;
import java.util.ArrayList;

import database.DBPasseggero;
import database.DBUtente;

public class Utente {
	private String idUtente;
    private String nome;
    private String cognome;
    private String telefono;
    private String email;
    private String tipoAuto;
    private int postiDisponibili;
    
    
    private ArrayList<Passeggero> passeggeri;
    private ArrayList<Autista> autisti;
    
    public Utente(String idUtente) {
		
		DBUtente utente=new DBUtente(idUtente);
		
		   this.idUtente = idUtente;
		    this.nome =utente.getNome();
	        this.cognome =utente.getCognome();
	        this.telefono =utente.getTelefono();
	        this.email = utente.getEmail();
	        this.tipoAuto =utente.getTipoAuto();
	        this.postiDisponibili =utente.getPostiDisponibili();
	        
	        this.passeggeri = new ArrayList<Passeggero>();
	        this.autisti = new ArrayList<Autista>();
	        utente.caricaPasseggereDaDB();
	        utente.caricaAutistiDaDB();
	       
	       caricaPasseggero(utente);
	       caricaAutista(utente);
	       
	}
	
	
	public int scriviSuDB(String id,String nome, String cognome, String telefono, String email, String tipoAuto, int postiDisponibili) {
		
    int ret=0;
		
		DBUtente utente = new DBUtente();
		
		
		
		ret = utente.SalvaInDB(id, nome, cognome,telefono,email,tipoAuto,postiDisponibili);
		
		if(ret!=-1) {
			this.setIdUtente(id);
			this.setNome(nome);
			this.setCognome(cognome);
			this.setTelefono(telefono);
			this.setEmail(email);
			this.setTipoAuto(tipoAuto);
			this.setPostiDisponibili(postiDisponibili);
			
		}
		
		return ret;
	}
	
	
	public void caricaAutista(DBUtente utente) {
		
		
for(int i=0;i<utente.getAutisti().size();i++) {
			
			Autista autista = new Autista(utente.getAutisti().get(i));
			
			this.autisti.add(autista);
			
		  
		}
			
		
	}
	

	public void caricaPasseggero(DBUtente utente) {
		
		for(int i=0;i<utente.getPasseggeri().size();i++) {
			
			Passeggero pass = new Passeggero(utente.getPasseggeri().get(i));
			
			this.passeggeri.add(pass);
			
		  }
		
}

	public Utente(String idUtente, String nome, String cognome, String telefono, String email, String tipoAuto,
			int postiDisponibili) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
		this.tipoAuto = tipoAuto;
		this.postiDisponibili = postiDisponibili;
	}



	public Utente(String nome, String cognome, String telefono, String email, String tipoAuto, int postiDisponibili) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
		this.tipoAuto = tipoAuto;
		this.postiDisponibili = postiDisponibili;
		this.autisti=new ArrayList<>();
		this.passeggeri=new ArrayList<>();
	}



	public Utente() {
		
		this.autisti=new ArrayList<>();
		this.passeggeri=new ArrayList<>();
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTipoAuto() {
		return tipoAuto;
	}


	public void setTipoAuto(String tipoAuto) {
		this.tipoAuto = tipoAuto;
	}


	public int getPostiDisponibili() {
		return postiDisponibili;
	}


	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}



	public String getIdUtente() {
		return idUtente;
	}



	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}



	public ArrayList<Autista> getAutisti() {
		return autisti;
	}



	public void setAutisti(Autista autista) {
		 if (!autisti.contains(autista)) { 
			 autisti.add(autista); 
	            autista.setUtente(this); 
	        }
	}
	 public void rimuoviCorso(Autista autista) {
	        if (autisti.remove(autista)) {
	        	autista.setUtente(this);
	        }
	    }






	public ArrayList<Passeggero> getPasseggeri() {
		return passeggeri;
	}



	public void setPasseggeri(Passeggero passeggero) {
		 if (!passeggeri.contains(passeggero)) { 
			 passeggeri.add(passeggero); 
			 passeggero.setUtente(this); 
	        }
	}
	 public void rimuoviPasseggero(Passeggero passeggero) {
	        if (passeggeri.remove(passeggero)) {
	        	passeggero.setUtente(this);
	        }
	    }


	public void visualizzaUtente() {
        this.nome =getNome();
        this.cognome = getCognome();
        this.telefono =getTelefono();
        this.email = getEmail();
        this.tipoAuto =getTipoAuto();
        this.postiDisponibili =getPostiDisponibili();
        System.out.println("Utente registrato con successo: " + nome + " " + cognome+" "+ telefono + " " + email+" "+ tipoAuto + " " + postiDisponibili+" ");
    }
	
	
	public void registraUtente(String nome, String cognome, String telefono, String email, String tipoAuto, int postiDisponibili) {
		
		setNome(nome);
		setCognome(cognome);
		setTelefono(telefono);
		setEmail(email);
		setTipoAuto(tipoAuto);
		setPostiDisponibili(postiDisponibili);
		
	}

   public void printListPasseggeri() {
	   
	   
	   System.out.println("lista passeggeri");
	   
	for(int i=0;i<passeggeri.size();i++) {
		
		 
		 
		 
		System.out.println("id passeggero"+passeggeri.get(i).getIdPasseggero());
		
	}
	   
   }

   
   public void printListAutisti() {
	   
	   
	   System.out.println("lista autisti");
	   
		for(int i=0;i<autisti.size();i++) {
			
			
			System.out.println("id autita:  "+autisti.get(i).getIdAutista());
			
		}
		   
	   }
	@Override
	public String toString() {
		final int maxLen = 10;
		return String.format(
				"Utente [getNome()=%s, getCognome()=%s, getTelefono()=%s, getEmail()=%s, getTipoAuto()=%s, getPostiDisponibili()=%s, getIdUtente()=%s, getAutisti()=%s, getPasseggeri()=%s]",
				getNome(), getCognome(), getTelefono(), getEmail(), getTipoAuto(), getPostiDisponibili(), getIdUtente(),
				getAutisti() != null ? getAutisti().subList(0, Math.min(getAutisti().size(), maxLen)) : null,
				getPasseggeri() != null ? getPasseggeri().subList(0, Math.min(getPasseggeri().size(), maxLen)) : null);
	}



	  public void printListPasseggeri(DBUtente utente) {
		   
		   
		  for(int i=0;i<utente.getPasseggeri().size();i++) {
				
				
				
			  System.out.println(utente.getPasseggeri());
				
			
			}
		   
	   }
}
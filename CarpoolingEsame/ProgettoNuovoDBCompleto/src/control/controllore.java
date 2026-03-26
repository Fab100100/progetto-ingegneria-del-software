package control;
import java.sql.DriverManager;
import java.util.ArrayList;

import database.DBUtente;
import entity.Autista;
import entity.Feedback;
import entity.Passeggero;
import entity.Prenotazione;
import entity.Utente;
import entity.Viaggio;
import entity.piattaforma;
public class controllore {
	
	
public static String ricercaUtente(String id) {
		
		Utente u = piattaforma.ricercaUtente(id);
		
		return "utente con id: "+id+" si chiama: "+u.getNome()+" "+u.getCognome()+" ";
	}

public static String ricercaViaggio(String id) {
	
	Viaggio u = piattaforma.ricercaViaggio(id);
	
	return "viaggio con id: "+id+" partenza "+u.getPartenza();
}


public static String ricercaIncasso(String id) {
	
	Viaggio v = piattaforma.ricercaIncassoTotale(id);
	
	return "il viaggio con seguente id : "+id+" ha il seguente incasso: "+v.getIncasso_totale();
}

public static String ricercaFeedback(String id) {
	
	Feedback f = piattaforma.ricercaFeedback(id);
	
	return "feedback id : "+id+" commento autista: "+f.getCommentoautista()+" commento passeggero: "+f.getCommentoPasseggero();
}

public static int InserisciUtente(String id,String nome, String cognome, String telefono, String email, String tipoAuto, int postiDisponibili) {
	
	  try {
	     
	    checkStringLength(telefono);
        System.out.println("campo telefono valido: " + telefono);	
      }catch(StringLengthException e) {
	
	  System.err.println("Errore: " + e.getMessage());
	  int ret=-1;
	  return ret;
	   
         }
	
	   try {
   	 onlyNumber(telefono);
           System.out.println("La stringa è valida: " + telefono);
       } catch (onlyNumber e) {
           System.err.println("Errore: " + e.getMessage());
          int ret=-1;
     	  return ret;
       }
	
	  try {
          checkIntGreaterThanZero(postiDisponibili);
          System.out.println("La variabile intera è maggiore di 0: " + postiDisponibili);
      } catch (IntGreaterThanZeroException e) {
          System.err.println("Errore: " + e.getMessage());
          int ret=-1;
    	  return ret;
      }
	  
	  try {
          checkStringForAtSymbol(email);
          System.out.println("La stringa è valida: " + email);
      } catch (AtSymbolException e) {
          System.err.println("Errore: " + e.getMessage());
          int ret=-1;
    	  return ret;
      }
	
	        
	Utente utente = new Utente();
	
	int ret = utente.scriviSuDB(id, nome, cognome,telefono,email,tipoAuto,postiDisponibili);
	
	if(ret!=-1) {
		utente.setIdUtente(id);
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setTelefono(telefono);
		utente.setEmail(email);
		utente.setTipoAuto(tipoAuto);
		utente.setPostiDisponibili(postiDisponibili);
		
	
	}
	
	return ret;
}

public static int InserisciViaggio(String idPrenotazione,float costo, String idViaggio, String idPasseggero) {
	
	Prenotazione prenotazione = new Prenotazione();
	
	int ret = prenotazione.scriviSuDB(idPrenotazione, costo, idViaggio,idPasseggero);
	
	if(ret!=-1) {
		
		prenotazione.setId(idPrenotazione);
		prenotazione.setCosto(costo);
		prenotazione.setIdViaggio(idViaggio);
		prenotazione.setIdPasseggero(idPasseggero);
		
		
	
	}
	
	return ret;
}

public static  ArrayList<String> elencoViaggi(String partenza,String destinazione,String dataOra){
	
	
	ArrayList<String> viaggi = new ArrayList<String>();		
					
	viaggi = piattaforma.getlistaViaggi(partenza, destinazione, dataOra);
	
			
	return viaggi;
}

public static int eliminaViaggio(String idPrenota) {
	
	Prenotazione prenotazione = new Prenotazione();
	
	int ret = prenotazione.eliminaInDB(idPrenota);
	
	if(ret!=-1) {
		
}
	
	return ret;
}


public static  ArrayList<String> elencoPasseggeri(){
	
	
	ArrayList<String> passeggeri = new ArrayList<String>();		
					
	passeggeri = piattaforma.getPasseggeri();
	
			
	return passeggeri;
}


public static  ArrayList<String> elencoAutisti(){
	
	
	ArrayList<String> autisti = new ArrayList<String>();		
					
	autisti = piattaforma.getAutisti();
	
			
	return autisti;
}

public static  ArrayList<String> elencoPrenotazioni(String id){
	
	
	ArrayList<String> prenotazioni = new ArrayList<String>();		
					
	prenotazioni = piattaforma.getPrenotazioni(id);
	
			
	return prenotazioni;
}


public static void checkStringLength(String str) throws StringLengthException {
    if (str.length() > 10) {
        throw new StringLengthException("La stringa supera i 10 caratteri.");
    }
}

public static void checkIntGreaterThanZero(int value) throws IntGreaterThanZeroException {
    if (value <= 0) {
        throw new IntGreaterThanZeroException("La variabile intera non è maggiore di 0.");
    }
}

public static void checkStringForAtSymbol(String str) throws AtSymbolException {
    if (!str.contains("@")) {
        throw new AtSymbolException("La stringa non contiene il carattere '@'.");
    }
}

public static void onlyNumber(String str) throws onlyNumber {
    if (!str.matches("[0-9]+")) {
        throw new onlyNumber("La stringa contiene caratteri non numerici.");
    }
}

}
class IntGreaterThanZeroException extends Exception {
    public IntGreaterThanZeroException(String message) {
        super(message);
    }
}

class StringLengthException extends Exception {
    public StringLengthException(String message) {
        super(message);
    }
}

class AtSymbolException extends Exception {
    public AtSymbolException(String message) {
        super(message);
    }
    
}


class onlyNumber extends Exception {
    public onlyNumber(String message) {
        super(message);
    }
}
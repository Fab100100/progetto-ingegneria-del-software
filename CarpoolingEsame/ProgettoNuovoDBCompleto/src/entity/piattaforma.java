package entity;

import java.util.ArrayList;

import database.DBPiattaforma;


public class piattaforma {
	
private ArrayList<Passeggero> passeggeri;	
	
public piattaforma() {
	}



public static Utente ricercaUtente (String id) {
	
	Utente utente = new Utente(id);
	
	return utente;
}
public static Viaggio ricercaViaggio (String id) {
	
	Viaggio viaggio = new Viaggio(id);
	
	return viaggio;
}
public static Feedback ricercaFeedback (String id) {
	
	Feedback feed = new Feedback(id);
	
	return feed;
}


public static Viaggio ricercaIncassoTotale(String id) {
	
	Viaggio viaggio = new Viaggio(id);
	
	viaggio.IncassoTotale();
	
	return viaggio;
}


public static ArrayList<String> getPasseggeri(){
	
	
	ArrayList<String> passeggeri = new ArrayList<String>();		
	
	passeggeri = DBPiattaforma.getListaPasseggeri();
	
	return passeggeri;
}
public static ArrayList<String> getAutisti(){
	
	
	ArrayList<String> autisti = new ArrayList<String>();		
	
	autisti = DBPiattaforma.getListaAutisti();
	
	return autisti;
}


public static ArrayList<String> getPrenotazioni(String id){
	
	
	ArrayList<String> prenotazioni = new ArrayList<String>();		
	
prenotazioni = DBPiattaforma.getListaPrenotazioni(id);
	
	return prenotazioni;
}

public static ArrayList<String> getlistaViaggi(String partenza,String destinazione,String dataOra){
	
	
	ArrayList<String> viaggio = new ArrayList<String>();		
	
	viaggio = DBPiattaforma.getListaViaggi(partenza, destinazione, dataOra);
	
	return viaggio;
}


}
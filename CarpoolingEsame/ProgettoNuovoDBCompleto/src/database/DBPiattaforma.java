package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





public class DBPiattaforma {

	public DBPiattaforma() {
	}
	
	
	
public static ArrayList<String> getListaPasseggeri(){ 
		
		ArrayList<String> ret = new ArrayList<String>();
		
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery("select Utente.idUtente, Utente.nome, Utente.cognome, Utente.telefono, Utente.email, Utente.tipoAuto, Utente.PostiDisponibili ,Passeggero.idPasseggero FROM Utente,Passeggero WHERE IdUtente=Utente_idUtente");
			
			while(rs.next()) {
				
				ret.add(rs.getString("idUtente"));
				ret.add(rs.getString("nome"));
				ret.add(rs.getString("cognome"));
				ret.add(rs.getString("telefono"));
				ret.add(rs.getString("email"));
				ret.add(rs.getString("tipoAuto"));
				ret.add(rs.getString("postiDisponibili"));
				ret.add(rs.getString("idPasseggero"));
				
			
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
		
	
	}


public static ArrayList<String> getListaPrenotazioni(String id){ 
	
	ArrayList<String> ret = new ArrayList<String>();
	
	try {
		
		ResultSet rs = DBConnectionManager.selectQuery("select Prenotazione.idPrenotazione, Prenotazione.costo FROM Viaggio,Prenotazione WHERE idViaggio=\'"+id+"'");
		
		while(rs.next()) {
			
			ret.add(rs.getString("idPrenotazione"));
			ret.add(rs.getString("costo"));
		
			
		
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return ret;
	

}



public static ArrayList<String> getListaAutisti(){ 
	
	ArrayList<String> ret = new ArrayList<String>();
	
	try {
		
		ResultSet rs = DBConnectionManager.selectQuery("select Utente.idUtente, Utente.nome, Utente.cognome, Utente.telefono, Utente.email, Utente.tipoAuto, Utente.PostiDisponibili ,Autista.idAutista FROM Utente,Autista WHERE IdUtente=Utente_idUtente;");
		
		while(rs.next()) {
			
			ret.add(rs.getString("idUtente"));
			ret.add(rs.getString("nome"));
			ret.add(rs.getString("cognome"));
			ret.add(rs.getString("telefono"));
			ret.add(rs.getString("email"));
			ret.add(rs.getString("tipoAuto"));
			ret.add(rs.getString("postiDisponibili"));
			ret.add(rs.getString("idAutista"));
			
		
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return ret;
}

public static ArrayList<String> getListaViaggi(String partenza,String destinazione,String dataOra){ 
	
	ArrayList<String> ret = new ArrayList<String>();
	
	try {
		
		ResultSet rs = DBConnectionManager.selectQuery("SELECT * FROM Viaggio WHERE partenza=\""+partenza+"\" AND destinazione=\""+destinazione+"\"AND dataOra=\""+dataOra+"\"");
		
		while(rs.next()) {
			
			ret.add(rs.getString("idViaggio"));
			ret.add(rs.getString("partenza"));
			ret.add(rs.getString("destinazione"));
			ret.add(rs.getString("dataOra"));
			ret.add(rs.getString("contributo"));
			ret.add(rs.getString("incassoTotale"));
			
			
		
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return ret;
	

}	

		
}
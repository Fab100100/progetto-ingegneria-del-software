package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class DBPasseggero {
	
	String idPasseggero;
	
	private ArrayList<DBPrenotazione> prenotazioni;
	private DBFeedback feedback;

	public DBPasseggero() {
	}

    


	public ArrayList<DBPrenotazione> getPrenotazioni() {
		return prenotazioni;
	}




	public void setPrenotazioni(ArrayList<DBPrenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}




	public DBPasseggero(String idPasseggero) {
		this.idPasseggero = idPasseggero;
		caricaDaDB();
	}
	
	
	
	
	public String getIdPasseggero() {
		return idPasseggero;
	}




	public void setIdPasseggero(String idPasseggero) {
		this.idPasseggero = idPasseggero;
	}




	public DBFeedback getFeedback() {
		return feedback;
	}




	public void setFeedback(DBFeedback feedback) {
		this.feedback = feedback;
	}




	public void caricaDaDB() {
		
		String query = new String("select * from Passeggero where idPasseggero=\""+idPasseggero+"\"");
		System.out.println(query);
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.setIdPasseggero(rs.getString("idPasseggero"));
				
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public int salvaInDB(String idPasseggero, String idUtente) {
		
		int ret = 0;
		
		String query = "INSERT INTO Passeggero(idPasseggero,Utente_idUtente) VALUES ( \'"+idPasseggero+"\',"+"\'"+idUtente+"\')"; 

		
		try {
			
			ret = DBConnectionManager.updateQuery(query);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		
		
		
		return ret;
	}
	
public int CercaPasseggero(String id) {
	
	int ret=0;
	
	String query = new String("select * from Passeggero where idPasseggero=\""+id+"\"");
	
	try {
		ResultSet rs = DBConnectionManager.selectQuery(query);
		
		if(rs.next()) {
			
			ret=1;
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		ret = -1;
	}
	
	
	return ret;
}

public void caricaPrenotazioniDaDB() {
	
	prenotazioni=new ArrayList<DBPrenotazione>();
	
	
	String query = new String("select * from Prenotazione where Passeggero_idPasseggero=\""+this.idPasseggero+"\"");
	
	try {
		ResultSet rs = DBConnectionManager.selectQuery(query);
		
		while(rs.next()) {
			
			DBPrenotazione prenotazione=new DBPrenotazione();
			
			prenotazione.setIdPrenotazione(rs.getString("idPrenotazione"));
			prenotazione.setCosto(rs.getFloat("costo"));		
		
			prenotazioni.add(prenotazione);
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void caricaFeedbackDaDB() {
	
	String query = new String("select * from Feedback where Passeggero_idPasseggero =\'"+this.idPasseggero+"'");
	
	
	try {
		
		ResultSet rs1 = DBConnectionManager.selectQuery(query);
		
		if(rs1.next()) {
			
			DBFeedback feedback=new DBFeedback();
			feedback.setIdFeedback(rs1.getString("idFeedback"));
			feedback.setCommentoautista(rs1.getString("commentoautista"));
			feedback.setCommentoPasseggero(rs1.getString("commentoPasseggero"));
			feedback.setValutazionePasseggero(rs1.getFloat("valutazionePasseggero"));
			feedback.setValutazoneAutista(rs1.getFloat("valutazioneAutista"));
						
			
			this.feedback = feedback;
			
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}




@Override
public String toString() {
	return String.format("DBPasseggero [getIdPasseggero()=%s]", getIdPasseggero());
}
}
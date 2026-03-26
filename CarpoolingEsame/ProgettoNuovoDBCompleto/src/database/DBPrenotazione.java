package database;

import java.sql.ResultSet;
import java.sql.SQLException;





public class DBPrenotazione {
	
	
	private String idPrenotazione;
	private float costo;
	
	
	
	public DBPrenotazione() {
	}



	public DBPrenotazione(String idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
		caricaDaDB();
	}



	public String getIdPrenotazione() {
		return idPrenotazione;
	}



	public void setIdPrenotazione(String idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}



	public float getCosto() {
		return costo;
	}



	public void setCosto(float costo) {
		this.costo = costo;
	}
	
public void caricaDaDB() {
		
		String query = new String("select * from Prenotazione where idPrenotazione=\""+idPrenotazione+"\"");
		System.out.println(query);
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.setIdPrenotazione(rs.getString("idPrenotazione"));
				this.setCosto(rs.getFloat("costo"));
				
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public int salvaInDB(String idPrenotazione,float costo, String idViaggio, String idPasseggero) {
	
	int ret = 0;
	
	String query = "INSERT INTO Prenotazione(idPrenotazione,costo, Viaggio_idViaggio,Passeggero_idPasseggero) VALUES ( \'"+idPrenotazione+"\',"+"\'"+costo+"\','"+idViaggio+"\',"+"\'"+idPasseggero+"\')"; 

	
	try {
		
		ret = DBConnectionManager.updateQuery(query);
		
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		ret = -1;
	}
	
	
	
	return ret;
}

public int eliminaInDB(String idPrenota) {
	
	int ret = 0;
	
	String query = "DELETE FROM Prenotazione where idPrenotazione=\""+idPrenota+"\""; 

	System.out.println("[QUERY]: "+query);
	try {
		
		ret = DBConnectionManager.updateQuery(query);
		
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		ret = -1;
	}
	
	
	
	return ret;
}



public int CercaViaggio(String id) {
	
	int ret=0;
	
	String query = new String("select * from Prenotazione where idViaggio="+id);
	
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

public int CercaPasseggero(String id) {
	
	int ret=0;
	
	String query = new String("select * from Prenotazione where idPrenotazione=\""+id+"\"");
	
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

}
package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





public class DBAutista {

	private String idAutista;
	private ArrayList<DBViaggio> viaggi;
	private DBFeedback feedback;
	
	public DBAutista() {
	}


	public DBAutista(String idAutista) {
		this.idAutista = idAutista;
		caricaDaDB();
	}
 
	

	public DBFeedback getFeedback() {
		return feedback;
	}


	public void setFeedback(DBFeedback feedback) {
		this.feedback = feedback;
	}


	public String getIdAutista() {
		return idAutista;
	}


	public void setIdAutista(String idAutista) {
		this.idAutista = idAutista;
	}


	public void caricaDaDB() {
		
		String query = new String("select * from Autista where idAutista=\""+idAutista+"\"");
		System.out.println(query);
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.setIdAutista(rs.getString("idAutista"));
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
public int salvaInDB(String idAutista, String idUtente) {
		
		int ret = 0;
		
		String query = "INSERT INTO Autista(idAutista,Utente_idUtente) VALUES ( \'"+idAutista+"\',"+"\'"+idUtente+"\')"; 

		
		try {
			
			ret = DBConnectionManager.updateQuery(query);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		
		
		
		return ret;
	}
	
	public int CercaAutista(String idAutista) {
		
		int ret=0;
		
		String query = new String("select * from Autista where idAutista=\""+idAutista+"\"");
		
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

	
public void caricaViaggiDaDB() {
		
		viaggi = new ArrayList<DBViaggio>();
		
		String query = new String("select * from Viaggio where Autista_idAutista=\""+this.idAutista+"\"");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				DBViaggio viaggio=new DBViaggio();
				
				viaggio.setIdViaggio(rs.getString("idViaggio"));
				viaggio.setPartenza(rs.getString("partenza"));
				viaggio.setDestinazione(rs.getString("destinazione"));
				viaggio.setDataOra(rs.getString("dataOra"));
				viaggio.setContributo(rs.getFloat("contributo"));
				viaggio.setIncasso_totale(rs.getFloat("incassoTotale"));
				

				viaggi.add(viaggio);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<DBViaggio> getViaggi() {
		return viaggi;
	}


	public void setViaggi(ArrayList<DBViaggio> viaggi) {
		this.viaggi = viaggi;
	}
	
	public void caricaFeedbackDaDB() {
		
		String query = new String("select * from Feedback where Autista_idAutista =\'"+this.idAutista+"'");
		
		
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
}
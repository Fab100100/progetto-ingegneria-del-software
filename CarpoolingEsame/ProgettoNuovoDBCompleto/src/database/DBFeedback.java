package database;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBFeedback {
	
	   private String idFeedback;
	   private String commentoPasseggero;
	   private String commentoautista;
	   private float valutazoneAutista;
	   private float valutazionePasseggero;
	   
	   
	   
	public DBFeedback() {
	}

	public DBFeedback(String idFeedback) {
		this.idFeedback = idFeedback;
		caricaDaDB();
	}

	public DBFeedback(DBFeedback feedback) {
		this.idFeedback = feedback.getIdFeedback();
		this.commentoPasseggero = feedback.getCommentoPasseggero();
		this.commentoautista = feedback.getCommentoautista();
		this.valutazoneAutista = feedback.getValutazoneAutista();
		this.valutazionePasseggero = feedback.getValutazionePasseggero();
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		
		String query = new String("select * from Feedback where idFeedback =\""+this.idFeedback+"\"");
		System.out.println(query);
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				this.setCommentoautista(rs.getString("commentoAutista"));
				this.setCommentoPasseggero(rs.getString("commentoPasseggero"));
				this.setValutazionePasseggero(rs.getFloat("valutazionePasseggero"));
				this.setValutazoneAutista(rs.getFloat("valutazioneAutista"));
				
		
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public String getIdFeedback() {
		return idFeedback;
	}

	public void setIdFeedback(String idFeedback) {
		this.idFeedback = idFeedback;
	}

	public String getCommentoPasseggero() {
		return commentoPasseggero;
	}

	public void setCommentoPasseggero(String commentoPasseggero) {
		this.commentoPasseggero = commentoPasseggero;
	}

	public String getCommentoautista() {
		return commentoautista;
	}

	public void setCommentoautista(String commentoautista) {
		this.commentoautista = commentoautista;
	}

	public float getValutazoneAutista() {
		return valutazoneAutista;
	}

	public void setValutazoneAutista(float valutazoneAutista) {
		this.valutazoneAutista = valutazoneAutista;
	}

	public float getValutazionePasseggero() {
		return valutazionePasseggero;
	}

	public void setValutazionePasseggero(float valutazionePasseggero) {
		this.valutazionePasseggero = valutazionePasseggero;
	}
}
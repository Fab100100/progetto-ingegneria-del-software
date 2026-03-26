package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class DBViaggio {
	
	   private String idViaggio;	
       private String partenza;
       private String destinazione;
	    private String dataOra;
	    private float contributo;
	    private float incasso_totale=0;
	    private ArrayList<DBPrenotazione> prenotazioni;
	    
		public DBViaggio() {
		}


		public DBViaggio(String idViaggio) {
			this.idViaggio = idViaggio;
			caricaDaDB();
		}	
	
		public void caricaDaDB() {
			
			String query = new String("select * from Viaggio where idViaggio=\""+idViaggio+"\"");
			System.out.println(query);
			
			try {
				ResultSet rs = DBConnectionManager.selectQuery(query);
				
				if(rs.next()) {
					
					this.setIdViaggio(rs.getString("idViaggio"));
					this.setPartenza(rs.getString("partenza"));
					this.setDestinazione(rs.getString("destinazione"));
					this.setDataOra(rs.getString("dataOra"));
					this.setContributo(rs.getFloat("contributo"));
					this.setIncasso_totale(rs.getFloat("incassoTotale"));
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

		public void caricaPrenotazioniDaDB() {
			
			
			
			prenotazioni=new ArrayList<DBPrenotazione>();
			
			
			String query = new String("select * from Prenotazione where Viaggio_idViaggio=\""+this.idViaggio+"\"");
			
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


		public String getIdViaggio() {
			return idViaggio;
		}


		public void setIdViaggio(String idViaggio) {
			this.idViaggio = idViaggio;
		}


		public String getPartenza() {
			return partenza;
		}


		public void setPartenza(String partenza) {
			this.partenza = partenza;
		}


		public String getDestinazione() {
			return destinazione;
		}


		public void setDestinazione(String destinazione) {
			this.destinazione = destinazione;
		}


		public String getDataOra() {
			return dataOra;
		}


		public void setDataOra(String dataOra) {
			this.dataOra = dataOra;
		}


		


		public float getContributo() {
			return contributo;
		}


		public void setContributo(float contributo) {
			this.contributo = contributo;
		}


		public float getIncasso_totale() {
			return incasso_totale;
		}


		
		
		public ArrayList<DBPrenotazione> getPrenotazioni() {
			return prenotazioni;
		}


		public void setPrenotazioni(ArrayList<DBPrenotazione> prenotazioni) {
			this.prenotazioni = prenotazioni;
		}


		public void setIncasso_totale(float incasso_totale) {
			this.incasso_totale = incasso_totale;
		}


		public int salvaInDB(String idViaggio,String partenza,String destinazione, Date dataOra, float contributo, float incasso_totale,String idAutista) {
			
			int ret = 0;
			
			String query = "INSERT INTO Viaggio(idViaggio,partenza, destinazione,contributo,dataOra,incassoTotale,Autista_idAutista) VALUES ( \'"+idViaggio+"\',"+"\'"+partenza+"\','"+destinazione+"\',"+"\'"+contributo+"\',"+"\'"+dataOra+"\',"+"\'"+incasso_totale+"\',"+"\'"+idAutista+"\')";

			System.out.println(query);
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
			
			String query = new String("select * from Viaggio where idViaggio=\""+id+"\"");
			
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
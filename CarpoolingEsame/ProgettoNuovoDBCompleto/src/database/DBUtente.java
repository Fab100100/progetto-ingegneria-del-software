package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DBUtente {
	
	private String idUtente;
    private String nome;
    private String cognome;
    private String telefono;
    private String email;
    private String tipoAuto;
    private int postiDisponibili;
    
    private ArrayList<DBAutista> autisti;
    private ArrayList<DBPasseggero>passeggeri;

	public DBUtente() {
		
	}

	public DBUtente(String idUtente) {
		this.idUtente = idUtente;
		this.passeggeri = new ArrayList<DBPasseggero>();
		caricaDaDB();
	}
	
	public ArrayList<DBPasseggero> getPass() {
		return passeggeri;
	}
	
	
    
	public ArrayList<DBPasseggero> getPasseggeri() {
		return passeggeri;
	}

	public void setPasseggeri(ArrayList<DBPasseggero> passeggeri) {
		this.passeggeri = passeggeri;
	}

	public void caricaDaDB() {
		
		String query = "SELECT * FROM Utente WHERE idUtente=\""+this.idUtente+"\"";
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) { 
				
				
				this.setIdUtente(rs.getString("idUtente"));
				this.setNome(rs.getString("nome"));
				this.setCognome(rs.getString("cognome"));
				this.setTelefono(rs.getString("telefono"));
				this.setEmail(rs.getString("email"));
				this.setTipoAuto(rs.getString("tipoAuto"));
				this.setPostiDisponibili(rs.getInt("postiDisponibili"));
				
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	
public void caricaAutistiDaDB() {
		
		autisti = new ArrayList<DBAutista>();
		
		
		String query = new String("select * from Autista where Utente_idUtente =\'"+this.idUtente+"'");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				
				DBAutista autista = new DBAutista();
				
				autista.setIdAutista(rs.getString("idAutista"));
				autisti.add(autista);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
		
	}

public void caricaPasseggereDaDB() {
	
	String query = new String("select * from Passeggero where Utente_idUtente =\'"+this.idUtente+"'");
	System.out.println("[QUERY]: "+query);
	
	try {
		
		ResultSet rs1 = DBConnectionManager.selectQuery(query);
		
		while(rs1.next()) {
			
			
			
			DBPasseggero pass=new DBPasseggero();
			
			pass.setIdPasseggero(rs1.getString("idPasseggero"));
			
			
			this.passeggeri.add(pass); 
			
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}


public int SalvaInDB(String id,String nome, String cognome, String telefono, String email, String tipoAuto, int postiDisponibili) {
	
	int ret = 0;
	
	String query =  "INSERT INTO Utente(idUtente,nome, cognome,telefono,email,tipoAuto,postiDisponibili) VALUES ( \'"+id+"\',"+"\'"+nome+"\','"+cognome+"\',"+"\'"+telefono+"\',"+"\'"+email+"\',"+"\'"+tipoAuto+"\','"+postiDisponibili+"')";
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

	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
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

	public ArrayList<DBAutista> getAutisti() {
		return autisti;
	}

	public void setAutisti(ArrayList<DBAutista> autisti) {
		this.autisti = autisti;
	}
}
package pack;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ObiectDAO{
	public static List<Obiect> getObiecte(){
		List<Obiect> obiecte = new ArrayList<>();
		Connection con = Conexiune.con();
		Statement stmt = null;
		ResultSet rs = null;
		obiecte = new ArrayList<>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from obiect");
			while(rs.next()) {
				Obiect obi = new Obiect();
				obi.setId(rs.getInt("id"));
				obi.setBig(rs.getBoolean("isBig"));
				obi.setNumber(rs.getInt("number"));
				obiecte.add(obi);
			}
		}catch(SQLException se) {}
		finally {
			try {
				rs.close();
				stmt.close();	
				con.close();
			}catch(SQLException se) {}
		}
		return obiecte;
	}
	public static void deleteObiect(String id) {
		Connection con = Conexiune.con();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String q = "delete from obiect where id=" +id; 
			stmt.executeUpdate(q);
		}catch(SQLException se) {}
		finally {
			try {
				stmt.close();	
				con.close();
			}catch(SQLException se) {}
		}
	}
}

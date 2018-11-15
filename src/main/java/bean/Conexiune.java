package bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexiune {
	public static Connection con() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/interviu?user=root&password=root");
		}catch(SQLException | ClassNotFoundException se){}
		return con;
	}
}

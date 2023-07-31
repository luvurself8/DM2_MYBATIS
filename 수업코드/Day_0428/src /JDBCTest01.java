import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest01 {

	public static void main(String[] args) {
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String id     = "hr";
		String pwd    = "hr"; 
		
		Connection conn = null;
		Statement stat  = null;
		String query    = null;
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, id, pwd);
			query = "CREATE TABLE MY_TABLE ( "
					+ "  USERNAME VARCHAR2(5), "
					+ "  AGE NUMBER(3) "
					+ ")";
			
			stat = conn.createStatement(); 
			stat.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stat.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("끝!!");
	}

}







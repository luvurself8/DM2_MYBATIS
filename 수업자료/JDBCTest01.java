import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest01 {

	public static void main(String[] args) {
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String id  = "hr";
		String pwd = "hr"; 
		
		Connection conn = null;
		Statement stat = null;
		String query = null;
		
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
		
		
		try {
			conn = DriverManager.getConnection(url, id, pwd);
			query = "CREATE TABLE MY_TABLE ( "
					+ "  USERNAME VARCHAR2(5), "
					+ "  AGE NUMBER(3) "
					+ ")";
			
			stat = conn.createStatement();
			stat.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("끝!!");
	}

}







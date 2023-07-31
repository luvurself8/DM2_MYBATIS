import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest02 {

	public static void main(String[] args) {
		// 1. 디펜던시 2개 추가하기 
		// 2. url. driver, userid, userpwd를 문자열로 세팅
		String url     = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String userid  = "hr";
		String userpwd = "hr";
		
		// 3. SQL명령문 , Connection객체, PreparedStatement 객체 준비
		String query = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			query = "INSERT INTO MY_TABLE "
					+ "(USERNAME, AGE) "
					+ "VALUES "
					+ "('손', 30)"; 
			
			conn = DriverManager.getConnection(url, userid, userpwd);
			pstmt = conn.prepareStatement(query);
			
			int result = pstmt.executeUpdate();
			System.out.println("결과: " + result);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}

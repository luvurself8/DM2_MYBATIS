import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest04 {

	public static void main(String[] args) {
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
			
			query = "SELECT * FROM MY_TABLE "
					+ "ORDER BY USERNAME" ;    // 테이블로 반환
			
			conn = DriverManager.getConnection(url, userid, userpwd);
			pstmt = conn.prepareStatement(query);
			

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("username");
				int age = rs.getInt("age");
				System.out.printf("이름 : %s, 나이 : %d\n", name, age);
				
			}
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

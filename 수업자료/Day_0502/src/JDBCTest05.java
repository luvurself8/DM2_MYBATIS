import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest05 {

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
			
			query = "SELECT FIRST_NAME, DEPARTMENT_NAME, SALARY\r\n"
					+ "FROM EMPLOYEES JOIN DEPARTMENTS\r\n"
					+ "USING (DEPARTMENT_ID) "
					+ "ORDER BY 1";    // 테이블로 반환
			
			conn = DriverManager.getConnection(url, userid, userpwd);
			pstmt = conn.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String firstName = rs.getString(1);
				String departmentName = rs.getString(2);
				Double salary = rs.getDouble(3);
				System.out.printf("%11s %16s %9.2f%n", firstName, departmentName, salary);
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

package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/*
 * ResultSet executeQury() : select 문장 실행
 * int executeUpdata() : select 문장 이외 구문실행
 * boolean execute() : 모든 sql 문장 사용가능
 * 		true : 실행된 구문이 select 인경우
 * 		false : 실행된 구문이 select 가 아닌경우
 */
public class JdbcEx6 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		String sql = "select * from student"; 
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if(pstmt.execute()) { // sql 실행후,select 구문인 경우 : true 리턴
			ResultSet rs = pstmt.getResultSet(); // getResultSet() : ResultSet 객체를 리턴
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i = 1; i <= rsmd.getColumnCount();i++) {
				System.out.printf("%10s",rsmd.getCatalogName(i));
			}
			System.out.println();
			while (rs.next()) {
				for (int i =1; i<= rsmd.getColumnCount();i++) {
					System.out.printf("%10s",rs.getString(i));
				}
				System.out.println();
			}
		}else { // select 구문 이외의 sql 문장인경우
			System.out.println("변경된 레코드 건수 : "+ pstmt.getUpdateCount());
		}
	}

}

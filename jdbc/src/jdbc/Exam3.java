package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/*
  학생의 학번,이름,학년,학과코드,학과명,지도교수명을 출력하기
  출력시 Header 에 컬럼명도 출력하기
 */
public class Exam3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		String sql = "select s.studno,s.name,s.grade, s.major1,m.name,p.name"+ 
					 "from student s ,professor p ,major m " + " where s.profno = p.no and m.code = s.major1";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int colCnt = rsmd.getColumnCount();
		for (int i=1; i<= colCnt; i++) {
			System.out.printf("%-10s",rsmd.getColumnName(i));
		}
		System.out.println();
//		while (rs.next()) {
//			System.out.print("학번 : " + rs.getInt("studno"));
//			System.out.print(",이름 : " + rs.getString("s.name"));
//			System.out.print(",학년 : " + rs.getInt("grade"));
//			System.out.print(",학과코드 : " + rs.getInt("major1"));
//			System.out.print(",학과명 : " + rs.getString("m.name"));
//			System.out.println(",지도교수 : " + rs.getString("p.name"));
//		}
//		while(rs.next()) {
//			System.out.printf("%-10d", rs.getInt(1));
//			System.out.printf("%-10s", rs.getString(2));
//			System.out.printf("%-10d", rs.getInt(3));
//			System.out.printf("%-10d", rs.getInt(4));
//			System.out.printf("%-10s", rs.getString(5));
//			System.out.printf("%-10s\n", rs.getString(6));
//		}
		while(rs.next()) {
			for(int i=1; i<= rsmd.getColumnCount();i++) {
				System.out.printf("10s",rs.getString(i));
			}
			System.out.println();
		}
	}

}

package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
  JDBC : 자바 애플리케이션과 DBMS를 연결하기 위한 도구 
  	1. 드라이버 파일 연결 : Classpath 연결 : Build Path 메뉴이용
  	2. JDBC 관련 패키지 : java.sql.*
  	3. 드라이버 클래스를 메모리의 로드하기 -> "org.mariadb.jdbc.Driver"
  	4. dbms와 java를 연결하여 객체 생성 ->Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gdjdb", "gduser", "1234");
 */
public class JdbcEx1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 3. Class.forName(문자열) : 문자열에 해당하는 클래스를 찾아서 클래스 파일을 메모리 로드
		// 		 mariadb : org.mariadb.jdbc.Driver
		//		 oracle  : oracle.jdbc.driver.OracleDriver
		Class.forName("org.mariadb.jdbc.Driver");
		// 4. conn: db 와 연결 객체
		// 	  localhost : IP 주소
		//	  3306 : PORT 번호
		// 	  gdjdb : Mariadb에서 설정한 데이터베이스 이름
		//	  "gduser", "1234" : db사용자,비밀번호
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gdjdb", "gduser", "1234");
		System.out.println("jdbc 연결완료");
		// SQL 명령문을 DB에 전달을 위한 객체
		Statement stmt = conn.createStatement();
		// executeQuery(sql구문) : sql 문장을 실행
		// ResultSet : select 구문의 결과를 저장하는 객체
		ResultSet rs = stmt.executeQuery("select * from student");
		while(rs.next()) { // 레코드 한개씩 조회
			// rs.getString(컬럼명) : 컬럼의 값을 문자열로 리턴
			// rs.getInt(컬럼명) : 컬럼의 값을 정수로 리턴
			System.out.print("학번 : " + rs.getString("studno")); // 첫번째 컬럼
			System.out.print(",이름 : " + rs.getString("name"));
			System.out.print(",학년 : " + rs.getString("grade"));
			System.out.println(",학과코드 : " + rs.getString("major1"));
		}
	}
}

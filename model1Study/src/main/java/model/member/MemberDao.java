package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnection;

public class MemberDao {
	public boolean insert(Member mem) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into member (id,pass,name,gender,tel,email,picture)"
				+ " values(?,?,?,?,?,?,?)" ;
		try {
			pstmt = conn.prepareStatement(sql);
			// pstmt.setString(1,값) => sql의 첫번째 ?에 해당하는 값을 Sting 형태로 설정
			pstmt.setString(1, mem.getId());   // joinForm.jsp에서 아이디로 입력된 값
			pstmt.setString(2, mem.getPass()); // joinForm.jsp에서 비밀번호로 입력된 값
			pstmt.setString(3, mem.getName()); // joinForm.jsp에서 이름으로 입력된 값
			pstmt.setInt(4, mem.getGender());  // DB에서 정수형태로 입력
			pstmt.setString(5, mem.getTel());  // joinForm.jsp에서 전화번호로 입력된 값
			pstmt.setString(6, mem.getEmail());// joinForm.jsp에서 이메일로 입력된 값
			pstmt.setString(7, mem.getPicture()); // 사진 이미지의 이름으로 입력된 값
			// executeUpdate() : 실행 후 변경된 레코드의 갯수를 리턴 
			if(pstmt.executeUpdate() > 0) return true;
			else return false;
		}catch (SQLException e) {
			e.printStackTrace();
		} finally { // 반드시 실행
			DBConnection.close(conn,pstmt,null);
		}
		return false; // 예외발생
	}
}

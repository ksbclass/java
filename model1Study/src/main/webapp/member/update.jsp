<%@page import="model.member.MemberDao"%>
<%@page import="model.member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	1. 모든 파라미터를 Member 객체에 저장하기
	2. 입력된 비밀번호와 db에 저장된 비밀번호 비교.
		관리자로 로그인 한 경우 관리자 비밀번호로 비교
		본인 정보 수정시 본인의 비밀번호로 비교
		불일치 : '비밀번호 오류' 메시지 출력 후 updateForm.jsp 페이지 이동
	3. Member 객체의 내용으로 db를 수정하기 : boolean MemberDao.update(Member)
		- 성공 : 회원정보 수정 완료 메시지 출력 후 info.jsp로 페이지 이동
		- 실패 : 회원정보 수정 실패 메시지 출력 후 updateForm.jsp 페이지 이동
 --%>
 <%
	Member mem = new Member();
 	mem.setId(request.getParameter("id"));
 	mem.setPass(request.getParameter("pass"));
 	mem.setGender(Integer.parseInt(request.getParameter("gender"))); 	
 	mem.setTel(request.getParameter("tel"));
 	mem.setEmail(request.getParameter("email"));
 	mem.setPicture(request.getParameter("picture"));
 	String pw = request.getParameter("pass");
 	String id = request.getParameter("id"); 
 	String login = (String)session.getAttribute("login");
 	Member mem2 =new MemberDao().selectOne(id);
	if(login == null || !mem2.getPass().equals(pw)) {
%>
<script type="text/javascript">
	alert("비밀번호 오류");
	location.href="updateForm.jsp";
</script>	
<% 
	}else{
		 boolean result = MemberDao.update(mem);
	if(result){
%>	
<script type="text/javascript">
	alert("회원정보 수정 완료");
	location.href="info.jsp";
</script>
<%
	} else {
%>
<script type="text/javascript">
	alert("회원정보 수정 실패");
	location.href="updateForm.jsp";
</script>
<% } %>
<% } %>

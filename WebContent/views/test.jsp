<%@page import="com.osf.test.vo.PhotoBoardVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	pageContext.setAttribute("str", "난페이지");
	request.setAttribute("str", "난리퀘스트");
	session.setAttribute("str", "난세션");
	application.setAttribute("str", "난어플");
	Map<String,String> tMap = new HashMap<>();
	tMap.put("ttt_nnn","1");
	tMap.put("ttt_nname","홍길동");
	pageContext.setAttribute("tMap", tMap);
	PhotoBoardVO pb = new PhotoBoardVO();
	pb.setPbTitle("제목");
	pageContext.setAttribute("pb", pb);
	RequestDispatcher rs = request.getRequestDispatcher("/views/app.jsp");
	rs.forward(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>전테스트입니다. ${applicationScope.str}<br>
${sessionScope.str}<Br>
${requestScope.str}<Br>
${pageScope.str}<Br>
${tMap.ttt_nname}<br>
<%=tMap.get("ttt_nname") %><br>
<%=pb.getPbTitle() %><br>
${pb.pbTitle}<br>
</body>
</html>
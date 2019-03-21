<%@page import="java.sql.ResultSet"%>
<%@page import="test.jsp.study.db.DBCon"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차량 조회</title>
</head>
<body>
<form method = "post" action = "/jsp-study/car/car_delete_ok.jsp">
	<table border="1">
		<tr>
			<th>선택</th>
			<th>번호</th>
			<th>모델</th>
			<th>년식</th>
			<th>제조회사</th>
			<th>기타</th>
		</tr>
		<%
			String sql = "select ci_num, ci_name, ci_year, ci_vendor, ci_etc from car_info";
			PreparedStatement ps = DBCon.getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
		%>
		<tr>
			<td><input type="checkbox" name="ci_num"
				value="<%=rs.getString("ci_num")%>"></td>
			<td><%=rs.getString("ci_num")%></td>
			<td><%=rs.getString("ci_name")%></td>
			<td><%=rs.getString("ci_year")%></td>
			<td><%=rs.getString("ci_vendor")%></td>
			<td><%=rs.getString("ci_etc")%></td>
		</tr>
		<%
			}
		%>
	</table>
	<button type ="button" onclick="goInsertPage()">차량등록</button>
	<button>차량 삭제</button>
	</form>
	<script>
		function goInsertPage() {
			location.href = "/jsp-study/car/car_insert2.jsp"
		}
	</script>
</body>
</html>
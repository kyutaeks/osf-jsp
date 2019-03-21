<%@page import="test.jsp.study.db.DBCon"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String ciName = request.getParameter("ci_name");
	String ciYear = request.getParameter("ci_year");
	String ciVendor = request.getParameter("ci_vendor");
	String ciEtc = request.getParameter("ci_etc");
	String sql = "insert into car_info (ci_num, ci_name, ci_Year, ci_vendor, ci_etc)";
	sql += " values((select nvl(max(ci_num),0)+1 from car_info),?,?,?,?)";
	PreparedStatement ps = DBCon.getCon().prepareStatement(sql);
	ps.setString(1, ciName);
	ps.setString(2, ciYear);
	ps.setString(3, ciVendor);
	ps.setString(4, ciEtc);
	int cnt = ps.executeUpdate();
	String result = "차량등록이 실패하였습니다.";
	if (cnt == 1) {
		result = "차량등록이 성공하였습니다.";
	}
%>
<script>
alert("<%=result%>");
	location.href = "/jsp-study/car/car_list2.jsp"
</script>

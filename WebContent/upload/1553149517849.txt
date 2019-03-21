<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차량등록</title>
</head>
<body>
	<form method="post" action="/jsp-study/car/car_insert_ok.jsp">
		<table border="1">
			<tr>
				<th>모델명</th>
				<td><input type="text" name="ci_name"></td>
			</tr>
			<tr>
				<th>년식</th>
				<td><input type="text" name="ci_year"></td>
			</tr>
			<tr>
				<th>제조회사</th>
				<td><input type="text" name="ci_vendor"></td>
			</tr>
			<tr>
				<th>기타</th>
				<td><input type="text" name="ci_etc"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button>차량등록</button></td>
			</tr>
		</table>
	</form>
</body>
</html>
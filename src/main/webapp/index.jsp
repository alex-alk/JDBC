<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table>
			<tr>
				<th>Nr ordin</th>
				<th>Numere</th>
			</tr>
			<c:set var="n" value="0"></c:set>
			<c:forEach var="obiect" items="${obiectDAO.getObiecte()}">
				<tr>
					<td>${obiect.id}</td>
					<td>${obiect.number}</td>
					<td><button onclick="f(${n}, ${obiect.big})" id="${n}">Este mare?</button></td>
					<td>
						<form action="" method="POST">
							<input type="hidden" name="id" value="${obiect.id}">
							<button type="submit">Sterge</button>
						</form>
					</td>
				</tr>
				<c:set var="n" value ="${n+1}"></c:set>
			</c:forEach>
		</table>
		<script>
			function f(id, big){
					if(document.getElementById(id).innerHTML == "Este mare?"){
						if(big){
						    document.getElementById(id).innerHTML = "Da";
						}else{
						    document.getElementById(id).innerHTML = "Nu";
						}
					}else {
						document.getElementById(id).innerHTML = "Este mare?";
					}
			}
		</script>
	</body>
</html>
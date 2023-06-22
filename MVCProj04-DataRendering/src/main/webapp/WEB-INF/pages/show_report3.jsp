<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: navy; text-align: center">Report Page 3</h1>
<br>
<h2 style="color:blue; text-align: center">Reading List of Model Objects</h2>
<table border="1" align="center">
	<tr>
		<th>eno</th>
		<th>ename</th>
		<th>desg</th>
		<th>salary</th>
	</tr>
	<c:forEach var="emp" items="${empsList}">
		<tr>
			<td>${emp.eno}</td>
			<td>${emp.ename}</td>
			<td>${emp.desg}</td>
			<td>${emp.salary}</td>
		</tr>
	</c:forEach>
</table>

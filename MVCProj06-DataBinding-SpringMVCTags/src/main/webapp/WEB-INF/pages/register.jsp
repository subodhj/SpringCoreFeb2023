<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<title>Registration Page</title>

	<h1 style="color: navy; text-align: center">Registration Page</h1>
	<br>
	<h2 style="color: green; text-align: center">Register Employee</h2>

	<!-- <form:form action="register" method="post"> -->
	<f:form modelAttribute="emp">
		<table bgcolor=cyan border="1" align="center">
			<tr>
				<td>Number</td>
				<td><f:input path="eno" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><f:input path="ename" /></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><f:input path="desig" /></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><f:input path="salary" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Register"></td>
			</tr>
		</table>
	</f:form>

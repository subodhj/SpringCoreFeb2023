<%@ page isELIgnored="false"%>

<title>Registration Page</title>

	<h1 style="color: navy; text-align: center">Registration Page</h1>
	<br>
	<h2 style="color: green; text-align: center">Register Employee</h2>
	
	<!-- <form action="register" method="post"> -->
	<form method="post">
		<table bgcolor=cyan border="1" align="center">
			<tr>
				<td>Number</td>
				<td><input type="text" name="eno"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="ename"></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><input type="text" name="desig"></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>

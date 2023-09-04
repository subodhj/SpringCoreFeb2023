<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<h1 style="text-align: center; color: red">Voter Registration</h1>
<br><br>
<f:form action="register_voter" modelAttribute="voter">

	<table border="0" bgcolor="red" align="center">
	<p style="color: red;">
	<f:errors path="*" />
	</p>
		<tr bgcolor="lime">
			<td>Name</td>
			<td><f:input path="name" /></td>
		</tr>
		<tr bgcolor="yellow">
			<td>Date of Birth</td>
			<td><f:input path="dob" type="date" /></td>
		</tr>
		<tr bgcolor="lime">
			<td>Date of Registration</td>
			<td><f:input path="dor" type="date" /></td>
		</tr>
		<tr align="right" bgcolor="yellow">
			<td colspan="2">
			<input type="submit" value="Register" style="color: green;"> 
			<input type="reset" value="Cancel" style="color: red">
			</td>
		</tr>
			
	</table>

</f:form>
<br><br>
<h4 style="text-align:center"><a style="color: brown" href="./">Home</a></h4>

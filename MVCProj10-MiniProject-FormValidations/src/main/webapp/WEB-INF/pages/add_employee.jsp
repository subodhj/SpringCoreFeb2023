<%@ page language="java" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<h1 style="text-align: center; color: blue">Register Employee</h1>
<br>
<f:form modelAttribute="emp">
	<p style="text-align: center; color: red">
		<f:errors path="*" />
	</p>
	<table border="1" align="center" color="cyan">
		<tr>
			<td>Name</td>
			<td><f:input path="ename" /></td>
		</tr>
		<tr>
			<td>Designation</td>
			<td><f:input path="job" /></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><f:input path="sal" /></td>
		</tr>
		<tr>
			<td>DepartmentNo</td>
			<td><f:input path="deptno" /></td>
		</tr>
		<tr>
			<!-- <td><input type="submit" value="Register"></td> -->
			<td colspan="2" align="right"><input type="image"
				src="images/submit-01.png" height="40" width="70">
				<button type="reset">
					<img src="images/reset-01.png" height="40" width="70">
				</button></td>
		</tr>
	</table>
</f:form>
<br>
<br>
<h3 style="text-align: center">
	<a href="./">Home <img src="images/home-03.png" height="30"
		width="30" align="middle"></a>
</h3>
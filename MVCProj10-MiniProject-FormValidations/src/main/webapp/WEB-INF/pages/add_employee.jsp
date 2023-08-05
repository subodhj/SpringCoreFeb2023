<%@ page language="java" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<h1 style="text-align: center; color: blue">Register Employee</h1>
<script type="text/javascript" src="js/emp_form_validation.js">
</script>
<br>
<f:form modelAttribute="emp" onsubmit=" return validate(this)">
	<%-- <p style="text-align: center; color: red">
		<f:errors path="*" />
	</p> --%>
	<table border="1" align="center" color="cyan">
		<tr>
			<td>Name</td>
			<td><f:input path="ename" /> <f:errors path="ename" cssStyle="color:red" /> <span id="enameErr" style="color:red"></span></td>
		</tr>
		<tr>
			<td>Designation</td>
			<td><f:input path="job" /> <f:errors path="job" cssStyle="color:red" /> <span id="jobErr" style="color:red"></span></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><f:input path="sal" /> <f:errors path="sal" cssStyle="color:red" /> <span id="salErr" style="color:red"></span></td>
		</tr>
		<tr>
			<td>DepartmentNo</td>
			<td><f:input path="deptno" /> <f:errors path="deptno" cssStyle="color:red" /> <span id="deptnoErr" style="color:red"></span></td>
		</tr>
		<tr>
		<%-- <td><f:hidden path="vflag"/></td> --%>
		<td><f:hidden path="isVerified"/></td>
		</tr>
		<tr>
			<!-- <td><input type="submit" value="Register"></td> -->
			<td colspan="2" align="right"> 
			     <input type="image" src="images/submit-01.png" height="40" width="70">
				<button type="reset"> <img src="images/reset-01.png" height="40" width="70"></button>
			</td>
		</tr>
	</table>
</f:form>
<br>
<br>
<h3 style="text-align: center">
	<a href="./">Home <img src="images/home-03.png" height="30" width="30" align="middle"></a>
</h3>
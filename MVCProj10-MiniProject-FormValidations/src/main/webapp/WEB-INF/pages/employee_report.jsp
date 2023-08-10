<%@ page language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 style="text-align: center; color: maroon">Employee Report</h1>
<c:choose>
	<c:when test="${!empty page}">
		<table border="1" bgcolor=#DFFF00 align="center">
			<tr bgcolor="yellow">
				<th>empno</th>
				<th>ename</th>
				<th>job</th>
				<th>sal</th>
				<th>deptno</th>
				<th>operations</th>
			</tr>
			<c:forEach var="emp" items="${page.getContent()}">
				<tr>
					<td style="text-align: center;">${emp.empno}</td>
					<td style="text-align: center;">${emp.ename}</td>
					<td style="text-align: center;">${emp.job}</td>
					<td style="text-align: center;">${emp.sal}</td>
					<td style="text-align: center;">${emp.deptno}</td>
					<td style="text-align: center;">
					     <a href="editEmp?empno=${emp.empno}">
					        <img src="images/edit-03.png" height="30" width="30" align="middle"></a> &nbsp;&nbsp; 
						 <a href="deleteEmp?empno=${emp.empno}" onclick="return confirm('Do you want to delete')">
						   <img src="images/delete-03.png" height="30" width="30" align="middle">
						 </a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<p style="text-align: center">
		   <c:if test="${!page.isFirst()}">
		      [<a href="emp_report?page=0">First</a>] &nbsp;
		   </c:if>
		   <c:if  test="${!page.isFirst()}">
		      [<a href="emp_report?page=${page.getNumber()-1}"><img src="images/arrow-right-previous.jpg" height="10" width="10" align="bottom"></a>] &nbsp;
		   </c:if>
		   <c:forEach var="i" begin="1" end="${page.getTotalPages()}" step="1">
		      [<a href="emp_report?page=${i-1}">${i}</a>] &nbsp;
		   </c:forEach>
		   <c:if test="${!page.isLast()}">
		      [<a href="emp_report?page=${page.getNumber()+1}"><img src="images/arrow-left-next.jpg" height="10" width="10" align="bottom"></a>] &nbsp;
		   </c:if>
		   <c:if test="${!page.isLast()}">
		      [<a href="emp_report?page=${page.getTotalPages()-1}">Last</a>]
		   </c:if>
		</p>
	</c:when>
	<c:otherwise>
		<h1 style="text-align: center; color: red">No Records Found</h1>
	</c:otherwise>
</c:choose>
<br>
<h3 style="text-align: center">
	<a href="insertEmp">Add Employee <img src="images/add-03.png"
		height="30" width="30" align="middle"></a>
</h3>
<blink>
	<h3 style="text-align: center; color: green">${resultMsg}</h3>
</blink>
<br>
<h3 style="text-align: center">
	<a href="./">Home <img src="images/home-03.png" height="30" width="30"
		align="middle"></a>
</h3>


<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: navy; text-align: center;">Report Page 2</h1>
<br>
<h2>Reading Array & Collection Type Values</h2>
<br>
<b>Nick Names   (Array)</b>
<br>
<c:forEach var="name" items="${nickNames }">
 ${name} <br>
</c:forEach>
<hr>
<br>
<b>Contact Numbers   (Set)</b>
<br>
<c:forEach var="no" items="${contactNos}">
${no} <br>
</c:forEach>
<hr>
<br>
<b>Courses   (List)</b>
<br>
<c:forEach var="course" items="${courses}">
${course} <br>
</c:forEach>
<hr>
<br>
<b>IDs   (Map)</b>
<br>
<c:forEach var="id" items="${ids}">
<%-- ${id} <br> --%>
${id.key} : ${id.value} <br>
</c:forEach>
<hr>
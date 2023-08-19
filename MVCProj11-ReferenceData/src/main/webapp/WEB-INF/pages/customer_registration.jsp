<%@ page language="java" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<h1 style="text-align: center;color: navy;">Customer Registration Form</h1>
<br><br>
<f:form action="customer_register" modelAttribute="cust">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Customer Number</td>
			<td><f:input path="cno" /></td>
		</tr>
		<tr>
			<td>Customer Name</td>
			<td><f:input path="cname" /></td>
		</tr>
		<tr>
			<td>Country</td>
			<td>
			  <f:select path="country">
			    <f:options items="${countriesList}" />
			  </f:select>
			</td>
		</tr>
		<tr>
			<td>Languages</td>
			<td>
			  <f:select path="languages" multiple="multiple" size="5">
			    <f:options items="${languagesList}" />			  
			  </f:select>
			</td>
		</tr>
		<tr>
			<td>Hobbies</td>
			<td>
			  <f:checkboxes items="${hobbiesList}" path="hobbies"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			  <input type="submit" value="Submit" /> 
			  <input type="reset" value="Cancel" />
			</td>
		</tr>
	</table>
</f:form>
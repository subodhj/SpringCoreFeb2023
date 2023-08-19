<%@ page language="java" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<h1 style="text-align: center;color: navy;">Customer Registration Form</h1>
<br><br>
<f:form name="frm" action="customer_register" modelAttribute="cust">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Customer Number</td>
			<td><f:input path="cno" /></td>
		</tr>
		<tr>
			<td>Customer Name</td>
			<td><f:input path="cname" /></td>
		</tr>
		<script type="text/javascript">
            function getStates() {
	           frm.action="states";
	           frm.submit();
            }
        </script>
		<tr>
			<td>Country</td>
			<td>
			  <f:select path="country" onchange="getStates()">
			    <f:options items="${countriesList}" />
			  </f:select>
			</td>
		</tr>
		<tr>
			<td>State</td>
			<td>
			  <f:select path="state">
			    <f:options items="${statesList}" />
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
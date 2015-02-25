<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Employees</title>
</head>
<body>
<h2>Employee List</h2>
<table style="border: 1px solid gray;">
<tr>
	<td>Name</td>
	<td>Email</td>
	<td>Phone</td>
	<td>Job Title</td>
	<td>Modifications</td>
</tr>
<s:iterator value="employees">
<tr style="border: 1px solid gray;">
	
	<td><s:property value = "Name"/></td>
	<td><s:property value = "Email"/></td>
	<td><s:property value = "Phone"/></td>
	<td><s:property value = "Job_Title"/></td>
	
	<td><s:form action="goToUpdateEmployee" method="post">
	<s:param name="employee" value = "employee"/>
	<s:hidden name="employee.Employee_ID" value="%{Employee_ID}"/>
	<s:submit value="UPDATE" align="center" />
	</s:form></td>
	
	<td><s:form action="disableEmployee" method="post">
	<s:param name="employee" value = "employee"/>
	<s:hidden name="employee.Employee_ID" value="%{Employee_ID}"/>
	<s:submit value="DISABLE" align="center" />
	</s:form></td>
	
</tr>
</s:iterator>

<s:form action="goToNewEmployee" method="post">
	<s:submit method="execute" key="label.goToNewEmployee" align="center" />
</s:form>
</table>

</body>
</html>
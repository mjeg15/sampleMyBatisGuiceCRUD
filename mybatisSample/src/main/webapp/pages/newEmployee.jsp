<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Employee</title>
</head>
<body>
<h2>Employee Details Form</h2>

<s:form action="createEmployee" method="post">
	<s:textfield name="employee.Name" key="label.Name" value="%{employee.Name}" size="20" />
	<s:textfield name="employee.Email" key="label.Email" value="%{employee.Email}" size="20" />
	<s:textfield name="employee.Phone" key="label.Phone" value="%{employee.Phone}" size="20" />
	<s:textfield name="employee.Job_Title" key="label.Job_Title" value="%{employee.Job_Title}" size="20" />
	<s:hidden name="employee.Employee_ID" value="%{employee.Employee_ID}"/>
	<s:if test="employee == null">
		<s:submit method="execute" key="label.create" align="center" />
	</s:if>
	<s:else>
		<s:submit method="execute" key="label.update" align="center" />
	</s:else>
	
</s:form>
</body>
</html>
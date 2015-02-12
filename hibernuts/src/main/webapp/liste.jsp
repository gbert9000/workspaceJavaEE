<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<body>
		<s:iterator value="stagiaires">
			<s:property value = "nom"/> - <s:property value = "prenom"/> - <s:property value = "email"/>
			<small>inscrit le <s:property value = "inscription"/></small> 
		</s:iterator>
	</body>
</html>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="m" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<h1><%= new Date()%></h1><br/>

	<h1>Date : <m:date h24="true"/> </h1>
	<h2>Date : <m:date /> </h2>
	<h3>Date : <m:date /> du texte dans le body</h3>
	
	<m:date>
	------------------------
	------------------------
	</m:date>
</body>
</html>
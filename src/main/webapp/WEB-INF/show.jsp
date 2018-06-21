<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
         <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><c:out value="${p.firstName}"/> <c:out value="${p.lastName}"/></h1>
	<h3>License Number <c:out value="00000${l.id}"/></h3>
	<h3>State: <c:out value="${l.state}"/></h3>
	<h3>Expiration Date: <fmt:formatDate pattern = "yyyy-MM-dd" value="${l.expiration_date}"/></h3>
</body>
</html>
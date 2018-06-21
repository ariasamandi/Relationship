<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New License</h1>
	<form:form action="/license/create" method="post" modelAttribute="license">
		<p>
	        <form:label path="Person">Person: </form:label>
	        <form:select path="Person">
			    <c:forEach var="p" items="${person}">
					<form:option value="${p.id}" label="${p.firstName} ${p.lastName}"></form:option>
				</c:forEach>
			</form:select>
	    </p>
	    <p>
	        <form:label path="state">State: </form:label>
	        <form:errors path="state"/>
	        <form:input path="state"/>
	    </p>
	    <p>
	    	<form:label path="expiration_date">Expiration Date: </form:label>
			<input type="date" name="exp">
			<input type="submit" value="create">
	</form:form>
</body>
</html>
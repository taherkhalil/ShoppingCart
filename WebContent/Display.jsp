<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<c:forEach var ="map" items="${map}"> <td>${map.key}</td><br/><td>${map.value}<br/></td></c:forEach>
<form action="Cart" method ="post">
<input type="number" name=key value="enter the value to remove">
<input type="submit" name="del" value="delete" ">

</form>

</body>
</html>
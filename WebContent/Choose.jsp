<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="abc" uri="WEB-INF/log.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>choose items</title>
</head>
<body>

<h1>hiii</h1>
 <c:out value="${username}"/> 
 <form action="Cart" method= "post">
Please Select item u want:<select name ="items" required= "required" multiple="multiple">

<option  value="watch">watch</option>
<option value="belt">belt</option>
<option value ="hat">hat</option>
</select>
<input type="submit" value ="add to cart" name="add">
</form>
</body>
</html>
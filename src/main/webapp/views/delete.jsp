
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<form action="deleteContacts" method="DELETE">
  <label for="contactId">ContactID:</label><br>
  <input type="text" id="contactId" name="contactId"><br>
   <input type="submit" value="Submit">
</form>

</table>
</form>
</body>
</html>

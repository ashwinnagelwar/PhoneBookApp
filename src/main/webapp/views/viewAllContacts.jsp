<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function confirmDelete(){
	return confirm("Are you sure,you want to delete?");
}
</script>
</head>
<body>

<a href="saveNewContact">+ Add New Contact</a>
<font color='green'>${deleteSuc}</font>
<font color='red'>${delete}</font>
<table border="1">
<thead>
<tr>
<td>Name</td>
<td>Email</td>
<td>Number</td>
<td>Action</td>
</tr>
</thead>

<tbody>

<c:forEach items="${contacts}" var="contact">
				<tr>
					<td>${contact.contactName}</td>
					<td>${contact.contactEmail}</td>
			    	<td>${contact.contactNumber}</td>
				    <td> <a href="updateContact?cid=${contact.contactId}">Edit</a> <a href="deleteContacts?cid=${contact.contactId}" onclick="return confirmDelete()">Delete</a></td>
					</tr>
			</c:forEach>
		</tbody>
				

</tbody>

</table>

</body>
</html>

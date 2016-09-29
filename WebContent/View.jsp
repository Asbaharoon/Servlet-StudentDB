<%@page import="com.coder.servlet.DeleteServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page language="java" import="java.util.List, com.coder.student.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View All</title>
<link href='css/bootstrap.min.css' rel=stylesheet>
</head>
<body>
<a href='index.html' class='btn btn-info' role='button'>Add Student</a>
<h1>Student Table</h1>
<% List<Student> list = StudentSQL.AllStudents(); %>
<table border="1" style=" width: 100% ">
<tr>
<th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th>
</tr>
<% 
for(Student student : list){ 
%>
<tr><td> <%=student.getId()%></td><td><%=student.getName()%> </td><td> <%=student.getPassword()%></td><td> <%=student.getEmail()%>
<td> <%=student.getCountry()%></td><td> <a href="UpdateServlet?id=<%=Integer.toString(student.getId())%>">edit</a> </td>
<td> <a href="DeleteServlet?id=<%=Integer.toString(student.getId())%>">delete</a></td></tr>
<% }%>
</table>
</body>
</html>
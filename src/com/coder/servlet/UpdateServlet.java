package com.coder.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coder.student.Student;
import com.coder.student.StudentSQL;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1> Update Student Info </h1>");
		String StudentId = request.getParameter("id");
		int id = Integer.parseInt(StudentId);
		
		Student student = StudentSQL.ReadOneStudent(id);
		
		printWriter.print("<head>");  
		printWriter.print(" <link href='css/bootstrap.min.css' rel='stylesheet'>");  
		printWriter.print(" </head>");  
		printWriter.print("<body>");  
		printWriter.print("<form action='UpdateServlet2' method='post'>");  
		printWriter.print("<table>");  
		printWriter.print("<tr><td>Id</td><td><input   name='id' value='"+student.getId()+"'/></td></tr>");  
		printWriter.print("<tr><td>Name:</td><td><input type='text' name='name' value='"
		+student.getName()+"'/></td></tr>");  
		printWriter.print("<tr><td>Password:</td><td><input type='password' name='password' value='"
		+student.getPassword()+"'/></td></tr>");  
		printWriter.print("<tr><td>Email:</td><td><input type='email' name='email' value='"
		+student.getEmail()+"'/></td></tr>");  
		printWriter.print("<tr><td>Country:</td><td><input type='text' name='country' value='"
				+student.getCountry()+"'/></td></tr>");  
		  
		printWriter.print("<tr><td colspan='2'><input type='submit' value='submit '/></td></tr>");  
		printWriter.print("</table>");  
		printWriter.print("</form>");
		printWriter.print("</body>"); 
	
	}



}

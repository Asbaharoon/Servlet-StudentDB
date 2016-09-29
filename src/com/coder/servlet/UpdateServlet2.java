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
 * Servlet implementation class UpdateServlet2
 */
@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		String StudentId = request.getParameter("id");
		int id = Integer.parseInt(StudentId);
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setPassword(password);
		student.setEmail(email);
		student.setCountry(country);
		
		boolean status = false;
		status = StudentSQL.Update(student);
		if (status == true) {
			response.sendRedirect("View.jsp");
			printWriter.println(name+" "+password+" "+email+" "+country);

		}else {
			printWriter.println("<h2> Sorry not updated :( </h2>");
		}
	}

}

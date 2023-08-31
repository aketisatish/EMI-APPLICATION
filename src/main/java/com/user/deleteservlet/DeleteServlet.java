package com.user.deleteservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.registration.UserDao;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      
		 PrintWriter writer=response.getWriter();
		 response.setContentType("text/html");
		String employeeId=request.getParameter("employeeId");
		boolean result;
		
		result= UserDao.deleteUserById(employeeId);
		System.out.println(result);
		if(result!=true) {
			writer.println("<h2 style='color: green;text-align: center'>success fully deleted..</h2>");
			request.getRequestDispatcher("members.jsp").include(request, response);
		}
		else {
			writer.println("<h2 style='color: red; text-align: center'>deleted fail..</h2>");
			request.getRequestDispatcher("members.jsp").include(request, response);
		}
	}

}

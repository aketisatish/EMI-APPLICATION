package com.user.registration;

import java.io.IOException;
//import java.io.PrintWriter;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegitration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		String employeeId = request.getParameter("employeeId");
		String caste = request.getParameter("caste");
		String doj = request.getParameter("dateOfJoining");
		String employeeName = request.getParameter("employeeName");
		String subCaste = request.getParameter("subCaste");
		String employeeFatherName = request.getParameter("employeeFatherName");
		Double thriftDeposit = Double.parseDouble(request.getParameter("thriftDeposit"));

		UserData user = new UserData(employeeId, caste, doj, employeeName, subCaste, employeeFatherName, thriftDeposit);
		int result = 0;
		try {
			result = UserDao.saveData(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result == 1) {
			writer.println("<h3 style='color: green;text-align: center'>Success fully registered..</h3>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("members.jsp");
			dispatcher.include(request, response);
		} else {
			writer.println("<h3 style='color: red; text-align: center'>registeration fail..</h3>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("addnew.jsp");
			dispatcher.include(request, response);
		}
	}

}

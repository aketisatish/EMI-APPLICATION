package com.users.updatedetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.registration.TestConnection;
import com.user.registration.UserDao;
import com.user.registration.UserData;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		String employeeId = request.getParameter("employeeId");
		String caste = request.getParameter("caste");
		String dateOfJoining = request.getParameter("dateOfJoining");
		String employeeName = request.getParameter("employeeName");
		String subCaste = request.getParameter("subCaste");
		String employeeFatherName = request.getParameter("employeeFatherName");
		Double thriftDeposit = Double.parseDouble(request.getParameter("thriftDeposit"));

		UserData user = new UserData(employeeId, caste, dateOfJoining, employeeName, subCaste, employeeFatherName,
				thriftDeposit);
		boolean rowUpdated = UserDao.UpdateUser(user);
		// System.out.println(rowUpdated);
	
		if (rowUpdated == false) {
			writer.println("<h1 style='color: green;text-align: center'>Successfully updated..</h1>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("members.jsp");
			dispatcher.include(request, response);
		} else {
			writer.println("<h1 style='color: red;text-align: center'>update failed..</h1>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("members.jsp");
			dispatcher.include(request, response);
		}
	}

}

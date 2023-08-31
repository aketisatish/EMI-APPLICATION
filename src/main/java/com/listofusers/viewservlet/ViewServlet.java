package com.listofusers.viewservlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.registration.UserDao;
import com.user.registration.UserData;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      List<UserData>users=new ArrayList<>();
      
           ResultSet resultSet= UserDao.listOfUsers();
           UserData user=null;
           if(resultSet!=null) {
        	   try {
				while(resultSet.next()) {
					 user= new UserData(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),resultSet.getDouble(7)); 
				   users.add(user);
				   
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	 request.setAttribute("users", users); 
        	 request.getRequestDispatcher("members.jsp").include(request, response);
        	 //request.getRequestDispatcher("update.jsp").include(request, response);
           }
	}
}

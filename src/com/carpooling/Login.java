package com.carpooling;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carpooling.dao.LoginDao;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginDao dao=new LoginDao();
		
		String email=request.getParameter("mail");
		String password=request.getParameter("pass");
		
		if(dao.check(email, password))
		{
			HttpSession session=request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("welcome.jsp");
		}
		else
		{
			request.setAttribute("error","Invalid Username or Password");
			RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
			rd.include(request, response);
		}
	}

}

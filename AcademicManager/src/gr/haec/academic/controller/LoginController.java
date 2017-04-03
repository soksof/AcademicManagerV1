package gr.haec.academic.controller;

import gr.haec.academic.model.Person;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller class for login screen
 * @author instructor
 *
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = -3658105520031582041L;

	public LoginController() {
		super();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
 
		AuthenticateUser authenticator = new AuthenticateUser();
		int personID = authenticator.authenticate(username, password);
		if (personID!=-1) {//Did not find the user
			rd = request.getRequestDispatcher("/success.jsp");
			//Maybe create a Person instance
			request.setAttribute("personID", personID);
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
			//alert("Error Password or Username")
		}
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
 
		AuthenticateUser authenticator = new AuthenticateUser();
		int personID = authenticator.authenticate(username, password);
		if (personID!= -1) {
			rd = request.getRequestDispatcher("/success.jsp");
			//Maybe create a Person instance
			request.setAttribute("personID", personID);
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
			//alert("Error Password or Username")
		}
		rd.forward(request, response);
	}
}
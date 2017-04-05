package gr.haec.academic.controller;

import gr.haec.academic.model.Person;

import java.io.IOException;
import java.io.PrintWriter;

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
		if (personID!=-1) {//found a user
			//Maybe create a Person instance
			request.setAttribute("personID", personID);
			rd = request.getRequestDispatcher("/StudentView");
		} else {//Did not find the user
			PrintWriter out=response.getWriter();
			out.println("<script language='javascript' type='text/javascript'>");
			out.println("alert(\"Invalid username or password!\")");
			out.println("</script>");
			rd = request.getRequestDispatcher("/index.html");
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
			rd = request.getRequestDispatcher("/StudentView");
			//Maybe create a Person instance
			request.setAttribute("personID", personID);
		} else {
			PrintWriter out=response.getWriter();
			out.println("<script language='javascript' type='text/javascript'>");
			out.println("alert(\"Invalid username or password!\")");
			out.println("</script>");
			rd = request.getRequestDispatcher("/index.html");
		}
		rd.forward(request, response);
	}
}
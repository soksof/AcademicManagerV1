package gr.haec.academic.controller;

import gr.haec.academic.model.Person;
import gr.haec.academic.model.Role;

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
		Person p1 = authenticator.authenticate(username, password);
		if (p1!=null) {//found a user
			//Maybe create a Person instance
			request.setAttribute("person", p1);
			if(p1.getRole().equals(Role.secretary)){
				rd = request.getRequestDispatcher("/home_secr.jsp");
			}
			else if(p1.getRole().equals(Role.teacher)){
				rd = request.getRequestDispatcher("/home_teach.jsp");
			}
			else if(p1.getRole().equals(Role.student)){
				rd = request.getRequestDispatcher("/home_stud.jsp");
			}
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
		Person p1 = authenticator.authenticate(username, password);
		if (p1!=null) {//found a user
			//Maybe create a Person instance
			request.setAttribute("person", p1);
			if(p1.getRole().equals(Role.secretary)){
				rd = request.getRequestDispatcher("/home_secr.jsp");
			}
			else if(p1.getRole().equals(Role.teacher)){
				rd = request.getRequestDispatcher("/home_teach.jsp");
			}
			else if(p1.getRole().equals(Role.student)){
				rd = request.getRequestDispatcher("/home_stud.jsp");
			}
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
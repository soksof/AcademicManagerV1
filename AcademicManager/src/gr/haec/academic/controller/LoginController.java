package gr.haec.academic.controller;

import gr.haec.academic.db.PersonDao;
import gr.haec.academic.model.Person;
import gr.haec.academic.model.Role;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		this.doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
 
		PersonDao authenticator = new PersonDao();
		Person p1 = authenticator.authenticate(username, password);
		if (p1!=null) {//found a user
			//Maybe create a Person instance
			HttpSession session = request.getSession();
			session.setAttribute("person", p1);
			if(p1.getRole().equals(Role.secretary)){
				rd = request.getRequestDispatcher("/WEB-INF/jsp/home_secr.jsp");
			}
			else if(p1.getRole().equals(Role.teacher)){
				rd = request.getRequestDispatcher("/WEB-INF/jsp/home_teach.jsp");
			}
			else if(p1.getRole().equals(Role.student)){
				rd = request.getRequestDispatcher("/WEB-INF/jsp/home_stud.jsp");
			}
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("/index.html");
			PrintWriter out=response.getWriter();
			out.println("<script language='javascript' type='text/javascript'>");
			out.println("alert(\"Invalid username or password!\")");
			out.println("</script>");
		
			rd.include(request, response);

		}
	}
}
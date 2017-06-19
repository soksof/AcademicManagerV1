package gr.haec.academic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gr.haec.academic.db.PersonDao;
import gr.haec.academic.model.Person;

@WebServlet(urlPatterns = { "/ViewPerson" }) 
public class ViewPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	protected void viewPerson(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;
		PersonDao pd=new PersonDao();
		Person p=pd.getPersonID(Integer.parseInt(request.getParameter("personID")));
		request.setAttribute("personq", p);
		if (p!=null)
			rd = request.getRequestDispatcher("/WEB-INF/jsp/viewperson.jsp");
		rd.forward(request, response);
	}
	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
	}
}

package gr.haec.academic.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gr.haec.academic.db.PersonDao;
import gr.haec.academic.model.Person;
import gr.haec.academic.model.Role;

@WebServlet(urlPatterns = { "/person" })

public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Process GET request
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "view":
			viewPerson(request, response);
			break;
		case "profile":
			viewProfile(request, response);
			break;
		case "edit":
			editPerson(request, response);
			break;
		case "insert":
			break;
		case "new":
			break;
		}
	}

	/**
	 * Process POST request
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		updatePerson(request, response);
		String personID = request.getParameter("personid");
		Person p = null;
		if (personID != null)
			p = updatePerson(request, response);
		else
			p = insertPerson(request, response);
		// Store the new or updated person as a session variable
		HttpSession session = request.getSession();
		session.setAttribute("person", p);
		RequestDispatcher rd = null;
		if (p.getRole().equals(Role.secretary)) {
			rd = request.getRequestDispatcher("/WEB-INF/jsp/home_secr.jsp");
		} else if (p.getRole().equals(Role.teacher)) {
			rd = request.getRequestDispatcher("/WEB-INF/jsp/home_teach.jsp");
		} else if (p.getRole().equals(Role.student)) {
			rd = request.getRequestDispatcher("/WEB-INF/jsp/home_stud.jsp");
		}
		rd.forward(request, response);
	}

	/**
	 * method to a new person in the database
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private Person insertPerson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}

	/**
	 * method to edit the profile of a person
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private Person updatePerson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String personID = request.getParameter("personid");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String sdob = request.getParameter("dob");
		Date dob = java.sql.Date.valueOf(sdob);
		String taxnumber = request.getParameter("taxnumber");
		String iban = request.getParameter("iban");
		String address = request.getParameter("address");
		String sex = request.getParameter("sex");
		PersonDao pd = new PersonDao();
		return pd.updatePerson(name, surname, email, phone, sex, address, dob, taxnumber, iban, personID);
	}

	/**
	 * method to view the profile of a person
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void viewPerson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		PersonDao pd = new PersonDao();
		Person p = pd.getPersonID(Integer.parseInt(request.getParameter("personID")));
		request.setAttribute("personq", p);
		if (p != null)
			rd = request.getRequestDispatcher("/WEB-INF/jsp/viewperson.jsp");
		rd.forward(request, response);
	}

	/**
	 * method to view the profile of the person that has logged in the system
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void viewProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		Person p = (Person) session.getAttribute("person");
		if (p == null)
			rd = request.getRequestDispatcher("/index.html");
		else
			rd = request.getRequestDispatcher("/WEB-INF/jsp/viewprofile.jsp");
		rd.forward(request, response);
	}

	/**
	 * method to update the information for a person
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void editPerson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		PersonDao pd = new PersonDao();
		Person p = pd.getPersonID(Integer.parseInt(request.getParameter("personID")));
		request.setAttribute("personq", p);
		if (p != null)
			rd = request.getRequestDispatcher("/WEB-INF/jsp/editperson.jsp");
		rd.forward(request, response);
	}
}
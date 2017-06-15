package gr.haec.academic.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gr.haec.academic.db.CourseDao;
import gr.haec.academic.db.PersonDao;
import gr.haec.academic.model.Course;
import gr.haec.academic.model.Person;
import gr.haec.academic.model.Student;

@WebServlet(urlPatterns = { "/student" })

public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Process GET request
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "view":
			viewStudent(request, response);
			break;
		case "update":
			updateStudent(request, response);
			break;
		case "edit":
			break;
		case "insert":
			break;
		case "new":
			break;
		case "courseEvaluation":
			System.out.println("ASDASDSADASD");
			courseEvaluation(request, response);
			break;
		case "activeCourses":
			System.out.println("ASDASDSADASDsssss");
			activeCourses(request, response);
			break;
		case "pastCourses":
			System.out.println("ASDASDSADASD222222222");
			pastCourses(request, response);
			break;
		}
	}

	/**
	 * Process POST request
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * method to view the information for a course
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void viewStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * method to update the information for a course
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * method to view the evaluation of a student for a given course
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void courseEvaluation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("personID"));
		int cid = Integer.parseInt(request.getParameter("courseID"));

		PersonDao c = new PersonDao();
		List<Student> list = c.getStudentEvaluation(pid, cid);
		request.setAttribute("StudentEvaluations", list);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/jsp/viewstudentevaluation.jsp");
		rd.forward(request, response);
	}

	/**
	 * method to view the active courses of a student
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void activeCourses(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CourseDao c = new CourseDao();
		HttpSession session = request.getSession();
		Person p = (Person) session.getAttribute("person");
		List<Course> list = c.getStudentCourses(p.getPersonID());
		request.setAttribute("StudentActiveCourses", list);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/jsp/viewstudentactivecourses.jsp");
		rd.forward(request, response);
	}

	/**
	 * method to view the past courses of a student
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void pastCourses(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Person p = (Person) session.getAttribute("person");
		PersonDao c = new PersonDao();
		List<Object[]> list = c.getCompleteStudentCourses(p.getPersonID());
		request.setAttribute("StudentActiveCourses", list);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/jsp/viewstudentpastcourses.jsp");
		rd.forward(request, response);
	}
}
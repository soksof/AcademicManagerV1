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
import gr.haec.academic.model.Teacher;

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
			courseEvaluation(request, response);
			break;
		case "activeCourses":
			activeCourses(request, response);
			break;
		case "studentApllication":
			studentApllication(request, response);
			break;
		case "pastCourses":
			pastCourses(request, response);
			break;
		case "listcoursestudappl":
			listCourseStudAppl(request, response);
			break;
		case "allStudentEvaluation":
			allStudentEvaluation(request, response);
			break;
		case "studentPayments":
			studentPayments(request, response);
			break;
		case "pendingPayments":
			pendingPayments(request, response);
			break;
		case "historyPayments":
			historyPayments(request, response);
			break;
		case "courseStudents":
			courseStudents(request, response);
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
	/**
	 * method to view all student applications.
	 * παρότι είναι ίδιο με το από κάτω χρησιμοποιούνται διαφορετικά.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listCourseStudAppl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonDao d= new PersonDao();
		List <Object[]> list = d.getApplicantStudent();
		request.setAttribute("applicantList",list);
		RequestDispatcher rd; 
		rd=request.getRequestDispatcher("/WEB-INF/jsp/viewcoursestudentapplication.jsp");
		rd.forward(request, response);
	}
	/**
	 * method to view all student applications.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void studentApllication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonDao c = new PersonDao();
		List<Object[]> list = c.getApplicantStudent();
		request.setAttribute("applicantStudent", list);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/jsp/viewstudentapplications.jsp");
		rd.forward(request, response);
	}
	/**
	 * servlet for all the students evaluation
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void allStudentEvaluation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonDao c = new PersonDao();
		List<Object[]> list = c.getAllStudentsEvaluation() ;
		request.setAttribute("studentEvaluation", list);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/jsp/viewallstudentevaluation.jsp");
		rd.forward(request, response);
	}
	/**
	 * method for all the payment informations for each student
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void studentPayments(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonDao c = new PersonDao();
		List<Object[]> list = c.getPaymentStudent() ;
		request.setAttribute("paymentStudent", list);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/jsp/viewstudentpayments.jsp");
		rd.forward(request, response);
	}
	/**
	 * method for all the pending payments of a student.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void pendingPayments(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Person p = (Person) session.getAttribute("person");
		PersonDao pd = new PersonDao();
		List<Object[]> list = pd.getPendingPayment(p.getPersonID());
		request.setAttribute("pendingPayment",list);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/jsp/viewpendingpayment.jsp");
		rd.forward(request, response);
	}
	/**
	 * method for all the complete payments of a student.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void historyPayments(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Person p = (Person) session.getAttribute("person");
		PersonDao pd = new PersonDao();
		List<Object[]> list = pd.getHistoryPayment(p.getPersonID());
		request.setAttribute("historyPayment",list);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/jsp/viewhistorypayment.jsp");
		rd.forward(request, response);
	}
	/**
	 * method to find all the students that attending a certain course which is teached from a certain teacher.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void courseStudents(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Person p = (Person) session.getAttribute("person");
		PersonDao pd = new PersonDao();
		List<Object[]> list = pd.getCourseStudents(p.getPersonID());
		request.setAttribute("courseStudents",list);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/jsp/viewcoursestudents.jsp");
		rd.forward(request, response);
	}
	
}
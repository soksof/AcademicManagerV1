package gr.haec.academic.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.haec.academic.db.PersonDao;
import gr.haec.academic.model.Teacher;

@WebServlet(urlPatterns = { "/teacher" })
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Process GET request
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		switch (action) {
		case "courseApplicants":
			courseTeacherApplicant(request, response);
			break;
		case "courseTeachers":
			roleCourseTeachers(request, response);
			break;
		case "teachActiveCourses":
			teachActiveCourses(request, response);
			break;
		case "listApplicants":
			listApplicantTeachers(request, response);
			break;
		case "view":
			viewTeacher(request, response);
			break;
		case "update":
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
	private void viewTeacher(HttpServletRequest request, HttpServletResponse response)
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
	private void courseTeacherApplicant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonDao d = new PersonDao();
		List<Object[]> list = d.getApplicantCourseTeachers();
		request.setAttribute("courseTeacherApplicantList", list);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/jsp/viewcourseteacherapplicant.jsp");
		rd.forward(request, response);
	}

	/**
	 * Returns all teachers that teach a course
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void roleCourseTeachers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonDao d = new PersonDao();
		List<Teacher> list = d.getCourseTeachers();
		request.setAttribute("teacherList", list);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/jsp/viewcourseteachers.jsp");
		rd.forward(request, response);
	}
	/**
	 * Returns all teachers that teach a course
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void teachActiveCourses(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonDao d = new PersonDao();
		List<Teacher> list = d.getActiveTeachers();
		request.setAttribute("teacherActiveList", list);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/jsp/viewteacheractivecourses.jsp");
		rd.forward(request, response);
	}
	/**
	 * Lists all people that have applied to register as teachers
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listApplicantTeachers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonDao d= new PersonDao();
		List<Teacher> list = d.getApplicantTeachers();
		request.setAttribute("applicantList",list);
		RequestDispatcher rd; 
		rd=request.getRequestDispatcher("/WEB-INF/jsp/viewapplicantteachers.jsp");
		rd.forward(request, response);
	}
}
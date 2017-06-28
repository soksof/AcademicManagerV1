package gr.haec.academic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.haec.academic.db.CourseDao;
import gr.haec.academic.model.Course;

@WebServlet(urlPatterns = { "/course" })

public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Process GET request
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "view":
			viewCourse(request, response);
			break;
		case "update":
			updateCourse(request, response);
			break;
		case "add":
			addCourse(request, response);
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
		String sCid = request.getParameter("courseid");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/home_secr.jsp");
		if (sCid != null) {
			this.updateCourse(request, response);
		} else {
			this.insertCourse(request, response);
			rd.forward(request, response);
		}
	}

	/**
	 * method to view the information for a course
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void viewCourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		CourseDao cd = new CourseDao();
		Course c = cd.getCourseID(Integer.parseInt(request.getParameter("courseID")));
		request.setAttribute("courseq", c);
		if (c != null)
			rd = request.getRequestDispatcher("/WEB-INF/jsp/viewcourse.jsp");
		rd.forward(request, response);
	}

	/**
	 * method to update the information for a course
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updateCourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void addCourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/WEB-INF/jsp/addcourse.jsp");
		rd.forward(request, response);
	}

	private Course insertCourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String courseID = request.getParameter("courseid");
		String sstartDate = request.getParameter("startdate");
		Date startDate = java.sql.Date.valueOf(sstartDate);
		String sendDate = request.getParameter("enddate");
		Date endDate = java.sql.Date.valueOf(sendDate);
		String status = request.getParameter("status");
		String totalHours = request.getParameter("totalhours");
		String timetable = request.getParameter("timetable");
		String syllabus = request.getParameter("syllabus");
		String cost = request.getParameter("cost");
		String discount = request.getParameter("discount");
		String classroom = request.getParameter("classroom");
		String maxStudents = request.getParameter("maxstudent");
		String MinStudents = request.getParameter("minstudent");
		String credits = request.getParameter("credits");
		String idCourseCore = request.getParameter("idcoursecore");

		CourseDao pd = new CourseDao();
		return pd.addCourse(courseID, startDate, endDate, status, totalHours, timetable, syllabus, cost, discount,
				classroom, maxStudents, MinStudents, credits, idCourseCore);
	}
}

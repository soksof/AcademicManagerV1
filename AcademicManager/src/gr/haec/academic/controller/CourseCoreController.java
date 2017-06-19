package gr.haec.academic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.haec.academic.db.CourseDao;
import gr.haec.academic.model.Course;

@WebServlet(urlPatterns = { "/coursecore" })

public class CourseCoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Process GET request
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "view":
			viewCourseCore(request, response);
			break;
		}
	}

	/**
	 * Process POST request
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer ccid=Integer.parseInt(request.getParameter("courseID"));
		if(ccid !=null)
			this.updateCourseCore(request, response);
		else
			this.insertCourseCore(request, response);
	}

	/**
	 * method to view the information for a CourseCore
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void viewCourseCore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	/**
	 * method to insert a new CourseCore
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void insertCourseCore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		int ccid=Integer.parseInt(request.getParameter("courseID"));
		String ccname=request.getParameter("courseCore");
		String cctitle=request.getParameter("title");
		String ccdescr=request.getParameter("description");
		CourseDao cd=new CourseDao();
		cd.insertCourseCore(ccid, ccname, cctitle, ccdescr);
	}
	/**
	 * method to update the information for a course
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updateCourseCore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}

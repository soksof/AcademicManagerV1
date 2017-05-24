package gr.haec.academic.controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.haec.academic.db.CourseDao;
import gr.haec.academic.model.Course;

@WebServlet(urlPatterns = { "/CourseList" }) 
public class CoursesList extends HttpServlet {
	private static final long serialVersionUID = -3658105520031582041L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CourseDao d= new CourseDao();
		List<Course> list = d.getAllCourses();
		request.setAttribute("courseList",list);
		RequestDispatcher rd; 
		rd=request.getRequestDispatcher("/WEB-INF/jsp/courseList.jsp");
		rd.forward(request, response);
	}
}

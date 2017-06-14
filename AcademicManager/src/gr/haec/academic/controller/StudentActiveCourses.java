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
import gr.haec.academic.model.Course;
import gr.haec.academic.model.Person;

@WebServlet(urlPatterns = { "/StudentActiveCourses" })

public class StudentActiveCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CourseDao c= new CourseDao();
		HttpSession session = request.getSession();
		Person p=(Person)session.getAttribute("person");
		List<Course> list = c.getStudentCourses(p.getPersonID());
		request.setAttribute("StudentActiveCourses",list);
		RequestDispatcher rd; 
		rd=request.getRequestDispatcher("/WEB-INF/jsp/viewstudentactivecourses.jsp");
		rd.forward(request, response);
	}
}

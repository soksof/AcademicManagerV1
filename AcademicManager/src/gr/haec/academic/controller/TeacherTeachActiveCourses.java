package gr.haec.academic.controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.haec.academic.db.PersonDao;
import gr.haec.academic.model.Teacher;

@WebServlet(urlPatterns = { "/TeacherTeachActiveCourses" })

public class TeacherTeachActiveCourses extends HttpServlet {
private static final long serialVersionUID = 7491965238817284255L;
protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request,response);
}
protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	PersonDao d= new PersonDao();
	List<Teacher> list = d.getActiveTeachers();
	request.setAttribute("teacherActiveList",list);
	RequestDispatcher rd; 
	rd=request.getRequestDispatcher("/WEB-INF/jsp/viewteacheractivecourses.jsp");
	rd.forward(request, response);
}
}


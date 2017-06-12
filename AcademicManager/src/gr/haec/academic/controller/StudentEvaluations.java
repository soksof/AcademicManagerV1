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

import gr.haec.academic.db.PersonDao;
import gr.haec.academic.model.Person;
import gr.haec.academic.model.Student;

@WebServlet(urlPatterns = { "/StudentEvaluations" })

public class StudentEvaluations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
		Person p=(Person)session.getAttribute("person");
		PersonDao c= new PersonDao();
		List<Student> list=c.getStudentEvaluations(1282);
		//List<Student> list=c.getStudentEvaluations(p.getPersonID());
		request.setAttribute("StudentEvaluations",list);
		RequestDispatcher rd; 
		rd=request.getRequestDispatcher("/WEB-INF/jsp/viewstudentevaluation.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
	}
}

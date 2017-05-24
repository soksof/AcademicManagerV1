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
import gr.haec.academic.model.Person;

@WebServlet(urlPatterns = { "/StudentList" }) 
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
	}
	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		PersonDao d=new PersonDao();
		List<Person>list=d.getAllStudents();
		request.setAttribute("studentlist",list);
		rd = request.getRequestDispatcher("/WEB-INF/jsp/studentlist.jsp");
		rd.forward(request, response);
	}
}


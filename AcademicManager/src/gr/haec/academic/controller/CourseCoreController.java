package gr.haec.academic.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.haec.academic.db.CourseDao;
import gr.haec.academic.db.PersonDao;
import gr.haec.academic.model.Course;
import gr.haec.academic.model.Person;

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
		case "add":
			addCourseCore(request, response);
			break;
	
		}
	}

	/**
	 * Process POST request
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sCid=request.getParameter("courseID");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/home_secr.jsp");
		if(sCid!=null){
			int ccid=Integer.parseInt(sCid);
			this.updateCourseCore(request, response);
		}
		else{
			boolean res=this.insertCourseCore(request, response);
			//if(res==false)
			if(!res){
				PrintWriter out=response.getWriter();
				out.println("<script language='javascript' type='text/javascript'>");
				out.println("alert(\"The course core code alread exists! Please select a different one.\")");
				out.println("</script>");
				rd.include(request, response);
			}
			else{
				PrintWriter out=response.getWriter();
				out.println("<script language='javascript' type='text/javascript'>");
				out.println("alert(\"The course core has been added to the database.\")");
				out.println("</script>");
				rd.include(request, response);
			}
		}
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
	private boolean insertCourseCore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String ccname=request.getParameter("courseCore");
		String cctitle=request.getParameter("title");
		String ccdescr=request.getParameter("description");
		String field=request.getParameter("field");
		String prereq=request.getParameter("prereq");
		CourseDao cd=new CourseDao();
		return cd.insertCourseCore(ccname, cctitle, ccdescr, field, prereq);
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
	/**
	 * method to insert a new course core
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addCourseCore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd=null;
		rd = request.getRequestDispatcher("/WEB-INF/jsp/addcoursecore.jsp");
		rd.forward(request, response);
	}
}

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

	@WebServlet(urlPatterns = { "/ViewCourse" }) 
	
	public class ViewCourse extends HttpServlet {
		private static final long serialVersionUID = 1L;
		/**
		 * 
		 */
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {

			RequestDispatcher rd=null;
			CourseDao cd=new CourseDao();
			Course c=cd.getCourseID(Integer.parseInt(request.getParameter("courseID")));
			request.setAttribute("courseq", c);
			if (c!=null)
				rd = request.getRequestDispatcher("/WEB-INF/jsp/viewcourse.jsp");
			rd.forward(request, response);
		}
		/**
		 * 
		 */
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			this.doGet(request,response);
		}
	}


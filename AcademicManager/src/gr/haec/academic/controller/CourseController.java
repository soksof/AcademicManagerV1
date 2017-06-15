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

	@WebServlet(urlPatterns = { "/course" }) 
	
	public class CourseController extends HttpServlet {
		private static final long serialVersionUID = 1L;
		/**
		 * Process GET request
		 */
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			String action = request.getParameter("action");
			switch(action){
			case "view":
				viewCourse(request, response);
				break;
			case "update":
				updateCourse(request, response);
				break;
			case "edit":
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
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			this.doGet(request,response);
		}
		/**
		 * method to view the information for a course
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		private void viewCourse(HttpServletRequest request,
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
		 * method to update the information for a course
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		private void updateCourse(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			
		}
	}


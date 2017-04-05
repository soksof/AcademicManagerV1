package gr.haec.academic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentView extends HttpServlet{
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		out.println("<script type='text/javascript'>");
		out.println("alert(\"Error Password or Username\")");
		out.println("</script>");
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("welcome "+request.getAttribute("personID"));
		out.println("</BODY>");
		out.println("</HTML>");
	}
	
	
}

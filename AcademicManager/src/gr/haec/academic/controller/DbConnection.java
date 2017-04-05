package gr.haec.academic.controller;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private java.sql.Connection conn;

	public DbConnection(String a, String b, String c){
	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");
	    	  conn = DriverManager.getConnection(a,b,c);
	      } catch (ClassNotFoundException e1) {
	    	  e1.printStackTrace();
	      }catch (SQLException e) {
	    	  e.printStackTrace();
	      }
	}
	/**
	 * Getter for the java.sql.Connection instance
	 * @return The instantiated java sql connection
	 */
	public java.sql.Connection getConnection(){
		return conn;
	}
}
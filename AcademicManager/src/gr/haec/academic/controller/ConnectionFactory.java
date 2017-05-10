package gr.haec.academic.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory{

	protected ConnectionFactory(){
	}
	/**
	 * Returns the connection to the database
	 * @return
	 */
	public static Connection getConnection(){
		DataSource ds;
		Connection conn = null;

		try {
			Context ctx=new InitialContext();
			Context envContext = (Context) ctx.lookup("java:comp/env");
			ds=(DataSource)envContext.lookup("jdbc/AcademicManagerDB");
			conn=ds.getConnection();
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
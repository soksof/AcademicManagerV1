package gr.haec.academic.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
	private DataSource ds;
	private static Connection conn;
	private static ConnectionFactory instance;

	protected ConnectionFactory(){
		try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("jdbc/AcademicManagerDB");
			conn=ds.getConnection();
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Returns an instance of the ConnectionFactory
	 * @return the single ConnectionFactory instance
	 * @throws SQLException
	 */
	public static ConnectionFactory getInstance(){
		if(instance==null)
			instance=new ConnectionFactory();
		return instance;
	}
	/**
	 * Returns the connection to the database
	 * @return
	 */
	public static Connection getConnection(){
		return getInstance().conn;
	}
}
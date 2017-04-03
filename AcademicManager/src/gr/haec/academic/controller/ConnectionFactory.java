package gr.haec.academic.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class ConnectionFactory {
	@Resource(name="jdbc/AcademicManagerDB")
	private DataSource ds;
	private static Connection conn;
	private static ConnectionFactory instance;

	protected ConnectionFactory(){
		try {
			conn=ds.getConnection();
		} catch (SQLException e) {
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
	public static Connection getConnetion(){
		return getInstance().conn;
	}
}
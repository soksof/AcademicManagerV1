package gr.haec.academic.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Check login credentials of user from database
 * @author instructor
 *
 */
public class AuthenticateUser{
	/**
	 * Authenticates the user over the database
	 * @param username The username the user has provided
	 * @param password The password the user has provided
	 * @return The personID from the database if authentication is successfull, else returns -1
	 */
	public int authenticate(String username, String password) {
		//Connection conn=ConnectionFactory.getConnection();
		DbConnection conn = new DbConnection("jdbc:mysql://localhost/academicmanagerdb", "root", "");
		try {
			PreparedStatement stm=conn.getConnection().prepareStatement("SELECT personID from person where username=? AND password=?");
			stm.setString(1, username);
			stm.setString(2, password);
			ResultSet rs=stm.executeQuery();

			while(rs.next()){
				return rs.getInt("personID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
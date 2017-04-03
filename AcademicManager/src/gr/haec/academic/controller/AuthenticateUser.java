package gr.haec.academic.controller;

import java.sql.Connection;

/**
 * Check login credentials of user from database
 * @author instructor
 *
 */
public class AuthenticateUser{
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public int authenticate(String username, String password) {
		Connection conn=ConnectionFactory.getConnetion();

		return -1;
	}

}

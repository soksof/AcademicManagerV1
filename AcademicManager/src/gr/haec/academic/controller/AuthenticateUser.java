package gr.haec.academic.controller;

import gr.haec.academic.model.Person;
import gr.haec.academic.model.Role;
import gr.haec.academic.model.Sex;

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
	public Person authenticate(String username, String password) {
		Connection conn=ConnectionFactory.getConnection();
		try {
			PreparedStatement stm=conn.prepareStatement("SELECT * from person where username=? AND password=?");
			stm.setString(1, username);
			stm.setString(2, password);
			ResultSet rs=stm.executeQuery();
 
			while(rs.next()){
				Person newPerson=new Person(rs.getInt("personID"),rs.getString("name"),rs.getString("surname"),rs.getString("email"),rs.getString("phone"),Sex.valueOf(rs.getString("sex")),rs.getString("address"),rs.getDate("dob"),rs.getString("username"),rs.getString("taxNumber"),rs.getString("iban"), Role.valueOf(rs.getString("role")));
				return newPerson;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
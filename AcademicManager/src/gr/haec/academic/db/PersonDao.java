package gr.haec.academic.db;

import gr.haec.academic.model.Person;
import gr.haec.academic.model.Role;
import gr.haec.academic.model.Sex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * sql queries regarding the person data taking
 * 
 * @author vassilis
 *
 */
public class PersonDao {
	/**
	 * Authenticates the user over the database
	 * 
	 * @param username
	 *            The username the user has provided
	 * @param password
	 *            The password the user has provided
	 * @return The person instance from the database if authentication is
	 *         successfull, else returns null
	 */
	public Person authenticate(String username, String password) {
		Connection conn = ConnectionFactory.getConnection();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * from person where username=? AND password=?");
			stm.setString(1, username);
			stm.setString(2, password);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Person newPerson = new Person(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")));
				return newPerson;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Returns a person with a given ID
	 * 
	 * @param id
	 *            The person id
	 * @return The person instance from the database if authentication is
	 *         successfull, else returns null
	 */
	public Person getPersonID(int id) {
		Connection conn = ConnectionFactory.getConnection();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * from person where personID=?");
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Person newPerson = new Person(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")));
				return newPerson;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Returns all people from the database that are students
	 * 
	 * @return A List with all the students (if none the list will be empty)
	 */
	public List<Person> getAllStudents() {
		Connection conn = ConnectionFactory.getConnection();
		List<Person> students = new ArrayList<Person>();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * from person where role='student'");
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				Person newPerson = new Person(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")));
				students.add(newPerson);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

}
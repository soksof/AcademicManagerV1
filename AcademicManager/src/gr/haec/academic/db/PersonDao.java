package gr.haec.academic.db;

import gr.haec.academic.model.Field;
import gr.haec.academic.model.Person;
import gr.haec.academic.model.Role;
import gr.haec.academic.model.Sex;
import gr.haec.academic.model.Student;
import gr.haec.academic.model.Teacher;

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
	
	/**
	 * Returns all people from the database that are teachers
	 * 
	 * @return A List with all the teachers (if none the list will be empty)
	 */
	
	public List<Teacher> getAllTeachers() {
		Connection conn = ConnectionFactory.getConnection();
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * from person where role='teacher'");
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				Teacher newTeacher = new Teacher (rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),rs.getString("cv"),Field.valueOf(rs.getString("field")));
				teachers.add(newTeacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachers;
	}
	
	
	/**
	 * Returns a Teacher with a given ID
	 * 
	 * @param id
	 *  The person id
	 * @return The Teacher instance from the database with given ID, else returns null
	 */
	public Teacher getTeacher(int id) {
		
		Connection conn = ConnectionFactory.getConnection();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM person WHERE personID=? AND role='teacher'");
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Teacher newTeacher = new Teacher(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")));
				return newTeacher;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Returns all students from the database with given name as name or surname
	 * @param name - given name
	 * @return A List with all the students with given name(if none the list will be empty)
	 */
	public List<Person> getStudentsByName(String name) {
		Connection conn = ConnectionFactory.getConnection();
		List<Person> students = new ArrayList<Person>();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM person WHERE role='student' AND (name=? OR surname=?)");
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
	
	/**
	 * Returns all students from the database that are currently registered to an active course
	 * 
	 * @return A List with all the students that are currently registered to an active course (if none the list will be empty)
	 *@author Stella
	 */
	public List<Person> getActiveStudents(){
		Connection conn = ConnectionFactory.getConnection();
		List<Person> students = new ArrayList<Person>();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM person WHERE personID IN (SELECT DISTINCT personID FROM person JOIN course WHERE status='active' AND role='student'");
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
	
	/**
	 * Returns all teachers that have applied to teach a course (any course)
	 * 
	 * @return A List with all the teachers that have applied to teach any course (if none the list will be empty)
	 *@author Stella
	 */
	public List<Object[]> getApplicantCourseTeachers(){
		Connection conn = ConnectionFactory.getConnection();
		List<Object[]> teachers = new ArrayList<Object[]>();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM person inner join teacher on teacher.teacherID=person.personID inner join courseteacherapplication on courseteacherapplication.teacherID=teacher.teacherID");
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				Teacher newTeacher = new Teacher (rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),rs.getString("cv"),Field.valueOf(rs.getString("field")));
				Object[] ret=new Object[2];
				ret[0]=newTeacher;
				ret[1]=rs.getDate("applicationDate");
				teachers.add(ret);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachers;
		
	}
	
	/**
	 * Returns all people that have applied to register as teachers.
	 * 
	 * @return A List with all people that have applied to register as teachers (if none the list will be empty)
	 *@author Stella
	 */
	public List<Teacher> getApplicantTeachers(){
		Connection conn = ConnectionFactory.getConnection();
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM person JOIN teacher WHERE personID=teacherID AND status='Teacher Applicant'");
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				Teacher newTeacher = new Teacher (rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),rs.getString("cv"),Field.valueOf(rs.getString("field")));
				teachers.add(newTeacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachers;
	}

	/**
	 * Returns a Student with a given ID
	 * 
	 * @param id
	 *  The person id
	 * @return The Student instance from the database with given ID, else returns null
	 */
		public Student getStudent(int id) {
		
		Connection conn = ConnectionFactory.getConnection();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM person WHERE personID=? AND role='student'");
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
	
			while (rs.next()) {
				Student newStudent = new Student(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")));
				return newStudent;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
		
		/**
		 * Returns all teachers from the database with given name as name or surname
		 * @param name - given name
		 * @return A List with all the teachers with given name(if none the list will be empty)
		 */
		public List<Teacher> getTeachersByName(String name) {
			Connection conn = ConnectionFactory.getConnection();
			List<Teacher> teachers = new ArrayList<Teacher>();
			try {
				PreparedStatement stm = conn.prepareStatement("SELECT * FROM person WHERE role='teacher' AND (name=? OR surname=?)");
				ResultSet rs = stm.executeQuery();
				
				while (rs.next()) {
					Teacher newTeacher = new Teacher (rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
							rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
							rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
							rs.getString("iban"), Role.valueOf(rs.getString("role")),rs.getString("cv"),Field.valueOf(rs.getString("field")));
					teachers.add(newTeacher);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return teachers;
		}
		
		/**
		 * Returns all teachers from the database that teach the course with id courseID
		 * @param courseID
		 * @return A List with all the teachers of the course with id courseID (if none the list will be empty)
		 */
		public List<Teacher> getCourseTeacher(int courseID){
			Connection conn = ConnectionFactory.getConnection();
			List<Teacher> teachers = new ArrayList<Teacher>();
			try {
				PreparedStatement stm = conn.prepareStatement("SELECT * FROM person JOIN courseteacher WHERE personID=teacherID AND courseID=?");
				ResultSet rs = stm.executeQuery();
				
				while (rs.next()) {
					Teacher newTeacher = new Teacher (rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
							rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
							rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
							rs.getString("iban"), Role.valueOf(rs.getString("role")),rs.getString("cv"),Field.valueOf(rs.getString("field")));
					teachers.add(newTeacher);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return teachers;
		}
		
		/**
		 * Returns all teachers from the database that are currently teaching an active course
		 * 
		 * @return A List with all the teachers that are currently teaching an active course (if none the list will be empty)
		 *@author Stella
		 */
		public List<Teacher> getActiveTeachers(){
			Connection conn = ConnectionFactory.getConnection();
			List<Teacher> teachers = new ArrayList<Teacher>();
			try {
				PreparedStatement stm = conn.prepareStatement("SELECT * FROM person inner join teacher on teacher.teacherID=person.personID inner join courseteacher on courseteacher.teacherID=teacher.teacherID inner join course on course.courseID=courseteacher.courseID where course.status='active' and person.role='teacher'");
				ResultSet rs = stm.executeQuery();
				
				while (rs.next()) {
					Teacher newTeacher = new Teacher (rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
							rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
							rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
							rs.getString("iban"), Role.valueOf(rs.getString("role")),rs.getString("cv"),Field.valueOf(rs.getString("field")));
					teachers.add(newTeacher);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return teachers;
		}
		
		/**
		 * Returns all course teachers.
		 * 
		 * @return A List with all teachers that teach a course (if none the list will be empty)
		 *@author Stella
		 */
		public List<Teacher> getCourseTeachers(){
			Connection conn = ConnectionFactory.getConnection();
			List<Teacher> teachers = new ArrayList<Teacher>();
			try {
				PreparedStatement stm = conn.prepareStatement("SELECT * FROM person JOIN teacher WHERE personID=teacherID AND status='Course Teacher'");
				ResultSet rs = stm.executeQuery();
				
				while (rs.next()) {
					Teacher newTeacher = new Teacher (rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
							rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
							rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
							rs.getString("iban"), Role.valueOf(rs.getString("role")),rs.getString("cv"),Field.valueOf(rs.getString("field")));
					teachers.add(newTeacher);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return teachers;
		}
		/**
		 * find all the teachers that teach a course
		 * @return a list with the teachers that teach a course 
		 */
		public List<Object[]> getCourseTeacher() {
			Connection conn = ConnectionFactory.getConnection();
			List<Object[]> courseTeacher = new ArrayList<Object[]>();
			try {
				PreparedStatement stm = conn.prepareStatement("select * from course inner join coursecore on coursecore.idcourseCore=course.idCourseCore inner join courseteacher on courseteacher.courseID=course.courseID inner join teacher on teacher.teacherID=courseteacher.teacherID inner join person on person.personID=teacher.teacherID");
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					Teacher newCourseTeacher = new Teacher(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"), 
							rs.getString("email"), rs.getString("phone"),Sex.valueOf(rs.getString("sex")),rs.getString("address"), 
							rs.getDate("dob"),rs.getString("username"),rs.getString("password"),rs.getString("taxNumber"),rs.getString("iban"),
							Role.valueOf(rs.getString("role")),rs.getString("cv"),Field.valueOf(rs.getString("field")));
					String courseTitle=rs.getString("title");
					Object[] ret=new Object[2];
					ret[0]=newCourseTeacher;
					ret[1]=courseTitle;
					courseTeacher.add(ret);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return courseTeacher;
		}
		/**
		 * 
		 * @return
		 */
		public List<Student> getApplicantStudent() {
			// TODO Auto-generated method stub
			Connection conn = ConnectionFactory.getConnection();
			List<Student> students = new ArrayList<Student>();
			try {
				PreparedStatement stm = conn.prepareStatement("SELECT * FROM person where role = 'student' JOIN courseapplication");
				ResultSet rs = stm.executeQuery();
				
				while (rs.next()) {
					Student newStudent = new Student (rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
							rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
							rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
							rs.getString("iban"), Role.valueOf(rs.getString("role")),Field.valueOf(rs.getString("field"))
							,rs.getInt("courseID"),rs.getDate("applicationDate"));
					students.add(newStudent);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return students;
			

			return null;
		}
}
package gr.haec.academic.db;

import gr.haec.academic.model.Field;
import gr.haec.academic.model.Person;
import gr.haec.academic.model.Role;
import gr.haec.academic.model.Sex;
import gr.haec.academic.model.Status;
import gr.haec.academic.model.Student;
import gr.haec.academic.model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
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
				Teacher newTeacher = new Teacher(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),Status.getValue(rs.getString("status")), rs.getString("cv"),
						Field.valueOf(rs.getString("field")));
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
	 *            The person id
	 * @return The Teacher instance from the database with given ID, else
	 *         returns null
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
	 * 
	 * @param name
	 *            - given name
	 * @return A List with all the students with given name(if none the list
	 *         will be empty)
	 */
	public List<Person> getStudentsByName(String name) {
		Connection conn = ConnectionFactory.getConnection();
		List<Person> students = new ArrayList<Person>();
		try {
			PreparedStatement stm = conn
					.prepareStatement("SELECT * FROM person WHERE role='student' AND (name=? OR surname=?)");
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
	 * Returns all students from the database that are currently registered to
	 * an active course
	 * 
	 * @return A List with all the students that are currently registered to an
	 *         active course (if none the list will be empty)
	 * @author Stella
	 */
	public List<Person> getActiveStudents() {
		Connection conn = ConnectionFactory.getConnection();
		List<Person> students = new ArrayList<Person>();
		try {
			PreparedStatement stm = conn.prepareStatement(
					"SELECT * FROM person WHERE personID IN (SELECT DISTINCT personID FROM person JOIN course WHERE status='active' AND role='student'");
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
	 * @return A List with all the teachers that have applied to teach any
	 *         course (if none the list will be empty)
	 * @author Stella
	 */
	public List<Object[]> getApplicantCourseTeachers() {
		Connection conn = ConnectionFactory.getConnection();
		List<Object[]> teachers = new ArrayList<Object[]>();
		try {
			PreparedStatement stm = conn.prepareStatement(
					"SELECT * FROM person inner join teacher on teacher.teacherID=person.personID inner join courseteacherapplication on courseteacherapplication.teacherID=teacher.teacherID");
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Teacher newTeacher = new Teacher(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),Status.getValue(rs.getString("status")), rs.getString("cv"),
						Field.valueOf(rs.getString("field")));
				Object[] ret = new Object[2];
				ret[0] = newTeacher;
				ret[1] = rs.getDate("applicationDate");
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
	 * @return A List with all people that have applied to register as teachers
	 *         (if none the list will be empty)
	 * @author Stella
	 */
	public List<Teacher> getApplicantTeachers() {
		Connection conn = ConnectionFactory.getConnection();
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			PreparedStatement stm = conn.prepareStatement(
					"SELECT * FROM person JOIN teacher WHERE personID=teacherID AND status='Teacher Applicant'");
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Teacher newTeacher = new Teacher(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),Status.getValue(rs.getString("status")), rs.getString("cv"),
						Field.valueOf(rs.getString("field")));
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
	 *            The person id
	 * @return The Student instance from the database with given ID, else
	 *         returns null
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
	 * 
	 * @param name
	 *            - given name
	 * @return A List with all the teachers with given name(if none the list
	 *         will be empty)
	 */
	public List<Teacher> getTeachersByName(String name) {
		Connection conn = ConnectionFactory.getConnection();
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			PreparedStatement stm = conn
					.prepareStatement("SELECT * FROM person WHERE role='teacher' AND (name=? OR surname=?)");
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Teacher newTeacher = new Teacher(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),Status.getValue(rs.getString("status")), rs.getString("cv"),
						Field.valueOf(rs.getString("field")));
				teachers.add(newTeacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachers;
	}

	/**
	 * Returns all teachers from the database that teach the course with id
	 * courseID
	 * 
	 * @param courseID
	 * @return A List with all the teachers of the course with id courseID (if
	 *         none the list will be empty)
	 */
	public List<Teacher> getCourseTeacher(int courseID) {
		Connection conn = ConnectionFactory.getConnection();
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			PreparedStatement stm = conn.prepareStatement(
					"SELECT * FROM person JOIN courseteacher WHERE personID=teacherID AND courseID=?");
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Teacher newTeacher = new Teacher(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),Status.getValue(rs.getString("status")), rs.getString("cv"),
						Field.valueOf(rs.getString("field")));
				teachers.add(newTeacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachers;
	}

	/**
	 * Returns all teachers from the database that are currently teaching an
	 * active course
	 * 
	 * @return A List with all the teachers that are currently teaching an
	 *         active course (if none the list will be empty)
	 * @author Stella
	 */
	public List<Teacher> getActiveTeachers() {
		Connection conn = ConnectionFactory.getConnection();
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			PreparedStatement stm = conn.prepareStatement(
					"SELECT * FROM person inner join teacher on teacher.teacherID=person.personID inner join courseteacher on courseteacher.teacherID=teacher.teacherID inner join course on course.courseID=courseteacher.courseID where course.status='active' and person.role='teacher'");
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Teacher newTeacher = new Teacher(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),Status.getValue(rs.getString("status")), rs.getString("cv"),
						Field.valueOf(rs.getString("field")));
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
	 * @return A List with all teachers that teach a course (if none the list
	 *         will be empty)
	 * @author Stella
	 */
	public List<Teacher> getCourseTeachers() {
		Connection conn = ConnectionFactory.getConnection();
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			PreparedStatement stm = conn.prepareStatement(
					"SELECT * FROM person JOIN teacher WHERE personID=teacherID AND status='Course Teacher'");
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Teacher newTeacher = new Teacher(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),Status.getValue(rs.getString("status")), rs.getString("cv"),
						Field.valueOf(rs.getString("field")));
				teachers.add(newTeacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachers;
	}

	/**
	 * find all the teachers that teach a course
	 * 
	 * @return a list with the teachers that teach a course
	 */
	public List<Object[]> getPastCourseTeacher(int personID) {
		Connection conn = ConnectionFactory.getConnection();
		List<Object[]> pastCourseTeacher = new ArrayList<Object[]>();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM person INNER JOIN courseteacher on courseteacher.teacherID=person.personID INNER JOIN course on course.courseID=courseteacher.courseID INNER JOIN coursecore ON coursecore.idcourseCore=course.idCourseCore WHERE personID=? AND course.status='complete'");
			stm.setInt(1, personID);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Teacher newCourseTeacher = new Teacher(rs.getInt("personID"), rs.getString("name"),
						rs.getString("surname"), rs.getString("email"), rs.getString("phone"),
						Sex.valueOf(rs.getString("sex")), rs.getString("address"), rs.getDate("dob"),
						rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")));
				String courseTitle = rs.getString("title");
				int courseID = rs.getInt("courseID");
				Date startDate= rs.getDate("startDate");
				Date endDate= rs.getDate("endDate");
				String courseCore = rs.getString("courseCore");
				Object[] ret = new Object[6];
				ret[0] = newCourseTeacher;
				ret[1] = courseTitle;
				ret[2] = courseID;
				ret[3] = courseCore;
				ret[4] = startDate;
				ret[5] = endDate;
				pastCourseTeacher.add(ret);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pastCourseTeacher;
	}

	/**
	 * Find all students that have applied for a course.
	 * @return
	 */
	public List<Object[]> getApplicantStudent() {
		Connection conn = ConnectionFactory.getConnection();
		List<Object[]> Applicantstudents = new ArrayList<Object[]>();
		try {
			PreparedStatement stm = conn
					.prepareStatement("SELECT * FROM person INNER JOIN courseapplication ON courseapplication.studentid=person.personid INNER JOIN course on course.courseID=courseapplication.courseID INNER JOIN coursecore on coursecore.idcourseCore=course.idCourseCore ");
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Student newStudent = new Student(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),rs.getDate("applicationDate"),rs.getInt("studentID"));
				int courseID = rs.getInt("courseID");
				String courseTitle=rs.getString("title");
				Object[] obj = new Object[3];
				obj[0] = newStudent;
				obj[1] = courseID;
				obj[2] = courseTitle;
				Applicantstudents.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Applicantstudents;
	}
	
	/**
	 * Returns all teachers that have applied to teach the course with id
	 * courseID
	 * 
	 * @param courseID
	 * @return A List with all the teachers hat have applied to teach the course with id courseID (if
	 *         none the list will be empty)
	 *         @author Stella
	 */
	public List<Teacher> getCourseApplicantTeachers(int courseID) {
		Connection conn = ConnectionFactory.getConnection();
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			PreparedStatement stm = conn.prepareStatement(
					"SELECT * FROM person INNER JOIN courseteacherapplication c WHERE personID=c.teacherID AND courseID=?");
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Teacher newTeacher = new Teacher(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")), rs.getString("cv"),
						Field.valueOf(rs.getString("field")),Status.getValue(rs.getString("status")),rs.getDate("applicationDate"));
				teachers.add(newTeacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachers;
	}
	
	/**
	 * Searching for the completed courses evaluation for a student for a certain course.
	 * @param personID
	 * @param courseID
	 * @return
	 */
	
	public List<Student> getStudentEvaluation(int personID, int courseID) {
		Connection conn = ConnectionFactory.getConnection();
		List<Student> studentEvaluations = new ArrayList<Student>();
		try {
			PreparedStatement stm = conn.prepareStatement(
					"SELECT * FROM person " 
			                + "inner join coursestudent on coursestudent.studentID=person.personID "
							+ "inner join course on course.courseID=coursestudent.courseID "
							+ "inner join coursecore on coursecore.idcourseCore=course.idCourseCore "
							+ "where personID=? AND course.courseID=? AND status='complete'");
			stm.setInt(1, personID);
			stm.setInt(2, courseID);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Student newStudent = new Student(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),rs.getString("evaluation"),rs.getFloat("finalGrade"));
				studentEvaluations.add(newStudent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentEvaluations;
}
	/**
	 * Searching for the completed courses evaluation for a student
	 * @param personID
	 * @return a  list of completed courses evaluation for student with id personID 
	 */
	public List<Object[]>getCompleteStudentCourses(int personID) {
		Connection conn = ConnectionFactory.getConnection();
		List<Object[]> studentComplete = new ArrayList<Object[]>();
		try {
			PreparedStatement stm = conn.prepareStatement(
					"SELECT * FROM person " 
			                + "inner join coursestudent on coursestudent.studentID=person.personID "
							+ "inner join course on course.courseID=coursestudent.courseID "
							+ "inner join coursecore on coursecore.idcourseCore=course.idCourseCore "
							+ "where personID=? AND status='complete'");
			stm.setInt(1, personID);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Student newStudent = new Student(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),rs.getString("evaluation"),
						rs.getFloat("finalGrade"));
				String courseClassroom = rs.getString("classroom");
				String courseTitle = rs.getString("title");
				String courseStartDate = rs.getString("startDate");
				String courseEndDate = rs.getString("endDate");
				int courseCourseID= rs.getInt("courseID");
				Object[] obj = new Object[6];
				obj[0] = newStudent;
				obj[1] = courseClassroom;
				obj[2] = courseTitle;
				obj[3] = courseCourseID;
				obj[4] = courseStartDate;
				obj[5] = courseEndDate;
				
				studentComplete.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentComplete;
}
/**
 * Updating the persons personal informations.
 * @param name
 * @param surname
 * @param email
 * @param phone
 * @param sex
 * @param address
 * @param dob
 * @param taxnumber
 * @param iban
 * @param personID
 * @return
 */
	public Person updatePerson(String name,String surname,String email,String phone,String sex,String address,Date dob,String taxnumber,String iban,String personID) {
		Connection conn = ConnectionFactory.getConnection();
		Person p=null;
		try {
			PreparedStatement stm = conn.prepareStatement("UPDATE person SET name=?,surname=?,email=?,phone=?,sex=?,address=?,dob=?,taxnumber=?,iban=? WHERE personID=?");
			stm.setString(1,name);
			stm.setString(2,surname);
			stm.setString(3,email);
			stm.setString(4,phone);
			stm.setString(5,sex);
			stm.setString(6,address);
			stm.setDate(7,dob);
			stm.setString(8,taxnumber);
			stm.setString(9,iban);
			stm.setString(10,personID);
			stm.executeUpdate();
			p=getPersonID(Integer.parseInt(personID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	/**
	 * Searching for all the teachers evaluation from the students.
	 * @return
	 */
	public List<Object[]> getTeachersEvaluation() {
		Connection conn = ConnectionFactory.getConnection();
		List<Object[]> teachersEvaluation= new ArrayList<Object[]>();
		try {
			PreparedStatement stm = conn.prepareStatement(
			"SELECT* FROM coursecore inner join course on course.idCourseCore=courseCore.idcourseCore inner join evaluationteachers on evaluationteachers.courseID=course.courseID inner join person on person.personID=evaluationteachers.teacherID");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Teacher newTeacher = new Teacher(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),rs.getString("evaluation"));
				String courseTitle = rs.getString("title");
				int studentID = rs.getInt("studentID");
				int courseID= rs.getInt("courseID");
				Object[] obj = new Object[4];
				obj[0] = newTeacher;
				obj[1] = studentID;
				obj[2] = courseTitle;
				obj[3] = courseID;
				teachersEvaluation.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachersEvaluation;
}
/**
 * searching for the evaluations of all the students.
 * @return a list with the evaluations of all students with their grades for the completed courses.
 */
	public List<Object[]> getAllStudentsEvaluation() {
		Connection conn = ConnectionFactory.getConnection();
		List<Object[]> allStudentsEvaluation= new ArrayList<Object[]>();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT* FROM person INNER JOIN coursestudent on coursestudent.studentID=person.personID INNER JOIN course on course.courseID=coursestudent.courseID INNER JOIN coursecore on coursecore.idcourseCore=course.idCourseCore WHERE status='complete'");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Student newStudent = new Student(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),rs.getString("evaluation"),
						rs.getFloat("finalGrade"));
				String courseTitle = rs.getString("title");
				int courseID= rs.getInt("courseID");
				float assignmnetGrades=rs.getFloat("assignmentGrades");
				Object[] obj = new Object[4];
				obj[0] = newStudent;
				obj[1] = courseTitle;
				obj[2] = courseID;
				obj[3]= assignmnetGrades;
				allStudentsEvaluation.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allStudentsEvaluation;
}
/**
 * searching for all the payments the students have done.
 * @return alist with the courses and the payment status of them for each student.
 */
	public List<Object[]> getPaymentStudent() {
		Connection conn = ConnectionFactory.getConnection();
		List<Object[]>PaymentStudent = new ArrayList<Object[]>();
		try {
			PreparedStatement stm = conn
					.prepareStatement("SELECT* FROM person INNER JOIN coursestudent on coursestudent.studentID=person.personID INNER JOIN course on course.courseID=coursestudent.courseID INNER JOIN coursecore on coursecore.idcourseCore=course.idCourseCore");
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Student newStudent = new Student(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),rs.getInt("studentID"),rs.getString("payment"));
				int courseID = rs.getInt("courseID");
				String courseTitle=rs.getString("title");
				Object[] obj = new Object[3];
				obj[0] = newStudent;
				obj[1] = courseID;
				obj[2] = courseTitle;
				PaymentStudent.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return PaymentStudent;
	}
	/**
	 * searching for all the payments of a student thai have not been paid.
	 * @param personID
	 * @return a list with courses that have not been paid.
	 */
	public List<Object[]> getPendingPayment(int personID) {
		Connection conn = ConnectionFactory.getConnection();
		List<Object[]>PendingPayments = new ArrayList<Object[]>();
		try {
			PreparedStatement stm = conn
					.prepareStatement("SELECT* FROM person INNER JOIN coursestudent on coursestudent.studentID=person.personID INNER JOIN course on course.courseID=coursestudent.courseID INNER JOIN coursecore on coursecore.idcourseCore=course.idCourseCore WHERE personID=? AND payment='0'");
			stm.setInt(1, personID);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Student newStudent = new Student(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),rs.getInt("studentID"),rs.getString("payment"));
				int courseID = rs.getInt("courseID");
				int discount =rs.getInt("discount");
				int cost =rs.getInt("cost");
				String courseTitle=rs.getString("title");
				Object[] obj = new Object[5];
				obj[0] = newStudent;
				obj[1] = courseID;
				obj[2] = courseTitle;
				obj[3] = discount;
				obj[4] = cost;
				PendingPayments.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return PendingPayments;
	}

	/**
	 * searching for all the course that has been paid.
	 * @param personID
	 * @return a list of the courses that a student has paid.
	 */
	
	public List<Object[]> getHistoryPayment(int personID) {
		Connection conn = ConnectionFactory.getConnection();
		List<Object[]>historyPayments = new ArrayList<Object[]>();
		try {
			PreparedStatement stm = conn
					.prepareStatement("SELECT* FROM person INNER JOIN coursestudent on coursestudent.studentID=person.personID INNER JOIN course on course.courseID=coursestudent.courseID INNER JOIN coursecore on coursecore.idcourseCore=course.idCourseCore WHERE personID=? AND payment='1'");
			stm.setInt(1, personID);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Student newStudent = new Student(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),rs.getInt("studentID"),rs.getString("payment"));
				int courseID = rs.getInt("courseID");
				int discount =rs.getInt("discount");
				int cost =rs.getInt("cost");
				String courseTitle=rs.getString("title");
				Object[] obj = new Object[5];
				obj[0] = newStudent;
				obj[1] = courseID;
				obj[2] = courseTitle;
				obj[3] = discount;
				obj[4] = cost;
				historyPayments.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return historyPayments;
	}
	/**
	 * searching for all the students that are attending a certain course which is teaching a certain teacher.  
	 * @param teacherID
	 * @return a list for all the students that are attending a certain course which is teaching a certain teacher. 
	 */
	public List<Object[]> getCourseStudents(int personID) {
		Connection conn = ConnectionFactory.getConnection();
		List<Object[]> courseStudents = new ArrayList<Object[]>();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM person INNER JOIN coursestudent ON coursestudent.studentID=person.personID INNER JOIN courseteacher ON courseteacher.courseID=coursestudent.courseID INNER JOIN course ON course.courseID=courseteacher.courseID INNER JOIN coursecore ON coursecore.idcourseCore=course.idCourseCore WHERE teacherID=?");
			stm.setInt(1, personID);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Student newStudent = new Student(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")));
				int courseID = rs.getInt("courseID");
				int studentID = rs.getInt("studentID");
				String courseTitle=rs.getString("title");
				String courseTimeTable=rs.getString("timetable");
				Object[] obj = new Object[5];
				obj[0] = newStudent;
				obj[1] = courseID;
				obj[2] = courseTitle;
				obj[3] = courseTimeTable;
				obj[4] = studentID;
				courseStudents.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courseStudents;
	}
	/**
	 * Searching for the grades of the completed courses for all students that they are attending a certain teachers courses.
	 * @param personID
	 * @return a list of the grades of the completed courses for all students that they are attending a certain teachers courses.
	 */
	public List<Object[]> getStudentGrades(int personID) {
		Connection conn = ConnectionFactory.getConnection();
		List<Object[]> StudentGrades = new ArrayList<Object[]>();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM person INNER JOIN coursestudent ON coursestudent.studentID=person.personID INNER JOIN courseteacher ON courseteacher.courseID=coursestudent.courseID INNER JOIN course ON course.courseID=courseteacher.courseID INNER JOIN coursecore ON coursecore.idcourseCore=course.idCourseCore WHERE teacherID=? AND course.status='complete'");
			stm.setInt(1, personID);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Student newStudent = new Student(rs.getInt("personID"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"), Sex.valueOf(rs.getString("sex")),
						rs.getString("address"), rs.getDate("dob"), rs.getString("username"), rs.getString("taxNumber"),
						rs.getString("iban"), Role.valueOf(rs.getString("role")),rs.getString("evaluation"),
						rs.getFloat("finalGrade"));
				int courseID = rs.getInt("courseID");
				int studentID = rs.getInt("studentID");
				String courseTitle=rs.getString("title");
				float assignmnetGrades=rs.getFloat("assignmentGrades");
				Object[] obj = new Object[5];
				obj[0] = newStudent;
				obj[1] = courseID;
				obj[2] = courseTitle;
				obj[3] = assignmnetGrades;
				obj[4] = studentID;
				StudentGrades.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return StudentGrades;
	}
	
}
package gr.haec.academic.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.haec.academic.model.Course;
import gr.haec.academic.model.CourseCore;
import gr.haec.academic.model.CourseStatus;
import gr.haec.academic.model.Field;

/**
 * sql queries regarding the course data taking
 * 
 * @author ILIAS
 *
 */
public class CourseDao {
	/**
	 * Give all the information for a a certain course (in the constructor line
	 * 33-38 you can see exactly what information we are taking from the sql)
	 * 
	 * @param courseID
	 * @return all the informations for a certain courseID
	 */
	public Course getCourseID(int courseID) {
		Connection conn = ConnectionFactory.getConnection();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * from course where courseID=?");
			stm.setInt(1, courseID);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Course newCourse = new Course(rs.getInt("courseID"), rs.getString("title"), rs.getDate("startDate"),
						rs.getDate("endDate"), CourseStatus.valueOf(rs.getString("status")), rs.getInt("totalHours"),
						rs.getString("timetable"), rs.getString("description"), rs.getString("syllabus"),
						rs.getString("prereqCoreCourse"), rs.getInt("cost"), rs.getInt("discount"),
						rs.getString("classroom"), rs.getInt("maxStudents"), rs.getInt("minStudents"),
						rs.getInt("credits"), rs.getInt("idCourseCore"), rs.getString("courseCore"),
						Field.valueOf(rs.getString("field")));
				return newCourse;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Give all the information for a a certain course core
	 * @param courseID
	 * @return all the informations for a certain courseID
	 */
	public CourseCore getCourseCoreID(int ccID) {
		Connection conn = ConnectionFactory.getConnection();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * from coursecore where idcourseCore=?");
			stm.setInt(1, ccID);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				CourseCore newCc = new CourseCore(rs.getInt("idcourseCore"), rs.getString("courseCore"),
						rs.getString("title"), rs.getString("description"), rs.getString("prereqCoreCourse"),
						Field.valueOf(rs.getString("field")));
				return newCc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Searching for the courses that a teacher is currently teaching
	 * 
	 * @param personID
	 * @return a list with the informations of the courses that the teacher with
	 *         id personID is teaching
	 */
	public List<Course> getCourses(int personID) {
		Connection conn = ConnectionFactory.getConnection();
		List<Course> courses = new ArrayList<Course>();
		try {
			PreparedStatement stm = conn.prepareStatement(
					"SELECT * FROM person " + "inner join courseteacher on courseteacher.teacherID=person.personID "
							+ "inner join course on course.courseID=courseteacher.courseID "
							+ "inner join coursecore on coursecore.idcourseCore=course.idCourseCore "
							+ " where personID=? AND role='teacher'");
			stm.setInt(1, personID);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Course newCourse = new Course(rs.getInt("courseID"), rs.getString("title"), rs.getDate("startDate"),
						rs.getDate("endDate"), CourseStatus.valueOf(rs.getString("status")), rs.getInt("totalHours"),
						rs.getString("timetable"), rs.getString("description"), rs.getString("syllabus"),
						rs.getString("prereqCoreCourse"), rs.getInt("cost"), rs.getInt("discount"),
						rs.getString("classroom"), rs.getInt("maxStudents"), rs.getInt("minStudents"),
						rs.getInt("credits"), rs.getInt("idCourseCore"), rs.getString("courseCore"),
						Field.valueOf(rs.getString("field")));
				courses.add(newCourse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * Searching for the active courses that a student is attending this
	 * semester
	 * 
	 * @param personID
	 * @return a list of active courses that the student with id personID is
	 *         attending
	 */
	public List<Course> getStudentCourses(int personID) {
		Connection conn = ConnectionFactory.getConnection();
		List<Course> studentCourses = new ArrayList<Course>();
		try {
			PreparedStatement stm = conn.prepareStatement(
					"SELECT * FROM person " + "inner join coursestudent on coursestudent.studentID=person.personID "
							+ "inner join course on course.courseID=coursestudent.courseID "
							+ "inner join coursecore on coursecore.idcourseCore=course.idCourseCore "
							+ "where personID=? AND status='active'");
			stm.setInt(1, personID);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Course newCourse = new Course(rs.getInt("courseID"), rs.getString("title"), rs.getDate("startDate"),
						rs.getDate("endDate"), CourseStatus.valueOf(rs.getString("status")), rs.getInt("totalHours"),
						rs.getString("timetable"), rs.getString("description"), rs.getString("syllabus"),
						rs.getString("prereqCoreCourse"), rs.getInt("cost"), rs.getInt("discount"),
						rs.getString("classroom"), rs.getInt("maxStudents"), rs.getInt("minStudents"),
						rs.getInt("credits"), rs.getInt("idCourseCore"), rs.getString("courseCore"),
						Field.valueOf(rs.getString("field")));
				studentCourses.add(newCourse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentCourses;
	}

	/**
	 * Returns a list with all courses
	 * 
	 * @return a list with the informations of the courses
	 */
	public List<Course> getAllCourses() {
		Connection conn = ConnectionFactory.getConnection();
		List<Course> courses = new ArrayList<Course>();
		try {
			PreparedStatement stm = conn.prepareStatement(
					"SELECT * FROM course " + "inner join coursecore on coursecore.idcourseCore=course.idCourseCore");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Course newCourse = new Course(rs.getInt("courseID"), rs.getString("title"), rs.getDate("startDate"),
						rs.getDate("endDate"), CourseStatus.valueOf(rs.getString("status")), rs.getInt("totalHours"),
						rs.getString("timetable"), rs.getString("description"), rs.getString("syllabus"),
						rs.getString("prereqCoreCourse"), rs.getInt("cost"), rs.getInt("discount"),
						rs.getString("classroom"), rs.getInt("maxStudents"), rs.getInt("minStudents"),
						rs.getInt("credits"), rs.getInt("idCourseCore"), rs.getString("courseCore"),
						Field.valueOf(rs.getString("field")));
				courses.add(newCourse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * Returns a list with all coursecore entries
	 * 
	 * @return a list with the informations of the coursecore entries
	 */
	public List<CourseCore> getAllCourseCore() {
		Connection conn = ConnectionFactory.getConnection();
		List<CourseCore> ccs = new ArrayList<CourseCore>();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM coursecore");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				CourseCore newCc = new CourseCore(rs.getInt("idcourseCore"), rs.getString("courseCore"),
						rs.getString("title"), rs.getString("description"), rs.getString("prereqCoreCourse"),
						Field.valueOf(rs.getString("field")));
				ccs.add(newCc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ccs;
	}

	/**
	 * Method to insert a new course core in the database
	 */
	public boolean insertCourseCore(String ccname, String cctitle, String ccdescr, String field, String prereq) {
		Connection conn = ConnectionFactory.getConnection();
		try {
			PreparedStatement stm = conn
					.prepareStatement("INSERT INTO coursecore (courseCore,title,description,field,prereqCoreCourse)"
							+ "VALUES(?,?,?,?,?)");
			stm.setString(1, ccname);
			stm.setString(2, cctitle);
			stm.setString(3, ccdescr);
			stm.setString(4, field);
			stm.setString(5, prereq);
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * method to insert a new course in the data base.
	 * @param courseID
	 * @param startDate
	 * @param endDate
	 * @param status
	 * @param totalHours
	 * @param timetable
	 * @param syllabus
	 * @param cost
	 * @param discount
	 * @param classroom
	 * @param maxStudents
	 * @param minStudents
	 * @param credits
	 * @param idCourseCore
	 * @return
	 */
	public boolean addCourse(String courseID,Date startDate,Date endDate,String status,String totalHours,String timetable,
			String syllabus,String cost,String discount,String classroom,String maxStudents,String minStudents,String credits,String idCourseCore){
		Connection conn = ConnectionFactory.getConnection();
		try {
			PreparedStatement stm = conn.prepareStatement("INSERT INTO course(courseID,startDate,endDate,status,totalHours"
					+ "timetable,syllabus,cost,discount,classroom,maxStudents,minStudents,credits,idCourseCore) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stm.setString(1,courseID);
			stm.setDate(2,startDate);
			stm.setDate(3,endDate);
			stm.setString(4,status);
			stm.setString(5,totalHours);
			stm.setString(6,timetable);
			stm.setString(7,syllabus);
			stm.setString(8,cost);
			stm.setString(9,discount);
			stm.setString(10,classroom);
			stm.setString(11,maxStudents);
			stm.setString(12,minStudents);
			stm.setString(13,credits);
			stm.setString(14,idCourseCore);
		    stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
}
	
/**
 * Searching for all courses evaluations from the students
 * @return a list with all the courses evaluations 
 */
	public List<Object[]> getCourseEvaluation() {
		Connection conn = ConnectionFactory.getConnection();
		List<Object[]> coursesEvaluation = new ArrayList<Object[]>();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM person "
					+ "inner join courseevaluation on courseevaluation.studentID=person.personID "
					+ "inner join course on course.courseID=courseevaluation.courseID  "
					+ "inner join coursecore on coursecore.idcourseCore=course.idCourseCore ");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Course newCourse = new Course(rs.getInt("courseID"), rs.getString("title"),rs.getString("evaluation"),
						rs.getDate("evaluationDate"));
				String studentName=rs.getString("name");
				String studentSurname=rs.getString("surname");
				int personID=rs.getInt("personID");
				Object[] obj = new Object[4];
				obj[0] = newCourse;
				obj[1] = studentName;
				obj[2] = studentSurname;
				obj[3] = personID;
				coursesEvaluation.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coursesEvaluation;
	}	
	
}
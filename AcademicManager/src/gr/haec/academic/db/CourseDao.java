package gr.haec.academic.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.haec.academic.model.Course;
import gr.haec.academic.model.Field;
import gr.haec.academic.model.Status;

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
						rs.getDate("endDate"), Status.valueOf(rs.getString("status")), rs.getInt("totalHours"),
						rs.getString("timetable"), rs.getString("description"), rs.getString("syllabus"),
						rs.getInt("prereqCoreCourse"), rs.getInt("cost"), rs.getInt("discount"),
						rs.getString("classroom"), rs.getInt("maxStudents"), rs.getInt("minStudents"),
						rs.getInt("credits"), rs.getInt("personID"), rs.getInt("idCourseCore"),
						Field.valueOf(rs.getString("field")));
				return newCourse;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Searching for the courses that a teacher is currently teaching  
	 * @param personID
	 * @return a list with the informations of the courses that the teacher with id personID is teaching
	 */
	public List<Course> getCourses(int personID) {
		Connection conn = ConnectionFactory.getConnection();
		List<Course> courses = new ArrayList<Course>();
		try {
			PreparedStatement stm = conn.prepareStatement(
					"SELECT * FROM person " 
			                + "inner join courseteacher on courseteacher.teacherID=person.personID "
							+ "inner join course on course.courseID=courseteacher.courseID "
							+ "inner join coursecore on coursecore.idcourseCore=course.idCourseCore "
							+ " where personID=? AND role='teacher'");
			stm.setInt(1, personID);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Course newCourse = new Course(rs.getInt("courseID"), rs.getString("title"), rs.getDate("startDate"),
						rs.getDate("endDate"), Status.valueOf(rs.getString("status")), rs.getInt("totalHours"),
						rs.getString("timetable"), rs.getString("description"), rs.getString("syllabus"),
						rs.getInt("prereqCoreCourse"), rs.getInt("cost"), rs.getInt("discount"),
						rs.getString("classroom"), rs.getInt("maxStudents"), rs.getInt("minStudents"),
						rs.getInt("credits"), rs.getInt("personID"), rs.getInt("idCourseCore"),
						Field.valueOf(rs.getString("field")));
				courses.add(newCourse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * Searching for the active courses that a student is attending this semester
	 * @param personID
	 * @return a  list of active courses that the student with id personID is attending
	 */
	public List<Course> getStudentCourses(int personID) {
		Connection conn = ConnectionFactory.getConnection();
		List<Course> studentCourses = new ArrayList<Course>();
		try {
			PreparedStatement stm = conn.prepareStatement(
					"SELECT * FROM person " 
			                + "inner join coursestudent on coursestudent.studentID=person.personID "
							+ "inner join course on course.courseID=coursestudent.courseID "
							+ "inner join coursecore on coursecore.idcourseCore=course.idCourseCore "
							+ "where personID=? AND status='active'");
			stm.setInt(1, personID);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Course newCourse = new Course(rs.getInt("courseID"), rs.getString("title"), rs.getDate("startDate"),
						rs.getDate("endDate"), Status.valueOf(rs.getString("status")), rs.getInt("totalHours"),
						rs.getString("timetable"), rs.getString("description"), rs.getString("syllabus"),
						rs.getInt("prereqCoreCourse"), rs.getInt("cost"), rs.getInt("discount"),
						rs.getString("classroom"), rs.getInt("maxStudents"), rs.getInt("minStudents"),
						rs.getInt("credits"), rs.getInt("personID"), rs.getInt("idCourseCore"),
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
	 * @return a list with the informations of the courses
	 */
	public List<Course> getAllCourses() {
		Connection conn = ConnectionFactory.getConnection();
		List<Course> courses = new ArrayList<Course>();
		try {
			PreparedStatement stm = conn.prepareStatement(
					"SELECT * FROM course ");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Course newCourse = new Course(rs.getInt("courseID"), rs.getString("title"), rs.getDate("startDate"),
						rs.getDate("endDate"), Status.valueOf(rs.getString("status")), rs.getInt("totalHours"),
						rs.getString("timetable"), rs.getString("description"), rs.getString("syllabus"),
						rs.getInt("prereqCoreCourse"), rs.getInt("cost"), rs.getInt("discount"),
						rs.getString("classroom"), rs.getInt("maxStudents"), rs.getInt("minStudents"),
						rs.getInt("credits"), rs.getInt("personID"), rs.getInt("idCourseCore"),
						Field.valueOf(rs.getString("field")));
				courses.add(newCourse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}
}
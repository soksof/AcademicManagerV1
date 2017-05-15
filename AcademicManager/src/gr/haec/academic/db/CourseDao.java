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
 * @author ILIAS
 *
 */
public class CourseDao {
/**
 * 	
 * @param courseID
 * @return
 */
	public Course getCourseID(int courseID) {
		Connection conn = ConnectionFactory.getConnection();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * from course where courseID=?");
			stm.setInt(1, courseID);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Course newCourse = new Course(rs.getInt("courseID"), rs.getString("title"), rs.getDate("startDate"),
						rs.getDate("endDate"),Status.valueOf(rs.getString("status")),rs.getInt("totalHours"),rs.getString("timetable"),
						rs.getString("description"), rs.getString("syllabus"), rs.getInt("prereqCoreCourse"), rs.getInt("cost"),
						rs.getInt("discount"),rs.getString("classroom"),rs.getInt("maxStudents"),rs.getInt("minStudents"),rs.getInt("credits")
						,rs.getInt("assignmentID"),rs.getString("assignmentDescription"),rs.getDate("startDateAssignment"),rs.getDate("endDateAssignment")
						,rs.getInt("studentID"),rs.getString("evaluation"),rs.getDate("evaluationDate"),rs.getInt("idCourseCore"),Field.valueOf(rs.getString("field")));
				return newCourse;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Course> getCourses(int personID) {
		Connection conn = ConnectionFactory.getConnection();
		List<Course> courses = new ArrayList<Course>();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT courseID FROM courseteacher where teacherID=?");
			stm.setInt(1, personID);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Course newCourse = new Course(rs.getInt("courseID"), rs.getString("title"), rs.getDate("startDate"),
						rs.getDate("endDate"),Status.valueOf(rs.getString("status")),rs.getInt("totalHours"),rs.getString("timetable"),
						rs.getString("description"), rs.getString("syllabus"), rs.getInt("prereqCoreCourse"), rs.getInt("cost"),
						rs.getInt("discount"),rs.getString("classroom"),rs.getInt("maxStudents"),rs.getInt("minStudents"),rs.getInt("credits")
						,rs.getInt("assignmentID"),rs.getString("assignmentDescription"),rs.getDate("startDateAssignment"),rs.getDate("endDateAssignment")
						,rs.getInt("studentID"),rs.getString("evaluation"),rs.getDate("evaluationDate"),rs.getInt("idCourseCore"),Field.valueOf(rs.getString("field")));
				courses.add(newCourse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
}
	public List<Course> getStudentCourses(int personID) {
		Connection conn = ConnectionFactory.getConnection();
		List<Course> studentCourses = new ArrayList<Course>();
		try {
			PreparedStatement stm = conn.prepareStatement("");
			stm.setInt(1, personID);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Course newCourse = new Course(rs.getInt("courseID"), rs.getString("title"), rs.getDate("startDate"),
						rs.getDate("endDate"),Status.valueOf(rs.getString("status")),rs.getInt("totalHours"),rs.getString("timetable"),
						rs.getString("description"), rs.getString("syllabus"), rs.getInt("prereqCoreCourse"), rs.getInt("cost"),
						rs.getInt("discount"),rs.getString("classroom"),rs.getInt("maxStudents"),rs.getInt("minStudents"),rs.getInt("credits")
						,rs.getInt("assignmentID"),rs.getString("assignmentDescription"),rs.getDate("startDateAssignment"),rs.getDate("endDateAssignment")
						,rs.getInt("studentID"),rs.getString("evaluation"),rs.getDate("evaluationDate"),rs.getInt("idCourseCore"),Field.valueOf(rs.getString("field")));
				studentCourses.add(newCourse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentCourses;
}
}

package dao;

// Import Student model class
import model.Student;

// Import SQL package classes
import java.sql.*;

// Import List collection classes
import java.util.ArrayList;
import java.util.List;

// DAO = Data Access Object
// This class handles all database operations
public class StudentDAO {

	// Database URL
	// curdapp = database name
	private String jdbcURL = "jdbc:mysql://localhost:3306/curdapp";

	// MySQL username
	private String jdbcUsername = "root";

	// MySQL password
	private String jdbcPassword = "";

	// SQL query to insert student data
	private static final String INSERT_SQL = "INSERT INTO students (name, age, course) VALUES (?, ?, ?)";

	// SQL query to fetch all students
	private static final String SELECT_ALL_SQL = "SELECT * FROM students";

	// SQL query to fetch single student by id
	private static final String SELECT_BY_ID_SQL = "SELECT * FROM students WHERE id = ?";

	// SQL query to update existing student
	private static final String UPDATE_SQL = "UPDATE students SET name=?, age=?, course=? WHERE id=?";

	// SQL query to delete student by id
	private static final String DELETE_SQL = "DELETE FROM students WHERE id=?";

	// SQL query to delete ALL records
	private static final String TRUNCATE_SQL = "TRUNCATE TABLE students";

	// Create database connection
	protected Connection getConnection() throws SQLException, ClassNotFoundException {

		// Load MySQL JDBC Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Return database connection
		return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// Insert student into database
	public void insertStudent(Student student) {

		// try-with-resources automatically closes connection
		try (Connection con = getConnection();

				PreparedStatement ps = con.prepareStatement(INSERT_SQL)) {

			// Set values into SQL query
			ps.setString(1, student.getName());

			ps.setInt(2, student.getAge());

			ps.setString(3, student.getCourse());

			// Execute INSERT query
			ps.executeUpdate();

		} catch (Exception e) {

			// Print error in console
			e.printStackTrace();
		}
	}

	// Fetch all students from database
	public List<Student> selectAllStudents() {

		// Create empty list
		List<Student> list = new ArrayList<>();

		try (Connection con = getConnection();

				PreparedStatement ps = con.prepareStatement(SELECT_ALL_SQL);

				ResultSet rs = ps.executeQuery()) {

			// Loop through each database row
			while (rs.next()) {

				// Create Student object
				Student s = new Student();

				// Set values from database columns
				s.setId(rs.getInt("id"));

				s.setName(rs.getString("name"));

				s.setAge(rs.getInt("age"));

				s.setCourse(rs.getString("course"));

				// Add student to list
				list.add(s);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		// Return complete student list
		return list;
	}

	// Fetch single student using id
	public Student selectStudent(int id) {

		// Initially null
		Student student = null;

		try (Connection con = getConnection();

				PreparedStatement ps = con.prepareStatement(SELECT_BY_ID_SQL)) {

			// Set id in query
			ps.setInt(1, id);

			// Execute SELECT query
			ResultSet rs = ps.executeQuery();

			// Check if record exists
			if (rs.next()) {

				// Create Student object
				student = new Student();

				// Set values from database
				student.setId(rs.getInt("id"));

				student.setName(rs.getString("name"));

				student.setAge(rs.getInt("age"));

				student.setCourse(rs.getString("course"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		// Return student object
		return student;
	}

	// Update existing student
	public boolean updateStudent(Student student) {

		// Track update status
		boolean rowUpdated = false;

		try (Connection con = getConnection();

				PreparedStatement ps = con.prepareStatement(UPDATE_SQL)) {

			// Set updated values
			ps.setString(1, student.getName());

			ps.setInt(2, student.getAge());

			ps.setString(3, student.getCourse());

			ps.setInt(4, student.getId());

			// executeUpdate() returns affected rows
			rowUpdated = ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		// Return true if update successful
		return rowUpdated;
	}

	// Delete student using id
	public boolean deleteStudent(int id) {

		// Track delete status
		boolean rowDeleted = false;

		try (Connection con = getConnection();

				PreparedStatement ps = con.prepareStatement(DELETE_SQL)) {

			// Set student id
			ps.setInt(1, id);

			// Execute DELETE query
			rowDeleted = ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		// Return delete result
		return rowDeleted;
	}

	// Delete ALL records from students table
	public void truncateStudents() {

		try (Connection con = getConnection();

				PreparedStatement ps = con.prepareStatement(TRUNCATE_SQL)) {

			// Execute TRUNCATE query
			ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
package controller;

// Import DAO class for database operations
import dao.StudentDAO;

// Import Student model class
import model.Student;

// Servlet imports
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

// Import IOException for servlet methods
import java.io.IOException;

// Import List collection
import java.util.List;

// Map this servlet with URL pattern "/students"
// Example:
// http://localhost:8080/JDBCWithServletJSP/students
@WebServlet("/students")
public class StudentController extends HttpServlet {

	// DAO object used to interact with database
	private StudentDAO studentDAO;

	// init() runs once when servlet starts
	// Used to initialize DAO object
	public void init() {

		// Create DAO object
		studentDAO = new StudentDAO();
	}

	// Handles all GET requests
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get action parameter from URL
		// Example:
		// students?action=edit
		String action = request.getParameter("action");

		// If no action is provided
		// set empty string
		if (action == null)
			action = "";

		try {

			// Decide which method to call
			// based on action value
			switch (action) {

			// Open Add Student form
			case "new":
				showNewForm(request, response);
				break;

			// Insert new student into database
			case "insert":
				insertStudent(request, response);
				break;

			// Delete student using id
			case "delete":
				deleteStudent(request, response);
				break;

			// Open Edit form with existing data
			case "edit":
				showEditForm(request, response);
				break;

			// Update student data
			case "update":
				updateStudent(request, response);
				break;

			// Delete all records from table
			case "truncate":
				truncateTable(request, response);
				break;

			// Default action:
			// Display all students
			default:
				listStudent(request, response);
				break;
			}

		} catch (Exception e) {

			// Throw servlet exception if any error occurs
			throw new ServletException(e);
		}
	}

	// Handles POST requests
	// Calls doGet() to avoid duplicate logic
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	// Fetch all students from database
	// and display in list.jsp
	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get all students from DAO
		List<Student> listStudent = studentDAO.selectAllStudents();

		// Store list in request scope
		request.setAttribute("listStudent", listStudent);

		// Forward request to list.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");

		dispatcher.forward(request, response);
	}

	// Open Add Student page
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Forward request to index.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");

		dispatcher.forward(request, response);
	}

	// Open Edit Student page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get student id from URL
		int id = Integer.parseInt(request.getParameter("id"));

		// Fetch existing student from database
		Student existingStudent = studentDAO.selectStudent(id);

		// Forward request to edit.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");

		// Send existing student object to JSP
		request.setAttribute("student", existingStudent);

		dispatcher.forward(request, response);
	}

	// Insert new student into database
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// Get form values from request
		String name = request.getParameter("name");

		int age = Integer.parseInt(request.getParameter("age"));

		String course = request.getParameter("course");

		// Create Student object
		Student s = new Student(name, age, course);

		// Call DAO method
		studentDAO.insertStudent(s);

		// Redirect to student list page
		response.sendRedirect("students");
	}

	// Update existing student
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// Get updated values from form
		int id = Integer.parseInt(request.getParameter("id"));

		String name = request.getParameter("name");

		int age = Integer.parseInt(request.getParameter("age"));

		String course = request.getParameter("course");

		// Create updated Student object
		Student s = new Student(id, name, age, course);

		// Update data in database
		studentDAO.updateStudent(s);

		// Redirect to updated list page
		response.sendRedirect("students");
	}

	// Delete single student using id
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// Get student id
		int id = Integer.parseInt(request.getParameter("id"));

		// Delete student from database
		studentDAO.deleteStudent(id);

		// Refresh list page
		response.sendRedirect("students");
	}

	// Delete ALL records from students table
	private void truncateTable(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// Call DAO truncate method
		studentDAO.truncateStudents();

		// Redirect back to list page
		response.sendRedirect("students");
	}
}
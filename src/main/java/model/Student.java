package model;

// Model class (POJO class i.e Plain Old Java Object)
// Represents one student record from database
public class Student {

	// Instance variables / fields
	// Match database column names
	private int id;

	private String name;

	private int age;

	private String course;

	// Default constructor
	// Required for creating empty objects
	// Example:
	// Student s = new Student();
	public Student() {
	}

	// Constructor used while INSERTING new student
	// id is not included because database auto-generates it
	public Student(String name, int age, String course) {

		this.name = name;

		this.age = age;

		this.course = course;
	}

	// Constructor used while UPDATING student
	// id is required to identify record
	public Student(int id, String name, int age, String course) {

		this.id = id;

		this.name = name;

		this.age = age;

		this.course = course;
	}

	// Getter method for id
	// Used to retrieve student id
	public int getId() {

		return id;
	}

	// Setter method for id
	// Used to set student id
	public void setId(int id) {

		this.id = id;
	}

	// Getter method for name
	public String getName() {

		return name;
	}

	// Setter method for name
	public void setName(String name) {

		this.name = name;
	}

	// Getter method for age
	public int getAge() {

		return age;
	}

	// Setter method for age
	public void setAge(int age) {

		this.age = age;
	}

	// Getter method for course
	public String getCourse() {

		return course;
	}

	// Setter method for course
	public void setCourse(String course) {

		this.course = course;
	}

	// toString() method
	// Converts object into readable string
	// Useful for debugging and console printing
	@Override
	public String toString() {

		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", course=" + course + "]";
	}
}
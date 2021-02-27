package DB.DBSSR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class controls the actions taken for a student.
 * @author miguel munoz
 *
 */
public class studentControler {
    static private BufferedReader br = null;
    static private DatabaseConnector databaseConnector = new DatabaseConnector();
    static private Connection connection = databaseConnector.getConnector();

    /**
     * This method 
     */
    static void registerStudent() {
	br = new BufferedReader(new InputStreamReader(System.in));
	String firstname;
	String lastname;
	int studentid;

	try {
	    System.out.print("Enter first name: ");
	    firstname = br.readLine();
	    System.out.print("Enter last name: ");
	    lastname = br.readLine();
	    System.out.print("Enter student ID: ");
	    studentid = Integer.parseInt(br.readLine());

	    Student student = new Student(firstname, lastname, studentid);
	    String query = "INSERT INTO student (firstname,lastname,studentid) VALUES(?,?,?)";
	    
	    try {
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, student.getFirstname());
		preparedStatement.setString(2, student.getLastname());
		preparedStatement.setInt(3, student.getStudentID());
		int r = preparedStatement.executeUpdate();
		// if r > 0 it means that the query was executed successfully.
		System.out.println((r > 0)
			? "\nStudent " + student.getFirstname() + " " + student.getLastname()
				+ " registered successfully!\n"
			: "There was an error while inserting the element try again!");
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	} catch (IOException | NumberFormatException e) {
	    e.printStackTrace();
	}
    }

    /**
     * This method deletes a student from the database.
     */
    static void deleteStudent() {
	br = new BufferedReader(new InputStreamReader(System.in));
	int studentid = 0;
	try {
	    System.out.println("Enter student id to delete");
	    System.out.print(" >> ");
	    studentid = Integer.parseInt(br.readLine());
	} catch (NumberFormatException e1) {
	    e1.printStackTrace();
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	String query = "DELETE FROM student WHERE studentid = ?";

	try {
	    PreparedStatement preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setInt(1, studentid);
	    int r = preparedStatement.executeUpdate();
	    System.out.println((r > 0) ? "Student deleted succesfully!" : "The Id number doesn't exist!, try again.");
	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    /**
     * This method returns the contents of the student table in the database and
     * print the contents to the console
     */
    static void showDB() {
	String query = "SELECT * FROM student";
	Statement statement;

	try {
	    statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery(query);

	    System.out.println("___________________________________________");
	    System.out.println("|FIRST NAME\tLAST NAME\tSTUDENT ID |");
	    System.out.println("|__________________________________________|");
	    while (resultSet.next()) {
		System.out.println("|" + resultSet.getString(2) + "\t\t" + resultSet.getString(3) + "\t\t"
			+ resultSet.getString(4) + "    |");
	    }
	    System.out.println("|__________________________________________|\n");

	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}

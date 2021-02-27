package DB.DBSSR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class creates the text based user interface and executes actions based on user input.
 * @author miguel munoz
 *
 */
public class TUI {
    private int input = 0;
    BufferedReader br = null;
    public TUI() {
	// call methods to create the app
	menu();
    }
    /**
     * Shows the menu to the user until the user decides to exit.
     */
    public void menu() {
	br  = new BufferedReader(new InputStreamReader(System.in));
	
	while (input != -1) {
	    System.out.println("____________________________________________");
	    System.out.println("|Enter the number of the action to perform  |");
	    System.out.println("|___________________________________________|");
	    System.out.println("|1. Register a student.                     |");
	    System.out.println("|2. Delete a student.                       |");
	    System.out.println("|3. Show database                           |");
	    System.out.println("|-1. To exit                                |");
	    System.out.println("|___________________________________________|\n");
	    System.out.print(" >> ");

	    try {
		input = Integer.parseInt(br.readLine());;
		performAction(input);
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }
    /**
     * Performs an action based on the user input.
     * @param input
     */
    private void performAction(int input) {
	// call methods to
	switch (input) {
	case 1:
	    studentControler.registerStudent();
	    break;
	case 2:
	    studentControler.deleteStudent();
	    break;
	case 3:
	    studentControler.showDB();
	    break;
	case -1:
	    System.out.println("Bye!");
	    break;
	default:
	    System.out.println("Please, enter a valid option\n");
	    break;
	}
    }
}

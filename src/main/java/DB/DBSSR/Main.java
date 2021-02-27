package DB.DBSSR;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
	// starts the application
        new TUI();
        new DatabaseConnector().close();
    }
}

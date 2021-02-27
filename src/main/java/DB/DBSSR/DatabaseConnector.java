package DB.DBSSR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private Connection databaseConnection = null;
    private String user = "root";
    private String password = "expresarte369";
    private String url = "jdbc:mysql://localhost:3306/mydb";
    
    public DatabaseConnector() {
        try {
	    databaseConnection = DriverManager.getConnection(url, user, password);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public void close(){
        try {
	    databaseConnection.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public Connection getConnector() {
	return this.databaseConnection;
    }
}

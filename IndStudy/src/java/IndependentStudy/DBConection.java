package IndependentStudy;

//STEP 1. Import required packages
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConection {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/StudInfoSystem";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "Madhavi";

	public static Connection getConnection() throws SQLException {
            try {
                Connection conn = null;
                Statement stmt = null;
                // STEP 3: Open a connection
                System.out.println("Connecting to database...");
                
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                conn.setAutoCommit(false);
                System.out.println("Connected to database, conn : " + conn);
                return conn;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBConection.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return null;
	}
}
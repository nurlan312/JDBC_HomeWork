package peaksoft.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConfig {

    private static final String URL = "jdbc:postgresql://localhost:5432/jdbc";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Tvrandot";

    public static Connection JDBCConnection() {
        Connection connection = null;
        try {connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("PosgtreSQL connected successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}


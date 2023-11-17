import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private final String DB_URL = "jdbc:mysql://localhost:3306/atmsystem";
    private final String USERNAME = "root";
    private final String PASSWORD = "123456789";
    private Connection connection;
    private Statement statement;
    private ResultSet rs;
    public DatabaseConnection() {
        try {
                connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                System.out.print("Database connected\n");

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public ResultSet getQuery(String query) {
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

}

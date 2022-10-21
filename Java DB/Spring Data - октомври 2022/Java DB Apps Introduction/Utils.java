import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

enum Utils {
    ;
    static Connection getSQLConnection() throws SQLException {
        final Properties properties = new Properties();
        properties.setProperty(Constants.user_key, Constants.user_value);
        properties.setProperty(Constants.user_password_key, Constants.user_password_value);

        return DriverManager.getConnection(Constants.JDBC_URL, properties);
    }
}

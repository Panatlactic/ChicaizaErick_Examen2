package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Infrastructure.ceAppConfig;

public abstract class ceSQLiteDataHelper {
    
    protected static Connection GetConnection() throws SQLException {
        try {
            Class.forName(ceAppConfig.ceDRIVER);
            return DriverManager.getConnection(ceAppConfig.ceDB_URL);
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQLite Driver not found", e);
        }
    }
}

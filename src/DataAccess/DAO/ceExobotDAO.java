package DataAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import DataAccess.ceSQLiteDataHelper;
import DataAccess.DTO.ceExobotDTO;

public class ceExobotDAO extends ceSQLiteDataHelper {

    // Create or Insert a new Exobot record
    public boolean gjCreateExobot(ceExobotDTO gjDto) {
        String gjSql = "INSERT INTO gjExobot (gjIdTipoExobot, gjIdUsuario, gjEntrenado, gjNumeroAccion, gjIdArma) VALUES (?, ?, ?, ?, ?)";
        try (Connection gjConn = GetConnection();
             PreparedStatement gjPstmt = gjConn.prepareStatement(gjSql)) {
            
            gjPstmt.setInt(1, gjDto.GetIdTipoExobot());
            gjPstmt.setInt(2, gjDto.GetIdUsuario());
            gjPstmt.setInt(3, gjDto.IsEntrenado() ? 1 : 0);
            gjPstmt.setInt(4, gjDto.GetNumeroAccion());
            gjPstmt.setInt(5, gjDto.GetIdArma());
            
            return gjPstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error creating Exobot: " + e.getMessage());
            return false;
        }
    }

    // Read/GetAll methods could be added here...
}

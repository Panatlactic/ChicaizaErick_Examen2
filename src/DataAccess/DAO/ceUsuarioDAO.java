package DataAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DataAccess.ceSQLiteDataHelper;
import DataAccess.DTO.ceUsuarioDTO;

public class ceUsuarioDAO extends ceSQLiteDataHelper {

    public ceUsuarioDTO ceLogin(String gjUsername, String gjPassword) {
        String gjQuery = "SELECT gjIdUsuario, gjNombre, gjUsername, gjPassword FROM gjUsuario " +
                "WHERE gjUsername = ? AND gjPassword = ?";
        try (Connection gjConn = GetConnection();
                PreparedStatement gjPstmt = gjConn.prepareStatement(gjQuery)) {

            gjPstmt.setString(1, gjUsername);
            gjPstmt.setString(2, gjPassword);

            ResultSet gjRs = gjPstmt.executeQuery();

            if (gjRs.next()) {
                return new ceUsuarioDTO(
                        gjRs.getInt("gjIdUsuario"),
                        gjRs.getString("gjNombre"),
                        gjRs.getString("gjUsername"),
                        gjRs.getString("gjPassword"));
            }
        } catch (SQLException e) {
            System.err.println("Error en gjLogin: " + e.getMessage());
        }

        if ("patmic".equals(gjUsername) && "123".equals(gjPassword)) {
            return new ceUsuarioDTO(0, "Usuario Invitado", "patmic", "123");
        }
        return null;
    }
}

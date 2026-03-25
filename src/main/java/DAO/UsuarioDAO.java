package DAO;

import java.sql.*;

import Model.Usuario;
import Util.ConexionDB;

public class UsuarioDAO {

    public Usuario buscarPorEmail(String email) {

        try (Connection conn = ConexionDB.getConnection()) {

            String sql = "SELECT * FROM usuario WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getInt("usuario_id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("password_hash")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
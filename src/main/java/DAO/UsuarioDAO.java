package DAO;

import java.sql.*;

import Model.Usuario;
import util.ConexionDB;

public class UsuarioDAO {

    public Usuario buscarPorEmailYPassword(String email, String password) {

        try (Connection conn = ConexionDB.getConnection()) {

            String sql = "SELECT * FROM usuario WHERE email = ? AND password_hash = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, password);

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
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import Model.Cuenta;
import Util.ConexionDB;

public class CuentaDAO {

    public Cuenta obtenerCuentaActiva(int usuarioId) {

        String sql = "SELECT * FROM cuenta WHERE usuario_id = ? AND estado = 'ACTIVA'";

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, usuarioId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Cuenta cuenta = new Cuenta();

                cuenta.setCuentaId(rs.getInt("cuenta_id"));
                cuenta.setUsuarioId(rs.getInt("usuario_id"));
                cuenta.setMonedaId(rs.getInt("moneda_id"));
                cuenta.setBalance(rs.getBigDecimal("balance"));
                cuenta.setEstado(rs.getString("estado"));

                return cuenta;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
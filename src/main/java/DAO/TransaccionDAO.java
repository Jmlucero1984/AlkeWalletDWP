package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Transaccion;
import util.ConexionDB;

public class TransaccionDAO {
	public List<Transaccion> obtenerPorUsuario(int usuarioId) {

	    List<Transaccion> lista = new ArrayList<>();

	    String sql = """
	        SELECT t.*
	        FROM transaccion t
	        JOIN cuenta c1 ON t.cuenta_origen_id = c1.cuenta_id
	        JOIN cuenta c2 ON t.cuenta_destino_id = c2.cuenta_id
	        WHERE c1.usuario_id = ? OR c2.usuario_id = ?
	    """;

	    try (Connection con = ConexionDB.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, usuarioId);
	        ps.setInt(2, usuarioId);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Transaccion t = new Transaccion();
	            t.setTransaccionId(rs.getInt("transaccion_id"));
	            t.setCantidad(rs.getBigDecimal("cantidad"));
	            t.setEstado(rs.getString("estado"));
	            t.setFechaCreacion(rs.getTimestamp("fecha_creacion"));

	            lista.add(t);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}
}

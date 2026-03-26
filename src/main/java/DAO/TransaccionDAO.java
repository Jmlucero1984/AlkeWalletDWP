package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Transaccion;
import Util.ConexionDB;

public class TransaccionDAO {
	public List<Transaccion> obtenerPorUsuario(int usuarioId) {

	    List<Transaccion> lista = new ArrayList<>();

	    String sql = """
	    	    SELECT t.*, tt.codigo
	    	    FROM transaccion t
	    	    JOIN cuenta c1 ON t.cuenta_origen_id = c1.cuenta_id
	    	    JOIN cuenta c2 ON t.cuenta_destino_id = c2.cuenta_id
	    	    JOIN tipo_transaccion tt ON t.tipo_transaccion_id = tt.tipo_transaccion_id
	    	    WHERE 
	    	        (
	    	            c1.usuario_id = ? 
	    	            AND tt.codigo IN ('DEPOSITO','RETIRO','REALIZA TCDM MMO', 'REALIZA TCDM MMD', 'REALIZA TCIM')
	    	        )
	    	        OR
	    	        (
	    	            c2.usuario_id = ? 
	    	            AND tt.codigo IN ('RECIBE TCDM MMO', 'RECIBE TCDM MMD', 'RECIBE TCIM')
	    	        )
	    	    ORDER BY t.fecha_creacion DESC
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
	            t.setTipoTransaccionCodigo(rs.getString("codigo"));
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

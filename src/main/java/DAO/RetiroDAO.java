package DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import Model.Cuenta;
import Util.ConexionDB;
 

public class RetiroDAO {

public void retirar(int usuarioId, BigDecimal monto) {

        String sqlCuenta = "SELECT * FROM cuenta WHERE usuario_id = ? AND estado = 'ACTIVA'";
        String sqlUpdate = "UPDATE cuenta SET balance = ? WHERE cuenta_id = ?";
        String sqlInsertTransaccion = """
            INSERT INTO transaccion
            (tipo_transaccion_id, cuenta_origen_id,cuenta_destino_id, cantidad,
             moneda_origen_id, moneda_destino_id,
             ratio_a_dolar_origen, ratio_a_dolar_destino,
             factor_conversion, cantidad_efectiva,
             saldo_anterior, saldo_posterior, estado)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection con = ConexionDB.getConnection()) {

            con.setAutoCommit(false);

            // 1️⃣ Obtener cuenta
            PreparedStatement psCuenta = con.prepareStatement(sqlCuenta);
            psCuenta.setInt(1, usuarioId);

            ResultSet rs = psCuenta.executeQuery();

            if (!rs.next()) {
                throw new RuntimeException("Cuenta no encontrada");
            }

            int cuentaId = rs.getInt("cuenta_id");
            BigDecimal saldoAnterior = rs.getBigDecimal("balance");
            int monedaId = rs.getInt("moneda_id");

            // 🔥 VALIDACIÓN IMPORTANTE
            if (saldoAnterior.compareTo(monto) < 0) {
                throw new RuntimeException("Saldo insuficiente");
            }

            BigDecimal saldoNuevo = saldoAnterior.subtract(monto);

            // 2️⃣ Actualizar balance
            PreparedStatement psUpdate = con.prepareStatement(sqlUpdate);
            psUpdate.setBigDecimal(1, saldoNuevo);
            psUpdate.setInt(2, cuentaId);
            psUpdate.executeUpdate();

            // 3️⃣ Registrar transacción
            PreparedStatement psInsert = con.prepareStatement(sqlInsertTransaccion);

            psInsert.setInt(1, 2); // tipo_transaccion_id = RETIRO
            psInsert.setInt(2, cuentaId);
            psInsert.setInt(3, cuentaId);
            psInsert.setBigDecimal(4, monto);
            psInsert.setInt(5, monedaId);
            psInsert.setInt(6, monedaId);
            psInsert.setDouble(7, 1);
            psInsert.setDouble(8, 1);
            psInsert.setDouble(9, 1);
            psInsert.setBigDecimal(10, monto); // opcional
            psInsert.setBigDecimal(11, saldoAnterior);
            psInsert.setBigDecimal(12, saldoNuevo);
            psInsert.setString(13, "COMPLETADA");

            psInsert.executeUpdate();

            con.commit();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
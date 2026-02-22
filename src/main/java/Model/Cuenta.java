package Model;

 

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Cuenta {

    private int cuentaId;
    private int usuarioId;
    private int monedaId;

    private BigDecimal balance;

    private String estado;

    private Timestamp fechaCreacion;

    // Constructor vacío
    public Cuenta() {
    }

    // Constructor útil
    public Cuenta(int usuarioId, int monedaId, BigDecimal balance, String estado) {
        this.usuarioId = usuarioId;
        this.monedaId = monedaId;
        this.balance = balance;
        this.estado = estado;
    }

    // GETTERS & SETTERS

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getMonedaId() {
        return monedaId;
    }

    public void setMonedaId(int monedaId) {
        this.monedaId = monedaId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
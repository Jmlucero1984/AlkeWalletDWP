package Model;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Transaccion {

    private int transaccionId;
    private int tipoTransaccionId;
    private Integer cuentaOrigenId;     
    private Integer cuentaDestinoId;    

    private BigDecimal cantidad;

    private int monedaOrigenId;
    private int monedaDestinoId;

    private double ratioADolarOrigen;
    private double ratioADolarDestino;
    private double factorConversion;

    private BigDecimal cantidadEfectiva;

    private BigDecimal saldoAnterior;
    private BigDecimal saldoPosterior;

    private String estado;

    private Timestamp fechaCreacion;

    // Constructor vacío
    public Transaccion() {
    }

    // Constructor completo (opcional)
    public Transaccion(int tipoTransaccionId,
                       Integer cuentaOrigenId,
                       Integer cuentaDestinoId,
                       BigDecimal cantidad,
                       int monedaOrigenId,
                       int monedaDestinoId,
                       double ratioADolarOrigen,
                       double ratioADolarDestino,
                       double factorConversion,
                       BigDecimal cantidadEfectiva,
                       BigDecimal saldoAnterior,
                       BigDecimal saldoPosterior,
                       String estado) {

        this.tipoTransaccionId = tipoTransaccionId;
        this.cuentaOrigenId = cuentaOrigenId;
        this.cuentaDestinoId = cuentaDestinoId;
        this.cantidad = cantidad;
        this.monedaOrigenId = monedaOrigenId;
        this.monedaDestinoId = monedaDestinoId;
        this.ratioADolarOrigen = ratioADolarOrigen;
        this.ratioADolarDestino = ratioADolarDestino;
        this.factorConversion = factorConversion;
        this.cantidadEfectiva = cantidadEfectiva;
        this.saldoAnterior = saldoAnterior;
        this.saldoPosterior = saldoPosterior;
        this.estado = estado;
    }

    // GETTERS & SETTERS

    public int getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(int transaccionId) {
        this.transaccionId = transaccionId;
    }

    public int getTipoTransaccionId() {
        return tipoTransaccionId;
    }

    public void setTipoTransaccionId(int tipoTransaccionId) {
        this.tipoTransaccionId = tipoTransaccionId;
    }

    public Integer getCuentaOrigenId() {
        return cuentaOrigenId;
    }

    public void setCuentaOrigenId(Integer cuentaOrigenId) {
        this.cuentaOrigenId = cuentaOrigenId;
    }

    public Integer getCuentaDestinoId() {
        return cuentaDestinoId;
    }

    public void setCuentaDestinoId(Integer cuentaDestinoId) {
        this.cuentaDestinoId = cuentaDestinoId;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public int getMonedaOrigenId() {
        return monedaOrigenId;
    }

    public void setMonedaOrigenId(int monedaOrigenId) {
        this.monedaOrigenId = monedaOrigenId;
    }

    public int getMonedaDestinoId() {
        return monedaDestinoId;
    }

    public void setMonedaDestinoId(int monedaDestinoId) {
        this.monedaDestinoId = monedaDestinoId;
    }

    public double getRatioADolarOrigen() {
        return ratioADolarOrigen;
    }

    public void setRatioADolarOrigen(double ratioADolarOrigen) {
        this.ratioADolarOrigen = ratioADolarOrigen;
    }

    public double getRatioADolarDestino() {
        return ratioADolarDestino;
    }

    public void setRatioADolarDestino(double ratioADolarDestino) {
        this.ratioADolarDestino = ratioADolarDestino;
    }

    public double getFactorConversion() {
        return factorConversion;
    }

    public void setFactorConversion(double factorConversion) {
        this.factorConversion = factorConversion;
    }

    public BigDecimal getCantidadEfectiva() {
        return cantidadEfectiva;
    }

    public void setCantidadEfectiva(BigDecimal cantidadEfectiva) {
        this.cantidadEfectiva = cantidadEfectiva;
    }

    public BigDecimal getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(BigDecimal saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public BigDecimal getSaldoPosterior() {
        return saldoPosterior;
    }

    public void setSaldoPosterior(BigDecimal saldoPosterior) {
        this.saldoPosterior = saldoPosterior;
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

    public void setFechaCreacion(Timestamp timestamp) {
        this.fechaCreacion = timestamp;
    }
}
package Model;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TipoTransaccion {

    private int tipoTransaccionId;


    private String codigo;
    private String descripcion;

 

    // Constructor vacío
    public TipoTransaccion() {
    }

    // Constructor completo (opcional)
    public TipoTransaccion(int tipoTransaccionId,
                       String codigo,
                       String descripcion) {

        this.tipoTransaccionId = tipoTransaccionId;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

	public int getTipoTransaccionId() {
		return tipoTransaccionId;
	}

	public void setTipoTransaccionId(int tipoTransaccionId) {
		this.tipoTransaccionId = tipoTransaccionId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




}
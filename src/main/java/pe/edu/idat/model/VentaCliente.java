package pe.edu.idat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ventacliente")
@Data
public class VentaCliente {

	@Id
	private Integer idventa;
	
	@Column
	private String numerocomprobante;
	
	@Column
	private Date fechaventa;
	
	@Column
	private Integer idusuario;
	
	@Column
	private Integer idpago;
	
	@ManyToOne
	@JoinColumn(name = "idusuario", referencedColumnName = "idusuario", insertable = false, updatable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "idpago", referencedColumnName = "idpago", insertable = false, updatable = false)
	private TipoPago tipoPago;
	
}

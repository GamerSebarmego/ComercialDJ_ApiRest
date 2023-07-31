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
@Table(name = "pedidocompra")
@Data
public class PedidoCompra {

	@Id
	private Integer idpedido;
	
	@Column
	private String numbercompra;
	
	@Column
	private Date fechapedido;
	
	@Column
	private String codtrabajador;
	
	@ManyToOne
	@JoinColumn(name = "codtrabajador", referencedColumnName = "codtrabajador", insertable = false, updatable = false)
	private Trabajador trabajador;
}

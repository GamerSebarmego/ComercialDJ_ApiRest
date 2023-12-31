package pe.edu.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "detallepedidocompra")
@Data
public class DetallePedidoCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddetalle;
	
	@Column
	private Integer idpedido;
	
	@Column
	private String codproducto;
	
	@Column
	private Integer cantidadproductos;
	

	@ManyToOne
	@JoinColumn(name = "idpedido", referencedColumnName = "idpedido", updatable = false, insertable = false)
	private PedidoCompra compra;

	@ManyToOne
	@JoinColumn(name = "codproducto", referencedColumnName = "codproducto", updatable = false, insertable = false)
	private Producto producto;
}

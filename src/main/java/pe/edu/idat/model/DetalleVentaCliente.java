package pe.edu.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "detalleventacliente")
@Data
public class DetalleVentaCliente {

	@Id
	private Integer iddetalle;
	
	@Column
	private String codproducto;
	
	@Column
	private Integer cantidadproductos;
	
	@Column
	private Integer idventa;
	
	@Column
	private double importetotal;
	
	@ManyToOne
	@JoinColumn(name = "codproducto", referencedColumnName = "codproducto", updatable = false, insertable = false)
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "idventa", referencedColumnName = "idventa", updatable = false, insertable = false)
	private VentaCliente ventaCliente;
	
}

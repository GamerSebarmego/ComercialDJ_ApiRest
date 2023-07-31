package pe.edu.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "producto")
@Data
public class Producto {

	@Id
	private String codproducto;
	
	@Column
	private String nombreproducto;
	
	@Column
	private String marcaproducto;
	
	@Column
	private Integer idcategoria;
	
	@Column
	private String descripcion;
	
	@Column
	private double preciocompra;
	
	@Column
	private double precioventa;

	@ManyToOne
	@JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria", updatable = false, insertable = false)
	private CategoriaProducto categoriaProducto;
	
}

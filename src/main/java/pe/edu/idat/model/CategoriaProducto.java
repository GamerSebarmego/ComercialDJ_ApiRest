package pe.edu.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "categoriaproducto")
@Data
public class CategoriaProducto {

	@Id
	private Integer idcategoria;
	
	@Column
	private String descripcion;
	
	@Column
	private boolean estado;
	
}
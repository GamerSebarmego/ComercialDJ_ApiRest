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
@Table(name = "vista")
@Data
public class Vista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codvista;
	
	@Column
	private String codproducto;
	
	@Column
	private String imagen;
	
	@Column
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "codproducto", referencedColumnName = "codproducto", updatable = false, insertable = false)
	private Producto producto;
}

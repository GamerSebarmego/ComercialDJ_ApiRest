package pe.edu.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "detalleguiaingreso")
@Data
public class DetallesGuiasIngreso {

	@Id
	private Integer idguiaingreso;
	
	@Column
	private Integer idguia;
	
	@Column
	private String codproducto;
	
	@Column
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name = "idguia", referencedColumnName = "idguia", updatable = false, insertable = false)
	private GuiasIngreso guiasIngreso;
	
	@ManyToOne
	@JoinColumn(name = "codproducto", referencedColumnName = "codproducto", updatable = false, insertable = false)
	private Producto producto;
	
}

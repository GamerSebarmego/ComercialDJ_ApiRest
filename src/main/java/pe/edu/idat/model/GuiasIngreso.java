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
@Table(name = "guiasingreso")
@Data
public class GuiasIngreso {

	@Id
	private Integer idguia;
	
	@Column
	private String numeroguia;
	
	@Column
	private Date fecha;
	
	@Column
	private String ruc;
	
	@ManyToOne
	@JoinColumn(name = "ruc", referencedColumnName = "ruc", insertable = false, updatable = false)
	private Proveedor proveedor;
	
}

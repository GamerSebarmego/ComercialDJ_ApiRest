package pe.edu.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "rol")
@Data
public class Rol {

	@Id
	private int idrol;
	
	@Column
	private String permisos;
	
	@Column
	private String descripcion;
	
	@Column
	private boolean estado;
	
}

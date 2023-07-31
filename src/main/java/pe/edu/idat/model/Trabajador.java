package pe.edu.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "trabajador")
@Data
public class Trabajador {

	@Id
	private String codtrabajador;
	
	@Column
	private String nombretrabajador;
	
	@Column
	private String direccion;
	
	@Column
	private Integer telefono;
	
	@Column
	private String correo;
}

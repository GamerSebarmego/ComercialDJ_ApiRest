package pe.edu.idat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {

	@Id
	private Integer dni;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column
	private String direccion;
	
	@Column
	private String referencia;
	
	@Column
	private Integer telefono;
	
	@Column
	private String correo;
	
	@Column
	private Date fechaingreso;
	
}

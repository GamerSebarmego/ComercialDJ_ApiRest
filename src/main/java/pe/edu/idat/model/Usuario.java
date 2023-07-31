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
@Table(name = "usuario")
@Data
public class Usuario {

	@Id
	private Integer idusuario;
	
	@Column
	private String nombreusuario;
	
	@Column
	private boolean estado;
	
	@Column
	private int idrol;
	
	@Column
	private String contrasenia;
	
	@Column
	private Date fecharegistro;
	
	@Column
	private Integer dni;
	
	@ManyToOne
	@JoinColumn(name = "idrol", referencedColumnName = "idrol", updatable = false, insertable = false)
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name = "dni", referencedColumnName = "dni", updatable = false, insertable = false)
	private Cliente cliente;
}

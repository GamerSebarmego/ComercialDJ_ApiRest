package pe.edu.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "proveedor")
@Data
public class Proveedor {

	@Id
	private Integer ruc;
	
	@Column
	private String representante;
	
	@Column
	private String razonsocial;
	
	@Column
	private Integer telefono;
	
	@Column
	private String correo;
	
	@Column
	private String direccion;
}

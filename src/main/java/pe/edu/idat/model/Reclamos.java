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
@Table(name = "reclamos")
@Data
public class Reclamos {

	@Id
	private Integer idreclamo;
	
	@Column
	private String asunto;
	
	@Column
	private String cuerporeclamo;
	
	@Column
	private String adjuntos;
	
	@Column
	private Integer dni;
	
	@Column
	private Date fechareclamo;
	
	@ManyToOne
	@JoinColumn(name = "dni", referencedColumnName = "dni", insertable = false, updatable = false)
	private Cliente cliente;
	
}

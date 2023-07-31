package pe.edu.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tipopago")
@Data
public class TipoPago {

	@Id
	private Integer idpago;
	
	@Column
	private String nombre;
}

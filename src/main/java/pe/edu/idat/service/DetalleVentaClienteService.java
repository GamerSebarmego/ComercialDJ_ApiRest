package pe.edu.idat.service;

import java.util.Collection;

import pe.edu.idat.model.DetalleVentaCliente;

public interface DetalleVentaClienteService {

	public abstract void insert(DetalleVentaCliente detalleVentaCliente);
	public abstract void update(DetalleVentaCliente detalleVentaCliente);
	public abstract void delete(Integer iddetalle);
	public abstract DetalleVentaCliente findbyid(Integer iddetalle);
	public abstract Collection<DetalleVentaCliente> findall();
	
}

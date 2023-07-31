package pe.edu.idat.service;

import java.util.Collection;

import pe.edu.idat.model.VentaCliente;

public interface VentaClienteService {

	public abstract void insert(VentaCliente ventaCliente);
	public abstract void update(VentaCliente ventaCliente);
	public abstract void delete(Integer idventa);
	public abstract VentaCliente findbyid(Integer idventa);
	public abstract Collection<VentaCliente> findall();
	
}

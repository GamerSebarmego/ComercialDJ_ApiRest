package pe.edu.idat.service;

import java.util.Collection;

import pe.edu.idat.model.Proveedor;

public interface ProveedorService {

	public abstract void insert(Proveedor proveedor);
	public abstract void update(Proveedor proveedor);
	public abstract void delete(String ruc);
	public abstract Proveedor findbyid(String ruc);
	public abstract Collection<Proveedor> findall();
}

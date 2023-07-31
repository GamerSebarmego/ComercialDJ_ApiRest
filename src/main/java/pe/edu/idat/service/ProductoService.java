package pe.edu.idat.service;

import java.util.Collection;

import pe.edu.idat.model.Producto;

public interface ProductoService {

	public abstract void insert(Producto producto);
	public abstract void update(Producto producto);
	public abstract void delete(String codproducto);
	public abstract Producto findbyid(String codproducto);
	public abstract Collection<Producto> findall();
}

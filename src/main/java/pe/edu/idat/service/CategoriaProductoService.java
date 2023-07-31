package pe.edu.idat.service;

import java.util.Collection;

import pe.edu.idat.model.CategoriaProducto;

public interface CategoriaProductoService {
	
	public abstract void insert(CategoriaProducto categoriaProducto);
	public abstract void update(CategoriaProducto categoriaProducto);
	public abstract void delete(Integer idcategoria);
	public abstract CategoriaProducto findbyid(Integer idcategoria);
	public abstract Collection<CategoriaProducto> findall();
	
}

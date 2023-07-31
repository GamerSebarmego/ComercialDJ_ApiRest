package pe.edu.idat.service;

import java.util.Collection;

import pe.edu.idat.model.Reclamos;

public interface ReclamosService {

	public abstract void insert(Reclamos  reclamos);
	public abstract void update(Reclamos reclamos);
	public abstract void delete(Integer idreclamo);
	public abstract Reclamos findbyid(Integer idreclamo);
	public abstract Collection<Reclamos> findall();
	
}

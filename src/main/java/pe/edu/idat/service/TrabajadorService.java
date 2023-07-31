package pe.edu.idat.service;

import java.util.Collection;

import pe.edu.idat.model.Trabajador;

public interface TrabajadorService {

	public abstract void insert(Trabajador trabajador);
	public abstract void update(Trabajador trabajador);
	public abstract void delete(String codtrabajador);
	public abstract Trabajador findbyid(String codtrabajador);
	public abstract Collection<Trabajador> findall();
	
}

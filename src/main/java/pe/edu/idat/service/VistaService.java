package pe.edu.idat.service;

import java.util.Collection;

import pe.edu.idat.model.Vista;

public interface VistaService {

	public abstract void insert(Vista vista);
	public abstract void update(Vista vista);
	public abstract void delete(Integer codvista);
	public abstract Vista findbyid(Integer codvista);
	public abstract Collection<Vista> findall();
}

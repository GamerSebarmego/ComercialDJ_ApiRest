package pe.edu.idat.service;

import java.util.Collection;

import pe.edu.idat.model.DetallesGuiasIngreso;

public interface DetallesGuiasIngresoService {

	public abstract void insert(DetallesGuiasIngreso detallesGuiasIngreso);
	public abstract void update(DetallesGuiasIngreso detallesGuiasIngreso);
	public abstract void delete(Integer idguiaingreso);
	public abstract DetallesGuiasIngreso findbyid(Integer idguiaingreso);
	public abstract Collection<DetallesGuiasIngreso> findall();
	
}

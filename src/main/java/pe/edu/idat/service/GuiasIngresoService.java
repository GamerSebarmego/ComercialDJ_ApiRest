package pe.edu.idat.service;

import java.util.Collection;

import pe.edu.idat.model.GuiasIngreso;

public interface GuiasIngresoService {

	public abstract void insert(GuiasIngreso guiasIngreso);
	public abstract void update(GuiasIngreso guiasIngreso);
	public abstract void delete(Integer idguia);
	public abstract GuiasIngreso findbyid(Integer idguia);
	public abstract Collection<GuiasIngreso> findall();
	
}

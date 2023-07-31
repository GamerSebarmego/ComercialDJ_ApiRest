package pe.edu.idat.service;

import java.util.Collection;

import pe.edu.idat.model.TipoPago;

public interface TipoPagoService {

	public abstract void insert(TipoPago tipoPago);
	public abstract void update(TipoPago tipoPago);
	public abstract void delete(Integer idpago);
	public abstract TipoPago findbyid(Integer idpago);
	public abstract Collection<TipoPago> findall();
	
}

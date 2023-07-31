package pe.edu.idat.service;

import java.util.Collection;

import pe.edu.idat.model.Cliente;

public interface ClienteService {
	
	public abstract void insert(Cliente cliente);
	public abstract void update(Cliente cliente);
	public abstract void delete(Integer dni);
	public abstract Cliente findbyid(Integer dni);
	public abstract Collection<Cliente> findall();
	
}

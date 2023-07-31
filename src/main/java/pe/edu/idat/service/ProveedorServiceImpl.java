package pe.edu.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.idat.dao.ProveedorDAO;
import pe.edu.idat.model.Proveedor;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private ProveedorDAO dao;
	
	@Override
	@Transactional
	public void insert(Proveedor proveedor) {
		dao.save(proveedor);

	}

	@Override
	@Transactional
	public void update(Proveedor proveedor) {
		dao.save(proveedor);

	}

	@Override
	@Transactional
	public void delete(Integer ruc) {
		dao.deleteById(ruc);

	}

	@Override
	@Transactional(readOnly = true)
	public Proveedor findbyid(Integer ruc) {
		return dao.findById(ruc).orElse(null);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Proveedor> findall() {
		return (Collection<Proveedor>) dao.findAll();
	}

}

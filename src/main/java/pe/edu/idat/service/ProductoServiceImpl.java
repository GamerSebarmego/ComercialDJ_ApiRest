package pe.edu.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.idat.dao.ProductoDAO;
import pe.edu.idat.model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDAO dao;
	
	@Override
	@Transactional
	public void insert(Producto producto) {
		dao.save(producto);

	}

	@Override
	@Transactional
	public void update(Producto producto) {
		dao.save(producto);

	}

	@Override
	@Transactional
	public void delete(String codproducto) {
		dao.deleteById(codproducto);

	}

	@Override
	@Transactional(readOnly = true)
	public Producto findbyid(String codproducto) {
		return dao.findById(codproducto).orElse(null);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Producto> findall() {
		return (Collection<Producto>) dao.findAll();
		
	}

}

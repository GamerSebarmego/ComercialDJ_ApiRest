package pe.edu.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.idat.dao.CategoriaProductoDAO;
import pe.edu.idat.model.CategoriaProducto;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

	@Autowired
	private CategoriaProductoDAO dao;
	
	@Override
	@Transactional
	public void insert(CategoriaProducto categoriaProducto) {
		dao.save(categoriaProducto);

	}

	@Override
	@Transactional
	public void update(CategoriaProducto categoriaProducto) {
		dao.save(categoriaProducto);

	}

	@Override
	@Transactional
	public void delete(Integer idcategoria) {
		dao.deleteById(idcategoria);

	}

	@Override
	@Transactional(readOnly = true)
	public CategoriaProducto findbyid(Integer idcategoria) {
		return dao.findById(idcategoria).orElse(null);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<CategoriaProducto> findall() {
		return (Collection<CategoriaProducto>) dao.findAll();
		
	}

}

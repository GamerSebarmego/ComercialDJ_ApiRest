package pe.edu.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.idat.dao.VistaDAO;
import pe.edu.idat.model.Vista;

@Service
public class VistaServiceImpl implements VistaService {

	@Autowired
	private VistaDAO dao;
	
	@Override
	@Transactional
	public void insert(Vista vista) {
		dao.save(vista);

	}

	@Override
	@Transactional
	public void update(Vista vista) {
		dao.save(vista);

	}

	@Override
	@Transactional
	public void delete(Integer codvista) {
		dao.deleteById(codvista);

	}

	@Override
	@Transactional(readOnly = true)
	public Vista findbyid(Integer codvista) {
		return dao.findById(codvista).orElse(null);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Vista> findall() {
		return (Collection<Vista>) dao.findAll();
	}

}

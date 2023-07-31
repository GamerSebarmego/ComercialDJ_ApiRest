package pe.edu.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.idat.dao.TrabajadorDAO;
import pe.edu.idat.model.Trabajador;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

	@Autowired
	private TrabajadorDAO dao;
	
	@Override
	@Transactional
	public void insert(Trabajador trabajador) {
		dao.save(trabajador);

	}

	@Override
	@Transactional
	public void update(Trabajador trabajador) {
		dao.save(trabajador);

	}

	@Override
	@Transactional
	public void delete(String codtrabajador) {
		dao.deleteById(codtrabajador);

	}

	@Override
	@Transactional(readOnly = true)
	public Trabajador findbyid(String codtrabajador) {
		return dao.findById(codtrabajador).orElse(null);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Trabajador> findall() {
		return (Collection<Trabajador>) dao.findAll();
		
	}

}

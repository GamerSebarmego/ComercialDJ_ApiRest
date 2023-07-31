package pe.edu.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.idat.dao.ReclamosDAO;
import pe.edu.idat.model.Reclamos;

@Service
public class ReclamosServiceImpl implements ReclamosService {

	@Autowired
	private ReclamosDAO dao;
	
	@Override
	@Transactional
	public void insert(Reclamos reclamos) {
		dao.save(reclamos);

	}

	@Override
	@Transactional
	public void update(Reclamos reclamos) {
		dao.save(reclamos);

	}

	@Override
	@Transactional
	public void delete(Integer idreclamo) {
		dao.deleteById(idreclamo);

	}

	@Override
	@Transactional(readOnly = true)
	public Reclamos findbyid(Integer idreclamo) {
		return dao.findById(idreclamo).orElse(null);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Reclamos> findall() {
		return (Collection<Reclamos>) dao.findAll();
	}

}

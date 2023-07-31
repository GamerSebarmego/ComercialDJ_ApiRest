package pe.edu.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.idat.dao.DetallesGuiasIngresoDAO;
import pe.edu.idat.model.DetallesGuiasIngreso;

@Service
public class DetallesGuiasIngresoServiceImpl implements DetallesGuiasIngresoService {

	@Autowired
	private DetallesGuiasIngresoDAO dao;
	
	@Override
	@Transactional
	public void insert(DetallesGuiasIngreso detallesGuiasIngreso) {
		dao.save(detallesGuiasIngreso);

	}

	@Override
	@Transactional
	public void update(DetallesGuiasIngreso detallesGuiasIngreso) {
		dao.save(detallesGuiasIngreso);

	}

	@Override
	@Transactional
	public void delete(Integer idguiaingreso) {
		dao.deleteById(idguiaingreso);

	}

	@Override
	@Transactional(readOnly = true)
	public DetallesGuiasIngreso findbyid(Integer idguiaingreso) {
		return dao.findById(idguiaingreso).orElse(null);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<DetallesGuiasIngreso> findall() {
		return (Collection<DetallesGuiasIngreso>) dao.findAll();
	}

}

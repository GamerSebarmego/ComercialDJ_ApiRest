package pe.edu.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.idat.dao.GuiasIngresoDAO;
import pe.edu.idat.model.GuiasIngreso;

@Service
public class GuiasIngresoServiceImpl implements GuiasIngresoService {

	@Autowired
	private GuiasIngresoDAO dao;
	
	@Override
	@Transactional
	public void insert(GuiasIngreso guiasIngreso) {
		dao.save(guiasIngreso);

	}

	@Override
	@Transactional
	public void update(GuiasIngreso guiasIngreso) {
		dao.save(guiasIngreso);

	}

	@Override
	@Transactional
	public void delete(Integer idguia) {
		dao.deleteById(idguia);

	}

	@Override
	@Transactional(readOnly = true)
	public GuiasIngreso findbyid(Integer idguia) {
		return dao.findById(idguia).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<GuiasIngreso> findall() {
		return (Collection<GuiasIngreso>) dao.findAll();
	}

}

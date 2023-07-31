package pe.edu.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.idat.dao.TipoPagoDAO;
import pe.edu.idat.model.TipoPago;

@Service
public class TipoPagoServiceImpl implements TipoPagoService {

	@Autowired
	private TipoPagoDAO dao;
	
	@Override
	public void insert(TipoPago tipoPago) {
		dao.save(tipoPago);

	}

	@Override
	public void update(TipoPago tipoPago) {
		dao.save(tipoPago);

	}

	@Override
	public void delete(Integer idpago) {
		dao.deleteById(idpago);

	}

	@Override
	public TipoPago findbyid(Integer idpago) {
		return dao.findById(idpago).orElse(null);
	}

	@Override
	public Collection<TipoPago> findall() {
		return (Collection<TipoPago>) dao.findAll();
	}

}

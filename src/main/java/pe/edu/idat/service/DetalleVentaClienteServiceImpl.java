package pe.edu.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.idat.dao.DetalleVentaClienteDAO;
import pe.edu.idat.model.DetalleVentaCliente;

@Service
public class DetalleVentaClienteServiceImpl implements DetalleVentaClienteService {

	@Autowired
	private DetalleVentaClienteDAO dao;
	
	@Override
	@Transactional
	public void insert(DetalleVentaCliente detalleVentaCliente) {
		dao.save(detalleVentaCliente);

	}

	@Override
	@Transactional
	public void update(DetalleVentaCliente detalleVentaCliente) {
		dao.save(detalleVentaCliente);

	}

	@Override
	@Transactional
	public void delete(Integer iddetalle) {
		dao.deleteById(iddetalle);

	}

	@Override
	@Transactional(readOnly = true)
	public DetalleVentaCliente findbyid(Integer iddetalle) {
		return dao.findById(iddetalle).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<DetalleVentaCliente> findall() {
		return (Collection<DetalleVentaCliente>) dao.findAll();
	}

}

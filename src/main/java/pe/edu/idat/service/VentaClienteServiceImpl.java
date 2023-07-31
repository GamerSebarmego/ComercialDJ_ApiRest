package pe.edu.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.idat.dao.VentaClienteDAO;
import pe.edu.idat.model.VentaCliente;

@Service
public class VentaClienteServiceImpl implements VentaClienteService {

	@Autowired
	private VentaClienteDAO dao;
	
	@Override
	@Transactional
	public void insert(VentaCliente ventaCliente) {
		dao.save(ventaCliente);

	}

	@Override
	@Transactional
	public void update(VentaCliente ventaCliente) {
		dao.save(ventaCliente);

	}

	@Override
	@Transactional
	public void delete(Integer idventa) {
		dao.deleteById(idventa);

	}

	@Override
	@Transactional(readOnly = true)
	public VentaCliente findbyid(Integer idventa) {
		return dao.findById(idventa).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<VentaCliente> findall() {
		return (Collection<VentaCliente>) dao.findAll();
	}

}

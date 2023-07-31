package pe.edu.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.idat.dao.ClienteDAO;
import pe.edu.idat.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDAO dao;
	
	@Override
	@Transactional
	public void insert(Cliente cliente) {
		dao.save(cliente);
		
	}

	@Override
	@Transactional
	public void update(Cliente cliente) {
		dao.save(cliente);

	}

	@Override
	@Transactional
	public void delete(Integer dni) {
		dao.deleteById(dni);

	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findbyid(Integer dni) {
		return dao.findById(dni).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Cliente> findall() {
		return (Collection<Cliente>) dao.findAll();
	}

}

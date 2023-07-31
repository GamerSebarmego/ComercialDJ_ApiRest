package pe.edu.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.idat.dao.PedidoCompraDAO;
import pe.edu.idat.model.PedidoCompra;

@Service
public class PedidoCompraServiceImpl implements PedidoCompraService {

	@Autowired
	private PedidoCompraDAO dao;
	
	@Override
	@Transactional
	public void insert(PedidoCompra pedidoCompra) {
		dao.save(pedidoCompra);

	}

	@Override
	@Transactional
	public void update(PedidoCompra pedidoCompra) {
		dao.save(pedidoCompra);

	}

	@Override
	@Transactional
	public void delete(Integer idpedido) {
		dao.deleteById(idpedido);

	}

	@Override
	@Transactional(readOnly = true)
	public PedidoCompra findbyid(Integer idpedido) {
		return dao.findById(idpedido).orElse(null);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<PedidoCompra> findall() {
		return (Collection<PedidoCompra>) dao.findAll();
		
	}

}

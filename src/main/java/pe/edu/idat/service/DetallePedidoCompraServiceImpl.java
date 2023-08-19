package pe.edu.idat.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.idat.dao.DetallePedidoCompraDAO;
import pe.edu.idat.model.DetallePedidoCompra;

@Service
public class DetallePedidoCompraServiceImpl implements DetallePedidoCompraService {

	@Autowired
	private DetallePedidoCompraDAO dao;
	
	@Override
	@Transactional
	public void insert(DetallePedidoCompra detallePedidoCompra) {
		dao.save(detallePedidoCompra);

	}

	@Override
	@Transactional
	public void update(DetallePedidoCompra detallePedidoCompra) {
		dao.save(detallePedidoCompra);

	}

	@Override
	@Transactional
	public void delete(Integer iddetalle) {
		dao.deleteById(iddetalle);

	}

	@Override
	@Transactional(readOnly = true)
	public DetallePedidoCompra findbyid(Integer idpedido) {
		return dao.findById(idpedido).orElse(null);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<DetallePedidoCompra> findall() {
		return (Collection<DetallePedidoCompra>) dao.findAll();
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<DetallePedidoCompra> findByPedidoId(Integer idpedido) {
	    return dao.findAllByPedidoId(idpedido);
	}
}

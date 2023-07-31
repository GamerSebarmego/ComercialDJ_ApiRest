package pe.edu.idat.service;

import java.util.Collection;

import pe.edu.idat.model.DetallePedidoCompra;

public interface DetallePedidoCompraService {

	public abstract void insert(DetallePedidoCompra detallePedidoCompra);
	public abstract void update(DetallePedidoCompra detallePedidoCompra);
	public abstract void delete(Integer iddetalle);
	public abstract DetallePedidoCompra findbyid(Integer iddetalle);
	public abstract Collection<DetallePedidoCompra> findall();
	
}

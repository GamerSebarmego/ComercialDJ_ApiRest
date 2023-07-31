package pe.edu.idat.service;

import java.util.Collection;

import pe.edu.idat.model.PedidoCompra;

public interface PedidoCompraService {

	public abstract void insert(PedidoCompra pedidoCompra);
	public abstract void update(PedidoCompra pedidoCompra);
	public abstract void delete(Integer idpedido);
	public abstract PedidoCompra findbyid(Integer idpedido);
	public abstract Collection<PedidoCompra> findall();
}

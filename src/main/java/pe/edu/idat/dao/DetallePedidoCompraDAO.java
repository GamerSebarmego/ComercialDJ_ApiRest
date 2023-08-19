package pe.edu.idat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pe.edu.idat.model.DetallePedidoCompra;

public interface DetallePedidoCompraDAO extends CrudRepository<DetallePedidoCompra, Integer>{
	
    @Query("SELECT dpc FROM DetallePedidoCompra dpc WHERE dpc.idpedido = :idpedido")
    List<DetallePedidoCompra> findAllByPedidoId(@Param("idpedido") Integer idpedido);
}

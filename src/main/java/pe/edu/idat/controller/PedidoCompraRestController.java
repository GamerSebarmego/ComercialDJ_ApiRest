package pe.edu.idat.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.idat.model.PedidoCompra;
import pe.edu.idat.service.PedidoCompraService;

@RestController
@RequestMapping("/pedidocompra")
public class PedidoCompraRestController {

	@Autowired
	private PedidoCompraService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
	Collection<PedidoCompra> itemsPedidoCompras = service.findall();
	return new ResponseEntity<>(itemsPedidoCompras,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idpedido}")
	public ResponseEntity<?> buscar(@PathVariable Integer idpedido) {
		PedidoCompra pedidoCompraDb = service.findbyid(idpedido);
	    if (pedidoCompraDb != null) {
	        return new ResponseEntity<>(pedidoCompraDb, HttpStatus.OK);
	    } else {
	        String mensaje = "El pedido de compra " + idpedido + " no se encontró.";
	        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody PedidoCompra pedidoCompra) {
	    service.insert(pedidoCompra);

	    return new ResponseEntity<>(HttpStatus.CREATED);
	}

	
	@PutMapping("/editar/{idpedido}")
	public ResponseEntity<?> editar(@PathVariable Integer idpedido, @RequestBody PedidoCompra newPedidoCompra) {
		PedidoCompra pedidoCompraDb = service.findbyid(idpedido);
	    if (pedidoCompraDb != null) {
	    	pedidoCompraDb.setNumbercompra(newPedidoCompra.getNumbercompra());
	    	pedidoCompraDb.setFechapedido(newPedidoCompra.getFechapedido());
	    	pedidoCompraDb.setCodtrabajador(newPedidoCompra.getCodtrabajador());
	        service.update(pedidoCompraDb);

	        String mensaje = "Pedido " + idpedido + " Editado Correctamente";
	        return new ResponseEntity<>(mensaje, HttpStatus.OK);
	    }

	    String mensaje2 = "Pedido " + idpedido + " no Editado";
	    return new ResponseEntity<>(mensaje2, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{idpedido}")
	public ResponseEntity<?> borrar(@PathVariable Integer idpedido) {
		PedidoCompra pedidoCompraDb = service.findbyid(idpedido);
	if(pedidoCompraDb != null) {
		service.delete(idpedido);
		String mensaje = "Pedido " + idpedido + " Borrado Correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.OK);
	}
	String mensaje1 = "Error al Eliminar este pedido: " + idpedido;
	return new ResponseEntity<>(mensaje1, HttpStatus.NOT_FOUND);
	}
	
}

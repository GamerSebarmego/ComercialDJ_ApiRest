package pe.edu.idat.controller;

import java.util.Collection;
import java.util.List;

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

import pe.edu.idat.model.DetallePedidoCompra;
import pe.edu.idat.service.DetallePedidoCompraService;

@RestController
@RequestMapping("/detallepedidocompra")
public class DetallePedidoCompraRestController {

	@Autowired
	private DetallePedidoCompraService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
	Collection<DetallePedidoCompra> itemDetallePedidoCompras = service.findall();
	return new ResponseEntity<>(itemDetallePedidoCompras,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{iddetalle}")
	public ResponseEntity<?> buscar(@PathVariable Integer iddetalle) {
		DetallePedidoCompra detallePedidoCompraDb = service.findbyid(iddetalle);
	    if (detallePedidoCompraDb != null) {
	        return new ResponseEntity<>(detallePedidoCompraDb, HttpStatus.OK);
	    } else {
	        String mensaje = "El detalle pedido compra " + iddetalle + " no se encontró.";
	        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
	    }
	}
	
    @GetMapping("/listarpedido/{idpedido}")
    public ResponseEntity<List<DetallePedidoCompra>> listarDetallesPorIdPedido(@PathVariable Integer idpedido) {
        List<DetallePedidoCompra> detalles = service.findByPedidoId(idpedido);
        
        if (detalles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody DetallePedidoCompra detallePedidoCompra) {
		
		service.insert(detallePedidoCompra);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{iddetalle}")
	public ResponseEntity<?> editar(@PathVariable Integer iddetalle, @RequestBody DetallePedidoCompra newDetallePedidoCompra) {
		DetallePedidoCompra detallePedidoCompraDb = service.findbyid(iddetalle);
	    if (detallePedidoCompraDb != null) {
	    	detallePedidoCompraDb.setCantidadproductos(newDetallePedidoCompra.getCantidadproductos());
	    	detallePedidoCompraDb.setCodproducto(newDetallePedidoCompra.getCodproducto());
	    	detallePedidoCompraDb.setIdpedido(newDetallePedidoCompra.getIdpedido());
	        service.update(detallePedidoCompraDb);

	        String mensaje = "Detalle " + iddetalle + " Editado Correctamente";
	        return new ResponseEntity<>(mensaje, HttpStatus.OK);
	    }

	    String mensaje2 = "Detalle " + iddetalle + " no Editado";
	    return new ResponseEntity<>(mensaje2, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{iddetalle}")
	public ResponseEntity<?> borrar(@PathVariable Integer iddetalle) {
		DetallePedidoCompra detallePedidoCompraDb = service.findbyid(iddetalle);
	if(detallePedidoCompraDb != null) {
		service.delete(iddetalle);
		String mensaje = "Producto " + iddetalle + " Borrado Correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.OK);
	}
	String mensaje1 = "Error al Eliminar este Producto: " + iddetalle;
	return new ResponseEntity<>(mensaje1, HttpStatus.NOT_FOUND);
	}
}

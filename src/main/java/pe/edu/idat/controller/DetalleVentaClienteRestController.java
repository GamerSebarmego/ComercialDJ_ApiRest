package pe.edu.idat.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.idat.model.DetalleVentaCliente;
import pe.edu.idat.service.DetalleVentaClienteService;

@Controller
@RequestMapping("/detalleventacliente")
public class DetalleVentaClienteRestController {

	@Autowired
	private DetalleVentaClienteService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
	Collection<DetalleVentaCliente> itemsDetalleVentaClientes = service.findall();
	return new ResponseEntity<>(itemsDetalleVentaClientes,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{iddetalle}")
	public ResponseEntity<?> buscar(@PathVariable Integer iddetalle) {
		DetalleVentaCliente DetalleVentaClienteDB = service.findbyid(iddetalle);
	    if (DetalleVentaClienteDB != null) {
	        return new ResponseEntity<>(DetalleVentaClienteDB, HttpStatus.OK);
	    } else {
	        String mensaje = "EL detalle de venta con el ID " + DetalleVentaClienteDB + " no se encontró.";
	        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody DetalleVentaCliente detalleVentaCliente) {
		service.insert(detalleVentaCliente);
		String mensaje = "EL detalle de venta: " + detalleVentaCliente.getIddetalle() + " se ingreso correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{iddetalle}")
	public ResponseEntity<?> editar(@PathVariable Integer iddetalle, @RequestBody DetalleVentaCliente newDetalleVentaCliente) {
	    DetalleVentaCliente DetalleVentaClienteDb = service.findbyid(iddetalle);
	    if (DetalleVentaClienteDb != null) {
	    	DetalleVentaClienteDb.setCodproducto(newDetalleVentaCliente.getCodproducto());
	    	DetalleVentaClienteDb.setCantidadproductos(newDetalleVentaCliente.getCantidadproductos());
	    	DetalleVentaClienteDb.setIddetalle(newDetalleVentaCliente.getIdventa());
	    	DetalleVentaClienteDb.setImportetotal(newDetalleVentaCliente.getImportetotal());

	        service.update(DetalleVentaClienteDb);

	        String mensaje = "EL detalle de venta " + iddetalle + " Editado Correctamente";
	        return new ResponseEntity<>(mensaje, HttpStatus.OK);
	    }

	    String mensaje2 = "EL detalle de venta " + iddetalle + " no Editado";
	    return new ResponseEntity<>(mensaje2, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{iddetalle}")
	public ResponseEntity<?> borrar(@PathVariable Integer iddetalle) {
		DetalleVentaCliente DetalleVentaClienteDb = service.findbyid(iddetalle);
	if(DetalleVentaClienteDb != null) {
		service.delete(iddetalle);
		String mensaje = "EL detalle de venta " + iddetalle + " Borrado Correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.OK);
	}
	String mensaje1 = "Error al Eliminar eL detalle de venta: " + iddetalle;
	return new ResponseEntity<>(mensaje1, HttpStatus.NOT_FOUND);
	}
	
}

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

import pe.edu.idat.model.VentaCliente;
import pe.edu.idat.service.VentaClienteService;

@RestController
@RequestMapping("/ventacliente")
public class VentaClienteRestController {

	@Autowired
	private VentaClienteService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
	Collection<VentaCliente> itemsVentaClientes = service.findall();
	return new ResponseEntity<>(itemsVentaClientes,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idventa}")
	public ResponseEntity<?> buscar(@PathVariable Integer idventa) {
		VentaCliente VentaClienteDB = service.findbyid(idventa);
	    if (VentaClienteDB != null) {
	        return new ResponseEntity<>(VentaClienteDB, HttpStatus.OK);
	    } else {
	        String mensaje = "La Venta Cliente con el ID " + VentaClienteDB + " no se encontró.";
	        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody VentaCliente ventaCliente) {
		service.insert(ventaCliente);
		String mensaje = "La Venta Cliente: " + ventaCliente.getIdventa() + " se ingreso correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{idventa}")
	public ResponseEntity<?> editar(@PathVariable Integer idventa, @RequestBody VentaCliente newVentaCliente) {
	    VentaCliente VentaClienteDb = service.findbyid(idventa);
	    if (VentaClienteDb != null) {
	    	VentaClienteDb.setNumerocomprobante(newVentaCliente.getNumerocomprobante());
	    	VentaClienteDb.setFechaventa(newVentaCliente.getFechaventa());
	    	VentaClienteDb.setIdusuario(newVentaCliente.getIdusuario());
	    	VentaClienteDb.setIdpago(newVentaCliente.getIdpago());

	        service.update(VentaClienteDb);

	        String mensaje = "Venta Cliente " + idventa + " Editado Correctamente";
	        return new ResponseEntity<>(mensaje, HttpStatus.OK);
	    }

	    String mensaje2 = "Venta Cliente " + idventa + " no Editado";
	    return new ResponseEntity<>(mensaje2, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{idventa}")
	public ResponseEntity<?> borrar(@PathVariable Integer idventa) {
		VentaCliente VentaClienteDb = service.findbyid(idventa);
	if(VentaClienteDb != null) {
		service.delete(idventa);
		String mensaje = "Venta Cliente " + idventa + " Borrado Correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.OK);
	}
	String mensaje1 = "Error al Eliminar este Venta Cliente: " + idventa;
	return new ResponseEntity<>(mensaje1, HttpStatus.NOT_FOUND);
	}
}

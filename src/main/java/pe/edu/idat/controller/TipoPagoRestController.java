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

import pe.edu.idat.model.TipoPago;
import pe.edu.idat.service.TipoPagoService;

@Controller
@RequestMapping("/tipopago")
public class TipoPagoRestController {

	@Autowired
	private TipoPagoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
	Collection<TipoPago> itemsTipoPagos = service.findall();
	return new ResponseEntity<>(itemsTipoPagos,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idpago}")
	public ResponseEntity<?> buscar(@PathVariable Integer idpago) {
		TipoPago TipoPagoDB = service.findbyid(idpago);
	    if (TipoPagoDB != null) {
	        return new ResponseEntity<>(TipoPagoDB, HttpStatus.OK);
	    } else {
	        String mensaje = "El Tipo de Pago con el ID " + TipoPagoDB + " no se encontró.";
	        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody TipoPago tipoPago) {
		service.insert(tipoPago);
		String mensaje = "El Tipo Pago: " + tipoPago.getIdpago() + " se ingreso correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{idpago}")
	public ResponseEntity<?> editar(@PathVariable Integer idpago, @RequestBody TipoPago newTipoPago) {
	    TipoPago TipoPagoDb = service.findbyid(idpago);
	    if (TipoPagoDb != null) {
	    	TipoPagoDb.setNombre(newTipoPago.getNombre());

	        service.update(TipoPagoDb);

	        String mensaje = "Tipo Pago " + idpago + " Editado Correctamente";
	        return new ResponseEntity<>(mensaje, HttpStatus.OK);
	    }

	    String mensaje2 = "Tipo Pago " + idpago + " no Editado";
	    return new ResponseEntity<>(mensaje2, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{idpago}")
	public ResponseEntity<?> borrar(@PathVariable Integer idpago) {
		TipoPago TipoPagoDb = service.findbyid(idpago);
	if(TipoPagoDb != null) {
		service.delete(idpago);
		String mensaje = "Tipo Pago " + idpago + " Borrado Correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.OK);
	}
	String mensaje1 = "Error al Eliminar este Tipo Pago: " + idpago;
	return new ResponseEntity<>(mensaje1, HttpStatus.NOT_FOUND);
	}
}

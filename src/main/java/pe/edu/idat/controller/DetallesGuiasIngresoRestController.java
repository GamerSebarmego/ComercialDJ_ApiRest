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

import pe.edu.idat.model.DetallesGuiasIngreso;
import pe.edu.idat.service.DetallesGuiasIngresoService;

@Controller
@RequestMapping("/detallesguiasingreso")
public class DetallesGuiasIngresoRestController {

	@Autowired
	private DetallesGuiasIngresoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
	Collection<DetallesGuiasIngreso> itemsDetallesGuiasIngresos = service.findall();
	return new ResponseEntity<>(itemsDetallesGuiasIngresos,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idguiaingreso}")
	public ResponseEntity<?> buscar(@PathVariable Integer idguiaingreso) {
		DetallesGuiasIngreso DetallesGuiasIngresoDB = service.findbyid(idguiaingreso);
	    if (DetallesGuiasIngresoDB != null) {
	        return new ResponseEntity<>(DetallesGuiasIngresoDB, HttpStatus.OK);
	    } else {
	        String mensaje = "La Guia de Ingreso con el ID " + DetallesGuiasIngresoDB + " no se encontró.";
	        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody DetallesGuiasIngreso detallesGuiasIngreso) {
		service.insert(detallesGuiasIngreso);
		String mensaje = "La Venta Cliente: " + detallesGuiasIngreso.getIdguiaingreso() + " se ingreso correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{idguiaingreso}")
	public ResponseEntity<?> editar(@PathVariable Integer idguiaingreso, @RequestBody DetallesGuiasIngreso newDetallesGuiasIngreso) {
	    DetallesGuiasIngreso DetallesGuiasIngresoDb = service.findbyid(idguiaingreso);
	    if (DetallesGuiasIngresoDb != null) {
	    	DetallesGuiasIngresoDb.setIdguia(newDetallesGuiasIngreso.getIdguia());
	    	DetallesGuiasIngresoDb.setCodproducto(newDetallesGuiasIngreso.getCodproducto());
	    	DetallesGuiasIngresoDb.setCantidad(newDetallesGuiasIngreso.getCantidad());

	        service.update(DetallesGuiasIngresoDb);

	        String mensaje = "Venta Cliente " + idguiaingreso + " Editado Correctamente";
	        return new ResponseEntity<>(mensaje, HttpStatus.OK);
	    }

	    String mensaje2 = "Venta Cliente " + idguiaingreso + " no Editado";
	    return new ResponseEntity<>(mensaje2, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{idguiaingreso}")
	public ResponseEntity<?> borrar(@PathVariable Integer idguiaingreso) {
		DetallesGuiasIngreso DetallesGuiasIngresoDb = service.findbyid(idguiaingreso);
	if(DetallesGuiasIngresoDb != null) {
		service.delete(idguiaingreso);
		String mensaje = "Guia de Ingreso " + idguiaingreso + " Borrado Correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.OK);
	}
	String mensaje1 = "Error al Eliminar la Guia de Ingreso: " + idguiaingreso;
	return new ResponseEntity<>(mensaje1, HttpStatus.NOT_FOUND);
	}
	
}

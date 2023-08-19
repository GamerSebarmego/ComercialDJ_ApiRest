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

import pe.edu.idat.model.Trabajador;
import pe.edu.idat.service.TrabajadorService;

@RestController
@RequestMapping("/trabajador")
public class TrabajadorRestController {

	@Autowired
	private TrabajadorService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
	Collection<Trabajador> itemsTrabajadors = service.findall();
	return new ResponseEntity<>(itemsTrabajadors,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{codtrabajador}")
	public ResponseEntity<?> buscar(@PathVariable String codtrabajador) {
		Trabajador trabajadorDB = service.findbyid(codtrabajador);
	    if (trabajadorDB != null) {
	        return new ResponseEntity<>(trabajadorDB, HttpStatus.OK);
	    } else {
	        String mensaje = "El Trabajador con el ID " + trabajadorDB + " no se encontró.";
	        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Trabajador trabajador) {
	    if (trabajador.getCodtrabajador() == null || trabajador.getCodtrabajador().isEmpty() ||
	        trabajador.getNombretrabajador() == null || trabajador.getNombretrabajador().isEmpty() ||
	        trabajador.getDireccion() == null || trabajador.getDireccion().isEmpty() ||
	        trabajador.getTelefono() == null || trabajador.getTelefono() == 0 || 
	        trabajador.getCorreo() == null || trabajador.getCorreo().isEmpty()) {
	        return new ResponseEntity<>("Faltan Datos",HttpStatus.BAD_REQUEST);
	    }

	    Trabajador existentTrabajador = service.findbyid(trabajador.getCodtrabajador());
	    if (existentTrabajador != null) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	    service.insert(trabajador);
	    return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{codtrabajador}")
	public ResponseEntity<?> editar(@PathVariable String codtrabajador, @RequestBody Trabajador newTrabajador) {
	    Trabajador TrabajadorDb = service.findbyid(codtrabajador);
	    if (TrabajadorDb != null) {
	        TrabajadorDb.setNombretrabajador(newTrabajador.getNombretrabajador());
	        TrabajadorDb.setDireccion(newTrabajador.getDireccion());
	        TrabajadorDb.setTelefono(newTrabajador.getTelefono());
	        TrabajadorDb.setCorreo(newTrabajador.getCorreo());

	        service.update(TrabajadorDb);

	        return new ResponseEntity<Void>(HttpStatus.OK);
	    }

	    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{codtrabajador}")
	public ResponseEntity<?> borrar(@PathVariable String codtrabajador) {
		Trabajador TrabajadorDb = service.findbyid(codtrabajador);
	if(TrabajadorDb != null) {
		service.delete(codtrabajador);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
}

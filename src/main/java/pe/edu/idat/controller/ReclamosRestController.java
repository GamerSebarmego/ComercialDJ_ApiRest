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

import pe.edu.idat.model.Reclamos;
import pe.edu.idat.service.ReclamosService;

@Controller
@RequestMapping("/reclamos")
public class ReclamosRestController {

	@Autowired
	private ReclamosService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
	Collection<Reclamos> itemsReclamoss = service.findall();
	return new ResponseEntity<>(itemsReclamoss,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idreclamo}")
	public ResponseEntity<?> buscar(@PathVariable Integer idreclamo) {
		Reclamos ReclamosDB = service.findbyid(idreclamo);
	    if (ReclamosDB != null) {
	        return new ResponseEntity<>(ReclamosDB, HttpStatus.OK);
	    } else {
	        String mensaje = "La Reclamos con el ID " + ReclamosDB + " no se encontró.";
	        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Reclamos reclamos) {
		service.insert(reclamos);
		String mensaje = "El Reclamos: " + reclamos.getIdreclamo() + " se ingreso correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{idreclamo}")
	public ResponseEntity<?> editar(@PathVariable Integer idreclamo, @RequestBody Reclamos newReclamos) {
	    Reclamos ReclamosDb = service.findbyid(idreclamo);
	    if (ReclamosDb != null) {
	    	ReclamosDb.setAsunto(newReclamos.getAsunto());
	    	ReclamosDb.setCuerporeclamo(newReclamos.getCuerporeclamo());
	    	ReclamosDb.setAdjuntos(newReclamos.getAdjuntos());
	    	ReclamosDb.setDni(newReclamos.getDni());
	    	ReclamosDb.setFechareclamo(newReclamos.getFechareclamo());

	        service.update(ReclamosDb);

	        String mensaje = "Reclamos " + idreclamo + " Editado Correctamente";
	        return new ResponseEntity<>(mensaje, HttpStatus.OK);
	    }

	    String mensaje2 = "Reclamos " + idreclamo + " no Editado";
	    return new ResponseEntity<>(mensaje2, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{idreclamo}")
	public ResponseEntity<?> borrar(@PathVariable Integer idreclamo) {
		Reclamos ReclamosDb = service.findbyid(idreclamo);
	if(ReclamosDb != null) {
		service.delete(idreclamo);
		String mensaje = "Reclamos " + idreclamo + " Borrado Correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.OK);
	}
	String mensaje1 = "Error al Eliminar este Reclamos: " + idreclamo;
	return new ResponseEntity<>(mensaje1, HttpStatus.NOT_FOUND);
	}
}

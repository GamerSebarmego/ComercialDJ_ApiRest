package pe.edu.idat.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

import pe.edu.idat.model.Vista;
import pe.edu.idat.service.VistaService;

@RestController
@RequestMapping("/vista")
public class VistaRestController {

	@Autowired
	private VistaService service;
	
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        Collection<Vista> itemsVistas = service.findall();
        
        Map<String, Collection<Vista>> response = new HashMap<>();
        response.put("products", itemsVistas);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@GetMapping("/buscar/{codvista}")
	public ResponseEntity<?> buscar(@PathVariable Integer codvista) {
		Vista VistaDB = service.findbyid(codvista);
	    if (VistaDB != null) {
	        return new ResponseEntity<>(VistaDB, HttpStatus.OK);
	    } else {
	        String mensaje = "La Vista con el ID " + VistaDB + " no se encontró.";
	        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Vista Vista) {
		service.insert(Vista);
		String mensaje = "El Vista: " + Vista.getCodvista() + " se ingreso correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{codvista}")
	public ResponseEntity<?> editar(@PathVariable Integer codvista, @RequestBody Vista newVista) {
	    Vista VistaDb = service.findbyid(codvista);
	    if (VistaDb != null) {
	    	VistaDb.setCodproducto(newVista.getCodproducto());
	    	VistaDb.setImagen(newVista.getImagen());
	    	VistaDb.setEstado(newVista.isEstado());

	        service.update(VistaDb);

	        String mensaje = "Vista " + codvista + " Editado Correctamente";
	        return new ResponseEntity<>(mensaje, HttpStatus.OK);
	    }

	    String mensaje2 = "Vista " + codvista + " no Editado";
	    return new ResponseEntity<>(mensaje2, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{codvista}")
	public ResponseEntity<?> borrar(@PathVariable Integer codvista) {
		Vista VistaDb = service.findbyid(codvista);
	if(VistaDb != null) {
		service.delete(codvista);
		String mensaje = "Vista " + codvista + " Borrado Correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.OK);
	}
	String mensaje1 = "Error al Eliminar este Vista: " + codvista;
	return new ResponseEntity<>(mensaje1, HttpStatus.NOT_FOUND);
	}
	
}

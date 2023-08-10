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

import pe.edu.idat.model.GuiasIngreso;
import pe.edu.idat.service.GuiasIngresoService;

@RestController
@RequestMapping("/guiasingreso")
public class GuiasIngresoRestController {

	@Autowired
	private GuiasIngresoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
	Collection<GuiasIngreso> itemsGuiasIngresos = service.findall();
	return new ResponseEntity<>(itemsGuiasIngresos,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idguia}")
	public ResponseEntity<?> buscar(@PathVariable Integer idguia) {
		GuiasIngreso GuiasIngresoDb = service.findbyid(idguia);
	    if (GuiasIngresoDb != null) {
	        return new ResponseEntity<>(GuiasIngresoDb, HttpStatus.OK);
	    } else {
	        String mensaje = "La Categoria con el ID " + idguia + " no se encontró.";
	        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody GuiasIngreso guiasIngreso) {
		service.insert(guiasIngreso);
		String mensaje = "La Guia: " + guiasIngreso.getIdguia() + " se ingreso correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{idguia}")
	public ResponseEntity<?> editar(@PathVariable Integer idguia, @RequestBody GuiasIngreso newGuiasIngreso) {
	    GuiasIngreso GuiasIngresoDb = service.findbyid(idguia);
	    if (GuiasIngresoDb != null) {
	    	GuiasIngresoDb.setNumeroguia(newGuiasIngreso.getNumeroguia());
	    	GuiasIngresoDb.setFecha(newGuiasIngreso.getFecha());
	    	GuiasIngresoDb.setRuc(newGuiasIngreso.getRuc());

	        service.update(GuiasIngresoDb);

	        String mensaje = "Guias de Ingreso " + idguia + " Editado Correctamente";
	        return new ResponseEntity<>(mensaje, HttpStatus.OK);
	    }

	    String mensaje2 = "Guias de Ingreso " + idguia + " no Editado";
	    return new ResponseEntity<>(mensaje2, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/borrar/{idguia}")
	public ResponseEntity<?> borrar(@PathVariable Integer idguia) {
		GuiasIngreso GuiasIngresoDb = service.findbyid(idguia);
	if(GuiasIngresoDb != null) {
		service.delete(idguia);
		String mensaje = "Guias de Ingreso " + idguia + " Borrado Correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.OK);
	}
	String mensaje1 = "Error al Eliminar la Guia de Ingreso: " + idguia;
	return new ResponseEntity<>(mensaje1, HttpStatus.NOT_FOUND);
	}
}

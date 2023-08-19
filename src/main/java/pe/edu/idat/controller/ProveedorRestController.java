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

import pe.edu.idat.model.Proveedor;
import pe.edu.idat.service.ProveedorService;

@RestController
@RequestMapping("/proveedor")
public class ProveedorRestController {

	@Autowired
	private ProveedorService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
	Collection<Proveedor> itemsProveedor = service.findall();
	return new ResponseEntity<>(itemsProveedor,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{ruc}")
	public ResponseEntity<?> buscar(@PathVariable String ruc) {
		Proveedor proveedorDb = service.findbyid(ruc);
	    if (proveedorDb != null) {
	        return new ResponseEntity<>(proveedorDb, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Proveedor proveedor) {
		service.insert(proveedor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{ruc}")
	public ResponseEntity<?> editar(@PathVariable String ruc, @RequestBody Proveedor newpProveedor) {
	    Proveedor proveedorDb = service.findbyid(ruc);
	    if (proveedorDb != null) {
	    	proveedorDb.setRepresentante(newpProveedor.getRepresentante());
	    	proveedorDb.setRazonsocial(newpProveedor.getRazonsocial());
	    	proveedorDb.setTelefono(newpProveedor.getTelefono());
	    	proveedorDb.setCorreo(newpProveedor.getCorreo());
	    	proveedorDb.setDireccion(newpProveedor.getDireccion());

	        service.update(proveedorDb);

	        return new ResponseEntity<Void>(HttpStatus.OK);
	    }

	    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/borrar/{ruc}")
	public ResponseEntity<?> borrar(@PathVariable String ruc) {
		Proveedor proveedorDb = service.findbyid(ruc);
	if(proveedorDb != null) {
		service.delete(ruc);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}

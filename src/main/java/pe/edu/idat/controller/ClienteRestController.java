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

import pe.edu.idat.model.Cliente;
import pe.edu.idat.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

	@Autowired
	private ClienteService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
	Collection<Cliente> itemsClientes = service.findall();
	return new ResponseEntity<>(itemsClientes,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{dni}")
	public ResponseEntity<?> buscar(@PathVariable Integer dni) {
		Cliente clienteDb = service.findbyid(dni);
	    if (clienteDb != null) {
	        return new ResponseEntity<>(clienteDb, HttpStatus.OK);
	    } else {
	        String mensaje = "El ciente con el DNI " + dni + " no se encontró.";
	        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Cliente cliente) {
		service.insert(cliente);
		String mensaje = "El cliente: " + cliente.getNombre() + cliente.getApellido() + " se ingreso correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{dni}")
	public ResponseEntity<?> editar(@PathVariable Integer dni, @RequestBody Cliente newCliente) {
	    Cliente clienteDb = service.findbyid(dni);
	    if (clienteDb != null) {
	    	clienteDb.setNombre(newCliente.getNombre());
	    	clienteDb.setApellido(newCliente.getApellido());
	    	clienteDb.setDireccion(newCliente.getDireccion());
	    	clienteDb.setReferencia(newCliente.getReferencia());
	    	clienteDb.setTelefono(newCliente.getTelefono());
	    	clienteDb.setCorreo(newCliente.getCorreo());
	    	clienteDb.setFechaingreso(newCliente.getFechaingreso());

	        service.update(clienteDb);

	        String mensaje = "Cliente con Dni " + dni + " Editado Correctamente";
	        return new ResponseEntity<>(mensaje, HttpStatus.OK);
	    }

	    String mensaje2 = "Cliente con DNI " + dni + " no Editado";
	    return new ResponseEntity<>(mensaje2, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{dni}")
	public ResponseEntity<?> borrar(@PathVariable Integer dni) {
		Cliente clienteDb = service.findbyid(dni);
	if(clienteDb != null) {
		service.delete(dni);
		String mensaje = "Cliente con DNI " + dni + " Borrado Correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.OK);
	}
	String mensaje1 = "Error al Eliminar este Ciente: " + dni;
	return new ResponseEntity<>(mensaje1, HttpStatus.NOT_FOUND);
	}
	
}

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

import pe.edu.idat.model.CategoriaProducto;
import pe.edu.idat.service.CategoriaProductoService;

@RestController
@RequestMapping("/categoriaproducto")
public class CategoriaProductoRestController {

	@Autowired
	private CategoriaProductoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
	Collection<CategoriaProducto> itemsCategoriaProductos = service.findall();
	return new ResponseEntity<>(itemsCategoriaProductos,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idcategoria}")
	public ResponseEntity<?> buscar(@PathVariable Integer idcategoria) {
		CategoriaProducto categoriaProductoDb = service.findbyid(idcategoria);
	    if (categoriaProductoDb != null) {
	        return new ResponseEntity<>(categoriaProductoDb, HttpStatus.OK);
	    } else {
	        String mensaje = "La Categoria con el ID " + idcategoria + " no se encontró.";
	        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody CategoriaProducto categoriaProducto) {
		service.insert(categoriaProducto);
		String mensaje = "La Categoria: " + categoriaProducto.getIdcategoria() + " se ingreso correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{idcategoria}")
	public ResponseEntity<?> editar(@PathVariable Integer idcategoria, @RequestBody CategoriaProducto newCategoriaProducto) {
	    CategoriaProducto categoriaProductoDb = service.findbyid(idcategoria);
	    if (categoriaProductoDb != null) {
	        categoriaProductoDb.setDescripcion(newCategoriaProducto.getDescripcion());
	        categoriaProductoDb.setEstado(newCategoriaProducto.isEstado());

	        service.update(categoriaProductoDb);

	        String mensaje = "Categoria " + idcategoria + " Editado Correctamente";
	        return new ResponseEntity<>(mensaje, HttpStatus.OK);
	    }

	    String mensaje2 = "Categoria " + idcategoria + " no Editado";
	    return new ResponseEntity<>(mensaje2, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/borrar/{idcategoria}")
	public ResponseEntity<?> borrar(@PathVariable Integer idcategoria) {
		CategoriaProducto categoriaProductoDb = service.findbyid(idcategoria);
	if(categoriaProductoDb != null) {
		service.delete(idcategoria);
		String mensaje = "Categoria " + idcategoria + " Borrado Correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.OK);
	}
	String mensaje1 = "Error al Eliminar este Juego: " + idcategoria;
	return new ResponseEntity<>(mensaje1, HttpStatus.NOT_FOUND);
	}
}

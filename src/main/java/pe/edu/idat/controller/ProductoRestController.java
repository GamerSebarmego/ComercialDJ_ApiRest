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

import pe.edu.idat.model.Producto;
import pe.edu.idat.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {

	@Autowired
	private ProductoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
	Collection<Producto> itemsProductos = service.findall();
	return new ResponseEntity<>(itemsProductos,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{codproducto}")
	public ResponseEntity<?> buscar(@PathVariable String codproducto) {
		Producto ProductoDb = service.findbyid(codproducto);
	    if (ProductoDb != null) {
	        return new ResponseEntity<>(ProductoDb, HttpStatus.OK);
	    } else {
	        String mensaje = "El producto con el codproducto " + codproducto + " no se encontró.";
	        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Producto producto) {
		service.insert(producto);
	    String mensajeDuplicacion = "El producto " + producto.getNombreproducto() + " a sido registrado correctamente";
	    return new ResponseEntity<>(mensajeDuplicacion, HttpStatus.CREATED);

	}

	@PutMapping("/editar/{codproducto}")
	public ResponseEntity<?> editar(@PathVariable String codproducto, @RequestBody Producto newProducto) {
	    Producto ProductoDb = service.findbyid(codproducto);
	    if (ProductoDb != null) {
	    	ProductoDb.setNombreproducto(newProducto.getNombreproducto());
	    	ProductoDb.setMarcaproducto(newProducto.getMarcaproducto());
	    	ProductoDb.setCategoriaProducto(newProducto.getCategoriaProducto());
	    	ProductoDb.setDescripcion(newProducto.getDescripcion());
	    	ProductoDb.setPreciocompra(newProducto.getPreciocompra());
	    	ProductoDb.setPrecioventa(newProducto.getPrecioventa());

	        service.update(ProductoDb);

	        String mensaje = "Producto con codproducto " + codproducto + " Editado Correctamente";
	        return new ResponseEntity<>(mensaje, HttpStatus.OK);
	    }

	    String mensaje2 = "Producto con codproducto " + codproducto + " no Editado";
	    return new ResponseEntity<>(mensaje2, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{codproducto}")
	public ResponseEntity<?> borrar(@PathVariable String codproducto) {
		Producto ProductoDb = service.findbyid(codproducto);
	if(ProductoDb != null) {
		service.delete(codproducto);
		String mensaje = "Producto con codproducto " + codproducto + " Borrado Correctamente";
		return new ResponseEntity<>(mensaje, HttpStatus.OK);
	}
	String mensaje1 = "Error al Eliminar este producto: " + codproducto;
	return new ResponseEntity<>(mensaje1, HttpStatus.NOT_FOUND);
	}
}

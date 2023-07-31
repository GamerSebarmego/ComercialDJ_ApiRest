package pe.edu.idat.dao;

import org.springframework.data.repository.CrudRepository;

import pe.edu.idat.model.Producto;

public interface ProductoDAO extends CrudRepository<Producto, String>{

}

package pe.edu.idat.dao;

import org.springframework.data.repository.CrudRepository;

import pe.edu.idat.model.Trabajador;

public interface TrabajadorDAO extends CrudRepository<Trabajador, String> {

}

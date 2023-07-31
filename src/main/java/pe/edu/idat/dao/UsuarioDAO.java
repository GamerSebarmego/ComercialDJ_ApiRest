package pe.edu.idat.dao;

import org.springframework.data.repository.CrudRepository;

import pe.edu.idat.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {

}

package pe.edu.idat.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.idat.model.Producto;
import pe.edu.idat.model.Vista;

@Service
public class A_DuplicateModelsService {

	@Autowired
	private EntityManager entityManager;
	
    @Transactional
    public void duplicarYModificarDatos() {
        List<Producto> datosOrigen = entityManager.createQuery("Select p from Producto p", Producto.class).getResultList();

        for (Producto datoOrigen : datosOrigen) {
            Vista nuevoDatoDestino = new Vista();
            nuevoDatoDestino.setCodproducto(datoOrigen.getCodproducto());
            nuevoDatoDestino.setImagen("Imagen no Insertada");
            nuevoDatoDestino.setEstado(true);
                        
            entityManager.persist(nuevoDatoDestino);
        }
    }
}

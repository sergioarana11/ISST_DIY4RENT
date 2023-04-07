package es.upm.isst.grupo07.diy4rent.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import es.upm.isst.grupo07.diy4rent.model.Herrramienta;
import es.upm.isst.grupo07.diy4rent.model.Categoria;

public interface HerramientaRepository extends CrudRepository<Herrramienta, String> {
    List<Herrramienta> findByTitulo(String nombre);

    List<Herrramienta> findByCategory(Categoria categoria);
}

package es.upm.isst.grupo07.diy4rent.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import es.upm.isst.grupo07.diy4rent.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    List<Usuario> findByUsuarios(String nombre);
}

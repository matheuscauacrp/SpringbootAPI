package springboot.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springboot.restapi.model.Usuario;
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
}

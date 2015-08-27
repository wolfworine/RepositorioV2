package pe.edu.cibertec.proyemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Usuario;

@Repository
public interface UsuarioRepository  extends CrudRepository<Usuario, Long>{

	    public final static String FIND_BY_USER= "SELECT u " + 
	            "FROM Usuario u " +
	            "WHERE u.c_email = :c_email";

		@Query(FIND_BY_USER)
		public List<Usuario> findbyUser( 
				@Param("c_email") String email);

}

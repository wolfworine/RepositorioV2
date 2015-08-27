package pe.edu.cibertec.proyemp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Ubicacion;

@Repository
public interface UbicacionRepository extends CrudRepository<Ubicacion, Long>{

	public final static String FIND_BY_CODIGO= "SELECT u " + 
            "FROM Ubicacion u " +
            "WHERE u.id = :id ";
	
	@Query(FIND_BY_CODIGO)
	Ubicacion findCod(@Param("id")  String id);

	
	
}

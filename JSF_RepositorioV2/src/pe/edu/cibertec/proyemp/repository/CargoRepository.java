package pe.edu.cibertec.proyemp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Cargo;

@Repository
public interface CargoRepository  extends CrudRepository<Cargo, Long>{
	public final static String FIND_BY_CODIGO= "SELECT c " + 
            "FROM Cargo c " +
            "WHERE c.id = :id ";
	
	public final static String FIND_BY_CODIGO2= "SELECT c " + 
            "FROM Cargo c " +
            "WHERE c.nombre = :nombre ";
	
	@Query(FIND_BY_CODIGO)
	Cargo findCod(@Param("id")String id);
	
	
	@Query(FIND_BY_CODIGO2)
	Cargo findCod2(@Param("nombre")String nombre);


}

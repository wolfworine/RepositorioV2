package pe.edu.cibertec.proyemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Suministro;

@Repository
public interface SuministroRepository extends CrudRepository<Suministro, Long>{

	
	public final static String FIND_BY_SUMINISTRO= "SELECT s " + 
            "FROM Suministro s " +
			"JOIN s.a_rol r " + 
            "WHERE r.id = :id";
	 @Query(FIND_BY_SUMINISTRO)
	List<Suministro> findSuministro(@Param("id")Long id);
	
/*	
	public final static String FIND_BY_SUMINISTRO= "SELECT s " + 
            "FROM Suministro s " +
            "WHERE s.id_rol = :id_rol";
	 @Query(FIND_BY_SUMINISTRO)
	public List<Suministro> findSuministro(@Param("id_rol") Long id_rol);
	 */
	 


}

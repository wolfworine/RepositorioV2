package pe.edu.cibertec.proyemp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Area;


@Repository
public interface AreaRepository  extends CrudRepository<Area, Long>{

	public final static String FIND_BY_CODIGO= "SELECT a " + 
            "FROM Area a " +
            "WHERE a.id = :id ";
	
	@Query(FIND_BY_CODIGO)
	Area findCod(@Param("id") String id);

	
	public final static String FIND_BY_CODIGO2= "SELECT a " + 
            "FROM Area a " +
            "WHERE a.nombre = :nombre ";
	
	@Query(FIND_BY_CODIGO2)
	Area findCod2(@Param("nombre") String nombre);

	
/*	public final static String FIND_BY_CODIGO_NOMBRE= "SELECT a " + 
	            "FROM Area a " +
	            "WHERE a.codigo = :codigo "+
	            "or a.area = :area";
	
	@Query(FIND_BY_CODIGO_NOMBRE)
	public List<Area> findByCodigoOrArea(
			@Param("codigo") String codigo,
			@Param("area") String area);*/


	

}

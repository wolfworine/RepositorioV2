package pe.edu.cibertec.proyemp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long>{

/*	
	@Query("select r from Rol r " +
			"Where r.b_area=:b_area")
	List<Rol> findRol(@Param("b_area")String area);

	@Query(value = "select r from Rol r " +
			"Where r.area=:area and r.id in "+
			"( select disctinct max(a.id_rol) from Atributo a where a.aplicacion=:aplicacion and r.id=a.id_rol) "+
			"order by r.id desc", nativeQuery = true)
	List<Rol> findRol2(@Param("area")String area,@Param("aplicacion")String aplicacion);

	@Query("select r from Rol r " +
			"Where r.b_area=:b_area order by r.c_cargo desc")
	List<Rol> findRol2(@Param("area")String area);

	
	@Query("select distinct r.c_cargo from Rol r " +
			"Where r.b_area=:b_area order by r.c_cargo asc")
	List<String> findCargo(@Param("b_area")String area);*/

	


}

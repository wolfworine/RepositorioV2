package pe.edu.cibertec.proyemp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Aplicacion;


@Repository
public interface AplicacionRepository  extends CrudRepository<Aplicacion, Long>{

/*	public final static String FIND_BY_CODIGO= "select r  " + 
            "FROM Rol r " +
            "WHERE r.id_area = :area ";

	@Query(FIND_BY_CODIGO)
	List<Aplicacion> findAtributo(@Param("area")String area);
*/
	
/*	public final static String FIND_BY_APLICACION_AREA= "SELECT a " + 
	            "FROM Area a " +
	            "WHERE a.codigo = :codigo ";
		
		
		@Query(FIND_BY_APLICACION_AREA)
		Area findCod(@Param("aplicacion") String aplicacion,@Param("area")String area);
		
		SELECT * FROM atributo a
		inner join rol r on r.id=a.id_rol
		where a.aplicacion="Portal" and r.area="ARQUITECTURA EMPRESARIAL";
			@Procedure(procedureName = "buscarArea")
		List<Aplicacion> findReporte(@Param("aplicacion")String aplicacion,@Param("area") String area);
		
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("ReadAddressById");
		query.setParameter("P_ADDRESS_ID", 12345);
		List<Address> result = query.getResultList();

		@Procedure(procedureName = "buscarArea")
		List<Reporte>  buscarArea(@Param("aplicacion")String aplicacion,@Param("area") String area);
		
			@Query("select a from Atributo a " +
			"Where a.id_rol=:id_rol and a.aplicacion=:aplicacion")
	List<Aplicacion> findApp(@Param("id_rol") String id_rol,@Param("aplicacion")String aplicacion);

	 */




}

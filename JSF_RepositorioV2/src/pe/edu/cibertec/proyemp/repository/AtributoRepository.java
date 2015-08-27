package pe.edu.cibertec.proyemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Atributo;

@Repository
public interface AtributoRepository extends CrudRepository<Atributo, Long>{

	public final static String FIND_BY_PARAMETRO= "SELECT d " + 
            "FROM Atributo a " + 
            "JOIN a.d_detalle d";
	 @Query(FIND_BY_PARAMETRO)
	    public List<Atributo> findParametro();


	 public final static String FIND_BY_PARAMETRO3= "SELECT atri " + 
	            "FROM Atributo atri " +
	            "JOIN atri.a_aplicacion a " +
	            "JOIN atri.b_rol r " +
	            "JOIN atri.c_suministro s " +
	            "JOIN atri.d_detalle d "+
	            "WHERE a.codigo= :aplicacion "+
	            "and s.id = :id_suministro "+
	            "and r.id = :id_rol "+
	            "and d.d_parametro = :parametro ";
	            	 
	@Query(FIND_BY_PARAMETRO3)
	public List<Atributo> findParametro3(@Param("aplicacion") Long aplicacions,@Param("id_rol") Long id_rol,
			@Param("id_suministro") Long id_suministro,@Param("parametro") String parametro);

	 public final static String FIND_BY_PARAMETRO2= "SELECT atri " + 
	            "FROM Atributo atri " +
	            "JOIN atri.b_rol r " +
	            "JOIN atri.c_suministro s " +
	            "JOIN atri.d_detalle d "+
	            "WHERE s.id = :id_suministro "+
	            "and r.id = :id_rol "+
	            "and d.d_parametro = :parametro ";
	
	@Query(FIND_BY_PARAMETRO2)
	public List<Atributo> findParametro2(@Param("id_rol") Long id_rol,@Param("id_suministro")  Long id_suministro,
			@Param("parametro") String parametro);

	 public final static String FIND_BY_ATRIBUTO= "SELECT atri " + 
	            "FROM Atributo atri " +
	            "JOIN atri.b_rol r " +
	            "JOIN atri.c_suministro s " +
	            "JOIN atri.d_detalle d "+
	            "WHERE s.id = :id_suministro "+
	            "and r.id = :id_rol "+
	            "and d.d_parametro = :parametro ";
	@Query(FIND_BY_ATRIBUTO)
	public List<Atributo> findAtributo(String id, Long codigo);
	

/*		public final static String FIND_BY_PARAMETRO= "SELECT d " + 
	            "FROM Atributo a " + 
	            " JOIN a.d_detalle d" +
	            " WHERE a.a_rol.id = :id_rol "+
	            "and a.c_suministro.id = :id_suministro "+
	            "and d.d_parametro = :d_parametro";
	 
    @Query(FIND_BY_PARAMETRO)
    public List<Atributo> findParametro(@Param("id_rol") Long id_rol,
    		@Param("id_suministro") Long id_suministro,
    		@Param("d_parametro") String parametro);*/
    
/*	public final static String FIND_BY_PARAMETRO2= "SELECT s " + 
            "FROM Atributo s " +
            "WHERE s.id_rol = :id_rol "+
            "and s.id_suministro = :id_suministro "+
            "and s.parametro = :parametro "+
            "and s.aplicacion= :aplicacion";
    @Query(FIND_BY_PARAMETRO2)
	public List<Atributo> findParametro2(@Param("id_rol") Long id_rol,@Param("id_suministro") Long id_suministro,@Param("parametro") 
			String parametro,@Param("aplicacion")  String aplicacion);
*/
}

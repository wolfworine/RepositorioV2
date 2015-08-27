package pe.edu.cibertec.proyemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Detalle;

@Repository
public interface DetalleRepository extends CrudRepository<Detalle, Long>{

	public final static String FIND_BY_CODIGO= "SELECT d " + 
            "FROM Detalle d " +
            "WHERE d.d_parametro = :d_parametro ";
	
	@Query(FIND_BY_CODIGO)
	public List<Detalle> findParametro(@Param("d_parametro") String parametro);

	
	public final static String FIND_BY_IDPARAMETRO= "SELECT d " + 
            "FROM Detalle d " +
            "WHERE d.b_atributo_codigo = :b_atributo_codigo and "+
            "d.d_parametro = :d_parametro ";
	@Query(FIND_BY_IDPARAMETRO)
	public List<Detalle>  findIdParametro(@Param("b_atributo_codigo")String atributo_codigo,@Param("d_parametro") String parametro);


}

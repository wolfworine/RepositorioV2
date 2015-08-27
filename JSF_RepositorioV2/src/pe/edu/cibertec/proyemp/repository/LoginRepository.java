package pe.edu.cibertec.proyemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.cibertec.proyemp.model.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long>{

    public final static String FIND_BY_EMAIL_PASSWORD= "SELECT p " + 
            "FROM Login p " +
            "WHERE p.email = :email "+
            "and p.password = :password";
    
	@Query(FIND_BY_EMAIL_PASSWORD)
	public List<Login> findbyEmailandPassword( 
			@Param("email") String email,
			@Param("password") String password);

	
	@Modifying
	@Transactional
	@Query("UPDATE Login SET email = :email, password = :password where id = :id")
	public void update(@Param("id")Long id,@Param("password") String password,@Param("email") String email);




}

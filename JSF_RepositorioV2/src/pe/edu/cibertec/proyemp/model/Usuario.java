package pe.edu.cibertec.proyemp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID",nullable=false,unique=true)
	private Long id;
	
	@Column(name="NOMBRE",nullable=false,length=100)
	private String a_firstname;
	
	@Column(name="APELLIDO",nullable=false,length=100)
	private String b_lastname;
	
	@Column(name="EMAIL",nullable=false,length=100)
	private String c_email;
	
	@Column(name="PASSWORD",nullable=false,length=100)
	private String d_password;

	public Usuario() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getA_firstname() {
		return a_firstname;
	}

	public void setA_firstname(String a_firstname) {
		this.a_firstname = a_firstname;
	}

	public String getB_lastname() {
		return b_lastname;
	}

	public void setB_lastname(String b_lastname) {
		this.b_lastname = b_lastname;
	}

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	public String getD_password() {
		return d_password;
	}

	public void setD_password(String d_password) {
		this.d_password = d_password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", a_firstname=" + a_firstname
				+ ", b_lastname=" + b_lastname + ", c_email=" + c_email
				+ ", d_password=" + d_password + "]";
	}






	
}

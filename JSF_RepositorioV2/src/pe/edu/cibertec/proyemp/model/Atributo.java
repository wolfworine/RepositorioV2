package pe.edu.cibertec.proyemp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "atributo")
public class Atributo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ATRIBUTO",nullable=false,unique=true)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_APLICACION")
	private Aplicacion a_aplicacion=new Aplicacion();
		
	@ManyToOne
	@JoinColumn(name="ID_ROL")
	private Rol b_rol= new Rol();

	@ManyToOne
	@JoinColumn(name="ID_SUMINISTRO")
	private Suministro c_suministro=new Suministro();
	
	@ManyToOne
	@JoinColumn(name="ID_DETALLE")
	private Detalle d_detalle=new Detalle();
	
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private Estado e_estado=new Estado();
	
	public Atributo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aplicacion getA_aplicacion() {
		return a_aplicacion;
	}

	public void setA_aplicacion(Aplicacion a_aplicacion) {
		this.a_aplicacion = a_aplicacion;
	}

	public Rol getB_rol() {
		return b_rol;
	}

	public void setB_rol(Rol b_rol) {
		this.b_rol = b_rol;
	}

	public Suministro getC_suministro() {
		return c_suministro;
	}

	public void setC_suministro(Suministro c_suministro) {
		this.c_suministro = c_suministro;
	}

	public Detalle getD_detalle() {
		return d_detalle;
	}

	public void setD_detalle(Detalle d_detalle) {
		this.d_detalle = d_detalle;
	}

	public Estado getE_estado() {
		return e_estado;
	}

	public void setE_estado(Estado e_estado) {
		this.e_estado = e_estado;
	}

	@Override
	public String toString() {
		return "Atributo [id=" + id + ", a_aplicacion=" + a_aplicacion
				+ ", b_rol=" + b_rol + ", c_suministro=" + c_suministro
				+ ", d_detalle=" + d_detalle + ", e_estado=" + e_estado + "]";
	}

	
	
	
	
	
	
}

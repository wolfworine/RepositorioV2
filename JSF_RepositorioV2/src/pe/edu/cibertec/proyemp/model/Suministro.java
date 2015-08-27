package pe.edu.cibertec.proyemp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "suministro")
public class Suministro implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_SUMINISTRO",nullable=false,unique=true)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_ROL")
	private Rol a_rol=new Rol();
	

	@Column(name="NOMBRE", nullable=false, length=200)
	private String b_nombre;
	
	@Column(name="PRIORIDAD", nullable=false, length=200)
	private String c_prioridad;
	
	@OneToMany(mappedBy="c_suministro",cascade = CascadeType.PERSIST)
	private List<Atributo> atributo= new ArrayList<Atributo>();

	public Suministro() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Rol getA_rol() {
		return a_rol;
	}

	public void setA_rol(Rol a_rol) {
		this.a_rol = a_rol;
	}

	public String getB_nombre() {
		return b_nombre;
	}

	public void setB_nombre(String b_nombre) {
		this.b_nombre = b_nombre;
	}

	public String getC_prioridad() {
		return c_prioridad;
	}

	public void setC_prioridad(String c_prioridad) {
		this.c_prioridad = c_prioridad;
	}

	@Override
	public String toString() {
		return "Suministro [id=" + id + ", a_rol=" + a_rol + ", b_nombre="
				+ b_nombre + ", c_prioridad=" + c_prioridad + "]";
	}

	public List<Atributo> getAtributo() {
		return atributo;
	}

	public void setAtributo(List<Atributo> atributo) {
		this.atributo = atributo;
	}



	
	
	
}

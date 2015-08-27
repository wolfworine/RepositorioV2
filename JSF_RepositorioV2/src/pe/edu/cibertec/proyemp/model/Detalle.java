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
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "detalle")
public class Detalle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DETALLE",nullable=false,unique=true)
	private Long a_id;
	
	@Column(name="ATRIBUTO_CODIGO",nullable=false,length=200)
	private String b_atributo_codigo;
		
	@Column(name="ATRIBUTO_NOMBRE",nullable=false,length=400)
	private String c_atributo_nombre;
	
	@Column(name="PARAMETRO",nullable=false,length=200)
	private String d_parametro;
	
	@OneToMany(mappedBy="d_detalle",cascade = CascadeType.PERSIST)
	private List<Atributo> atributo= new ArrayList<Atributo>();

	public Detalle() {
		super();
	}

	public Long getA_id() {
		return a_id;
	}

	public void setA_id(Long a_id) {
		this.a_id = a_id;
	}

	public String getB_atributo_codigo() {
		return b_atributo_codigo;
	}

	public void setB_atributo_codigo(String b_atributo_codigo) {
		this.b_atributo_codigo = b_atributo_codigo;
	}

	public String getC_atributo_nombre() {
		return c_atributo_nombre;
	}

	public void setC_atributo_nombre(String c_atributo_nombre) {
		this.c_atributo_nombre = c_atributo_nombre;
	}

	public String getD_parametro() {
		return d_parametro;
	}

	public void setD_parametro(String d_parametro) {
		this.d_parametro = d_parametro;
	}

	public List<Atributo> getAtributo() {
		return atributo;
	}

	public void setAtributo(List<Atributo> atributo) {
		this.atributo = atributo;
	}

	@Override
	public String toString() {
		return "Detalle [a_id=" + a_id + ", b_atributo_codigo="
				+ b_atributo_codigo + ", c_atributo_nombre="
				+ c_atributo_nombre + ", d_parametro=" + d_parametro + "]";
	}






	

	
}

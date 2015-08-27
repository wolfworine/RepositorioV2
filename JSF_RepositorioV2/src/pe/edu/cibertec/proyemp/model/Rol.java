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
@Table(name = "rol")
public class Rol implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ROL",nullable=false,unique=true)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_UBICACION",referencedColumnName="ID")
	private Ubicacion a_ubicacion=new Ubicacion();
		
	@ManyToOne
	@JoinColumn(name="ID_AREA",referencedColumnName="ID")
	private Area b_area=new Area();

	@ManyToOne
	@JoinColumn(name="ID_CARGO",referencedColumnName="ID")
	private Cargo c_cargo=new Cargo();
	
	@Column(name="NOMBRE", nullable=false, length=200)
	private String a_nombre;

	@Column(name="DESCRIPCION", nullable=false, length=200)
	private String b_descripcion;
	
	@Column(name="TIPO", nullable=false, length=200)
	private String c_tipo; 
	
	@Column(name="REGLA_NEGOCIO", nullable=false, length=200)
	private String d_regla_negocio;
	
	@Column(name="AMBITO", nullable=false, length=200)
	private String e_ambito;
	
	@Column(name="PROPIETARIO_ROL", nullable=false, length=200)
	private String f_propietario_rol;
	
	@Column(name="PROPIETARIO_PERSONA", nullable=false, length=200)
	private String g_propietario_persona;
	
	@Column(name="SITUACION", nullable=false, length=45)
	private String h_situacion;
	
	@Column(name="ROL_BASE", nullable=false, length=3)
	private String i_rol_base;
	
	@OneToMany(mappedBy="a_rol",cascade = CascadeType.PERSIST)
	private List<Suministro> suministro= new ArrayList<Suministro>();
	
	@OneToMany(mappedBy="b_rol",cascade = CascadeType.PERSIST)
	private List<Atributo> atributo= new ArrayList<Atributo>();
	
	public Rol() {
		super();
	}

	
	public Rol(Long id, Ubicacion a_ubicacion, Area b_area, Cargo c_cargo,
			String a_nombre, String b_descripcion, String c_tipo,
			String d_regla_negocio, String e_ambito, String f_propietario_rol,
			String g_propietario_persona, String h_situacion, String i_rol_base) {
		super();
		this.id = id;
		this.a_ubicacion = a_ubicacion;
		this.b_area = b_area;
		this.c_cargo = c_cargo;
		this.a_nombre = a_nombre;
		this.b_descripcion = b_descripcion;
		this.c_tipo = c_tipo;
		this.d_regla_negocio = d_regla_negocio;
		this.e_ambito = e_ambito;
		this.f_propietario_rol = f_propietario_rol;
		this.g_propietario_persona = g_propietario_persona;
		this.h_situacion = h_situacion;
		this.i_rol_base = i_rol_base;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ubicacion getA_ubicacion() {
		return a_ubicacion;
	}

	public void setA_ubicacion(Ubicacion a_ubicacion) {
		this.a_ubicacion = a_ubicacion;
	}

	public Area getB_area() {
		return b_area;
	}

	public void setB_area(Area b_area) {
		this.b_area = b_area;
	}

	public Cargo getC_cargo() {
		return c_cargo;
	}

	public void setC_cargo(Cargo c_cargo) {
		this.c_cargo = c_cargo;
	}

	public String getA_nombre() {
		return a_nombre;
	}

	public void setA_nombre(String a_nombre) {
		this.a_nombre = a_nombre;
	}

	public String getB_descripcion() {
		return b_descripcion;
	}

	public void setB_descripcion(String b_descripcion) {
		this.b_descripcion = b_descripcion;
	}

	public String getC_tipo() {
		return c_tipo;
	}

	public void setC_tipo(String c_tipo) {
		this.c_tipo = c_tipo;
	}

	public String getD_regla_negocio() {
		return d_regla_negocio;
	}

	public void setD_regla_negocio(String d_regla_negocio) {
		this.d_regla_negocio = d_regla_negocio;
	}

	public String getE_ambito() {
		return e_ambito;
	}

	public void setE_ambito(String e_ambito) {
		this.e_ambito = e_ambito;
	}

	public String getF_propietario_rol() {
		return f_propietario_rol;
	}

	public void setF_propietario_rol(String f_propietario_rol) {
		this.f_propietario_rol = f_propietario_rol;
	}

	public String getG_propietario_persona() {
		return g_propietario_persona;
	}

	public void setG_propietario_persona(String g_propietario_persona) {
		this.g_propietario_persona = g_propietario_persona;
	}

	public String getH_situacion() {
		return h_situacion;
	}

	public void setH_situacion(String h_situacion) {
		this.h_situacion = h_situacion;
	}

	public String getI_rol_base() {
		return i_rol_base;
	}

	public void setI_rol_base(String i_rol_base) {
		this.i_rol_base = i_rol_base;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", a_ubicacion=" + a_ubicacion + ", b_area="
				+ b_area + ", c_cargo=" + c_cargo + ", a_nombre=" + a_nombre
				+ ", b_descripcion=" + b_descripcion + ", c_tipo=" + c_tipo
				+ ", d_regla_negocio=" + d_regla_negocio + ", e_ambito="
				+ e_ambito + ", f_propietario_rol=" + f_propietario_rol
				+ ", g_propietario_persona=" + g_propietario_persona
				+ ", h_situacion=" + h_situacion + ", i_rol_base=" + i_rol_base
				+ "]";
	}

	public List<Suministro> getSuministro() {
		return suministro;
	}

	public void setSuministro(List<Suministro> suministro) {
		this.suministro = suministro;
	}

	public List<Atributo> getAtributo() {
		return atributo;
	}

	public void setAtributo(List<Atributo> atributo) {
		this.atributo = atributo;
	}

	
	
	

/*	public Collection<Suministro> getSuministro() {
		return suministro;
	}

	public void setSuministro(Collection<Suministro> suministro) {
		this.suministro = suministro;
	}

	public Collection<Atributo> getAtributo() {
		return atributo;
	}

	public void setAtributo(Collection<Atributo> atributo) {
		this.atributo = atributo;
	}
*/




	
	
}

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


/**
 * The persistent class for the aplicacion database table.
 * 
 */
@Entity
@Table(name = "aplicacion")
public class Aplicacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID",nullable=false,unique=true)
	private Long codigo;

	@Column(name="ID_APLICACION", nullable=false, length=20)
	private String id;
	
	@Column(name="NOMBRE", nullable=false, length=200)
	private String nombre;
	
	@OneToMany(mappedBy="a_aplicacion",cascade = CascadeType.PERSIST)
	private List<Atributo> atributo= new ArrayList<Atributo>();

	public Aplicacion() {
		super();
	}


	public Long getCodigo() {
		return codigo;
	}




	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Aplicacion [codigo=" + codigo + ", id=" + id + ", nombre="
				+ nombre + "]";
	}


	public List<Atributo> getAtributo() {
		return atributo;
	}


	public void setAtributo(List<Atributo> atributo) {
		this.atributo = atributo;
	}

	
	


}

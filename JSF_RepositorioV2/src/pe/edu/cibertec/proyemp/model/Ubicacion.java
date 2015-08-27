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
@Table(name = "ubicacion")

public class Ubicacion  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID",nullable=false,unique=true)
	private Long codigo;

	@Column(name="ID_UBICACION",nullable=false,length=50)
	private String id;
	
	@OneToMany(mappedBy="a_ubicacion",cascade = CascadeType.PERSIST)
	private List<Rol> rol= new ArrayList<Rol>();
	
	@Column(name="DESCRIPCION", nullable=false, length=200)
	private String ubicacion;
	
	public Ubicacion() {
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



	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}



	@Override
	public String toString() {
		return "Ubicacion [codigo=" + codigo + ", id=" + id + ", ubicacion="
				+ ubicacion + "]";
	}



	public List<Rol> getRol() {
		return rol;
	}



	public void setRol(List<Rol> rol) {
		this.rol = rol;
	}







}
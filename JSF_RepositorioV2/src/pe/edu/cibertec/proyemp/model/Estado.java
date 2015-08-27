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
 * The persistent class for the estado database table.
 * 
 */
@Entity
@Table(name = "estado")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ESTADO",nullable=false,unique=true)
	private Long id;


	@Column(name="NOMBRE", nullable=false, length=45)
	private String nombre;
	
	@OneToMany(mappedBy="e_estado",cascade = CascadeType.PERSIST)
	private List<Atributo> atributo= new ArrayList<Atributo>();

	public Estado() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Atributo> getAtributo() {
		return atributo;
	}

	public void setAtributo(List<Atributo> atributo) {
		this.atributo = atributo;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nombre=" + nombre + "]";
	}


	
	

}
package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.edu.cibertec.proyemp.model.Ubicacion;
import pe.edu.cibertec.proyemp.service.UbicacionService;

import com.google.common.collect.Lists;


@ManagedBean
@SessionScoped
public class UbicacionManagedBean {
	
	private List<Ubicacion> ubicaciones= new ArrayList<Ubicacion>();
	
	private Ubicacion selecUbicacion= new Ubicacion();
	
	private Ubicacion ubicacion= new Ubicacion();

	@ManagedProperty(value = "#{ubicacionService}")
	private UbicacionService ubicacionService;
	
	@PostConstruct
	public void init(){
		ubicaciones = Lists.newArrayList(
				ubicacionService.getUbicacionRepository().findAll());
	}

	public String  nuevo() {
		return "/paginas/ubicacion/editar.xhtml?faces-redirect=true";
	}
	
	public String  editar() {
		return "/paginas/ubicacion/modificar.xhtml?faces-redirect=true";
	}
	
	public String  volver() {
		return "/paginas/ubicacion/mantenimiento.xhtml?faces-redirect=true";
	}
	
	public String  registrar() {
		ubicacionService.getUbicacionRepository().save(ubicacion);
		ubicacion = new Ubicacion();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + ubicacion.getUbicacion() + " ingresado"
				));
		return "/paginas/ubicacion/mantenimiento.xhtml?faces-redirect=true";
	}
	
	
	public String  modificar() {
		System.out.println(selecUbicacion);
		ubicacionService.getUbicacionRepository().save(selecUbicacion);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + selecUbicacion.getUbicacion()+ " Actualizado"
				));
		return "/paginas/ubicacion/mantenimiento.xhtml?faces-redirect=true";
	}
	

	public List<Ubicacion> getUbicaciones() {
		ubicaciones = Lists.newArrayList(
				ubicacionService.getUbicacionRepository().findAll());
		return ubicaciones;
	}

	public void setUbicaciones(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public Ubicacion getSelecUbicacion() {
		return selecUbicacion;
	}

	public void setSelecUbicacion(Ubicacion selecUbicacion) {
		this.selecUbicacion = selecUbicacion;
	}

	public UbicacionService getUbicacionService() {
		return ubicacionService;
	}

	public void setUbicacionService(UbicacionService ubicacionService) {
		this.ubicacionService = ubicacionService;
	}


	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	

}

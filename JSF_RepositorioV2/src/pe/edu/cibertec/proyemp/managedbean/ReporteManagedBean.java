package pe.edu.cibertec.proyemp.managedbean;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import pe.edu.cibertec.proyemp.model.Aplicacion;
import pe.edu.cibertec.proyemp.model.Area;
import pe.edu.cibertec.proyemp.model.Atributo;
import pe.edu.cibertec.proyemp.service.AtributoService;

@ManagedBean
@SessionScoped
public class ReporteManagedBean{
	
	private List<Atributo> atributos = new ArrayList<Atributo>();
	
	private Area selecArea = new Area();
	
	private Aplicacion selecAplicacion= new Aplicacion();
	
	@ManagedProperty(value = "#{atributoService}")
	private AtributoService atributoService;

		

	public  String reporte() {
		atributos=atributoService.getAtributoRepository().findAtributo(selecAplicacion.getId(),selecArea.getCodigo());
		return  "/paginas/reporte/vista.xhtml?faces-redirect=true";
	

	}

	

	
    public void save(ActionEvent actionEvent) {
        addMessage("Data saved");
    }
     
    public void update(ActionEvent actionEvent) {
        addMessage("Data updated");
    }
     
    public void delete(ActionEvent actionEvent) {
        addMessage("Data deleted");
    }
 
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }




	public List<Atributo> getAtributos() {
		return atributos;
	}




	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}




	public Area getSelecArea() {
		return selecArea;
	}




	public void setSelecArea(Area selecArea) {
		this.selecArea = selecArea;
	}




	public Aplicacion getSelecAplicacion() {
		return selecAplicacion;
	}




	public void setSelecAplicacion(Aplicacion selecAplicacion) {
		this.selecAplicacion = selecAplicacion;
	}




	public AtributoService getAtributoService() {
		return atributoService;
	}




	public void setAtributoService(AtributoService atributoService) {
		this.atributoService = atributoService;
	}
	
/*	public String buscar() {
		filteredAreas =		areaService.getAreaRepository().
				findByCodigoOrArea(busqueda.getCodigo(), busqueda.getArea());
		return null;
	}*/
	
	
	

	
	
}

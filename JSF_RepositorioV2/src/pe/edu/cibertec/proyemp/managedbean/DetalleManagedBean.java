package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.edu.cibertec.proyemp.model.Detalle;
import pe.edu.cibertec.proyemp.service.DetalleService;

@ManagedBean
@SessionScoped
public class DetalleManagedBean {

	private List<Detalle> droles = new ArrayList<Detalle>();
	private List<Detalle> dgrupos = new ArrayList<Detalle>();
	private List<Detalle> dinbox = new ArrayList<Detalle>();
	private List<Detalle> ddefaultinbox = new ArrayList<Detalle>();	
	
	private String rolesa;
	private String gruposa;
	private String inboxa;
	private String defaultinboxa;
	
	private String parametro;
	
	private Detalle selecDetalle = new Detalle();
	
	private Detalle detalle= new Detalle();
	
	@ManagedProperty(value = "#{detalleService}")
	private DetalleService detalleService;
	
	
	@PostConstruct
	public void init(){
		
		rolesa="ROLES";
		gruposa="GRUPOS";
		inboxa="INBOX";
		defaultinboxa="DEFAULTINBOX";
		droles=  detalleService.getDetalleRepository().findParametro(rolesa);
		dgrupos=  detalleService.getDetalleRepository().findParametro(gruposa);
		dinbox=  detalleService.getDetalleRepository().findParametro(inboxa);
		ddefaultinbox=  detalleService.getDetalleRepository().findParametro(defaultinboxa);
		
		System.out.println("droles" +droles);
		System.out.println("dgrupos" +dgrupos);
		System.out.println("dinbox" +dinbox);
		System.out.println("ddefaultinbox" +ddefaultinbox);
	}

	// Detalle atributo
		// Atributo Roles
		public String  nuevo_rol() {
			detalle.setD_parametro("ROLES");
			parametro="Roles";
			return "/paginas/detalle/editar.xhtml?faces-redirect=true";
		}
		
		public String  editar_rol() {
			parametro="Roles";
			return "/paginas/detalle/modificar.xhtml?faces-redirect=true";
		}
		
		// Atributo Grupos
		public String  nuevo_grupo() {
			detalle.setD_parametro("GRUPOS");
			parametro="Grupos";
			return "/paginas/detalle/editar.xhtml?faces-redirect=true";
		}
		
		public String  editar_grupo() {	
			parametro="Grupos";
			return "/paginas/detalle/modificar.xhtml?faces-redirect=true";
		}
		
		// Atributo Inbox 
		public String  nuevo_inbox() {
			parametro="Inbox";
			detalle.setD_parametro("INBOX");
			return "/paginas/detalle/editar.xhtml?faces-redirect=true";
		}
		
		public String  editar_inbox() {

			parametro="Inbox";
			return "/paginas/detalle/modificar.xhtml?faces-redirect=true";
		}
		
		// Atributo Default Inbox
		public String  nuevo_defaultinbox() {
			parametro="Default Inbox";
			detalle.setD_parametro("DEFAULTINBOX");
			return "/paginas/detalle/editar.xhtml?faces-redirect=true";
		}
		
		public String  editar_defaultinbox() {
			parametro="Default Inbox";
			return "/paginas/detalle/modificar.xhtml?faces-redirect=true";
		}
		
		public String  volver() {
			return "/paginas/detalle/mantenimiento.xhtml?faces-redirect=true";
		}
		
		public String  registrar() {
			detalleService.getDetalleRepository().save(detalle);
			detalle = new Detalle();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Registro " + detalle.getC_atributo_nombre()+ " ingresado"
					));
			droles=  detalleService.getDetalleRepository().findParametro(rolesa);
			dgrupos=  detalleService.getDetalleRepository().findParametro(gruposa);
			dinbox=  detalleService.getDetalleRepository().findParametro(inboxa);
			ddefaultinbox=  detalleService.getDetalleRepository().findParametro(defaultinboxa);
			return "/paginas/detalle/mantenimiento.xhtml?faces-redirect=true";
		}
		
		
		public String  modificar() {
			detalleService.getDetalleRepository().save(selecDetalle);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Registro " + selecDetalle.getC_atributo_nombre()+ " Actualizado"
					));
			droles=  detalleService.getDetalleRepository().findParametro(rolesa);
			dgrupos=  detalleService.getDetalleRepository().findParametro(gruposa);
			dinbox=  detalleService.getDetalleRepository().findParametro(inboxa);
			ddefaultinbox=  detalleService.getDetalleRepository().findParametro(defaultinboxa);
			return "/paginas/detalle/mantenimiento.xhtml?faces-redirect=true";
		}
	

	public List<Detalle> getDroles() {
		return droles;
	}


	public void setDroles(List<Detalle> droles) {
		this.droles = droles;
	}


	public List<Detalle> getDgrupos() {
		return dgrupos;
	}


	public void setDgrupos(List<Detalle> dgrupos) {
		this.dgrupos = dgrupos;
	}


	public List<Detalle> getDinbox() {
		return dinbox;
	}


	public void setDinbox(List<Detalle> dinbox) {
		this.dinbox = dinbox;
	}


	public List<Detalle> getDdefaultinbox() {
		return ddefaultinbox;
	}


	public void setDdefaultinbox(List<Detalle> ddefaultinbox) {
		this.ddefaultinbox = ddefaultinbox;
	}


	public Detalle getSelecDetalle() {
		return selecDetalle;
	}


	public void setSelecDetalle(Detalle selecDetalle) {
		this.selecDetalle = selecDetalle;
	}


	public Detalle getDetalle() {
		return detalle;
	}


	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}


	public DetalleService getDetalleService() {
		return detalleService;
	}


	public void setDetalleService(DetalleService detalleService) {
		this.detalleService = detalleService;
	}


	public String getRolesa() {
		return rolesa;
	}


	public void setRolesa(String rolesa) {
		this.rolesa = rolesa;
	}


	public String getGruposa() {
		return gruposa;
	}


	public void setGruposa(String gruposa) {
		this.gruposa = gruposa;
	}


	public String getInboxa() {
		return inboxa;
	}


	public void setInboxa(String inboxa) {
		this.inboxa = inboxa;
	}


	public String getDefaultinboxa() {
		return defaultinboxa;
	}


	public void setDefaultinboxa(String defaultinboxa) {
		this.defaultinboxa = defaultinboxa;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	
}

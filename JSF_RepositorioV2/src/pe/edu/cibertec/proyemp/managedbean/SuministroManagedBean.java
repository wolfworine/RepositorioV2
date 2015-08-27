package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.edu.cibertec.proyemp.model.Atributo;
import pe.edu.cibertec.proyemp.model.Detalle;
import pe.edu.cibertec.proyemp.model.Estado;
import pe.edu.cibertec.proyemp.model.Suministro;
import pe.edu.cibertec.proyemp.service.AtributoService;
import pe.edu.cibertec.proyemp.service.DetalleService;
import pe.edu.cibertec.proyemp.service.EstadoService;
import pe.edu.cibertec.proyemp.service.SuministroService;

import com.google.common.collect.Lists;


@ManagedBean
@SessionScoped
public class SuministroManagedBean {
		
	//Vista de Suministro
	
	private List<Suministro> suministros= new ArrayList<Suministro>();

	private Suministro selecSuministro= new Suministro();
	
	private Suministro suministro= new Suministro();
	
	//Vista de Suministro_Atributo
	
	private String rolesa;
	private String gruposa;
	private String inboxa;
	private String defaultinboxa;
	private String parametro;
	
	private List<Atributo> aroles=new ArrayList<Atributo>();
	
	private List<Atributo> agrupos=new ArrayList<Atributo>();
	
	private List<Atributo> ainbox=new ArrayList<Atributo>();
	
	private List<Atributo> adefaultinbox=new ArrayList<Atributo>();
	private Atributo atributo=new Atributo();
	private Atributo selectAtributo = new Atributo();
	
	//detalle
	private List<Detalle> detalles=new ArrayList<Detalle>();
	private Detalle detalle= new Detalle();
	
	//estado
	private List<Estado> estados=new ArrayList<Estado>();
	
	@ManagedProperty(value = "#{estadoService}")
	private EstadoService estadoService;
	
	@ManagedProperty(value = "#{detalleService}")
	private DetalleService detalleService;
	
	@ManagedProperty(value = "#{suministroService}")
	private SuministroService suministroService;
	
	@ManagedProperty(value = "#{atributoService}")
	private AtributoService atributoService;
	
	@PostConstruct
	public void init(){
		suministros = Lists.newArrayList(
				suministroService.getSuministroRepository().findAll());
	}

	//vista suministro
	
	public String  nuevo() {
		return "/paginas/suministro/editar.xhtml?faces-redirect=true";
	}
	
	public String  editar() {
		return "/paginas/suministro/modificar.xhtml?faces-redirect=true";
	}
	
	public String  volver() {
		return "/paginas/suministro/mantenimiento.xhtml?faces-redirect=true";
	}
	
	public String  registrar() {
		suministroService.getSuministroRepository().save(suministro);
		suministro = new Suministro();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + suministro.getB_nombre()+ " ingresado"
				));
		return "/paginas/suministro/mantenimiento.xhtml?faces-redirect=true";
	}
	
	public String  modificar() {
		System.out.println(selecSuministro);
		suministroService.getSuministroRepository().save(selecSuministro);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + selecSuministro.getB_nombre()+ " Actualizado"
				));
		return "/paginas/suministro/mantenimiento.xhtml?faces-redirect=true";
	}

	//suministro_atributo
	public String  ver_atributo() {

		
			rolesa="ROLES";
			gruposa="GRUPOS";
			inboxa="INBOX";
			defaultinboxa="DEFAULTINBOX";
			
			Long id_rol=selecSuministro.getA_rol().getId();
			Long id_suministro=selecSuministro.getId();


			aroles=  atributoService.getAtributoRepository().findParametro2(id_rol,id_suministro,rolesa);
			agrupos=  atributoService.getAtributoRepository().findParametro2(id_rol,id_suministro,gruposa);
			ainbox=  atributoService.getAtributoRepository().findParametro2(id_rol,id_suministro,inboxa);
			adefaultinbox=  atributoService.getAtributoRepository().findParametro2(id_rol,id_suministro,defaultinboxa);
			estados = Lists.newArrayList(
					estadoService.getEstadoRepository().findAll());
			return "/paginas/atributo/mantenimiento.xhtml?faces-redirect=true";
	}	
	
	// Atributo Roles
			public String  nuevo_atributo_rol() {
				atributo.getB_rol().setId(selecSuministro.getA_rol().getId());
				atributo.getC_suministro().setId(selecSuministro.getId());

				parametro="Roles";
				detalles=detalleService.getDetalleRepository().findParametro(parametro);
			
				return "/paginas/atributo/editar.xhtml?faces-redirect=true";
			}
			
			public String  editar_atributo_rol() {
				parametro="Roles";
				detalles=detalleService.getDetalleRepository().findParametro(parametro);
				return "/paginas/atributo/modificar.xhtml?faces-redirect=true";
			}
			
			// Atributo Grupos
			public String  nuevo_atributo_grupo() {
				atributo.getB_rol().setId(selecSuministro.getA_rol().getId());
				atributo.getC_suministro().setId(selecSuministro.getId());

				parametro="Grupos";
				detalles=detalleService.getDetalleRepository().findParametro(parametro);
				return "/paginas/atributo/editar.xhtml?faces-redirect=true";
			}
			
			public String  editar_atributo_grupo() {
				parametro="Grupos";
				detalles=detalleService.getDetalleRepository().findParametro(parametro);
				return "/paginas/atributo/modificar.xhtml?faces-redirect=true";
			}
			
			// Atributo Inbox 
			public String  nuevo_atributo_inbox() {
				atributo.getB_rol().setId(selecSuministro.getA_rol().getId());
				atributo.getC_suministro().setId(selecSuministro.getId());

				parametro="Inbox";
				detalles=detalleService.getDetalleRepository().findParametro(parametro);
				return "/paginas/atributo/editar.xhtml?faces-redirect=true";
			}
			
			public String  editar_atributo_inbox() {
				parametro="Inbox";
				detalles=detalleService.getDetalleRepository().findParametro(parametro);
				return "/paginas/atributo/modificar.xhtml?faces-redirect=true";
			}
			
			// Atributo Default Inbox
			public String  nuevo_atributo_defaultinboxa() {
				atributo.getB_rol().setId(selecSuministro.getA_rol().getId());
				atributo.getC_suministro().setId(selecSuministro.getId());

				parametro="DefaultInbox";
				detalles=detalleService.getDetalleRepository().findParametro(parametro);
				return "/paginas/atributo/editar.xhtml?faces-redirect=true";
			}
			
			public String  editar_atributo_defaultinboxa() {
				parametro="DefaultInbox";
				detalles=detalleService.getDetalleRepository().findParametro(parametro);
				return "/paginas/atributo/modificar.xhtml?faces-redirect=true";
			}
			
			
			public String  volver_atributo() {
				return "/paginas/atributo/mantenimiento.xhtml?faces-redirect=true";
			}
			
			public String  registrar_atributo() {
				atributoService.getAtributoRepository().save(atributo);
				Long id_rol=selecSuministro.getA_rol().getId();
				Long id_suministro=selecSuministro.getId();
	
				aroles=  atributoService.getAtributoRepository().findParametro2(id_rol,id_suministro,rolesa);
				agrupos=  atributoService.getAtributoRepository().findParametro2(id_rol,id_suministro,gruposa);
				ainbox=  atributoService.getAtributoRepository().findParametro2(id_rol,id_suministro,inboxa);
				adefaultinbox=  atributoService.getAtributoRepository().findParametro2(id_rol,id_suministro,defaultinboxa);
				atributo =new Atributo();
				return "/paginas/atributo/mantenimiento.xhtml?faces-redirect=true";
			}
			
			
			public String  modificar_atributo() {
				
				atributoService.getAtributoRepository().save(selectAtributo);			
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(
						"Registro " + selectAtributo.getId() + " actualizado"
						));
				Long id_rol=selecSuministro.getA_rol().getId();
				Long id_suministro=selecSuministro.getId();
		
				aroles=  atributoService.getAtributoRepository().findParametro2(id_rol,id_suministro,rolesa);
				agrupos=  atributoService.getAtributoRepository().findParametro2(id_rol,id_suministro,gruposa);
				ainbox=  atributoService.getAtributoRepository().findParametro2(id_rol,id_suministro,inboxa);
				adefaultinbox=  atributoService.getAtributoRepository().findParametro2(id_rol,id_suministro,defaultinboxa);

				return "/paginas/atributo/mantenimiento.xhtml?faces-redirect=true";
			}
			
			public String  eliminar_atributo() {
				
				atributoService.getAtributoRepository().delete(selectAtributo.getId());		
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(
						"registro " + selectAtributo.getId() + " eliminado"
						));
				Long id_rol=selecSuministro.getA_rol().getId();
				Long id_suministro=selecSuministro.getId();
		
				aroles=  atributoService.getAtributoRepository().findParametro2(id_rol,id_suministro,rolesa);
				agrupos=  atributoService.getAtributoRepository().findParametro2(id_rol,id_suministro,gruposa);
				ainbox=  atributoService.getAtributoRepository().findParametro2(id_rol,id_suministro,inboxa);
				adefaultinbox=  atributoService.getAtributoRepository().findParametro2(id_rol,id_suministro,defaultinboxa);

				return "/paginas/atributo/mantenimiento.xhtml?faces-redirect=true";
			}
	
		
	
	public List<Suministro> getSuministros() {
		suministros = Lists.newArrayList(
				suministroService.getSuministroRepository().findAll());
		return suministros;
	}

	public void setSuministros(List<Suministro> suministros) {
		this.suministros = suministros;
	}

	public Suministro getSelecSuministro() {
		return selecSuministro;
	}

	public void setSelecSuministro(Suministro selecSuministro) {
		this.selecSuministro = selecSuministro;
	}

	public Suministro getSuministro() {
		return suministro;
	}

	public void setSuministro(Suministro suministro) {
		this.suministro = suministro;
	}

	public SuministroService getSuministroService() {
		return suministroService;
	}

	public void setSuministroService(SuministroService suministroService) {
		this.suministroService = suministroService;
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

	public List<Atributo> getAroles() {
		return aroles;
	}

	public void setAroles(List<Atributo> aroles) {
		this.aroles = aroles;
	}

	public List<Atributo> getAgrupos() {
		return agrupos;
	}

	public void setAgrupos(List<Atributo> agrupos) {
		this.agrupos = agrupos;
	}

	public List<Atributo> getAinbox() {
		return ainbox;
	}

	public void setAinbox(List<Atributo> ainbox) {
		this.ainbox = ainbox;
	}

	public List<Atributo> getAdefaultinbox() {
		return adefaultinbox;
	}

	public void setAdefaultinbox(List<Atributo> adefaultinbox) {
		this.adefaultinbox = adefaultinbox;
	}

	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}

	public Atributo getSelectAtributo() {
		return selectAtributo;
	}

	public void setSelectAtributo(Atributo selectAtributo) {
		this.selectAtributo = selectAtributo;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}


	public AtributoService getAtributoService() {
		return atributoService;
	}

	public void setAtributoService(AtributoService atributoService) {
		this.atributoService = atributoService;
	}

	public DetalleService getDetalleService() {
		return detalleService;
	}

	public void setDetalleService(DetalleService detalleService) {
		this.detalleService = detalleService;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public EstadoService getEstadoService() {
		return estadoService;
	}

	public void setEstadoService(EstadoService estadoService) {
		this.estadoService = estadoService;
	}
	
	

}

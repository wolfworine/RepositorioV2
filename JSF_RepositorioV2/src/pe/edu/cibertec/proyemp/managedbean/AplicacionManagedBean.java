package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.edu.cibertec.proyemp.model.Aplicacion;
import pe.edu.cibertec.proyemp.model.Atributo;
import pe.edu.cibertec.proyemp.model.Detalle;
import pe.edu.cibertec.proyemp.model.Estado;
import pe.edu.cibertec.proyemp.model.Rol;
import pe.edu.cibertec.proyemp.model.Suministro;
import pe.edu.cibertec.proyemp.service.AplicacionService;
import pe.edu.cibertec.proyemp.service.AtributoService;
import pe.edu.cibertec.proyemp.service.DetalleService;
import pe.edu.cibertec.proyemp.service.EstadoService;
import pe.edu.cibertec.proyemp.service.RolService;
import pe.edu.cibertec.proyemp.service.SuministroService;

import com.google.common.collect.Lists;


@ManagedBean
@SessionScoped
public class AplicacionManagedBean {
	
	private List<Aplicacion> aplicaciones= new ArrayList<Aplicacion>();

	
	private Aplicacion selecAplicacion= new Aplicacion();
	
	private Aplicacion aplicacion= new Aplicacion();
	
	//Vista de Rol

	private Rol rol =new Rol();
	private Rol selecRol = new Rol();
	
	//Vista de Suministro
	
	private List<Suministro> rol_suministros = new ArrayList<Suministro>();
	private Suministro suministro=new Suministro();
	private Suministro selecSuministro = new Suministro();
	
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
	
	@ManagedProperty(value = "#{rolService}")
	private RolService rolService;

	@ManagedProperty(value = "#{detalleService}")
	private DetalleService detalleService;
	
	@ManagedProperty(value = "#{aplicacionService}")
	private AplicacionService aplicacionService;

	@ManagedProperty(value = "#{suministroService}")
	private SuministroService suministroService;
	
	@ManagedProperty(value = "#{atributoService}")
	private AtributoService atributoService;
	

		
	@PostConstruct
	public void init(){
		aplicaciones = Lists.newArrayList(
				aplicacionService.getAplicacionRepository().findAll());
	}

	//Vista Aplicacion
	
	public String  nuevo() {
		return "/paginas/aplicacion/editar.xhtml?faces-redirect=true";
	}
	
	public String  editar() {
		return "/paginas/aplicacion/modificar.xhtml?faces-redirect=true";
	}
	
	public String  volver() {
		return "/paginas/aplicacion/mantenimiento.xhtml?faces-redirect=true";
	}
	
	public String  registrar() {
		aplicacionService.getAplicacionRepository().save(aplicacion);
		aplicacion = new Aplicacion();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + aplicacion.getNombre()+ " ingresado"
				));
		return "/paginas/aplicacion/mantenimiento.xhtml?faces-redirect=true";
	}
	
	
	public String  modificar() {
		System.out.println(selecAplicacion);
		aplicacionService.getAplicacionRepository().save(selecAplicacion);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + selecAplicacion.getNombre()+ " Actualizado"
				));
		return "/paginas/aplicacion/mantenimiento.xhtml?faces-redirect=true";
	}

	//vista rol
		public String  ver_rol() {

			return "/paginas/aplicacion/mantenimiento_rol.xhtml?faces-redirect=true";
		}
		
		public String  nuevo_rol() {
			return "/paginas/aplicacion/editar_rol.xhtml?faces-redirect=true";
		}
		
		public String  editar_rol() {
			return "/paginas/aplicacion/modificar_rol.xhtml?faces-redirect=true";
		}
		
		
		
		public String  volver_rol() {
			return "/paginas/aplicacion/mantenimiento_rol.xhtml?faces-redirect=true";
		}
		
		public String  registrar_rol() {
		
			rolService.getRolRepository().save(rol);
			rol = new Rol();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Registro " + rol.getA_nombre()+ "ingresado"
					));

			return "/paginas/aplicacion/mantenimiento_rol.xhtml?faces-redirect=true";
		}
		
		
		public String  modificar_rol() {
			System.out.println(selecRol);
			rolService.getRolRepository().save(selecRol);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Registro " + selecRol.getA_nombre()+ " Actualizado"
					));
			return "/paginas/aplicacion/mantenimiento_rol.xhtml?faces-redirect=true";
		}
	
		//suministro
		public String  versuministro() {
			System.out.println(selecRol.getId());
			rol_suministros=suministroService.getSuministroRepository().findSuministro(selecRol.getId());

			return "/paginas/aplicacion/mantenimiento_suministro.xhtml?faces-redirect=true";
		}

		public String  nuevo_suministro() {
			suministro.getA_rol().setId(selecRol.getId());
			return "/paginas/aplicacion/editar_suministro.xhtml?faces-redirect=true";
		}
		
		public String  editar_suministro() {
		
			return "/paginas/aplicacion/modificar_suministro.xhtml?faces-redirect=true";
		}
		
		public String  volver_suministro() {
			return "/paginas/aplicacion/mantenimiento_suministro.xhtml?faces-redirect=true";
		}
		
		public String  registrar_suministro() {


			suministroService.getSuministroRepository().save(suministro);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Registro " + suministro.getB_nombre()+ " ingresado"
					));
			suministro = new Suministro();
			rol_suministros=suministroService.getSuministroRepository().findSuministro(selecRol.getId());
			return "/paginas/aplicacion/mantenimiento_suministro.xhtml?faces-redirect=true";
		}
		
		
		public String  modificar_suministro() {
			suministroService.getSuministroRepository().save(selecSuministro);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Registro " + selecSuministro.getB_nombre() + " actualizado"
					));
			return "/paginas/aplicacion/mantenimiento_suministro.xhtml?faces-redirect=true";
		}
	
		//suministro_atributo
		public String  ver_atributo() {

			
				rolesa="ROLES";
				gruposa="GRUPOS";
				inboxa="INBOX";
				defaultinboxa="DEFAULTINBOX";
				
				Long id_rol=selecSuministro.getA_rol().getId();
				Long id_suministro=selecSuministro.getId();
				Long aplicacion=selecAplicacion.getCodigo();

				aroles=  atributoService.getAtributoRepository().findParametro3(aplicacion,id_rol,id_suministro,rolesa);
				agrupos=  atributoService.getAtributoRepository().findParametro3(aplicacion,id_rol,id_suministro,gruposa);
				ainbox=  atributoService.getAtributoRepository().findParametro3(aplicacion,id_rol,id_suministro,inboxa);
				adefaultinbox=  atributoService.getAtributoRepository().findParametro3(aplicacion,id_rol,id_suministro,defaultinboxa);
				estados = Lists.newArrayList(
						estadoService.getEstadoRepository().findAll());
				return "/paginas/aplicacion/mantenimiento_atributo.xhtml?faces-redirect=true";
		}	
		
		// Atributo Roles
				public String  nuevo_atributo_rol() {
					atributo.getB_rol().setId(selecSuministro.getA_rol().getId());
					atributo.getC_suministro().setId(selecSuministro.getId());
					atributo.getA_aplicacion().setCodigo(selecAplicacion.getCodigo());
					parametro="Roles";
					detalles=detalleService.getDetalleRepository().findParametro(parametro);
				
					return "/paginas/aplicacion/editar_atributo.xhtml?faces-redirect=true";
				}
				
				public String  editar_atributo_rol() {
					parametro="Roles";
					detalles=detalleService.getDetalleRepository().findParametro(parametro);
					return "/paginas/aplicacion/modificar_atributo.xhtml?faces-redirect=true";
				}
				
				// Atributo Grupos
				public String  nuevo_atributo_grupo() {
					atributo.getB_rol().setId(selecSuministro.getA_rol().getId());
					atributo.getC_suministro().setId(selecSuministro.getId());
					atributo.getA_aplicacion().setCodigo(selecAplicacion.getCodigo());
					parametro="Grupos";
					detalles=detalleService.getDetalleRepository().findParametro(parametro);
					return "/paginas/aplicacion/editar_atributo.xhtml?faces-redirect=true";
				}
				
				public String  editar_atributo_grupo() {
					parametro="Grupos";
					detalles=detalleService.getDetalleRepository().findParametro(parametro);
					return "/paginas/aplicacion/modificar_atributo.xhtml?faces-redirect=true";
				}
				
				// Atributo Inbox 
				public String  nuevo_atributo_inbox() {
					atributo.getB_rol().setId(selecSuministro.getA_rol().getId());
					atributo.getC_suministro().setId(selecSuministro.getId());
					atributo.getA_aplicacion().setCodigo(selecAplicacion.getCodigo());
					parametro="Inbox";
					detalles=detalleService.getDetalleRepository().findParametro(parametro);
					return "/paginas/aplicacion/editar_atributo.xhtml?faces-redirect=true";
				}
				
				public String  editar_atributo_inbox() {
					parametro="Inbox";
					detalles=detalleService.getDetalleRepository().findParametro(parametro);
					return "/paginas/aplicacion/modificar_atributo.xhtml?faces-redirect=true";
				}
				
				// Atributo Default Inbox
				public String  nuevo_atributo_defaultinboxa() {
					atributo.getB_rol().setId(selecSuministro.getA_rol().getId());
					atributo.getC_suministro().setId(selecSuministro.getId());
					atributo.getA_aplicacion().setCodigo(selecAplicacion.getCodigo());
					parametro="DefaultInbox";
					detalles=detalleService.getDetalleRepository().findParametro(parametro);
					return "/paginas/aplicacion/editar_atributo.xhtml?faces-redirect=true";
				}
				
				public String  editar_atributo_defaultinboxa() {
					parametro="DefaultInbox";
					detalles=detalleService.getDetalleRepository().findParametro(parametro);
					return "/paginas/aplicacion/modificar_atributo.xhtml?faces-redirect=true";
				}
				
				
				public String  volver_atributo() {
					return "/paginas/aplicacion/mantenimiento_atributo.xhtml?faces-redirect=true";
				}
				
				public String  registrar_atributo() {
					atributoService.getAtributoRepository().save(atributo);
					Long id_rol=selecSuministro.getA_rol().getId();
					Long id_suministro=selecSuministro.getId();
					Long aplicacion=selecAplicacion.getCodigo();
					aroles=  atributoService.getAtributoRepository().findParametro3(aplicacion,id_rol,id_suministro,rolesa);
					agrupos=  atributoService.getAtributoRepository().findParametro3(aplicacion,id_rol,id_suministro,gruposa);
					ainbox=  atributoService.getAtributoRepository().findParametro3(aplicacion,id_rol,id_suministro,inboxa);
					adefaultinbox=  atributoService.getAtributoRepository().findParametro3(aplicacion,id_rol,id_suministro,defaultinboxa);
					atributo =new Atributo();
					return "/paginas/aplicacion/mantenimiento_atributo.xhtml?faces-redirect=true";
				}
				
				
				public String  modificar_atributo() {
					
					atributoService.getAtributoRepository().save(selectAtributo);			
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage(
							"Registro " + selectAtributo.getId() + " actualizado"
							));
					Long id_rol=selecSuministro.getA_rol().getId();
					Long id_suministro=selecSuministro.getId();
					Long aplicacion=selecAplicacion.getCodigo();
					aroles=  atributoService.getAtributoRepository().findParametro3(aplicacion,id_rol,id_suministro,rolesa);
					agrupos=  atributoService.getAtributoRepository().findParametro3(aplicacion,id_rol,id_suministro,gruposa);
					ainbox=  atributoService.getAtributoRepository().findParametro3(aplicacion,id_rol,id_suministro,inboxa);
					adefaultinbox=  atributoService.getAtributoRepository().findParametro3(aplicacion,id_rol,id_suministro,defaultinboxa);

					return "/paginas/aplicacion/mantenimiento_atributo.xhtml?faces-redirect=true";
				}
				
				public String  eliminar_atributo() {
					
					atributoService.getAtributoRepository().delete(selectAtributo.getId());		
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage(
							"registro " + selectAtributo.getId() + " eliminado"
							));
					Long id_rol=selecSuministro.getA_rol().getId();
					Long id_suministro=selecSuministro.getId();
					Long aplicacion=selecAplicacion.getCodigo();
					aroles=  atributoService.getAtributoRepository().findParametro3(aplicacion,id_rol,id_suministro,rolesa);
					agrupos=  atributoService.getAtributoRepository().findParametro3(aplicacion,id_rol,id_suministro,gruposa);
					ainbox=  atributoService.getAtributoRepository().findParametro3(aplicacion,id_rol,id_suministro,inboxa);
					adefaultinbox=  atributoService.getAtributoRepository().findParametro3(aplicacion,id_rol,id_suministro,defaultinboxa);

					return "/paginas/aplicacion/mantenimiento_atributo.xhtml?faces-redirect=true";
				}
				
				
	public List<Aplicacion> getAplicaciones() {
		aplicaciones = Lists.newArrayList(
				aplicacionService.getAplicacionRepository().findAll());
		return aplicaciones;
	}

	public void setAplicaciones(List<Aplicacion> aplicaciones) {
		this.aplicaciones = aplicaciones;
	}

	public Aplicacion getSelecAplicacion() {
		return selecAplicacion;
	}

	public void setSelecAplicacion(Aplicacion selecAplicacion) {
		this.selecAplicacion = selecAplicacion;
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public AplicacionService getAplicacionService() {
		return aplicacionService;
	}

	public void setAplicacionService(AplicacionService aplicacionService) {
		this.aplicacionService = aplicacionService;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Rol getSelecRol() {
		return selecRol;
	}

	public void setSelecRol(Rol selecRol) {
		this.selecRol = selecRol;
	}

	public DetalleService getDetalleService() {
		return detalleService;
	}

	public void setDetalleService(DetalleService detalleService) {
		this.detalleService = detalleService;
	}

	public RolService getRolService() {
		return rolService;
	}

	public void setRolService(RolService rolService) {
		this.rolService = rolService;
	}

	public SuministroService getSuministroService() {
		return suministroService;
	}

	public void setSuministroService(SuministroService suministroService) {
		this.suministroService = suministroService;
	}

	public AtributoService getAtributoService() {
		return atributoService;
	}

	public void setAtributoService(AtributoService atributoService) {
		this.atributoService = atributoService;
	}

	public List<Suministro> getRol_suministros() {
		return rol_suministros;
	}

	public void setRol_suministros(List<Suministro> rol_suministros) {
		this.rol_suministros = rol_suministros;
	}

	public Suministro getSuministro() {
		return suministro;
	}

	public void setSuministro(Suministro suministro) {
		this.suministro = suministro;
	}

	public Suministro getSelecSuministro() {
		return selecSuministro;
	}

	public void setSelecSuministro(Suministro selecSuministro) {
		this.selecSuministro = selecSuministro;
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

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public List<Estado> getEstados() {
		estados = Lists.newArrayList(
				estadoService.getEstadoRepository().findAll());
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

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	

	
	
	

}

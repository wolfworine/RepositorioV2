package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.edu.cibertec.proyemp.model.Login;
import pe.edu.cibertec.proyemp.model.Usuario;
import pe.edu.cibertec.proyemp.service.LoginService;
import pe.edu.cibertec.proyemp.service.UsuarioService;

import com.google.common.collect.Lists;

@ManagedBean
@SessionScoped
public class UsuarioManagedBean {

	private List<Usuario> usuarios= new ArrayList<Usuario>();

	private Usuario selecUsuario= new Usuario();
	
	private Usuario usuario= new Usuario();

	private Login login= new Login();

	private String password_verify;
	
	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;
	
	@ManagedProperty(value = "#{loginService}")
	private LoginService loginService;
	
	@PostConstruct
	public void init(){
		usuarios = Lists.newArrayList(
				usuarioService.getUsuarioRepository().findAll());
	}
	
	public String  nuevo() {
		return "/paginas/usuario/editar.xhtml?faces-redirect=true";
	}
	
	public String  editar() {
		return "/paginas/usuario/modificar.xhtml?faces-redirect=true";
	}
	
	public String  volver() {
		return "/paginas/usuario/mantenimiento.xhtml?faces-redirect=true";
	}
	
	public String registrar() {
		login.setEmail(usuario.getC_email());
		login.setPassword(usuario.getD_password());
		usuarioService.getUsuarioRepository().save(usuario);
		loginService.getLoginRepository().save(login);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + usuario.getC_email()+ " ingresado"
				));
		usuario = new Usuario();
		return "/paginas/usuario/mantenimiento.xhtml?faces-redirect=true";
		// TODO Auto-generated method stub

	}	
	
	public String  modificar() {
		login.setId(selecUsuario.getId());
		login.setPassword(selecUsuario.getD_password());
		login.setEmail(selecUsuario.getC_email());
		login.setPassword(selecUsuario.getD_password());
		usuarioService.getUsuarioRepository().save(selecUsuario);
		loginService.getLoginRepository().update(selecUsuario.getId(),selecUsuario.getD_password(),selecUsuario.getC_email());
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + usuario.getC_email()+ " actualizado"
				));
		return "/paginas/usuario/mantenimiento.xhtml?faces-redirect=true";
	}
	

	
	public List<Usuario> getUsuarios() {
		usuarios = Lists.newArrayList(
				usuarioService.getUsuarioRepository().findAll());
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getSelecUsuario() {
		return selecUsuario;
	}

	public void setSelecUsuario(Usuario selecUsuario) {
		this.selecUsuario = selecUsuario;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getPassword_verify() {
		return password_verify;
	}

	public void setPassword_verify(String password_verify) {
		this.password_verify = password_verify;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}


	
	
	
	
}

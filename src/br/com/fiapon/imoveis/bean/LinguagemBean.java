/*A classe LinguagemBean ser� respons�vel por trocar o Locale
 * para ingl�s ou portugu�s, de acorod com a escolha do usu�rio.
 * � um bean gerenciado com o escopo de sess�o, sou seja, ap�s 
 * a linguagem trocada, o usu�rio poder� navegar para outra p�gina
 * e o arquivo das propriedades ser� atualizado pelo JSF*/

package br.com.fiapon.imoveis.bean;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LinguagemBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Locale locale;
	
	@PostConstruct
	private void init(){
		locale = FacesContext.getCurrentInstance().getViewRoot()
			.getLocale();
	}

	public void mudarParaIngles() {
		FacesContext context = FacesContext.getCurrentInstance();
		UIViewRoot view = context.getViewRoot();
		locale = Locale.ENGLISH;
		view.setLocale(locale);
	}

	public void mudarParaPortugues() {

		FacesContext context = FacesContext.getCurrentInstance();
		UIViewRoot view = context.getViewRoot();
		locale = new Locale("pt", "BR");
		view.setLocale(locale);
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
}
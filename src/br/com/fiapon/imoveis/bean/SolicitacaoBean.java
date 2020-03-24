/*A classe SolicitacaoBean ser� respons�vel por instancias
 * uma solicita��o, simular um cadastro, navegar para a p�gina
 * inicial e retornar Listas para popular a tela, tratando de
 * internacionaliza��o*/

package br.com.fiapon.imoveis.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiapon.imoveis.entity.Solicitacao;

@ManagedBean
public class SolicitacaoBean {

	private Solicitacao solicitacao;
	private Locale locale;

	@PostConstruct // Inicializando os atributos
	//essa nota��o garante que o m�todo init() ser� disparado quando
	//o bean for totalmente inicializado
	private void init() {
		solicitacao = new Solicitacao();
	}

	public void cadastrar() {
		System.out.println("Cidade " + solicitacao.getCidade());
		System.out.println("Valor: " + solicitacao.getValor());
		System.out.println("Desc: " + solicitacao.getDescricao());
		System.out.println("Senha: " + solicitacao.getSenha());
		System.out.println("Novo: " + solicitacao.isNovo());
		System.out.println(solicitacao.getItens());
		System.out.println(solicitacao.getComodos());
		System.out.println(solicitacao.getTipo());
		System.out.println(solicitacao.getFinalidade());
		System.out.println(solicitacao.getOperacao());
		System.out.println(solicitacao.getEmail());

	// Mensagem que ser� associada ao componente h:h:messages � Por ser um simula��o, n�o est� internacionalizado
		FacesMessage msg = new FacesMessage("Im�vel Cadastrado!");

		//Adiciona a mensagem na inst�ncia corrente da solicita��o
	FacesContext.getCurrentInstance().addMessage(null, msg);
	}

    //Navega para a tela home
	public String navegarHome() {
		return "index?faces-redirect=true";
	}

     //Retorna true se a linguagem for pt
     //Novamente utilizamos o contexto, agora para obter o Locale
	private boolean getLocalePt() {
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

		return locale.getLanguage().toString().equals("pt");
	}


     //Retorna uma lista de tipos para a p�gina xhtml, tratando internacionaliza��o
	public List<String> getTipos() {
		List<String> lista = new ArrayList<String>();

		if (getLocalePt()) {
			lista.add("Casa");
			lista.add("Apartamento");
			lista.add("Armaz�m");
			lista.add("Sitio");
			lista.add("Fazenda");
		} else {
			lista.add("House");
			lista.add("Apartment");
			lista.add("Warehouse");
			lista.add("Rural");
			lista.add("Farm");
		}

		return lista;
	}

     //Retorna uma lista de comodos para a p�gina xhtml, tratando internacionaliza��o
	public List<String> getListaComodos() {
		List<String> lista = new ArrayList<String>();

		if (getLocalePt()) {
			lista.add("Quarto");
			lista.add("Sala");
			lista.add("Cozinha");
			lista.add("Banheiro");
			lista.add("Varanda");
		} else {
			lista.add("Bedroom");
			lista.add("Living room");
			lista.add("Kitchen");
			lista.add("Bathroom");
			lista.add("Balcony");
		}
		return lista;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

}
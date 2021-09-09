package br.com.drogaria.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {
	public static void adicionarMensagemSucesso(String mensagem) {

		FacesMessage msgSucess = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		FacesContext contexto = FacesContext.getCurrentInstance();

		contexto.addMessage(null, msgSucess);
	}

	public static void adicionarMensagemErro(String mensagem) {

		FacesMessage msgError = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		FacesContext contexto = FacesContext.getCurrentInstance();

		contexto.addMessage(null, msgError);
	}

}

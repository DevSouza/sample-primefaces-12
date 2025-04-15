package br.com.devsouza.convexus.web.utils;

import java.io.IOException;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

public final class FacesUtils {

	public static final void addInfoMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
	public static final void addErrorMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
		FacesContext.getCurrentInstance().validationFailed();
	}
	public static String getParameter(String key) {
		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
		return value == null ? "" : value;
	}
	public static void redirecionarPagina(String pagina) {
        FacesContext context = FacesContext.getCurrentInstance();
        String url = context.getExternalContext().getRequestContextPath();
        
        try {
        	if(pagina.startsWith("/")) {
        		context.getExternalContext().redirect(url + pagina);
        	} else {
        		context.getExternalContext().redirect(url + "/" + pagina);
        	}
        } catch (IOException ex) {
        	ex.printStackTrace();
        }
    }
}

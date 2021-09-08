package br.com.drogaria.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

@ManagedBean(name = "mbFabricante")
@ViewScoped
public class FabricanteBean {
	private ListDataModel<Fabricante> listaFabricantes; // utilizado para mostrar dados na tabela

	public ListDataModel<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(ListDataModel<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			FabricanteDAO fDao = new FabricanteDAO();
			ArrayList<Fabricante> lista = (ArrayList<Fabricante>) fDao.listarFabricantes();
			listaFabricantes = new ListDataModel<Fabricante>(lista);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

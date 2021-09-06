package br.com.drogaria.bean;

import java.sql.SQLException;
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
	private ListDataModel<Fabricante> listaFabricantes;

	public ListDataModel<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(ListDataModel<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}

//	@PostConstruct
//	public void prepararPesquisa() {
//
//		try {
//			FabricanteDAO dao = new FabricanteDAO();
//			ArrayList<Fabricante> lista = (ArrayList<Fabricante>) dao.listarFabricantes();
//			listaFabricantes = new ListDataModel<Fabricante>(lista);
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//	}
}

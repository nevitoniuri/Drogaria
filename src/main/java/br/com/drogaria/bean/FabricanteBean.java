package br.com.drogaria.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.exception.DaoException;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "mbFabricante")
@ViewScoped
public class FabricanteBean {
	private Fabricante fabricante;
	private ArrayList<Fabricante> listaFabricantes; // utilizado para mostrar dados na tabela
	private ArrayList<Fabricante> listaFabricantesFiltrados;

//	private EntityManager em;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ArrayList<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(ArrayList<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}

	public ArrayList<Fabricante> getListaFabricantesFiltrados() {
		return listaFabricantesFiltrados;
	}

	public void setListaFabricantesFiltrados(ArrayList<Fabricante> listaFabricantesFiltrados) {
		this.listaFabricantesFiltrados = listaFabricantesFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			FabricanteDAO fDao = new FabricanteDAO();
			listaFabricantes = fDao.listarFabricantes();
		} catch (DaoException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void prepararNovoFabricante() {
		fabricante = new Fabricante();
	}

	public void cadastrarNovoFabricante() { // função site

		try {
			FabricanteDAO fDao = new FabricanteDAO();
			fDao.cadastrarFabricante(fabricante);

			listaFabricantes = fDao.listarFabricantes();

			JSFUtil.adicionarMensagemSucesso("Fabricante cadastrado com sucesso.");

		} catch (DaoException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

//	public void prepararExcluir() {
//		fabricante = listaFabricantes.getRowData();
//	}

	public void excluirFabricante() {

		try {
			FabricanteDAO fDao = new FabricanteDAO();

			fDao.removerFabricante(fabricante.getCodigo());

			listaFabricantes = fDao.listarFabricantes();

			JSFUtil.adicionarMensagemSucesso("Fabricante excluído com sucesso");

		} catch (DaoException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

//	public void prepararEditar() {
//		fabricante = listaFabricantes.getRowData();
//	}

	public void editarFabricante() {
		try {
			FabricanteDAO fDao = new FabricanteDAO();
			fDao.atualizarFabricante(fabricante);

			listaFabricantes = fDao.listarFabricantes();

//			ArrayList<Fabricante> lista = (ArrayList<Fabricante>) fDao.listarFabricantes();
//			listaFabricantes = new ListDataModel<Fabricante>(lista);

			JSFUtil.adicionarMensagemSucesso("Fabricante atualizado com sucesso");
		} catch (DaoException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

}

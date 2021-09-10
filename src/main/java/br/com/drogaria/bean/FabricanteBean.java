package br.com.drogaria.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.exception.DaoException;
import br.com.drogaria.util.JPAUtil;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "mbFabricante")
@ViewScoped
public class FabricanteBean {
	private Fabricante fabricante;
	private ListDataModel<Fabricante> listaFabricantes; // utilizado para mostrar dados na tabela

//	private EntityManager em;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

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
		} catch (DaoException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void prepararNovoFabricante() {
		fabricante = new Fabricante();
	}

	public void cadastrarNovoFabricante() { // função site
		EntityManager em = JPAUtil.getEntityManager(); /// sempre colocar nos métodos...
		try {
			FabricanteDAO fDao = new FabricanteDAO();
			fDao.cadastrarFabricante(fabricante);

			ArrayList<Fabricante> lista = (ArrayList<Fabricante>) fDao.listarFabricantes();
			listaFabricantes = new ListDataModel<Fabricante>(lista);

			JSFUtil.adicionarMensagemSucesso("Fabricante cadastrado com sucesso.");

		} catch (DaoException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
			
		} finally {
			em.close();
		}
	}

	public void prepararExcluir() {
		fabricante = listaFabricantes.getRowData();
	}

	public void excluirFabricante() {

		try {
			FabricanteDAO fDao = new FabricanteDAO();

			fDao.removerFabricante(fabricante.getCodigo());

			ArrayList<Fabricante> lista = (ArrayList<Fabricante>) fDao.listarFabricantes();
			listaFabricantes = new ListDataModel<Fabricante>(lista);

			JSFUtil.adicionarMensagemSucesso("Fabricante excluído com sucesso");

		} catch (DaoException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}
}

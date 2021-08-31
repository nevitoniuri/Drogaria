package br.com.drogaria.factory;

import javax.persistence.EntityManager;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.JPAUtil;

public class CadastroFabricante {

	public static void main(String[] args) {
		Fabricante f1 = new Fabricante();
		f1.setNome("Dell");

		EntityManager em = JPAUtil.getEntityManager();
		FabricanteDAO dao = new FabricanteDAO(em);

		dao.cadastrar(f1);

	}

}
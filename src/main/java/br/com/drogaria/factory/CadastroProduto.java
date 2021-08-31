package br.com.drogaria.factory;

import javax.persistence.EntityManager;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JPAUtil;
//import br.com.drogaria.domain.Fabricante;
//import br.com.drogaria.factory.CadastroFabricante;

public class CadastroProduto {

	public static void main(String[] args) {
	
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDAO dao = new ProdutoDAO(em);
		Produto p1 = new Produto();
		p1.setDescricao("Notebook N4050 - i3 4th gen | 4gb RAM | 500gb HD");
		dao.cadastrar(p1);
	}
}

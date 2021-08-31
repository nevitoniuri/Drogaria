package br.com.drogaria.dao;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Produto;

public class ProdutoDAO {
	
	private EntityManager em;

	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		try {
			em.getTransaction().begin();
			this.em.persist(produto);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

}

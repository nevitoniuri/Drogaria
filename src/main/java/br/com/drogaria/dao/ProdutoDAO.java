package br.com.drogaria.dao;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JPAUtil;

public class ProdutoDAO {
	
	private EntityManager em;

	public void cadastrar(Produto produto) {
		try {
			em = JPAUtil.getEntityManager(); ///sempre colocar nos métodos...
			em.getTransaction().begin();
			this.em.persist(produto);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}
	
	public void remover(Produto produto) {
		em = JPAUtil.getEntityManager(); ///sempre colocar nos métodos...
		this.em.remove(produto);
	}
	public void atualizar(Produto produto) {
		em = JPAUtil.getEntityManager(); ///sempre colocar nos métodos...
		this.em.merge(produto);
	}

}

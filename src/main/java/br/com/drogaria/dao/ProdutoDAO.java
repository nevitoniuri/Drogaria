package br.com.drogaria.dao;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JPAUtil;

public class ProdutoDAO {

	private EntityManager em;

	public void cadastrarProduto(Produto produto) {
		try {
			em = JPAUtil.getEntityManager(); /// sempre colocar nos m�todos...
			em.getTransaction().begin();
			this.em.persist(produto);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	public Produto buscarProduto(int id) {
		if(em == null || !em.isOpen()) {
			em = JPAUtil.getEntityManager();  /// sempre colocar nos m�todos...
		}
		return em.find(Produto.class, id);
	}

	public void removerProduto(int id) {
		try {
			em = JPAUtil.getEntityManager(); /// sempre colocar nos m�todos...
			em.getTransaction().begin();
			Produto buscaProduto = this.buscarProduto(id);
			System.out.println(buscaProduto);
			this.em.remove(buscaProduto);
			em.getTransaction().commit();
			System.out.println("Produto " + id + " removido.");

		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}

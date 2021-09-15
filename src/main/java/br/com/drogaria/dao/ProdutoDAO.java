package br.com.drogaria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.exception.DaoException;
import br.com.drogaria.util.JPAUtil;

public class ProdutoDAO {

	private EntityManager em;

	public void cadastrarProduto(Produto produto) throws DaoException {
		try {
			em = JPAUtil.getEntityManager(); /// sempre colocar
			em.getTransaction().begin();
			this.em.persist(produto);
			em.getTransaction().commit();
			System.out.println("Produto cadastrado.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Nao foi possivel cadastrar o produto.");
			throw new DaoException("Nao foi possivel cadastrar o produto.");
		} finally {
			em.close();
		}

	}

	public Produto buscarProduto(int id) {
		if (em == null || !em.isOpen()) {
			em = JPAUtil.getEntityManager(); /// sempre colocar
		}
		return em.find(Produto.class, id);
	}

	public void removerProduto(int id) throws DaoException {
		try {
			em = JPAUtil.getEntityManager(); /// sempre colocar
			em.getTransaction().begin();
			Produto buscaProduto = this.buscarProduto(id);
			System.out.println(buscaProduto);
			this.em.remove(buscaProduto);
			em.getTransaction().commit();
			System.out.println("Produto " + id + " removido.");

		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new DaoException("Nao foi possivel remover o produto.");
		} finally {
			em.close();
		}
	}

	public void atualizarProduto(Produto produto) throws DaoException {
		try {
			em = JPAUtil.getEntityManager();

			em.getTransaction().begin();
			this.em.merge(produto);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new DaoException("Nao foi possivel atualizar o produto.");
		} finally {
			em.close();
		}
	}
	
	public ArrayList<Produto> listarProdutos() throws DaoException{  //estava List
		em = JPAUtil.getEntityManager(); /// sempre colocar 

		String queryList = "SELECT f FROM produto f ORDER BY codigo_produto ASC";
		List<Produto> produtoList = em.createQuery(queryList, Produto.class).getResultList();
		return (ArrayList<Produto>) produtoList;
	}
	
}

package br.com.drogaria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.exception.DaoException;
import br.com.drogaria.util.JPAUtil;

public class FabricanteDAO {

	private EntityManager em;

	public void cadastrarFabricante(Fabricante fabricante) throws DaoException {
		try {
			em = JPAUtil.getEntityManager(); /// sempre colocar nos metodos...
			em.getTransaction().begin();
			this.em.persist(fabricante);
			em.getTransaction().commit();
			System.out.println("Fabricante cadastrado.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Nao foi possivel cadastrar o fabricante.");
			throw new DaoException("Nao foi possivel cadastrar o fabricante.");
		} finally {
			em.close();
		}
	}

	public Fabricante buscarFabricante(int id) {
		if (em == null || !em.isOpen()) {
			em = JPAUtil.getEntityManager(); /// sempre colocar
		}
		return em.find(Fabricante.class, id);
	}

	public void removerFabricante(int id) throws DaoException{
		try {
			em = JPAUtil.getEntityManager(); /// sempre colocar 
			em.getTransaction().begin();
			Fabricante buscaFabricante = this.buscarFabricante(id);
			System.out.println(buscaFabricante);
			this.em.remove(buscaFabricante);
			em.getTransaction().commit();
			System.out.println("Fabricante " + id + " removido.");

		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new DaoException("Nao foi possivel remover o fabricante.");
		} finally {
			em.close();
		}
	}

	public void atualizarFabricante(Fabricante fabricante) throws DaoException{
		try {
			em = JPAUtil.getEntityManager();

			em.getTransaction().begin();
			this.em.merge(fabricante);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new DaoException("Nao foi possivel atualizar o fabricante.");
		} finally {
			em.close();
		}
	}


	public ArrayList<Fabricante> listarFabricantes() throws DaoException{  //estava List
		em = JPAUtil.getEntityManager(); /// sempre colocar 

		String queryList = "SELECT f FROM Fabricante f ORDER BY codigo_fabricante ASC";
		List<Fabricante> fabricanteList = em.createQuery(queryList, Fabricante.class).getResultList();
		return (ArrayList<Fabricante>) fabricanteList;
	}

	public List<Fabricante> buscarPorDesc(String desc) {
		em = JPAUtil.getEntityManager(); /// sempre colocar
		try {
			String queryList = "SELECT f FROM Fabricante f WHERE f.descricao LIKE :descricao";
			List<Fabricante> fabricanteList = em.createQuery(queryList, Fabricante.class)
					.setParameter("descricao", "%" + desc + "%").getResultList();

			return fabricanteList;

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro na pesquisa");
		} finally {
			em.close();
		}
		return null;
	}
}
package br.com.drogaria.dao;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.JPAUtil;

public class FabricanteDAO {

	private EntityManager em;

	public void cadastrarFabricante(Fabricante fabricante) {
		try {
			em = JPAUtil.getEntityManager(); /// sempre colocar nos métodos...
			em.getTransaction().begin();
			this.em.persist(fabricante);
			em.getTransaction().commit();
			System.out.println("Fabricante cadastrado.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Não foi possível cadastrar o fabricante.");
		} finally {
			em.close();
		}
	}

	public Fabricante buscarFabricante(int id) {
		if (em == null || !em.isOpen()) {
			em = JPAUtil.getEntityManager(); /// sempre colocar nos métodos...
		}
		return em.find(Fabricante.class, id);
	}

	public void removerFabricante(int id) {
		try {
			em = JPAUtil.getEntityManager(); /// sempre colocar nos métodos...
			em.getTransaction().begin();
			Fabricante buscaFabricante = this.buscarFabricante(id);
			System.out.println(buscaFabricante);
			this.em.remove(buscaFabricante);
			em.getTransaction().commit();
			System.out.println("Fabricante " + id + " removido.");

		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void atualizarFabricante(Fabricante fabricante) {
		try {
			em = JPAUtil.getEntityManager();
			
			em.getTransaction().begin();
			this.em.merge(fabricante);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}
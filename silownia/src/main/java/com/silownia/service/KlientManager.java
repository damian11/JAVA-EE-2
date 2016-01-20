package com.silownia.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.silownia.domain.Karnet;
import com.silownia.domain.Klient;

@Stateless
public class KlientManager {

	@PersistenceContext
	EntityManager em;

	public void addKlient(Klient klient) {
		klient.setId_klient(null);
		em.persist(klient);
	}

	public void deleteKlient(Klient klient) {
		klient = em.find(Klient.class, klient.getId());
		em.remove(klient);
	}

	@SuppressWarnings("unchecked")
	public List<Klient> getAllKlient() {
		return em.createNamedQuery("klient.all").getResultList();
	}

	public List<Karnet> getOwnedKarnet(Klient klient) {
		klient = em.find(Klient.class, klient.getId_klient());
		// lazy loading here - try this code without this (shallow) copying
		List<Karnet> karnety = new ArrayList<Karnet>(klient.getKarnety());
		return karnety;
	}

}

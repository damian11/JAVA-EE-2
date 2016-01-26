package com.silownia.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.hibernate.Hibernate;

import com.silownia.KlientDAO;
import com.silownia.KarnetDAO;
import com.silownia.domain.Karnet;
import com.silownia.domain.Klient;

@Stateless
public class KlientManager implements KlientDAO {


	@PersistenceContext
	EntityManager em;

	public Klient addKlient(Klient klient) {
		em.persist(klient);
	  em.flush();

		return klient;
	}

	public void deleteKlient(Klient klient) {
	  em.remove(em.getReference(Klient.class, klient.getId_klient()));
	}

	public Klient updateKlient(Klient klient)
    {
        return em.merge(klient);
    }



    public List<Klient> getAllKlient()
    {
        return em.createNamedQuery("klient.getAll").getResultList();
    }

    public Klient getKlientByID(Long id)
    {
        return em.find(Klient.class, id);
    }
}
}

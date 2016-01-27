package com.silownia.service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.silownia.domain.*;
import com.silownia.KlientDAO;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class KlientManager implements KlientDAO {


	@PersistenceContext
	EntityManager em;

	public Klient addKlient(Klient klient)
    {
		em.persist(klient);
	    em.flush();

		return klient;
	}

	public void deleteKlient(Klient klient) 
    {
	  em.remove(em.getReference(Klient.class, klient.getId_klient()));
	}

	public Klient updateKlient(Klient klient)
    {
        return (Klient)em.merge(klient);
    }



    public List<Klient> getAllKlient()
    {
        return em.createNamedQuery("klient.getAllKlient").getResultList();
    }

    public Klient getKlientById(Long id_klient)
    {
        return em.find(Klient.class, id_klient);
    }
    
    
    	public List<Klient> getKlientaByKarnetId(Karnet karnet){
        return em.createNamedQuery("klient.getKarnetById").
            setParameter("id_karnet",karnet.getId_karnet()).getResultList();
    }
}

package com.silownia.service;

import com.silownia.KarnetDAO;
import com.silownia.domain.Karnet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class KarnetManager implements KarnetDAO {

      @PersistenceContext
      EntityManager em;

      public karnet addKarnet(Karnet karnet)
      {
          em.persist(karnet);
          em.flush();
  
          return karnet;
      }

      public void deleteKarnet(Karnet karnet)
      {
          em.remove(em.getReference(Karnet.class, karnet.getIdKarnet()));
      }

      public Karnet updateKarnet(Karnet karnet)
      {
          return (Karnet)em.merge(karnet);
      }

      public List<Karnet> getAllKarnet()
      {
          return em.createNamedQuery("karnet.getAll").getResultList();
      }

      public Karnet getKarnetByID(Long id)
      {
          return em.find(Karnet.class, id);
      }
}

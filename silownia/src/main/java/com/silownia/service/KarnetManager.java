package com.silownia.service;
import org.hibernate.Hibernate;
import com.silownia.KarnetDAO;
import com.silownia.domain.Karnet;
import com.silownia.domain.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class KarnetManager implements KarnetDAO {

      @PersistenceContext
      EntityManager em;

      public Karnet addKarnet(Karnet karnet)
      {
          em.persist(karnet);
          em.flush();

          return karnet;
      }

      public void deleteKarnet(Karnet karnet)
      {
     em.remove(em.getReference(Karnet.class, karnet.getId_karnet()));
      }

      public Karnet updateKarnet(Karnet karnet)
      {
          return em.merge(karnet);
      }

      public List<Karnet> getAllKarnet()
      {
          return em.createNamedQuery("karnet.getAllKarnet").getResultList();
      }

      public Karnet getKarnetById(Long id_karnet)
      {
          return em.find(Karnet.class, id_karnet);
      }
}

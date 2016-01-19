
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.silownia.domain.Klient;
import com.silownia.domain.Karnet;


@Stateless
public class SprzedazManager {

  	@PersistenceContext
  	EntityManager em;

  	public void sprzedazKarnetu (Long id_karnet, Long id_klient) {

  		Klient klient = em.find(Klient.class, id_klient);
  		Karnet karnet = em.find(Karnet.class, id_karnet);


  	klient.getKarnety().add(karnet);
  	}

}

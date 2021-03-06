package com.silownia;

import com.silownia.domain.Karnet;
import java.util.List;

public interface KarnetDAO {

      List<Karnet> getAllKarnet();
      Karnet addKarnet(Karnet karnet);
      void deleteKarnet(Karnet karnet);
      Karnet updateKarnet(Karnet karnet);
      Karnet getKarnetById(long id_karnet);
}

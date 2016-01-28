package com.silownia;

import com.silownia.domain.Klient;
import java.util.List;

public interface KlientDAO {

  List<Klient> getAllKlient();
  Klient addKlient(Klient klient);
  void deleteKlient(Klient klient);
  Klient updateKlient(Klient klient);
  Klient getKlientById(Long id_klient);

}

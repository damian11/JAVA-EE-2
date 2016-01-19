package com.example.jeedemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "karnet.unsold", query = "Select k from Karnet k where k.sold = false")
public class Karnet {

	private Long id_karnet;
	private String rodzaj;
	private String opis;
	private String cena;
}
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Long getId_karnet() {
  return id_karnet;
}
public void setId_karnet(Long id) {
  this.id_karnet = id_karnet;
}
public String getRodzaj() {
  return rodzaj;
}
public void setRodzaj(String rodzaj) {
  this.rodzaj = rodzaj;
}
public String getOpis() {
  return opis;
}
public void setOpis(String opis) {
  this.opis = opis;
}
public void getCena() {
  return cena;
}
public void setCena(String cena) {
  this.cena = cena;
}
}

package com.silownia.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name = "karnet.getAll", query = "Select k from Karnet k"),
@NamedQuery(name = "karnet.getByID", query = "Select k from Karnet k where k.id_karnet = :id_karnet")
})
public class Karnet {

	private Long id_karnet;
	private String rodzaj;
	private String opis;
	private String cena;

  private List<Klient> klienci = new ArrayList<Klient>();

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
public double getCena() {
  return cena;
}
public void setCena(String cena) {
  this.cena = cena;
}


@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "karnet")
	@JsonIgnore
	public List<Klient> getKlients(){
			return klienci;
	}
	public void setKlients(List<Klient> klienci){
			this.klienci = klienci;
	}
}

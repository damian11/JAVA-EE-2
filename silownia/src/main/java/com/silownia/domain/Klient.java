package com.silownia.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "Klient")
@NamedQueries({
	@NamedQuery(name = "klient.getAll", query = "Select kl from Klient kl"),
	@NamedQuery(name = "klient.getKlientByID", query = "Select kl from Klient kl where kl.id_klient = :id_klient"),
	@NamedQuery(name = "klient.getKarnetByID", query = "Select kl from Klient kl where kl.karnet = :id_karnet")
})

public class Klient {

	private Long id_klient;
	private String imie;
	private String nazwisko;
	private String telefon;
	private Karnet karnet;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId_klient() {
		return id_klient;
	}
	public void setId_klient(Long id) {
		this.id_klient = id_klient;
	}


	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}


	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}


	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	@ManyToOne
    @JoinColumn(name = "id_karnet")
    public Karnet getKarnet(){
        return karnet;
    }
    public void setKarnet(Karnet karnet){
        this.karnet = karnet;
    }
}
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

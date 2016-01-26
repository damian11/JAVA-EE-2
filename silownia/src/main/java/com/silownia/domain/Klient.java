

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
	@NamedQuery(name = "klient.getAll", query = "Select kl from Klient kl")
	@NamedQuery(name = "klient.getByID", query = "Select kl from Klient kl where kl.id_klient = :id_klient"),
})

public class Klient {

	private Long id_klient;

	private String imie = "brak";
	private String nazwisko = "brak";
	private String telefon = "brak";

	private List<Klient> klienci = new ArrayList<Klient>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId_klient() {
		return id_klient;
	}
	public void setId_klient(Long id) {
		this.id_klient = id_klient;
	}

	@Size(min = 1, max = 50)
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}

	@Size(min = 1, max = 80)
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	@Size(min = 4, max = 30)
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Karnet> getKarnety() {
		return karnety;
	}
	public void setKarnety(List<Karnet> karnety) {
		this.karnety = karnety;
	}
}

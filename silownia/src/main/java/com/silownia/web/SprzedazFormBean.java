
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;




import com.silownia.domain.Karnet;
import com.silownia.domain.Klient;

import com.silownia.service.KlientManager;
import com.silownia.service.SprzedazManager;
import com.silownia.service.KarnetManager;

@SessionScoped
@Named("sprzedazBean")
public class SprzedazFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SprzedazManager sm;

	@Inject
	private KlientManager km;

	private Long id_karnet;
	private Long id_klient;

	public Long getId_karnet() {
		return id_karnet;
	}
	public void setId_karnet(Long id_karnet) {
		this.id_karnet = id_karnet;
	}
	public Long getId_klient() {
		return id_klient;
	}
	public void setId_klient(Long id_klient) {
		this.id_klient = id_klient;
	}

	public List<Karnet> getAvailableKarnety() {
		return sm.getAvailableKarnety();
	}

	public List<Klient> getAllKleint() {
		return km.getAllKlient();
	}

	public String sellKarnet() {
		sm.sellKarnet(id_klient, id_karnet);
		return null;
	}
}

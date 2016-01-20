
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.silownia.domain.Karnet;
import com.silownia.domain.Klient;

import com.silownia.service.KlientManager;
import com.silownia.service.SprzedazManager;
import com.silownia.service.KarnetManager;
@SessionScoped
@Named("klientBean")
public class KlientFormBean implements Serializable {


  	private static final long serialVersionUID = 1L;

  	private Klient klient = new klient();
  	private ListDataModel<Klient> klienci = new ListDataModel<Klient>();

  	private Klient KlientToShow = new Klient();
  	private ListDataModel<Karnet> ownedKarnety = new ListDataModel<Karnet>();


  	@Inject
  	private KlientManager km;

  	@Inject
  	private SprzedazManager sm;

  	public Klient getKlient() {
  		return klient;
  	}
  	public void setKlient(Klient klient) {
  		this.klient = klient;
  	}

  	public ListDataModel<Klient> getAllKlient() {
  		klienci.setWrappedData(km.getAllKlient());
  		return klienci;
  	}

  	public ListDataModel<Karnet> getOwnedKarnet() {
  		ownedKarnety.setWrappedData(km.getOwnedKarnety(KlientToShow));
  		return ownedKarnety;
  	}



    public String addKlient() {
      km.addKlient(klient);
      return "showKlienci";

    }

    public String deleteKlient() {
      Klient klientToDelete = klienci.getRowData();
      km.deleteKlient(klientToDelete);
      return null;
    }

    public String showDetails() {
      klientToShow = klienci.getRowData();
      return "details";
    }

    public String disposeKarnet(){
      Karnet karnetToDispose = ownedKlienci.getRowData();
      sm.disposeKarnet(klientToShow, karnetToDispose);
      return null;
    }

}

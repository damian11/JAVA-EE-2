package com.silownia.rest;

import com.silownia.KlientDAO;
import com.silownia.domain.Klient;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.util.List;

@Stateless
@Path("/klient")
public class KlientResource {
	
    @EJB
    private KarnetDAO karnetManager;
    
      @EJB
      private KlientDAO klientManager;

      @POST
      @Path("/addKlient")
      public Response addKlient(
          @FormParam("id_karnet") String karnet,
          @FormParam("imie") String imie,
          @FormParam("nazwisko") String nazwisko,
          @FormParam("telefon") String telefon)

      {
          Long id_karnet = Long.parseLong(karnet);
          Klient klient = new Klient();
          klient.setKarnet(karnetManager.getKarnetById(id_karnet));
          klient.setImie(imie);
          klient.setNazwisko(nazwisko);
          klient.setTelefon(telefon);

          klientManager.addKlient(klient);

          return Response.status(Response.Status.CREATED).build();
      }

      @GET
      @Path("/getAllKlient")
      @Produces(MediaType.APPLICATION_JSON)
      public List<Klient> getAllKlient() {
          return klientManager.getAllKlient();
      }

      @GET
      @Path("/getKlient/{id_klient}")
      @Produces(MediaType.APPLICATION_JSON)
      public Klient getKlientById(@PathParam("id_klient") Long id_klient) {
          return klientManager.getKlientById(id_klient);
      }

      @POST
      @Path("/deleteKlient")
      public Response deleteKlient(@FormParam("id_klient") long id_klient)
      {
          Klient klient = new Klient();

          klient.setId_klient(id_klient);
          klientManager.deleteKlient(klient);

          return Response.status(Response.Status.OK).build();
      }



      @POST
      @Path("/updateKlient")
      public Response updateKlient(
            @FormParam("id_klient") long id_klient,
            @FormParam("imie") String imie,
            @FormParam("nazwisko") String nazwisko,
            @FormParam("telefon") String telefon),
            @FormParam("karnet") String karnet)
      {
          Long id_karnet = Long.parseLong(karnet);        
          Klient klient = klientManager.getKlientById(id_klient);
          klient.setImie(imie);
          klient.setNazwisko(nazwisko);
          klient.setTelefon(telefon);
          klientManager.updateKlient(klient);      
          klient.setKarnet(karnetManager.getKarnetById(id_karnet));
		

          return Response.status(Response.Status.OK).build();
      }
}

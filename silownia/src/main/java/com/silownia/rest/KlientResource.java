package com.siłownia.rest;

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
      private KlientDAO klientManager;

      @POST
      @Path("/addKlient")
      public Response addKlient(
          @FormParam("imie") String imie,
          @FormParam("nazwisko") String nazwisko,
          @FormParam("telefon") String telefon)

      {
          Klient klient = new Klient();
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
      public Klient getKlientByID(@PathParam("id_klient") Long id_klient) {
          return klientManager.getKlientByID(id_klient);
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
            @FormParam("telefon") String telefon)
      {
          Klient klient = new Klient();
          klient.setId_klient(id_klient);
          klient.setImie(imie);
          klient.setNazwisko(nazwisko);
          klient.setTelefon(telefon);
          klientManager.updateKlient(klient);

          return Response.status(Response.Status.OK).build();
      }
}

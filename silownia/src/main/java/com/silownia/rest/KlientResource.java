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

    
}

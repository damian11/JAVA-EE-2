package com.siłownia.rest;

import com.silownia.KarnetDAO;
import com.silownia.domain.Karnet;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.util.List;


@Stateless
@Path("/karnet")
public class KarnetResource {

    @EJB
    private KarnetDAO karnetManager;

    @POST
    @Path("/addKarnet")
    public Response addKarnet(
                @FormParam("rodzaj") String rodzaj,
                @FormParam("opis") String opis,
                @FormParam("cena") double cena)
    {
        Karnet karnet = new Karnet();
        karnet.setRodzaj(rodzaj);
        karnet.setOpis(opis);
        karnet.setCena(cena);

        karnetManager.addKarnet(karnet);

        return Response.status(Response.Status.CREATED).build();
    }

}

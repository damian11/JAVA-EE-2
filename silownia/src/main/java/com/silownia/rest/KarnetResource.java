package com.silownia.rest;

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



    @GET
    @Path("/getKarnet/{id_karnet}")
    @Produces(MediaType.APPLICATION_JSON)
    public Karnet getKarnetById(@PathParam("id_karnet") Long id_karnet) {
        return karnetManager.getKarnetById(id_karnet);
    }

    @GET
    @Path("/getAllKarnet")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Karnet> getAllKarnet() {
        return karnetManager.getAllKarnet();
    }




    @POST
    @Path("/deleteKarnet")
    public Response deleteKarnet(@FormParam("id_karnet") long id_karnet)
    {
        Karnet karnet = new Karnet();
        karnet.setId_karnet(id_karnet);

        karnetManager.deleteKarnet(karnet);

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/updateKarnet")
    public Response updateKarnet(
    @FormParam("id_karnet") long id_karnet,
    @FormParam("rodzaj") String rodzaj,
    @FormParam("opis") String opis,
    @FormParam("cena") double cena)
{
      Karnet karnet = new Karnet();
      karnet.setId_karnet(id_karnet);
      karnet.setRodzaj(rodzaj);
      karnet.setOpis(opis);
      karnet.setCena(cena);


        karnetManager.updateKarnet(karnet);

        return Response.status(Response.Status.OK).build();
    }

}

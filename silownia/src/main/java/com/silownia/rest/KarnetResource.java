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


}

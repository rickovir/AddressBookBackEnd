/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.addressbook.resource;

import com.addressbook.app.Contact;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author start
 */
@Stateless
@Path("com.addressbook.app.contact")
public class ContactFacadeREST extends AbstractFacade<Contact> {

    @PersistenceContext(unitName = "AddressBookPU")
    private EntityManager em;

    public ContactFacadeREST() {
        super(Contact.class);
    }

//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(Contact entity) {
//        super.create(entity);
//    }
    
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    
    @GET
    @Path("buat/{id}/{firstname}/{lastname}/{phone}/{email}/{address}/{lat}/{lng}")
    public void buat(@PathParam("id") Long id,@PathParam("firstname") String firstname,@PathParam("lastname") String lastname, @PathParam("phone") String phone, @PathParam("address") String address,@PathParam("email") String email, @PathParam("lat") int lat,@PathParam("lng") int lng) {
        Contact entity = new Contact();
        entity.setId(id);
        entity.setFirstname(firstname);
        entity.setLastname(lastname);
        entity.setAddress(address);
        entity.setPhone(phone);
        entity.setEmail(email);
        entity.setLat(lat);
        entity.setLng(lng);
        super.create(entity);
    }

    @GET
    @Path("edit/{id}/{firstname}/{lastname}/{phone}/{email}/{address}/{lat}/{lng}")
    public void update(@PathParam("id") Long id,@PathParam("firstname") String firstname,@PathParam("lastname") String lastname, @PathParam("phone") String phone, @PathParam("address") String address,@PathParam("email") String email, @PathParam("lat") int lat,@PathParam("lng") int lng) {
        Contact entity = new Contact();
        entity.setId(id);
        entity.setFirstname(firstname);
        entity.setLastname(lastname);
        entity.setAddress(address);
        entity.setPhone(phone);
        entity.setEmail(email);
        entity.setLat(lat);
        entity.setLng(lng);
        super.edit(entity);
    }
    
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Long id, Contact entity) {
//        super.edit(entity);
//    }


    @GET
    @Path("hapus/{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }
    
//    @DELETE
//    @Path("{id}")
//    public void remove(@PathParam("id") Long id) {
//        super.remove(super.find(id));
//    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Contact find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Contact> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Contact> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}

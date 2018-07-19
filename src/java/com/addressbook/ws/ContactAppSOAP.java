/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.addressbook.ws;

import com.addressbook.app.Contact;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author start
 */
@WebService(serviceName = "ContactAppSOAP")
public class ContactAppSOAP {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getall")
    public List<Contact> getall(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        List<Contact> kontak = new ArrayList<Contact>();
        Contact kontak1 = new Contact();
        kontak1.setId(Long.MIN_VALUE);
        kontak1.setFirstname("Ricko");
        kontak.add(kontak1);
        return kontak;
    }
}

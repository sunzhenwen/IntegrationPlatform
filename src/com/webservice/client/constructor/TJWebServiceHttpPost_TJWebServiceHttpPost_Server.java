
package com.webservice.client.constructor;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 2.7.16
 * 2016-04-29T14:56:19.564+08:00
 * Generated source version: 2.7.16
 * 
 */
 
public class TJWebServiceHttpPost_TJWebServiceHttpPost_Server{

    protected TJWebServiceHttpPost_TJWebServiceHttpPost_Server() throws java.lang.Exception {
        System.out.println("Starting Server");
        Object implementor = new TJWebServiceHttpPostImpl();
        String address = "http://192.20.1.43:9090/TJWebService.asmx";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws java.lang.Exception { 
        new TJWebServiceHttpPost_TJWebServiceHttpPost_Server();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}

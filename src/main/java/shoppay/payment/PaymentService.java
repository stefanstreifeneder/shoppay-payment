/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppay.payment;

import shoppay.events.OrderEvent;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;








@Path("/pay")
@ManagedBean
@SessionScoped
@DeclareRoles({"admin, user"})
@RolesAllowed({"admin, user"})
@ServletSecurity(
 @HttpConstraint(transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL,
    rolesAllowed = {"admin, user"}))
public class PaymentService {

    
    /**
     * Creates a new instance of PaymentService
     */
    public PaymentService() {
    }

        
    
    
    @POST
    @Consumes("application/xml")
    public Response processPayment(OrderEvent order) {
        System.out.println("SS-PaymentService, processPayment, order: " + order.getAmount());
         if (order.getAmount() < 1000) {
            return Response.ok().build();
        } else {
            return Response.status(401).build();
        }
    }
    
    @GET
    @Produces("text/html")
    public String getHtml() {
        System.out.println("PaymentService, getHtml()");
        return "PaymentService";
    }
}

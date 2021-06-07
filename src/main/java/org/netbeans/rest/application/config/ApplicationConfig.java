package org.netbeans.rest.application.config;


import java.util.Set;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * The class is autogenerated by creating a Restful Java Pattern.
 * 
 * 
 * @author stefan.streifeneder@gmx.de
 * 
 * 
 */@ApplicationPath("payment")
@ManagedBean//runs without CustomerController
//if '@EJB UserBean userBean' then Attempting to execute an operation on a closed
@SessionScoped
@DeclareRoles({"admin, user"})
@RolesAllowed({"admin, user"})
@ServletSecurity(
 @HttpConstraint(transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL,
    rolesAllowed = {"admin, user"}))
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(shoppay.payment.PaymentService.class);
    }
    
}

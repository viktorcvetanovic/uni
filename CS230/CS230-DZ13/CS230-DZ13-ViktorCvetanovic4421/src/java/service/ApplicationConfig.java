/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author student
 */
@javax.ws.rs.ApplicationPath("webresources")
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
        resources.add(service.CustomersFacadeREST.class);
        resources.add(service.EmployeesFacadeREST.class);
        resources.add(service.OfficesFacadeREST.class);
        resources.add(service.OrderDetailsFacadeREST.class);
        resources.add(service.OrdersFacadeREST.class);
        resources.add(service.PaymentsFacadeREST.class);
        resources.add(service.ProductlinesFacadeREST.class);
        resources.add(service.ProductsFacadeREST.class);
    }
    
}

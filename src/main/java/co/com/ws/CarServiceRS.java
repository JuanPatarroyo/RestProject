/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ws;

import co.com.model.Car;
import co.com.service.EntityService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author jpatarroyo
 */
@Path("/car")
public class CarServiceRS {
    
    private EntityService<Car> service;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Car> cars() {
        return service.selectAll();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}") // /car/{id}
    public Car findById(@PathParam("id") int id) {
        return service.findById(new Car(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addCar(Car car) {
        try {
            service.add(car);
            return Response.ok().entity(car).build();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response modifyCar(@PathParam("id") int id, Car car) {
        try {
            Car car = service.getById(new Car(id));
            if (car == null) {
                return Response.status(Status.NOT_FOUND).build();
            }
            service.modify(car);
            return Response.ok().entity(car).build();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteById(@PathParam("id") int id) {
        try {
            service.deleteById(new Car(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}

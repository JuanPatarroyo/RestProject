/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ws;

import co.com.model.Car;
import co.com.service.EntityService;
import co.com.service.EntityServiceImpl;
import java.util.List;
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

    public CarServiceRS() {
        service = new EntityServiceImpl(Car.class);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Car> cars() {
        return service.selectAll("Car");
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}") // /car/{id}
    public Car findById(@PathParam("id") int id) {
        return service.selectById(new Car(id), id);
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/add/{id}")
    public Response addCar(Car car) {
        try {
            service.insert(car);
            return Response.ok().entity(car).build();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/modify/{id}")
    public Response modifyCar(@PathParam("id") int id, Car car) {
        try {
            Car carFound = service.selectById(new Car(id), id);
            if (carFound == null) {
                return Response.status(Status.NOT_FOUND).build();
            }
            service.update(car);
            return Response.ok().entity(car).build();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteById(@PathParam("id") int id) {
        try {
            service.delete(new Car(id), id);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}

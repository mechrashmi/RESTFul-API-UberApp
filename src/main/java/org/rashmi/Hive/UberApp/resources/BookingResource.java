package org.rashmi.Hive.UberApp.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.rashmi.Hive.UberApp.exceptions.CabNotFoundException;
import org.rashmi.Hive.UberApp.models.api.Car;
import org.rashmi.Hive.UberApp.models.impl.ErrorModel;
import org.rashmi.Hive.UberApp.models.impl.Receipt;
import org.rashmi.Hive.UberApp.models.impl.Rider;
import org.rashmi.Hive.UberApp.services.BookingService;
import org.rashmi.Hive.UberApp.services.impl.BookingServiceImpl;

@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingResource {
	private static BookingService service = new BookingServiceImpl();
	
	@GET
	public List<Car> getAll(){
		return service.getAllAvailable();
	}
	
	@POST
	public Response bookCab(Rider rider, @Context UriInfo uriInfo) {
		Car car = service.bookCab(rider);
		if(car == null) {
			throw new CabNotFoundException("No Cab Available!");
		}
		URI uri = uriInfo.getBaseUriBuilder().path(BookingResource.class).path(String.valueOf(car.getId())).path("release").build();
		
		return Response.created(uri).entity(car).build();
	}
	
	@PUT
	@Path("/{id}/release")
	public Response finishTrip(@PathParam("id") Integer id) {
		Receipt receipt = service.releaseCar(id);
		return Response.status(Status.OK).entity(receipt).build();
	}
	
}

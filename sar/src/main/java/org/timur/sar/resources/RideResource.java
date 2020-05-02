package org.timur.sar.resources;

import java.net.URI;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.timur.sar.model.Account;
import org.timur.sar.model.Join_ride_request;
import org.timur.sar.model.Message;
import org.timur.sar.model.Rating;
import org.timur.sar.model.Ride;
import org.timur.sar.service.RideService;

@Path("/rides")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RideResource 
{
	RideService rideService = new RideService();
	
	@GET
	public List<Ride> getMessages()
	{

		return rideService.getAllRides();
	}
	
	/*
	@GET
	@Path("/{rid}")
	public Ride getRide(@PathParam("rid") int rid)
	{
		return rideService.getRide(rid);
	}
	*/
	
	@POST
	public Response createRide(Ride ride, @Context UriInfo uriInfo)
	{
		
		Ride newRide = rideService.addRide(ride);
		String newId = String.valueOf(newRide.getRid());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newRide).build();
	}
	
	@PUT
	@Path("/{rid}")
	public void updateRide(@PathParam("rid") int rid, Ride ride)
	{
		ride.setRid(rid);
		Ride updateRide = rideService.updateRide(ride);
		Response.status(Status.NO_CONTENT).entity(updateRide).build();
	}
	
	@DELETE
	@Path("/{rid}")
	public void deleteRide(@PathParam("rid") int rid)
	{
		Ride deleteRide = rideService.removeRide(rid);
		Response.status(Status.NO_CONTENT).entity(deleteRide).build();
	}
	
	@POST
	@Path("/{rid}/join_requests")
	public Response joinRide(Join_ride_request jrr, @Context UriInfo uriInfo)
	{
		Join_ride_request newRequest = rideService.joinRide(jrr);
		String newId = String.valueOf(newRequest.getJid());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newRequest).build();
	}
	
	/*
	@PATCH
	@Path("/{rid}/join_requests/{jid}")
	public void confirmDenyRide(@PathParam("rid") int rid, @PathParam("jid") int jid, Join_ride_request jrr)
	{
		Join_ride_request newRequest = rideService.confirmDenyRideRequest(jrr);
		Response.status(Status.NO_CONTENT).entity(newRequest).build();
	}
	*/
	
	@POST
	@Path("/{rid}/messages")
	public Response addMessage(Message msg, @Context UriInfo uriInfo)
	{
		Message newMessage = rideService.addMessage(msg);
		String newId = String.valueOf(newMessage.getMid());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newMessage).build();
	}
	
	@GET
	@Path("/{rid}/messages")
	public List<Message> getAllMessages()
	{
		return rideService.viewAllRideMessages();
	}
}

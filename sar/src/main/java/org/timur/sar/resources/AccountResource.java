package org.timur.sar.resources;

import java.net.URI;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.timur.sar.model.Account;
import org.timur.sar.model.Rating;
import org.timur.sar.service.AccountService;

@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource
{
	AccountService accountService = new AccountService();
	
	@GET
	public List<Account> getAccountsWithKeyword(@QueryParam("key") String keyword)
	{
		if((keyword.equals("")))
		{
			return accountService.getAllAccounts();
		}
		else
		{
			return accountService.getAllAccountsWithKeyword(keyword);
		}
	}
	
	@GET
	@Path("/{aid}")
	public Account getAccount(@PathParam("aid") int aid)
	{
		return accountService.getAccount(aid);
	}
	
	@POST
	public Response createAccount(Account acc, @Context UriInfo uriInfo)
	{
		Account newAccount = accountService.addAccount(acc);
		String newId = String.valueOf(newAccount.getAccountID());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newAccount).build();
	}
	
	@PUT
	@Path("/{aid}/status")
	public void activateAccount(@PathParam("aid") int aid, Account acc)
	{
		acc.setAccountID(aid);
		Account activateAccount = accountService.activateAccount(acc);
		Response.status(Status.NO_CONTENT).entity(activateAccount).build();
	}
	
	@PUT
	@Path("/{aid}")
	public void updateAccount(@PathParam("aid") int aid, Account acc)
	{
		acc.setAccountID(aid);
		Account updateAccount = accountService.updateAccount(acc);
		Response.status(Status.NO_CONTENT).entity(updateAccount).build();
	}
	
	@DELETE
	@Path("/{aid}")
	public void deleteAccount(@PathParam("aid") int aid)
	{
		Account deleteAccount = accountService.removeAccount(aid);
		Response.status(Status.NO_CONTENT).entity(deleteAccount).build();
	}
	
	@POST
	@Path("/{aid}/ratings")
	public Response rateAccount(Rating rating, @Context UriInfo uriInfo)
	{
		Rating newRating = accountService.addRating(rating);
		String newId = String.valueOf(newRating.getSid());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newRating).build();
	}
}

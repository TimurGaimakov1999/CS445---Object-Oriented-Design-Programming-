package org.timur.sar.database;

import java.util.*;

import org.timur.sar.model.Account;
import org.timur.sar.model.Driver;
import org.timur.sar.model.Join_ride_request;
import org.timur.sar.model.Message;
import org.timur.sar.model.Rating;
import org.timur.sar.model.Ride;

public class DatabaseClass 
{
	private static Map<Integer, Account> accounts = new HashMap<>();
	private static ArrayList<Account> accounts_list = new ArrayList<Account>();
	
	private static Map<Integer, Ride> rides = new HashMap<>();
	private static ArrayList<Ride> rides_list = new ArrayList<Ride>();
	
	private static Map<Integer, Rating> ratings = new HashMap<>();
	private static ArrayList<Rating> ratings_list = new ArrayList<Rating>();
	
	private static Map<Integer, Driver> drivers = new HashMap<>();
	private static ArrayList<Driver> drivers_list = new ArrayList<Driver>();
	
	private static Map<Integer, Join_ride_request> join_ride_requests = new HashMap<>();
	private static ArrayList<Join_ride_request> join_ride_requests_list = new ArrayList<Join_ride_request>();
	
	private static Map<Integer, Message> messages = new HashMap<>();
	private static ArrayList<Message> messages_list = new ArrayList<Message>();
	
	public static Map<Integer, Account> getAccounts()
	{
		return accounts;
	}
	
	public static ArrayList<Account> getAccountsList()
	{
		return accounts_list;
	}
	
	public static Map<Integer, Ride> getRides()
	{
		return rides;
	}
	
	public static ArrayList<Ride> getRidesList()
	{
		return rides_list;
	}
	
	public static Map<Integer, Rating> getRatings()
	{
		return ratings;
	}
	
	public static ArrayList<Rating> getRatingsList()
	{
		return ratings_list;
	}
	
	public static Map<Integer, Driver> getDriver()
	{
		return drivers;
	}
	
	public static ArrayList<Driver> getDriversList()
	{
		return drivers_list;
	}
	
	public static Map<Integer, Join_ride_request> getJoin_ride_request()
	{
		return join_ride_requests;
	}
	
	public static ArrayList<Join_ride_request> getJoin_ride_requestList()
	{
		return join_ride_requests_list;
	}
	
	public static Map<Integer, Message> getMessages()
	{
		return messages;
	}
	
	public static ArrayList<Message> getMessageList()
	{
		return messages_list;
	}
}

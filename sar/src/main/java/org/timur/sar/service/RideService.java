package org.timur.sar.service;

import java.util.*;

import org.timur.sar.database.DatabaseClass;
import org.timur.sar.exception.DataNotFoundException;
import org.timur.sar.exception.BadRequestException;
import org.timur.sar.model.Car_info;
import org.timur.sar.model.Date_time;
import org.timur.sar.model.Detail;
import org.timur.sar.model.Driver;
import org.timur.sar.model.Join_ride_request;
import org.timur.sar.model.Location_info;
import org.timur.sar.model.Message;
import org.timur.sar.model.Rating;
import org.timur.sar.model.Ride;

import org.timur.sar.model.Account;
import org.timur.sar.service.AccountService;

public class RideService 
{
	private Map<Integer, Ride> rides = DatabaseClass.getRides();
	private ArrayList<Ride> rides_list = DatabaseClass.getRidesList();
	
	private Map<Integer, Driver> drivers = DatabaseClass.getDriver();
	private ArrayList<Driver> drivers_list = DatabaseClass.getDriversList();
	
	private Map<Integer, Join_ride_request> join_ride_requests = DatabaseClass.getJoin_ride_request();
	private ArrayList<Join_ride_request> join_ride_requests_list = DatabaseClass.getJoin_ride_requestList();
	
	private Map<Integer, Message> messages = DatabaseClass.getMessages();
	private ArrayList<Message> messages_list = DatabaseClass.getMessageList();
	
	int number_of_rides = 0;
	ArrayList<Integer> takenDriverAccountIds = new ArrayList<Integer>();
	
	String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
			"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	String[] colors = {"Red", "Blue", "White", "Black", "Silver", "Yellow", "Brown", 
						"Gray", "Green", "Purple", "Orange"};
	String[] makes = {"Audi", "BMW", "Toyota", "Subaru", "Mercedes Benz", "Honda", "Nissan",
						"Mazda", "Mitsubishi", "Ford", "Chevrolet", "Dodge", "Cadillac",
						"Hyundai", "Acura", "Volkswagen", "Pontiac", "Porsche", "Suzuki",
						"Fiat", "Lexus"};
	String[] plate_states = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
								"HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
								"MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
								"NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
								"SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
	
	public RideService()
	{

	}
	
	public ArrayList<Ride> getAllRides()
	{
		ArrayList<Ride> ride = new ArrayList<Ride>();
		for(int i = 0; i < rides_list.size(); i++)
		{
			Ride r = new Ride((rides_list.get(i)).getRid(), (rides_list.get(i)).getLocation_info(), 
					(rides_list.get(i)).getDate_time());
			ride.add(r);
		}
		return ride;
	}
	
	/*
	public Detail getRideDetails(int rid)
	{
		Ride ride1 = findByIdRide(rid);
		Detail detail = null;
		if(ride1 == null)
		{
			throw new DataNotFoundException("The ride identified by " + rid + 
					" doesn't exists");
		}
		else
		{
			detail = new Detail(ride1.getRid(), ride1.getLocation_info(), ride1.getDate_time(),
					ride1.getCar_info(), (searchDriver_byAccountId(ride1.getAid())).getFirst_name(),
					(searchDriver_byAccountId(ride1.getAid())).getPicture(),
					how_many_rides_does_this_driver_has((searchDriver_byAccountId(ride1.getAid())).getAid()),
					how_many_ratings_does_this_driver_has((searchDriver_byAccountId(ride1.getAid())).getAid()),
					);
		}
		return detail;
	}
	*/
	
	public Ride addRide(Ride ride)
	{
		Ride ride1;
		
		String from_city_Str = (ride.getLocation_info()).getFrom_city();
		String from_zip_Str = (ride.getLocation_info()).getFrom_zip();
		String to_city_Str = (ride.getLocation_info()).getTo_city();
		String to_zip_Str = (ride.getLocation_info()).getTo_zip();
		
		String date1 = (ride.getDate_time()).getDate();
		String time1 = (ride.getDate_time()).getTime();
		
		String make = (ride.getCar_info()).getMake();
		String model = (ride.getCar_info()).getModel();
		String color = (ride.getCar_info()).getColor();
		String plate_state = (ride.getCar_info()).getPlate_state();
		String plate_serial = (ride.getCar_info()).getPlate_serial();

		int max_passengers = ride.getMax_passengers();
		double amount_per_passenger = ride.getAmount_per_passenger();
		
		if(ride.getAid() < 0) //passed
		{
			throw new BadRequestException("Invalid aid. List of available accounts aids: " 
											+ listAvailableAccounts());
		}
		else if(checkAccounts_for_accountID(ride.getAid()) == false) //passed
		{
			throw new BadRequestException("The account identified by " + ride.getAid() + " is not created. "
					+ "Create the account first or enter available account aids: " +
					listAvailableAccounts());
		}
		else if(checkAccounts_if_accountID_isActivated(ride.getAid()) == false) //passed
		{
			throw new BadRequestException("The account identified by " + ride.getAid() + " is not active. "
					+ "Activate the account first or enter active account aids: " +
					listActiveAccounts());
		}
		else if(from_city_Str.equals("")) //passed
		{
			throw new BadRequestException("Invalid location_info: 'from_city' can't be empty");
		}
		else if(!(from_city_Str.matches("[a-zA-Z]+"))) //passed
		{
			throw new BadRequestException("Invalid location_info: 'from_city' can have only letters");
		}
		else if(from_zip_Str.equals("")) //passed
		{
			throw new BadRequestException("Invalid location_info: 'from_zip' can't be empty");
		}
		else if(!(from_zip_Str.matches("^[0-9]+$"))) //passed
		{
			throw new BadRequestException("Invalid location_info: 'from_zip' can have only numbers");
		}
		else if(from_zip_Str.length() != 5) //passed
		{
			throw new BadRequestException("Invalid location_info: 'from_zip' must have length of 5");
		}
		else if(to_city_Str.equals("")) //passed
		{
			throw new BadRequestException("Invalid location_info: 'to_city' can't be empty");
		}
		else if(!(to_city_Str.matches("[a-zA-Z]+"))) //passed
		{
			throw new BadRequestException("Invalid location_info: 'to_city' can have only letters");
		}
		else if(to_zip_Str.equals("")) //passed
		{
			throw new BadRequestException("Invalid location_info: 'to_zip' can't be empty");
		}
		else if(!(to_zip_Str.matches("^[0-9]+$"))) //passed
		{
			throw new BadRequestException("Invalid location_info: 'to_zip' can have only numbers");
		}
		else if(to_zip_Str.length() != 5) //passed
		{
			throw new BadRequestException("Invalid location_info: 'to_zip' must have length of 5");
		}
		else if(date1.equals("")) //passed
		{
			throw new BadRequestException("Invalid date_time: 'date' can't be empty");
		}
		
		else if( !( ((date1.substring(2, 3)).equals("-")) &&
				((date1.substring(6, 7)).equals("-"))
				&& (date1.length() == 11) )) //passed
		{
			throw new BadRequestException("Invalid date_time: 'date' format is ##-XXX-#### (DD-MMM-YYYY)");
		}
		
		else if( !( (date1.substring(0, 2).matches("^[0-9]+$")) 
				&& (date1.substring(7, 11).matches("^[0-9]+$")) )) //passed
		{
			throw new BadRequestException("Invalid date_time: 'date' day and year must have numbers "
					+ "(Ex. 01-Apr-2020)");
		}
	
		else if(!(date1.substring(3, 6).matches("[a-zA-Z]+"))) //passed
		{
			throw new BadRequestException("Invalid date_time: 'date' month can only have letters");
		}
		
		else if( (Integer.parseInt(date1.substring(0, 2)) < 1) ||  (Integer.parseInt(date1.substring(0, 2)) > 30) 
				|| (Integer.parseInt(date1.substring(7, 11)) != 2020)) //passed
		{
			throw new BadRequestException("Invalid date_time: 'date' ranges from 01-MMM-2020 to 30-MMM-2020 "
					+ "(2020 is the only year)");
		}
		
		else if(monthChecker(date1.substring(3, 6)) == false) //passed
		{
			throw new BadRequestException("Invalid date_time: 'date' month entered is not correct. " + 
						"Month must be in one of these forms: " + monthList_abbreviation());
		}
		
		else if(time1.equals("")) //passed
		{
			throw new BadRequestException("Invalid date_time: 'time' can't be empty");
		}
		
		
		else if(!(time1.substring(2, 3).equals(":") && (time1.length() == 5))) //passed
		{
			throw new BadRequestException("Invalid date_time: 'time' format is ##:## (HH-MM)");
		}
		
		else if( !( (time1.substring(0, 2).matches("^[0-9]+$")) 
				&& (time1.substring(3, 5).matches("^[0-9]+$")) )) //passed
		{
			throw new BadRequestException("Invalid date_time: 'time' hours and minutes must have numbers "
					+ "(Ex. 09:58)");
		}
		
		else if( (Integer.parseInt(time1.substring(0, 2)) < 0) 
				|| (Integer.parseInt(time1.substring(0, 2)) > 23) 
				|| (Integer.parseInt(time1.substring(3, 5)) < 0) 
				|| (Integer.parseInt(time1.substring(3, 5)) > 59) ) //passed but incorrect
		{
			throw new BadRequestException("Invalid date_time: 'time' ranges from 00:00 to 23:59");
		}
		
		else if(make.equals("")) //passed
		{
			throw new BadRequestException("Invalid car_info: 'make' can't be empty");
		}
		else if(!(make.matches("[a-zA-Z]+"))) //passed
		{
			throw new BadRequestException("Invalid car_info: 'make' can only have letters");
		}
		else if(makeChecker(make) == false) //passed
		{
			throw new BadRequestException("Invalid car_info: 'make' entered is not correct. " + 
					"These are available makes: " + makeList());
		}
		else if(model.equals("")) //passed
		{
			throw new BadRequestException("Invalid car_info: 'model' can't be empty");
		}
		else if(color.equals("")) //passed
		{
			throw new BadRequestException("Invalid car_info: 'color' can't be empty");
		}
		else if(!(color.matches("[a-zA-Z]+"))) //passed
		{
			throw new BadRequestException("Invalid car_info: 'color' can only have letters");
		}
		else if(colorChecker(color) == false) //passed
		{
			throw new BadRequestException("Invalid car_info: 'color' entered is not correct. " + 
					"These are available colors: " + colorList());
		}
		else if(plate_state.equals("")) //passed
		{
			throw new BadRequestException("Invalid car_info: 'plate_state' can't be empty");
		}
		else if(!(plate_state.matches("[a-zA-Z]+"))) //passed
		{
			throw new BadRequestException("Invalid car_info: 'plate_state' can only have letters");
		}
		else if(plate_stateChecker(plate_state) == false) //passed
		{
			throw new BadRequestException("Invalid car_info: 'plate_state' entered is not correct. " + 
					"These are available colors: " + plate_stateList());
		}
		else if(plate_serial.equals("")) //passed
		{
			throw new BadRequestException("Invalid car_info: 'plate_serial' can't be empty");
		}
		else if(max_passengers < 1) //passed
		{
			throw new BadRequestException("Invalid max_passengers: 'max_passengers' must be at least 1");
		}
		else if(amount_per_passenger < 0.00) //passed
		{
			throw new BadRequestException("Invalid amount_per_passenger: 'amount_per_passenger' must be have 0.00 or higher");
		}
		else
		{
			number_of_rides = number_of_rides + 1;
			rides.put(ride.getRid(), ride);
			rides_list.add(ride);
			/*
			if(drivers_list.size() == 0)
			{
				drivers_list.add(new Driver((findAccount_by_accountID(ride.getAid())).getAccountID(),
						(findAccount_by_accountID(ride.getAid())).getFirst_name(),
						(findAccount_by_accountID(ride.getAid())).getPicture(), 0,
						(findAccount_by_accountID(ride.getAid())).getNumber_of_ratings(), 0.0));
				
				(drivers_list.get(0)).addRide(ride);
				takenDriverAccountIds.add((findAccount_by_accountID(ride.getAid())).getAccountID());
			}			
			else if(drivers_list.size() > 0)
			{
				for(int i = 0; i < drivers_list.size(); i++)
				{
					if(takenDriverAccountIds.contains((findAccount_by_accountID(ride.getAid())).getAccountID()))
					{
						for(int k = 0; k < takenDriverAccountIds.size(); k++)
						{
							if((takenDriverAccountIds.get(k)) == ((findAccount_by_accountID(ride.getAid())).getAccountID()))
							{
								(drivers_list.get(k)).addRide(ride);
							}
						}
					}
					else if(!(takenDriverAccountIds.contains((findAccount_by_accountID(ride.getAid())).getAccountID())))
					{
						drivers_list.add(new Driver((findAccount_by_accountID(ride.getAid())).getAccountID(),
								(findAccount_by_accountID(ride.getAid())).getFirst_name(),
								(findAccount_by_accountID(ride.getAid())).getPicture(), 0,
								(findAccount_by_accountID(ride.getAid())).getNumber_of_ratings(), 0.0));
						
						(drivers_list.get(i + 1)).addRide(ride);
						takenDriverAccountIds.add((findAccount_by_accountID(ride.getAid())).getAccountID());
					}
				}
			}
			*/
			ride1 = new Ride(ride.getRid());
		}
		return ride1;
	}
	
	public int how_many_rides_does_this_driver_has(int aid)
	{
		return (searchDriver_byAccountId(aid)).getNumber_of_rides();
	}
	
	public int how_many_ratings_does_this_driver_has(int aid)
	{
		return (searchDriver_byAccountId(aid)).getNumber_of_ratings();
	}
	
	/*
	public double calculate_average_Rating_of_this_Driver(int aid)
	{
		Driver driver = searchDriver_byAccountId(aid);
	}
	*/
	
	public Ride updateRide(Ride ride) 
	{
		Ride ride1 = rides.get(ride.getRid());
		
		String from_city_Str = (ride.getLocation_info()).getFrom_city();
		String from_zip_Str = (ride.getLocation_info()).getFrom_zip();
		String to_city_Str = (ride.getLocation_info()).getTo_city();
		String to_zip_Str = (ride.getLocation_info()).getTo_zip();
		
		String date1 = (ride.getDate_time()).getDate();
		String time1 = (ride.getDate_time()).getTime();
		
		String make = (ride.getCar_info()).getMake();
		String model = (ride.getCar_info()).getModel();
		String color = (ride.getCar_info()).getColor();
		String plate_state = (ride.getCar_info()).getPlate_state();
		String plate_serial = (ride.getCar_info()).getPlate_serial();

		int max_passengers = ride.getMax_passengers();
		double amount_per_passenger = ride.getAmount_per_passenger();
		
		if(ride1 == null)
		{
			throw new DataNotFoundException("The ride identified by " + ride.getRid() + 
					" doesn't exists");
		}
		if(ride.getAid() < 0) //passed
		{
			throw new BadRequestException("Invalid aid. List of available accounts aids: " 
											+ listAvailableAccounts());
		}
		else if(checkAccounts_for_accountID(ride.getAid()) == false) //passed
		{
			throw new BadRequestException("The account identified by " + ride.getAid() + " is not created. "
					+ "Create the account first or enter available account aids: " +
					listAvailableAccounts());
		}
		else if(checkAccounts_if_accountID_isActivated(ride.getAid()) == false) //passed
		{
			throw new BadRequestException("The account identified by " + ride.getAid() + " is not active. "
					+ "Activate the account first or enter active account aids: " +
					listActiveAccounts());
		}
		else if(from_city_Str.equals("")) //passed
		{
			throw new BadRequestException("Invalid location_info: 'from_city' can't be empty");
		}
		else if(!(from_city_Str.matches("[a-zA-Z]+"))) //passed
		{
			throw new BadRequestException("Invalid location_info: 'from_city' can have only letters");
		}
		else if(from_zip_Str.equals("")) //passed
		{
			throw new BadRequestException("Invalid location_info: 'from_zip' can't be empty");
		}
		else if(!(from_zip_Str.matches("^[0-9]+$"))) //passed
		{
			throw new BadRequestException("Invalid location_info: 'from_zip' can have only numbers");
		}
		else if(from_zip_Str.length() != 5) //passed
		{
			throw new BadRequestException("Invalid location_info: 'from_zip' must have length of 5");
		}
		else if(to_city_Str.equals("")) //passed
		{
			throw new BadRequestException("Invalid location_info: 'to_city' can't be empty");
		}
		else if(!(to_city_Str.matches("[a-zA-Z]+"))) //passed
		{
			throw new BadRequestException("Invalid location_info: 'to_city' can have only letters");
		}
		else if(to_zip_Str.equals("")) //passed
		{
			throw new BadRequestException("Invalid location_info: 'to_zip' can't be empty");
		}
		else if(!(to_zip_Str.matches("^[0-9]+$"))) //passed
		{
			throw new BadRequestException("Invalid location_info: 'to_zip' can have only numbers");
		}
		else if(to_zip_Str.length() != 5) //passed
		{
			throw new BadRequestException("Invalid location_info: 'to_zip' must have length of 5");
		}
		else if(date1.equals("")) //passed
		{
			throw new BadRequestException("Invalid date_time: 'date' can't be empty");
		}
		
		else if( !( ((date1.substring(2, 3)).equals("-")) &&
				((date1.substring(6, 7)).equals("-"))
				&& (date1.length() == 11) )) //passed
		{
			throw new BadRequestException("Invalid date_time: 'date' format is ##-XXX-#### (DD-MMM-YYYY)");
		}
		
		else if( !( (date1.substring(0, 2).matches("^[0-9]+$")) 
				&& (date1.substring(7, 11).matches("^[0-9]+$")) )) //passed
		{
			throw new BadRequestException("Invalid date_time: 'date' day and year must have numbers "
					+ "(Ex. 01-Apr-2020)");
		}
	
		else if(!(date1.substring(3, 6).matches("[a-zA-Z]+"))) //passed
		{
			throw new BadRequestException("Invalid date_time: 'date' month can only have letters");
		}
		
		else if( (Integer.parseInt(date1.substring(0, 2)) < 1) ||  (Integer.parseInt(date1.substring(0, 2)) > 31) 
				|| (Integer.parseInt(date1.substring(7, 11)) != 2020)) //passed
		{
			throw new BadRequestException("Invalid date_time: 'date' ranges from 01-MMM-2020 to 30-MMM-2020 "
					+ "(2020 is the only year)");
		}
		
		else if(monthChecker(date1.substring(3, 6)) == false) //passed
		{
			throw new BadRequestException("Invalid date_time: 'date' month entered is not correct. " + 
						"Month must be in one of these forms: " + monthList_abbreviation());
		}
		
		else if(time1.equals("")) //passed
		{
			throw new BadRequestException("Invalid date_time: 'time' can't be empty");
		}
		
		
		else if(!(time1.substring(2, 3).equals(":") && (time1.length() == 5))) //passed
		{
			throw new BadRequestException("Invalid date_time: 'time' format is ##:## (HH-MM)");
		}
		
		else if( !( (time1.substring(0, 2).matches("^[0-9]+$")) 
				&& (time1.substring(3, 5).matches("^[0-9]+$")) )) //passed
		{
			throw new BadRequestException("Invalid date_time: 'time' hours and minutes must have numbers "
					+ "(Ex. 09:58)");
		}
		
		else if( (Integer.parseInt(time1.substring(0, 2)) < 0) 
				|| (Integer.parseInt(time1.substring(0, 2)) > 23) 
				|| (Integer.parseInt(time1.substring(3, 5)) < 0) 
				|| (Integer.parseInt(time1.substring(3, 5)) > 59) ) //passed but incorrect
		{
			throw new BadRequestException("Invalid date_time: 'time' ranges from 00:00 to 23:59");
		}
		
		else if(make.equals("")) //passed
		{
			throw new BadRequestException("Invalid car_info: 'make' can't be empty");
		}
		else if(!(make.matches("[a-zA-Z]+"))) //passed
		{
			throw new BadRequestException("Invalid car_info: 'make' can only have letters");
		}
		else if(makeChecker(make) == false) //passed
		{
			throw new BadRequestException("Invalid car_info: 'make' entered is not correct. " + 
					"These are available makes: " + makeList());
		}
		else if(model.equals("")) //passed
		{
			throw new BadRequestException("Invalid car_info: 'model' can't be empty");
		}
		else if(color.equals("")) //passed
		{
			throw new BadRequestException("Invalid car_info: 'color' can't be empty");
		}
		else if(!(color.matches("[a-zA-Z]+"))) //passed
		{
			throw new BadRequestException("Invalid car_info: 'color' can only have letters");
		}
		else if(colorChecker(color) == false) //passed
		{
			throw new BadRequestException("Invalid car_info: 'color' entered is not correct. " + 
					"These are available colors: " + colorList());
		}
		else if(plate_state.equals("")) //passed
		{
			throw new BadRequestException("Invalid car_info: 'plate_state' can't be empty");
		}
		else if(!(plate_state.matches("[a-zA-Z]+"))) //passed
		{
			throw new BadRequestException("Invalid car_info: 'plate_state' can only have letters");
		}
		else if(plate_stateChecker(plate_state) == false) //passed
		{
			throw new BadRequestException("Invalid car_info: 'plate_state' entered is not correct. " + 
					"These are available colors: " + plate_stateList());
		}
		else if(plate_serial.equals("")) //passed
		{
			throw new BadRequestException("Invalid car_info: 'plate_serial' can't be empty");
		}
		else if(max_passengers < 1) //passed
		{
			throw new BadRequestException("Invalid max_passengers: 'max_passengers' must be at least 1");
		}
		else if(amount_per_passenger < 0.00) //passed
		{
			throw new BadRequestException("Invalid amount_per_passenger: 'amount_per_passenger' must be have 0.00 or higher");
		}
		else
		{
			rides.put(ride.getRid(), ride);
			for(int i = 0; i < rides_list.size(); i++)
			{
				if((rides_list.get(i)).getRid() == ride.getRid())
				{
					rides_list.set(i, ride);
				}
			}
		}
		return ride;
	}
	
	public Ride removeRide(int rid) 
	{
		Ride ride1 = rides.get(rid);
		if(ride1 == null)
		{
			throw new DataNotFoundException("The ride identified by " + rid + 
					" doesn't exists");
		}
		for(int i = 0; i < rides_list.size(); i++)
		{
			if(rid == (rides_list.get(i)).getRid())
			{
				rides_list.remove(i);
			}
		}
		return rides.remove(rid);
	}
	
	/*
	public ArrayList<Ride> getAllAccountsWithKeywords(String from, String to, String date)
	{
		ArrayList<Ride> rideSearch = new ArrayList<Ride>();
		for(int i = 0; i < rides_list.size(); i++)
		{
			if(((rides_list.get(i)).getFirst_name()).equalsIgnoreCase(keyword) || 
				((rides_list.get(i)).getLast_name()).equalsIgnoreCase(keyword) ||
				((rides_list.get(i)).getPhone()).equals(keyword))
			{
				Account tempAcc = new Account((accounts_list.get(i)).getAccountID(),
						(accounts_list.get(i)).getFirst_name() + " " + (accounts_list.get(i)).getLast_name(),
						(accounts_list.get(i)).getDate_created(), (accounts_list.get(i)).isIs_active());				
				accountSearch.add(tempAcc);
			}
		}
		return accountSearch;
	}
	*/
	
	public Join_ride_request joinRide(Join_ride_request jrr)
	{
		Join_ride_request jrr1;
		if(jrr.getRide_confirmed() != null)
		{
			throw new BadRequestException("Invalid value for ride_confirmed");
		}
		else if(jrr.getPickup_confirmed() != null)
		{
			throw new BadRequestException("Invalid value for pickup_confirmed");
		}
		else if((checkAccounts_for_accountID(jrr.getAid()) == false))
		{
			throw new BadRequestException("The account identified by " + jrr.getAid() + " is not created. "
					+ "Create the account first or enter available account aids: " +
					listAvailableAccounts());
		}
		else if(checkAccounts_if_accountID_isActivated(jrr.getAid()) == false) //passed
		{
			throw new BadRequestException("The account identified by " + jrr.getAid() + " is not active. "
					+ "Activate the account first or enter active account aids: " +
					listActiveAccounts());
		}
		else 
		{
			join_ride_requests.put(jrr.getJid(), jrr);
			join_ride_requests_list.add(jrr);
			jrr1 = new Join_ride_request(jrr.getJid());
		}
		return jrr1;
	}
	
	public Join_ride_request confirmDenyRideRequest(Join_ride_request jrr)
	{
		Join_ride_request jrr1;
		if(jrr.getRide_confirmed() == null)
		{
			throw new BadRequestException("Invalid value for ride_confirmed");
		}
		else if(checkAccounts_for_accountID(jrr.getAid()) == false)
		{
			throw new BadRequestException("The account identified by " + jrr.getAid() + " is not created. "
					+ "Create the account first or enter available account aids: " +
					listAvailableAccounts());
		}
		else
		{
			jrr1 = new Join_ride_request(jrr.getAid(), jrr.getRide_confirmed());
		}
		return jrr1;
	}
	
	public Message addMessage(Message msg)
	{
		Message msg1;
		if((checkAccounts_for_accountID(msg.getAid()) == false))
		{
			throw new BadRequestException("The account identified by " + msg.getAid() + " is not created. "
					+ "Create the account first or enter available account aids: " +
					listAvailableAccounts());
		}
		else if(checkAccounts_if_accountID_isActivated(msg.getAid()) == false) //passed
		{
			throw new BadRequestException("The account identified by " + msg.getAid() + " is not active. "
					+ "Activate the account first or enter active account aids: " +
					listActiveAccounts());
		}
		else 
		{
			messages.put(msg.getMid(), msg);
			messages_list.add(msg);
			msg1 = new Message(msg.getMid());
		}
		return msg1;
	}
	
	public ArrayList<Message> viewAllRideMessages()
	{
		ArrayList<Message> msgs = new ArrayList<Message>();
		for(int i = 0; i < messages_list.size(); i++)
		{
			Message msg = new Message((messages_list.get(i)).getMid(), (messages_list.get(i)).getAid(),
					(messages_list.get(i)).getDate(), (messages_list.get(i)).getMessage());
			msgs.add(msg);
		}
		return msgs;
	}
	
	public Ride findByIdRide(int rid) 
    {
        Iterator<Ride> rides = rides_list.listIterator();
        while(rides.hasNext()) 
        {
        	Ride ride = rides.next();
            if(ride.matchesId(rid) == true) 
            {
            	return(ride);
            }
        }
        return null;
    }
	
	public boolean monthChecker(String month)
	{
		boolean dec = false;
		for(int i = 0; i < months.length; i++)
		{
			if((months[i]).equalsIgnoreCase(month))
			{
				dec = true;
			}
		}
		return dec;
	}
	
	public String monthList_abbreviation()
	{
		String list = "(";
		for(int i = 0; i < months.length; i++)
		{
			if(i == months.length - 1)
			{
				list += (months[i] + ")");
			}
			else
			{
				list += (months[i] + ", ");
			}
		}
		return list;
	}
	
	public boolean colorChecker(String color)
	{
		boolean dec = false;
		for(int i = 0; i < colors.length; i++)
		{
			if((colors[i]).equalsIgnoreCase(color))
			{
				dec = true;
			}
		}
		return dec;
	}
	
	public String colorList()
	{
		String list = "(";
		for(int i = 0; i < colors.length; i++)
		{
			if(i == colors.length - 1)
			{
				list += (colors[i] + ")");
			}
			else
			{
				list += (colors[i] + ", ");
			}
		}
		return list;
	}
	
	public boolean makeChecker(String make)
	{
		boolean dec = false;
		for(int i = 0; i < makes.length; i++)
		{
			if((makes[i]).equalsIgnoreCase(make))
			{
				dec = true;
			}
		}
		return dec;
	}
	
	public String makeList()
	{
		String list = "(";
		for(int i = 0; i < makes.length; i++)
		{
			if(i == makes.length - 1)
			{
				list += (makes[i] + ")");
			}
			else
			{
				list += (makes[i] + ", ");
			}
		}
		return list;
	}
	
	public boolean plate_stateChecker(String plate_state)
	{
		boolean dec = false;
		for(int i = 0; i < plate_states.length; i++)
		{
			if((plate_states[i]).equalsIgnoreCase(plate_state))
			{
				dec = true;
			}
		}
		return dec;
	}
	
	public String plate_stateList()
	{
		String list = "(";
		for(int i = 0; i < plate_states.length; i++)
		{
			if(i == plate_states.length - 1)
			{
				list += (plate_states[i] + ")");
			}
			else
			{
				list += (plate_states[i] + ", ");
			}
		}
		return list;
	}
	
	public boolean checkAccounts_for_accountID(int aid)
	{
		boolean dec = false;
		AccountService accService = new AccountService();
		ArrayList<Account> accounts = accService.getAllAccounts();
		for(int i = 0; i < accounts.size(); i++)
		{
			if(aid == (accounts.get(i)).getAccountID())
			{
				dec = true;
			}
		}
		return dec;
	}
	
	public Account findAccount_by_accountID(int aid)
	{
		Account acc = null;
		AccountService accService = new AccountService();
		ArrayList<Account> accounts = accService.getAllAccounts_with_num_of_ratings();
		for(int i = 0; i < accounts.size(); i++)
		{
			if(aid == (accounts.get(i)).getAccountID())
			{
				acc = new Account((accounts.get(i)).getAccountID(), (accounts.get(i)).getFirst_name(),
						(accounts.get(i)).getPicture(), (accounts.get(i)).getNumber_of_ratings());
			}
		}
		return acc;
	}
	
	public int getNum_of_Ratings()
	{
		AccountService accService = new AccountService();
		return (accService.getNumber_of_Ratings());
	}
	
	public boolean checkAccounts_if_accountID_isActivated(int aid)
	{
		boolean dec = false;
		AccountService accService = new AccountService();
		ArrayList<Account> accounts = accService.getAllAccounts();
		for(int i = 0; i < accounts.size(); i++)
		{
			if(aid == (accounts.get(i)).getAccountID())
			{
				if(accounts.get(i).isIs_active() == true)
				{
					dec = true;
				}
			}
		}
		return dec;
	}
	
	public double calculateAverageRating_of_this_Account(Account acc)
	{
		AccountService accountService = new AccountService();
		ArrayList<Rating> ratings_2 = accountService.getAllRatings();
		
		int total = 0;
		ArrayList<Ride> all_rides = getAllRides();
		for(int i = 0; i < all_rides.size(); i++)
		{
			if((all_rides.get(i)).getAid() == acc.getAccountID())
			{
				total = total + (all_rides.get(i)).getAid();
			}
		}
		if(ratings_2.size() == 0)
		{
			throw new BadRequestException("Invalid result: 'rating' is to be divided by 0");
		}
		return (total/ ratings_2.size());
	}
	
	public String listAvailableAccounts()
	{
		String list = "(";
		AccountService accService = new AccountService();
		ArrayList<Account> accounts = accService.getAllAccounts();
		for(int i = 0; i < accounts.size(); i++)
		{
			if(i == accounts.size() - 1)
			{
				list += ((accounts.get(i)).getAccountID() + ")");
			}
			else 
			{
				list += ((accounts.get(i)).getAccountID() + ", ");
			}
		}
		return list;
	}
	
	public String listActiveAccounts()
	{
		String list = "(";
		AccountService accService = new AccountService();
		ArrayList<Account> accounts = accService.getAllAccounts();
		for(int i = 0; i < accounts.size(); i++)
		{
			if((accounts.get(i)).isIs_active() == true)
			{
				if(i == accounts.size() - 1)
				{
					list += ((accounts.get(i)).getAccountID() + ")");
				}
				else 
				{
					list += ((accounts.get(i)).getAccountID() + ", ");
				}
			}
		}
		return list;
	}
	
	public boolean is_this_Ride_in_System(ArrayList<Ride> arrRide, Ride ride) 
	{
		int count = 0;
		boolean dec = false;
		for(int i = 0; i < arrRide.size(); i++)
		{
			if( ((arrRide.get(i)).getAid() == ride.getAid()) && 
				(((arrRide.get(i)).getLocation_info()).getFrom_city()).equalsIgnoreCase((ride.getLocation_info()).getFrom_city())
				&& ((((arrRide.get(i)).getLocation_info()).getFrom_zip()).equals((ride.getLocation_info()).getFrom_zip())) &&
				((((arrRide.get(i)).getLocation_info()).getTo_city()).equalsIgnoreCase((ride.getLocation_info()).getTo_city()))
				&& ((((arrRide.get(i)).getLocation_info()).getTo_zip()).equals((ride.getLocation_info()).getTo_zip()))
				&& ((((arrRide.get(i)).getDate_time()).getDate()).equalsIgnoreCase((ride.getDate_time()).getDate()))
				&& ((((arrRide.get(i)).getDate_time()).getTime()).equalsIgnoreCase((ride.getDate_time()).getTime()))
				&& ((((arrRide.get(i)).getCar_info()).getMake()).equalsIgnoreCase((ride.getCar_info()).getMake()))
				&& ((((arrRide.get(i)).getCar_info()).getModel()).equalsIgnoreCase((ride.getCar_info()).getModel()))
				&& ((((arrRide.get(i)).getCar_info()).getColor()).equalsIgnoreCase((ride.getCar_info()).getColor()))
				&& ((((arrRide.get(i)).getCar_info()).getPlate_state()).equalsIgnoreCase((ride.getCar_info()).getPlate_state()))
				&& ((((arrRide.get(i)).getCar_info()).getPlate_serial()).equalsIgnoreCase((ride.getCar_info()).getPlate_serial()))
				&& ((arrRide.get(i)).getMax_passengers() == ride.getMax_passengers())
				&& ((arrRide.get(i)).getAmount_per_passenger() == ride.getAmount_per_passenger()))
			{
				count++;
			}
		}
		if(count > 0)
		{
			dec = true;
		}
		return dec;
	}
	
	public int getNumber_of_Rides()
	{
		return number_of_rides;
	}
	
	public Driver searchDriver_byAccountId(int aid)
	{
		Driver driver = null;

		for(int i = 0; i < drivers_list.size(); i++)
		{
			if(aid == (drivers_list.get(i)).getAid())
			{
				driver = new Driver((drivers_list.get(i)).getAid(), (drivers_list.get(i)).getFirst_name(),
						(drivers_list.get(i)).getPicture());
			}
		}
		return driver;
	}
}

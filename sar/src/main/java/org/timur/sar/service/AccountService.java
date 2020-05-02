package org.timur.sar.service;

import java.util.*;


import org.timur.sar.database.DatabaseClass;
import org.timur.sar.exception.DataNotFoundException;
import org.timur.sar.exception.BadRequestException;
import org.timur.sar.model.Account;
import org.timur.sar.model.Rating;

import org.timur.sar.model.Ride;
import org.timur.sar.model.Detail;
import org.timur.sar.service.RideService;

public class AccountService 
{
	private Map<Integer, Account> accounts = DatabaseClass.getAccounts();
	private ArrayList<Account> accounts_list = DatabaseClass.getAccountsList();
	private ArrayList<Account> accounts_list_with_num_of_ratings = DatabaseClass.getAccountsList();
	
	private Map<Integer, Rating> ratings = DatabaseClass.getRatings();
	private ArrayList<Rating> ratings_list = DatabaseClass.getRatingsList();
	int number_of_ratings = 0;
	
	public AccountService()
	{
		
	}
	
	public ArrayList<Account> getAllAccounts()
	{
		ArrayList<Account> account = new ArrayList<Account>();
		for(int i = 0; i < accounts_list.size(); i++)
		{
			Account acc = new Account((accounts_list.get(i)).getAccountID(), 
					(accounts_list.get(i)).getFirst_name() + " " + (accounts_list.get(i)).getLast_name(),
					(accounts_list.get(i)).getDate_created(), (accounts_list.get(i)).isIs_active());
			account.add(acc);
		}
		return account;
	}
	
	public ArrayList<Account> getAllAccounts_with_num_of_ratings()
	{
		return accounts_list_with_num_of_ratings;
	}
	
	public Account getAccount(int aid)
	{
		return accounts.get(aid);
	}
	
	public Account addAccount(Account acc)
	{
		Account acc1;
		if(acc.getFirst_name().equals(""))
		{
			throw new BadRequestException("First name can't be empty");
		}
		else if((acc.getFirst_name()).matches(".*\\d.*"))
		{
			throw new BadRequestException("First name can't have numbers");
		}
		else if((acc.getLast_name()).equals(""))
		{
			throw new BadRequestException("Last name can't be empty");
		}
		else if((acc.getLast_name()).matches(".*\\d.*"))
		{
			throw new BadRequestException("Last name can't have numbers");
		}
		else if(acc.getPhone().equals(""))
		{
			throw new BadRequestException("Phone can't be empty");
		}
		else if(!((acc.getPhone()).substring(3, 4)).equals("-") || !((acc.getPhone()).substring(7, 8)).equals("-") 
				|| (acc.getPhone()).length() != 12 || (!((acc.getPhone()).substring(0, 3)).matches("^[0-9]+$")) 
				|| (!((acc.getPhone()).substring(4, 7)).matches("^[0-9]+$")) 
				|| (!((acc.getPhone()).substring(8, 12)).matches("^[0-9]+$")))
		{
			throw new BadRequestException("Invalid phone number (XXX-XXX-XXXX)");
		}
		else if(acc.getPicture().equals(""))
		{
			throw new BadRequestException("Picture URL can't be empty");
		}
		else if(acc.isIs_active() == true)
		{
			throw new BadRequestException("Invalid value for is_active");
		}
		else 
		{
			accounts.put(acc.getAccountID(), acc);
			//Account acc2 = new Account(acc.getAccountID(), acc.getFirst_name(), acc.getLast_name(),
						//				acc.getPhone(), acc.getPicture(), acc.isIs_active(), 0);
			
			//accounts_list_with_num_of_ratings.add(acc2);
			
			accounts_list.add(acc);
			acc1 = new Account(acc.getAccountID());
		}
		return acc1;
	}
	
	public Account activateAccount(Account acc)
	{
		Account acc1 = accounts.get(acc.getAccountID());
		if(acc1 == null)
		{
			throw new DataNotFoundException("The account identified by " + acc.getAccountID() + 
					" doesn't exists");
		}
		else if(acc.getFirst_name().equals(""))
		{
			throw new BadRequestException("First name can't be empty");
		}
		else if((acc.getFirst_name()).matches(".*\\d.*"))
		{
			throw new BadRequestException("First name can't have numbers");
		}
		else if(acc.getLast_name().equals(""))
		{
			throw new BadRequestException("Last name can't be empty");
		}
		else if((acc.getLast_name()).matches(".*\\d.*"))
		{
			throw new BadRequestException("Last name can't have numbers");
		}
		else if(acc.getPhone().equals(""))
		{
			throw new BadRequestException("Phone can't be empty");
		}
		else if(!((acc.getPhone()).substring(3, 4)).equals("-") || !((acc.getPhone()).substring(7, 8)).equals("-") 
				|| (acc.getPhone()).length() != 12 || (!((acc.getPhone()).substring(0, 3)).matches("^[0-9]+$")) 
				|| (!((acc.getPhone()).substring(4, 7)).matches("^[0-9]+$")) 
				|| (!((acc.getPhone()).substring(8, 12)).matches("^[0-9]+$")))
		{
			throw new BadRequestException("Invalid phone number (###-###-####)");
		}
		else if(acc.getPicture().equals(""))
		{
			throw new BadRequestException("Picture URL can't be empty");
		}
		else if(acc.isIs_active() == false)
		{
			throw new BadRequestException("Invalid value for is_active");
		}
		else if(is_this_Account_in_System(accounts_list, acc) == false)
		{
			throw new BadRequestException("The account information entered is not found. "
					+ "You have to create this account first");
		}
		else
		{
			acc.setIs_active(true);
			accounts.put(acc.getAccountID(), acc);
			for(int i = 0; i < accounts_list.size(); i++)
			{
				if((accounts_list.get(i)).getAccountID() == acc.getAccountID())
				{
					accounts_list.set(i, acc);
				}
			}
		}
		return acc;
	}
	
	public Account updateAccount(Account acc)
	{
		Account acc1 = accounts.get(acc.getAccountID());
		if(acc1 == null)
		{
			throw new DataNotFoundException("The account identified by " + acc.getAccountID() + 
					" doesn't exists");
		}
		else if(acc.getFirst_name().equals(""))
		{
			throw new BadRequestException("First name can't be empty");
		}
		else if((acc.getFirst_name()).matches(".*\\d.*"))
		{
			throw new BadRequestException("First name can't have numbers");
		}
		else if(acc.getLast_name().equals(""))
		{
			throw new BadRequestException("Last name can't be empty");
		}
		else if((acc.getLast_name()).matches(".*\\d.*"))
		{
			throw new BadRequestException("Last name can't have numbers");
		}
		else if(acc.getPhone().equals(""))
		{
			throw new BadRequestException("Phone can't be empty");
		}
		else if(!((acc.getPhone()).substring(3, 4)).equals("-") || !((acc.getPhone()).substring(7, 8)).equals("-") 
				|| (acc.getPhone()).length() != 12 || (!((acc.getPhone()).substring(0, 3)).matches("^[0-9]+$")) 
				|| (!((acc.getPhone()).substring(4, 7)).matches("^[0-9]+$")) 
				|| (!((acc.getPhone()).substring(8, 12)).matches("^[0-9]+$")))
		{
			throw new BadRequestException("Invalid phone number (XXX-XXX-XXXX)");
		}
		else if(acc.getPicture().equals(""))
		{
			throw new BadRequestException("Picture URL can't be empty");
		}
		else if(acc.isIs_active() == true)
		{
			throw new BadRequestException("Invalid value for is_active");
		}
		else
		{
			accounts.put(acc.getAccountID(), acc);
			for(int i = 0; i < accounts_list.size(); i++)
			{
				if((accounts_list.get(i)).getAccountID() == acc.getAccountID())
				{
					accounts_list.set(i, acc);
				}
			}
		}
		return acc;
	}
	
	public Account removeAccount(int aid) 
	{
		Account acc1 = accounts.get(aid);
		if(acc1 == null)
		{
			throw new DataNotFoundException("The account identified by " + aid + 
					" doesn't exists");
		}
		for(int i = 0; i < accounts_list.size(); i++)
		{
			if(aid == (accounts_list.get(i)).getAccountID())
			{
				accounts_list.remove(i);
			}
		}
		return accounts.remove(aid);
	}
	
	public ArrayList<Account> getAllAccountsWithKeyword(String keyword)
	{
		ArrayList<Account> accountSearch = new ArrayList<Account>();
		for(int i = 0; i < accounts_list.size(); i++)
		{
			if(((accounts_list.get(i)).getFirst_name()).equalsIgnoreCase(keyword) || 
				((accounts_list.get(i)).getLast_name()).equalsIgnoreCase(keyword) ||
				((accounts_list.get(i)).getPhone()).equals(keyword))
			{
				Account tempAcc = new Account((accounts_list.get(i)).getAccountID(),
						(accounts_list.get(i)).getFirst_name() + " " + (accounts_list.get(i)).getLast_name(),
						(accounts_list.get(i)).getDate_created(), (accounts_list.get(i)).isIs_active());				
				accountSearch.add(tempAcc);
			}
		}
		return accountSearch;
	}                                               
	
	public Rating addRating(Rating rating)
	{
		Rating rtng1;
		if(is_this_Account_in_System(accounts_list, findByIdAccount(rating.getSent_by_id())) == false)
		{
			throw new BadRequestException("This account (" + rating.getSent_by_id() + ") didn't "
					+ "create this ride (" + rating.getRid() + ") nor was it a passenger");
		}
		else if((rating.getRating() < 0) || (rating.getRating() > 5))
		{
			throw new BadRequestException("Invalid rating: 'rating' is ranged from 0 to 5 inclusive");
		}
		else if(checkRides_for_rideID(rating.getRid()) == false)
		{
			throw new BadRequestException("The ride identified by " + rating.getRid() + " is not created. "
					+ "Create the ride first or enter available account rids: " +
					listAvailableRides());
		}
		else
		{
			ratings.put(rating.getSid(), rating);
			ratings_list.add(rating);
			rtng1 = new Rating(rating.getSid());
		}
		return rtng1;
	}
	
	public ArrayList<Rating> getAllRatings()
	{
		return ratings_list;
	}
	
	public Account findByIdAccount(int aid) 
    {
        Iterator<Account> accounts = accounts_list.listIterator();
        while(accounts.hasNext()) 
        {
        	Account acc = accounts.next();
            if(acc.matchesId(aid) == true) 
            {
            	return(acc);
            }
        }
        return null;
    }
	
	public boolean checkRides_for_rideID(int rid)
	{
		boolean dec = false;
		RideService rideService = new RideService();
		ArrayList<Ride> rides1 = rideService.getAllRides();
		for(int i = 0; i < rides1.size(); i++)
		{
			if(rid == (rides1.get(i)).getRid())
			{
				dec = true;
			}
		}
		return dec;
	}
	
	public boolean is_this_Account_in_System(ArrayList<Account> arrAcc, Account acc) 
	{
		int count = 0;
		boolean dec = false;
		for(int i = 0; i < arrAcc.size(); i++)
		{
			if(((arrAcc.get(i)).getFirst_name()).equalsIgnoreCase(acc.getFirst_name()) &&
				((arrAcc.get(i)).getLast_name()).equalsIgnoreCase(acc.getLast_name()) &&
				((arrAcc.get(i)).getPhone()).equals(acc.getPhone()) &&
				((arrAcc.get(i)).getPicture()).equals(acc.getPicture()) &&
				(arrAcc.get(i)).getAccountID() == acc.getAccountID()) 
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
	
	public String listAvailableRides()
	{
		String list = "(";
		RideService rideService = new RideService();
		ArrayList<Ride> rides = rideService.getAllRides();
		for(int i = 0; i < rides.size(); i++)
		{
			if(i == rides.size() - 1)
			{
				list += ((rides.get(i)).getRid() + ")");
			}
			else 
			{
				list += ((rides.get(i)).getRid() + ", ");
			}
		}
		return list;
	}
	
	public int getNumber_of_Ratings()
	{
		return ratings_list.size();
	}
	
	
	
	public double calculateAverageRating_of_this_Account(Account acc)
	{
		RideService rideService = new RideService();
		ArrayList<Ride> rides1 = rideService.getAllRides();
		int total = 0;
		for(int i = 0; i < rides1.size(); i++)
		{
			if((rides1.get(i)).getAid() == acc.getAccountID())
			{
				total = total + (rides1.get(i)).getAid();
			}
		}
		if(getNumber_of_Ratings() == 0)
		{
			throw new BadRequestException("Invalid result: 'rating' is to be divided by 0");
		}
		return (total/ getNumber_of_Ratings());
	}
}

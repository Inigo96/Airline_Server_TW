package db;

import entities.*;


import javax.jdo.Extent;
import java.util.*;


public interface carazoTraidorInterfaz {
	//Show all instances of the object
	
    public Extent<User> getAllUsers();
    public Extent<Reservation> getAllReservations();
    public Extent<Flight> getAllFlights();
    
    //Show only one instance
   
    public User searchUser(String username);
    public List<Flight> searchFlight(String departure,String arrival,GregorianCalendar date);
    
    //Store one instance on the DB
   
    public void storeUser(User u);
    public void storeReservation(Reservation r);
    public void storeFlight(Flight f);
	
	
	
}

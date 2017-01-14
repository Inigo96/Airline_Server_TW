import entities.*;

import java.util.*;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	
    public static void main(String[] args) {
    	
        
    	
		 EasyBookingDao easyBookingDao=new EasyBookingDaoImplement(null);
//CREATE DATABASE
		 	
	        try {  
	        	
	        	 GregorianCalendar date1 =	new GregorianCalendar(2017,1,1);
	        	 GregorianCalendar date2 =	new GregorianCalendar(2017,2,2);
	        	 GregorianCalendar date3 =	new GregorianCalendar(2017,3,3);
	        	 GregorianCalendar date4 =	new GregorianCalendar(2017,3,3);
	        
				Flight f1 =new Flight ("Bilbao","Madrid", date1);
                Flight f2 =new Flight ("Bilbao","Barcelona",date2);               
                Flight f3 =new Flight ("Barcelona","Bilbao",date3);
                Flight f4 =new Flight ("Barcelona","Madrid",date4);
                
       
                
                
                Reservation r1=new Reservation();
                	r1.addFlight(f1);
                Reservation r2=new Reservation();
                	r2.addFlight(f2);
                Reservation r3=new Reservation();
                	r3.addFlight(f3);
                Reservation r4=new Reservation();
                	r4.addFlight(f4);
                	
                User u1=new User("user1","pass1");
                	u1.addReservation(r1);
                	u1.addReservation(r2);
                User u2=new User("user2","pass2");
                	u2.addReservation(r3);
                	u2.addReservation(r4);
 
                //Reservation 1  flights       
                easyBookingDao.storeReservation(r1);    
                easyBookingDao.storeFlight(f1);
                               
                //Reservation 2  flights          
                easyBookingDao.storeReservation(r2);    
                easyBookingDao.storeFlight(f2);
                
                //Reservation 3 flights       
                easyBookingDao.storeReservation(r3);    
                easyBookingDao.storeFlight(f3);
                               
                //Reservation 4 flights          
                easyBookingDao.storeReservation(r4);    
                easyBookingDao.storeFlight(f4);
           
                
                //User 1            
                easyBookingDao.storeUser(u1);
             
                
                //User 2 
                easyBookingDao.storeUser(u2);
//Show all flights 
                easyBookingDao.getAllFlights();      
                
//Show 1 user results
              easyBookingDao.searchUser("user1");
                
	        } catch (Exception e) {
	            e.printStackTrace();
	          }
  
	 }
}

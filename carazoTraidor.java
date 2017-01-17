package db;

import entities.*;

import javax.jdo.*;
import java.util.*;


public class carazoTraidor {
PersistenceManagerFactory pmf;
    
    /** Constructor, defining the PersistenceManagerFactory to use. */
    public carazoTraidor(PersistenceManagerFactory pmf)
    {
        this.pmf = pmf;
    }

    public carazoTraidor(){}
    
   
    
   public void addReservation(User u){
       deleteUser(u);
       storeUser(u);
   }

    public void deleteUser(User u){
        PersistenceManagerFactory pmfNoDeCarazo = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
       PersistenceManager pm = pmfNoDeCarazo.getPersistenceManager();
       Transaction tx = pm.currentTransaction();

       try {
           tx.begin();
           Extent<User> extentP = pm.getExtent(User.class);

           for (User p : extentP) {
               System.out.println(p.getPassword());
               if(p.getUsername().equals(u.getUsername())){
                   System.out.println("ENTRE!!!!!!!!!!!!!!!!!");
                   pm.deletePersistent(p);}
           }

           tx.commit();

       } catch (Exception ex) {
           System.out.println("# Error getting Extent: " + ex.getMessage());
       } finally {
           if (tx.isActive()) {
               tx.rollback();
           }
           pm.close();
       }
    }

    public Extent<User> getAllUsers()
    {
    	
    	
    	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        Extent<User> extentU;
        try
        {
            tx.begin();

            extentU = pm.getExtent(User.class);
            int cont = 0;
            for (User u : extentU) {
            	System.out.println((cont++) + "  - " + u.getUsername() + " - " + u.getPassword());
            }

            tx.commit();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        return extentU;
    }

    public Extent<Reservation> getAllReservations()
    {
    	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        Extent<Reservation> extentR;
        try
        {
            tx.begin();

            extentR = pm.getExtent(Reservation.class);
            int cont = 0;
            for (Reservation r : extentR) {
            	System.out.println((cont++) + " - " +r.toString());
            }
            tx.commit();
        }    finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        return extentR;
    }
    
    public Extent<Flight> getAllFlights()
    {
    	
    	
    	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        Extent<Flight> extentF;
        try
        {
            tx.begin();

            extentF = pm.getExtent(Flight.class);
            int cont = 0;
            for (Flight f : extentF) {
                if(!f.equals(null)){
                    if(!(f.getArrivalA() == null)|| !(f.getDepartureA() == null))
                    System.out.println((cont++) + " - "+ f.getArrivalA() + " - " + f.getDepartureA()+ " - " + f.getDate());
                }           	
            }
            tx.commit();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        return extentF;
    }

    public  User searchUser(String username){
    	List<User> users;
        
    	pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    	PersistenceManager pm = pmf.getPersistenceManager();
    	Transaction tx = pm.currentTransaction();
       try {
     tx.begin();
     Query q = pm.newQuery("SELECT FROM " + User.class.getName() + 
    		 " WHERE username == ' "+ username+"'");
     
     users = (List<User>)q.execute();
     Iterator<User> iter = users.iterator();
  
     while (iter.hasNext()) {
    	 User u = iter.next();
       //(use the retrieved objects)  //RETURN
     }
  
     tx.commit();
  } finally {
     if (tx.isActive()) {
        tx.rollback();
     }

     pm.close();
  }
 return users.get(0);
    }

    
    public  List<Flight> searchFlight(String departure,String arrival,GregorianCalendar date){
    	
    	 List<Flight> flights;
    	pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    	PersistenceManager pm = pmf.getPersistenceManager();
    	Transaction tx = pm.currentTransaction();
       try {
     tx.begin();
     Query q = pm.newQuery("SELECT FROM " + Flight.class.getName() + 
    		 " WHERE departureA == '" + departure +"' AND arrivalA = '" +arrival +" ' AND date = '"+ date +"'");
     
     flights = (List<Flight>)q.execute();
     Iterator<Flight> iter = flights.iterator();
  
     while (iter.hasNext()) {
       Flight p = iter.next();
       //RETURN
     }
  
     tx.commit();
  } finally {
     if (tx.isActive()) {
        tx.rollback();
     }

     pm.close();
  }
       return flights;
    }

    
    public void storeUser(User u){
    	pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    	PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
            tx.begin();

            // Persist our changes back to the datastore
            pm.makePersistent(u);

            tx.commit();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }
    
    
    public void storeReservation(Reservation r){
    	pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    	PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
            tx.begin();

            // Persist our changes back to the datastore
            pm.makePersistent(r);

            tx.commit();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }
    
    
    public void storeFlight(Flight f){
    	pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    	PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
            tx.begin();

            // Persist our changes back to the datastore
            pm.makePersistent(f);

            tx.commit();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
}

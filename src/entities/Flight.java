package es.deusto.ingenieria.sd.jdo.inventory;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PrimaryKey;

import java.util.*;
//import com.google.appengine.api.datastore.Key;


@PersistenceCapable
public class Flight { 

private	String departureA=null;
private String arrivalA=null;
private GregorianCalendar date;
	
	
	
	public Flight(String departureA, String arrivalA, GregorianCalendar date) {

		this.departureA = departureA;
		this.arrivalA = arrivalA;
		this.date = date;
	}
	
	@Override
	public String toString(){
	    return "D: " + departureA + ", A: " + arrivalA + ", on " + date.toString();
	    
	  }


	public String getDepartureA() {
		return departureA;
	}

	public void setDepartureA(String departureA) {
		this.departureA = departureA;
	}

	public String getArrivalA() {
		return arrivalA;
	}

	public void setArrivalA(String arrivalA) {
		this.arrivalA = arrivalA;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	

}



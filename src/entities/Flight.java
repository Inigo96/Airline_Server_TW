package entities;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import org.datanucleus.enhancement.*;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PrimaryKey;

import java.io.Serializable;
import java.util.*;

@PersistenceCapable(detachable = "true")
public class Flight implements Serializable{

//	private String us;
private	String departureA;
private String arrivalA;
private GregorianCalendar date;
	
	
	
	public Flight(String departureA, String arrivalA, GregorianCalendar date) {
		this.departureA = departureA;
		this.arrivalA = arrivalA;
		this.date = date;
	}

	public Flight(){

	}
	
	@Override
	public String toString(){
		return departureA + "%&&&%" + arrivalA + "%&&&%" + date.toString();
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



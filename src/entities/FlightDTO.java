package entities;

import java.io.Serializable;
import java.util.*;

public class FlightDTO implements Serializable{

    private	String departureA;
    private String arrivalA;
    private GregorianCalendar date;

    public FlightDTO(String departureA, String arrivalA, GregorianCalendar date) {
        this.departureA = departureA;
        this.arrivalA = arrivalA;
        this.date = date;
    }

    @Override
    public String toString(){
        return departureA + "%&&&%" + arrivalA + "%&&&%" + date.toString();
    }

    public String getDepartureA() {
        return departureA;
    }


    public String getArrivalA() {
        return arrivalA;
    }


    public GregorianCalendar getDate() {
        return date;
    }



}



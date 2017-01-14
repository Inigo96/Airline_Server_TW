package entities;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PrimaryKey;

import java.util.*;

@PersistenceCapable
public class Flight {
    @Persistent
    private int id=0;
    @Persistent
    private String departureA=null;
    @Persistent
    private String arrivalA=null;
    @Persistent
    private Date date;

    public Flight(int id, String departureA, String arrivalA, Date date) {
        super();
        this.id = id;
        this.departureA = departureA;
        this.arrivalA = arrivalA;
        this.date = date;
    }

    @Override
    public String toString(){
        return "D: " + departureA + ", A: " + arrivalA + ", on " + date.toString();

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}



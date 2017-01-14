package entities;

import java.util.ArrayList;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PrimaryKey;
import java.util.List;
import javax.jdo.annotations.*;
import javax.jdo.annotations.Persistent;
@PersistenceCapable
public class Reservation {
    @Persistent
    private int id=0;
    @Join
    private List<Flight> flightList=new ArrayList<>();


    public int getId() {
        return id;
    }


    void addFlight(Flight f){
        flightList.add(f);
    }

    void getFlight(int b){
        flightList.get(b);
    }



    public Reservation(int id) {
        this.id = id;
    }



}

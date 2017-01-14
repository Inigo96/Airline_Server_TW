package es.deusto.ingenieria.sd.jdo.inventory;

import java.util.ArrayList;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PrimaryKey;
import java.util.List;
import javax.jdo.annotations.*;
import javax.jdo.annotations.Persistent;
@PersistenceCapable
public class Reservation {

	@Join
    private List<Flight> flightList=new ArrayList<>();

    @Override
	public String toString() {
		return "Reservation [flightList=" + flightList + "]";
	}

	void addFlight(Flight f){
    	flightList.add(f);
    }

    void getFlight(int b){
    	flightList.get(b);
    }



}

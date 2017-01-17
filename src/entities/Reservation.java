package entities;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.datanucleus.enhancement.*;
@PersistenceCapable
public class Reservation implements Serializable{


	public Reservation(List<Flight> e){
		flightList=e;
	}

//	private String username;
	public Reservation(){
		flightList=new ArrayList<>();
	}

	@Join
    private List<Flight> flightList;

    @Override
	public String toString() {
		return "Reservation [flightList=" + flightList + "]";
	}

	public void addFlight(Flight f){
    	flightList.add(f);
    }

    public Flight getFlight(){
    	return flightList.get(0);
    }

	public List<Flight> getFlights(){
		return flightList;
	}

}

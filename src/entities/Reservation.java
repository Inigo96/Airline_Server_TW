package entities;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import java.util.ArrayList;
import java.util.List;
@PersistenceCapable
public class Reservation {


	public Reservation(){

	}
	@Join
    private List<Flight> flightList=new ArrayList<>();

    @Override
	public String toString() {
		return "Reservation [flightList=" + flightList + "]";
	}

	public void addFlight(Flight f){
    	flightList.add(f);
    }

    public void getFlight(int b){
    	flightList.get(b);
    }



}

package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class ReservationDTO implements Serializable{

    public ReservationDTO(List<Flight> e){
        flightList=e;
    }

    private List<Flight> flightList;

    @Override
    public String toString() {
        return "Reservation [flightList=" + flightList + "]";
    }

    public Flight getFlight(){
        return flightList.get(0);
    }

    public List<Flight> getFlights(){
        return flightList;
    }

}

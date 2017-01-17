package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class ReservationDTO implements Serializable{

    public ReservationDTO(List<FlightDTO> e){
        flightList=e;
    }

    private List<FlightDTO> flightList;

    @Override
    public String toString() {
        return "Reservation [flightList=" + flightList + "]";
    }

    public FlightDTO getFlight(){
        return flightList.get(0);
    }

    public List<FlightDTO> getFlights(){
        return flightList;
    }

}

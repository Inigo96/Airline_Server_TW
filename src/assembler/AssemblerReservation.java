package assembler;

import entities.Flight;
import entities.FlightDTO;
import entities.Reservation;
import entities.ReservationDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by inigo on 17/01/17.
 */
public class AssemblerReservation {
    public ReservationDTO assembleReservation(Reservation e){
        List<FlightDTO> f=new ArrayList<>();
        for(Flight a:e.getFlights()) f.add(new FlightDTO(a.getDepartureA(),a.getArrivalA(),a.getDate()));
        return new ReservationDTO(f);
    }

    public Reservation DesAssembleReservation(ReservationDTO e){
        List<Flight> f=new ArrayList<>();
        for(FlightDTO a:e.getFlights()) f.add(new Flight(a.getDepartureA(),a.getArrivalA(),a.getDate()));
        return new Reservation(f);
    }
}

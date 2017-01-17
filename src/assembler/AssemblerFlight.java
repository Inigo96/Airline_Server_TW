package assembler;

import entities.Flight;
import entities.FlightDTO;

/**
 * Created by inigo on 17/01/17.
 */
public class AssemblerFlight {
    public FlightDTO assembleFlight(Flight e){
        return new FlightDTO(e.getDepartureA(),e.getArrivalA(),e.getDate());
    }
    public Flight DesAssembleFlight(FlightDTO e){
        return new Flight(e.getDepartureA(),e.getArrivalA(),e.getDate());
    }
}

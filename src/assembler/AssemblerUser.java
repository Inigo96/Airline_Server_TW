package assembler;

import entities.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by inigo on 17/01/17.
 */
public class AssemblerUser {
    public UserDTO assembleUser(User e){
        List<ReservationDTO> res=new ArrayList<>();
        for(Reservation a:e.getReservation()){
            List<FlightDTO> fl=new ArrayList<>();
            fl.add(new FlightDTO(a.getFlight().getDepartureA(),a.getFlight().getArrivalA(),a.getFlight().getDate()));
            res.add(new ReservationDTO(fl));
        }
        return new UserDTO(e.getUsername(),e.getPassword(),res);
    }

    public User DesAssembleUser(UserDTO e){
        List<Reservation> res=new ArrayList<>();
        for(ReservationDTO a:e.getReservation()){
            List<Flight> fl=new ArrayList<>();
            fl.add(new Flight(a.getFlight().getDepartureA(),a.getFlight().getArrivalA(),a.getFlight().getDate()));
            res.add(new Reservation(fl));
        }
        return new User(e.getUsername(),e.getPassword(),res);
    }
}

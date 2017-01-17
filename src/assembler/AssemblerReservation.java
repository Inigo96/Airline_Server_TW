package assembler;

import entities.Reservation;
import entities.ReservationDTO;

/**
 * Created by inigo on 17/01/17.
 */
public class AssemblerReservation {
    public ReservationDTO assembleReservation(Reservation e){
        return new ReservationDTO(e.getFlights());
    }

    public Reservation DesAssembleReservation(ReservationDTO e){
        return new Reservation(e.getFlights());
    }
}

package remote;

import entities.Flight;
import entities.Reservation;
import entities.User;

import java.util.Date;

/**
 * Created by inigo on 30/12/16.
 */
public interface IReservationService {
    boolean createReservation(Flight f, User u);
    Flight[] searchFlight(String departure, String arrival, Date date);
    Reservation[] getReservations(User u);
    User login(String email, String password);
}

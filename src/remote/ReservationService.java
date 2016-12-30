package remote;

import entities.Flight;
import entities.Reservation;
import entities.User;

import java.util.Date;

/**
 * Created by inigo on 30/12/16.
 */
public class ReservationService implements IReservationService {
    @Override
    public boolean createReservation(Flight f, User u) {
        return false;
    }

    @Override
    public Flight[] searchFlight(String departure, String arrival, Date date) {
        return new Flight[0];
    }

    @Override
    public Reservation[] getReservations(User u) {
        return new Reservation[0];
    }

    @Override
    public User login(String email, String password) {
        return null;
    }
}

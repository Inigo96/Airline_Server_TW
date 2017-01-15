package managers;

import db.EasyBookingDaoImplement;
import entities.Flight;
import entities.Reservation;
import entities.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pablocabezali on 15/1/17.
 */
public class ReservationManager {
    EasyBookingDaoImplement a = new EasyBookingDaoImplement();

    public boolean createReservation(User u, Flight f) {
        Reservation r = new Reservation();
        r.addFlight(f);
        u.addReservation(r);

        a.storeReservation(r);
        return true;
    }

    public List<Reservation> getReservations(User u) {
        List<Reservation> reserveList = new ArrayList<>();
        reserveList = u.getReservation();
        return reserveList;
    }
}
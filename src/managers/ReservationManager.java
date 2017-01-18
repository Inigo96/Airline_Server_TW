package managers;

import db.MySQL;
import entities.Flight;
import entities.Reservation;
import entities.User;

import java.util.List;

/**
 * Created by pablocabezali on 15/1/17.
 */
public class ReservationManager {
    private MySQL a;

    public ReservationManager(MySQL bd){
        a=bd;
    }

    public synchronized boolean createReservation(User u, Flight f) {
        Reservation r = new Reservation();
        r.addFlight(f);
        System.out.println("Entro en el guardado del vuelo");
        a.addReservation(u,r);
        return true;
    }

//    public synchronized List<Reservation> getReservations(User u) {
//        List<Reservation> reserveList = u.getReservation();
//        return reserveList;
//    }
}
package remote;

import entities.Flight;
import entities.Reservation;
import entities.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by inigo on 30/12/16.
 */
public interface IReservationService extends Remote {
    boolean createReservation(Flight f, User u) throws RemoteException;
    Flight[] searchFlight(String departure, String arrival, GregorianCalendar date) throws RemoteException;
    Reservation[] getReservations(User u) throws RemoteException;
    User login(String email, String password) throws RemoteException;
}

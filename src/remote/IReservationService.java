package remote;

import entities.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by inigo on 30/12/16.
 */
public interface IReservationService extends Remote {
    boolean createReservation(FlightDTO f, UserDTO u) throws RemoteException;
    FlightDTO[] searchFlight(String departure, String arrival, GregorianCalendar date) throws RemoteException;
//    ReservationDTO[] getReservations(UserDTO u) throws RemoteException;
    UserDTO login(String email, String password) throws RemoteException;
}

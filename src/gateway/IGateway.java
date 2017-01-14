package gateway;

import entities.Flight;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by inigo on 14/01/17.
 */
public interface IGateway {
    Flight[] searchFlight(String departure, String arrival, GregorianCalendar date);
}

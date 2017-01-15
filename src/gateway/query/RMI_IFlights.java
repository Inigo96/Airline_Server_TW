package gateway.query;

import entities.Flight;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.GregorianCalendar;

/**
 * Created by inigo on 15/01/17.
 */
public interface RMI_IFlights extends Remote{
    Flight[] searchFlightRMI(FlightsQuery fq) throws RemoteException;
}

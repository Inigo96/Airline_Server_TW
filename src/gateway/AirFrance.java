package gateway;

import entities.Flight;
import gateway.query.FlightsQuery;
import gateway.query.RMI_IFlights;

import java.rmi.RemoteException;
import java.util.GregorianCalendar;

/**
 * Created by inigo on 14/01/17.
 */
public class AirFrance implements IGateway, RMI_IFlights {

    private String IP;
    private int port;

    public AirFrance(String IP, int port){
        super();
        this.IP=IP;
        this.port=port;
    }

    @Override
    public Flight[] searchFlight(String departure, String arrival, GregorianCalendar date) {
        try {
            return searchFlightRMI(new FlightsQuery(departure, arrival, date));
        } catch (RemoteException e) {
            e.printStackTrace();
            return new Flight[0];
        }
    }


    @Override
    public Flight[] searchFlightRMI(FlightsQuery fq) throws RemoteException {
        return new Flight[0];
    }

}

package gateway;

import entities.Flight;

import java.util.GregorianCalendar;

/**
 * Created by inigo on 14/01/17.
 */
public class AirFrance implements IGateway {
    @Override
    public Flight[] searchFlight(String departure, String arrival, GregorianCalendar date) {
        return new Flight[0];
    }


}

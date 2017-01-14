package gateway;

import entities.Flight;

import java.util.GregorianCalendar;

/**
 * Created by inigo on 14/01/17.
 */
public class Iberia implements IGateway{
    private String IP;
    private int port;

    public Iberia (String ip, int port){
        this.IP=ip;
        this.port=port;
    }


    @Override
    public Flight[] searchFlight(String departure, String arrival, GregorianCalendar date) {
        return new Flight[0];
    }
}

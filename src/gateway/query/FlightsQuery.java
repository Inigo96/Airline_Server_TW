package gateway.query;

import java.util.GregorianCalendar;

/**
 * Created by inigo on 15/01/17.
 */
public class FlightsQuery {

    private String departure;
    private String arrival;
    private GregorianCalendar date;

    public FlightsQuery(String departure, String arrival, GregorianCalendar date){
        this.departure=departure;
        this.arrival=arrival;
        this.date=date;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public GregorianCalendar getDate() {
        return date;
    }
}

package gateway;

import entities.Flight;
import gateway.query.FlightsQuery;
import gateway.query.RMI_IFlights;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.GregorianCalendar;

/**
 * Created by inigo on 15/01/17.
 */
public class AirFranceGateway implements IGateway{

    private RMIServiceLocator serviceLocator;

    public void initialize(String IP, String port, String serviceName){
        this.serviceLocator = new RMIServiceLocator();
        this.serviceLocator.setService(IP,port,serviceName);
    }

    private static AirFranceGateway ourInstance = new AirFranceGateway();

    public static AirFranceGateway getInstance() {
        return ourInstance;
    }

    private AirFranceGateway() {
    }

    @Override
    public Flight[] searchFlight(String departure, String arrival, GregorianCalendar date) {
        try {
            return this.serviceLocator.getService().searchFlightRMI(new FlightsQuery(departure, arrival, date));
        } catch (RemoteException e) {
            e.printStackTrace();
            return new Flight[0];
        }
    }

    public class RMIServiceLocator{
        private RMI_IFlights pf;

        public void setService(String ip, String port, String serviceName) {
            String url = "//" + ip + ":" + port + "/" + serviceName;
            System.out.println("Client looking for service : //"+ip+":"+port+"/"+serviceName);
            try {
                pf= (RMI_IFlights) Naming.lookup(url);
            } catch (MalformedURLException e) {
                System.out.println(e.getMessage());
            } catch (RemoteException e) {
                System.out.println(e.getMessage());
            } catch (NotBoundException e) {
                System.out.println(e.getMessage());
            }
        }

        public RMI_IFlights getService() {
            return this.pf;
        }
    }
}

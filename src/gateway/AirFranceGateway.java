package gateway;

import entities.Flight;
import airFrance.AirFrance_Flight;
import airFrance.FlightsQuery;
import airFrance.RMI_IFlights;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.GregorianCalendar;

/**
 * Created by inigo on 15/01/17.
 */
public class AirFranceGateway implements IGateway{

    private RMIServiceLocator serviceLocator;

    public void initialize(String IP, String port, String serviceName) throws RemoteException {
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
            AirFrance_Flight[] airFrance_flights= this.serviceLocator.getService().searchFlightRMI(new FlightsQuery(departure, arrival, date));
            Flight[] flights = new Flight[airFrance_flights.length];
            for(int a=0;a<airFrance_flights.length;a++) {
                flights[a]=new Flight(airFrance_flights[a].getDepartureA(), airFrance_flights[a].getArrivalA(), airFrance_flights[a].getDate());
            }
            System.out.println("Devuelvo VUELO AIR FRANCE "+flights.toString());
            return flights;
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("NO Devuelvo VUELO AIR FRANCE");
            return new Flight[0];
        }
    }

    public class RMIServiceLocator extends UnicastRemoteObject {
        private RMI_IFlights pf;

        protected RMIServiceLocator() throws RemoteException {
        }

        public void setService(String ip, String port, String serviceName) {

            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
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

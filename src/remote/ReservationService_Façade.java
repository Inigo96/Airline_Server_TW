package remote;

import entities.Flight;
import entities.Reservation;
import entities.User;
import managers.FlightManager;
import managers.ReservationManager;
import managers.UserManager;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.GregorianCalendar;

/**
 * Created by inigo on 30/12/16.
 */
public class ReservationService_Façade extends UnicastRemoteObject implements IReservationService {

    private FlightManager flightManager;
    private ReservationManager reservationManager;
    private UserManager userManager;


    public ReservationService_Façade(FlightManager flightManager, ReservationManager reservationManager, UserManager userManager) throws RemoteException {
        super();
        this.flightManager=flightManager;
        this.reservationManager=reservationManager;
        this.userManager=userManager;
    }

    @Override
    public boolean createReservation(Flight f, User u) throws RemoteException {
        return reservationManager.createReservation(u,f);
    }

    @Override
    public Flight[] searchFlight(String departure, String arrival, GregorianCalendar date) throws RemoteException {
        return flightManager.searchFlight(departure,arrival,date);
    }

    @Override
    public Reservation[] getReservations(User u) throws RemoteException {
        return (Reservation[])reservationManager.getReservations(u).toArray();
    }

    @Override
    public User login(String email, String password) throws RemoteException {
        return this.userManager.login(email,password);
    }

    public static void run_Server(String ip, String port, String serviceName, FlightManager flightManager, ReservationManager reservationManager, UserManager userManager){

//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }

        String name = "//" + ip + ":" + port + "/" + serviceName;

        try {
            IReservationService objServer = new ReservationService_Façade( flightManager,  reservationManager,  userManager);
//			objServer.registerUser("client","pass");
            Naming.rebind(name, objServer);
            System.out.println("* Server '" + name + "' active and waiting...");
        } catch (Exception e) {
            System.err.println("- Exception running the server: " + e.getMessage());
            e.printStackTrace();
        }


    }
}

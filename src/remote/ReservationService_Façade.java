package remote;

import entities.Flight;
import entities.Reservation;
import entities.User;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by inigo on 30/12/16.
 */
public class ReservationService_Façade implements IReservationService {

    @Override
    public boolean createReservation(Flight f, User u) throws RemoteException {
        return false;
    }

    @Override
    public Flight[] searchFlight(String departure, String arrival, Date date) throws RemoteException {
        return new Flight[0];
    }

    @Override
    public Reservation[] getReservations(User u) throws RemoteException {
        return new Reservation[0];
    }

    @Override
    public User login(String email, String password) throws RemoteException {
        return null;
    }

    public static void run_Server(String ip, String port, String serviceName){

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        String name = "//" + ip + ":" + port + "/" + serviceName;

        try {
            IReservationService objServer = new ReservationService_Façade();
//			objServer.registerUser("client","pass");
            Naming.rebind(name, objServer);
            System.out.println("* Server '" + name + "' active and waiting...");
        } catch (Exception e) {
            System.err.println("- Exception running the server: " + e.getMessage());
            e.printStackTrace();
        }


    }
}

package remote;

import assembler.AssemblerFlight;
import assembler.AssemblerReservation;
import assembler.AssemblerUser;
import entities.*;
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
    private AssemblerFlight aF;
    private AssemblerReservation aR;
    private AssemblerUser aU;


    public ReservationService_Façade(FlightManager flightManager, ReservationManager reservationManager, UserManager userManager) throws RemoteException {
        super();
        this.flightManager=flightManager;
        this.reservationManager=reservationManager;
        this.userManager=userManager;
        aF= new AssemblerFlight();
        aR= new AssemblerReservation();
        aU= new AssemblerUser();
    }

    @Override
    public boolean createReservation(FlightDTO f, UserDTO u) throws RemoteException {

        return reservationManager.createReservation(aU.DesAssembleUser(u),aF.DesAssembleFlight(f));
    }

    @Override
    public FlightDTO[] searchFlight(String departure, String arrival, GregorianCalendar date) throws RemoteException {
        Flight[] lista=flightManager.searchFlight(departure, arrival, date);
        FlightDTO[] listaDTO = new FlightDTO[lista.length];
        for(int a=0;a<lista.length;a++) listaDTO[a]=aF.assembleFlight(lista[a]);
        return listaDTO;
    }

    @Override
    public ReservationDTO[] getReservations(UserDTO u) throws RemoteException {
        Reservation[] lista=(Reservation[])reservationManager.getReservations(aU.DesAssembleUser(u)).toArray();
        ReservationDTO[] listaDTO = new ReservationDTO[lista.length];
        for(int a=0;a<lista.length;a++) listaDTO[a]=aR.assembleReservation(lista[a]);
        return listaDTO;

    }

    @Override
    public UserDTO login(String email, String password) throws RemoteException {
        return aU.assembleUser(this.userManager.login(email,password));
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

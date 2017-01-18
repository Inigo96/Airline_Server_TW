import db.MySQL;
import gateway.AirFranceGateway;
import gateway.IGateway;
import gateway.IberiaGateway;
import managers.FlightManager;
import managers.ReservationManager;
import managers.UserManager;
import remote.ReservationService_Façade;

import java.rmi.RemoteException;

/**
 * Created by inigo on 15/01/17.
 */
public class Main {
    public static void main(String[] args) throws RemoteException {
        //This SERVER ARGUMENTS
        String serverIP = args[0];
        String serverPort = args[1];
        String serverServiceName = args[2];
        //Initialize Managers
            //Initialize IGateways
            IGateway[] arrayIgateways = new IGateway[2];
            String iberiaIP = args[3];
            String iberiaPort = args[4];
            IberiaGateway iberia= IberiaGateway.getInstance();
            iberia.initialize(iberiaIP, Integer.parseInt(iberiaPort));

            String airFranceIP = args[5];
            String airFrancePort = args[6];
            String airFranceServiceName = args[7];
            AirFranceGateway airFrance = AirFranceGateway.getInstance();
            airFrance.initialize(airFranceIP, airFrancePort, airFranceServiceName);

            arrayIgateways[0] = iberia;
            arrayIgateways[1] = airFrance;
        FlightManager flightManager = new FlightManager(arrayIgateways);

        //Initialize bd
        MySQL bd=new MySQL();

        //Reservation Manager
        ReservationManager reservationManager = new ReservationManager(bd);

        //UserManager
        UserManager userManager = new UserManager(bd);

        //Initialize bd

        //Inicializar Server
        ReservationService_Façade.run_Server(serverIP, serverPort, serverServiceName, flightManager, reservationManager, userManager);
    }
}

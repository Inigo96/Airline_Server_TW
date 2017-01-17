
import db.MySQL;
import entities.Flight;
import entities.Reservation;
import entities.User;

import java.util.GregorianCalendar;

/**
 * Created by inigo on 16/01/17.
 */
public class InigoBD {
    public static void main(String[] args) {
        GregorianCalendar date1 =	new GregorianCalendar(2017,1,1);
        GregorianCalendar date2 =	new GregorianCalendar(2017,2,2);
        GregorianCalendar date3 =	new GregorianCalendar(2017,3,3);
        GregorianCalendar date4 =	new GregorianCalendar(2017,3,3);

        Flight f1 =new Flight ("Bilbao","Madrid", date1);
        Flight f2 =new Flight ("Bilbao","Barcelona",date2);
        Flight f3 =new Flight ("Barcelona","Bilbao",date3);
        Flight f4 =new Flight ("Barcelona","Madrid",date4);


        Reservation r1=new Reservation();
        r1.addFlight(f1);
        Reservation r2=new Reservation();
        r2.addFlight(f2);
        Reservation r3=new Reservation();
        r3.addFlight(f3);

        User u1=new User("user1","pass1");
        u1.addReservation(r1);
        u1.addReservation(r2);

        MySQL db = new MySQL();
        db.storeUser(u1);
//        db.deleteUser(u1);
//        u1.addReservation(r3);
        db.addReservation(u1, r3);

        User inigo=db.getUser("user1");
        System.out.println(inigo.getUsername());
        System.out.println(inigo.getReservation().size());
        for(Reservation r:inigo.getReservation()){
            System.out.println(r.getFlight().getArrivalA());
        }
        db.deleteUser(u1);

    }
}

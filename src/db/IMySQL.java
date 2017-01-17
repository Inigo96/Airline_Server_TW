package db;

import entities.Reservation;
import entities.User;

/**
 * Created by inigo on 17/01/17.
 */
public interface IMySQL {
    public void storeUser(User u);
    public void deleteUser(User u);
    public void addReservation(User u, Reservation r);
    public User getUser(String email);
}

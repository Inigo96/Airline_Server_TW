package managers;

import db.EasyBookingDaoImplement;
import entities.User;
import gateway.UserGateway;

/**
 * Created by pablocabezali on 15/1/17.
 */
public class UserManager {
    private EasyBookingDaoImplement a = new EasyBookingDaoImplement(null);
    public User login(String username, String password) {


        if (a.searchUser(username) != null) {
            if (a.searchUser(username).getPassword().equals(password)) {
                return a.searchUser(username);
            } else {
                System.out.println("Wrong password ");
                return null;
            }
        } else if (UserGateway.getInstance().login(username, password)) {
            User u = new User(username, password);
            a.storeUser(u);
            return u;
        }
    else{
            return null;
        }

    }
}

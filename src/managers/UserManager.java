package managers;

import db.MySQL;
import entities.User;
import gateway.UserGateway;

/**
 * Created by pablocabezali on 15/1/17.
 */
public class UserManager {
    private MySQL a;

    public UserManager(MySQL bd){
        a=bd;
    }

    public synchronized User login(String username, String password) {

        User u=a.getUser(username);
        if (u != null) {
            if (u.getPassword().equals(password)) {
                return u;
            } else {
                System.out.println("Wrong password ");
                return null;
            }
        } else if (UserGateway.getInstance().login(username, password)) {
            u = new User(username, password);
            a.storeUser(u);
            return u;
        }
    else{
            return null;
        }

    }
}

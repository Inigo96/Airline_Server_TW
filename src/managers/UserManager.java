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
        System.out.println("u = " + u);
//        System.out.println("u.getUsername() = " + u.getUsername());
//        System.out.println("u.getUsername() = " + u.getPassword());
        if (u != null) {
            System.out.println("User dentro de la bd");

            if (u.getPassword().equals(password)) {
                System.out.println("Contrasenya correcta "+u.getPassword()+" "+password);
                return u;
            } else {
                System.out.println("Wrong password ");
                return null;
            }
        } else if (UserGateway.getInstance().login(username, password)) {
            System.out.println("Exito esta en google");
            u = new User(username, password);
            a.storeUser(u);
            return u;
        } else{
            System.out.println("Fracaso no esta en google");
            return null;
        }

    }
}

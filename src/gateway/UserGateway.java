package gateway;

import db.EasyBookingDaoImplement;
import entities.User;

/**
 * Created by pablocabezali on 15/1/17.
 */
public class UserGateway {

    private String IP;
    private int port;

    public void initialize(String IP, int port){
        this.IP = IP;
        this.port = port;
    }

    private static UserGateway ourInstance = new UserGateway();

    public static UserGateway getInstance() {
        return ourInstance;
    }

    public boolean login(String username, String password){

        boolean successful=false;
        if(username.contains("@gamil.")){
            successful=true;


        }else{
            System.out.println("Try another username with @gmail.");
        }

        return successful;

    }
}

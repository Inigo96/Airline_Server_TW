package gateway;

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
        if()

    }
}

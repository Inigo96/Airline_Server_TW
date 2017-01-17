package entities;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class UserDTO implements Serializable{

    private String username;

    private String password;
    //	@Persistent(defaultFetchGroup="true", mappedBy="user", dependentElement = "true")

    private List<Reservation> reserveList;

    public UserDTO(String username, String password, List<Reservation> lista) {
        this.username = username;
        this.password = password;
        reserveList=lista;
    }

    public List<Reservation> getReservation(){
        return reserveList;
    }

    public Reservation getLastReservation() {return reserveList.get(reserveList.size()-1);}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", reserveList=" + reserveList + "]";
    }






}

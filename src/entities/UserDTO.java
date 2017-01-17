package entities;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class UserDTO implements Serializable{

    private String username;

    private String password;
    //	@Persistent(defaultFetchGroup="true", mappedBy="user", dependentElement = "true")

    private List<ReservationDTO> reserveList;

    public UserDTO(String username, String password, List<ReservationDTO> lista) {
        this.username = username;
        this.password = password;
        reserveList=lista;
    }

    public List<ReservationDTO> getReservation(){
        return reserveList;
    }

    public ReservationDTO getLastReservation() {return reserveList.get(reserveList.size()-1);}

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

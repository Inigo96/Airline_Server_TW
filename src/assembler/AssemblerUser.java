package assembler;

import entities.Reservation;
import entities.ReservationDTO;
import entities.User;
import entities.UserDTO;

/**
 * Created by inigo on 17/01/17.
 */
public class AssemblerUser {
    public UserDTO assembleUser(User e){
        return new UserDTO(e.getUsername(),e.getPassword(),e.getReservation());
    }

    public User DesAssembleUser(UserDTO e){
        return new User(e.getUsername(),e.getPassword(),e.getReservation());
    }
}

package entities;

 import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import java.util.ArrayList;
import java.util.List;


@PersistenceCapable
public class User {

	private String username;

	private String password;
	@Join
	private List<Reservation> reserveList;
	
	public User(String username, String password) {

		this.username = username;
		this.password = password;
		reserveList=new ArrayList<>();
	}
	public User(){};

	public void addReservation(Reservation r){
        reserveList.add(r);
    }
	
	public List<Reservation> getReservation(){
        return reserveList;
    }


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", reserveList=" + reserveList + "]";
	}

	

	


}

package entities;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable(detachable = "true")
public class User implements Serializable{
public User(){

}

	@PrimaryKey
	private String username;

	private String password;

	@Persistent(defaultFetchGroup = "true")
	@Join
	private List<Reservation> reserveList;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		reserveList=new ArrayList<>();
	}
	public User(String username, String password, List<Reservation> reservation){};

	public void addReservation(Reservation r){
        reserveList.add(r);
    }
	
	public List<Reservation> getReservation(){
        return reserveList;
    }

	public Reservation getLastReservation() {return reserveList.get(reserveList.size()-1);}

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

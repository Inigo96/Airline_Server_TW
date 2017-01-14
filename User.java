package es.deusto.ingenieria.sd.jdo.inventory;

 import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import java.util.ArrayList;
import java.util.List;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class User {

	private String username=null;

	private String password=null;
	@Join
	private List<Reservation> reserveList=new ArrayList<>();
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;

	}
	

	void addReservation(Reservation r){
        reserveList.add(r);
    }
	
	void getReservation(int a){
        reserveList.get(a);
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

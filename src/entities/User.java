package entities;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import java.util.ArrayList;
import java.util.List;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class User {
    @PrimaryKey
    @Persistent
    private int id=0;

    @Persistent
    private String username=null;
    @Persistent
    private String password=null;
    @Join
    private List<Reservation> reserveList=new ArrayList<>();

    public User(int id,String username, String password) {
        this.username = username;
        this.password = password;
        this.id = id;
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

    public int getId() {
        return id;
    }






}

package gateway;

import entities.Flight;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by inigo on 15/01/17.
 */
public class IberiaGateway implements IGateway{

    private String IP;
    private int port;

    public void initialize(String IP, int port){
        this.IP = IP;
        this.port = port;
    }

    private static IberiaGateway ourInstance = new IberiaGateway();

    public static IberiaGateway getInstance() {
        return ourInstance;
    }

    private IberiaGateway() {
    }

    @Override
    public Flight[] searchFlight(String departure, String arrival, GregorianCalendar date){
        try{
            Socket tcpSocket = new Socket(this.IP, this.port);
            //Streams to send and receive information are created from the Socket
            DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream());

            //Send request (a Srting) to the server
            String text;
            text= departure+"$$$$$$$$$#"+arrival+"$$$$$$$$$#"+date.getTimeInMillis();
            out.writeUTF(text);

            //Read response (a String) from the server
            String data = in.readUTF();
            Flight[] devuelve=transformToArray(data);
            System.out.println("devuelve = " + devuelve);
            System.out.println("IBERIA tamanyo" +devuelve.length);
            return devuelve;

        } catch (UnknownHostException e) {
            System.err.println("# TCPSocketClient: Socket error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("# TCPSocketClient: IO error: " + e.getMessage());
        }
        return new Flight[0];
    }

    private Flight[] transformToArray(String text){

        Flight[] res;
        String[] temp;
        String[] atribs;
    /* delimiter */
        String delimiterF = "$$$$$$$$$#";
        String delimiterA = "%&&&%";
    /* given string will be split by the argument delimiter provided. */
        temp = text.split(delimiterF);
        res = new Flight[temp.length];
    /* print substrings */
        for(int i =0; i < temp.length ; i++){
            atribs = temp[i].split(delimiterA);
            GregorianCalendar r= new GregorianCalendar();
            Date e = new Date();
            e.setTime(Long.valueOf(atribs[2]).longValue());
            r.setTime(e);
            res[i]=new Flight(atribs[0],atribs[1],r);
        }
        return res;
    }
}

package gateway;

import entities.Flight;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.GregorianCalendar;

/**
 * Created by inigo on 14/01/17.
 */
public class Iberia implements IGateway{
    private String IP;
    private int port;

    public Iberia (String ip, int port){
        this.IP=ip;
        this.port=port;
    }

    @Override
    public Flight[] searchFlight(String departure, String arrival, GregorianCalendar date) {
        try (Socket tcpSocket = new Socket(this.IP, this.port);
             //Streams to send and receive information are created from the Socket
             DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
             DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){

            //Send request (a Srting) to the server
            String text;
            text= departure+"$$$$$$$$$#"+arrival+"$$$$$$$$$#"+date.getTimeInMillis();
            out.writeUTF(text);

            //Read response (a String) from the server
            String data = in.readUTF();
            text=data;

        } catch (UnknownHostException e) {
            System.err.println("# TCPSocketClient: Socket error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("# TCPSocketClient: IO error: " + e.getMessage());
        }
        return new Flight[0];
    }

}


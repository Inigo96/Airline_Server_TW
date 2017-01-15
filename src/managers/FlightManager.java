package managers;

import com.sun.tools.javac.util.ArrayUtils;
import entities.Flight;
import gateway.*;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.stream.Stream;


/**
 * Created by pablocabezali on 15/1/17.
 */
public class FlightManager {

    IGateway[] arrayGateway;

    public FlightManager(IGateway[] arrayGateway) {
        this.arrayGateway = arrayGateway;
    }

    public Flight[] searchFlight(String departure, String arrival, GregorianCalendar date){

        Flight [] temp;
        Flight [] temp2=new Flight[0];

        for(IGateway gateway: this.arrayGateway){
            temp=gateway.searchFlight(departure, arrival, date);
            if(gateway instanceof AirFranceGateway){
                System.out.println("Gateway AirFrance: ");
                for(Flight flight: temp){
                    System.out.println("flight = " + flight);
                }
            }else if(gateway instanceof IberiaGateway){
                System.out.println("Gateway Iberia: ");
                for(Flight flight: temp){
                    System.out.println("flight = " + flight);
                }
            }
            temp2= fusionArrays(temp,temp2);
        }


        return temp2;
    }
    private Flight[] fusionArrays(Flight[] a, Flight[] b){
        Flight[] fusion= new Flight[a.length+b.length];
        for(int i=0;i<a.length;i++){
            fusion[i]=a[i];
        }
        for(int j=0;j<b.length; j++){
            fusion[j+a.length]=b[j];
        }


        return fusion;
    }

};

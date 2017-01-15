package gateway.utils;

/**
 * Created by inigo on 15/01/17.
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIServiceLocator{

    /** Creates a new instance of RMIServiceLocator */
    public RMIServiceLocator(){

    }

    public void setService(String ip, String port, String serviceName, ) {

        String url = "//" + ip + ":" + port + "/" + serviceName;

        System.out.println("Client looking for service : //"+ip+":"+port+"/"+serviceName);
        try {

            pf= (IProductFinder)Naming.lookup(url);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public IProductFinder getService() {

        return pf;
    }
}

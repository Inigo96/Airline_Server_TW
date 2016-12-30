package managers;

import java.rmi.Naming;

/**
 * Created by inigo on 30/12/16.
 */
public class Server_Manager_Main {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.exit(0);
        }

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        String nameAdmin = "//" + args[0] + ":" + args[1] + "/" + args[2];
        String nameReceiver = "//" + args[0] + ":" + args[1] + "/" + args[3];

        try {
            TVProgramService TVProgData = new TVProgramService();

            ITVProgramAdmin adminService = new TVProgramAdmin(TVProgData);
            Naming.rebind(nameAdmin, adminService);
            System.out.println("* TVProgram Admin Service '" + nameAdmin + "' active and waiting...");

            ITVProgramReceiver receiverService = new TVProgramReceiver(TVProgData);
            Naming.rebind(nameReceiver, receiverService);
            System.out.println("* TVProgram Admin Service '" + nameReceiver + "' active and waiting...");
        } catch (Exception e) {
            System.err.println("$ TVProgramManager exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

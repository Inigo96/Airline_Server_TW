//package db;
//
//import entities.Reservation;
//import entities.User;
//import org.datanucleus.enhancement.*;
//import javax.jdo.*;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.rmi.server.UnicastRemoteObject;
//import java.util.List;
//
///**
// * Created by inigo on 16/01/17.
// */
//public class MySQL {
//
//    PersistenceManagerFactory pmf;
//
//    public MySQL(){
//        pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
//    }
//
//    public synchronized void storeUser(User u){
//        PersistenceManager pm = pmf.getPersistenceManager();
//        Transaction tx = pm.currentTransaction();
//        try {
//            tx.begin();
//            pm.makePersistent(u);
//            System.out.println("Inserting contents into the database ....");
//            tx.commit();
//        } catch (Exception ex) {
//            System.out.println("# Error storing objects: " + ex.getMessage());
//        } finally {
//            if (tx.isActive()) {
//                tx.rollback();
//            }
//            pm.close();
//        }
//    }
//
//    public synchronized void deleteUser(User u){
//        PersistenceManager pm = pmf.getPersistenceManager();
//        Transaction tx = pm.currentTransaction();
//
//        try {
//            tx.begin();
//            Extent<User> extentP = pm.getExtent(User.class);
//
//            for (User p : extentP) {
//                System.out.println(p.getUsername());
//                System.out.println(u.getUsername());
//                if(p.getUsername().equals(u.getUsername()))
//                {
//                    System.out.println("ENTRE!!!!!!!!!!!!!!!!!");
//                    pm.deletePersistent(p);
//                }
//            }
//            tx.commit();
//        } catch (Exception ex) {
//            System.out.println("# Error getting Extent: " + ex.getMessage());
//        } finally {
//            if (tx.isActive()) {
//                tx.rollback();
//            }
//            pm.close();
//        }
//    }
//
//    public synchronized void addReservation(User u, Reservation r){
//        PersistenceManager pm = pmf.getPersistenceManager();
//        Transaction tx = pm.currentTransaction();
//
//        try {
//            tx.begin();
//            Extent<User> extentP = pm.getExtent(User.class);
//
//            for (User p : extentP) {
//                System.out.println(p.getUsername());
//                System.out.println(u.getUsername());
//                if(p.getUsername().equals(u.getUsername()))
//                {
//                    System.out.println("ENTRE!!!!!!!!!!!!!!!!!");
//                    p.addReservation(r);
//                }
//            }
//            tx.commit();
//        } catch (Exception ex) {
//            System.out.println("# Error getting Extent: " + ex.getMessage());
//        } finally {
//            if (tx.isActive()) {
//                tx.rollback();
//            }
//            pm.close();
//        }
//    }
//
//    public synchronized User getUser(String email){
//        System.out.println("Get User from db");
//        PersistenceManager pm = pmf.getPersistenceManager();
//        Transaction tx = pm.currentTransaction();
//        pm.getFetchPlan().setMaxFetchDepth(3);
//        User u = new User();
//        try {
//            tx.begin();
//            Extent<User> extentP = pm.getExtent(User.class);
//
//            for (User p : extentP) {
//                System.out.println(p.getReservation().size());
//                if(p.getUsername().equals(email))
//                {
////                    System.out.println("p.getUsername() = " + p.getUsername());
////                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
////                    ObjectOutputStream oos = new ObjectOutputStream(bos);
////                    oos.writeObject(p);
////                    oos.flush();
////                    oos.close();
////                    bos.close();
////                    byte[] byteData = bos.toByteArray();
////                    ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
////                    u = (User) new ObjectInputStream(bais).readObject();
//                    u=p;
//                }
//            }
//            tx.commit();
//        } catch (Exception ex) {
//            System.out.println("# Error getting Extent: " + ex.getMessage());
//        } finally {
//            if (tx.isActive()) {
//                tx.rollback();
//            }
//            pm.close();
//        }
//        System.out.println(u.getReservation().size());
//        return u;
//    }
//}

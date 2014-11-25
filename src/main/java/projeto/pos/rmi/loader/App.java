package projeto.pos.rmi.loader;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto.pos.rmi.server.CifraDeCesar;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
//        Registry registry;
//        try {
//            registry = LocateRegistry.getRegistry("localhost", 9999);
//            CifraDeCesar c = (CifraDeCesar) registry.lookup("CifraDeCesar");
//            System.out.println(c.criptografar("Oi kelson", 3));
//        } catch (RemoteException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NotBoundException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        String string = "Magdiel;bruno;matias";
        String[] taai = string.split(";");
        
        
        for(int i = 0; i < taai.length;i++){
            System.out.println(taai[i]);
        }
    }
}

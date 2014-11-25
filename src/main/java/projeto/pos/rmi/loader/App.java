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
        Registry registry;
        try {
            registry = LocateRegistry.getRegistry("localhost", 9999);
            CifraDeCesar c = (CifraDeCesar) registry.lookup("CifraDeCesar");
            String frase = "A ligeira raposa saltou sobre o cachorro cansado";
            int chave = 3;
            String result = c.criptografar(frase, chave);
            System.out.println(frase);
            System.out.println(result);
            
        } catch (RemoteException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

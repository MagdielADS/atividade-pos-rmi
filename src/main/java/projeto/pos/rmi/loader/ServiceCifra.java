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
public class ServiceCifra { 
    
    
    public String cifrar( String texto ){
        Registry registry;
        try {
            registry = LocateRegistry.getRegistry("localhost", 9999);
            CifraDeCesar c = (CifraDeCesar) registry.lookup("CifraDeCesar");
            
            int chave = 3;
            
            return c.criptografar(texto, chave);            
            
        } catch (RemoteException ex) {
            Logger.getLogger(ServiceCifra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ServiceCifra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

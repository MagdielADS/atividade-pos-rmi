/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projeto.pos.rmi.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Magdiel Ildefonso
 */
public class CifraDeCesarImpl extends UnicastRemoteObject implements CifraDeCesar{
    
    public CifraDeCesarImpl() throws RemoteException {
        super();
    }
    
    public String criptografar(String frase, int chave) throws RemoteException {
        String result = "";
        int ordChar = 0;
        for (int i = 0; i < frase.length(); i++) {
            ordChar = ((int)frase.charAt(i))-chave;
            if(frase.charAt(i) == ' '){
                result += " ";
            }else if(ordChar >= 65 && ordChar <= 90){
                result += (char)ordChar;
            }else if(ordChar < 97){
                result += (char)(122-((97-ordChar)-1));
            }else if(ordChar >= 97 && ordChar <= 122){
                result += (char)ordChar;
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws AlreadyBoundException {
        Registry registry;
        
        try {
            registry = LocateRegistry.createRegistry(9999);
            registry.bind("CifraDeCesar", new CifraDeCesarImpl());
            System.out.println("Serviço vinculado");
        } catch (RemoteException ex) {
            System.out.println("Servidor inalcançável");
        }
    }
}

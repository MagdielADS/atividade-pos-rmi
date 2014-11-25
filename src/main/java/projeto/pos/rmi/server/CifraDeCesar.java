/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projeto.pos.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Magdiel Ildefonso
 */
public interface CifraDeCesar extends Remote{
    public String criptografar(String frase, int chave) throws RemoteException;
}

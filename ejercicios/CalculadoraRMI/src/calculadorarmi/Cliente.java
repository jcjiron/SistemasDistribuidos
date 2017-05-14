/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorarmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author juan
 */
public class Cliente {
 
     
    public static void main(String[] args) throws RemoteException, NotBoundException{
     String IP_SERVER="localhost";
     String PUERTO_SERVER = "5050";
     String REGISTRY_NAME = "MY_REGISTRY";
     String PAH_REGISTRY = IP_SERVER+":"+PUERTO_SERVER+"/"+REGISTRY_NAME;
     
        Registry registry = LocateRegistry.getRegistry();
        Operaciones testRemote = (Operaciones) registry.lookup(PAH_REGISTRY);
        int[] x = {1,2,3,4,5,6,7,8,9}; 
        System.out.println(testRemote.suma(x));
    }
}

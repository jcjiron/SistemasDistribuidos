/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorarmi;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        /**
         *
         */
        String IP = "localhost";
        String PUERTO = "5050";
        String REGISTRY_NAME = "MY_REGISTRY";
        String PAH_REGISTRY = IP + ":" + PUERTO + "/" + REGISTRY_NAME;

        Remote keyRegOperaciones = UnicastRemoteObject.exportObject(new Operaciones() {
            @Override
            public int suma(int[] x) throws RemoteException {
                int s =0;
                for(int i : x){
                    s += i;
                }
                return s;
            }

            @Override
            public int resta(int x, int y) throws RemoteException {
                return x - y;
            }

            @Override
            public int multiplicacion(int x, int y) throws RemoteException {
                return x * y;
            }

            @Override
            public int division(int x, int y) throws RemoteException {
                if (y != 0)
                    return x / y;
                return 0;

            }

            @Override
            public int desvStd(int[] x) throws RemoteException {
                int s = suma(x);
                s = s * s;
                s = s / x.length;
                return (int)Math.sqrt(s);
                
            }

            @Override
            public int varianza(int[] x) throws RemoteException {
                int med = media(x);
                int sum =0;
                for(int i=0 ;i <x.length; i++){
                    sum += Math.pow(x[i] - med,2);
                }
                return sum /x.length;
            }

            @Override
            public int media(int[] x) throws RemoteException {
                int sum =0;
                for(int i : x){
                    sum +=i;
                }
                return sum / x.length;
            }
        }, 0);

        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        registry.bind(PAH_REGISTRY, keyRegOperaciones);
        System.out.println("Serevr corriendo: " + PAH_REGISTRY);

    }

}

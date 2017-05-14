/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorarmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author juan
 */
public interface Operaciones extends Remote {
    int suma(int[] x) throws RemoteException;
    int resta(int x, int y) throws RemoteException;
    int multiplicacion(int x, int y) throws RemoteException;
    int division(int x, int y) throws RemoteException;
    int media(int[] x) throws RemoteException;
    int desvStd(int[] x) throws RemoteException;
    int varianza(int[] x) throws RemoteException;
}

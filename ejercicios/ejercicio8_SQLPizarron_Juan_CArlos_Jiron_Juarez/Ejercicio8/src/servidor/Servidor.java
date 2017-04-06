/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author juancarlos
 */
public class Servidor extends Thread {

    public static final int PUERTO = 6666;
    ServerSocket socketServidor;

    public Servidor() {
        try {
            socketServidor = new ServerSocket(PUERTO);
            System.out.println("Funcionando ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket socketCliente = socketServidor.accept();
                SQLConexion miconexion = new SQLConexion(socketCliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
            new Servidor();
            
        /*SQLManager manager = new SQLManager();
        manager.getDatabases().forEach(item -> System.out.println(item));
        System.out.println("==========================");
        manager.getTables("ESCUELA").forEach(item -> System.out.println(item));
        System.out.println("==========================");
        manager.showCreateTable("ESCUELA", "Profesor").forEach(item -> System.out.println(item));
        System.out.println("==========================");

        ArrayList<String[]> t = manager.getTable("ESCUELA", "select *from Profesor");
        if (t != null) {
            int filas = t.size();
            int col = t.get(0).length;

            for (int i = 0; i < filas; i++) {
                String[] c = t.get(i);
                for (int e = 0; e < col; e++) {
                    System.out.print(c[e] + "\t");
                }
                System.out.println("");
            }
        } else {
            System.out.println("No hay tabla");

        }*/

    }
}

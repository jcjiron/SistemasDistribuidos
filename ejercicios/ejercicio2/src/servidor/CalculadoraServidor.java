/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import cliente.Calc;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author juancarlos
 */
public class CalculadoraServidor {
    public static int PUERTO=8000;
    public static void main(String[] args) throws IOException {
        
        Calc c = new Calc();

        System.out.println("suma: " + c.suma(a, b));
        System.out.println("resta: " + c.resta(a, b));
        System.out.println("multipliacion: " + c.multiplicacion(a, b));
        System.out.println("division: " + c.division(a, b));

        ServerSocket serverSocket = new ServerSocket(PUERTO);
        while (true) {
            Socket socketCliente = serverSocket.accept();
            InputStream entrada = socketCliente.getInputStream();
            OutputStream salida = socketCliente.getOutputStream();
            
            DataInputStream entradaDatos = new DataInputStream (entrada);
            DataOuputStream salidaDatos = new DataOutputStream (salida);

            
            PrintWriter pw = new PrintWriter(socketCliente.getOutputStream());
            pw.println(mostrarFecha());
            pw.close();
            socketCliente.close();
        }
    }
}

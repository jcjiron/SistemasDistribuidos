/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import cliente.Calc;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import cliente.Operaciones;

/**
 *
 * @author juancarlos
 */
public class CalculadoraServidor {

    public static int PUERTO = 8000;
    public static String DIRECCION = "127.0.0.1";

    public static void main(String[] args) throws IOException {

        /*System.out.println("suma: " + c.suma(a, b));
        System.out.println("resta: " + c.resta(a, b));
        System.out.println("multipliacion: " + c.multiplicacion(a, b));
        System.out.println("division: " + c.division(a, b));*/
        ServerSocket serverSocket = new ServerSocket(PUERTO);
        while (true) {
            
            System.out.println("Esperando cliente");
            Socket socketCliente = serverSocket.accept();
            
            InputStream entrada = socketCliente.getInputStream();
            OutputStream salida = socketCliente.getOutputStream();

            DataInputStream entradaDatos = new DataInputStream(entrada);
            DataOutputStream salidaDatos = new DataOutputStream(salida);

            int a = entradaDatos.readInt();
            int b = entradaDatos.readInt();
            int opc = entradaDatos.readInt();
            
            System.out.println("Resultado: "+hacerOperaciones(a, b, opc));
            
            salidaDatos.writeInt(hacerOperaciones(a, b, opc));
            
            salidaDatos.close();
            salida.close();
            
            entradaDatos.close();
            entrada.close();
            
            socketCliente.close();
        }
        
        
    }

    public static int hacerOperaciones(int a, int b, int opc) {
        Calc c = new Calc();
        switch (opc) {
            case Operaciones.SUMA:
                return c.suma(a, b);
            case Operaciones.RESTA:
                return c.resta(a, b);

            case Operaciones.MULTIPLICACION:
                return c.multiplicacion(a, b);

            case Operaciones.DIVISION:
                return c.division(a, b);
                
            default:
                    return 0;
        }
    }
}

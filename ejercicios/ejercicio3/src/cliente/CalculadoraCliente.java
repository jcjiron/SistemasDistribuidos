/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import servidor.CalculadoraServidor;

/**
 *
 * @author juancarlos
 */
public class CalculadoraCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce a");
        int a = in.nextInt();
        System.out.println("Introduce b");
        int b = in.nextInt();
        System.out.println("Introduce la opcion de la operacion");
        System.out.println("1) Suma");
        System.out.println("2) Resta");
        System.out.println("3) Multiplicacion");
        System.out.println("4) Division");
        int opc = in.nextInt();

        Socket socketCliente = new Socket(CalculadoraServidor.DIRECCION, CalculadoraServidor.PUERTO);

        InputStream entrada = socketCliente.getInputStream();
        OutputStream salida = socketCliente.getOutputStream();

        DataInputStream entradaDatos = new DataInputStream(entrada);
        DataOutputStream salidaDatos = new DataOutputStream(salida);
        
        salidaDatos.writeInt(a);
        salidaDatos.writeInt(b);
        salidaDatos.writeInt(opc);

        int res=entradaDatos.readInt();
        System.out.println("Resultado: "+res);
        
        entradaDatos.close();
        entrada.close();
        
        salidaDatos.close();
        salida.close();
        socketCliente.close();
    }

}

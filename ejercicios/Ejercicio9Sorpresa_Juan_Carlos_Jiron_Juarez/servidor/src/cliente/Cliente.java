/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos
 */
public class Cliente {

    private final static int PORT = 5000;
    private final static String SERVER = "localhost";

    public static void main(String[] args) {
        boolean banderaSalida = false;
        Socket socketCliente;
        try {
            JOptionPane.showMessageDialog(null, "Cliente Funcionando");
            while (!banderaSalida) {
                socketCliente = new Socket(SERVER, PORT);
                BufferedReader input = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                PrintStream ps = new PrintStream(socketCliente.getOutputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("$> Escriba comando");
                String peticion = br.readLine();
                ps.println(peticion);
                String st = input.readLine();
                if(st != null){
                    JOptionPane.showMessageDialog(null,""+ st);
                    System.out.println(" $> "+st);
                }
                if(peticion.equals("salir")){
                    banderaSalida = true;
                    JOptionPane.showMessageDialog(null, "Fin del programa");
                    System.out.println("Fin del programa");
                }
                socketCliente.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

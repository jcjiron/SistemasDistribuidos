/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos
 */
public class Servidor {

    private final static int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket socketServidor = new ServerSocket(PORT);
            JOptionPane.showMessageDialog(null, "Servidor Funcionando");
            JOptionPane.showMessageDialog(null, "Servidor en espera");
            System.out.println("En espera de clientes...");
            Socket socketCliente;
            while (true) {
                socketCliente = socketServidor.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                PrintStream ps = new PrintStream(socketCliente.getOutputStream());
                String peticionesDelCliente = br.readLine();
                System.out.println("Peticion del cliente [" + peticionesDelCliente + "]");
                String salida = procesarSolicitud(peticionesDelCliente);
                System.out.println("Resultado de peticion" + salida + ".");
                ps.flush();
                ps.println(salida);
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String procesarSolicitud(String peticion) {
        String resultado = "";
        String[] frasesDeNorris = {
            "A Chuck Norris no le gustan los caballos, los caballos le gustan a Chuck Norris",
            "Chuck Norris puede dividir por 0",
            "Cuando Chuck Norris conduce los pasos de cebra se apartan",
            "Para que Chuck Norris naciera no hicieron falta 9 meses basto con 1 dia",
            "Chuck Norris jugo a la ruleta rusa con una pistola completamente cargada y gano"
        };
        ArrayList<String> listaDeFrases = new ArrayList<>();
        Collections.addAll(listaDeFrases, frasesDeNorris);
        String[] libros = {
            "Angeles y Demonios - Dan Brown",
            "Divina Comedia - Dante Alighieri",
            "Don Quijote de la Mancha - Miguel de Cervantes",
            "Cien años de soledad - Gabriel Garcia Marquez"
        };
        ArrayList<String> listaDeLibros = new ArrayList<>();
        Collections.addAll(listaDeLibros, libros);
        if(peticion != null){
            switch(peticion){
                case "frase":
                    Collections.shuffle(listaDeFrases);
                    resultado = listaDeFrases.get(0);
                    break;
                case "libro":
                    Collections.shuffle(listaDeLibros);
                    resultado = listaDeLibros.get(0);
                    break;
                case "salir":
                    resultado = "bye";
                    break;
                default:
                    resultado = "La peticion no se pudo resolver";
                    break;
            }
        }
        return resultado;
    }

}

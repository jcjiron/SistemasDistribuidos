package servidor;

import ejercicio4.controler.CategoriaDAO;
import ejercicio4.model.Categoria;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author juancarlos
 */
public class Servidor implements Peticiones {

    public static final String ERROR_SOCKET_SERVIDOR = "Error al levantar el sockt servidor";
    public static final String ERROR_SOCKET_CLIENTE = "Error al recibir peticion del cliente";
    public static final String ERROR_FLUJO = "Error al abrir flujo";
    public static final String PETICION_RECIBIDA = "Peticion recibida";
    public static final String RESPUESTA_ENVIADA = "Respuesta enviada";
    public static final String PROCESANDO_PETICION = "Procesando peticion";

    public static final String IP = "127.0.0.1";
    public static final int PUERTO = 8000;

    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        CategoriaDAO manager = new CategoriaDAO();

        ObjectInputStream entradaDatos = null;
        ObjectOutputStream salidaDatos = null;
        //============================================================================
        //============================================================================
        //creando socket del servidor
        try {
            serverSocket = new ServerSocket(PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ERROR_SOCKET_SERVIDOR);
        }

        while (true) {
            //=========================================================================
            //=========================================================================
            //recibiendo la peticion
            System.out.println("=============================");
            System.out.println("=============================");
            System.out.println("Esperando cliente");
            Socket socketCliente = null;
            try {
                socketCliente = serverSocket.accept();
                //System.out.println("creando serverSocket");
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }

            //====================================================================
            //====================================================================
            //====================================================================
            //====================================================================
            //envolviendo el flujo
            try {
                //System.out.println("antes del Object data input");
                entradaDatos = new ObjectInputStream(socketCliente.getInputStream());

               // System.out.println("despues del Object data input");
                //=================================================================
                //=================================================================
                //leyndo el flujo
                //System.out.println("antes del read int");
                int opc = entradaDatos.readInt();

                System.out.println(PETICION_RECIBIDA + " " + opc);
                Categoria c;
                //System.out.println("despues del read int");
                //=================================================================
                //=================================================================
                //procesando la peticion
                System.out.println(PROCESANDO_PETICION);
                switch (opc) {
                    case PETICION_ALTA:
                        c = (Categoria) entradaDatos.readObject();
                        manager.alta(c);
                        break;
                    case PETICION_BAJA:
                        c = (Categoria) entradaDatos.readObject();
                        manager.baja(c);
                        break;
                    case PETICION_CAMBIO:
                        c = (Categoria) entradaDatos.readObject();
                        manager.editar(c);
                        break;
                    default:
                        //listar elemento
                        break;
                }

                //entradaDatos.close();
                //=================================================================
                //=================================================================
                //devolviendo la respuesta
                List<Categoria> li = manager.listar();
                System.out.println(li.toString());
                salidaDatos = new ObjectOutputStream(socketCliente.getOutputStream());
                salidaDatos.writeObject(li);
                salidaDatos.flush();
                //salidaDatos.close();
                System.out.println(RESPUESTA_ENVIADA);

            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                entradaDatos.close();
                salidaDatos.close();
                socketCliente.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        //=================================================================
        //=================================================================
    }
}

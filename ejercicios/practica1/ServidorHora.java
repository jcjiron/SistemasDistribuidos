import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.util.Date;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.*;

public class ServidorHora{
  public static final int puerto=5000;

  private static String mostrarHora(){
    GregorianCalendar calendar=new GregorianCalendar();
    Date fecha=calendar.getTime();
    DateFormat hora=DateFormat.getTimeInstance(DateFormat.SHORT);
    return hora.format(fecha);
  }

  private static String mostrarFecha(){

    Date fecha=new Date();

    return fecha.toString();
  }

  public static void main(String args[])throws IOException{
    ServerSocket serverSocket =  new ServerSocket(puerto);
    while(true){
      Socket socketCliente= serverSocket.accept();
      PrintWriter pw = new PrintWriter(socketCliente.getOutputStream());
      pw. println(mostrarFecha());
      pw.close();
      socketCliente.close();
    }

  }
}

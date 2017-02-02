import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClienteHora{
  public static void main(String[] args)throws Exception {
    Socket socket = new Socket("localhost",ServidorHora.puerto);
    InputStream is = socket.getInputStream();
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    System.out.println(br.readLine());
    br.close();
    socket.close();

  }


}

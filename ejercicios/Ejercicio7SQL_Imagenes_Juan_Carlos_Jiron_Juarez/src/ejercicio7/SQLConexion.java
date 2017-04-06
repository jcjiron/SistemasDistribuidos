package ejercicio7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class SQLConexion extends Thread {

    protected Socket socketCliente;
    protected BufferedReader entrada;
    protected PrintStream salida;
    protected String consulta;

    public SQLConexion(Socket socketCliente) {
        this.socketCliente = socketCliente;
        try {
            entrada = new BufferedReader(new InputStreamReader(this.socketCliente.getInputStream()));
            salida = new PrintStream(this.socketCliente.getOutputStream());
        } catch (IOException e) {
            System.err.println(e);
            try {
                this.socketCliente.close();
            } catch (IOException e2) {

            }
            return;
        }
        start();
    }

    public void run() {
        try {
            consulta = entrada.readLine();
            System.out.println("Consulta a ejecutar: " + consulta + ";");
            ejecutarSQL();
        } catch (IOException e) {
        } finally {
            try {
                socketCliente.close();
            } catch (IOException e) {

            }
        }
    }

    public void ejecutarSQL() {
        Connection cnn;
        Statement st;
        ResultSet rs;
        ResultSetMetaData resultadoMetadata;
        boolean existenMasFilas;
        String  registro;
        int numeroColumnas, i;

        // JDBC driver name and database URL
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String PORT = "3306";
        String HOST = "localhost";
        String DATABASE_NAME = "Mobiles";

        //  Database credentials
        String USER = "root";
        String PASS = "root";
        String DB_URL = "jdbc:mysql://" + HOST + ":" + PORT + "/"+DATABASE_NAME;

        try {
            Class.forName(JDBC_DRIVER);
            cnn = DriverManager.getConnection(DB_URL,USER,PASS);
            st = cnn.createStatement();
            rs = st.executeQuery(consulta);
            existenMasFilas = rs.next();
            if (!existenMasFilas) {
                salida.println("No hay más filas.");
                return;
            }
            resultadoMetadata = rs.getMetaData();
            numeroColumnas = resultadoMetadata.getColumnCount();
            System.out.println(numeroColumnas + "columnas en el resultado.");
            while (existenMasFilas) {
                registro = "";
                for (i = 1; i <= numeroColumnas; i++) {
                    registro = registro.concat(rs.getString(i) + " ");
                }
                salida.println(registro);
                System.out.println(registro);
                existenMasFilas = rs.next();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

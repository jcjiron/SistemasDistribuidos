package ejercicio7.cliente;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class DBDto {

    private static final String SQL_SHOW_TABLES = "CALL spShowTables()";
    private static final String SQL_SHOW_CREATE_TABLE = "show create table ?";
    private static final String SQL_SHOW_DATABASES = "CALL spShowDatabases()";
    private static final String SQL_READ = "CALL spREAD(?)";
    private static final String SQL_READ_ALL = "CALL spREAD_ALL()";
    private static final String TABLE_CAT = "TABLE_CAT";

    private static final String ERROR_CONEXION = "Error al conectar base de datos";
    private static final String CONEXION_EXITOSA = "Conexion exitosa";
    private static final String CONEXION_CERRADA = "Conexion cerrada";
    private static final String ERROR_CLOSE_CALLABLE = "Error al cerrar CallableStatement";
    private static final String ERROR_CLOSE_RESULTSET = "Error al cerrrar ResultSet";

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String PORT = "3306";
    private static final String HOST = "localhost";
    private static final String DATABASE_NAME = "tarea4";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String DB_URL = "jdbc:mysql://" + HOST + ":" + PORT + "/";

    private Connection connection;

    public DBDto() {

    }

    public void getDatabases() {
        getConnection();
        try {
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet res = meta.getCatalogs();
            while (res.next()) {
                String db = res.getString(TABLE_CAT);
                System.out.println(db);
            }
            closeResultSet(res);
            closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(DBDto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showCreateTable(String database, String table) {
                    getConnection(database);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("show create table " + database + "." + table);
            if (rs.next()) {
                System.out.println("Table Name: " + rs.getString(1));
                System.out.println("SQL Code: " + rs.getString(2));
            }
            closeResultSet(rs);
            closeStatement(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(DBDto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getTables(String database) {
        getConnection(database);

        try {
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            while (rs.next()) {
                System.out.println(rs.getString(3));
            }
            closeResultSet(rs);
            closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(DBDto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getConnection() {
        connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            //System.out.println(CONEXION_EXITOSA);

        } catch (SQLException ex) {
            Logger.getLogger(DBDto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ERROR_CONEXION);
        }
    }

    private void getConnection(String database) {
        connection = null;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBDto.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            connection = DriverManager.getConnection(DB_URL + database, USER, PASS);
            //System.out.println(CONEXION_EXITOSA);

        } catch (SQLException ex) {
            Logger.getLogger(DBDto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ERROR_CONEXION);
        }
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
            //System.out.println(CONEXION_CERRADA);
        } catch (SQLException ex) {
            Logger.getLogger(DBDto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void closeResultSet(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ERROR_CLOSE_RESULTSET);
            Logger.getLogger(DBDto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void closeStatement(CallableStatement cs) {
        try {
            cs.close();
        } catch (SQLException ex) {
            System.out.println(ERROR_CLOSE_CALLABLE);
            Logger.getLogger(DBDto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void closeStatement(PreparedStatement ps) {
        try {
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ERROR_CLOSE_CALLABLE);
            Logger.getLogger(DBDto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void closeStatement(Statement s) {
        try {
            s.close();
        } catch (SQLException ex) {
            System.out.println(ERROR_CLOSE_CALLABLE);
            Logger.getLogger(DBDto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

package tarea4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tarea4.HechoContract.HechoEntry;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author juancarlos
 */
public class HechoDAO {

    private static final String SQL_INSERT = "CALL spINSERT(?)";
    private static final String SQL_DELETE = "CALL spDELETE(?)";
    private static final String SQL_UPDATE = "CALL spUPDATE(?,?)";
    private static final String SQL_READ = "CALL spREAD(?)";
    private static final String SQL_READ_ALL = "CALL spREAD_ALL()";

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

    private static final String DB_URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE_NAME;

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection connection;

    public HechoDAO() {

    }

    public void create(Hecho echo) {
        getConnection();
        try {
            CallableStatement cStmt = connection.prepareCall(SQL_INSERT);
            cStmt.setString(1, echo.getNombreHecho());
            cStmt.execute();
            cStmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(HechoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Hecho echo) {
        getConnection();
        try {
            CallableStatement cStmt = connection.prepareCall(SQL_UPDATE);
            cStmt.setInt(1, echo.getIdHecho());
            cStmt.setString(2, echo.getNombreHecho());
            cStmt.execute();
            cStmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(HechoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Hecho read(Hecho echo) {
        getConnection();
        Hecho e = new Hecho();
        try {
            CallableStatement cStmt = connection.prepareCall(SQL_READ);
            cStmt.setInt(1, echo.getIdHecho());
            ResultSet rs = cStmt.executeQuery();

            while (rs.next()) {
                e.setIdHecho(rs.getInt(HechoEntry.idHecho));
                e.setNombreHecho(rs.getString(HechoEntry.nombreHecho));
            }
            closeResultSet(rs);
            closeStatement(cStmt);
        } catch (SQLException ex) {
            Logger.getLogger(HechoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return e;
    }

    public List<Hecho> readAll() {
        getConnection();
        List<Hecho> list = new ArrayList<Hecho>();
        try {

            CallableStatement cStmt = connection.prepareCall(SQL_READ_ALL);
            ResultSet rs = cStmt.executeQuery();

            while (rs.next()) {

                Hecho e = new Hecho();
                e.setIdHecho(rs.getInt(HechoEntry.idHecho));
                e.setNombreHecho(rs.getString(HechoEntry.nombreHecho));
                list.add(e);
            }
            closeResultSet(rs);
            closeStatement(cStmt);

        } catch (SQLException ex) {
            Logger.getLogger(HechoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void delete(Hecho echo) {
        getConnection();
        try {
            CallableStatement cStmt = connection.prepareCall(SQL_DELETE);
            cStmt.setInt(1, echo.getIdHecho());
            cStmt.execute();
            closeStatement(cStmt);
        } catch (SQLException ex) {
            Logger.getLogger(HechoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getConnection() {
        connection = null;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HechoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println(CONEXION_EXITOSA);

        } catch (SQLException ex) {
            Logger.getLogger(HechoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ERROR_CONEXION);
        }
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
            System.out.println(CONEXION_CERRADA);
        } catch (SQLException ex) {
            Logger.getLogger(HechoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void closeResultSet(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ERROR_CLOSE_RESULTSET);
            Logger.getLogger(HechoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void closeStatement(CallableStatement cs) {
        try {
            cs.close();
        } catch (SQLException ex) {
            System.out.println(ERROR_CLOSE_CALLABLE);
            Logger.getLogger(HechoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

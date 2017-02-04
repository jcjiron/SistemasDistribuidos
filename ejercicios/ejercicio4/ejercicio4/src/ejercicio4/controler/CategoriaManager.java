/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4.controler;

import ejercicio4.model.Cat;
import ejercicio4.model.Categoria;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ejercicio4.data.CategoriaContract.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author juan
 */
public class CategoriaManager implements Cat {

    private static final String ERROR_CONEXION = "Error al conectar base de datos";
    private static final String CONEXION_EXITOSA = "Conexion exitosa";

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String PORT = "3306";
    private static final String HOST = "localhost";
    private static final String DATABASE_NAME = "distribuidos";
    private static final String DB_URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE_NAME;

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection conn = null;


    public CategoriaManager() {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println(CONEXION_EXITOSA);

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ERROR_CONEXION);
        }

    }
    
    private void cerrarConexion(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean alta(Categoria c) {
        try {
            String q = "INSERT INTO " + CategoriaEntry.TABLE_NAME + "("
                    + CategoriaEntry.ID + ","
                    + CategoriaEntry.NAME + ") VALUES ( ? , ? )";
            //System.out.println(q);
            PreparedStatement pstmt = conn.prepareStatement(q);

            pstmt.setInt(1, c.getIdCategoria());
            pstmt.setString(2, c.getNombreCategoria());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean baja(Categoria c) {
        try {
            String deleteSQL = "DELETE  FROM " + CategoriaEntry.TABLE_NAME + " WHERE " + CategoriaEntry.ID + "= ?";
            PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setInt(1, c.getIdCategoria());
            // execute delete SQL stetement
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editar(Categoria c) {
        try {
            String updateTableSQL = "UPDATE " + CategoriaEntry.TABLE_NAME + " SET " + CategoriaEntry.NAME + " = ? WHERE " + CategoriaEntry.ID + " = ?";
            PreparedStatement pstmt = conn.prepareStatement(updateTableSQL);
            pstmt.setString(1, c.getNombreCategoria());
            pstmt.setInt(2, c.getIdCategoria());
// execute insert SQL stetement
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean buscar(int id) {
        return true;
    }

    @Override
    public List<Categoria> listar() {
       List<Categoria> list=new ArrayList<Categoria>();
        try {
            
            String selectSQL = "SELECT * FROM "+CategoriaEntry.TABLE_NAME;
            PreparedStatement pstmt = conn.prepareStatement(selectSQL);
            
            ResultSet rs = pstmt.executeQuery(selectSQL );
            while (rs.next()) {
                int userid = rs.getInt(CategoriaEntry.ID);
                String username = rs.getString(CategoriaEntry.NAME);
                list.add(new Categoria(userid,username));
            }
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    


}

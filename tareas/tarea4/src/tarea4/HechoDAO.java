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
    private static final String SQL_INSERT="CALL spINSERT(?)";
    private static final String SQL_DELETE="CALL spDELETE(?)";
    private static final String SQL_UPDATE="CALL spUPDATE(?)";
    private static final String SQL_READ="CALL spREAD(?)";
    private static final String SQL_READ_ALL="CALL spREAD_ALL(?)";
    
    private static final String MYSQL_DRIVER="com.mysql.jdbc.Driver";
    private static final String USER="root";
    private static final String PASS="root";
    private static final String URL="jdbc:mysql://localhost:3306/distribuidos";
    private Connection connection;
    
    public HechoDAO(){
        try {
            Class.forName(MYSQL_DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HechoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HechoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void create(Hecho echo){
        
    }
    
    public void update(Hecho echo){
        
    }
    
    public Hecho read(Hecho echo){
        return new Hecho();
    }
    
    public List<Hecho> readAll(Hecho echo){
        return new ArrayList<Hecho>();
    }
    
    public void delete(Hecho echo){
        
    }
    
    public void getConnection(){
        
    }
    
    public void closeConnection(Connection con){
        
    }
    
    public void closeResultSet(ResultSet rs){
        
    }
    
    public void closeStatement(CallableStatement cs){
        
    }
    
}

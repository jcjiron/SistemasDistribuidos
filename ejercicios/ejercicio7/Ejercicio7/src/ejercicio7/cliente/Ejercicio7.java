/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7.cliente;

/**
 *
 * @author juancarlos
 */
public class Ejercicio7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBDto db=new DBDto();
        db.getDatabases();
        System.out.println("==========================");
        db.getTables("ESCUELA");
        System.out.println("==========================");
        db.showCreateTable("ESCUELA","Profesor");
    }
    
}

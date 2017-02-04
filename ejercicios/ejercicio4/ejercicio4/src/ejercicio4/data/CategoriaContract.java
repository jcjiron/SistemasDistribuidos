/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4.data;

/**
 *
 * @author juancarlos
 */
public class CategoriaContract {
    public static abstract class CategoriaEntry{
        public static final String TABLE_NAME ="categoria";
        
        public static final String ID = "idCategoria";
        public static final String NAME = "nombreCategoria";
    }
}

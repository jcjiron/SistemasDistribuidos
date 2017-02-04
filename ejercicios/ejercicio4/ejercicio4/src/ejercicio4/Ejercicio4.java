/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import ejercicio4.controler.CategoriaManager;
import ejercicio4.model.Categoria;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author juan
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*CategoriaManager m=new CategoriaManager();
        Categoria c=new Categoria(1,"lacteos");
        m.alta(c);
        //m.baja(c);
        List<Categoria> l=m.listar();
        for(Categoria ca:l){
            System.out.println(ca.getNombreCategoria());
        }*/
        UUID uniqueKey = UUID.randomUUID();
    System.out.println (uniqueKey);
  }
    
    
}

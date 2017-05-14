/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciox.cliente;

import ejerciciox.dao.UsuarioDAO;
import ejerciciox.entidades.Usuario;
import java.rmi.Naming;

/**
 *
 * @author asuncionez
 */
public class Cliente {
    public static void main(String[] args) {
        try{
            Usuario u = 
             new Usuario(2, "diana", "ww","diana", "prince",
                     "ww@ldj.com");
            UsuarioDAO dao =(UsuarioDAO)
                    Naming.lookup("usuario");
            dao.create(u);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

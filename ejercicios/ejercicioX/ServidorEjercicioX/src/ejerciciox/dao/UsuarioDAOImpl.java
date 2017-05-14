/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciox.dao;

import ejerciciox.entidades.Usuario;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author asuncionez
 */
public class UsuarioDAOImpl 
        extends UnicastRemoteObject
        implements UsuarioDAO{

    public UsuarioDAOImpl() 
            throws RemoteException{
    }
    
    
    @Override
    public void create(Usuario u) 
            throws RemoteException {
        EntityManagerFactory emf=
                Persistence.
        createEntityManagerFactory("EjercicioXPU");
        EntityManager em = emf.
                createEntityManager();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
    }

    @Override
    public void update(Usuario u) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario read(Usuario u) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> readAll() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Usuario u) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(1099);
            UsuarioDAOImpl 
                    usuario= new UsuarioDAOImpl();
            Naming.bind("usuario",usuario );
            System.out.println("Servidor funcionando");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

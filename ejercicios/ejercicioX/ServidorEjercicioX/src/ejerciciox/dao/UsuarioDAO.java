/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciox.dao;

import ejerciciox.entidades.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author asuncionez
 */
public interface UsuarioDAO extends Remote{
    public void create(Usuario u) 
            throws RemoteException;
    public void update (Usuario u)
            throws RemoteException;
    public Usuario read(Usuario u)
            throws RemoteException;
    public List<Usuario> readAll()
            throws RemoteException;
    public void delete(Usuario u)
            throws RemoteException;
    
}

package ejercicio4.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;

/**
 *
 * @author juan
 */
public interface Cat {
    public boolean alta(Categoria c);
    public boolean baja(Categoria c);
    public boolean editar(Categoria c);
    public boolean buscar(int id);
    public List<Categoria> listar();
}

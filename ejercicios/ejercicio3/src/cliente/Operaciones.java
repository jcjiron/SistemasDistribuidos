/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author juancarlos
 */
public interface Operaciones {
    public static final int SUMA=1;
    public static final int RESTA=2;
    public static final int MULTIPLICACION=3;
    public static final int DIVISION=4;
    
    public int suma(int a,int b);
    public int resta(int a,int b);
    public int multiplicacion(int a,int b);
    public int division(int a,int b);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

/**
 *
 * @author juancarlos
 */
public interface Peticiones {
    public static final String PETICION_SHOW_DATABASES = "1";
    public static final String PETICION_SHOW_TABLES = "2";
    public static final String PETICION_SHOW_CREATE_TABLE = "3";
    public static final String PETICION_QUERY = "4";
}

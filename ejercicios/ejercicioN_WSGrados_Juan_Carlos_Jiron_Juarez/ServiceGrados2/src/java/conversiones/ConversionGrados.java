/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversiones;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author juancarlos
 */
@WebService(serviceName = "ConversionGrados")
public class ConversionGrados {

    /**
     * This is a sample web service operation
     */
    
        @WebMethod(operationName = "CelsiusToFahrenheit")
    public double celsiusToFahrent(@WebParam(name = "grados") double grados) {
        return (grados*9/5)+32;
    }
    
     @WebMethod(operationName = "FahrenheitToCelsius")
    public double faharentToCels(@WebParam(name = "grados") double grados) {
        return (grados-32)*(5/9);
    }
    
     @WebMethod(operationName = "CelsiusToKelvin")
    public double celsiusToKelvin(@WebParam(name = "grados") double grados) {
        return grados +273.15;
    }
    
      @WebMethod(operationName = "KelvinToCelsius")
    public double kelvinToCelsius(@WebParam(name = "grados") double grados) {
        return grados - 273.15;
    }
}

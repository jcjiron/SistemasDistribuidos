
package cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cliente package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CrearEmpleado_QNAME = new QName("http://web.ipn.com/", "crearEmpleado");
    private final static QName _CrearEmpleadoResponse_QNAME = new QName("http://web.ipn.com/", "crearEmpleadoResponse");
    private final static QName _Hello_QNAME = new QName("http://web.ipn.com/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://web.ipn.com/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CrearEmpleado }
     * 
     */
    public CrearEmpleado createCrearEmpleado() {
        return new CrearEmpleado();
    }

    /**
     * Create an instance of {@link CrearEmpleadoResponse }
     * 
     */
    public CrearEmpleadoResponse createCrearEmpleadoResponse() {
        return new CrearEmpleadoResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Empleado }
     * 
     */
    public Empleado createEmpleado() {
        return new Empleado();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearEmpleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.ipn.com/", name = "crearEmpleado")
    public JAXBElement<CrearEmpleado> createCrearEmpleado(CrearEmpleado value) {
        return new JAXBElement<CrearEmpleado>(_CrearEmpleado_QNAME, CrearEmpleado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearEmpleadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.ipn.com/", name = "crearEmpleadoResponse")
    public JAXBElement<CrearEmpleadoResponse> createCrearEmpleadoResponse(CrearEmpleadoResponse value) {
        return new JAXBElement<CrearEmpleadoResponse>(_CrearEmpleadoResponse_QNAME, CrearEmpleadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.ipn.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.ipn.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

}

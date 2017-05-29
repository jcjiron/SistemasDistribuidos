
package mx.ipn.wsc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mx.ipn.wsc package. 
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

    private final static QName _GetEmpleados_QNAME = new QName("http://ws.ip.mc/", "getEmpleados");
    private final static QName _DeleteEmpleadoResponse_QNAME = new QName("http://ws.ip.mc/", "deleteEmpleadoResponse");
    private final static QName _UpdateEmpleado_QNAME = new QName("http://ws.ip.mc/", "updateEmpleado");
    private final static QName _GetEmpleadoById_QNAME = new QName("http://ws.ip.mc/", "getEmpleadoById");
    private final static QName _GetEmpleadosResponse_QNAME = new QName("http://ws.ip.mc/", "getEmpleadosResponse");
    private final static QName _AddEmpleadoResponse_QNAME = new QName("http://ws.ip.mc/", "addEmpleadoResponse");
    private final static QName _UpdateEmpleadoResponse_QNAME = new QName("http://ws.ip.mc/", "updateEmpleadoResponse");
    private final static QName _AddEmpleado_QNAME = new QName("http://ws.ip.mc/", "addEmpleado");
    private final static QName _GetEmpleadoByIdResponse_QNAME = new QName("http://ws.ip.mc/", "getEmpleadoByIdResponse");
    private final static QName _DeleteEmpleado_QNAME = new QName("http://ws.ip.mc/", "deleteEmpleado");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mx.ipn.wsc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddEmpleadoResponse }
     * 
     */
    public AddEmpleadoResponse createAddEmpleadoResponse() {
        return new AddEmpleadoResponse();
    }

    /**
     * Create an instance of {@link GetEmpleadosResponse }
     * 
     */
    public GetEmpleadosResponse createGetEmpleadosResponse() {
        return new GetEmpleadosResponse();
    }

    /**
     * Create an instance of {@link UpdateEmpleadoResponse }
     * 
     */
    public UpdateEmpleadoResponse createUpdateEmpleadoResponse() {
        return new UpdateEmpleadoResponse();
    }

    /**
     * Create an instance of {@link DeleteEmpleado }
     * 
     */
    public DeleteEmpleado createDeleteEmpleado() {
        return new DeleteEmpleado();
    }

    /**
     * Create an instance of {@link AddEmpleado }
     * 
     */
    public AddEmpleado createAddEmpleado() {
        return new AddEmpleado();
    }

    /**
     * Create an instance of {@link GetEmpleadoByIdResponse }
     * 
     */
    public GetEmpleadoByIdResponse createGetEmpleadoByIdResponse() {
        return new GetEmpleadoByIdResponse();
    }

    /**
     * Create an instance of {@link DeleteEmpleadoResponse }
     * 
     */
    public DeleteEmpleadoResponse createDeleteEmpleadoResponse() {
        return new DeleteEmpleadoResponse();
    }

    /**
     * Create an instance of {@link GetEmpleados }
     * 
     */
    public GetEmpleados createGetEmpleados() {
        return new GetEmpleados();
    }

    /**
     * Create an instance of {@link GetEmpleadoById }
     * 
     */
    public GetEmpleadoById createGetEmpleadoById() {
        return new GetEmpleadoById();
    }

    /**
     * Create an instance of {@link UpdateEmpleado }
     * 
     */
    public UpdateEmpleado createUpdateEmpleado() {
        return new UpdateEmpleado();
    }

    /**
     * Create an instance of {@link Empleado }
     * 
     */
    public Empleado createEmpleado() {
        return new Empleado();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmpleados }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ip.mc/", name = "getEmpleados")
    public JAXBElement<GetEmpleados> createGetEmpleados(GetEmpleados value) {
        return new JAXBElement<GetEmpleados>(_GetEmpleados_QNAME, GetEmpleados.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEmpleadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ip.mc/", name = "deleteEmpleadoResponse")
    public JAXBElement<DeleteEmpleadoResponse> createDeleteEmpleadoResponse(DeleteEmpleadoResponse value) {
        return new JAXBElement<DeleteEmpleadoResponse>(_DeleteEmpleadoResponse_QNAME, DeleteEmpleadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmpleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ip.mc/", name = "updateEmpleado")
    public JAXBElement<UpdateEmpleado> createUpdateEmpleado(UpdateEmpleado value) {
        return new JAXBElement<UpdateEmpleado>(_UpdateEmpleado_QNAME, UpdateEmpleado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmpleadoById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ip.mc/", name = "getEmpleadoById")
    public JAXBElement<GetEmpleadoById> createGetEmpleadoById(GetEmpleadoById value) {
        return new JAXBElement<GetEmpleadoById>(_GetEmpleadoById_QNAME, GetEmpleadoById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmpleadosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ip.mc/", name = "getEmpleadosResponse")
    public JAXBElement<GetEmpleadosResponse> createGetEmpleadosResponse(GetEmpleadosResponse value) {
        return new JAXBElement<GetEmpleadosResponse>(_GetEmpleadosResponse_QNAME, GetEmpleadosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEmpleadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ip.mc/", name = "addEmpleadoResponse")
    public JAXBElement<AddEmpleadoResponse> createAddEmpleadoResponse(AddEmpleadoResponse value) {
        return new JAXBElement<AddEmpleadoResponse>(_AddEmpleadoResponse_QNAME, AddEmpleadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmpleadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ip.mc/", name = "updateEmpleadoResponse")
    public JAXBElement<UpdateEmpleadoResponse> createUpdateEmpleadoResponse(UpdateEmpleadoResponse value) {
        return new JAXBElement<UpdateEmpleadoResponse>(_UpdateEmpleadoResponse_QNAME, UpdateEmpleadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEmpleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ip.mc/", name = "addEmpleado")
    public JAXBElement<AddEmpleado> createAddEmpleado(AddEmpleado value) {
        return new JAXBElement<AddEmpleado>(_AddEmpleado_QNAME, AddEmpleado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmpleadoByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ip.mc/", name = "getEmpleadoByIdResponse")
    public JAXBElement<GetEmpleadoByIdResponse> createGetEmpleadoByIdResponse(GetEmpleadoByIdResponse value) {
        return new JAXBElement<GetEmpleadoByIdResponse>(_GetEmpleadoByIdResponse_QNAME, GetEmpleadoByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEmpleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ip.mc/", name = "deleteEmpleado")
    public JAXBElement<DeleteEmpleado> createDeleteEmpleado(DeleteEmpleado value) {
        return new JAXBElement<DeleteEmpleado>(_DeleteEmpleado_QNAME, DeleteEmpleado.class, null, value);
    }

}

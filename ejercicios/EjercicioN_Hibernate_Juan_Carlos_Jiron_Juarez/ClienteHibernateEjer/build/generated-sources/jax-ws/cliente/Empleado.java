
package cliente;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para empleado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="empleado"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idEmpleado" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="maternoEmpleado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombreEmpleado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paternoEmpleado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "empleado", propOrder = {
    "email",
    "idEmpleado",
    "maternoEmpleado",
    "nombreEmpleado",
    "paternoEmpleado"
})
public class Empleado {

    protected String email;
    protected int idEmpleado;
    protected String maternoEmpleado;
    protected String nombreEmpleado;
    protected String paternoEmpleado;

    /**
     * Obtiene el valor de la propiedad email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define el valor de la propiedad email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtiene el valor de la propiedad idEmpleado.
     * 
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * Define el valor de la propiedad idEmpleado.
     * 
     */
    public void setIdEmpleado(int value) {
        this.idEmpleado = value;
    }

    /**
     * Obtiene el valor de la propiedad maternoEmpleado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaternoEmpleado() {
        return maternoEmpleado;
    }

    /**
     * Define el valor de la propiedad maternoEmpleado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaternoEmpleado(String value) {
        this.maternoEmpleado = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreEmpleado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    /**
     * Define el valor de la propiedad nombreEmpleado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreEmpleado(String value) {
        this.nombreEmpleado = value;
    }

    /**
     * Obtiene el valor de la propiedad paternoEmpleado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaternoEmpleado() {
        return paternoEmpleado;
    }

    /**
     * Define el valor de la propiedad paternoEmpleado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaternoEmpleado(String value) {
        this.paternoEmpleado = value;
    }

}


package webservice.impl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice.impl package. 
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

    private final static QName _Exception_QNAME = new QName("http://impl.webservice/", "Exception");
    private final static QName _CalcularCusto_QNAME = new QName("http://impl.webservice/", "calcularCusto");
    private final static QName _CalcularCustoResponse_QNAME = new QName("http://impl.webservice/", "calcularCustoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CalcularCusto }
     * 
     */
    public CalcularCusto createCalcularCusto() {
        return new CalcularCusto();
    }

    /**
     * Create an instance of {@link CalcularCustoResponse }
     * 
     */
    public CalcularCustoResponse createCalcularCustoResponse() {
        return new CalcularCustoResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.webservice/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalcularCusto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.webservice/", name = "calcularCusto")
    public JAXBElement<CalcularCusto> createCalcularCusto(CalcularCusto value) {
        return new JAXBElement<CalcularCusto>(_CalcularCusto_QNAME, CalcularCusto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalcularCustoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.webservice/", name = "calcularCustoResponse")
    public JAXBElement<CalcularCustoResponse> createCalcularCustoResponse(CalcularCustoResponse value) {
        return new JAXBElement<CalcularCustoResponse>(_CalcularCustoResponse_QNAME, CalcularCustoResponse.class, null, value);
    }

}

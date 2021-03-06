
package fr.polytech.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "EnvoiService", targetNamespace = "http://ws.polytech.fr/", wsdlLocation = "http://localhost:9516/envoi?WSDL")
public class EnvoiService
    extends Service
{

    private final static URL ENVOISERVICE_WSDL_LOCATION;
    private final static WebServiceException ENVOISERVICE_EXCEPTION;
    private final static QName ENVOISERVICE_QNAME = new QName("http://ws.polytech.fr/", "EnvoiService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9516/envoi?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ENVOISERVICE_WSDL_LOCATION = url;
        ENVOISERVICE_EXCEPTION = e;
    }

    public EnvoiService() {
        super(__getWsdlLocation(), ENVOISERVICE_QNAME);
    }

    public EnvoiService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ENVOISERVICE_QNAME, features);
    }

    public EnvoiService(URL wsdlLocation) {
        super(wsdlLocation, ENVOISERVICE_QNAME);
    }

    public EnvoiService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ENVOISERVICE_QNAME, features);
    }

    public EnvoiService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EnvoiService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Envoi
     */
    @WebEndpoint(name = "EnvoiPort")
    public Envoi getEnvoiPort() {
        return super.getPort(new QName("http://ws.polytech.fr/", "EnvoiPort"), Envoi.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Envoi
     */
    @WebEndpoint(name = "EnvoiPort")
    public Envoi getEnvoiPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.polytech.fr/", "EnvoiPort"), Envoi.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ENVOISERVICE_EXCEPTION!= null) {
            throw ENVOISERVICE_EXCEPTION;
        }
        return ENVOISERVICE_WSDL_LOCATION;
    }

}

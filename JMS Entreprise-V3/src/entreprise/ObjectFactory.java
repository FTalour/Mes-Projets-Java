//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.10.21 à 03:24:13 PM CEST 
//


package entreprise;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the entreprise package. 
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

    private final static QName _Entreprise_QNAME = new QName("http://www.leuville.com/entreprise2", "entreprise");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: entreprise
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Departement }
     * 
     */
    public Departement createDepartement() {
        return new Departement();
    }

    /**
     * Create an instance of {@link Entreprise }
     * 
     */
    public Entreprise createEntreprise() {
        return new Entreprise();
    }

    /**
     * Create an instance of {@link RaisonSociale }
     * 
     */
    public RaisonSociale createRaisonSociale() {
        return new RaisonSociale();
    }

    /**
     * Create an instance of {@link Departement.Membres }
     * 
     */
    public Departement.Membres createDepartementMembres() {
        return new Departement.Membres();
    }

    /**
     * Create an instance of {@link Entreprise.Departements }
     * 
     */
    public Entreprise.Departements createEntrepriseDepartements() {
        return new Entreprise.Departements();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Entreprise }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.leuville.com/entreprise2", name = "entreprise")
    public JAXBElement<Entreprise> createEntreprise(Entreprise value) {
        return new JAXBElement<Entreprise>(_Entreprise_QNAME, Entreprise.class, null, value);
    }

}

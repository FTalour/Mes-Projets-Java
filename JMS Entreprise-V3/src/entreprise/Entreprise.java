//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.10.21 à 03:24:13 PM CEST 
//


package entreprise;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour entreprise complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="entreprise">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="raison-sociale" type="{http://www.leuville.com/entreprise2}raison-sociale"/>
 *         &lt;element name="departements">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="departement" type="{http://www.leuville.com/entreprise2}departement" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entreprise", propOrder = {
    "raisonSociale",
    "departements"
})
public class Entreprise {

    @XmlElement(name = "raison-sociale", required = true)
    protected RaisonSociale raisonSociale;
    @XmlElement(required = true)
    protected Entreprise.Departements departements;

    /**
     * Obtient la valeur de la propriété raisonSociale.
     * 
     * @return
     *     possible object is
     *     {@link RaisonSociale }
     *     
     */
    public RaisonSociale getRaisonSociale() {
        return raisonSociale;
    }

    /**
     * Définit la valeur de la propriété raisonSociale.
     * 
     * @param value
     *     allowed object is
     *     {@link RaisonSociale }
     *     
     */
    public void setRaisonSociale(RaisonSociale value) {
        this.raisonSociale = value;
    }

    /**
     * Obtient la valeur de la propriété departements.
     * 
     * @return
     *     possible object is
     *     {@link Entreprise.Departements }
     *     
     */
    public Entreprise.Departements getDepartements() {
        return departements;
    }

    /**
     * Définit la valeur de la propriété departements.
     * 
     * @param value
     *     allowed object is
     *     {@link Entreprise.Departements }
     *     
     */
    public void setDepartements(Entreprise.Departements value) {
        this.departements = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="departement" type="{http://www.leuville.com/entreprise2}departement" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "departement"
    })
    public static class Departements {

        @XmlElement(required = true)
        protected List<Departement> departement;

        /**
         * Gets the value of the departement property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the departement property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDepartement().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Departement }
         * 
         * 
         */
        public List<Departement> getDepartement() {
            if (departement == null) {
                departement = new ArrayList<Departement>();
            }
            return this.departement;
        }

    }

}

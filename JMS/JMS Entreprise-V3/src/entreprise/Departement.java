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
 * <p>Classe Java pour departement complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="departement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="intitule" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="responsable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="adjoint" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="membres">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
@XmlType(name = "departement", propOrder = {
    "intitule",
    "responsable",
    "adjoint",
    "membres"
})
public class Departement {

    @XmlElement(required = true)
    protected String intitule;
    @XmlElement(required = true)
    protected String responsable;
    protected String adjoint;
    @XmlElement(required = true)
    protected Departement.Membres membres;

    /**
     * Obtient la valeur de la propriété intitule.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * Définit la valeur de la propriété intitule.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntitule(String value) {
        this.intitule = value;
    }

    /**
     * Obtient la valeur de la propriété responsable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsable() {
        return responsable;
    }

    /**
     * Définit la valeur de la propriété responsable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsable(String value) {
        this.responsable = value;
    }

    /**
     * Obtient la valeur de la propriété adjoint.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdjoint() {
        return adjoint;
    }

    /**
     * Définit la valeur de la propriété adjoint.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdjoint(String value) {
        this.adjoint = value;
    }

    /**
     * Obtient la valeur de la propriété membres.
     * 
     * @return
     *     possible object is
     *     {@link Departement.Membres }
     *     
     */
    public Departement.Membres getMembres() {
        return membres;
    }

    /**
     * Définit la valeur de la propriété membres.
     * 
     * @param value
     *     allowed object is
     *     {@link Departement.Membres }
     *     
     */
    public void setMembres(Departement.Membres value) {
        this.membres = value;
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
     *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
        "nom"
    })
    public static class Membres {

        @XmlElement(required = true)
        protected List<String> nom;

        /**
         * Gets the value of the nom property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the nom property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNom().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getNom() {
            if (nom == null) {
                nom = new ArrayList<String>();
            }
            return this.nom;
        }

    }

}

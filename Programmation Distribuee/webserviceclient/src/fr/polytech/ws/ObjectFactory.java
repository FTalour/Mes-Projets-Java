
package fr.polytech.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.polytech.ws package. 
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

    private final static QName _AjouterPanier_QNAME = new QName("http://ws.polytech.fr/", "ajouterPanier");
    private final static QName _RetirerPanierResponse_QNAME = new QName("http://ws.polytech.fr/", "retirerPanierResponse");
    private final static QName _ModifierPanierResponse_QNAME = new QName("http://ws.polytech.fr/", "modifierPanierResponse");
    private final static QName _AjouterPanierResponse_QNAME = new QName("http://ws.polytech.fr/", "ajouterPanierResponse");
    private final static QName _AfficherCommande_QNAME = new QName("http://ws.polytech.fr/", "afficherCommande");
    private final static QName _ViewCatalogue_QNAME = new QName("http://ws.polytech.fr/", "viewCatalogue");
    private final static QName _GetNewPanier_QNAME = new QName("http://ws.polytech.fr/", "getNewPanier");
    private final static QName _GetNewPanierResponse_QNAME = new QName("http://ws.polytech.fr/", "getNewPanierResponse");
    private final static QName _ExceptionArticle_QNAME = new QName("http://ws.polytech.fr/", "ExceptionArticle");
    private final static QName _SetCatalogueResponse_QNAME = new QName("http://ws.polytech.fr/", "setCatalogueResponse");
    private final static QName _ModifierPanier_QNAME = new QName("http://ws.polytech.fr/", "modifierPanier");
    private final static QName _RetirerPanier_QNAME = new QName("http://ws.polytech.fr/", "retirerPanier");
    private final static QName _GetCatalogueResponse_QNAME = new QName("http://ws.polytech.fr/", "getCatalogueResponse");
    private final static QName _GetCatalogue_QNAME = new QName("http://ws.polytech.fr/", "getCatalogue");
    private final static QName _ViewCatalogueResponse_QNAME = new QName("http://ws.polytech.fr/", "viewCatalogueResponse");
    private final static QName _AfficherCommandeResponse_QNAME = new QName("http://ws.polytech.fr/", "afficherCommandeResponse");
    private final static QName _SetCatalogue_QNAME = new QName("http://ws.polytech.fr/", "setCatalogue");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.polytech.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Catalogue }
     * 
     */
    public Catalogue createCatalogue() {
        return new Catalogue();
    }

    /**
     * Create an instance of {@link Catalogue.Art }
     * 
     */
    public Catalogue.Art createCatalogueArt() {
        return new Catalogue.Art();
    }

    /**
     * Create an instance of {@link ModifierPanier }
     * 
     */
    public ModifierPanier createModifierPanier() {
        return new ModifierPanier();
    }

    /**
     * Create an instance of {@link SetCatalogueResponse }
     * 
     */
    public SetCatalogueResponse createSetCatalogueResponse() {
        return new SetCatalogueResponse();
    }

    /**
     * Create an instance of {@link RetirerPanier }
     * 
     */
    public RetirerPanier createRetirerPanier() {
        return new RetirerPanier();
    }

    /**
     * Create an instance of {@link GetCatalogue }
     * 
     */
    public GetCatalogue createGetCatalogue() {
        return new GetCatalogue();
    }

    /**
     * Create an instance of {@link GetCatalogueResponse }
     * 
     */
    public GetCatalogueResponse createGetCatalogueResponse() {
        return new GetCatalogueResponse();
    }

    /**
     * Create an instance of {@link ViewCatalogueResponse }
     * 
     */
    public ViewCatalogueResponse createViewCatalogueResponse() {
        return new ViewCatalogueResponse();
    }

    /**
     * Create an instance of {@link AfficherCommandeResponse }
     * 
     */
    public AfficherCommandeResponse createAfficherCommandeResponse() {
        return new AfficherCommandeResponse();
    }

    /**
     * Create an instance of {@link SetCatalogue }
     * 
     */
    public SetCatalogue createSetCatalogue() {
        return new SetCatalogue();
    }

    /**
     * Create an instance of {@link AjouterPanier }
     * 
     */
    public AjouterPanier createAjouterPanier() {
        return new AjouterPanier();
    }

    /**
     * Create an instance of {@link RetirerPanierResponse }
     * 
     */
    public RetirerPanierResponse createRetirerPanierResponse() {
        return new RetirerPanierResponse();
    }

    /**
     * Create an instance of {@link AjouterPanierResponse }
     * 
     */
    public AjouterPanierResponse createAjouterPanierResponse() {
        return new AjouterPanierResponse();
    }

    /**
     * Create an instance of {@link ModifierPanierResponse }
     * 
     */
    public ModifierPanierResponse createModifierPanierResponse() {
        return new ModifierPanierResponse();
    }

    /**
     * Create an instance of {@link AfficherCommande }
     * 
     */
    public AfficherCommande createAfficherCommande() {
        return new AfficherCommande();
    }

    /**
     * Create an instance of {@link GetNewPanier }
     * 
     */
    public GetNewPanier createGetNewPanier() {
        return new GetNewPanier();
    }

    /**
     * Create an instance of {@link GetNewPanierResponse }
     * 
     */
    public GetNewPanierResponse createGetNewPanierResponse() {
        return new GetNewPanierResponse();
    }

    /**
     * Create an instance of {@link ViewCatalogue }
     * 
     */
    public ViewCatalogue createViewCatalogue() {
        return new ViewCatalogue();
    }

    /**
     * Create an instance of {@link ExceptionArticle }
     * 
     */
    public ExceptionArticle createExceptionArticle() {
        return new ExceptionArticle();
    }

    /**
     * Create an instance of {@link Article }
     * 
     */
    public Article createArticle() {
        return new Article();
    }

    /**
     * Create an instance of {@link Catalogue.Art.Entry }
     * 
     */
    public Catalogue.Art.Entry createCatalogueArtEntry() {
        return new Catalogue.Art.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouterPanier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "ajouterPanier")
    public JAXBElement<AjouterPanier> createAjouterPanier(AjouterPanier value) {
        return new JAXBElement<AjouterPanier>(_AjouterPanier_QNAME, AjouterPanier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetirerPanierResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "retirerPanierResponse")
    public JAXBElement<RetirerPanierResponse> createRetirerPanierResponse(RetirerPanierResponse value) {
        return new JAXBElement<RetirerPanierResponse>(_RetirerPanierResponse_QNAME, RetirerPanierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifierPanierResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "modifierPanierResponse")
    public JAXBElement<ModifierPanierResponse> createModifierPanierResponse(ModifierPanierResponse value) {
        return new JAXBElement<ModifierPanierResponse>(_ModifierPanierResponse_QNAME, ModifierPanierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouterPanierResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "ajouterPanierResponse")
    public JAXBElement<AjouterPanierResponse> createAjouterPanierResponse(AjouterPanierResponse value) {
        return new JAXBElement<AjouterPanierResponse>(_AjouterPanierResponse_QNAME, AjouterPanierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AfficherCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "afficherCommande")
    public JAXBElement<AfficherCommande> createAfficherCommande(AfficherCommande value) {
        return new JAXBElement<AfficherCommande>(_AfficherCommande_QNAME, AfficherCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewCatalogue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "viewCatalogue")
    public JAXBElement<ViewCatalogue> createViewCatalogue(ViewCatalogue value) {
        return new JAXBElement<ViewCatalogue>(_ViewCatalogue_QNAME, ViewCatalogue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNewPanier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "getNewPanier")
    public JAXBElement<GetNewPanier> createGetNewPanier(GetNewPanier value) {
        return new JAXBElement<GetNewPanier>(_GetNewPanier_QNAME, GetNewPanier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNewPanierResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "getNewPanierResponse")
    public JAXBElement<GetNewPanierResponse> createGetNewPanierResponse(GetNewPanierResponse value) {
        return new JAXBElement<GetNewPanierResponse>(_GetNewPanierResponse_QNAME, GetNewPanierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExceptionArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "ExceptionArticle")
    public JAXBElement<ExceptionArticle> createExceptionArticle(ExceptionArticle value) {
        return new JAXBElement<ExceptionArticle>(_ExceptionArticle_QNAME, ExceptionArticle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCatalogueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "setCatalogueResponse")
    public JAXBElement<SetCatalogueResponse> createSetCatalogueResponse(SetCatalogueResponse value) {
        return new JAXBElement<SetCatalogueResponse>(_SetCatalogueResponse_QNAME, SetCatalogueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifierPanier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "modifierPanier")
    public JAXBElement<ModifierPanier> createModifierPanier(ModifierPanier value) {
        return new JAXBElement<ModifierPanier>(_ModifierPanier_QNAME, ModifierPanier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetirerPanier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "retirerPanier")
    public JAXBElement<RetirerPanier> createRetirerPanier(RetirerPanier value) {
        return new JAXBElement<RetirerPanier>(_RetirerPanier_QNAME, RetirerPanier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCatalogueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "getCatalogueResponse")
    public JAXBElement<GetCatalogueResponse> createGetCatalogueResponse(GetCatalogueResponse value) {
        return new JAXBElement<GetCatalogueResponse>(_GetCatalogueResponse_QNAME, GetCatalogueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCatalogue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "getCatalogue")
    public JAXBElement<GetCatalogue> createGetCatalogue(GetCatalogue value) {
        return new JAXBElement<GetCatalogue>(_GetCatalogue_QNAME, GetCatalogue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewCatalogueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "viewCatalogueResponse")
    public JAXBElement<ViewCatalogueResponse> createViewCatalogueResponse(ViewCatalogueResponse value) {
        return new JAXBElement<ViewCatalogueResponse>(_ViewCatalogueResponse_QNAME, ViewCatalogueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AfficherCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "afficherCommandeResponse")
    public JAXBElement<AfficherCommandeResponse> createAfficherCommandeResponse(AfficherCommandeResponse value) {
        return new JAXBElement<AfficherCommandeResponse>(_AfficherCommandeResponse_QNAME, AfficherCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCatalogue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.polytech.fr/", name = "setCatalogue")
    public JAXBElement<SetCatalogue> createSetCatalogue(SetCatalogue value) {
        return new JAXBElement<SetCatalogue>(_SetCatalogue_QNAME, SetCatalogue.class, null, value);
    }

}

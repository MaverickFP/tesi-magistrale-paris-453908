
package it.parisnews.test.wb.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.parisnews.test.wb.service package. 
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

    private final static QName _FindUserResponse_QNAME = new QName("http://service.wb.test.parisnews.it/", "findUserResponse");
    private final static QName _FindUser_QNAME = new QName("http://service.wb.test.parisnews.it/", "findUser");
    private final static QName _DelUser_QNAME = new QName("http://service.wb.test.parisnews.it/", "delUser");
    private final static QName _AddUser_QNAME = new QName("http://service.wb.test.parisnews.it/", "addUser");
    private final static QName _AddUserResponse_QNAME = new QName("http://service.wb.test.parisnews.it/", "addUserResponse");
    private final static QName _DelUserResponse_QNAME = new QName("http://service.wb.test.parisnews.it/", "delUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.parisnews.test.wb.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindUser }
     * 
     */
    public FindUser createFindUser() {
        return new FindUser();
    }

    /**
     * Create an instance of {@link FindUserResponse }
     * 
     */
    public FindUserResponse createFindUserResponse() {
        return new FindUserResponse();
    }

    /**
     * Create an instance of {@link DelUser }
     * 
     */
    public DelUser createDelUser() {
        return new DelUser();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link DelUserResponse }
     * 
     */
    public DelUserResponse createDelUserResponse() {
        return new DelUserResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.wb.test.parisnews.it/", name = "findUserResponse")
    public JAXBElement<FindUserResponse> createFindUserResponse(FindUserResponse value) {
        return new JAXBElement<FindUserResponse>(_FindUserResponse_QNAME, FindUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.wb.test.parisnews.it/", name = "findUser")
    public JAXBElement<FindUser> createFindUser(FindUser value) {
        return new JAXBElement<FindUser>(_FindUser_QNAME, FindUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DelUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.wb.test.parisnews.it/", name = "delUser")
    public JAXBElement<DelUser> createDelUser(DelUser value) {
        return new JAXBElement<DelUser>(_DelUser_QNAME, DelUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.wb.test.parisnews.it/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.wb.test.parisnews.it/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DelUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.wb.test.parisnews.it/", name = "delUserResponse")
    public JAXBElement<DelUserResponse> createDelUserResponse(DelUserResponse value) {
        return new JAXBElement<DelUserResponse>(_DelUserResponse_QNAME, DelUserResponse.class, null, value);
    }

}

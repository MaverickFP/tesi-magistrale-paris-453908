
package it.parisnews.test.wb.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UserRepository", targetNamespace = "http://service.wb.test.parisnews.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserRepository {


    /**
     * 
     * @param arg0
     * @return
     *     returns it.parisnews.test.wb.service.User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addUser", targetNamespace = "http://service.wb.test.parisnews.it/", className = "it.parisnews.test.wb.service.AddUser")
    @ResponseWrapper(localName = "addUserResponse", targetNamespace = "http://service.wb.test.parisnews.it/", className = "it.parisnews.test.wb.service.AddUserResponse")
    @Action(input = "http://service.wb.test.parisnews.it/UserRepository/addUserRequest", output = "http://service.wb.test.parisnews.it/UserRepository/addUserResponse")
    public User addUser(
        @WebParam(name = "arg0", targetNamespace = "")
        User arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns it.parisnews.test.wb.service.User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findUser", targetNamespace = "http://service.wb.test.parisnews.it/", className = "it.parisnews.test.wb.service.FindUser")
    @ResponseWrapper(localName = "findUserResponse", targetNamespace = "http://service.wb.test.parisnews.it/", className = "it.parisnews.test.wb.service.FindUserResponse")
    @Action(input = "http://service.wb.test.parisnews.it/UserRepository/findUserRequest", output = "http://service.wb.test.parisnews.it/UserRepository/findUserResponse")
    public User findUser(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "delUser", targetNamespace = "http://service.wb.test.parisnews.it/", className = "it.parisnews.test.wb.service.DelUser")
    @ResponseWrapper(localName = "delUserResponse", targetNamespace = "http://service.wb.test.parisnews.it/", className = "it.parisnews.test.wb.service.DelUserResponse")
    @Action(input = "http://service.wb.test.parisnews.it/UserRepository/delUserRequest", output = "http://service.wb.test.parisnews.it/UserRepository/delUserResponse")
    public int delUser(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}

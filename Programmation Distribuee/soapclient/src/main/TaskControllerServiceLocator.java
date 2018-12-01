/**
 * TaskControllerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public class TaskControllerServiceLocator extends org.apache.axis.client.Service implements main.TaskControllerService {

    public TaskControllerServiceLocator() {
    }


    public TaskControllerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TaskControllerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TaskControllerPort
    private java.lang.String TaskControllerPort_address = "http://localhost:8080/taskController";

    public java.lang.String getTaskControllerPortAddress() {
        return TaskControllerPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TaskControllerPortWSDDServiceName = "TaskControllerPort";

    public java.lang.String getTaskControllerPortWSDDServiceName() {
        return TaskControllerPortWSDDServiceName;
    }

    public void setTaskControllerPortWSDDServiceName(java.lang.String name) {
        TaskControllerPortWSDDServiceName = name;
    }

    public main.TaskController getTaskControllerPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TaskControllerPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTaskControllerPort(endpoint);
    }

    public main.TaskController getTaskControllerPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            main.TaskControllerPortBindingStub _stub = new main.TaskControllerPortBindingStub(portAddress, this);
            _stub.setPortName(getTaskControllerPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTaskControllerPortEndpointAddress(java.lang.String address) {
        TaskControllerPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (main.TaskController.class.isAssignableFrom(serviceEndpointInterface)) {
                main.TaskControllerPortBindingStub _stub = new main.TaskControllerPortBindingStub(new java.net.URL(TaskControllerPort_address), this);
                _stub.setPortName(getTaskControllerPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TaskControllerPort".equals(inputPortName)) {
            return getTaskControllerPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://main/", "TaskControllerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://main/", "TaskControllerPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TaskControllerPort".equals(portName)) {
            setTaskControllerPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

/**
 * TaskControllerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public interface TaskControllerService extends javax.xml.rpc.Service {
    public java.lang.String getTaskControllerPortAddress();

    public main.TaskController getTaskControllerPort() throws javax.xml.rpc.ServiceException;

    public main.TaskController getTaskControllerPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

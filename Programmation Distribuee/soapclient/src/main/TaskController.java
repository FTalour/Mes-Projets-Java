/**
 * TaskController.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public interface TaskController extends java.rmi.Remote {
    public main.TaskID submit(main.Task arg0, main.StatusListener arg1) throws java.rmi.RemoteException;
    public void cancel(main.TaskID arg0) throws java.rmi.RemoteException, main.StatusException;
}

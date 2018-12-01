package main;

public class TaskControllerProxy implements main.TaskController {
  private String _endpoint = null;
  private main.TaskController taskController = null;
  
  public TaskControllerProxy() {
    _initTaskControllerProxy();
  }
  
  public TaskControllerProxy(String endpoint) {
    _endpoint = endpoint;
    _initTaskControllerProxy();
  }
  
  private void _initTaskControllerProxy() {
    try {
      taskController = (new main.TaskControllerServiceLocator()).getTaskControllerPort();
      if (taskController != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)taskController)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)taskController)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (taskController != null)
      ((javax.xml.rpc.Stub)taskController)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public main.TaskController getTaskController() {
    if (taskController == null)
      _initTaskControllerProxy();
    return taskController;
  }
  
  public main.TaskID submit(main.Task arg0, main.StatusListener arg1) throws java.rmi.RemoteException{
    if (taskController == null)
      _initTaskControllerProxy();
    return taskController.submit(arg0, arg1);
  }
  
  public void cancel(main.TaskID arg0) throws java.rmi.RemoteException, main.StatusException{
    if (taskController == null)
      _initTaskControllerProxy();
    taskController.cancel(arg0);
  }
  
  
}
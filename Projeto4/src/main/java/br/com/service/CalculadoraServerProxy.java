package br.com.service;

public class CalculadoraServerProxy implements br.com.service.CalculadoraServer {
  private String _endpoint = null;
  private br.com.service.CalculadoraServer calculadoraServer = null;
  
  public CalculadoraServerProxy() {
    _initCalculadoraServerProxy();
  }
  
  public CalculadoraServerProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalculadoraServerProxy();
  }
  
  private void _initCalculadoraServerProxy() {
    try {
      calculadoraServer = (new br.com.service.CalculadoraServerImplServiceLocator()).getCalculadoraServerPort();
      if (calculadoraServer != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calculadoraServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calculadoraServer)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calculadoraServer != null)
      ((javax.xml.rpc.Stub)calculadoraServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.service.CalculadoraServer getCalculadoraServer() {
    if (calculadoraServer == null)
      _initCalculadoraServerProxy();
    return calculadoraServer;
  }
  
  public float divisao(float num1, float arg1) throws java.rmi.RemoteException{
    if (calculadoraServer == null)
      _initCalculadoraServerProxy();
    return calculadoraServer.divisao(num1, arg1);
  }
  
  public float soma(float num1, float num2) throws java.rmi.RemoteException{
    if (calculadoraServer == null)
      _initCalculadoraServerProxy();
    return calculadoraServer.soma(num1, num2);
  }
  
  public float subtracao(float num1, float arg1) throws java.rmi.RemoteException{
    if (calculadoraServer == null)
      _initCalculadoraServerProxy();
    return calculadoraServer.subtracao(num1, arg1);
  }
  
  public float multiplicacao(float num1, float arg1) throws java.rmi.RemoteException{
    if (calculadoraServer == null)
      _initCalculadoraServerProxy();
    return calculadoraServer.multiplicacao(num1, arg1);
  }
  
  
}
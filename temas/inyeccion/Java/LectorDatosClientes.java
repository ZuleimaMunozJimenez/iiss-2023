package es.jpascu.ioc.googleguice.services;

import com.google.inject.Inject;

public class LectorDatosClientes {

 private IClienteDao clientesDao;

 @Inject
 public void setClientesDao(IClienteDao clientesDao) {
  this.clientesDao = clientesDao;
 }

 public void escribirDatosCliente(String id) {
  clientesDao.leerClienteDao(id);
 }
}

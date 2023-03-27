package es.jpascu.ioc.googleguice.services;

public class ClienteDaoJdbc implements IClienteDao {

 @Override
 public void leerClienteDao(String id) {
  System.out.println("Datos de cliente: " + id);
 }

}

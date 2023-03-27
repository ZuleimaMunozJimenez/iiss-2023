package es.jpascu.ioc.test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import es.jpascu.ioc.googleguice.services.ClienteDaoJdbc;
import es.jpascu.ioc.googleguice.services.IClienteDao;
import es.jpascu.ioc.googleguice.services.LectorDatosClientes;

public class TestGoogleGuice {
 public static void main(String args[]) {
  Injector injector = Guice.createInjector(new JdbcInjectionModule());
  LectorDatosClientes lectorClientes = injector
    .getInstance(LectorDatosClientes.class);

  lectorClientes.escribirDatosCliente("jpascu");
 }

 public static class JdbcInjectionModule extends AbstractModule {
  @Override
  protected void configure() {
   bind(IClienteDao.class).to(ClienteDaoJdbc.class);
  }

 }
}

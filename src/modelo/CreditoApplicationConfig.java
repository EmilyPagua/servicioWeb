package modelo;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("credito")
public class CreditoApplicationConfig extends Application {
  Application app;

 @Override
  public Set<Class<?>> getClasses() {
      Set<Class<?>> resources = new HashSet<>();
      addRestreourceClasses(resources);
      return resources;
  }
 
  private void addRestreourceClasses(Set<Class<?>> resources) {
    // TODO add classes to HashSet
    resources.add(ws.CreditoRest.class);
  }
}
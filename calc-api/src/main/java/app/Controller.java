package app;

import io.jooby.annotations.*;

@Path("/")
public class Controller {

  @GET
  public String sayHi() {
    return "Bem-vindos(as) a API calculadora!";
  }
}

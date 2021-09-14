package app;

import io.jooby.annotations.*;

@Path("/")
public class Controlador {

  @GET
  public String boasVindas() {
    return "Bem-vindos(as) a API calculadora!";
  }
}

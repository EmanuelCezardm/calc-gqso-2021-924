package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {
  @Test
  public void welcome() {
    Controlador controller = new Controlador();
    assertEquals("Bem-vindos(as) a API calculadora!", controller.boasVindas());
  }
}

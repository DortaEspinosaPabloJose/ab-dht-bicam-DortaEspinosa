package config.tspDynamic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** Pruebas de {@link TSPState}. */
class TSPStateTest {

  @Test
  void defaultValuesAreZero() {
    TSPState state = new TSPState();
    assertEquals(0, state.getValue());
    assertEquals(0, state.getIdCity());
  }

  @Test
  void setAndGetValue() {
    TSPState state = new TSPState();
    state.setValue(42);
    assertEquals(42, state.getValue());
  }

  @Test
  void setAndGetIdCity() {
    TSPState state = new TSPState();
    state.setIdCity(7);
    assertEquals(7, state.getIdCity());
  }

  @Test
  void fieldsAreIndependent() {
    TSPState state = new TSPState();
    state.setValue(1);
    state.setIdCity(2);
    assertEquals(1, state.getValue());
    assertEquals(2, state.getIdCity());
  }
}

package local_search.complement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/** Pruebas de {@link StopExecute} y {@link StrategyType}. */
class StopExecuteTest {

  private final StopExecute stop = new StopExecute();

  @Test
  @DisplayName("No se detiene mientras el contador sea menor que el máximo")
  void doesNotStopBeforeMax() {
    assertFalse(stop.stopIterations(0, 10));
    assertFalse(stop.stopIterations(9, 10));
  }

  @Test
  @DisplayName("Se detiene al alcanzar el máximo")
  void stopsAtMax() {
    assertTrue(stop.stopIterations(10, 10));
  }

  @Test
  @DisplayName("Se detiene si el contador supera el máximo")
  void stopsAboveMax() {
    assertTrue(stop.stopIterations(11, 10));
  }

  @ParameterizedTest(name = "stopIterations({0}, {1}) = {2}")
  @CsvSource({"0,0,true", "0,1,false", "5,5,true", "4,5,false", "-1,0,false"})
  void boundaryValues(int current, int max, boolean expected) {
    assertEquals(expected, stop.stopIterations(current, max));
  }

  @Test
  @DisplayName("StrategyType define TABU y NORMAL")
  void strategyTypeValues() {
    assertEquals(2, StrategyType.values().length);
    assertEquals(StrategyType.TABU, StrategyType.valueOf("TABU"));
    assertEquals(StrategyType.NORMAL, StrategyType.valueOf("NORMAL"));
  }
}

package problem.extension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/** Pruebas de {@link MetricasMultiobjetivo} (estadísticos) y {@link TypeSolutionMethod}. */
class MetricasMultiobjetivoTest {

  private static final double DELTA = 1e-9;
  private final MetricasMultiobjetivo metricas = new MetricasMultiobjetivo();

  private static ArrayList<Double> list(Double... values) {
    return new ArrayList<Double>(Arrays.asList(values));
  }

  @Test
  void calcularMinReturnsSmallest() {
    assertEquals(0.5, metricas.CalcularMin(list(3.0, 0.5, 2.0)), DELTA);
  }

  @Test
  void calcularMinOfEmptyListReturnsInitialBound() {
    assertEquals(1000.0, metricas.CalcularMin(new ArrayList<Double>()), DELTA);
  }

  @Test
  void calcularMaxReturnsLargest() {
    assertEquals(9.0, metricas.CalcularMax(list(3.0, 9.0, 2.0)), DELTA);
  }

  @Test
  void calcularMaxOfEmptyListReturnsZero() {
    assertEquals(0.0, metricas.CalcularMax(new ArrayList<Double>()), DELTA);
  }

  @Test
  void calcularMediaReturnsAverage() {
    assertEquals(2.0, metricas.CalcularMedia(list(1.0, 2.0, 3.0)), DELTA);
  }

  @Test
  void calcularMediaOfEmptyListIsNaN() {
    assertEquals(Double.NaN, metricas.CalcularMedia(new ArrayList<Double>()), DELTA);
  }

  @Test
  void typeSolutionMethodValues() {
    assertEquals(2, TypeSolutionMethod.values().length);
    assertEquals(TypeSolutionMethod.FactoresPonderados, TypeSolutionMethod.valueOf("FactoresPonderados"));
    assertEquals(TypeSolutionMethod.MultiObjetivoPuro, TypeSolutionMethod.valueOf("MultiObjetivoPuro"));
  }
}

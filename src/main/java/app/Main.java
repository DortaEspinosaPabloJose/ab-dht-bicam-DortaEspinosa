package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import problem.extension.TypeSolutionMethod;

/** Punto de entrada de BiCIAM para ejecutar la aplicación en un contenedor. */
public final class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private Main() {
        // clase de utilidad: no se instancia
    }

    /**
     * Arranca la aplicación y muestra los métodos de solución disponibles.
     *
     * @param args argumentos de línea de comandos (sin uso por ahora)
     */
    public static void main(String[] args) {
        LOGGER.info("BiCIAM iniciado correctamente");
        for (TypeSolutionMethod method : TypeSolutionMethod.values()) {
            LOGGER.info("Método de solución disponible: {}", method);
        }
    }
}
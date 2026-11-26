package metaheuristics.generators;

import factory_method.FactoryGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class InstanceGA implements Runnable {

	private boolean terminate = false;
	private static final Logger LOGGER = LoggerFactory.getLogger(InstanceGA.class);
	
	public void run() {
		FactoryGenerator ifFactoryGenerator = new FactoryGenerator();
		Generator generatorGA = null;
		try {
			generatorGA = ifFactoryGenerator.createGenerator(GeneratorType.GeneticAlgorithm);
		} catch (Exception e) {
			LOGGER.error("No se pudo crear el generador DistributionEstimationAlgorithm", e);
		}
		boolean find = false;
		int i = 0;
		while (find == false) {
			if(MultiGenerator.getListGenerators()[i].getType().equals(GeneratorType.GeneticAlgorithm)){
				MultiGenerator.getListGenerators()[i] = generatorGA;
				find = true;
			}
			else i++;
		}
		terminate = true;
	}

	public boolean isTerminate() {
		return terminate;
	}

	public void setTerminate(boolean terminate) {
		this.terminate = terminate;
	}

}

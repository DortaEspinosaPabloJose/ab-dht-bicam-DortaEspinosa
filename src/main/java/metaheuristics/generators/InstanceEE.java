package metaheuristics.generators;

import factory_method.FactoryGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstanceEE implements Runnable {

	private boolean terminate = false;
	private static final Logger LOGGER = LoggerFactory.getLogger(InstanceEE.class);
	
	public void run() {
		FactoryGenerator ifFactoryGenerator = new FactoryGenerator();
		Generator generatorEE = null;
		try {
			generatorEE = ifFactoryGenerator.createGenerator(GeneratorType.EvolutionStrategies);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error("No se pudo crear el generador DistributionEstimationAlgorithm", e);
		}
		boolean find = false;
		int i = 0;
		while (find == false) {
			if(MultiGenerator.getListGenerators()[i].getType().equals(GeneratorType.EvolutionStrategies)){
				MultiGenerator.getListGenerators()[i] = generatorEE;
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

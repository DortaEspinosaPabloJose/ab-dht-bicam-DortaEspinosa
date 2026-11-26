package evolutionary_algorithms.complement;


import metaheurictics.strategy.Strategy;
import problem.definition.State;

import java.security.SecureRandom;

public class OnePointMutation extends Mutation {

	private static final SecureRandom RANDOM = new SecureRandom();

	@Override
	public State mutation(State state, double PM) {
		double probM = (double)(RANDOM.nextDouble());
		if(PM >= probM)
		{
			int key = Strategy.getStrategy().getProblem().getCodification().getAleatoryKey();
			Object value = Strategy.getStrategy().getProblem().getCodification().getVariableAleatoryValue(key);
			state.getCode().set(key, value);
		}
		return state;
	}
}

/**
 * @(#) AcceptNoBadT.java
 */

package local_search.acceptation_type;

import java.lang.reflect.InvocationTargetException;
import java.security.SecureRandom;

import metaheurictics.strategy.Strategy;
import metaheuristics.generators.SimulatedAnnealing;
import problem.definition.Problem;
import problem.definition.State;
import problem.definition.Problem.ProblemType;

public class AcceptNotBadT extends AcceptableCandidate{
	private static final SecureRandom RANDOM = new SecureRandom();

	@Override
	public Boolean acceptCandidate(State stateCurrent, State stateCandidate) throws IllegalArgumentException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Boolean accept = null;
		Problem problem = Strategy.getStrategy().getProblem();
		if (problem.getTypeProblem().equals(ProblemType.Maximizar)) {
			double result = (stateCandidate.getEvaluation().get(0) - stateCurrent.getEvaluation().get(0)) / SimulatedAnnealing.tinitial;
			double probaleatory = RANDOM.nextDouble();
			double exp = Math.exp(result);
			if ((stateCandidate.getEvaluation().get(0) >= stateCurrent.getEvaluation().get(0))
					|| (probaleatory < exp))
 				accept = true;
			else
				accept = false;
		} else {
			double result_min = (stateCandidate.getEvaluation().get(0) - stateCurrent.getEvaluation().get(0)) / SimulatedAnnealing.tinitial;
            accept = (stateCandidate.getEvaluation().get(0) <= stateCurrent.getEvaluation().get(0))
                    || (RANDOM.nextInt() < Math.exp(result_min));
		}
		return accept;
	}
}

/**
 * @(#) AleatoryCandidate.java
 */

package local_search.candidate_type;

import java.security.SecureRandom;
import java.util.List;

import problem.definition.State;

public class RandomCandidate extends SearchCandidate {
	private static final SecureRandom RANDOM = new SecureRandom();

	@Override
	public State stateSearch(List<State> listNeighborhood) {
		int pos = (int)(RANDOM.nextInt() * (double)(listNeighborhood.size() - 1));
		State stateAleatory = listNeighborhood.get(pos);
		return stateAleatory;
	}
}

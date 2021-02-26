package AcceptanceNewSolution;

import SimulatedAnnealing.CurrentLoopData;
import SimulatedAnnealing.Solution;

public interface AcceptanceNewSolutionMethod {
    public boolean shouldAcceptNewSolution(Double difference, CurrentLoopData currentLoopData);
}

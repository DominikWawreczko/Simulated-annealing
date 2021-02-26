package AcceptanceNewSolution;

import SimulatedAnnealing.CurrentLoopData;

public interface AcceptanceNewSolutionMethod {
    public boolean shouldAcceptNewSolution(Double difference, CurrentLoopData currentLoopData);
}

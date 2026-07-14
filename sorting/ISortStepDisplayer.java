package sorting;

public interface ISortStepDisplayer {
    // Implementer will show array in its current state, for example in a visualizer;
    public void showStep(Comparable []a, int i, int min);
}

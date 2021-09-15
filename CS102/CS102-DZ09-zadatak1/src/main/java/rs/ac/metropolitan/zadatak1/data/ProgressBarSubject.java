package rs.ac.metropolitan.zadatak1.data;

import java.util.List;

public class ProgressBarSubject extends Subject<Integer[]> {
    public ProgressBarSubject(List<Observer<Integer[]>> observables) {
        super(observables);
    }
}

package rs.ac.metropolitan.zadatak1.data;

import java.util.List;

public abstract class Subject<T> {
    protected List<Observer<T>> observables;

    protected Subject(List<Observer<T>> observables) {
        this.observables = observables;
    }

    public void doNotify(T data){
        observables.forEach(observable -> observable.onNotify(data));
    }
}

package rs.ac.metropolitan.zadatak1.data;
public interface Observer<T> {
    void onNotify(T data);
}
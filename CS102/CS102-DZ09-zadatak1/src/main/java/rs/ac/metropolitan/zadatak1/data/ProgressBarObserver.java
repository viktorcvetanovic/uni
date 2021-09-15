package rs.ac.metropolitan.zadatak1.data;

import javafx.scene.control.ProgressIndicator;

public class ProgressBarObserver implements Observer<Integer[]> {
    public ProgressIndicator indicator;
    public ProgressBarObserver(ProgressIndicator indicator) {
        this.indicator = indicator;
    }

    @Override
    public void onNotify(Integer[] data) {
        int current = data[0];
        int total = data[1];
        double progress = current / (double) total;
        indicator.setProgress(progress);
    }
}

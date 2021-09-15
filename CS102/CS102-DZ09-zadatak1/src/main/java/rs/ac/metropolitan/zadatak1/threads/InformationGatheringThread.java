package rs.ac.metropolitan.zadatak1.threads;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rs.ac.metropolitan.zadatak1.data.ProgressBarSubject;

import java.io.IOException;


@RequiredArgsConstructor
@Data
public class InformationGatheringThread implements Runnable {
    private final ProgressBarSubject observer;
    private final ObservableList<String> list;
    private String url = "https://www.polovniautomobili.com";

    @Override
    public void run() {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("#top-pagination > section > a");
            int total = elements.size();
            int count = 0;
            for (Element e : elements) {
                count++;
                try {
                    Document carDocument = Jsoup.connect(url + e.attr("href")).get();
                    String text = carDocument.select(".h1-classified-title").text();
                    Platform.runLater(()-> list.add(text));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                observer.doNotify(new Integer[]{count, total});
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

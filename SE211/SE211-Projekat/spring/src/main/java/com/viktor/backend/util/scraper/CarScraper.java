package com.viktor.backend.util.scraper;

import com.viktor.backend.entity.Car;
import com.viktor.backend.service.CarService;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CarScraper {
    private static final String URL = "https://www.polovniautomobili.com";
    private final CarService carService;

    public List<Car> scrap() {
        List<Car> list = new ArrayList<>();
        Document document = null;
        try {
            document = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = document.getElementsByClass("home-classified");
        for (Element e : elements.select(".uk-grid > section")) {
            String name = e.select("a > .carThumbHolderBottom > h3").text();
                String[] splited = name.trim().split(" ");
                String brand = splited[0];
                String model = "";
                for (int i = 1; i < splited.length; i++) {
                    model += splited[i];
                    if (i > 1) {
                        model += " ";
                    }
                }
                list.add(new Car(brand, model));
        }
        return list;
    }

    public void writeToDatabase() {
        for (Car car : scrap()) {
            carService.save(car);
        }
    }


}

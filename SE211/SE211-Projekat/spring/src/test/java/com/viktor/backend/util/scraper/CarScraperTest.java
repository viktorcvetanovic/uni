package com.viktor.backend.util.scraper;

import com.viktor.backend.entity.Car;
import com.viktor.backend.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


class CarScraperTest {
    @Autowired
    private CarScraper carScraper;

    @Autowired
    private CarService carService;


    @Test
    void scrap() {
        List<Car> list = carScraper.scrap();
        assert(list.size()>0);
    }

    @Test
    void scrap_with_empty_list() {
        List<Car> list = carScraper.scrap();
        assert(list!=null);
    }

    @Test
    void writeToDatabase() {
        carScraper.writeToDatabase();
    }

    @Test
    void getAllCars() {
        List<Car> list = carService.findAll();
        assert(list.size()>0);
    }


}
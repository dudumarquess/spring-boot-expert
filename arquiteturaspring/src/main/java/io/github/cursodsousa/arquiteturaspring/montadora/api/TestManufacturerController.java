package io.github.cursodsousa.arquiteturaspring.montadora.api;

import io.github.cursodsousa.arquiteturaspring.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class TestManufacturerController {

    @Autowired
    @Qualifier("electricEngine")
    private Engine engine;

    @PostMapping("/start-car")
    public CarStatus startCar(@RequestBody CarKey carKey) {
        var car = new HondaHRV(engine);
        return car.startCar(carKey);
    }
}

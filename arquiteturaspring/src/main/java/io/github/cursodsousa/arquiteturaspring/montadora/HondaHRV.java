package io.github.cursodsousa.arquiteturaspring.montadora;

import java.awt.*;

public class HondaHRV extends Car{
    public HondaHRV(Engine engine) {
        super(engine);
        this.setModel("HR-V");
        this.setManufacturer(Manufacturer.HONDA);
        this.setColor(Color.BLACK);
    }
}

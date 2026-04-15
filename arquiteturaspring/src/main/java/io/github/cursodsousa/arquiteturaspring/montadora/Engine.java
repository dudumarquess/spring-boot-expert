package io.github.cursodsousa.arquiteturaspring.montadora;

public class Engine {
    private String model;
    private Integer horsePower;
    private Integer cylinders;
    private Double liters;
    private EngineType engineType;



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public Integer getCylinders() {
        return cylinders;
    }

    public void setCylinders(Integer cylinders) {
        this.cylinders = cylinders;
    }

    public Double getLiters() {
        return liters;
    }

    public void setLiters(Double liters) {
        this.liters = liters;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "model='" + model + '\'' +
                ", horsePower=" + horsePower +
                ", cylinders=" + cylinders +
                ", liters=" + liters +
                ", engineType=" + engineType +
                '}';
    }
}

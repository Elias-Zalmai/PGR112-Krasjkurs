package Scrapyard;

import java.util.Objects;

public abstract class Vehicles {
    private int id;
    private String brand;
    private String model;
    private int yearModel;
    private String registrationNumber;
    private String chassisNumber;
    private boolean driveable;
    private int numberOfWheels;
    private int scrapyardId;

    public Vehicles(int id, String brand, String model, int yearModel, String registrationNumber, String chassisNumber, boolean driveable, int numberOfWheels, int scrapyardId) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearModel = yearModel;
        this.registrationNumber = registrationNumber;
        this.chassisNumber = chassisNumber;
        this.driveable = driveable;
        this.numberOfWheels = numberOfWheels;
        this.scrapyardId = scrapyardId;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearModel() {
        return yearModel;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public boolean isDriveable() {
        return driveable;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public int getScrapyardId() {
        return scrapyardId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicles vehicles = (Vehicles) o;
        return id == vehicles.id && yearModel == vehicles.yearModel && driveable == vehicles.driveable && numberOfWheels == vehicles.numberOfWheels && scrapyardId == vehicles.scrapyardId && Objects.equals(brand, vehicles.brand) && Objects.equals(model, vehicles.model) && Objects.equals(registrationNumber, vehicles.registrationNumber) && Objects.equals(chassisNumber, vehicles.chassisNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfWheels, scrapyardId);
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearModel=" + yearModel +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", driveable=" + driveable +
                ", numberOfWheels=" + numberOfWheels +
                ", scrapyardId=" + scrapyardId +
                '}';
    }
}

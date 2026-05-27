package Scrapyard;

import java.util.Objects;

public class FossilCar extends Vehicles {

    private String fuelType;
    private int fuelAmount;

    public FossilCar(int id, String brand, String model, int yearModel, String registrationNumber, String chassisNumber, boolean driveable, int numberOfWheels, int scrapyardId, String fuelType, int fuelAmount) {
        super(id, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfWheels, scrapyardId);
        this.fuelType = fuelType;
        this.fuelAmount = fuelAmount;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getFuelAmount() {
        return fuelAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FossilCar fossilCar = (FossilCar) o;
        return fuelAmount == fossilCar.fuelAmount && Objects.equals(fuelType, fossilCar.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fuelType, fuelAmount);
    }

    @Override
    public String toString() {
        return "FossilCar{" +
                "fuelType='" + fuelType + '\'' +
                ", fuelAmount=" + fuelAmount +
                "} " + super.toString();
    }
}

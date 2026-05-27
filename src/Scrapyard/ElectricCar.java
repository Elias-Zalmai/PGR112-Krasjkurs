package Scrapyard;

import java.util.Objects;

public class ElectricCar extends Vehicles{
    private int batteryCapacity;
    private int numberOfBatteries;

    public ElectricCar(int id, String brand, String model, int yearModel, String registrationNumber, String chassisNumber, boolean driveable, int numberOfWheels, int scrapyardId, int batteryCapacity, int numberOfBatteries) {
        super(id, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfWheels, scrapyardId);
        this.batteryCapacity = batteryCapacity;
        this.numberOfBatteries = numberOfBatteries;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getNumberOfBatteries() {
        return numberOfBatteries;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ElectricCar that = (ElectricCar) o;
        return batteryCapacity == that.batteryCapacity && numberOfBatteries == that.numberOfBatteries;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), batteryCapacity, numberOfBatteries);
    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                "batteryCapacity=" + batteryCapacity +
                ", numberOfBatteries=" + numberOfBatteries +
                "} " + super.toString();
    }
}

package Scrapyard;

import java.util.Objects;

public class Motercycle extends Vehicles {
    private boolean hasSidecar;
    private int engineCapacity;
    private boolean isModified;
    private int numberOfWheels;

    public Motercycle(int id, String brand, String model, int yearModel, String registrationNumber, String chassisNumber, boolean driveable, int numberOfWheels, int scrapyardId, boolean hasSidecar, int engineCapacity, boolean isModified, int numberOfWheels1) {
        super(id, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfWheels, scrapyardId);
        this.hasSidecar = hasSidecar;
        this.engineCapacity = engineCapacity;
        this.isModified = isModified;
        this.numberOfWheels = numberOfWheels1;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public boolean isModified() {
        return isModified;
    }

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Motercycle that = (Motercycle) o;
        return hasSidecar == that.hasSidecar && engineCapacity == that.engineCapacity && isModified == that.isModified && numberOfWheels == that.numberOfWheels;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasSidecar, engineCapacity, isModified, numberOfWheels);
    }


    @Override
    public String toString() {
        return "Motercycle{" +
                "hasSidecar=" + hasSidecar +
                ", engineCapacity=" + engineCapacity +
                ", isModified=" + isModified +
                ", numberOfWheels=" + numberOfWheels +
                "} " + super.toString();
    }
}

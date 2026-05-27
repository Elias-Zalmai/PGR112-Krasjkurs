package Services;

import Scrapyard.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private ArrayList<Scrapyard> scrapyardList = new ArrayList<>();
    private ArrayList<ElectricCar> electricCarList = new ArrayList<>();
    private ArrayList<FossilCar> fossilCarList = new ArrayList<>();
    private ArrayList<Motercycle> motorCycleList = new ArrayList<>();


    public void readFile() throws FileNotFoundException {
        File file = new File("src/Files/vehicles.txt");
        try (Scanner scanner = new Scanner(file);) {
            int scapyardCounter = Integer.parseInt(scanner.nextLine());
            while (scanner.hasNextLine()) {
                for (int i = 0; i < scapyardCounter; i++) {
                    int id = Integer.parseInt(scanner.nextLine());
                    String name = scanner.nextLine();
                    String address = scanner.nextLine();
                    String phoneNumber = scanner.nextLine();
                    scanner.nextLine();
                    Scrapyard scrapyard = new Scrapyard(id, name, address, phoneNumber);
                    scrapyardList.add(scrapyard);
                }
                //Scapyard added
                int vehicleCounter = Integer.parseInt(scanner.nextLine());
                while (scanner.hasNextLine()) {
                    for (int i = 0; i < vehicleCounter; i++) {
                        int id = Integer.parseInt(scanner.nextLine());
                        int scrapyardId = Integer.parseInt(scanner.nextLine());
                        String vehicleType = scanner.nextLine();
                        String brand = scanner.nextLine();
                        String model = scanner.nextLine();
                        int yearModel = Integer.parseInt(scanner.nextLine());
                        String registrationNumber = scanner.nextLine();
                        String chassisNumber = scanner.nextLine();
                        boolean driveable = Boolean.parseBoolean(scanner.nextLine());
                        int numberOfWheels = Integer.parseInt(scanner.nextLine());
                        switch (vehicleType) {
                            //nå velger vi hvilken av de det blir


                            case "FossilCar" -> {
                                String fuelType = scanner.nextLine();
                                int fuelAmount = Integer.parseInt(scanner.nextLine());
                                FossilCar fossilCar = new FossilCar(id, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfWheels, scrapyardId, fuelType, fuelAmount);
                                fossilCarList.add(fossilCar);
                            }
                            case "ElectricCar" -> {
                                int batteryCapacity = Integer.parseInt(scanner.nextLine());
                                int numberOfBatteries = Integer.parseInt(scanner.nextLine());
                                ElectricCar electricCar = new ElectricCar(id, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfWheels, scrapyardId, batteryCapacity, numberOfBatteries);
                                electricCarList.add(electricCar);
                            }
                            case "Motorcycle" -> {
                                boolean hasSidecar = Boolean.parseBoolean(scanner.nextLine());
                                int engineCapacity = Integer.parseInt(scanner.nextLine());
                                boolean isModified = Boolean.parseBoolean(scanner.nextLine());
                                int numberOfWheels1 = Integer.parseInt(scanner.nextLine());
                                Motercycle motorCycle = new Motercycle(id, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfWheels1, scrapyardId, hasSidecar, engineCapacity, isModified, numberOfWheels1);
                                motorCycleList.add(motorCycle);
                            }
                            default -> System.out.println("Invalid vehicle type");
                        }
                        scanner.nextLine();
                    }
                }
            }
            System.out.println("File read successfully");
        }
        electricCarList.forEach(System.out::println);
        fossilCarList.forEach(System.out::println);
        motorCycleList.forEach(System.out::println);
        scrapyardList.forEach(System.out::println);
    }
    public ArrayList<Scrapyard> getScrapyardList() {
        return scrapyardList;
    }

    public ArrayList<ElectricCar> getElectricCarList() {
        return electricCarList;
    }

    public ArrayList<FossilCar> getFossilCarList() {
        return fossilCarList;
    }

    public ArrayList<Motercycle> getMotorCycleList() {
        return motorCycleList;
    }
}

package Services;

import Scrapyard.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    DbProvider dbProvider = new DbProvider();


    public void run() throws SQLException {
        System.out.println("Velkommen til programmet");
        int choice = 0;
        while (choice != 4) {
            Scanner Userinput = new Scanner(System.in);
            presentMenuOptions();
            choice = Userinput.nextInt();
            switch (choice) {
                case 1 -> SeeAllVehicles();
                case 2 -> SeeTotalFuel();
                case 3 -> SeeDriveableVehicles();
                case 4 -> Quit();
                default -> System.out.println("Feil, velg tall mellom 1-4");
            }
        }
    }

    private void SeeAllVehicles() throws SQLException {
        System.out.println("Her er informasjon om alle kjøretøy:");
        List<Vehicles>allVehicles = new ArrayList<>();
        allVehicles.addAll(dbProvider.printFossilCar());
        allVehicles.addAll(dbProvider.printElectricCar());
        allVehicles.addAll(dbProvider.printMotercycle());
        System.out.println("--------------------");
        for (int i = 0; i < allVehicles.size(); i++) {
            System.out.println((i + 1) + ". " + allVehicles.get(i));
        }
        System.out.println("--------------------");
        System.out.println(allVehicles.size());
        System.out.println("--------------------");


    }

    private void SeeTotalFuel() throws SQLException {
        int fuelAmount = dbProvider.getFuelAmount();
        System.out.println("----------------------");
        System.out.printf("Alle fossilbilene har totalt sett %d liter med drivstoff \n", fuelAmount);
        System.out.println("----------------------");
    }

    private void SeeDriveableVehicles() throws SQLException {
        System.out.println("Her er informasjon om alle kjørbare kjøretøy:");
        System.out.println("---------------------");
        List <Vehicles>driveableVehicles = new ArrayList<>();
        driveableVehicles.addAll(dbProvider.printDrivableFossilCar());
        driveableVehicles.addAll(dbProvider.printDrivableElectricCar());
        driveableVehicles.addAll(dbProvider.printDrivableMotorcycles());
        driveableVehicles.forEach(System.out::println);
        System.out.println("-------------------");
    }


    private void Quit() {
        System.out.println("Takk for meg, håper du liker programmet!");
    }


    private static void presentMenuOptions() {
        System.out.println("Velg en av 4 valg:");
        System.out.println("1. Se informasjon om alle kjøretøy. ");
        System.out.println("2. Se informasjon om hvor mye drivstoff som befinner seg i fossilbilene totalt: ");
        System.out.println("3. Se informasjon om alle kjøretøy som er kjørbare:");
        System.out.println("5. Avslutt program");

    }
}

import Services.*;
import Services.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {


        FileHandler fileHandler = new FileHandler();
        try {
            fileHandler.readFile();
            System.out.println("---------------------");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            new DbImporter().importData(fileHandler);
        } catch (
                SQLException e) {
            System.out.println("failed to write to database: " + e.getMessage());
            e.printStackTrace();
        }
        try{
            new Program().run();
        } catch (SQLException e) {
            System.out.println("error while running program: " + e.getMessage());
            e.printStackTrace();
        }

    }
}

package Services;

import java.sql.Connection;
import java.sql.SQLException;

public class DbImporter {

    private final DbProvider dbProvider = new DbProvider();

    public void importData(FileHandler fileReader) throws SQLException {
       try(Connection con = dbProvider.getExamDS().getConnection()){
           boolean autoCommit = con.getAutoCommit();
           con.setAutoCommit(false);
           try{
               dbProvider.insertScrapyard(fileReader.getScrapyardList(), con);
               dbProvider.insertFossilCar(fileReader.getFossilCarList(), con);
               dbProvider.insertElectricCar(fileReader.getElectricCarList(), con);
               dbProvider.insertMotorcycle(fileReader.getMotorCycleList(), con);
               con.commit();
           } catch (SQLException e) {
               con.rollback();
               System.out.println("Rolling back changes: " + e.getMessage());
           } finally {
               con.setAutoCommit(autoCommit);
               System.out.println("-----------");
               System.out.println("Import complete");

           }
       }
    }
}

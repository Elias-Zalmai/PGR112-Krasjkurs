package Services;

import Scrapyard.*;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;

public class DbProvider {


    private static final String ADD_SCAPYARD_SQL = "INSERT INTO scrapyard (scrapyardID, name, address, phoneNumber) VALUES (?, ?, ?, ?)";
    private static final String ADD_ELECTRIC_SQL = "INSERT INTO electricCar (vehicleId, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, scrapyardID, batteryCapacity, chargeLevel) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ADD_FOSSIL_SQL = "INSERT INTO fossilCar (vehicleId, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, scrapyardID, fuelType, fuelAmount ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ADD_MOTORCYCLE_SQL = "INSERT INTO motorcycle (vehicleId, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, scrapyardID, hasSidecar, engineCapacity, isModified, numberOfWheels ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String GET_ELECTRIC_SQL = "SELECT * FROM electricCar";
    private static final String GET_FOSSIL_SQL = "SELECT * FROM fossilCar";
    private static final String GET_MOTORCYCLE_SQL = "SELECT * FROM motorcycle";
    private static final String GET_TOTAL_FUELAMOUT = "SELECT SUM(fuelAmount) AS fuelAmount FROM fossilCar;";


    public static final String GET_DRIVEABLE_ELECTRIC_CAR_SQL ="select VehicleID,Brand,Model,YearModel,RegistrationNumber,ChassisNumber,Driveable,NumberOfSellableWheels,ScrapyardID,BatteryCapacity,ChargeLevel from ElectricCar where Driveable=1;";
    public static final String GET_DRIVEABLE_FOSSIL_CAR_SQL="select VehicleID,Brand,Model,YearModel,RegistrationNumber,ChassisNumber,Driveable,NumberOfSellableWheels,ScrapyardID,FuelType,FuelAmount from FossilCar where Driveable=1;";
    public static final String GET_DRIVEABLE_MOTORCYCLE_SQL ="select VehicleID,Brand,Model,YearModel,RegistrationNumber,ChassisNumber,Driveable,NumberOfSellableWheels,ScrapyardID,HasSidecar,EngineCapacity,IsModified,NumberOfWheels from Motorcycle where Driveable=1";

    private MysqlDataSource examDS;

    public MysqlDataSource getExamDS() {
        return examDS;
    }

    public DbProvider() {
        examDS = new MysqlDataSource();
        examDS.setServerName(PropertiesProvider.PROPS.getProperty("host"));
        examDS.setPortNumber(Integer.parseInt(PropertiesProvider.PROPS.getProperty("port")));
        examDS.setDatabaseName(PropertiesProvider.PROPS.getProperty("db_name"));
        examDS.setUser(PropertiesProvider.PROPS.getProperty("uname"));
        examDS.setPassword(PropertiesProvider.PROPS.getProperty("pwd"));
    }

    public void insertScrapyard(ArrayList<Scrapyard> scrapyardList, Connection con) throws SQLException {
        try (PreparedStatement statement = con.prepareStatement(ADD_SCAPYARD_SQL)){
            for (Scrapyard x : scrapyardList) {
                statement.setInt(1, x.getId());
                statement.setString(2, x.getName());
                statement.setString(3, x.getAddress());
                statement.setString(4, x.getPhoneNumber());
                statement.executeUpdate();
            }
        }
    }

    public void insertFossilCar(ArrayList<FossilCar> fossilCarList, Connection con) throws SQLException {
        for (FossilCar x : fossilCarList) {
            try (PreparedStatement statement = con.prepareStatement(ADD_FOSSIL_SQL)){
                statement.setInt(1, x.getId());
                statement.setString(2, x.getBrand());
                statement.setString(3, x.getModel());
                statement.setInt(4, x.getYearModel());
                statement.setString(5, x.getRegistrationNumber());
                statement.setString(6, x.getChassisNumber());
                statement.setBoolean(7, x.isDriveable());
                statement.setInt(8, x.getNumberOfWheels());
                statement.setInt(9, x.getScrapyardId());
                statement.setString(10, x.getFuelType());
                statement.setInt(11, x.getFuelAmount());
                statement.executeUpdate();
            }
        }
    }

    public void insertElectricCar(ArrayList<ElectricCar> electricCarList, Connection con) throws SQLException {
        for (ElectricCar x : electricCarList) {
            try (PreparedStatement statement = con.prepareStatement(ADD_ELECTRIC_SQL)){
                statement.setInt(1, x.getId());
                statement.setString(2, x.getBrand());
                statement.setString(3, x.getModel());
                statement.setInt(4, x.getYearModel());
                statement.setString(5, x.getRegistrationNumber());
                statement.setString(6, x.getChassisNumber());
                statement.setBoolean(7, x.isDriveable());
                statement.setInt(8, x.getNumberOfWheels());
                statement.setInt(9, x.getScrapyardId());
                statement.setInt(10, x.getBatteryCapacity());
                statement.setInt(11, x.getNumberOfBatteries());
                statement.executeUpdate();
            }
        }
    }

    public void insertMotorcycle(ArrayList<Motercycle> motercycleList, Connection con) throws SQLException {
        for (Motercycle x : motercycleList) {
            try (PreparedStatement statement = con.prepareStatement(ADD_MOTORCYCLE_SQL)){
                statement.setInt(1, x.getId());
                statement.setString(2, x.getBrand());
                statement.setString(3, x.getModel());
                statement.setInt(4, x.getYearModel());
                statement.setString(5, x.getRegistrationNumber());
                statement.setString(6, x.getChassisNumber());
                statement.setBoolean(7, x.isDriveable());
                statement.setInt(8, x.getNumberOfWheels());
                statement.setInt(9, x.getScrapyardId());
                statement.setBoolean(10, x.isHasSidecar());
                statement.setInt(11, x.getEngineCapacity());
                statement.setBoolean(12, x.isModified());
                statement.setInt(13, x.getNumberOfWheels());
                statement.executeUpdate();
            }
        }
    }


    private ArrayList<ElectricCar> getElectricCar(String ElectricCarSQL) throws SQLException {
        ArrayList<ElectricCar> electricCarList = new ArrayList<>();
        try (Connection conn = examDS.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(ElectricCarSQL);
        ){
            while (rs.next()) {
                int id = rs.getInt("VehicleID");
                String brand = rs.getString("Brand");
                String model = rs.getString("Model");
                int yearModel = rs.getInt("YearModel");
                String registrationNumber = rs.getString("RegistrationNumber");
                String chassisNumber = rs.getString("ChassisNumber");
                boolean driveable = rs.getBoolean("Driveable");
                int numberOfWheels = rs.getInt("NumberOfSellableWheels");
                int scrapyardId = rs.getInt("ScrapyardID");
                int batteryCapacity = rs.getInt("BatteryCapacity");
                int numberOfBatteries = rs.getInt("ChargeLevel");
                ElectricCar electricCar = new ElectricCar(id, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfWheels, scrapyardId, batteryCapacity, numberOfBatteries);
                electricCarList.add(electricCar);
            }
            return electricCarList;
        }
    }
   public ArrayList<ElectricCar> printElectricCar() throws SQLException {
        return getElectricCar(GET_ELECTRIC_SQL);
   }

    public ArrayList<ElectricCar> printDrivableElectricCar() throws SQLException {
        return getElectricCar(GET_DRIVEABLE_ELECTRIC_CAR_SQL);
    }

    private ArrayList<FossilCar> getFossilCar(String FossilCarSQL) throws SQLException {
        ArrayList<FossilCar> fossilCarList = new ArrayList<>();
        try (Connection conn = examDS.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(FossilCarSQL);
        ){
            while (rs.next()) {
                int id = rs.getInt("VehicleID");
                String brand = rs.getString("Brand");
                String model = rs.getString("Model");
                int yearModel = rs.getInt("YearModel");
                String registrationNumber = rs.getString("RegistrationNumber");
                String chassisNumber = rs.getString("ChassisNumber");
                boolean driveable = rs.getBoolean("Driveable");
                int numberOfWheels = rs.getInt("NumberOfSellableWheels");
                int scrapyardId = rs.getInt("ScrapyardID");
                String fuelType = rs.getString("FuelType");
                int fuelAmount = rs.getInt("FuelAmount");
                FossilCar fossilCar = new FossilCar(id, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfWheels, scrapyardId, fuelType, fuelAmount);
                fossilCarList.add(fossilCar);
            }
            return fossilCarList;
        }
    }
    public ArrayList<FossilCar> printFossilCar() throws SQLException {
        return getFossilCar(GET_FOSSIL_SQL);
    }

    public ArrayList<FossilCar> printDrivableFossilCar() throws SQLException {
        return getFossilCar(GET_DRIVEABLE_FOSSIL_CAR_SQL);
    }


    private ArrayList<Motercycle> getMotercycle(String MotercycleSQL) throws SQLException {
        ArrayList<Motercycle> motercycleList = new ArrayList<>();
        try (Connection conn = examDS.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(MotercycleSQL);
        ){
            while (rs.next()) {
                int id = rs.getInt("VehicleID");
                String brand = rs.getString("Brand");
                String model = rs.getString("Model");
                int yearModel = rs.getInt("YearModel");
                String registrationNumber = rs.getString("RegistrationNumber");
                String chassisNumber = rs.getString("ChassisNumber");
                boolean driveable = rs.getBoolean("Driveable");
                int numberOfWheels = rs.getInt("NumberOfSellableWheels");
                int scrapyardId = rs.getInt("ScrapyardID");
                boolean hasSidecar = rs.getBoolean("HasSidecar");
                int engineCapacity = rs.getInt("EngineCapacity");
                boolean isModified = rs.getBoolean("IsModified");
                int numberOfWheels1 = rs.getInt("NumberOfWheels");
                Motercycle motercycle = new Motercycle(id, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfWheels, scrapyardId, hasSidecar, engineCapacity, isModified, numberOfWheels1);
                motercycleList.add(motercycle);
            }
            return motercycleList;
        }
    }

    public ArrayList<Motercycle> printMotercycle() throws SQLException {
        return getMotercycle(GET_MOTORCYCLE_SQL);
    }

    public ArrayList<Motercycle> printDrivableMotorcycles() throws SQLException {
        return getMotercycle(GET_DRIVEABLE_MOTORCYCLE_SQL);
    }


    public int getFuelAmount() throws SQLException {
        int fuelAmount = 0;
        try (Connection conn = examDS.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(GET_TOTAL_FUELAMOUT)
        ) {
            while (rs.next()) {
                fuelAmount = rs.getInt("fuelAmount");
            }
            return fuelAmount;
        }
    }


}


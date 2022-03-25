package peaksoft.Tables;

import peaksoft.config.JDBCConfig;
import peaksoft.models.Mayor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableMayor {

    public static void createTableMayor() {
        String createSQL = "create table if not exists Mayors (" +
                "mayor_id serial primary key," +
                "mayor_name text," +
                "mayor_age int," +
                "cityId int references Cities(city_id));";
        System.out.println("Create table Mayors successfully");
        try (Connection connection = JDBCConfig.JDBCConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(createSQL);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveMayors(String mayor_surname, int mayor_age, int cityId) {
        String saveSQL = "insert into Mayors(mayor_surname, mayor_age, cityId) values(?, ?, ?);";
        try (Connection connection = JDBCConfig.JDBCConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(saveSQL);
            preparedStatement.setString(1, mayor_surname);
            preparedStatement.setInt(2, mayor_age);
            preparedStatement.setInt(3, cityId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Added in table Mayors success: " + mayor_surname);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Mayor> getAllMayors() {
        String getAllSQL = "select city_id, city_name, mayor_id, " +
                "       mayor_surname, mayor_age, cityid " +
                "from mayors inner join cities c on c.city_id = mayors.cityid;";
        List<Mayor> mayorList = new ArrayList<>();
        try (Connection connection = JDBCConfig.JDBCConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllSQL);
            System.out.println("Table mayor in ArrayList: \n");
            while (resultSet.next()) {
                Mayor mayor = new Mayor();
                mayor.setMayor_id(resultSet.getLong("mayor_id"));
                mayor.setMayor_name(resultSet.getString("mayor_surname"));
                mayor.setMayor_age(resultSet.getInt("mayor_age"));
                mayor.setCityId(resultSet.getInt("cityId"));
                mayorList.add(mayor);
                System.out.println(mayor);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mayorList;
    }
}

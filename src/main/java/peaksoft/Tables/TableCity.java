package peaksoft.Tables;

import peaksoft.config.JDBCConfig;
import peaksoft.models.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableCity {

    public static void createTable() {
        String createSQL = "create table if not exists Cities(" +
                        "city_id serial primary key, " +
                        "city_name text, " +
                        "mayor_name text);";
//                        "mayorId int references Mayors(id));";
              System.out.println("Create table Cities successfully");
        try (Connection connection = JDBCConfig.JDBCConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(createSQL);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//    public static void alterTableCities() {
//        String alterSQL = "alter table Cities add mayorId int references Mayors(mayor_id);";
//        try (Connection connection = JDBCConnection()) {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(alterSQL);
//            statement.close();
//            System.out.println("Successfully added in Cities mayorId");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static void deleteId() {
//        String deleteSQL = "delete from Cities where mayorId = mayorId";
//        try (Connection connection = JDBCConnection()) {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(deleteSQL);
//            statement.close();
//            System.out.println("Successfully delete mayorId");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public static void saveCities(String city_name, String mayor_name) {
        String saveSQL = "insert into Cities(city_name, mayor_name) values(?, ?);";
        try (Connection connection = JDBCConfig.JDBCConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(saveSQL);
            preparedStatement.setString(1, city_name);
            preparedStatement.setString(2, mayor_name);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Added in table Cities success: " + city_name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     }

     public static List<City> getAllCities() {
        String getAllSQL = "select city_id, city_name, mayor_surname, mayor_id, " +
                "       mayor_age, cityid " +
                "from cities inner join mayors c on cities.city_id = c.cityid;";
        List<City> cityList = new ArrayList<>();
        try (Connection connection = JDBCConfig.JDBCConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllSQL)) {
            System.out.println("Table in ArrayList");
            while (resultSet.next()) {
                City city = new City();
                city.setCity_id(resultSet.getLong("city_id"));
                city.setCity_name(resultSet.getString("city_name"));
                city.setMayor_name(resultSet.getString("mayor_surname"));
//                city.setNameCountry(resultSet.getString("name_country"));
                cityList.add(city);
                System.out.println(city);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cityList;
     }
}

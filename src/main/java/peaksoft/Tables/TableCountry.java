package peaksoft.Tables;

import peaksoft.config.JDBCConfig;
import peaksoft.models.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableCountry {

    public static void createTableCountry() {
        String createSQL = "create table if not exists Countries(" +
                "country_id serial primary key," +
                "country_name text, " +
                "population int," +
                "cityId int references Cities(city_id));";
        try (Connection connection = JDBCConfig.JDBCConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(createSQL);
            statement.close();
            System.out.println("Create table Country successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveCountries(String name_country, double population, int cityId){
            String saveSQL = "insert into Countries(country_name, population, cityId) values (?, ?, ?);";
            try (Connection connection = JDBCConfig.JDBCConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(saveSQL);
                preparedStatement.setString(1, name_country);
                preparedStatement.setDouble(2, population);
                preparedStatement.setInt(3, cityId);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                System.out.println("Added in table Country success: " + name_country);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    }

    public static List<Country> getAllCountries() {
        String getAllSQL = "select country_id, country_name, population, cityId, city_name from cities " +
                "inner join countries on cities.city_id = cityid;";
        List<Country> countryList = new ArrayList<>();
        try (Connection connection = JDBCConfig.JDBCConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllSQL);
            System.out.println("Table country in ArrayLIst: \n");
            while (resultSet.next()) {
                Country country = new Country();
                country.setCountry_id(resultSet.getLong("country_id"));
                country.setCountry_name(resultSet.getString("country_name"));
                country.setPopulation(resultSet.getInt("population"));
                country.setCityId(resultSet.getInt("cityId"));
                countryList.add(country);
                System.out.println(country);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return countryList;
    }
}

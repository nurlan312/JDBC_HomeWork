package peaksoft;

import peaksoft.Tables.TableCity;
import peaksoft.Tables.TableCountry;
import peaksoft.Tables.TableMayor;
import peaksoft.config.JDBCConfig;

public class App {
    public static void main( String[] args ) {

        JDBCConfig.JDBCConnection();
        TableCity.createTable();
//        TableCity.alterTableCities();
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        TableCountry.createTableCountry();
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        TableMayor.createTableMayor();
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-* City class *-*-*-*-*-*-*-*-*-*-*-*-");
        TableCity.saveCities("Moscow", "Bahtyiar Surantaev");
        TableCity.saveCities("Bishkek", "Ulukmyrza Talipov");
        TableCity.saveCities("Washington", "Mirbek Abylov");
        TableCity.saveCities("London", "Shergazy Kalmyrza uulu");
        TableCity.saveCities("Brasilia", "Bekmurat Satyboldiev");

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-* Country class *-*-*-*-*-*-*-*-*-*-*-");
        TableCountry.saveCountries("Russia", 14515295, 1);
        TableCountry.saveCountries("Kyrgyzstan", 6200000, 2);
        TableCountry.saveCountries("USA", 64515215, 3);
        TableCountry.saveCountries("England", 6451521, 4);
        TableCountry.saveCountries("Brazil", 1451521, 5);

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-* Mayor class *-*-*-*-*-*-*-*-*-*-*-*-*");
        TableMayor.saveMayors("Bahtyiar Surantaev", 35, 1);
        TableMayor.saveMayors("Ulukmyrza Talipov", 29, 2);
        TableMayor.saveMayors("Mirbek Abylov", 36, 3);
        TableMayor.saveMayors("Shergazy Kalmyrza uulu", 23, 4);
        TableMayor.saveMayors("Bekmurat Satyboldiev", 23, 5);

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        TableCity.getAllCities();

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        TableMayor.getAllMayors();

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        TableCountry.getAllCountries();
    }
}

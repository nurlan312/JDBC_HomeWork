package peaksoft.models;

public class Country {

    private Long country_id;
    private String country_name;
    private double population;
    private int cityId;

    public Country(Long country_id, String country_name, double population, int cityId) {
        this.country_id = country_id;
        this.country_name = country_name;
        this.population = population;
        this.cityId = cityId;
    }

    public Country(String country_name, double population, int cityId) {
        this.country_name = country_name;
        this.population = population;
        this.cityId = cityId;
    }

    public Country() {
    }

    public Long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Long country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country_id=" + country_id +
                ", country_name='" + country_name + '\'' +
                ", population=" + population +
                ", cityId=" + cityId +
                '}';
    }
}

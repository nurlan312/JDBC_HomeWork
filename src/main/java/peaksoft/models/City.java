package peaksoft.models;

public class City {

    private Long city_id;
    private String city_name;
    private String mayor_name;

    public City(String city_name, String mayor_name) {
        this.city_name = city_name;
        this.mayor_name = mayor_name;
    }

    public City() {
    }

    public Long getCity_id() {
        return city_id;
    }

    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getMayor_name() {
        return mayor_name;
    }

    public void setMayor_name(String mayor_name) {
        this.mayor_name = mayor_name;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                ", mayor_name='" + mayor_name + '\'' +
                '}';
    }
}

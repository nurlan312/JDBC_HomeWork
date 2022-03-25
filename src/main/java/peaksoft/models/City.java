package peaksoft.models;

public class City {

    private Long city_id;
    private String city_name;
    private int mayorId;

    public City(String city_name, int mayorId) {
        this.city_name = city_name;
        this.mayorId = mayorId;
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

    public int getMayorId() {
        return mayorId;
    }

    public void setMayorId(int mayorId) {
        this.mayorId = mayorId;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                ", mayorId=" + mayorId +
                '}';
    }
}

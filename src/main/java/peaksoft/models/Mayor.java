package peaksoft.models;

public class Mayor {

    private Long mayor_id;
    private String mayor_name;
    private int mayor_age;
    private int cityId;

    public Mayor(Long mayor_id, String mayor_name, int mayor_age, int cityId) {
        this.mayor_id = mayor_id;
        this.mayor_name = mayor_name;
        this.mayor_age = mayor_age;
        this.cityId = cityId;
    }

    public Mayor(String mayor_name, int mayor_age, int cityId) {
        this.mayor_name = mayor_name;
        this.mayor_age = mayor_age;
        this.cityId = cityId;
    }

    public Mayor() {
    }

    public Long getMayor_id() {
        return mayor_id;
    }

    public void setMayor_id(Long mayor_id) {
        this.mayor_id = mayor_id;
    }

    public String getMayor_name() {
        return mayor_name;
    }

    public void setMayor_name(String mayor_name) {
        this.mayor_name = mayor_name;
    }

    public int getMayor_age() {
        return mayor_age;
    }

    public void setMayor_age(int mayor_age) {
        this.mayor_age = mayor_age;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Mayor{" +
                "mayor_id=" + mayor_id +
                ", mayor_name='" + mayor_name + '\'' +
                ", mayor_age=" + mayor_age +
                ", cityId=" + cityId +
                '}';
    }
}

package br.com.carv.registrations.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    @Column(nullable = false, length = 100)
    private String cityName;

    @ManyToOne
    @JoinColumn(nullable = false)
    private State state;

    public City() {

    }

    public City(Long cityId, String cityName, State state) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.state = state;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Id: " + getCityId() + " City Name: " + getCityName() + " State: " + state.getStateName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(cityId, city.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId);
    }
}

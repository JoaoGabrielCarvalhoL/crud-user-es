package br.com.carv.registrations.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userId;

    @Column(nullable = false, name = "fullname")
    private String fullName;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, length = 15, name = "cellphone")
    private String cellphone;

    @Column(name = "college")
    private String college;

    @Column(name = "profession")
    private String profession;

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "haircolor")
    private String hairColor;

    @Column(name = "street")
    private String street;

    @Column(name = "district")
    private String district;

    @Column(name = "numberhouse")
    private String numberHouse;

    @Column(name = "city")
    private String city;

    public User() {

    }

    public User(Long userId, String fullName, String email, String cellphone) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.cellphone = cellphone;
    }

    public User(Long userId, String fullName, String email, String cellphone, String college, String profession, Double height, Double weight, String hairColor, String street, String district, String numberHouse, String city) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.cellphone = cellphone;
        this.college = college;
        this.profession = profession;
        this.height = height;
        this.weight = weight;
        this.hairColor = hairColor;
        this.street = street;
        this.district = district;
        this.numberHouse = numberHouse;
        this.city = city;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(String numberHouse) {
        this.numberHouse = numberHouse;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }


}

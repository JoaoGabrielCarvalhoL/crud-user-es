package br.com.carv.registrations.model;

import javax.persistence.*;
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

    private User(UsBuilder usBuilder) {
        this.fullName = usBuilder.fullName;
        this.email = usBuilder.email;
        this.cellphone = usBuilder.cellphone;
        this.college = usBuilder.college;
        this.profession = usBuilder.profession;
        this.height = usBuilder.height;
        this.weight = usBuilder.weight;
        this.hairColor = usBuilder.hairColor;
        this.street = usBuilder.street;
        this.district = usBuilder.district;
        this.numberHouse = usBuilder.numberHouse;
        this.city = usBuilder.city;

    }

    public static UsBuilder builder() {
        return new UsBuilder();
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

    public static class UsBuilder {
        private Long userId;
        private String fullName;
        private String email;
        private String cellphone;
        private String college;
        private String profession;
        private Double height;
        private Double weight;
        private String hairColor;
        private String street;
        private String district;
        private String numberHouse;
        private String city;

        public UsBuilder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public UsBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public UsBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UsBuilder setCellphone(String cellphone) {
            this.cellphone = cellphone;
            return this;
        }

        public UsBuilder setCollege(String college) {
            this.college = college;
            return this;
        }

        public UsBuilder setProfession(String profession) {
            this.profession = profession;
            return this;
        }

        public UsBuilder setHeight(Double height) {
            this.height = height;
            return this;
        }

        public UsBuilder setWeight(Double weight) {
            this.weight = weight;
            return this;
        }

        public UsBuilder setHairColor(String hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public UsBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        public UsBuilder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public UsBuilder setNumberHouse(String numberHouse) {
            this.numberHouse = numberHouse;
            return this;
        }

        public UsBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public User createUser() {
            return new User(userId, fullName, email, cellphone);
        }

        @Override
        public String toString() {
            return "UserBuilder{" +
                    "userId=" + userId +
                    ", fullName='" + fullName + '\'' +
                    ", email='" + email + '\'' +
                    ", cellphone='" + cellphone + '\'' +
                    ", college='" + college + '\'' +
                    ", profession='" + profession + '\'' +
                    ", height=" + height +
                    ", weight=" + weight +
                    ", hairColor='" + hairColor + '\'' +
                    ", street='" + street + '\'' +
                    ", district='" + district + '\'' +
                    ", numberHouse='" + numberHouse + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }

    }

}


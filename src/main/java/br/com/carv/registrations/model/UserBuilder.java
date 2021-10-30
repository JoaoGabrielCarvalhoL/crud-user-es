package br.com.carv.registrations.model;

public class UserBuilder {
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

    public UserBuilder setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public UserBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setCellphone(String cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    public UserBuilder setCollege(String college) {
        this.college = college;
        return this;
    }

    public UserBuilder setProfession(String profession) {
        this.profession = profession;
        return this;
    }

    public UserBuilder setHeight(Double height) {
        this.height = height;
        return this;
    }

    public UserBuilder setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public UserBuilder setHairColor(String hairColor) {
        this.hairColor = hairColor;
        return this;
    }

    public UserBuilder setStreet(String street) {
        this.street = street;
        return this;
    }

    public UserBuilder setDistrict(String district) {
        this.district = district;
        return this;
    }

    public UserBuilder setNumberHouse(String numberHouse) {
        this.numberHouse = numberHouse;
        return this;
    }

    public UserBuilder setCity(String city) {
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
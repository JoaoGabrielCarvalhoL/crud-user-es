package br.com.carv.registrations.model;

public class Builder {

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

    public Builder setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Builder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Builder setEmail(String email) {
        this.email = email;
        return this;
    }

    public Builder setCellphone(String cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    public Builder setCollege(String college) {
        this.college = college;
        return this;
    }

    public Builder setProfession(String profession) {
        this.profession = profession;
        return this;
    }

    public Builder setHeight(Double height) {
        this.height = height;
        return this;
    }

    public Builder setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Builder setHairColor(String hairColor) {
        this.hairColor = hairColor;
        return this;
    }

    public Builder setStreet(String street) {
        this.street = street;
        return this;
    }

    public Builder setDistrict(String district) {
        this.district = district;
        return this;
    }

    public Builder setNumberHouse(String numberHouse) {
        this.numberHouse = numberHouse;
        return this;
    }

    public Builder setCity(String city) {
        this.city = city;
        return this;
    }

    public User builderUser() {
        return new User(userId, fullName, email, cellphone);
    }

    @Override
    public String toString() {
        return "Builder{" +
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

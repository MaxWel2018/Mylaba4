package lesson6.task4.domain;

public class Address {
    private String nameStreet;
    private int apartmentNumber;


    public Address(String nameStreet, int apartmentNumber) {
        this.nameStreet = nameStreet;
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return "Street='" + nameStreet + '\'' +
                ", apartment number=" + apartmentNumber;
    }
}

package Scrapyard;

import java.util.Objects;

public class Scrapyard {
private int id;
private String name;
private String address;
private String phoneNumber;

    public Scrapyard(int id, String name, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Scrapyard scrapyard = (Scrapyard) o;
        return id == scrapyard.id && Objects.equals(name, scrapyard.name) && Objects.equals(address, scrapyard.address) && Objects.equals(phoneNumber, scrapyard.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phoneNumber);
    }

    @Override
    public String toString() {
        return "Scrapyard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}



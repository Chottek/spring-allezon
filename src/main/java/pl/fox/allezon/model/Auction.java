package pl.fox.allezon.model;

import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@ToString
@Entity
public class Auction {
    private int id;
    private String name;
    private String shortdesc;
    private String description;
    private double price;
    private String owner;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "shortdesc")
    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "owner")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auction auction = (Auction) o;
        return id == auction.id &&
                Double.compare(auction.price, price) == 0 &&
                Objects.equals(name, auction.name) &&
                Objects.equals(shortdesc, auction.shortdesc) &&
                Objects.equals(description, auction.description) &&
                Objects.equals(owner, auction.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortdesc, description, price, owner);
    }
}

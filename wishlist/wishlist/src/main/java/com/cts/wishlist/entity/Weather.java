package com.cts.wishlist.entity;

import jakarta.persistence.*;

@Entity
public class Weather {

    @Id
    @Embedded
    private Location location;
    @Embedded
    private Current current;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Weather() {
    }

    public Weather(Location location, Current current) {
        this.location = location;
        this.current = current;
    }

    @ManyToOne
    @JoinColumn(name = "wish_list_id")  // This should be the actual name of the foreign key column
     private WishList wishList;
}

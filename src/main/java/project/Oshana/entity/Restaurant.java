package project.Oshana.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "is_freeship")
    private boolean isFreeShip;

    @Column(name = "address")
    private String address;

    @Column(name = "open_date")
    private Date openDate;

    @OneToMany(mappedBy = "restaurant")
    private Set<RatingRestaurant> ratingRestaurantSet;

    @OneToMany(mappedBy = "restaurant")
    private Set<Promo> promoSet;

    @OneToMany(mappedBy = "restaurant")
    private Set<Orders> ordersSet;

    @OneToMany(mappedBy = "restaurant")
    private Set<MenuRestaurant> menuRestaurantSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFreeShip() {
        return isFreeShip;
    }

    public void setFreeShip(boolean freeShip) {
        isFreeShip = freeShip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Set<RatingRestaurant> getRatingRestaurantSet() {
        return ratingRestaurantSet;
    }

    public void setRatingRestaurantSet(Set<RatingRestaurant> ratingRestaurantSet) {
        this.ratingRestaurantSet = ratingRestaurantSet;
    }

    public Set<Promo> getPromoSet() {
        return promoSet;
    }

    public void setPromoSet(Set<Promo> promoSet) {
        this.promoSet = promoSet;
    }

    public Set<Orders> getOrdersSet() {
        return ordersSet;
    }

    public void setOrdersSet(Set<Orders> ordersSet) {
        this.ordersSet = ordersSet;
    }

    public Set<MenuRestaurant> getMenuRestaurantSet() {
        return menuRestaurantSet;
    }

    public void setMenuRestaurantSet(Set<MenuRestaurant> menuRestaurantSet) {
        this.menuRestaurantSet = menuRestaurantSet;
    }
}

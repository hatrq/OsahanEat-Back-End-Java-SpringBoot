package project.Oshana.entity;

import jakarta.persistence.*;
import project.Oshana.entity.keys.KeyMenuRestaurant;

import java.util.Date;

@Entity(name = "menuRestaurant")
public class MenuRestaurant {
    @EmbeddedId
    KeyMenuRestaurant keyMenuRestaurant;

    @ManyToOne
    @JoinColumn(name = "cate_id", insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "res_id", insertable = false, updatable = false)
    private Restaurant restaurant;

    @Column(name = "create_date")
    private Date createDate;

    public KeyMenuRestaurant getKeyMenuRestaurant() {
        return keyMenuRestaurant;
    }

    public void setKeyMenuRestaurant(KeyMenuRestaurant keyMenuRestaurant) {
        this.keyMenuRestaurant = keyMenuRestaurant;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

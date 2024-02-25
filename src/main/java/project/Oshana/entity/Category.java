package project.Oshana.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "create_date")
    private Date createDate;

    @OneToMany(mappedBy = "category")
    private Set<Food> foodSet;

    @OneToMany(mappedBy = "category")
    private Set<MenuRestaurant> menuRestaurantSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<Food> getFoodSet() {
        return foodSet;
    }

    public void setFoodSet(Set<Food> foodSet) {
        this.foodSet = foodSet;
    }

    public Set<MenuRestaurant> getMenuRestaurantSet() {
        return menuRestaurantSet;
    }

    public void setMenuRestaurantSet(Set<MenuRestaurant> menuRestaurantSet) {
        this.menuRestaurantSet = menuRestaurantSet;
    }
}

package project.Oshana.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @OneToMany(mappedBy = "users")
    private Set<RatingFood> ratingFoodSet;

    @OneToMany(mappedBy = "users")
    private Set<RatingRestaurant> ratingRestaurantSet;

    @OneToMany(mappedBy = "users")
    private Set<Orders> ordersSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Set<RatingFood> getRatingFoodSet() {
        return ratingFoodSet;
    }

    public void setRatingFoodSet(Set<RatingFood> ratingFoodSet) {
        this.ratingFoodSet = ratingFoodSet;
    }

    public Set<RatingRestaurant> getRatingRestaurantSet() {
        return ratingRestaurantSet;
    }

    public void setRatingRestaurantSet(Set<RatingRestaurant> ratingRestaurantSet) {
        this.ratingRestaurantSet = ratingRestaurantSet;
    }

    public Set<Orders> getOrdersSet() {
        return ordersSet;
    }

    public void setOrdersSet(Set<Orders> ordersSet) {
        this.ordersSet = ordersSet;
    }
}

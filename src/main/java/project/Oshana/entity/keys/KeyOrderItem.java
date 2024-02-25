package project.Oshana.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class KeyOrderItem implements Serializable {
    @Column(name = "food_id")
    private int foodID;

    @Column(name = "order_id")
    private int orderID;

    public KeyOrderItem() {
    }

    public KeyOrderItem(int foodID, int orderID) {
        this.foodID = foodID;
        this.orderID = orderID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}

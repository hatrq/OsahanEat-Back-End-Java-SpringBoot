package project.Oshana.payload.request;

public class OrderRequest {
    private int userID;
    private int restaurantID;
    private int[] foodID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public int[] getFoodID() {
        return foodID;
    }

    public void setFoodID(int[] foodID) {
        this.foodID = foodID;
    }
}

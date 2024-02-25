package project.Oshana.dto;

import java.util.List;

public class RestaurantDTO {
    private String title;
    private String subtitle;
    private String description;
    private double rate;
    private boolean isFreeShip;
    private String image;
    private List<CategoryDTO> categoryDTO;

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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isFreeShip() {
        return isFreeShip;
    }

    public void setFreeShip(boolean freeShip) {
        isFreeShip = freeShip;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<CategoryDTO> getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(List<CategoryDTO> categoryDTO) {
        this.categoryDTO = categoryDTO;
    }
}

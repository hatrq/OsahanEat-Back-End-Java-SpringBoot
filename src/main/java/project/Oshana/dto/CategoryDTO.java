package project.Oshana.dto;

import java.util.Date;
import java.util.List;

public class CategoryDTO {
    private int id;
    private String name;
    private Date createDate;
    private List<MenuRestaurantDTO> menuRestaurantDTOList;

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

    public List<MenuRestaurantDTO> getMenuRestaurantDTOList() {
        return menuRestaurantDTOList;
    }

    public void setMenuRestaurantDTOList(List<MenuRestaurantDTO> menuRestaurantDTOList) {
        this.menuRestaurantDTOList = menuRestaurantDTOList;
    }
}

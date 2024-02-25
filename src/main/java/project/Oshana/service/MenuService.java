package project.Oshana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.Oshana.entity.Category;
import project.Oshana.entity.Food;
import project.Oshana.entity.Restaurant;
import project.Oshana.repository.FoodRepository;
import project.Oshana.service.imp.FileServiceImp;
import project.Oshana.service.imp.MenuServiceImp;

import java.text.SimpleDateFormat;

@Service
public class MenuService implements MenuServiceImp {
    @Autowired
    FoodRepository foodRepository;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public Boolean insertMenu(MultipartFile file, String title, String timeShip, boolean isFreeShip, double price, int cateID) {
        boolean isSuccess = false;
        try{
            boolean isFileSuccess = fileServiceImp.saveFile(file);
            if (isFileSuccess){
                Food food = new Food();
                food.setTitle(title);
                food.setImage(file.getOriginalFilename());
                food.setTimeShip(timeShip);
                food.setPrice(price);
                food.setFreeShip(isFreeShip);
                Category category = new Category();
                category.setId(cateID);
                food.setCategory(category);

                foodRepository.save(food);

                isSuccess = true;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return isSuccess;
    }
}
